package com.o2.finance.spring.controller;

import java.util.Map;

import com.o2.finance.model.FeedbackTO;
import junit.framework.TestCase;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;

import com.o2.finance.beans.AddressBean;
import com.o2.finance.beans.DateOfBirthBean;
import com.o2.finance.beans.EnterUserDetailsForm;
import com.o2.finance.beans.GenderBean;
import com.o2.finance.beans.ProductBean;
import com.o2.finance.beans.StoredUserDetailsBean;
import com.o2.finance.etc.FinanceConstants;
import com.o2.finance.etc.RequestParameterConstants;
import com.o2.finance.exception.MaxSecondaryAccsExceededException;
import com.o2.finance.exception.MsisdnBarredException;
import com.o2.finance.exception.UserNameAlreadyExistsException;
import com.o2.finance.facade.FinanceFacade;
import com.o2.finance.facade.memory.InMemoryFinanceFacade;
import com.o2.finance.model.FinanceLocalModel;
import com.o2.finance.model.UserTO;
import com.o2.finance.properties.PropertyManager;

/**
 * Purpose: This is the test case for com.o2.finance.spring.controller.EnterUserDetailsController
 * 
 * User: D Smith Date: 20/05/2011
 */
public class EnterUserDetailsControllerTest 
extends TestCase 
implements FinanceConstants, 
           RequestParameterConstants
{
    private static final String FORM_VIEW                         = "enterUserDetails";
    private static final String SETUP_FOR_SILENT_LOG_IN_VIEW      = "silentLoginView";
    private static final String ADDRESS_LOOKUP_VIEW               = "redirect:pafLookup.do";
    private static final String SUCCESS_VIEW        			  = "redirect:updateUserDetails.do";
    private static final String COMMAND             			  = "enterUserDetailsForm";
    
    private MockHttpServletRequest     request;
    private MockHttpServletResponse    response;
    private FinanceLocalModel          local;
    private UserTO                     user;
    private EnterUserDetailsController controller;
    private InMemoryFinanceFacade      facade;
    private ServletRequestDataBinder   binder;
    private BindException              errors;
    private EnterUserDetailsForm       newUserForm;
    private GenderBean                 gBean;
    private AddressBean                aBean;
    private StoredUserDetailsBean      sBean;
    private DateOfBirthBean            dBean;

    protected void setUp() throws Exception
    {
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
        binder = new ServletRequestDataBinder(COMMAND, COMMAND);
        errors = new BindException(binder.getBindingResult());
        facade = new InMemoryFinanceFacade();
        user = new UserTO();
        local = new FinanceLocalModel();
        local.setJourneyInitialised( true );
        gBean = new GenderBean();
        aBean = new AddressBean();
        sBean = new StoredUserDetailsBean();
        dBean = new DateOfBirthBean();
        local.setUser(user);
        controller = new EnterUserDetailsController();
        controller.setLocalModel(local);
        controller.setFormView(FORM_VIEW);
        controller.setAddressLookupView(ADDRESS_LOOKUP_VIEW);
        controller.setSuccessView(SUCCESS_VIEW);
        controller.setSilentLoginView(SETUP_FOR_SILENT_LOG_IN_VIEW);
        controller.setFacade(facade);
        gBean.setGender("M");
        aBean.setHouseNumber("48");
        aBean.setPostcode("IP2 8PN");
        sBean.setStoredMsisdn("447912578673");
        dBean.setBirthDay("1");
        dBean.setBirthMonth("5");
        dBean.setBirthYear("1980");
        newUserForm = new EnterUserDetailsForm("Mr", "Vijay", "Kancherla", "447912578673", "vkancherla@smart421.com",
                "vkancherla@smart421.com", "vkancherla333", "password", "password", "Name of your pet", "pet",
                true, true, null, gBean, aBean, dBean, sBean);
        newUserForm.setMobileMake("Apple iPhone");
        
    }

    /**
     * Test to ensure that when the page loads all the drop downs are populated
     * 
     * @throws Exception
     */
    public void testOnLoadWithDefaults() throws Exception
    {
        EnterUserDetailsForm expectedForm = new EnterUserDetailsForm();
        expectedForm.setTitles(USER_DETAILS_FIELD_TITLES);
        expectedForm.setMobileMakes(USER_DETAILS_FIELD_MOBILE_MAKES);
        expectedForm.setMonths(USER_DETAILS_FIELD_BIRTH_MONTHS);
        expectedForm.setSecurityQuestions(USER_DETAILS_FIELD_SECURITY_QUESTIONS);
        EnterUserDetailsForm actualForm = (EnterUserDetailsForm) controller.formBackingObject(request);
        assertNotNull(actualForm.getTitles());
        assertEquals(4, actualForm.getTitles().size());
        assertNotNull(actualForm.getMobileMakes());
        assertEquals(26, actualForm.getMobileMakes().size());
        assertNotNull(actualForm.getMonths());
        assertEquals(13, actualForm.getMonths().size());
        assertNotNull(actualForm.getSecurityQuestions());
        assertEquals(7, actualForm.getSecurityQuestions().size());
    }

    /**
     * 
     * Test to ensure that the MSISDN is read from the localmodel and populated in the form
     * 
     * @throws Exception
     */
    public void testOnLoadGetMPN() throws Exception
    {
        String testMsisdn = "447912578673";
        local.setMsisdn(testMsisdn);
        EnterUserDetailsForm actualForm = (EnterUserDetailsForm) controller.formBackingObject(request);
        assertEquals(testMsisdn, actualForm.getStoredUserDetailsBean().getStoredMsisdn());
    }

    /**
     * 
     * Test to ensure that the correct view (redirect:pafLookup.do) is returned when "find address" button in clicked
     * 
     * @throws Exception
     */
    public void testHandOverToPAFConfirm() throws Exception
    {
        EnterUserDetailsForm form = new EnterUserDetailsForm();
        request.addParameter("findAddress", "true");
        form.setAddress(aBean);
        ModelAndView mv = controller.onSubmit(request, response, new EnterUserDetailsForm(), errors);
        assertEquals(ADDRESS_LOOKUP_VIEW, mv.getViewName());
    }

    /**
     * Test to ensure that on a successful return from PAFConfirm page, the AddressBean is populated with the required values
     * 
     * @throws Exception
     */
    public void testSuccessPAFConfirm() throws Exception
    {
        EnterUserDetailsForm form = new EnterUserDetailsForm();
        MockHttpSession session = new MockHttpSession(null);
        session.setAttribute("enterUserDetailsForm", form);
        request.setSession(session);
        request.addParameter("pafaddress", "true");
        request.addParameter("pafaddress.houseNumber", "48");
        request.addParameter("pafaddress.postcode", "IP2 8PN");
        form = (EnterUserDetailsForm) controller.formBackingObject(request);
        assertEquals("48", form.getAddress().getHouseNumber());
        assertEquals("IP2 8PN", form.getAddress().getPostcode());
    }

    /**
     * 
     * If the user has clicked the submit button without first confirming his address on the PAFconfirm page, take him to the
     * PAFconfirm page.
     * 
     * @throws Exception
     */
    public void testCreateUserPAFNotUpdated() throws Exception
    {
        local.setPafUpdated(false);
        ModelAndView mv = controller.onSubmit(request, response, newUserForm, errors);
        assertEquals(ADDRESS_LOOKUP_VIEW, mv.getViewName());
    }

    /**
     * Test for the existence of the FeedbackTO when a creatUser (with PAF updated) call fails due to a MSISDNBARREDEXCEPTION
     * 
     * @throws Exception
     */
    public void testCreateUserFailedMsisdnBarred() throws Exception
    {
        local.setPafUpdated(true);


        local.setProduct( new ProductBean(  ) );

        local.getProduct().setProductId( "1000" );

        controller.setLocalModel( local );

        controller.setFacade(new FinanceFacade()
        {
            public UserTO createUser(UserTO user) throws MsisdnBarredException, MaxSecondaryAccsExceededException,
                    UserNameAlreadyExistsException
            {
                throw new MsisdnBarredException("MSISDN is barred");
            }
        });
        ModelAndView mv = controller.onSubmit(request, response, newUserForm, errors);
        Map model = mv.getModel();
        FeedbackTO feedback = (FeedbackTO) model.get(FEEDBACK_REQUEST_KEY);
        assertNotNull(feedback);
        assertEquals( FeedbackTO.SERVER_ERROR, feedback.getType());
        assertEquals(PropertyManager.getFeedbackProps().getMsisdnBarredMessage(), feedback.getDesc());
    }

    /**
     * Test for the existence of the FeedbackTO when a creatUser (with PAF updated) call fails due to a
     * MaxSecondaryAccsExceededException
     * 
     * @throws Exception
     */
    public void testCreateUserFailedMaxSecAccsExceeded() throws Exception
    {
        local.setPafUpdated(true);

        local.setProduct( new ProductBean(  ) );

        local.getProduct().setProductId( "1000" );

        controller.setLocalModel( local );


        controller.setFacade(new FinanceFacade()
        {
            public UserTO createUser(UserTO user) throws MsisdnBarredException, MaxSecondaryAccsExceededException,
                    UserNameAlreadyExistsException
            {
                throw new MaxSecondaryAccsExceededException("MAX secondary accounts reached");
            }
        });
        ModelAndView mv = controller.onSubmit(request, response, newUserForm, errors);
        Map model = mv.getModel();
        FeedbackTO feedback = (FeedbackTO) model.get(FEEDBACK_REQUEST_KEY);
        assertNotNull(feedback);
        assertEquals( FeedbackTO.SERVER_ERROR, feedback.getType());
        assertEquals(PropertyManager.getFeedbackProps().getMaxSecondaryAccsReachedMessage(), feedback.getDesc());
    }

    /**
     * Test for the existence of the FeedbackTO when a creatUser (with PAF updated) call fails due to a
     * UserNameAlreadyExistsException
     * 
     * @throws Exception
     */
    public void testCreateUserFailedUsernameExists() throws Exception
    {
        local.setPafUpdated(true);

        local.setProduct( new ProductBean(  ) );
        local.getProduct().setProductId( "1000" );

        controller.setLocalModel( local );


        controller.setFacade(new FinanceFacade()
        {
            public UserTO createUser(UserTO user) throws MsisdnBarredException, MaxSecondaryAccsExceededException,
                    UserNameAlreadyExistsException
            {
                throw new UserNameAlreadyExistsException("USername already exists");
            }
        });
        ModelAndView mv = controller.onSubmit(request, response, newUserForm, errors);
        Map model = mv.getModel();
        FeedbackTO feedback = (FeedbackTO) model.get(FEEDBACK_REQUEST_KEY);
        assertNotNull(feedback);
        assertEquals( FeedbackTO.SERVER_ERROR, feedback.getType());
        assertEquals(PropertyManager.getFeedbackProps().getUsernameExistsMessage(), feedback.getDesc());
    }

    /**
     * 
     * Test for a successful user create (with PAF Updated)
     * 
     * @throws Exception
     */
    public void testCreatUserSuccess() throws Exception
    {
        local.setPafUpdated(true);

        local.setProduct( new ProductBean(  ) );

        local.getProduct().setProductId( "1000" );

        controller.setLocalModel( local );



        ModelAndView mv = controller.onSubmit(request, response, newUserForm, errors);
        UserTO user = local.getUser();
        assertEquals(user.getTitle(), newUserForm.getTitle());
        assertEquals(user.getForename(), newUserForm.getForename());
        assertEquals(user.getLastname(), newUserForm.getLastName());
        assertEquals(user.getGender(), newUserForm.getGender().getGender());
        assertEquals(user.getAlternativeEmail(), newUserForm.getAlternativeEmail());
        assertEquals(user.getPostcode(), newUserForm.getAddress().getPostcode());
        assertEquals("" + user.getBirthDay(), newUserForm.getDateOfBirth().getBirthDay());
        assertEquals("" + user.getBirthMonth(), newUserForm.getDateOfBirth().getBirthMonth());
        assertEquals("" + user.getBirthYear(), newUserForm.getDateOfBirth().getBirthYear());
        assertEquals(user.getMsisdn(), newUserForm.getMobileNumber());
        assertEquals(user.getSecurityQuestion(), newUserForm.getSecurityQuestion());
        assertEquals(user.getSecurityAnswer(), newUserForm.getSecurityAnswer());
        
        assertEquals(SETUP_FOR_SILENT_LOG_IN_VIEW, mv.getViewName());
    }
}
