package com.o2.finance.spring.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.o2.finance.model.FeedbackTO;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.o2.finance.beans.EnterOtacForm;
import com.o2.finance.etc.util.FeedbackModelBuilder;
import com.o2.finance.etc.RequestParameterConstants;
import com.o2.finance.exception.FinanceServiceOtacTriesExceededException;
import com.o2.finance.facade.FinanceFacade;
import com.o2.finance.model.FinanceLocalModel;
import com.o2.finance.model.UserTO;
import com.o2.finance.properties.PropertyManager;
import com.o2.finance.util.MsisdnConverter;

/**
 * Web controller to handle the verification of a user entered mobile phone verification code (OTAC).
 * 
 * A code will be captured via the web interface and passed to a back-end server process for verification.
 * 
 * @author SWatson
 * 
 */
public class EnterOtacController 
extends SimpleFormController 
implements RequestParameterConstants
{
    private static final Logger LOG = LogManager.getLogger( EnterOtacController.class );

    private FinanceLocalModel localModel;
    private FinanceFacade     facade;

    private String initialView;

    public EnterOtacController()
    {
        super();
    }

    /**
     * @param localModel
     * @param facade
     */
    public EnterOtacController(FinanceLocalModel localModel, 
                               FinanceFacade     facade, 
                               String            formView,
                               String            successView)
    {
        super();
        LOG.info( "EnterOtacController start." );
        
        setFormView(formView);
        setSuccessView(successView);
        this.localModel = localModel;
        this.facade     = facade;
        
        LOG.info( "EnterOtacController ends." );
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.web.servlet.mvc.SimpleFormController#onSubmit(javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.validation.BindException)
     */
    protected ModelAndView onSubmit(HttpServletRequest  request, 
                                    HttpServletResponse response, 
                                    Object              command, 
                                    BindException       errors)
    throws Exception
    {
        LOG.info( "onSubmit start." );

        ModelAndView mav = null;

        if ( localModel.isJourneyInitialised())
        {
            if (errors != null && errors.hasErrors())
            {
                /*
                 * Validation errors exist so return to the data entry form to display the validation messages.
                 */
                mav = showForm(request, response, errors);
            }
            else
            {
                EnterOtacForm form = (EnterOtacForm) command;
                boolean attemptsExceeded = false;
                boolean isOtacValid = false;
                try
                {
                    /*
                     * First check the local model to ensure the user entered code is a match. If a match then sent to the back-end
                     * server for verification.
                     *
                     * The back-end server will always deal with a MSISDN in international format, so ensure this is correct before
                     * dispatch.
                     */
                    isOtacValid = localModel.getOTAC() != null && localModel.getOTAC().equalsIgnoreCase(form.getVerificationCode());
                    if (isOtacValid)
                    {
                        isOtacValid = facade.verifyOtac(MsisdnConverter.msisdnToInternational(form.getMsisdn()),
                                                        form.getVerificationCode());
                    }
                }
                catch (FinanceServiceOtacTriesExceededException vce)
                {
                    attemptsExceeded = true;
                }

                if (attemptsExceeded)
                {
                    /*
                     * The back-end server has indicated that too many attempts have been made to obtain a new verification code,
                     * therefore we need to send a message to the view layer for display.
                     *
                     * Here we create a FeedbackTO and place it in the request to be picked up by the view layer to display an error
                     * message, and we navigate back to the data entry view.
                     *
                     * As this is a simple forward request returns back to the existing view we can add the FeedbackTO to the model
                     * for rendition by the view handler.
                     */
                    localModel.setMsisdnVerified(false);

                    String     message  = PropertyManager.getFeedbackProps().getOtacRequestsExceededMessage();
                    FeedbackTO feedback = new FeedbackTO( FeedbackTO.VALIDATION_ERROR, message);
                    Map model = new HashMap();

                    model.put(FEEDBACK_REQUEST_KEY, feedback);
                    mav = showForm(request, response, errors, model);
                }
                else if (isOtacValid)
                {
                    /*
                     * The verification check was successful so set the the verification flag in the local model and forward to the
                     * success view.
                     *
                     * If user object does not already exist (a new customer) then add a new empty object to the local view.
                     */
                    localModel.setMsisdnVerified(true);
                    UserTO user = localModel.getUser();
                    if (user != null)
                    {
                        user.setMsisdn(MsisdnConverter.msisdnToInternational(form.getMsisdn()));
                    }
                    mav = new ModelAndView(getSuccessView());
                }
                else
                {
                    /*
                     * The verification was unsuccessful we need to display a message to the user on the OTAC entry form.
                     *
                     * Here we create a FeedbackTO and place it in the request to be picked up by the view layer to display an error
                     * message, and we navigate back to the data entry view.
                     *
                     * As this is a simple forward request returns back to the existing view we can add the FeedbackTO to the model
                     * for rendition by the view handler.
                     */
                    localModel.setMsisdnVerified(false);

                    String     message  = PropertyManager.getFeedbackProps().getOtacIncorrectMessage();
                    FeedbackTO feedback = new FeedbackTO( FeedbackTO.VALIDATION_ERROR, message);

                    Map model = new HashMap();
                    model.put(FEEDBACK_REQUEST_KEY, feedback);
                    mav = showForm(request, response, errors, model);
                }
            }
        } else
        {
            LOG.info( "Invalid flow access." );
            mav = new ModelAndView( getInvalidFlowView() );
            localModel.clear();
        }
        LOG.info( "onSubmit ends." );
        return mav;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.web.servlet.mvc.SimpleFormController#showForm(javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse, org.springframework.validation.BindException)
     */
    protected ModelAndView showForm(HttpServletRequest request, HttpServletResponse response, BindException errors)
            throws Exception
    {
        LOG.info( "showForm start." );
        /*
         * It is possible that we may receive query parameters on the request supplying messages for user from the verification
         * code request process. These will need to be converted into an model object to pass through to the view renderer.
         */
        FeedbackTO feedback = FeedbackModelBuilder.getFeedback(request);
        Map model = new HashMap();
        if (feedback != null)
        {
            model.put(FEEDBACK_REQUEST_KEY, feedback);
        }

        LOG.info( "showForm ends." );
        return showForm(request, errors, getFormView(), model);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.web.servlet.mvc.AbstractFormController#formBackingObject(javax.servlet.http.HttpServletRequest)
     */
    protected Object formBackingObject(HttpServletRequest request) throws Exception
    {
        LOG.info( "formBackingObject start." );
        // Set the MSISDN value to that stored in the local finance model for display.
        EnterOtacForm form = new EnterOtacForm();
        form.setMsisdn(MsisdnConverter.msisdnToNational(localModel.getMsisdn()));
        LOG.info( "formBackingObject ends." );

        return form;
    }

    /**
     * @return the localModel
     */
    public FinanceLocalModel getLocalModel()
    {
        return localModel;
    }

    /**
     * @param localModel
     *            the localModel to set
     */
    public void setLocalModel(FinanceLocalModel localModel)
    {
        this.localModel = localModel;
    }

    /**
     * @return the facade
     */
    public FinanceFacade getFacade()
    {
        return facade;
    }

    /**
     * @param facade
     *            the facade to set
     */
    public void setFacade(FinanceFacade facade)
    {
        this.facade = facade;
    }

    public String getInvalidFlowView()
    {
        return initialView;
    }

    public void setInvalidFlowView( String initialView )
    {
        this.initialView = initialView;
    }
}
