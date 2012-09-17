/**
 * 
 */
package com.o2.finance.spring.controller;

import com.o2.finance.beans.ProductBean;
import com.o2.finance.model.FeedbackTO;
import junit.framework.Assert;
import junit.framework.TestCase;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;

import com.o2.finance.beans.EnterMpnForm;
import com.o2.finance.etc.RequestParameterConstants;
import com.o2.finance.exception.FinanceServiceVerificationCodeTriesExceededException;
import com.o2.finance.facade.FinanceFacade;
import com.o2.finance.model.FinanceLocalModel;
import com.o2.finance.model.UserTO;
import com.o2.finance.properties.PropertyManager;
import com.o2.finance.util.MsisdnConverter;

/**
 * @author SWatson
 * 
 */
public class EnterMpnControllerTest extends TestCase
{
    private static final String COMMAND = "enterMpnForm";
    private static final String FORM_VIEW = "enterMpn";
    private static final String EXISTING_MPN_VIEW = "enterMpn";
    private static final String SUCCESS_VIEW = "redirect:enterOtac.do";
    private FinanceLocalModel localModel;
    private FinanceFacade facade;
    private EnterMpnController controller;

    protected void setUp() throws Exception
    {
        localModel = new FinanceLocalModel();
        localModel.setJourneyInitialised( true );

        MockHttpServletRequest request = new MockHttpServletRequest(  );

        localModel.setProduct( ProductBean.getProduct( "1000", request.getSession( true ) ) );

        facade = new FinanceFacade();
        controller = new EnterMpnController(facade, localModel, EXISTING_MPN_VIEW, FORM_VIEW, SUCCESS_VIEW);

    }

    public void testOnSubmitWithErrors() throws Exception
    {
        ServletRequestDataBinder binder = new ServletRequestDataBinder(COMMAND, COMMAND);
        BindingResult result = binder.getBindingResult();
        result.addError(new ObjectError(COMMAND, "An Error"));
        BindException errors = new BindException(result);
        ModelAndView mav = controller.onSubmit(new MockHttpServletRequest(), new MockHttpServletResponse(), new EnterMpnForm(),
                errors);
        Assert.assertNotNull(FORM_VIEW + " not returned", mav);
        BindingResult error = (BindingResult) mav.getModel().get("org.springframework.validation.BindingResult.enterMpnForm");
        Assert.assertNotNull("Errors not returned", error);
        Assert.assertEquals(1, error.getErrorCount());
        Assert.assertEquals(FORM_VIEW, mav.getViewName());
    }

    public void testOnSubmitSuccess() throws Exception
    {
        ServletRequestDataBinder binder = new ServletRequestDataBinder(COMMAND, COMMAND);
        BindException errors = new BindException(binder.getBindingResult());
        EnterMpnForm form = new EnterMpnForm("07912000000");
        controller.setFacade(new FinanceFacade()
        {
            public String sendOtac(String msisdn) throws FinanceServiceVerificationCodeTriesExceededException
            {
                Assert.assertEquals(MsisdnConverter.msisdnToInternational("07912000000"), msisdn);
                return "123456";
            }
        });
        ModelAndView mav = controller.onSubmit(new MockHttpServletRequest(), new MockHttpServletResponse(), form, errors);
        Assert.assertEquals(SUCCESS_VIEW, mav.getViewName());
        Assert.assertEquals("123456", localModel.getOTAC());
        Assert.assertEquals(false, localModel.isMsisdnVerified());
    }

    public void testOnSubmitForResend() throws Exception
    {
        ServletRequestDataBinder binder = new ServletRequestDataBinder(COMMAND, COMMAND);
        BindException errors = new BindException(binder.getBindingResult());
        EnterMpnForm form = new EnterMpnForm("07912000000");
        form.setResentRequest(true);
        controller.setFacade(new FinanceFacade()
        {
            public String sendOtac(String msisdn) throws FinanceServiceVerificationCodeTriesExceededException
            {
                Assert.assertEquals(MsisdnConverter.msisdnToInternational("07912000000"), msisdn);
                return "123456";
            }
        });
        ModelAndView mav = controller.onSubmit(new MockHttpServletRequest(), new MockHttpServletResponse(), form, errors);
        Assert.assertEquals(SUCCESS_VIEW, mav.getViewName());
        Assert.assertEquals("123456", localModel.getOTAC());
        Assert.assertEquals(false, localModel.isMsisdnVerified());
        Assert.assertEquals(new Integer( FeedbackTO.MESSAGE),
                mav.getModel().get(RequestParameterConstants.FEEDBACK_TYPE_REQUEST_KEY));
        Assert.assertEquals(PropertyManager.getFeedbackProps().getOtacResendMessage(),
                mav.getModel().get(RequestParameterConstants.FEEDBACK_MESSAGE_REQUEST_KEY));
    }

    public void testOnSubmitExceedsTriesNotReSend() throws Exception
    {
        ServletRequestDataBinder binder = new ServletRequestDataBinder(COMMAND, COMMAND);
        BindException errors = new BindException(binder.getBindingResult());
        EnterMpnForm form = new EnterMpnForm("07912000000");
        controller.setFacade(new FinanceFacade()
        {
            public String sendOtac(String msisdn) throws FinanceServiceVerificationCodeTriesExceededException
            {
                throw new FinanceServiceVerificationCodeTriesExceededException(null,null,null);
            }
        });
        ModelAndView mav = controller.onSubmit(new MockHttpServletRequest(), new MockHttpServletResponse(), form, errors);
        Assert.assertEquals(FORM_VIEW, mav.getViewName());
        Assert.assertNull("OTAC is set in FinanceLocalModel", localModel.getOTAC());
        Assert.assertEquals(false, localModel.isMsisdnVerified());
        FeedbackTO feedback = (FeedbackTO) mav.getModel().get(RequestParameterConstants.FEEDBACK_REQUEST_KEY);
        Assert.assertNotNull("FeedbackTO is null", feedback);
        Assert.assertEquals( FeedbackTO.VALIDATION_ERROR, feedback.getType());
        Assert.assertEquals(PropertyManager.getFeedbackProps().getOtacRequestsExceededMessage(), feedback.getDesc());
    }

    public void testOnSubmitExceedsTriesOnReSend() throws Exception
    {
        ServletRequestDataBinder binder = new ServletRequestDataBinder(COMMAND, COMMAND);
        BindException errors = new BindException(binder.getBindingResult());
        EnterMpnForm form = new EnterMpnForm("07912000000");
        form.setResentRequest(true);
        controller.setFacade(new FinanceFacade()
        {
            public String sendOtac(String msisdn) throws FinanceServiceVerificationCodeTriesExceededException
            {
                throw new FinanceServiceVerificationCodeTriesExceededException(null,null,null);
            }
        });
        ModelAndView mav = controller.onSubmit(new MockHttpServletRequest(), new MockHttpServletResponse(), form, errors);
        Assert.assertEquals(SUCCESS_VIEW, mav.getViewName());
        Assert.assertNull("OTAC is set in FinanceLocalModel", localModel.getOTAC());
        Assert.assertEquals(false, localModel.isMsisdnVerified());
        Assert.assertEquals(new Integer( FeedbackTO.VALIDATION_ERROR),
                mav.getModel().get(RequestParameterConstants.FEEDBACK_TYPE_REQUEST_KEY));
        Assert.assertEquals(PropertyManager.getFeedbackProps().getOtacRequestsExceededMessage(),
                mav.getModel().get(RequestParameterConstants.FEEDBACK_MESSAGE_REQUEST_KEY));
    }

    public void testBackingFormObject() throws Exception
    {
        EnterMpnForm form = new EnterMpnForm();
        Object obj = controller.formBackingObject(null);
        Assert.assertNotNull("EnterMpnForm is null", obj);
        Assert.assertTrue("Form is not a EnterMpnForm", obj instanceof EnterMpnForm);
        Assert.assertEquals(form, obj);
    }

    public void testBackingFormObjectWithMsisdnInLocalModel() throws Exception
    {
        String msisdn = "07912000000";
        EnterMpnForm form = new EnterMpnForm();
        localModel.setMsisdn(msisdn);
        form.setMsisdn(msisdn);
        Object obj = controller.formBackingObject(null);
        Assert.assertNotNull("EnterMpnForm is null", obj);
        Assert.assertTrue("Form is not a EnterMpnForm", obj instanceof EnterMpnForm);
        Assert.assertEquals(form, obj);
    }

    public void testBackingFormObjectWithExistingUser() throws Exception
    {
        String msisdn = "07912000000";
        EnterMpnForm form = new EnterMpnForm();
        UserTO user = new UserTO();
        user.setMsisdn(MsisdnConverter.msisdnToInternational(msisdn));
        localModel.setUser(user);
        form.setMsisdn(MsisdnConverter.msisdnToNational(msisdn));
        Object obj = controller.formBackingObject(null);
        Assert.assertNotNull("EnterMpnForm is null", obj);
        Assert.assertTrue("Form is not a EnterMpnForm", obj instanceof EnterMpnForm);
        Assert.assertEquals(form, obj);
    }

    public void testShowFormWithResend() throws Exception
    {
        ServletRequestDataBinder binder = new ServletRequestDataBinder(COMMAND, COMMAND);
        BindException errors = new BindException(binder.getBindingResult());
        controller.setFacade(new FinanceFacade()
        {
            public String sendOtac(String msisdn) throws FinanceServiceVerificationCodeTriesExceededException
            {
                Assert.assertEquals(MsisdnConverter.msisdnToInternational("07912000000"), msisdn);
                return "123456";
            }
        });
        localModel.setMsisdn(MsisdnConverter.msisdnToInternational("07912000000"));
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addParameter("action", "resendotac");
        ModelAndView mav = controller.showForm(request, new MockHttpServletResponse(), errors);
        Assert.assertEquals(SUCCESS_VIEW, mav.getViewName());
        Assert.assertEquals("123456", localModel.getOTAC());
        Assert.assertEquals(false, localModel.isMsisdnVerified());
    }

    public void testShowFormNoResendNoExistingMpn() throws Exception
    {
        ServletRequestDataBinder binder = new ServletRequestDataBinder(COMMAND, COMMAND);
        BindException errors = new BindException(binder.getBindingResult());
        ModelAndView mav = controller.showForm(new MockHttpServletRequest(), new MockHttpServletResponse(), errors);
        Assert.assertEquals(FORM_VIEW, mav.getViewName());
        Assert.assertEquals(false, localModel.isMsisdnVerified());
    }

    public void testShowFormNoResendWithExistingLocalModelMpn() throws Exception
    {
        ServletRequestDataBinder binder = new ServletRequestDataBinder(COMMAND, COMMAND);
        BindException errors = new BindException(binder.getBindingResult());
        localModel.setMsisdn("07912000000");
        ModelAndView mav = controller.showForm(new MockHttpServletRequest(), new MockHttpServletResponse(), errors);
        Assert.assertEquals(EXISTING_MPN_VIEW, mav.getViewName());
        Assert.assertEquals(false, localModel.isMsisdnVerified());
    }

    public void testShowFormNoResendWithExistingUserMpn() throws Exception
    {
        ServletRequestDataBinder binder = new ServletRequestDataBinder(COMMAND, COMMAND);
        BindException errors = new BindException(binder.getBindingResult());
        UserTO user = new UserTO();
        user.setMsisdn("07912000000");
        localModel.setUser(user);
        ModelAndView mav = controller.showForm(new MockHttpServletRequest(), new MockHttpServletResponse(), errors);
        Assert.assertEquals(EXISTING_MPN_VIEW, mav.getViewName());
        Assert.assertEquals(false, localModel.isMsisdnVerified());
    }
}
