package com.o2.finance.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.o2.finance.etc.RequestParameterConstants;
import com.o2.finance.exception.FinanceException;
import com.o2.finance.facade.FinanceFacade;
import com.o2.finance.model.FinanceLocalModel;
import com.o2.finance.model.UserTO;
import com.o2.finance.properties.PropertyManager;
import com.o2.finance.util.CookieUtils;

/**
 * Web controller to handle account selection for those user how have multiple accounts.
 * 
 * @author SWatson
 * 
 */
public class SecurityCheckController 
extends SimpleFormController
implements RequestParameterConstants
{

    Logger log = LogManager.getLogger( this.getClass() );


    protected FinanceLocalModel localModel;
    protected FinanceFacade     facade;
    protected boolean           authFromRequest;

    private String initialView;


    public SecurityCheckController()
    {
        super();
        authFromRequest = PropertyManager.getApplicationProperties().getAuthFromRequest();
    }

    /**
     * @param localModel
     * @param facade
     */
    public SecurityCheckController(FinanceLocalModel localModel, 
                                   FinanceFacade     facade, 
                                   String            formView, 
                                   String            successView,
                                   String            initialView,
                                   boolean           authFromRequest)
    {
        super();

        log.info( "SecurityCheckController start." );

        setFormView(formView);
        setSuccessView(successView);
        this.localModel      = localModel;
        this.facade          = facade;
        this.authFromRequest = authFromRequest;
        this.initialView = initialView;

        log.info( "SecurityCheckController ends." );
    }

    protected boolean userAlreadyHasProduct(String msisdn, String productId) throws FinanceException
    {
        return facade.hasMsisdnGotProduct(msisdn, productId);
    }
    
    protected boolean checkForLoginAndLoadUser(HttpServletRequest request) throws FinanceException
    {
        log.info( "checkForLoginAndLoadUser start." );

        boolean loggedIn;
        if (authFromRequest)
        {
            /*
             * Authentication is to be from the request so get the username and pass to the back-end for authentication.
             */
            String username = request.getParameter(USERNAME);
            loggedIn = facade.isUserLoggedIn(username, authFromRequest);
        } 
        else
        {
            /*
             * Authentication is not to be from the request so get the userid and authentication token from the cookies and pass
             * to the back-end for authentication.
             */
            String userIdCookie    = PropertyManager.getApplicationProperties().getPaaAuthUserIdCookie();
            String authTokenCookie = PropertyManager.getApplicationProperties().getPaaAuthTokenCookie();
            String userId          = CookieUtils.getCookieValue(userIdCookie, request);
            String authToken       = CookieUtils.getCookieValue(authTokenCookie, request);
            loggedIn = facade.isUserLoggedIn(userId, authToken, authFromRequest);
        }
        
        localModel.setLoggedIn(loggedIn);
        if(loggedIn)
        {
            loadUser(request);
        }

        log.info( "checkForLoginAndLoadUser ends." );
        return loggedIn;
    }

    /**
     * @param localModel the localModel to set
     */
    public void setLocalModel(FinanceLocalModel localModel)
    {
        this.localModel = localModel;
    }

    /**
     * @param facade the facade to set
     */
    public void setFacade(FinanceFacade facade)
    {
        this.facade = facade;
    }

    /**
     * @param authFromRequest the authFromRequest to set
     */
    public void setAuthFromRequest(boolean authFromRequest)
    {
        this.authFromRequest = authFromRequest;
    }

    private void loadUser(HttpServletRequest request)  throws FinanceException
    {
        log.info( "loadUser start." );

        String username = null;
        if (authFromRequest)
        {
            /*
             * Authentication is to be from the request so get the username from the request.
             */
            username = request.getParameter(USERNAME);
            long uid  = username.hashCode();
            localModel.setUserUID(uid >= 0 ? uid : -uid);
        } 
        else
        {
            /*
             * Authentication is not to be from the request so get the userid and authentication token from the cookies and pass
             * to the back-end to translate this into a username.
             */
            String userIdCookie    = PropertyManager.getApplicationProperties().getPaaAuthUserIdCookie();
            String authTokenCookie = PropertyManager.getApplicationProperties().getPaaAuthTokenCookie();
            String userId          = CookieUtils.getCookieValue(userIdCookie, request);
            String authToken       = CookieUtils.getCookieValue(authTokenCookie, request);
            username               = facade.getUsernameFromId(userId, authToken);

            localModel.setUserUID(Long.parseLong(userId));
        }
        
        // Get the user object from the back-end server.
        localModel.setUser(null);
        UserTO user = facade.getUserByUsername(username);
        if (user != null)
        {
            localModel.setUser(user);
            localModel.setPostPay(facade.isUserPostPay(user));
        } else
        {
            log.info( "Failed to get user " + username + " from facade." );
        }

        log.info( "loadUser ends." );

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
