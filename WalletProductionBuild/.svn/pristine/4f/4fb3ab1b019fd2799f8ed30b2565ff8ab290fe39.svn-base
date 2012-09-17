package com.o2.finance.spring.controller;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.o2.finance.etc.RequestParameterConstants;
import com.o2.finance.facade.FinanceFacade;
import com.o2.finance.facade.memory.InMemoryFinanceFacade;
import com.o2.finance.facade.memory.InMemoryFinanceFacade.UsernameKey;
import com.o2.finance.model.FinanceLocalModel;
import com.o2.finance.model.UserTO;
import com.o2.finance.properties.PropertyManager;

/**
 * Web controller to handle the entry point into the eWallet registration process.
 * 
 * @author SWatson
 * 
 */
public class TestSetupController 
extends SimpleFormController 
implements RequestParameterConstants
{
    private FinanceLocalModel model;
    private FinanceFacade     facade;

    public TestSetupController()
    {
        super();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.web.servlet.mvc.AbstractController#handleRequest(javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse)
     */
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) 
    throws Exception
    {
        if(facade instanceof InMemoryFinanceFacade)
        {
            String skipreset = request.getParameter("skipreset");
            
            if(skipreset == null || !skipreset.trim().equalsIgnoreCase("true"))
            {
                InMemoryFinanceFacade memory = (InMemoryFinanceFacade)facade;
                memory.reset();
            }

            String username = model.getToLoginAs() != null ? 
                              model.getToLoginAs() : request.getParameter("u");
            if(username != null && username.trim().length() > 0)
            {
                setUpCookies(username, response);
            }
        }
        
        Map model = request.getParameterMap();
        return new ModelAndView(getSuccessView(), model);
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
     * @param model the model to set
     */
    public void setModel(FinanceLocalModel model)
    {
        this.model = model;
    }

    private void setUpCookies(String username, HttpServletResponse response)
    {
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
    }
}
