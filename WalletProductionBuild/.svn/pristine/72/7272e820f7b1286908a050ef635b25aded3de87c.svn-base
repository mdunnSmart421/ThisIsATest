package com.o2.finance.spring.controller;

import com.o2.finance.model.FeedbackTO;
import junit.framework.Assert;
import junit.framework.TestCase;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

import com.o2.finance.etc.RequestParameterConstants;
import com.o2.finance.exception.FinanceDelegateException;
import com.o2.finance.facade.FinanceFacade;
import com.o2.finance.model.FinanceLocalModel;
import com.o2.finance.properties.PropertyManager;

public class InitiateControllerTest 
extends TestCase
{
    private static final String SUCCESS_VIEW = "successView";
    private static final String ERROR_VIEW   = "applicationError";

    private FinanceLocalModel  localModel;
    private FinanceFacade      facade;
    private InitiateController controller;

    protected void setUp() throws Exception
    {
        localModel = new FinanceLocalModel();
        facade     = new FinanceFacade();
        controller = new InitiateController(localModel, facade, SUCCESS_VIEW, ERROR_VIEW);
    }

    public void testHandleRequestNoProductId() 
    throws Exception
    {
        ModelAndView mav = controller.handleRequest(new MockHttpServletRequest(), new MockHttpServletResponse());
        Assert.assertNotNull("ModelAndView is null", mav);
        Assert.assertEquals(ERROR_VIEW, mav.getViewName());
        
        FeedbackTO feedback = (FeedbackTO) mav.getModel().get(RequestParameterConstants.FEEDBACK_REQUEST_KEY);
        Assert.assertNotNull("FeedbackTO not provided", feedback);
        Assert.assertEquals( FeedbackTO.VALIDATION_ERROR, feedback.getType());
        Assert.assertEquals(PropertyManager.getFeedbackProps().getMissingProductIdMessage(), feedback.getDesc());
    }

    public void testHandleRequestInvalidProductId() 
    throws Exception
    {
        controller.setFacade(new FinanceFacade()
                             {
                                public boolean validateProductId(String productID) 
                                throws FinanceDelegateException
                                {
                                    Assert.assertEquals("123456", productID);
                                    return false;
                                }
                             });
        
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setParameter(RequestParameterConstants.PRODUCT_ID, "123456");
        
        ModelAndView mav = controller.handleRequest(request, new MockHttpServletResponse());
        Assert.assertNotNull("ModelAndView is null", mav);
        Assert.assertEquals(ERROR_VIEW, mav.getViewName());
        
        FeedbackTO feedback = (FeedbackTO) mav.getModel().get(RequestParameterConstants.FEEDBACK_REQUEST_KEY);
        Assert.assertNotNull("FeedbackTO not provided", feedback);
        Assert.assertEquals( FeedbackTO.VALIDATION_ERROR, feedback.getType());
        Assert.assertEquals(PropertyManager.getFeedbackProps().getInvalidProductIdMessage(), feedback.getDesc());
        Assert.assertNull("ProductID has been set in local model", localModel.getProduct());
    }

    public void testHandleRequestValidProductId() 
    throws Exception
    {
        controller.setFacade(new FinanceFacade()
                             {
                                public boolean validateProductId(String productID) 
                                throws FinanceDelegateException
                                {
                                    Assert.assertEquals("123456", productID);
                                    return true;
                                }
                             });
        
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setParameter(RequestParameterConstants.PRODUCT_ID, "123456");
        
        ModelAndView mav = controller.handleRequest(request, new MockHttpServletResponse());
        Assert.assertNotNull("ModelAndView is null", mav);
        Assert.assertEquals(SUCCESS_VIEW, mav.getViewName());
        
        FeedbackTO feedback = (FeedbackTO) mav.getModel().get(RequestParameterConstants.FEEDBACK_REQUEST_KEY);
        Assert.assertNull("FeedbackTO is null", feedback);
        Assert.assertNotNull("Product is null", localModel.getProduct());
        Assert.assertEquals("123456", localModel.getProduct().getProductId());
    }
}
