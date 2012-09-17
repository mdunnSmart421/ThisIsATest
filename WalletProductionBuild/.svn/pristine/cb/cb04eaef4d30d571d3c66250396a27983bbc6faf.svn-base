package com.o2.finance.spring.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.o2.finance.model.UserTO;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import com.o2.finance.beans.ProductBean;
import com.o2.finance.etc.RequestParameterConstants;
import com.o2.finance.external.boa.BACNameValuePairBuilder;
import com.o2.finance.model.FeedbackTO;
import com.o2.finance.model.FinanceLocalModel;
import com.o2.finance.properties.PropertyManager;

/**
 * Web controller to handle the entry point into the eWallet registration process.
 *
 * @author SWatson
 */
public class HandoffController
        extends SimpleFormController
        implements RequestParameterConstants
{
    private FinanceLocalModel localModel;
    private String errorView;
    private BACNameValuePairBuilder bacRequestBuilder;
    private String initialView;

    Logger log = LogManager.getLogger( this.getClass() );

    public HandoffController()
    {
        super();
    }

    public HandoffController( FinanceLocalModel localModel, String errorView )
    {
        this( localModel, errorView, new BACNameValuePairBuilder() );
    }

    public HandoffController( FinanceLocalModel localModel,
                              String errorView,
                              BACNameValuePairBuilder bacRequestBuilder )
    {
        this.localModel = localModel;
        this.errorView = errorView;
        this.bacRequestBuilder = bacRequestBuilder;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.web.servlet.mvc.AbstractController#handleRequest(javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse)
     */
    public ModelAndView handleRequest( HttpServletRequest request, HttpServletResponse response ) throws Exception
    {
        log.info( "handleRequest start." );

        ModelAndView mav = null;

//        //todo remove hacks
//        localModel.setJourneyInitialised( true );
//        localModel.setUser( new UserTO() );
//
//        ProductBean productX = new ProductBean(  );
//        productX.setProductId( "1001" );
//
//        localModel.setProduct( productX );
//
//        // end hacks

        if (!localModel.isJourneyInitialised())
        {
            log.info( "Invalid flow access." );
            mav = new ModelAndView( getInvalidFlowView() );
            localModel.clear();
        } else
        {


            // If this is a return to the flow from outside, then there will be a return url on the localModel,
            // if this is true, then we send the user to this url


            if (null != localModel.getReturnUrl() && !"".equalsIgnoreCase( localModel.getReturnUrl() ))
            {
                String returnUrl = localModel.getReturnUrl();
                localModel.setReturnUrl( null );
                mav = new ModelAndView( new RedirectView( returnUrl ) );
            } else
            {


                ProductBean product = localModel.getProduct();
                if (product != null)
                {
                    if (ProductBean.HANDOFF_BOA.equalsIgnoreCase( product.getProductHandoff() ))
                    {
//                        Map model = bacRequestBuilder.createDataPacket( localModel.getUser(),
//                                localModel.getUserUID(),
//                                BACNameValuePairBuilder.ARI_TYPE_BFID,
//                                product.getProductReturnUrl() );
                        String params = bacRequestBuilder.createDataPacket( localModel.getUser(),
                                localModel.getUserUID(),
                                BACNameValuePairBuilder.ARI_TYPE_BFID,
                                product.getProductReturnUrl() );

//                        mav = new ModelAndView( new RedirectView( product.getProductTargetUrl() ), model );
                        mav = new ModelAndView( new RedirectView( product.getProductTargetUrl() + "&" + params ) );
                    } else
                    {
                        mav = new ModelAndView( new RedirectView( product.getProductTargetUrl() ) );
                    }
                } else
                {
                    /*
                    * Product is missing so send message to the user.
                    */
                    FeedbackTO feedback = new FeedbackTO( FeedbackTO.VALIDATION_ERROR, PropertyManager.getFeedbackProps()
                            .getMissingProductIdMessage() );
                    Map model = new HashMap();
                    model.put( RequestParameterConstants.FEEDBACK_REQUEST_KEY, feedback );
                    mav = new ModelAndView( errorView, model );
                }
            }
        }
        log.info( "handleRequest ends." );
        return mav;
    }

    /**
     * @param localModel the localModel to set
     */
    public void setLocalModel( FinanceLocalModel localModel )
    {
        this.localModel = localModel;
    }

    /**
     * @param errorView the errorView to set
     */
    public void setErrorView( String errorView )
    {
        this.errorView = errorView;
    }

    /**
     * @param bacRequestBuilder the bacRequestBuilder to set
     */
    public void setBacRequestBuilder( BACNameValuePairBuilder bacRequestBuilder )
    {
        this.bacRequestBuilder = bacRequestBuilder;
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
