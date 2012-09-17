package com.o2.finance.spring.controller;

import javax.servlet.http.Cookie;

import com.o2.finance.model.FeedbackTO;
import junit.framework.Assert;
import junit.framework.TestCase;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

import com.o2.finance.beans.ProductBean;
import com.o2.finance.etc.RequestParameterConstants;
import com.o2.finance.exception.FinanceException;
import com.o2.finance.facade.FinanceFacade;
import com.o2.finance.model.FinanceLocalModel;
import com.o2.finance.model.UserTO;

public class PostLoginControllerTest extends TestCase
{
    private static final String FORM_VIEW     = "formView";
    private static final String SUCCESS_VIEW  = "successView";
    private static final String FLOW_ERROR_VIEW = "error";

    private FinanceLocalModel   localModel;
    private FinanceFacade       facade;
    private PostLoginController controller;

    protected void setUp() throws Exception
    {
        localModel = new FinanceLocalModel();
        localModel.setJourneyInitialised( true );
        facade     = new FinanceFacade();
        controller = new PostLoginController(localModel, facade, FORM_VIEW, SUCCESS_VIEW, FLOW_ERROR_VIEW, false);
        
        localModel.setProduct(new ProductBean("10012"));
    }

    public void testHandleRequestUserNotLoggedIn() 
    throws Exception
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setParameter(RequestParameterConstants.PRODUCT_ID, "10012");
        
        ModelAndView mav = controller.handleRequest(request, new MockHttpServletResponse());
        Assert.assertNotNull("ModelAndView is null", mav);
        Assert.assertEquals(FORM_VIEW, mav.getViewName());
        
        FeedbackTO feedback = (FeedbackTO) mav.getModel().get(RequestParameterConstants.FEEDBACK_REQUEST_KEY);
        Assert.assertNull("FeedbackTO provided", feedback);
        Assert.assertNull("User object has been set", localModel.getUser());
    }

    public void testHandleRequestUserLoggedInRequestAuth() 
    throws Exception
    {



        controller = new PostLoginController(localModel, new FinanceFacade()
                                            {
                                                public boolean isUserLoggedIn(String username, boolean authFromRequest)
                                                {
                                                    Assert.assertEquals("user1", username);
                                                    Assert.assertEquals(true, authFromRequest);
                                                    return true;
                                                }
                                    
                                                public UserTO getUserByUsername(String id)
                                                {
                                                    UserTO user = new UserTO();
                                                    user.setId(id);
                                                    return user;
                                                }
                                    
                                                public boolean isUserPostPay(UserTO user)
                                                {
                                                    return false;
                                                }
                                                
                                                public boolean hasMsisdnGotProduct(String msisdn, String productId)
                                                throws FinanceException
                                                {
                                                    return false;
                                                }
                                            }, 
                                            FORM_VIEW, SUCCESS_VIEW, FLOW_ERROR_VIEW, true);
        
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setParameter(RequestParameterConstants.PRODUCT_ID, "10012");
        request.setParameter(RequestParameterConstants.USERNAME, "user1");
        
        ModelAndView mav = controller.handleRequest(request, new MockHttpServletResponse());
        Assert.assertNotNull("ModelAndView is null", mav);
        Assert.assertEquals(FORM_VIEW, mav.getViewName());
        
        FeedbackTO feedback = (FeedbackTO) mav.getModel().get(RequestParameterConstants.FEEDBACK_REQUEST_KEY);
        Assert.assertNull("FeedbackTO provided", feedback);
        Assert.assertEquals("10012", localModel.getProduct().getProductId());
        Assert.assertNotNull("User object is null", localModel.getUser());
        Assert.assertEquals("user1", localModel.getUser().getId());
    }

    public void testHandleRequestUserLoggedInRequestAuthUserHasProduct() 
    throws Exception
    {
        controller = new PostLoginController(localModel, new FinanceFacade()
                                            {
                                                public boolean isUserLoggedIn(String username, boolean authFromRequest)
                                                {
                                                    Assert.assertEquals("user1", username);
                                                    Assert.assertEquals(true, authFromRequest);
                                                    return true;
                                                }
                                    
                                                public UserTO getUserByUsername(String id)
                                                {
                                                    UserTO user = new UserTO();
                                                    user.setId(id);
                                                    return user;
                                                }
                                    
                                                public boolean isUserPostPay(UserTO user)
                                                {
                                                    return false;
                                                }
                                                
                                                public boolean hasMsisdnGotProduct(String msisdn, String productId)
                                                throws FinanceException
                                                {
                                                    return true;
                                                }
                                            }, 
                                            FORM_VIEW, SUCCESS_VIEW, FLOW_ERROR_VIEW,true);
        
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setParameter(RequestParameterConstants.PRODUCT_ID, "10012");
        request.setParameter(RequestParameterConstants.USERNAME, "user1");
        
        ModelAndView mav = controller.handleRequest(request, new MockHttpServletResponse());
        Assert.assertNotNull("ModelAndView is null", mav);
        Assert.assertEquals(SUCCESS_VIEW, mav.getViewName());
        
        FeedbackTO feedback = (FeedbackTO) mav.getModel().get(RequestParameterConstants.FEEDBACK_REQUEST_KEY);
        Assert.assertNull("FeedbackTO provided", feedback);
        Assert.assertEquals("10012", localModel.getProduct().getProductId());
        Assert.assertNotNull("User object is null", localModel.getUser());
        Assert.assertEquals("user1", localModel.getUser().getId());
    }

    public void testHandleRequestUserLoggedInRequestCookie() 
    throws Exception
    {
        controller = new PostLoginController(localModel, 
                                            new FinanceFacade()
                                            {
                                                public boolean isUserLoggedIn(String userId, String authToken, boolean authFromRequest) 
                                                throws FinanceException
                                                {
                                                    Assert.assertEquals("1234567890", userId);
                                                    Assert.assertEquals("0987654321", authToken);
                                                    Assert.assertEquals(false, authFromRequest);
                                                    return true;
                                                }
                                    
                                                public UserTO getUserByUsername(String id)
                                                {
                                                    UserTO user = new UserTO();
                                                    user.setId(id);
                                                    return user;
                                                }
                                    
                                                public String getUsernameFromId(String userId, String authToken)
                                                {
                                                    Assert.assertEquals("1234567890", userId);
                                                    Assert.assertEquals("0987654321", authToken);
                                                    return "user1";
                                                }
                                    
                                                public boolean isUserPostPay(UserTO user)
                                                {
                                                    return false;
                                                }
                                                
                                                public boolean hasMsisdnGotProduct(String msisdn, String productId)
                                                throws FinanceException
                                                {
                                                    return false;
                                                }
                                            }, 
                                            FORM_VIEW, SUCCESS_VIEW, FLOW_ERROR_VIEW, false);
        
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setParameter(RequestParameterConstants.PRODUCT_ID, "10012");
        
        Cookie mid = new Cookie("MID", "1234567890");
        Cookie mat = new Cookie("MAT", "0987654321");
        request.setCookies(new Cookie[]
        { mid, mat });
        
        ModelAndView mav = controller.handleRequest(request, new MockHttpServletResponse());
        Assert.assertNotNull("ModelAndView is null", mav);
        Assert.assertEquals(FORM_VIEW, mav.getViewName());
        
        FeedbackTO feedback = (FeedbackTO) mav.getModel().get(RequestParameterConstants.FEEDBACK_REQUEST_KEY);
        Assert.assertNull("FeedbackTO provided", feedback);
        Assert.assertEquals("10012", localModel.getProduct().getProductId());
        Assert.assertNotNull("User object is null", localModel.getUser());
        Assert.assertEquals("user1", localModel.getUser().getId());
    }

    public void testHandleRequestUserLoggedInRequestCookieUserHasProduct() 
    throws Exception
    {
        controller = new PostLoginController(localModel, 
                                            new FinanceFacade()
                                            {
                                                public boolean isUserLoggedIn(String userId, String authToken, boolean authFromRequest) 
                                                throws FinanceException
                                                {
                                                    Assert.assertEquals("1234567890", userId);
                                                    Assert.assertEquals("0987654321", authToken);
                                                    Assert.assertEquals(false, authFromRequest);
                                                    return true;
                                                }
                                    
                                                public UserTO getUserByUsername(String id)
                                                {
                                                    UserTO user = new UserTO();
                                                    user.setId(id);
                                                    return user;
                                                }
                                    
                                                public String getUsernameFromId(String userId, String authToken)
                                                {
                                                    Assert.assertEquals("1234567890", userId);
                                                    Assert.assertEquals("0987654321", authToken);
                                                    return "user1";
                                                }
                                    
                                                public boolean isUserPostPay(UserTO user)
                                                {
                                                    return false;
                                                }
                                                
                                                public boolean hasMsisdnGotProduct(String msisdn, String productId)
                                                throws FinanceException
                                                {
                                                    return true;
                                                }
                                            }, 
                                            FORM_VIEW, SUCCESS_VIEW, FLOW_ERROR_VIEW, false);
        
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setParameter(RequestParameterConstants.PRODUCT_ID, "10012");
        
        Cookie mid = new Cookie("MID", "1234567890");
        Cookie mat = new Cookie("MAT", "0987654321");
        request.setCookies(new Cookie[]
        { mid, mat });
        
        ModelAndView mav = controller.handleRequest(request, new MockHttpServletResponse());
        Assert.assertNotNull("ModelAndView is null", mav);
        Assert.assertEquals(SUCCESS_VIEW, mav.getViewName());
        
        FeedbackTO feedback = (FeedbackTO) mav.getModel().get(RequestParameterConstants.FEEDBACK_REQUEST_KEY);
        Assert.assertNull("FeedbackTO provided", feedback);
        Assert.assertEquals("10012", localModel.getProduct().getProductId());
        Assert.assertNotNull("User object is null", localModel.getUser());
        Assert.assertEquals("user1", localModel.getUser().getId());
    }

    public void testHandleRequestNoCookies() 
    throws Exception
    {
        controller = new PostLoginController(localModel, new FinanceFacade()
                                            {
                                                public boolean isUserLoggedIn(String userId, String authToken, boolean authFromRequest) 
                                                throws FinanceException
                                                {
                                                    return false;
                                                }
                                            }, 
                                            FORM_VIEW, SUCCESS_VIEW, FLOW_ERROR_VIEW, false);
        
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setParameter(RequestParameterConstants.PRODUCT_ID, "10012");
        
        ModelAndView mav = controller.handleRequest(request, new MockHttpServletResponse());
        Assert.assertNotNull("ModelAndView is null", mav);
        Assert.assertEquals(FORM_VIEW, mav.getViewName());
        
        FeedbackTO feedback = (FeedbackTO) mav.getModel().get(RequestParameterConstants.FEEDBACK_REQUEST_KEY);
        Assert.assertNull("FeedbackTO provided", feedback);
        Assert.assertEquals("10012", localModel.getProduct().getProductId());
        Assert.assertNull("User object is not null", localModel.getUser());
    }
}
