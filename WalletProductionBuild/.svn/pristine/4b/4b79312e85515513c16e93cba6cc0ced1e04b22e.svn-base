package com.o2.finance.spring.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.o2.finance.model.FeedbackTO;
import junit.framework.Assert;
import junit.framework.TestCase;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import com.o2.finance.beans.ProductBean;
import com.o2.finance.etc.RequestParameterConstants;
import com.o2.finance.model.FinanceLocalModel;
import com.o2.finance.model.UserTO;
import com.o2.finance.properties.ProductProperties;
import com.o2.finance.properties.PropertyManager;

public class HandoffControllerTest extends TestCase
{
    private static final String ERROR_VIEW = "applicationError";
    private FinanceLocalModel localModel;
    private HandoffController controller;

    protected void setUp() throws Exception
    {
        localModel = new FinanceLocalModel();
        localModel.setJourneyInitialised( true );
        controller = new HandoffController(localModel, ERROR_VIEW);
    }

    public void testHandleRequestNoProductId() throws Exception
    {
        ModelAndView mav = controller.handleRequest(new MockHttpServletRequest(), new MockHttpServletResponse());
        Assert.assertNotNull("ModelAndView is null", mav);
        Assert.assertEquals(ERROR_VIEW, mav.getViewName());
        FeedbackTO feedback = (FeedbackTO) mav.getModel().get(RequestParameterConstants.FEEDBACK_REQUEST_KEY);
        Assert.assertNotNull("FeedbackTO not provided", feedback);
        Assert.assertEquals( FeedbackTO.VALIDATION_ERROR, feedback.getType());
        Assert.assertEquals(PropertyManager.getFeedbackProps().getMissingProductIdMessage(), feedback.getDesc());
    }

    public void testWaveCrestHandoff() throws Exception
    {
        ProductBean product = new ProductBean("20202");
        localModel.setProduct(product);
        ModelAndView mav = controller.handleRequest(new MockHttpServletRequest(), new MockHttpServletResponse());
        Assert.assertNotNull("ModelAndView is null", mav);
        View view = mav.getView();
        Assert.assertNotNull("View is null", view);
        Assert.assertEquals(true, view instanceof RedirectView);
        Assert.assertEquals(product.getProductTargetUrl(), ((RedirectView) view).getUrl());
    }

    public void testBoaHandoff() throws Exception
    {
        UserTO user = new UserTO();
        user.setTitle("Mr");
        user.setForename("Simon");
        user.setLastname("Watson");
        user.setBirthDay(3);
        user.setBirthMonth(1);
        user.setBirthYear(1968);
        user.setAccountManagerEmail("swatson@smart421.com");
        user.setHouseNumber("12");
        user.setPostcode("IP1 1PI");
        user.setMsisdn("447912000000");
        user.setGender("M");
        user.setCustomerNumber(new Integer(123456789));
        
        ProductProperties props     = PropertyManager.getProductProps();
        List              products  = props.getProductIdList();
        String            productid = null;
        Iterator          itr       = products.iterator();
        while(itr.hasNext() && productid == null)
        {
            String id = (String)itr.next();
            if("BOA".equals(props.getProductHandoff(id)))
            {
                productid = id;
            }
        }

        ProductBean product = new ProductBean(productid);
        localModel.setUser(user);
        localModel.setProduct(product);
        localModel.setApplicationRef(new Long(123456));
        localModel.setAdvertisingCode("AD123");
        localModel.setProductOfferCode("POC12345");
        
        ModelAndView mav = controller.handleRequest(new MockHttpServletRequest(), new MockHttpServletResponse());
        Assert.assertNotNull("ModelAndView is null", mav);
        
        View view = mav.getView();
        Assert.assertNotNull("View is null", view);
        Assert.assertEquals(true, view instanceof RedirectView);
        Assert.assertEquals(product.getProductTargetUrl(), ((RedirectView) view).getUrl());
        
        Map model = mav.getModel();
        Assert.assertNotNull("Model is null", model);
        Assert.assertEquals(9, model.size());
        Assert.assertEquals(true, model.containsKey("ARI"));
        Assert.assertEquals(true, model.containsKey("POC"));
        Assert.assertEquals(true, model.containsKey("AD"));
        Assert.assertEquals(true, model.containsKey("SDP"));
        Assert.assertEquals(true, model.containsKey("CD"));
        Assert.assertEquals(true, model.containsKey("EK"));
        Assert.assertEquals(true, model.containsKey("RU"));
        Assert.assertEquals(true, model.containsKey("DT"));
        Assert.assertEquals(true, model.containsKey("PARTNER"));
    }
}
