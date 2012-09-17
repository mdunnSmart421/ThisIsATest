package com.o2.finance.spring.controller;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.o2.finance.facade.FinanceFacade;
import com.o2.finance.facade.memory.InMemoryFinanceFacade;
import com.o2.finance.facade.memory.InMemoryFinanceFacade.UsernameKey;
import com.o2.finance.model.FinanceLocalModel;
import com.o2.finance.model.UserTO;
import com.o2.finance.properties.PropertyManager;

public class MockLoginServletController extends SimpleFormController 
{

	 private FinanceLocalModel model;
	 private FinanceFacade     facade;
	 
	 Logger log = LogManager.getLogger( this.getClass() );
	 
	 public MockLoginServletController()
	 {
		 super();
	 }
	 
	 public MockLoginServletController( FinanceLocalModel model, FinanceFacade facade )
	 {
		 this.model  = model;
		 this.facade = facade;
	 }
	 
	 public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	 {
	 	log.info("handleRequest start.");
		 
		 if(facade instanceof InMemoryFinanceFacade)
        {
            String username  = (String) request.getParameter("username");
            String password  = (String) request.getParameter("password");
            String returnURL = (String) request.getParameter("destURL");
            String fuUrl     = (String) request.getParameter("fuUrl");
            
            log.info(" Username - "+username+
            		"\nPassword - "+password+
            		"\nreturnURL - "+returnURL+
            		"\nfuUrl - "+fuUrl);
            
            if(username != null && username.trim().length() > 0)
            {	            	
            	setUpCookies(username, response);
            }
        }
        
        Map model = request.getParameterMap();
        
        log.info("handleRequest ends.");
        
        return new ModelAndView(getSuccessView(), model);
    }
	 
	 private void setUpCookies(String username, HttpServletResponse response)
     {
		 log.info("setUpCookies start.");
		 
		InMemoryFinanceFacade memory = (InMemoryFinanceFacade)facade;
        UserTO user = memory.getUserByUsername(username);
        if(user != null)
        {
            String userIdCookie    = PropertyManager.getApplicationProperties().getPaaAuthUserIdCookie();
            String authTokenCookie = PropertyManager.getApplicationProperties().getPaaAuthTokenCookie();
            
            UsernameKey key = memory.getUsernameKey(user);
            
            response.addCookie(new Cookie(userIdCookie, key.userId));
            response.addCookie(new Cookie(authTokenCookie, key.authToken));
        }
        
        log.info("setUpCookies ends.");
     }
	 
	 public FinanceLocalModel getModel() {
			return model;
		}

		public void setModel(FinanceLocalModel model) {
			this.model = model;
		}

		public FinanceFacade getFacade() {
			return facade;
		}

		public void setFacade(FinanceFacade facade) {
			this.facade = facade;
		}
	
}
