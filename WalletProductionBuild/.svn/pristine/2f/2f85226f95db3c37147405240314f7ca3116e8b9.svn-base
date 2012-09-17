package com.o2.finance.spring.controller;

import java.util.Map;
import java.util.TreeMap;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import com.o2.finance.beans.ChooseAccountForm;
import com.o2.finance.facade.FinanceFacade;
import com.o2.finance.model.FinanceLocalModel;
import com.o2.finance.model.UserTO;
import com.o2.finance.properties.PropertyManager;
import com.o2.finance.util.MsisdnConverter;

public class ChooseAccountControllerTest extends TestCase
{
    private static final String FORM_VIEW        = "chooseAccount";
    private static final String SUCCESS_VIEW     = "redirect:updateUserDetails.do";
    private static final String NEW_ACCOUNT_VIEW = "redirect:enterUserDetails.do";
    private static final String COMMAND          = "chooseAccountForm";
   
    private FinanceLocalModel       localModel;
    private FinanceFacade           facade;
    private ChooseAccountController controller;

    protected void setUp() 
    throws Exception
    {
        UserTO user = new UserTO();
        user.setMsisdn(MsisdnConverter.msisdnToInternational("07912000000"));
        user.setId("user1");
        
        localModel = new FinanceLocalModel();
        localModel.setUser(user);
        localModel.setJourneyInitialised( true );

        facade     = new FinanceFacade();
        controller = new ChooseAccountController(localModel,
                                                 facade, 
                                                 FORM_VIEW, 
                                                 SUCCESS_VIEW, 
                                                 NEW_ACCOUNT_VIEW);
    }

    public void testOnSubmitExistingAccountLoggedIn() 
    throws Exception
    {
        UserTO user2 = new UserTO();
        user2.setId("user2");
        UserTO user3 = new UserTO();
        user3.setId("user3");
        
        Map accounts = new TreeMap();
        accounts.put("user1", localModel.getUser());
        accounts.put("user2", user2);
        accounts.put("user3", user3);
        
        localModel.setLoggedIn(true);
        
        ChooseAccountForm form = new ChooseAccountForm("07912000000", "user1", null);

        ModelAndView mav = controller.onSubmit(form);
        Assert.assertNotNull("ModelAndView object is null", mav);
        Assert.assertEquals(SUCCESS_VIEW, mav.getViewName());


        UserTO user = localModel.getUser();
        Assert.assertEquals("user1", user.getId());
        Assert.assertEquals(true, localModel.isLoggedIn());
    }

    public void testOnSubmitExistingAccountNotLoggedIn() 
    throws Exception
    {
        UserTO user2 = new UserTO();
        user2.setId("user2");
        UserTO user3 = new UserTO();
        user3.setId("user3");
        
        Map accounts = new TreeMap();
        accounts.put("user1", localModel.getUser());
        accounts.put("user2", user2);
        accounts.put("user3", user3);
        
        localModel.setLoggedIn(false);
        
        ChooseAccountForm form = new ChooseAccountForm("07912000000", "user1", null);

        ModelAndView mav = controller.onSubmit(form);

        View view = mav.getView();
        Assert.assertNotNull("View is null", mav.getView());
        Assert.assertTrue("View is a RedirectView", view instanceof RedirectView);
        
        String url = PropertyManager.getApplicationProperties().getO2LoginPageUrl();
        Assert.assertEquals(url, ((RedirectView) view).getUrl());
        
        UserTO user = localModel.getUser();
        Assert.assertEquals("user1", user.getId());
        Assert.assertEquals(false, localModel.isLoggedIn());
    }


    public void testOnSubmitChangeAccount() 
    throws Exception
    {
        UserTO user2 = new UserTO();
        user2.setId("user2");
        UserTO user3 = new UserTO();
        user3.setId("user3");
        
        Map accounts = new TreeMap();
        accounts.put("user1", localModel.getUser());
        accounts.put("user2", user2);
        accounts.put("user3", user3);
        
        localModel.setLoggedIn(true);

        ChooseAccountForm form = new ChooseAccountForm("07912000000", "user2", null);
        
        ModelAndView mav = controller.onSubmit(form);
        Assert.assertNotNull("ModelAndView object is null", mav);
        
        View view = mav.getView();
        Assert.assertNotNull("View is null", mav.getView());
        Assert.assertTrue("View is a RedirectView", view instanceof RedirectView);
        
        String url = PropertyManager.getApplicationProperties().getO2LoginPageUrl();
        Assert.assertEquals(url, ((RedirectView) view).getUrl());
        
        UserTO user = localModel.getUser();
        Assert.assertEquals("user1", user.getId());
    }

    public void testOnSubmitNoSelectedAccount() 
    throws Exception
    {
        UserTO user2 = new UserTO();
        user2.setId("user2");
        UserTO user3 = new UserTO();
        user3.setId("user3");
        
        Map accounts = new TreeMap();
        accounts.put("user1", localModel.getUser());
        accounts.put("user2", user2);
        accounts.put("user3", user3);
        
        ChooseAccountForm form = new ChooseAccountForm("07912000000", null, null);
        
        ModelAndView mav = controller.onSubmit(form);
        Assert.assertNotNull("ModelAndView object is null", mav);
        Assert.assertEquals(FORM_VIEW, mav.getViewName());
        
        UserTO user = localModel.getUser();
        Assert.assertEquals("user1", user.getId());
    }

    public void testShowFormWithMultipleAccounts() 
    throws Exception
    {
        final UserTO user2 = new UserTO();
        user2.setId("user2");
        final UserTO user3 = new UserTO();
        user3.setId("user3");
        controller.setFacade(new FinanceFacade()
                             {
                                public Map getUsersByMsisdn(String msisdn)
                                {
                                    return new TreeMap()
                                    {
                                        {
                                            put("user1", localModel.getUser());
                                            put("user2", user2);
                                            put("user3", user3);
                                        }
                                        private static final long serialVersionUID = 1L;
                                    };
                                }
                             });
        
        ServletRequestDataBinder binder = new ServletRequestDataBinder(COMMAND, COMMAND);
        BindException            errors = new BindException(binder.getBindingResult());
        
        ModelAndView mav = controller.showForm(new MockHttpServletRequest(), new MockHttpServletResponse(), errors);
        Assert.assertNotNull("ModelAndView object is null", mav);
        Assert.assertEquals(FORM_VIEW, mav.getViewName());
        
        UserTO user = localModel.getUser();
        Assert.assertEquals("user1", user.getId());
    }


    public void testShowFormWithSingleAccountNoMatch() 
    throws Exception
    {
        final UserTO user2 = new UserTO();
        user2.setId("user2");

        localModel.setLoggedIn(true);
        controller.setFacade(new FinanceFacade()
                             {
                                public Map getUsersByMsisdn(String msisdn)
                                {
                                    return new TreeMap()
                                    {
                                        {
                                            put("user2", user2);
                                        }
                                        private static final long serialVersionUID = 1L;
                                    };
                                }
                             });
        
        ServletRequestDataBinder binder = new ServletRequestDataBinder(COMMAND, COMMAND);
        BindException            errors = new BindException(binder.getBindingResult());
        
        ModelAndView mav = controller.showForm(new MockHttpServletRequest(), new MockHttpServletResponse(), errors);
        Assert.assertNotNull("ModelAndView object is null", mav);
        
        View view = mav.getView();
        Assert.assertNotNull("View is null", mav.getView());
        Assert.assertTrue("View is a RedirectView", view instanceof RedirectView);
        
        String url = PropertyManager.getApplicationProperties().getO2LoginPageUrl();
        Assert.assertEquals(url, ((RedirectView) view).getUrl());
        
        UserTO user = localModel.getUser();
        Assert.assertEquals("user1", user.getId());
    }

    public void testShowFormWithSingleAccountWithMatchLoggedIn() 
    throws Exception
    {
        localModel.setLoggedIn(true);
        controller.setFacade(new FinanceFacade()
                             {
                                public Map getUsersByMsisdn(String msisdn)
                                {
                                    return new TreeMap()
                                    {
                                        {
                                            put("user1", localModel.getUser());
                                        }
                                        private static final long serialVersionUID = 1L;
                                    };
                                }
                             });
        
        ServletRequestDataBinder binder = new ServletRequestDataBinder(COMMAND, COMMAND);
        BindException            errors = new BindException(binder.getBindingResult());
        
        ModelAndView mav = controller.showForm(new MockHttpServletRequest(), new MockHttpServletResponse(), errors);
        Assert.assertNotNull("ModelAndView object is null", mav);
        Assert.assertEquals(SUCCESS_VIEW, mav.getViewName());
        
        UserTO user = localModel.getUser();
        Assert.assertEquals("user1", user.getId());
    }

    public void testShowFormWithSingleAccountWithMatchNotLoggedIn() 
    throws Exception
    {
        localModel.setLoggedIn(false);
        controller.setFacade(new FinanceFacade()
                             {
                                public Map getUsersByMsisdn(String msisdn)
                                {
                                    return new TreeMap()
                                    {
                                        {
                                            put("user1", localModel.getUser());
                                        }
                                        private static final long serialVersionUID = 1L;
                                    };
                                }
                             });
        
        ServletRequestDataBinder binder = new ServletRequestDataBinder(COMMAND, COMMAND);
        BindException            errors = new BindException(binder.getBindingResult());
        
        ModelAndView mav = controller.showForm(new MockHttpServletRequest(), new MockHttpServletResponse(), errors);
        Assert.assertNotNull("ModelAndView object is null", mav);
        
        View view = mav.getView();
        Assert.assertNotNull("View is null", mav.getView());
        Assert.assertTrue("View is a RedirectView", view instanceof RedirectView);
        
        String url = PropertyManager.getApplicationProperties().getO2LoginPageUrl();
        Assert.assertEquals(url, ((RedirectView) view).getUrl());
        
        UserTO user = localModel.getUser();
        Assert.assertEquals("user1", user.getId());
    }

    public void testShowFormWithNoAccounts() 
    throws Exception
    {
        localModel.setLoggedIn(false);
        controller.setFacade(new FinanceFacade()
                             {
                                public Map getUsersByMsisdn(String msisdn)
                                {
                                    return new TreeMap();
                                }
                             });
        
        ServletRequestDataBinder binder = new ServletRequestDataBinder(COMMAND, COMMAND);
        BindException            errors = new BindException(binder.getBindingResult());
        
        ModelAndView mav = controller.showForm(new MockHttpServletRequest(), new MockHttpServletResponse(), errors);
        Assert.assertNotNull("ModelAndView object is null", mav);
        Assert.assertEquals(NEW_ACCOUNT_VIEW, mav.getViewName());
        
        UserTO user = localModel.getUser();
        Assert.assertEquals("user1", user.getId());
    }
}
