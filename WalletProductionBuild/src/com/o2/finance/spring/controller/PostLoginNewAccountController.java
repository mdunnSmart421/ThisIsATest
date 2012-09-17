package com.o2.finance.spring.controller;

import com.o2.finance.exception.FinanceException;
import com.o2.finance.exception.unchecked.RuntimeFinanceException;
import com.o2.finance.facade.FinanceFacade;
import com.o2.finance.model.FinanceLocalModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Purpose:
 * com.o2.finance.spring.controller
 * User: D Smith
 * Date: 27/06/2011
 */
public class PostLoginNewAccountController extends SecurityCheckController
{


    Logger log = LogManager.getLogger( this.getClass() );


    public PostLoginNewAccountController()
    {
        super();
    }

    public PostLoginNewAccountController( FinanceLocalModel localModel,
                                          FinanceFacade facade,
                                          String formView,
                                          String successView,
                                          String initialView,
                                          boolean authFromRequest )
    {
        super( localModel, facade, formView, successView, initialView, authFromRequest );
    }


    public ModelAndView handleRequest( HttpServletRequest request,
                                       HttpServletResponse response ) throws FinanceException
    {
        log.info( "handleRequest start." );

        ModelAndView mav;

        if (localModel.isJourneyInitialised())
        {
            // the user should now be logged in.
            if (checkForLoginAndLoadUser( request ))
            {
            	/*
                 *  since we are here because a new user account has just been created, it means that the address
                 *  will have been already validated by PAF.
                 *  
                 */
                localModel.setPafUpdated( true );
                localModel.setNewAccount( true );                
            	
            	mav = new ModelAndView( getSuccessView() );
            } else
            {
                // user not logged in...
                RuntimeFinanceException error = new RuntimeFinanceException( this.getClass(), "User not logged in.", null );
                log.error( error.getMessage(), error );
                throw error;
            }

        } else
        {
            log.info( "Invalid flow access." );
            mav = new ModelAndView( getInvalidFlowView() );
            localModel.clear();
        }
        log.info( "handleRequest ends." );
        return mav;

    }

}
