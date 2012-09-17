package com.o2.finance.spring.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.o2.finance.etc.util.FeedbackModelBuilder;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.o2.finance.beans.EnterMpnForm;
import com.o2.finance.beans.StageBean;
import com.o2.finance.beans.validator.EnterMpnFormValidator;
import com.o2.finance.beans.validator.ExistingMpnFormValidator;
import com.o2.finance.etc.RequestParameterConstants;
import com.o2.finance.exception.FinanceServiceVerificationCodeTriesExceededException;
import com.o2.finance.facade.FinanceFacade;
import com.o2.finance.model.FeedbackTO;
import com.o2.finance.model.FinanceLocalModel;
import com.o2.finance.model.UserTO;
import com.o2.finance.properties.PropertyManager;
import com.o2.finance.util.MsisdnConverter;

/**
 * Web controller to handle capture of a customer's mobile phone number (MSISDN) and make a request for a verification code from
 * the O2 back-end server.
 * 
 * If a customer is an existing user then their existing mobile phone number is presented for display, otherwise the user must
 * provide through the web interface.
 * 
 * @author SWatson
 * 
 */
public class EnterMpnController extends SimpleFormController implements RequestParameterConstants
{
    Logger log = LogManager.getLogger( this.getClass() );


    private FinanceLocalModel localModel;
    private FinanceFacade facade;
    private String existingMpnView;
    private String initialView;

    public EnterMpnController()
    {
    }



    public ModelAndView handleRequest( HttpServletRequest request, HttpServletResponse response ) throws Exception
    {
        log.info( "handleRequest start." );


        ModelAndView mav;

        if (localModel.isJourneyInitialised())
        {
        	String edit = request.getParameter( "edit" );
        	if (( edit != null && edit.trim().length() > 0 ))
        	{
        		log.info( "Validate with ExistingMpnFormValidator" );
        		this.setValidator( new ExistingMpnFormValidator() );
        		
        	} else
        	{
        		log.info( "Validate with EnterMpnFormValidator" );
        		this.setValidator( new EnterMpnFormValidator() );
        	}
            mav = super.handleRequest( request, response );
        } else
        {
            log.info( "Invalid flow access." );
            mav = new ModelAndView( getInvalidFlowView()  );
            localModel.clear();

        }
        

        log.info( "handleRequest ends." );

        return mav;
    }

    /**
     * @param facade
     * @param modelSessionAttribute
     */
    public EnterMpnController(FinanceFacade facade, FinanceLocalModel localModel, String existingMpnView, String formView,
            String successView)
    {
        super();

        log.info( "EnterMpnController start." );

        super.setFormView(formView);
        super.setSuccessView(successView);
        this.facade = facade;
        this.localModel = localModel;
        this.existingMpnView = existingMpnView;

        log.info( "EnterMpnController ends." );
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.web.servlet.mvc.SimpleFormController#onSubmit(javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.validation.BindException)
     * 
     * Handles the request for a MSISDN verification code.
     */
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors)
            throws Exception
    {

        log.info( "onSubmit start." );

        ModelAndView mav;

        if (! localModel.isJourneyInitialised())
        {

            log.info( "Invalid flow access." );
            mav = new ModelAndView( getInvalidFlowView() );
            localModel.clear();

        } else
        {

            if (errors != null && errors.hasErrors())
            {
                /*
                 * Validation errors exist so return to the data entry form to display the validation messages.
                 */
                log.info( "Validation errors exist - returning to data entry form." );
                mav = showForm( request, response, errors );
            } else
            {
                EnterMpnForm form = (EnterMpnForm) command;
                /*
                 * Check to see if this is an edit of an existing number if so update the in-session user object.
                 * Local model will always contain the international version of the mobile
                 * number. This is the format stored by the back-end server.
                 */
                String msisdn = form.getMsisdn();
                localModel.setMsisdn( MsisdnConverter.msisdnToInternational( msisdn ) );
                localModel.setOriginalMsisdn(MsisdnConverter.msisdnToInternational( msisdn ));
                log.info( "Checking if edit of existing customer." );
                
                
                
                if (isEdit( request ))
                {
                    msisdn = form.getNewMsisdn();
                    UserTO user = localModel.getUser();
                    if (user != null)
                    {
                        user.setMsisdn( MsisdnConverter.msisdnToInternational( msisdn ) );                        
                    }
                    
                    localModel.setMsisdn( MsisdnConverter.msisdnToInternational( msisdn ) );
                }

                boolean attemptsExceeded = false;
                String otac = null;
                try
                {
                    /*
                     * Set the the local model to show that the mobile phone has not been verified, and make the request to the
                     * back-end for a verification code.
                     */

                	localModel.setMsisdnVerified( false );
                    otac = facade.sendOtac( MsisdnConverter.msisdnToInternational( msisdn ),
                            localModel.getProduct().getProductSmsMessage() );
                }
                catch (FinanceServiceVerificationCodeTriesExceededException fse)
                {
                    log.info( "Verification code tries exceeded." );
                    attemptsExceeded = true;
                }


                if (!attemptsExceeded)
                {
                    /*
                     * The verification request was successful so we need navigate to the success view, however is as a result of a
                     * RE-SEND request then we want to display a message on the view.
                     *
                     * As this is a redirect to the next view page we need to break up the FeedbackTO content into simple query
                     * parameters to the to the GET request for the next view, we therefore add the feed back type and message as
                     * string parameters to the model these will be converted to query parameters on the redirect GET request.
                     */
                    localModel.setOTAC( otac );
                    if (form.isResentRequest())
                    {
                        String message = PropertyManager.getFeedbackProps().getOtacResendMessage();
                        mav = new ModelAndView( getSuccessView(), FeedbackModelBuilder.getFeedbackModel( FeedbackTO.MESSAGE, message ) );
                    } else
                    {
                        mav = new ModelAndView( getSuccessView() );
                    }
                } else
                {
                    /*
                     * The back-end server has indicated that too many attempts have been made to obtain a new verification code,
                     * therefore we need to send a message to the view layer for display.
                     *
                     * Here we create a FeedbackTO and place it in the request to be picked up by the view layer to display an error
                     * message, and we navigate back to the data entry view.
                     */
                    if (form.isResentRequest())
                    {
                        /*
                         *
                         * As this is a simple forward request returns back to the existing view we can add the FeedbackTO to the
                         * model for rendition by the view handler.
                         */
                        String message = PropertyManager.getFeedbackProps().getOtacRequestsExceededMessage();
                        mav = new ModelAndView( getSuccessView(),
                                FeedbackModelBuilder.getFeedbackModel( FeedbackTO.VALIDATION_ERROR, message ) );
                    } else
                    {
                        /*
                         * As this is a redirect to the next view page we need to break up the FeedbackTO content into simple query
                         * parameters to the to the GET request for the next view, we therefore add the feed back type and message as
                         * string parameters to the model these will be converted to query parameters on the redirect GET request.
                         */
                        String message = PropertyManager.getFeedbackProps().getOtacRequestsExceededMessage();
                        FeedbackTO feedback = new FeedbackTO( FeedbackTO.VALIDATION_ERROR, message );
                        Map model = new HashMap();
                        model.put( FEEDBACK_REQUEST_KEY, feedback );
                        mav = showForm( request, response, errors, model );
                    }
                }
            }

        }
        log.info( "onSubmit ends." );
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
        log.info( "showForm start." );

        ModelAndView mav;
        /*
         * This controller handles all requests for a MSISDN verification code (OTAC). Request my come from the view as either a
         * form submission from the Enter MSISDN Form of a s RES-SEND request from the Enter OTAC view.
         * 
         * If a RE-SEND request then we need to make a request for a verification code and return the user back to the Enter OTAC
         * view, otherwise we simply display the Enter MSISDN form.
         * 
         * A re-send flag is set to tell the submit handler whether or not a feedback message needs to be returned.
         */
        if (isResendRequest(request))
        {
        	log.info( "Resend otac" );
            EnterMpnForm form = (EnterMpnForm) formBackingObject(request);
            form.setResentRequest(true);
            // Request a verification code.
            mav = onSubmit(request, response, form, errors);
        } else if (hasExistingMsisdn())
        {
            // Display the data entry form
            StageBean.getStage(request.getSession(true)).setStageToCheck();
            mav = super.showForm(request, errors, getExistingMpnView());
        } else
        {
        	
            // Display the data entry form
            mav = super.showForm(request, errors, getFormView());
        }

        log.info( "showForm ends." );
        return mav;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.web.servlet.mvc.AbstractFormController#formBackingObject(javax.servlet.http.HttpServletRequest)
     */
    protected Object formBackingObject(HttpServletRequest request) throws Exception
    {
        log.info( "formBackingObject start." );

        /*
         * If a MSISDN already exists either in a pre-loaded user object or within the local finance model (ie. exiting customer)
         * then add this to the form for display within the Enter MPV view.
         * 
         * The view will always display the mobile phone number in national format.
         */
        EnterMpnForm form = new EnterMpnForm();
        if (hasExistingMsisdn())
        {
            form.setMsisdn(MsisdnConverter.msisdnToNational(getExistingMsisdn()));
        }

        log.info( "formBackingObject ends." );

        return form;
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
     * @return the existingMpnView
     */
    public String getExistingMpnView()
    {
        return existingMpnView;
    }

    /**
     * @param existingMpnView
     *            the existingMpnView to set
     */
    public void setExistingMpnView(String existingMpnView)
    {
        this.existingMpnView = existingMpnView;
    }

    private boolean isResendRequest(HttpServletRequest request)
    {
        String action = request.getParameter("action");
        return action != null && "resendotac".equals(action);
    }

    private boolean hasExistingMsisdn()
    {
        log.info( "hasExistingMsisdn start." );

        boolean hasMsisdn;
        hasMsisdn = localModel.getMsisdn() != null && localModel.getMsisdn().trim().length() > 0;
        
        if (!hasMsisdn)
        {
        	log.info("User does not have msisdn");
        	UserTO user = localModel.getUser();
            hasMsisdn = user != null && user.getMsisdn() != null && user.getMsisdn().trim().length() > 0;
        }else{
        	
        	log.info("user has existing msisdn : " + localModel.getMsisdn());
        }

        log.info( "hasExistingMsisdn ends." );
        return hasMsisdn;
    }

    private String getExistingMsisdn()
    {
        log.info( "getExistingMsisdn start." );

        String msisdn = localModel.getMsisdn();
        if (msisdn == null || msisdn.trim().length() == 0)
        {
        	log.info( "Not found msisdn in local model looking in user");
            msisdn = localModel.getUser().getMsisdn();
        }
        	
        log.info( "Msisdn : " + msisdn);
        log.info( "getExistingMsisdn end." );

        return msisdn;
    }

    private boolean isEdit(HttpServletRequest request)
    {
        String edit = request.getParameter("edit");
        return edit != null && edit.trim().length() > 0;
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
