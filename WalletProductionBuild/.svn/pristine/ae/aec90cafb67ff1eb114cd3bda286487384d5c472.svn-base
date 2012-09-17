package com.o2.finance.spring.controller;

/**
 * This web controller will
 * a) set up all the required data to do a silent login
 * b) forwards the user to silengLogin.jsp, which in-turn auto submits and POSTs the data to the logInServlet
 * 
 * @author vkancherla
 */

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.o2.finance.beans.SilentLoginForm;
import com.o2.finance.etc.RequestParameterConstants;
import com.o2.finance.exception.FinanceException;
import com.o2.finance.facade.FinanceFacade;
import com.o2.finance.model.FinanceLocalModel;
import com.o2.finance.model.UserTO;
import com.o2.finance.properties.ApplicationProperties;
import com.o2.finance.properties.PropertyManager;

public class SilentLoginController extends SimpleFormController implements RequestParameterConstants
{
	 private FinanceFacade     facade;
	 private FinanceLocalModel localModel;
	 private String            errorView;
	 
	 
	 Logger log = LogManager.getLogger( this.getClass() );
	 
	 public SilentLoginController()
	 {
		 super( );
	 }	 
	 
	 public SilentLoginController( FinanceFacade facade, FinanceLocalModel localModel, String errorView )
	 {
		 log.info( "Constructor SilentLoginController start. " );
		 
		 this.facade     = facade;
		 this.localModel = localModel;
		 this.errorView  = errorView;
		 
		 log.info( "Constructor SilentLoginController ends. " );
	 }
	 
	 /**
	  * 
	  */
	 public ModelAndView handleRequest( HttpServletRequest request, HttpServletResponse response ) throws Exception
	 {
		 log.info( "handleRequest start." );
		 
		 SilentLoginForm form           = new SilentLoginForm();
		 UserTO user                    =  localModel.getUser();
		 ApplicationProperties appProps = PropertyManager.getApplicationProperties();



         if ( null == user )
         {
             throw new FinanceException( "User is null." );
         }

		 form.setUsername(user.getId());
		 form.setPassword(user.getPassword());
		 form.setLoginURL(appProps.getNewUserPostLoginUrl());
		 form.setReturnURL(appProps.getNewUserPostLoginReturnUrl());
		 form.setFailureURL(appProps.getNewUserPostLoginFailureUrl());

		 Map model = new HashMap();
		 model.put( REQUEST_ATTR_NAME_SILENTLOGINFORM, form );
		 
		 log.info( "handleRequest ends." );
		 
		 return new ModelAndView( getSuccessView(), model );
	 }
//
//	 /**
//	  *
//	  * @param request
//	  * @return
//	  */
//	private UserTO getUser( HttpServletRequest request )
//    {
//        log.info( "getUser start." );
//
//        /*
//         * Get the existing user object from the in-session model, if not available and a username is provided as a request query
//         * parameter then try to obtain a user from the back-end service.
//         */
//        UserTO user = localModel.getUser();
//
//
//        // Only get the user name from the request if property says that auth can be made from request
//        if (user == null && PropertyManager.getApplicationProperties().getAuthFromRequest() == true)
//        {
//            String userId = (String) request.getParameter("userid");
//            if (userId != null && userId.trim().length() > 0)
//            {
//                user = facade.getUserByUsername(userId);
//                if (user != null)
//                {
//                    localModel.setUser(user);
//                }
//            }
//        }
//
//        log.info( "getUser ends." );
//        return user;
//    }
//
	 public FinanceLocalModel getLocalModel() {
		 return localModel;
	 }
	 public FinanceFacade getFacade() {
		return facade;
	}

	public void setFacade(FinanceFacade facade) {
		this.facade = facade;
	}

	public void setLocalModel(FinanceLocalModel localModel) {
		 this.localModel = localModel;
	 }
	 public String getErrorView() {
		 return errorView;
	 }
	 public void setErrorView(String errorView) {
		 this.errorView = errorView;
	 }
}
