package com.o2.finance.spring.controller;

import java.util.List;

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
import com.o2.finance.beans.DateOfBirthBean;
import com.o2.finance.beans.EditableUserDetailFlags;
import com.o2.finance.beans.GenderBean;
import com.o2.finance.beans.ProductBean;
import com.o2.finance.beans.StoredUserDetailsBean;
import com.o2.finance.beans.UpdateUserDetailsForm;
import com.o2.finance.etc.FinanceConstants;
import com.o2.finance.etc.RequestParameterConstants;
import com.o2.finance.facade.FinanceFacade;
import com.o2.finance.facade.memory.InMemoryFinanceFacade;
import com.o2.finance.model.FinanceLocalModel;
import com.o2.finance.model.UserTO;
import com.o2.finance.properties.PropertyManager;
import com.o2.finance.util.MsisdnConverter;

/**
 * Purpose: com.o2.finance.spring.controller User: D Smith Date: 20/05/2011
 */
public class UpdateUserDetailsControllerTest extends TestCase implements FinanceConstants, RequestParameterConstants
{
	private static final String CONFIRM_DETAILS_VIEW = "confirmDetailsPage";
	private static final String UPDATE_DETAILS_VIEW = "updateUserDetailsPage";
	private static final String PAF_UPDATED_AND_WAS_INITIATED_BY_FIND_ADDRESS_BUTTON = "redirect:updateUserDetails.do?activatedBy=FindAddress";
	private static final String PAF_UPDATED_AND_WAS_INITIATED_BY_FIND_CONTINUE_BUTTON = "redirect:updateUserDetails.do?activatedBy=Continue";
    private static final String ADDRESS_LOOKUP_VIEW = "redirect:pafLookup.do";
    private static final String SAVE_USER_UPDATES_VIEW = "redirect:saveUSerUpdates.do";
    private static final String SUCCESS_VIEW = "redirect:handoff.do";
    private static final String COMMAND = "updateUserDetailsForm";
    private static final String EDIT_VIEW = UPDATE_DETAILS_VIEW;
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;
    private FinanceLocalModel local;
    private UserTO user;
    private UpdateUserDetailsController controller;

    protected void setUp() throws Exception
    {
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
        user = new UserTO();
        local = new FinanceLocalModel();
        local.setUser(user);
        local.setProduct(new ProductBean("123456"));
        local.setJourneyInitialised( true );
        controller = new UpdateUserDetailsController();
        controller.setLocalModel(local);
        controller.setConfirmUserDetailsView(CONFIRM_DETAILS_VIEW);
        controller.setUpdateUserDetailsView(UPDATE_DETAILS_VIEW);
        controller.setAddressLookupView(ADDRESS_LOOKUP_VIEW);
        controller.setSaveUserUpdatesView( SAVE_USER_UPDATES_VIEW );
        controller.setPafCallbackActivatedByFindAddress(PAF_UPDATED_AND_WAS_INITIATED_BY_FIND_ADDRESS_BUTTON);
        controller.setPafCallbackActivatedByContinue(PAF_UPDATED_AND_WAS_INITIATED_BY_FIND_CONTINUE_BUTTON);
        controller.setSuccessView(SUCCESS_VIEW);
    }

    public void testShowFormNoPafUpdate() throws Exception
    {
        local.setPafUpdated(false);
        ServletRequestDataBinder binder = new ServletRequestDataBinder(COMMAND, COMMAND);
        BindException errors = new BindException(binder.getBindingResult());
        ModelAndView mav = controller.showForm(request, response, errors);
        Assert.assertNotNull(UPDATE_DETAILS_VIEW + " not returned", mav);
        Assert.assertEquals(UPDATE_DETAILS_VIEW, mav.getViewName());
    }

    public void testShowFormPafUpdate() throws Exception
    {
        local.setPafUpdated(true);
        ServletRequestDataBinder binder = new ServletRequestDataBinder(COMMAND, COMMAND);
        BindException errors = new BindException(binder.getBindingResult());
        ModelAndView mav = controller.showForm(request, response, errors);
        Assert.assertNotNull(CONFIRM_DETAILS_VIEW + " not returned", mav);
        Assert.assertEquals(CONFIRM_DETAILS_VIEW, mav.getViewName());
    }

    public void testShowFormNoPostPay() throws Exception
    {
        local.setPostPay(false);
        setBasicInputs();
        ServletRequestDataBinder binder = new ServletRequestDataBinder(COMMAND, COMMAND);
        BindException errors = new BindException(binder.getBindingResult());
        ModelAndView mav = controller.showForm(request, response, errors);
        assertBasicOutputs(mav);
        EditableUserDetailFlags editable = (EditableUserDetailFlags) mav.getModel().get("editable");
        Assert.assertNotNull("EditableUserDetailFlags is null", editable);
        Assert.assertEquals(true, editable.isForename());
        Assert.assertEquals(true, editable.isLastName());
        Assert.assertEquals(true, editable.isGender());
        Assert.assertEquals(true, editable.isDateOfBirth());
        String cssClass = (String) mav.getModel().get("postPayDivClass");
        Assert.assertNotNull("CSSClass is null", cssClass);
        Assert.assertEquals("w77", cssClass);
    }

    public void testShowFormPostPayNoGender() throws Exception
    {
        local.setPostPay(true);
        setBasicInputs();
        ServletRequestDataBinder binder = new ServletRequestDataBinder(COMMAND, COMMAND);
        BindException errors = new BindException(binder.getBindingResult());
        ModelAndView mav = controller.showForm(request, response, errors);
        assertBasicOutputs(mav);
        EditableUserDetailFlags editable = (EditableUserDetailFlags) mav.getModel().get("editable");
        Assert.assertNotNull("EditableUserDetailFlags is null", editable);
        Assert.assertEquals(false, editable.isForename());
        Assert.assertEquals(false, editable.isLastName());
        Assert.assertEquals(true, editable.isGender());
        Assert.assertEquals(false, editable.isDateOfBirth());
        String cssClass = (String) mav.getModel().get("postPayDivClass");
        Assert.assertNotNull("CSSClass is null", cssClass);
        Assert.assertEquals("showOverflow", cssClass);
    }

    public void testShowFormPostPayWithGender() throws Exception
    {
        local.setPostPay(true);
        setBasicInputs();
        user.setGender("M");
        ServletRequestDataBinder binder = new ServletRequestDataBinder(COMMAND, COMMAND);
        BindException errors = new BindException(binder.getBindingResult());
        ModelAndView mav = controller.showForm(request, response, errors);
        assertBasicOutputs(mav);
        EditableUserDetailFlags editable = (EditableUserDetailFlags) mav.getModel().get("editable");
        Assert.assertNotNull("EditableUserDetailFlags is null", editable);
        Assert.assertEquals(false, editable.isForename());
        Assert.assertEquals(false, editable.isLastName());
        Assert.assertEquals(false, editable.isGender());
        Assert.assertEquals(false, editable.isDateOfBirth());
        String cssClass = (String) mav.getModel().get("postPayDivClass");
        Assert.assertNotNull("CSSClass is null", cssClass);
        Assert.assertEquals("showOverflow", cssClass);
    }

    public void testOnSubmitWithErrors() throws Exception
    {
        local.setPafUpdated(true);
        ServletRequestDataBinder binder = new ServletRequestDataBinder(COMMAND, COMMAND);
        BindingResult result = binder.getBindingResult();
        result.addError(new ObjectError(COMMAND, "An Error"));
        BindException errors = new BindException(result);
        UpdateUserDetailsForm form = new UpdateUserDetailsForm();
        ModelAndView mav = controller.onSubmit(request, response, form, errors);
        Assert.assertNotNull(UPDATE_DETAILS_VIEW + " not returned", mav);
        BindingResult error = (BindingResult) mav.getModel().get(
                "org.springframework.validation.BindingResult.updateUserDetailsForm");
        Assert.assertNotNull("Errors not returned", error);
        Assert.assertEquals(1, error.getErrorCount());
        Assert.assertEquals(UPDATE_DETAILS_VIEW, mav.getViewName());
    }

    public void testOnSubmitNoErrorsPafUpdated() throws Exception
    {
        UserTO updated = onSubmitNoErrors(true, SAVE_USER_UPDATES_VIEW);
        Assert.assertEquals("uforename", updated.getForename());
        Assert.assertEquals("ulastname", updated.getLastname());
        Assert.assertEquals("ufirst@last.com", updated.getAlternativeEmail());
        Assert.assertEquals(10, updated.getBirthDay());
        Assert.assertEquals(12, updated.getBirthMonth());
        Assert.assertEquals(1980, updated.getBirthYear());
        Assert.assertEquals("F", updated.getGender());
    }

    public void testOnSubmitNoErrorsNoPaf() throws Exception
    {
        UserTO updated = onSubmitNoErrors(false, ADDRESS_LOOKUP_VIEW);
        Assert.assertEquals("uforename", updated.getForename());
        Assert.assertEquals("ulastname", updated.getLastname());
        Assert.assertEquals("ufirst@last.com", updated.getAlternativeEmail());
        Assert.assertEquals(10, updated.getBirthDay());
        Assert.assertEquals(12, updated.getBirthMonth());
        Assert.assertEquals(1980, updated.getBirthYear());
        Assert.assertEquals("F", updated.getGender());
    }

    public void testOnSubmitFindAddress() throws Exception
    {
        ServletRequestDataBinder binder = new ServletRequestDataBinder(COMMAND, COMMAND);
        BindException errors = new BindException(binder.getBindingResult());
        UpdateUserDetailsForm form = new UpdateUserDetailsForm();
        controller.setFacade(new FinanceFacade()
        {
            public UserTO updateUser(UserTO user)
            {
                Assert.fail("Update user should not be called");
                return user;
            }
        });
        user.setForename("forename");
        user.setLastname("last name");
        user.setHouseNumber("21");
        user.setPostcode("IP1 1PI");
        form.setForename("updated forename");
        form.setLastName("updated last name");
        form.getAddress().setHouseNumber("12");
        form.getAddress().setPostcode("PI1 1IP");
        request.addParameter("findAddress", "Find Address");
        ModelAndView mav = controller.onSubmit(request, response, form, errors);
        Assert.assertNotNull(ADDRESS_LOOKUP_VIEW + " not returned", mav);
        BindingResult error = (BindingResult) mav.getModel().get(
                "org.springframework.validation.BindingResult.updateUserDetailsForm");
        Assert.assertNull("Errors not returned", error);
        Assert.assertEquals("12", mav.getModel().get(PafLookupController.REQUEST_ATTR_NAME_ADDRESS + ".houseNumber"));
        Assert.assertEquals("PI1 1IP", mav.getModel().get(PafLookupController.REQUEST_ATTR_NAME_ADDRESS + ".postcode"));
        Assert.assertEquals("updated forename", user.getForename());
        Assert.assertEquals("updated last name", user.getLastname());
        Assert.assertEquals("21", user.getHouseNumber());
        Assert.assertEquals("IP1 1PI", user.getPostcode());
        Assert.assertEquals(ADDRESS_LOOKUP_VIEW, mav.getViewName());
    }

    public void testOnSubmitEdit() throws Exception
    {
        ServletRequestDataBinder binder = new ServletRequestDataBinder(COMMAND, COMMAND);
        BindException errors = new BindException(binder.getBindingResult());
        UpdateUserDetailsForm form = new UpdateUserDetailsForm();
        controller.setFacade(new FinanceFacade()
        {
            public UserTO updateUser(UserTO user)
            {
                Assert.fail("Update user should not be called");
                return user;
            }
        });
        user.setForename("forename");
        user.setLastname("last name");
        user.setHouseNumber("21");
        user.setPostcode("IP1 1PI");
        form.setForename("updated forename");
        form.setLastName("updated last name");
        form.getAddress().setHouseNumber("12");
        form.getAddress().setPostcode("PI1 1IP");
        request.addParameter("edit", "Edit");
        local.setPafUpdated(true);
        ModelAndView mav = controller.onSubmit(request, response, form, errors);
        Assert.assertNotNull(EDIT_VIEW + " not returned", mav);
        BindingResult error = (BindingResult) mav.getModel().get(
                "org.springframework.validation.BindingResult.updateUserDetailsForm");
        Assert.assertNotNull("Errors not returned", error);
        Assert.assertEquals("forename", user.getForename());
        Assert.assertEquals("last name", user.getLastname());
        Assert.assertEquals("21", user.getHouseNumber());
        Assert.assertEquals("IP1 1PI", user.getPostcode());
        Assert.assertEquals(EDIT_VIEW, mav.getViewName());
    }

    public void testGetBackingFormNoUser() throws Exception
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        controller.setFacade( new InMemoryFinanceFacade() );
        local.setUser(null);
        Object form = controller.formBackingObject(request);
        Assert.assertNotNull("Form is null", form);
        Assert.assertTrue("Form is not an UpdateUserDetailsForm", form instanceof UpdateUserDetailsForm);
        Assert.assertEquals(new UpdateUserDetailsForm(), form);
    }

    public void testGetBackingForm() throws Exception
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        UserTO user = new UserTO();
        user.setTitle("Mr");
        user.setForename("Simon");
        user.setLastname("Watson");
        user.setMsisdn("07912000000");
        user.setAlternativeEmail("simon@address.com");
        user.setGender("M");
        user.setDateOfBirth(1, 2, 1970);
        user.setHouseName("My House");
        user.setHouseNumber("28");
        user.setAddressLine1("The Flats");
        user.setAddressLine2("The Street");
        user.setTownCity("The Town");
        user.setPostcode("IP1 1DR");
        local.setUser(user);
        controller.setFacade( new InMemoryFinanceFacade() );
        UpdateUserDetailsForm expected = new UpdateUserDetailsForm(user.getTitle(), user.getForename(), user.getLastname(),
                user.getMsisdn(), user.getAlternativeEmail(), new GenderBean(user.getGender(), user.getGenderText()),
                new AddressBean(user.getHouseNumber(), user.getHouseName(), user.getAddressLine1(), user.getAddressLine2(),
                        user.getTownCity(), user.getCounty(), user.getPostcode(), user.getCountry()), new DateOfBirthBean(user.getBirthDay(), user.getBirthMonth(),
                        user.getBirthYear()));
        Object form = controller.formBackingObject(request);
        Assert.assertNotNull("Form is null", form);
        Assert.assertTrue("Form is not an UpdateUserDetailsForm", form instanceof UpdateUserDetailsForm);
        Assert.assertEquals(expected, (UpdateUserDetailsForm) form);
    }

    public void testGetBackingFormWithPafAddress() throws Exception
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        UserTO user = new UserTO();
        user.setTitle("Mr");
        user.setForename("Simon");
        user.setLastname("Watson");
        user.setMsisdn("07912000000");
        user.setAlternativeEmail("simon@address.com");
        user.setGender("M");
        user.setDateOfBirth(1, 2, 1970);
        user.setHouseName("My House");
        user.setHouseNumber("28");
        user.setAddressLine1("The Flats");
        user.setAddressLine2("The Street");
        user.setTownCity("The Town");
        user.setPostcode("IP1 1DR");
        local.setUser(user);
        controller.setFacade( new InMemoryFinanceFacade() );
        AddressBean paf = new AddressBean("48", null, "North Maltings", "Felaw Street", "Ipswich", "Suffolk", "IP2 8PN", "GB");
        addPafAddressToRequest(paf, request);
        UpdateUserDetailsForm expected = new UpdateUserDetailsForm(user.getTitle(), user.getForename(), user.getLastname(),
                user.getMsisdn(), user.getAlternativeEmail(), new GenderBean(user.getGender(), user.getGenderText()),
                new AddressBean("48", null, "North Maltings", "Felaw Street", "Ipswich", "Suffolk", "IP2 8PN", "GB"), new DateOfBirthBean(
                        user.getBirthDay(), user.getBirthMonth(), user.getBirthYear()));
        Object form = controller.formBackingObject(request);
        Assert.assertNotNull("Form is null", form);
        Assert.assertTrue("Form is not an UpdateUserDetailsForm", form instanceof UpdateUserDetailsForm);
        Assert.assertEquals(expected, (UpdateUserDetailsForm) form);
    }

    private void setBasicInputs()
    {
        List   products = PropertyManager.getProductProps().getProductIdList();
        String product  = "1000";
        if(products != null && products.size() > 0)
        {
            product = (String)products.get(0);
        }
        
        user.setMsisdn("07912000000");
        user.setId("TestUser");
        local.setProduct(new ProductBean(product));
    }

    private void assertBasicOutputs(ModelAndView mav)
    {
        List   products = PropertyManager.getProductProps().getProductIdList();
        String product  = "1000";
        if(products != null && products.size() > 0)
        {
            product = (String)products.get(0);
        }

        Assert.assertNotNull("ModelAndView is null", mav);
        StoredUserDetailsBean stored = (StoredUserDetailsBean) mav.getModel().get("storedUserDetails");
        Assert.assertNotNull("StoredUserDetailsBean is null", stored);
        Assert.assertEquals("07912000000", stored.getStoredMsisdn());
        Assert.assertEquals("TestUser", stored.getExistingUsername());
        Assert.assertEquals(product, stored.getProductId());
        Assert.assertEquals(PropertyManager.getProductProps().getProductTitle(product), stored.getProductName());
    }

    public static void addPafAddressToRequest(AddressBean address, MockHttpServletRequest request)
    {
        if (address.getHouseNumber().trim().length() > 0)
        {
            request.addParameter(PafLookupController.REQUEST_ATTR_NAME_ADDRESS + ".houseNumber", address.getHouseNumber());
        }
        if (address.getHouseName().trim().length() > 0)
        {
            request.addParameter(PafLookupController.REQUEST_ATTR_NAME_ADDRESS + ".houseName", address.getHouseName());
        }
        if (address.getAddressLine1().trim().length() > 0)
        {
            request.addParameter(PafLookupController.REQUEST_ATTR_NAME_ADDRESS + ".addressLine1", address.getAddressLine1());
        }
        if (address.getAddressLine2().trim().length() > 0)
        {
            request.addParameter(PafLookupController.REQUEST_ATTR_NAME_ADDRESS + ".addressLine2", address.getAddressLine2());
        }
        if (address.getTownOrCity().trim().length() > 0)
        {
            request.addParameter(PafLookupController.REQUEST_ATTR_NAME_ADDRESS + ".townOrCity", address.getTownOrCity());
        }
        if (address.getPostcode().trim().length() > 0)
        {
            request.addParameter(PafLookupController.REQUEST_ATTR_NAME_ADDRESS + ".postcode", address.getPostcode());
        }
    }

    private UserTO onSubmitNoErrors(boolean pafUpdated, String successView) throws Exception
    {
        local.setPafUpdated(pafUpdated);
        
        request.addParameter("continueUpdate", "Continue to Confirm Page");
        
        ServletRequestDataBinder binder = new ServletRequestDataBinder(COMMAND, COMMAND);
        BindException            errors = new BindException(binder.getBindingResult());
        
        UpdateUserDetailsForm    form   = new UpdateUserDetailsForm();
        InMemoryFinanceFacade    facade = new InMemoryFinanceFacade();
        facade.setModel(local);
        
        user.setId("test1");
        user.setForename("forename");
        user.setLastname("lastname");
        user.setAlternativeEmail("first@last.com");
        user.setPostcode("postcode");
        user.setDateOfBirth(1, 2, 1970);
        user.setGender("M");
        user.setMsisdn(MsisdnConverter.msisdnToInternational("07912000000"));
        
        
        facade.createUser(new UserTO(user));
        local.setUser(user);
        
        form.setForename("uforename");
        form.setLastName("ulastname");
        form.setAlternativeEmail("ufirst@last.com");
        form.getDateOfBirth().setBirthDay("10");
        form.getDateOfBirth().setBirthMonth("12");
        form.getDateOfBirth().setBirthYear("1980");
        form.getGender().setGender("F");
        
        controller.setFacade(facade);
        
        ModelAndView mav = controller.onSubmit(request, response, form, errors);
        Assert.assertNotNull( mav );
        
        BindingResult error = (BindingResult) mav.getModel().get(
                "org.springframework.validation.BindingResult.updateUserDetailsForm");
        
        if ( error != null )
        {
        	Assert.assertEquals(0, error.getErrorCount());
        }        
        
        if ( !pafUpdated )
        {
        	/*
        	 * We are going to the PAF view. So make sure "callback" and "forward" request params are set
        	 * 
        	 */
        	String callback = ( String ) mav.getModel().get( REQUEST_ATTR_NAME_CALLBACK );
            String forward  = ( String ) mav.getModel().get( REQUEST_ATTR_NAME_FORWARD_TO ); 
            
            Assert.assertEquals( PAF_UPDATED_AND_WAS_INITIATED_BY_FIND_CONTINUE_BUTTON , callback );
            Assert.assertEquals( SAVE_USER_UPDATES_VIEW , forward );
            
        }
        
        Assert.assertEquals(successView, mav.getViewName());
        
        /*
         * all the user details will be updated with in the
         * userTO in the LocalModel, ready to be persisted to
         * the back end.
         */
        return local.getUser();
    }
    
    public void testHandOffToWaveCrest() throws Exception
    {
    	ServletRequestDataBinder binder = new ServletRequestDataBinder(COMMAND, COMMAND);
        BindException            errors = new BindException(binder.getBindingResult());
        
        UpdateUserDetailsForm    form   = new UpdateUserDetailsForm();
        InMemoryFinanceFacade    facade = new InMemoryFinanceFacade();
        
        local.setPafUpdated(true);
        facade.setModel(local);        
        
        user.setId("test1");
        user.setForename("forename");
        user.setLastname("lastname");
        user.setAlternativeEmail("first@last.com");
        user.setPostcode("postcode");
        user.setDateOfBirth(1, 2, 1970);
        user.setGender("M");
        user.setMsisdn(MsisdnConverter.msisdnToInternational("07912000000"));
        user.setHouseName("My House");
        user.setHouseNumber("28");
        user.setAddressLine1("The Flats");
        user.setAddressLine2("The Street");
        user.setTownCity("The Town");
        user.setPostcode("IP1 1DR");
        
        facade.createUser(new UserTO(user));
        
        user.setId("test1");
        user.setForename("updated forename");
        user.setLastname("updated lastname");
        user.setAlternativeEmail("updated_first@last.com");
        user.setDateOfBirth(10, 12, 1980);
        user.setGender("F");
        user.setHouseName("My Updated House");
        user.setHouseNumber("58");
        user.setAddressLine1("The Updated Flats");
        user.setAddressLine2("The Updated Street");
        user.setTownCity("The Updated Town");
        user.setPostcode("IP1 1PI");
        local.setUser(user);
        
        controller.setFacade(facade);
        
        ModelAndView mav = controller.onSubmit(request, response, form, errors);
                
//        UserTO updatedUser = facade.getUserByUsername("test1");
//        
//        Assert.assertEquals("updated forename", updatedUser.getForename());
//        Assert.assertEquals("updated lastname", updatedUser.getLastname());
//        Assert.assertEquals("updated_first@last.com", updatedUser.getAlternativeEmail());
//        Assert.assertEquals(10, updatedUser.getBirthDay());
//        Assert.assertEquals(12, updatedUser.getBirthMonth());
//        Assert.assertEquals(1980, updatedUser.getBirthYear());
//        Assert.assertEquals("F", updatedUser.getGender());
//        Assert.assertEquals("58", updatedUser.getHouseNumber());
//        Assert.assertEquals("My Updated House", updatedUser.getHouseName());
//        Assert.assertEquals("The Updated Flats", updatedUser.getAddressLine1());
//        Assert.assertEquals("The Updated Town", updatedUser.getTownCity());
//        Assert.assertEquals("IP1 1PI", updatedUser.getPostcode());
        
        Assert.assertEquals(SUCCESS_VIEW, mav.getViewName());
        
    }
    
}
