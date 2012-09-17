package com.o2.finance.spring.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.o2.finance.etc.ApplicationConstants;
import com.o2.finance.exception.FinanceServiceSLMBreachException;
import com.o2.finance.exception.unchecked.RuntimeFinanceException;
import com.o2.finance.util.CookieUtils;
import com.o2.finance.util.MobileThemeSupportHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.o2.finance.beans.ProductBean;
import com.o2.finance.etc.DeviceConstants;
import com.o2.finance.etc.RequestParameterConstants;
import com.o2.finance.facade.FinanceFacade;
import com.o2.finance.model.FeedbackTO;
import com.o2.finance.model.FinanceLocalModel;
import com.o2.finance.properties.PropertyManager;

/**
 * Web controller to handle the entry point into the eWallet registration process.
 *
 * @author SWatson
 */
public class InitiateController extends SimpleFormController
        implements RequestParameterConstants, DeviceConstants, ApplicationConstants
{
    private FinanceLocalModel localModel;
    private FinanceFacade facade;
    private String errorView;

    Logger log = LogManager.getLogger( this.getClass() );


    public InitiateController()
    {
        super();
    }

    public InitiateController( FinanceLocalModel localModel,
                               FinanceFacade facade,
                               String successView,
                               String errorView )
    {
        this( localModel, facade, successView, errorView,
                PropertyManager.getApplicationProperties().getAuthFromRequest() );
    }

    public InitiateController( FinanceLocalModel localModel,
                               FinanceFacade facade,
                               String successView,
                               String errorView,
                               boolean authFromRequest )
    {
        super();

        log.info( "InitiateController start." );

        setSuccessView( successView );
        this.localModel = localModel;
        this.facade = facade;
        this.errorView = errorView;

        log.info( "InitiateController ends." );

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.web.servlet.mvc.AbstractController#handleRequest(javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse)
     */
    public ModelAndView handleRequest( HttpServletRequest request, HttpServletResponse response )
            throws Exception
    {
        log.info( "handleRequest start." );


        localModel.clear();

        manageTheme( request, response );

        //todo - remove
//        throwTimeout();
//        throwRuntimeFinanceException();
//        throwException();

        ModelAndView mav = null;
        String productId = request.getParameter( PRODUCT_ID );
        if (productId != null && productId.trim().length() > 0)
        {
            /*
             * Check for the presence and validity of the product id, if not valid return a FeedbackTO with message to display to
             * the user.
             */
            if (facade.validateProductId( productId ))
            {
                localModel.setProduct( ProductBean.getProduct( productId, request.getSession( true ) ) );
                
                CookieUtils.setCookie( request, response, PRODUCT_COOKIE_NAME , productId  );
                
                localModel.setJourneyInitialised( true );

                Map model = request.getParameterMap();

                mav = new ModelAndView( getSuccessView(), model );
            } else
            {
                /*
                 * Product is invalid so send message to the user.
                 */
                FeedbackTO feedback = new FeedbackTO( FeedbackTO.VALIDATION_ERROR,
                        PropertyManager.getFeedbackProps().getInvalidProductIdMessage() );
                Map model = new HashMap();
                model.put( RequestParameterConstants.FEEDBACK_REQUEST_KEY, feedback );
                mav = new ModelAndView( errorView, model );
            }
        } else
        {
            /*
             * Product is missing so send message to the user.
             */
            FeedbackTO feedback = new FeedbackTO( FeedbackTO.VALIDATION_ERROR,
                    PropertyManager.getFeedbackProps().getMissingProductIdMessage() );
            Map model = new HashMap();
            model.put( RequestParameterConstants.FEEDBACK_REQUEST_KEY, feedback );
            mav = new ModelAndView( errorView, model );
        }

        log.info( "handleRequest ends." );

        return mav;

    }


    private void manageTheme( HttpServletRequest request, HttpServletResponse response )
    {

        if (null == localModel.getTheme())
        {
            String theme = MobileThemeSupportHelper.determineTheme( request );


            localModel.setTheme( theme );

            CookieUtils.setCookie( request, response, THEME_COOKIE_NAME , theme  );

        }
    }

    /**
     * @param errorView the errorView to set
     */
    public void setErrorView( String errorView )
    {
        this.errorView = errorView;
    }

    /**
     * @param localModel the localModel to set
     */
    public void setLocalModel( FinanceLocalModel localModel )
    {
        this.localModel = localModel;
    }

    /**
     * @param facade the facade to set
     */
    public void setFacade( FinanceFacade facade )
    {
        this.facade = facade;
    }


    //todo remove
    private void throwTimeout() throws FinanceServiceSLMBreachException
    {
        throw new FinanceServiceSLMBreachException( "badger", "wombat", "zebra" );
    }


    private void throwException() throws Exception
    {
        throw new Exception( "Spanner" );
    }


    private void throwRuntimeFinanceException() throws RuntimeFinanceException
    {
        Throwable t = new Throwable();
        throw new RuntimeFinanceException( this.getClass(), "throwRuntimeFinanceException", "badger", t );
    }


}
