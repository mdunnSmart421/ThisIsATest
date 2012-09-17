package com.o2.finance.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

import com.o2.finance.beans.StageBean;
import com.o2.finance.facade.FinanceFacade;
import com.o2.finance.model.FinanceLocalModel;

/**
 * Web controller to handle account selection for those user how have multiple accounts.
 *
 * @author SWatson
 */
public class PostLoginController
        extends SecurityCheckController
{
    Logger log = LogManager.getLogger( this.getClass() );

    public PostLoginController()
    {
        super();
    }

    /**
     * @param localModel
     * @param facade
     */
    public PostLoginController( FinanceLocalModel localModel,
                                FinanceFacade facade,
                                String formView,
                                String successView,
                                String flowErrorView,
                                boolean authFromRequest )
    {
        super( localModel, facade, formView, successView, flowErrorView, authFromRequest );
    }

    /*
    * (non-Javadoc)
    *
    * @see org.springframework.web.servlet.mvc.AbstractController#handleRequest(javax.servlet.http.HttpServletRequest,
    * javax.servlet.http.HttpServletResponse)
    */
    public ModelAndView handleRequest( HttpServletRequest request,
                                       HttpServletResponse response )
            throws Exception
    {
        log.info( "handleRequest start." );

        ModelAndView mav;

        if (localModel.isJourneyInitialised())
        {

            if (checkForLoginAndLoadUser( request ) )
//                &&    userAlreadyHasProduct( localModel.getUser().getMsisdn(),
//                            localModel.getProduct().getProductId() ))
            {
                // DS Does this need to be be made null safe?
            	if(localModel.getOriginalMsisdn().equals(localModel.getUser().getMsisdn()))
            	{
            		log.info("msisdn match so we can carry on to check for legacy changes are ok.");
            		StageBean.getStage( request.getSession( true ) ).setStageToComplete();
                    mav = new ModelAndView( getSuccessView() );
                    // DS - non null safe call to toString() ( not necessary to call toString either)
                    log.info( "redirecting to "+getSuccessView().toString() );
            	}
            	else
            	{
            		
                    mav = new ModelAndView( getFormView() );
                    // DS - non null safe call to toString() ( not necessary to call toString either)
                    log.info( "The user has not logged in as the same msisdn that was OTAC verified  going redirecting ="+getFormView().toString() );
            	}
            	
            	
                
            } else
            {
                mav = new ModelAndView( getFormView() );
                // DS - non null safe call to toString() ( not necessary to call toString either)
                log.info( "User not logged in so return back to the EnterMPN = redirecting"+getFormView().toString() );
            }

        } else
        {
            log.info( "Invalid flow access - returning user to start." );
            mav = new ModelAndView( getInvalidFlowView() );
        }


        log.info( "handleRequest ends." );

        return mav;

    }
}
