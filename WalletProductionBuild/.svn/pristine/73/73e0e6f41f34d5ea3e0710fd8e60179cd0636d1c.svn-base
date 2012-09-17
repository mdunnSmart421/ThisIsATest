package com.o2.finance.spring.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;

import com.o2.finance.beans.AddressBean;
import com.o2.finance.beans.PafLookupForm;
import com.o2.finance.exception.FinanceException;
import com.o2.finance.facade.FinanceFacade;
import com.o2.finance.model.FinanceLocalModel;

public class PafLookupControllerTest extends TestCase
{
    private static final String COMMAND = "pafLookupForm";

    public void testFormBackingObjectNoAddress() throws Exception
    {
        AddressBean in = new AddressBean("1", "", "", "", "", "", "IP1 1PI", "");
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addParameter(PafLookupController.REQUEST_ATTR_NAME_ADDRESS + ".houseNumber", in.getHouseNumber());
        request.addParameter(PafLookupController.REQUEST_ATTR_NAME_ADDRESS + ".houseName", in.getHouseName());
        request.addParameter(PafLookupController.REQUEST_ATTR_NAME_ADDRESS + ".postcode", in.getPostcode());
        PafLookupController controller = new PafLookupController(new FinanceLocalModel()
        {
            public void setPafUpdated(boolean isPafUpdated)
            {
                Assert.fail("PafUpdated flag should not be set");
            }
        }, new FinanceFacade()
        {
            public List findAddress(String houseNumber, String houseName, String postcode)
            {
                Assert.assertEquals("1", houseNumber);
                Assert.assertEquals("", houseName);
                Assert.assertEquals("IP1 1PI", postcode);
                return Arrays.asList(new AddressBean[] {});
            }
        }, "pafConfirm", "redirect:updateUserDetails.do");
        Object form = controller.formBackingObject(request);
        Assert.assertNotNull("PafLookupForm is null", form);
        Assert.assertTrue("Form returned is not a PafLookupForm", form instanceof PafLookupForm);
        Assert.assertEquals(0, ((PafLookupForm) form).getPafList().size());
        Assert.assertEquals(in, ((PafLookupForm) form).getAddress());
        Assert.assertEquals(in.getAddress(), ((PafLookupForm) form).getCurrent());
    }

    public void testFormBackingObjectSingleAddress() throws Exception
    {
        AddressBean in = new AddressBean("1", "", "", "", "", "", "IP1 1PI", "");
        final AddressBean out = new AddressBean("1", "", "The Flats", "The Street", "The Town", "", "IP1 1PI", "");
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addParameter(PafLookupController.REQUEST_ATTR_NAME_ADDRESS + ".houseNumber", in.getHouseNumber());
        request.addParameter(PafLookupController.REQUEST_ATTR_NAME_ADDRESS + ".houseName", in.getHouseName());
        request.addParameter(PafLookupController.REQUEST_ATTR_NAME_ADDRESS + ".postcode", in.getPostcode());
        PafLookupController controller = new PafLookupController(new FinanceLocalModel()
        {
            public void setPafUpdated(boolean isPafUpdated)
            {
                Assert.fail("PafUpdated flag should not be set");
            }
        }, new FinanceFacade()
        {
            public List findAddress(String houseNumber, String houseName, String postcode)
            {
                Assert.assertEquals("1", houseNumber);
                Assert.assertEquals("", houseName);
                Assert.assertEquals("IP1 1PI", postcode);
                return Arrays.asList(new AddressBean[]
                { out });
            }
        }, "pafConfirm", "redirect:updateUserDetails.do");
        Object form = controller.formBackingObject(request);
        Assert.assertNotNull("PafLookupForm is null", form);
        Assert.assertTrue("Form returned is not a PafLookupForm", form instanceof PafLookupForm);
        Assert.assertEquals(1, ((PafLookupForm) form).getPafList().size());
        Assert.assertEquals(true, ((PafLookupForm) form).getPafList().contains(out));
        Assert.assertEquals(out, ((PafLookupForm) form).getAddress());
        Assert.assertEquals(out.getAddress(), ((PafLookupForm) form).getCurrent());
    }

    public void testFormBackingObjectMultipleAddresses() throws Exception
    {
        AddressBean in = new AddressBean("", "", "", "", "", "", "IP1 1PI", "");
        final AddressBean out1 = new AddressBean("1", "", "The Flats", "The Street", "The Town", "", "IP1 1PI", "");
        final AddressBean out2 = new AddressBean("2", "", "The Flats", "The Street", "The Town", "", "IP1 1PI", "");
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addParameter(PafLookupController.REQUEST_ATTR_NAME_ADDRESS + ".houseNumber", in.getHouseNumber());
        request.addParameter(PafLookupController.REQUEST_ATTR_NAME_ADDRESS + ".houseName", in.getHouseName());
        request.addParameter(PafLookupController.REQUEST_ATTR_NAME_ADDRESS + ".postcode", in.getPostcode());
        PafLookupController controller = new PafLookupController(new FinanceLocalModel()
        {
            public void setPafUpdated(boolean isPafUpdated)
            {
                Assert.fail("PafUpdated flag should not be set");
            }
        }, new FinanceFacade()
        {
            public List findAddress(String houseNumber, String houseName, String postcode)
            {
                Assert.assertEquals("", houseNumber);
                Assert.assertEquals("", houseName);
                Assert.assertEquals("IP1 1PI", postcode);
                return Arrays.asList(new AddressBean[]
                { out1, out2 });
            }
        }, "pafConfirm", "redirect:updateUserDetails.do");
        Object form = controller.formBackingObject(request);
        Assert.assertNotNull("PafLookupForm is null", form);
        Assert.assertTrue("Form returned is not a PafLookupForm", form instanceof PafLookupForm);
        Assert.assertEquals(2, ((PafLookupForm) form).getPafList().size());
        Assert.assertEquals(true, ((PafLookupForm) form).getPafList().contains(out1));
        Assert.assertEquals(true, ((PafLookupForm) form).getPafList().contains(out2));
        Assert.assertEquals(out1, ((PafLookupForm) form).getAddress());
        Assert.assertEquals(out1.getAddress(), ((PafLookupForm) form).getCurrent());
    }

    public void testOnSubmitWithErrors() throws Exception
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        PafLookupController controller = new PafLookupController(new FinanceLocalModel()
        {
            {setJourneyInitialised( true );}
            public void setPafUpdated(boolean isPafUpdated)
            {
                Assert.fail("PafUpdated flag should not be set");
            }
        }, null, "pafConfirm", "redirect:updateUserDetails.do");
        ServletRequestDataBinder binder = new ServletRequestDataBinder(COMMAND, COMMAND);
        BindingResult result = binder.getBindingResult();
        result.addError(new ObjectError(COMMAND, "An Error"));
        BindException errors = new BindException(result);
        ModelAndView mav = controller.onSubmit(request, new MockHttpServletResponse(), new PafLookupForm(), errors);
        Assert.assertEquals("pafConfirm", mav.getViewName());
    }

    public void testOnSubmitCancelNoCallback() throws Exception
    {
        AddressBean in = new AddressBean("1", "", "", "", "", "", "IP1 1PI", "");
        final AddressBean out = new AddressBean("1", "", "The Flats", "The Street", "The Town", "", "IP1 1PI", "");
        PafLookupForm form = new PafLookupForm(in, Arrays.asList(new AddressBean[]
        { out }));
        ServletRequestDataBinder binder = new ServletRequestDataBinder(COMMAND, COMMAND);
        BindException errors = new BindException(binder.getBindingResult());
        MockHttpServletResponse response = new MockHttpServletResponse();
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addParameter("cancel", "Cancel");
        PafLookupController controller = new PafLookupController(new FinanceLocalModel()
        {
            {setJourneyInitialised( true );}

            public void setPafUpdated(boolean isPafUpdated)
            {
                Assert.fail("PafUpdated flag should not be set");
            }
        }, null, "pafConfirm", "redirect:updateUserDetails.do");
        ModelAndView mav = controller.onSubmit(request, response, form, errors);


        // Testing cancel flow - returned address should be null
        assertNull( mav.getModel().get(PafLookupController.REQUEST_ATTR_NAME_ADDRESS) );


//        assertPafAddress(in, mav.getModel());
        Assert.assertEquals("redirect:updateUserDetails.do", mav.getViewName());
    }

    public void testOnSubmitCancelWithCallback() throws Exception
    {
        AddressBean in = new AddressBean("1", "", "", "", "", "", "IP1 1PI", "");
        final AddressBean out = new AddressBean("1", "", "The Flats", "The Street", "The Town", "", "IP1 1PI", "");
        PafLookupForm form = new PafLookupForm(in, Arrays.asList(new AddressBean[]
        { out }));
        ServletRequestDataBinder binder = new ServletRequestDataBinder(COMMAND, COMMAND);
        BindException errors = new BindException(binder.getBindingResult());
        MockHttpServletResponse response = new MockHttpServletResponse();
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addParameter("cancel", "Cancel");
        request.addParameter(PafLookupController.REQUEST_ATTR_NAME_CALLBACK, "my-callback-page");
        PafLookupController controller = new PafLookupController(new FinanceLocalModel()
        {
            {setJourneyInitialised( true );}
            public void setPafUpdated(boolean isPafUpdated)
            {
                Assert.fail("PafUpdated flag should not be set");
            }
        }, null, "pafConfirm", "redirect:updateUserDetails.do");
        ModelAndView mav = controller.onSubmit(request, response, form, errors);
                // Testing cancel flow - returned address should be null
        assertNull( mav.getModel().get(PafLookupController.REQUEST_ATTR_NAME_ADDRESS) );
//        assertPafAddress(in, mav.getModel());
        Assert.assertEquals("my-callback-page", mav.getViewName());
    }

    public void testOnSubmitSelectAddressNoCallback() throws Exception
    {
        final AddressBean out = new AddressBean("1", "", "The Flats", "The Street", "The Town", "", "IP1 1PI", "");
        PafLookupForm form = new PafLookupForm(out, Arrays.asList(new AddressBean[]
        { out }));
        ServletRequestDataBinder binder = new ServletRequestDataBinder(COMMAND, COMMAND);
        BindException errors = new BindException(binder.getBindingResult());
        MockHttpServletResponse response = new MockHttpServletResponse();
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addParameter("select", "Select Address");
        PafLookupController controller = new PafLookupController(new FinanceLocalModel()
        {
            { setJourneyInitialised(true);}
            public void setPafUpdated(boolean isPafUpdated)
            {
                Assert.assertEquals(true, isPafUpdated);
            }
        }, null, "pafConfirm", "redirect:updateUserDetails.do");
        ModelAndView mav = controller.onSubmit(request, response, form, errors);
        assertPafAddress(out, mav.getModel());
        Assert.assertEquals("redirect:updateUserDetails.do", mav.getViewName());
    }

    public void testOnSubmitSelectAddressWithCallback() throws Exception
    {
        final AddressBean out = new AddressBean("1", "", "The Flats", "The Street", "The Town", "", "IP1 1PI", "");
        PafLookupForm form = new PafLookupForm(out, Arrays.asList(new AddressBean[]
        { out }));
        ServletRequestDataBinder binder = new ServletRequestDataBinder(COMMAND, COMMAND);
        BindException errors = new BindException(binder.getBindingResult());
        MockHttpServletResponse response = new MockHttpServletResponse();
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addParameter("select", "Select Address");
        request.addParameter(PafLookupController.REQUEST_ATTR_NAME_CALLBACK, "my-callback-page");
        PafLookupController controller = new PafLookupController(new FinanceLocalModel()
        {
            { setJourneyInitialised(true);}

            public void setPafUpdated(boolean isPafUpdated)
            {
                Assert.assertEquals(true, isPafUpdated);
            }
        }, null, "pafConfirm", "redirect:updateUserDetails.do");
        ModelAndView mav = controller.onSubmit(request, response, form, errors);
        assertPafAddress(out, mav.getModel());
        Assert.assertEquals("my-callback-page", mav.getViewName());
    }

    private void assertPafAddress(AddressBean expected, Map model)
    {
        String houseNumber = (String) model.get(PafLookupController.REQUEST_ATTR_NAME_ADDRESS + ".houseNumber");
        String houseName = (String) model.get(PafLookupController.REQUEST_ATTR_NAME_ADDRESS + ".houseName");
        String addressLine1 = (String) model.get(PafLookupController.REQUEST_ATTR_NAME_ADDRESS + ".addressLine1");
        String addressLine2 = (String) model.get(PafLookupController.REQUEST_ATTR_NAME_ADDRESS + ".addressLine2");
        String townOrCity = (String) model.get(PafLookupController.REQUEST_ATTR_NAME_ADDRESS + ".townOrCity");
        String postcode = (String) model.get(PafLookupController.REQUEST_ATTR_NAME_ADDRESS + ".postcode");
        Assert.assertEquals(expected.getHouseNumber(), houseNumber != null ? houseNumber : "");
        Assert.assertEquals(expected.getHouseName(), houseName != null ? houseName : "");
        Assert.assertEquals(expected.getAddressLine1(), addressLine1 != null ? addressLine1 : "");
        Assert.assertEquals(expected.getAddressLine2(), addressLine2 != null ? addressLine2 : "");
        Assert.assertEquals(expected.getTownOrCity(), townOrCity != null ? townOrCity : "");
        Assert.assertEquals(expected.getPostcode(), postcode != null ? postcode : "");
    }

    private void assertPafAddressNull( Map model)
    {

    }

}
