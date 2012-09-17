package com.o2.finance.spring.controller;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

import com.o2.finance.beans.SilentLoginForm;
import com.o2.finance.facade.memory.InMemoryFinanceFacade;
import com.o2.finance.model.FinanceLocalModel;
import com.o2.finance.model.UserTO;
import com.o2.finance.properties.ApplicationProperties;
import com.o2.finance.properties.PropertyManager;

import junit.framework.TestCase;

public class SilentLoginControllerTest extends TestCase
{
	
    private MockHttpServletRequest     request;
    private MockHttpServletResponse    response;
    private FinanceLocalModel          local;
    private UserTO                     user;
    private SilentLoginController      controller;
    private InMemoryFinanceFacade      facade;
    
    private final static String ERROR_VIEW = "applicationError";
    private final static String SUCCESS_VIEW = "silentLogin";
	
	protected void setUp() throws Exception
	{
		request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
        facade = new InMemoryFinanceFacade();
        local = new FinanceLocalModel();
        local.setJourneyInitialised( true );            
        local.setPafUpdated( true );
        user = new UserTO();
        user.setId( "vkancherla15" );
        user.setPassword( "111111" );
        local.setUser( user );        
        controller = new SilentLoginController( facade, local, ERROR_VIEW );
        controller.setSuccessView( SUCCESS_VIEW );
	}
	
	public void testHandleRequest() throws Exception
	{
		ApplicationProperties appsProps = PropertyManager.getApplicationProperties();		
		ModelAndView mv 		        = controller.handleRequest(request, response);	
		
		SilentLoginForm form 			= ( SilentLoginForm ) mv.getModel().get( "silentLoginForm" );
		
		assertNotNull( form );
		assertEquals( "vkancherla15", form.getUsername() );
		assertEquals( "111111", form.getPassword() );
		assertEquals( appsProps.getNewUserPostLoginUrl(), form.getLoginURL() );
		assertEquals( appsProps.getNewUserPostLoginReturnUrl(), form.getReturnURL() );
		assertEquals( appsProps.getNewUserPostLoginFailureUrl(), form.getFailureURL() );
		assertEquals( SUCCESS_VIEW, mv.getViewName() );
	}

}
