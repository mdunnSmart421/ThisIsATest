package com.o2.finance.spring.controller;

import com.o2.finance.model.FeedbackTO;
import junit.framework.Assert;
import junit.framework.TestCase;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;

import com.o2.finance.beans.EnterOtacForm;
import com.o2.finance.etc.RequestParameterConstants;
import com.o2.finance.exception.FinanceServiceOtacTriesExceededException;
import com.o2.finance.facade.FinanceFacade;
import com.o2.finance.facade.memory.InMemoryFinanceFacade;
import com.o2.finance.model.FinanceLocalModel;
import com.o2.finance.model.UserTO;
import com.o2.finance.properties.PropertyManager;
import com.o2.finance.util.MsisdnConverter;

public class EnterOtacControllerTest 
extends TestCase
{
    private static final String COMMAND      = "enterOtacForm";
    private static final String FORM_VIEW    = "enterOtac";
    private static final String SUCCESS_VIEW = "redirect:chooseAccount.do";
    
    private FinanceLocalModel   localModel;
    private FinanceFacade       facade;
    private EnterOtacController controller;

    protected void setUp() 
    throws Exception
    {
        localModel = new FinanceLocalModel();
        localModel.setMsisdn(MsisdnConverter.msisdnToInternational("07912000000"));
        localModel.setJourneyInitialised( true );
        facade     = new InMemoryFinanceFacade();
        controller = new EnterOtacController(localModel, facade, FORM_VIEW, SUCCESS_VIEW);
    }

    public void testFormBackingObject() 
    throws Exception
    {
        EnterOtacForm form = new EnterOtacForm();
        form.setMsisdn(MsisdnConverter.msisdnToNational(localModel.getMsisdn()));
        
        Object obj = controller.formBackingObject(new MockHttpServletRequest());
        
        Assert.assertNotNull("EnterOtacForm is null", obj);
        Assert.assertTrue("Form is not a EnterOtacForm", obj instanceof EnterOtacForm);
        Assert.assertEquals(form, obj);
    }

    public void testShowFormNoFeedback() 
    throws Exception
    {
        ServletRequestDataBinder binder = new ServletRequestDataBinder(COMMAND, COMMAND);
        BindException            errors = new BindException(binder.getBindingResult());
        
        ModelAndView mav = controller.showForm(new MockHttpServletRequest(), 
                                               new MockHttpServletResponse(), 
                                               errors);
        
        Assert.assertNotNull("ModelAndView is null", mav);
        Assert.assertEquals(FORM_VIEW, mav.getViewName());
        Assert.assertNull("FeedbackTO provided", mav.getModel().get(RequestParameterConstants.FEEDBACK_REQUEST_KEY));
    }

    public void testShowFormWithFeedback() 
    throws Exception
    {
        ServletRequestDataBinder binder = new ServletRequestDataBinder(COMMAND, COMMAND);
        BindException            errors = new BindException(binder.getBindingResult());
        
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setParameter(RequestParameterConstants.FEEDBACK_TYPE_REQUEST_KEY, Integer.toString( FeedbackTO.MESSAGE));
        request.setParameter(RequestParameterConstants.FEEDBACK_MESSAGE_REQUEST_KEY, "Feedback message");
        
        ModelAndView mav = controller.showForm(request, new MockHttpServletResponse(), errors);
        Assert.assertNotNull("ModelAndView is null", mav);
        Assert.assertEquals(FORM_VIEW, mav.getViewName());
        
        FeedbackTO feedback = (FeedbackTO) mav.getModel().get(RequestParameterConstants.FEEDBACK_REQUEST_KEY);
        Assert.assertNotNull("FeedbackTO not provided", feedback);
        Assert.assertEquals( FeedbackTO.MESSAGE, feedback.getType());
        Assert.assertEquals("Feedback message", feedback.getDesc());
    }

    public void testOnSubmitNoOtac() 
    throws Exception
    {
        ServletRequestDataBinder binder = new ServletRequestDataBinder(COMMAND, COMMAND);
        BindException            errors = new BindException(binder.getBindingResult());
        EnterOtacForm            form   = new EnterOtacForm();
        
        ModelAndView mav = controller.onSubmit(new MockHttpServletRequest(), new MockHttpServletResponse(), form, errors);
        Assert.assertNotNull("ModelAndView is null", mav);
        Assert.assertEquals(FORM_VIEW, mav.getViewName());
        Assert.assertEquals(false, localModel.isMsisdnVerified());
        
        FeedbackTO feedback = (FeedbackTO) mav.getModel().get(RequestParameterConstants.FEEDBACK_REQUEST_KEY);
        Assert.assertNotNull("FeedbackTO not provided", feedback);
        Assert.assertEquals( FeedbackTO.VALIDATION_ERROR, feedback.getType());
        Assert.assertEquals(PropertyManager.getFeedbackProps().getOtacIncorrectMessage(), feedback.getDesc());
    }

    public void testOnSubmitNoLocalOtac() 
    throws Exception
    {
        ServletRequestDataBinder binder = new ServletRequestDataBinder(COMMAND, COMMAND);
        BindException            errors = new BindException(binder.getBindingResult());
        EnterOtacForm            form   = new EnterOtacForm();
        form.setVerificationCode("123456");
        
        ModelAndView mav = controller.onSubmit(new MockHttpServletRequest(), new MockHttpServletResponse(), form, errors);
        Assert.assertNotNull("ModelAndView is null", mav);
        Assert.assertEquals(FORM_VIEW, mav.getViewName());
        Assert.assertEquals(false, localModel.isMsisdnVerified());
        
        FeedbackTO feedback = (FeedbackTO) mav.getModel().get(RequestParameterConstants.FEEDBACK_REQUEST_KEY);
        Assert.assertNotNull("FeedbackTO not provided", feedback);
        Assert.assertEquals( FeedbackTO.VALIDATION_ERROR, feedback.getType());
        Assert.assertEquals(PropertyManager.getFeedbackProps().getOtacIncorrectMessage(), feedback.getDesc());
    }

    public void testOnSubmitMismatchOtac() 
    throws Exception
    {
        ServletRequestDataBinder binder = new ServletRequestDataBinder(COMMAND, COMMAND);
        BindException            errors = new BindException(binder.getBindingResult());
        localModel.setOTAC("654321");
        
        EnterOtacForm form = new EnterOtacForm();
        form.setVerificationCode("123456");
        
        ModelAndView mav = controller.onSubmit(new MockHttpServletRequest(), new MockHttpServletResponse(), form, errors);
        Assert.assertNotNull("ModelAndView is null", mav);
        Assert.assertEquals(FORM_VIEW, mav.getViewName());
        Assert.assertEquals(false, localModel.isMsisdnVerified());
        
        FeedbackTO feedback = (FeedbackTO) mav.getModel().get(RequestParameterConstants.FEEDBACK_REQUEST_KEY);
        Assert.assertNotNull("FeedbackTO not provided", feedback);
        Assert.assertEquals( FeedbackTO.VALIDATION_ERROR, feedback.getType());
        Assert.assertEquals(PropertyManager.getFeedbackProps().getOtacIncorrectMessage(), feedback.getDesc());
    }

    public void testOnSubmitExceedsTries() 
    throws Exception
    {
        ServletRequestDataBinder binder = new ServletRequestDataBinder(COMMAND, COMMAND);
        BindException            errors = new BindException(binder.getBindingResult());
        
        localModel.setOTAC("123456");
        
        EnterOtacForm form = new EnterOtacForm();
        form.setVerificationCode("123456");
        
        controller.setFacade(new FinanceFacade()
                             {
                                public boolean verifyOtac(String msisdn, String otac) 
                                throws FinanceServiceOtacTriesExceededException
                                {
                                    throw new FinanceServiceOtacTriesExceededException(null,null,null);
                                }
                             });
        
        ModelAndView mav = controller.onSubmit(new MockHttpServletRequest(), new MockHttpServletResponse(), form, errors);
        Assert.assertEquals(FORM_VIEW, mav.getViewName());
        Assert.assertEquals(false, localModel.isMsisdnVerified());
        
        FeedbackTO feedback = (FeedbackTO) mav.getModel().get(RequestParameterConstants.FEEDBACK_REQUEST_KEY);
        Assert.assertNotNull("FeedbackTO is null", feedback);
        Assert.assertEquals( FeedbackTO.VALIDATION_ERROR, feedback.getType());
        Assert.assertEquals(PropertyManager.getFeedbackProps().getOtacRequestsExceededMessage(), feedback.getDesc());
    }

    public void testOnFalseVerification() 
    throws Exception
    {
        ServletRequestDataBinder binder = new ServletRequestDataBinder(COMMAND, COMMAND);
        BindException            errors = new BindException(binder.getBindingResult());
        
        localModel.setOTAC("123456");
        
        EnterOtacForm form = new EnterOtacForm();
        form.setVerificationCode("123456");
        form.setMsisdn("07912000000");
        
        controller.setFacade(new FinanceFacade()
                             {
                                public boolean verifyOtac(String msisdn, String otac) 
                                throws FinanceServiceOtacTriesExceededException
                                {
                                    Assert.assertEquals(MsisdnConverter.msisdnToInternational("07912000000"), msisdn);
                                    Assert.assertEquals("123456", otac);
                                    return false;
                                }
                             });
        
        ModelAndView mav = controller.onSubmit(new MockHttpServletRequest(), new MockHttpServletResponse(), form, errors);
        Assert.assertEquals(FORM_VIEW, mav.getViewName());
        Assert.assertEquals(false, localModel.isMsisdnVerified());
        
        FeedbackTO feedback = (FeedbackTO) mav.getModel().get(RequestParameterConstants.FEEDBACK_REQUEST_KEY);
        Assert.assertNotNull("FeedbackTO is null", feedback);
        Assert.assertEquals( FeedbackTO.VALIDATION_ERROR, feedback.getType());
        Assert.assertEquals(PropertyManager.getFeedbackProps().getOtacIncorrectMessage(), feedback.getDesc());
    }

    public void testOnSubmitSuccess() 
    throws Exception
    {
        ServletRequestDataBinder binder = new ServletRequestDataBinder(COMMAND, COMMAND);
        BindException            errors = new BindException(binder.getBindingResult());
        localModel.setOTAC("123456");
        
        EnterOtacForm form = new EnterOtacForm();
        form.setVerificationCode("123456");
        form.setMsisdn("07912000000");
        
        controller.setFacade(new FinanceFacade()
                             {
                                public boolean verifyOtac(String msisdn, String otac) throws FinanceServiceOtacTriesExceededException
                                {
                                    Assert.assertEquals(MsisdnConverter.msisdnToInternational("07912000000"), msisdn);
                                    Assert.assertEquals("123456", otac);
                                    return true;
                                }
                             });
        
        ModelAndView mav = controller.onSubmit(new MockHttpServletRequest(), new MockHttpServletResponse(), form, errors);
        
        Assert.assertEquals(SUCCESS_VIEW, mav.getViewName());
        Assert.assertEquals(true, localModel.isMsisdnVerified());
        
        FeedbackTO feedback = (FeedbackTO) mav.getModel().get(RequestParameterConstants.FEEDBACK_REQUEST_KEY);
        Assert.assertNull("FeedbackTO is not null", feedback);
    }

    public void testOnSubmitSuccessWithExistingUser() 
    throws Exception
    {
        ServletRequestDataBinder binder = new ServletRequestDataBinder(COMMAND, COMMAND);
        BindException            errors = new BindException(binder.getBindingResult());
        
        localModel.setOTAC("123456");
        localModel.setUser(new UserTO());
        
        EnterOtacForm form = new EnterOtacForm();
        form.setVerificationCode("123456");
        form.setMsisdn("07912000000");
        
        controller.setFacade(new FinanceFacade()
                             {
                                public boolean verifyOtac(String msisdn, String otac) throws FinanceServiceOtacTriesExceededException
                                {
                                    Assert.assertEquals(MsisdnConverter.msisdnToInternational("07912000000"), msisdn);
                                    Assert.assertEquals("123456", otac);
                                    return true;
                                }
                             });
        
        ModelAndView mav = controller.onSubmit(new MockHttpServletRequest(), new MockHttpServletResponse(), form, errors);
        Assert.assertEquals(SUCCESS_VIEW, mav.getViewName());
        Assert.assertEquals(true, localModel.isMsisdnVerified());
        Assert.assertNotNull("CustomerCO is null", localModel.getUser());
        
        FeedbackTO feedback = (FeedbackTO) mav.getModel().get(RequestParameterConstants.FEEDBACK_REQUEST_KEY);
        Assert.assertNull("FeedbackTO is not null", feedback);
    }
}
