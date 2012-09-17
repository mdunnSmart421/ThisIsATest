package com.o2.finance.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.o2.finance.etc.RequestParameterConstants;
import com.o2.finance.facade.FinanceFacade;

/**
 * Web controller to handle the "username suggestion" functionality
 * 
 * @author VKancherla
 * 
 */
public class UsernameSuggestionsController extends SimpleFormController implements RequestParameterConstants
{
    private FinanceFacade facade;

    Logger log = LogManager.getLogger( this.getClass() );


    public UsernameSuggestionsController()
    {
        super();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.web.servlet.mvc.AbstractController#handleRequest(javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse)
     */
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        log.info( "handleRequest start." );

        String foreName = request.getParameter(FORENAME);
        String lastName = request.getParameter(LASTNAME);
        List suggestions = facade.suggestUserName(foreName, lastName);
        Map model = new HashMap();
        model.put(USERNAME_SUGGESTIONS, suggestions);

        log.info( "handleRequest ends." );
        return new ModelAndView(getSuccessView(), model);
    }

    /**
     * @return the facacde
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
}
