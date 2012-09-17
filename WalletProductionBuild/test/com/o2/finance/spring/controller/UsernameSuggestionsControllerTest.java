package com.o2.finance.spring.controller;

import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

import com.o2.finance.etc.RequestParameterConstants;
import com.o2.finance.facade.memory.InMemoryFinanceFacade;

/**
 * Purpose: This is the test case for com.o2.finance.spring.controller.UsernameSuggestionsControllerTest
 * 
 * User: D Smith Date: 20/05/2011
 */
public class UsernameSuggestionsControllerTest extends TestCase implements RequestParameterConstants
{
    private static final String SUCCESS_VIEW = "usernameSuggestions";
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;
    private InMemoryFinanceFacade facade;
    private UsernameSuggestionsController controller;

    protected void setUp() throws Exception
    {
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
        facade = new InMemoryFinanceFacade();
        controller = new UsernameSuggestionsController();
        controller.setSuccessView(SUCCESS_VIEW);
        controller.setFacade(facade);
    }

    /**
     * Test to ensure that when the page loads all the drop downs are populated
     * 
     * @throws Exception
     */
    public void testOnRequest() throws Exception
    {
        request.addParameter(RequestParameterConstants.FORENAME, "Vijay");
        request.addParameter(RequestParameterConstants.LASTNAME, "Kancherla");
        ModelAndView mav = controller.handleRequest(request, response);
        Map model = mav.getModel();
        List suggestions = (List) model.get(USERNAME_SUGGESTIONS);
        assertNotNull(suggestions);
        assertEquals(2, suggestions.size());
        assertEquals(SUCCESS_VIEW, mav.getViewName());
    }
}
