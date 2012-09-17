/**
 * 
 */
package com.o2.finance.beans.validator;

import com.o2.finance.etc.RequestParameterConstants;
import org.mockito.MockitoTestCase;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import com.o2.finance.beans.AddressBean;
import com.o2.finance.beans.DateOfBirthBean;
import com.o2.finance.beans.GenderBean;
import com.o2.finance.beans.UpdateUserDetailsForm;
import com.o2.finance.beans.validator.UpdateUserDetailsFormValidator;
import com.o2.finance.util.TestSetup;

/**
 * @author SCroft
 *
 */
public class UpdateUserDetailsFormValidatorTest extends MockitoTestCase  implements RequestParameterConstants
{
    private UpdateUserDetailsFormValidator validator;

    private String tooLong = "testnametestnametestnametestnametestnametestnametestnametestnametestname";
    private String forename = "theForename";
    private String lastName = "theLastname";
    private String mobileNumber = "07345678901";
    private String dateOfBirth = "15 December 1975";
    private String bDay = "15", bMonth = "12", bYear = "1975";
    private String houseName = "Dunroamin";
    private String houseNumber = "33";
    private String alternativeEmail = "abc@smart421.com";
    private String gender = "m";
    private String postcode = "IM3 4YH";
    // private
    //private Errors errors;

    public void setUp() throws Exception
    {
        super.setUp();
        TestSetup.initialiseLog4j();
        validator = new UpdateUserDetailsFormValidator();
    }

    public void testMobileNumberAccessor()
    {

        UpdateUserDetailsForm form = new UpdateUserDetailsForm();
        assertTrue(form.getMobileNumber().equals(""));
        form.setMobileNumber(mobileNumber);
        assertTrue(form.getMobileNumber().equals(mobileNumber));
    }

    public void testDoBAccessor()
    {
        UpdateUserDetailsForm form = new UpdateUserDetailsForm();

        createDoB(form);
        assertTrue(form.getDateOfBirth().getBirthDay().equals(bDay));
        assertTrue(form.getDateOfBirth().getBirthMonth().equals(bMonth));
        assertTrue(form.getDateOfBirth().getBirthYear().equals(bYear));
        assertTrue(form.getDateOfBirth().getDateOfBirth().equals(dateOfBirth));
    }

    /**
	 *
	 */
    private void createDoB(  UpdateUserDetailsForm form)
    {
        DateOfBirthBean dobBean = new DateOfBirthBean(bDay, bMonth, bYear);
        form.setDateOfBirth(dobBean);
    }

    public void testGenderAccessor()
    {
        UpdateUserDetailsForm form   = new UpdateUserDetailsForm();
        createGender( form );
        assertTrue(form.getGender().getGender().equals(gender));
    }

    /**
	 *
	 */
    private void createGender( UpdateUserDetailsForm form)
    {
        GenderBean gb = new GenderBean();
        gb.setGender("m");
        form.setGender(gb);
    }

    /**
	 *
	 */
    public void testPostcodeAccessor()
    {
        UpdateUserDetailsForm form = new UpdateUserDetailsForm();

        createAddress( form );
        assertTrue(form.getAddress().getPostcode().equals(postcode));
    }

    /**
	 *
	 */
    private void createAddress(UpdateUserDetailsForm form)
    {
        AddressBean aBean = new AddressBean(houseNumber, houseName, "", "", "", "", postcode, "");
        form.setAddress(aBean);
    }

    public void testAlternativeEmailAccessor()
    {
        UpdateUserDetailsForm form = new UpdateUserDetailsForm();

        form.setAlternativeEmail(alternativeEmail);
        assertTrue(form.getAlternativeEmail().equals(alternativeEmail));
    }

    /**
     * No errors when all fields have valid data
     */
    public void testNoErrors()
    {

        UpdateUserDetailsForm form = new UpdateUserDetailsForm();
        createAddress( form );
        createDoB( form );
        createGender( form );
        form.setForename(forename);
        form.setLastName(lastName);
        form.setMobileNumber(mobileNumber);
        form.setAlternativeEmail(alternativeEmail);
        form.setMobileMake( "badger" );

        Errors errors = new BeanPropertyBindingResult(form, UpdateUserDetailsForm.class.getName());

        validator.validate(form, errors);
        assertTrue(errors.getErrorCount() == 0);
    }

    /**
     * testForenameField error when not set
     */
    public void testForenameField()
    {
        UpdateUserDetailsForm form = new UpdateUserDetailsForm();

        createAddress( form );
        createDoB( form );
        createGender( form );
        form.setLastName(lastName);
        form.setMobileNumber(mobileNumber);
        form.setAlternativeEmail(alternativeEmail);
        form.setMobileMake( "badger" );
        form.setActivatedButton(CONTINUE_UPDATE);


        Errors errors = new BeanPropertyBindingResult(form, UpdateUserDetailsForm.class.getName());

        validator.validate(form, errors);
        assertTrue(errors.hasErrors());
        assertTrue(errors.getErrorCount() == 1);
        assertTrue(errors.getFieldError("forename") != null);
    }

    /**
     * testLastNameField error when not set
     */
    public void testLastNameField()
    {
        UpdateUserDetailsForm form = new UpdateUserDetailsForm();

        createAddress( form );
        createDoB( form );
        createGender( form );
        form.setForename(forename);
        form.setMobileNumber(mobileNumber);
        form.setAlternativeEmail(alternativeEmail);
        form.setMobileMake( "badger" );
        form.setActivatedButton(CONTINUE_UPDATE);


        Errors errors = new BeanPropertyBindingResult(form, UpdateUserDetailsForm.class.getName());

        validator.validate(form, errors);
        assertTrue(errors.getErrorCount() == 1);
        assertTrue(errors.getFieldError("lastName") != null);
    }

    /**
     * testHouseNumberField
     */
    public void testHouseNumberField()
    {
        UpdateUserDetailsForm form = new UpdateUserDetailsForm();

        AddressBean aBean = new AddressBean(null, houseName, null, null, null, null, postcode, null);
        form.setAddress(aBean);
        createDoB( form );
        createGender( form );
        form.setForename(forename);
        form.setLastName(lastName);
        form.setMobileNumber(mobileNumber);
        form.setAlternativeEmail(alternativeEmail);
        form.setMobileMake( "badger" );

        Errors errors = new BeanPropertyBindingResult(form, UpdateUserDetailsForm.class.getName());

        validator.validate(form, errors);
        assertEquals(0, errors.getErrorCount());
        assertNull(errors.getFieldError("address.houseNumber"));
    }

    /**
     * testHouseNameField 2 errors regex and required
     */
    public void testHouseNameField()
    {
        UpdateUserDetailsForm form = new UpdateUserDetailsForm();

        AddressBean aBean = new AddressBean(houseNumber, null, null, null, null, null, postcode, null);
        form.setAddress(aBean);

        createDoB( form );
        createGender( form );
        form.setForename(forename);
        form.setLastName(lastName);
        form.setMobileNumber(mobileNumber);
        form.setAlternativeEmail(alternativeEmail);
        form.setMobileMake( "badger" );


        Errors errors = new BeanPropertyBindingResult(form, UpdateUserDetailsForm.class.getName());

        validator.validate(form, errors);
        assertEquals(0, errors.getErrorCount());
        assertNull(errors.getFieldError("address.houseName"));
    }

    public void testHouseNameFieldTooLong()
    {

        UpdateUserDetailsForm form = new UpdateUserDetailsForm();

        AddressBean aBean = new AddressBean(houseNumber, tooLong + tooLong, null, null, null, null, postcode, null);
        form.setAddress(aBean);
        createDoB( form );
        createGender( form );
        form.setForename(forename);
        form.setLastName(lastName);
        form.setMobileNumber(mobileNumber);
        form.setAlternativeEmail(alternativeEmail);
        form.setMobileMake( "badger" );
        form.setActivatedButton(CONTINUE_UPDATE);


        Errors errors = new BeanPropertyBindingResult(form, UpdateUserDetailsForm.class.getName());

        validator.validate(form, errors);
        assertTrue(errors.getErrorCount() == 1);
        assertTrue(errors.getFieldError("address.houseName") != null);
    }

    /**
     * TestPostcode field missing 2 errors required and regex
     */
    public void testPostcodeField()
    {


        UpdateUserDetailsForm form = new UpdateUserDetailsForm();


        AddressBean aBean = new AddressBean(houseNumber, houseName, null, null, null, null, null, null);
        form.setAddress(aBean);
        createDoB( form );
        createGender( form );
        form.setForename(forename);
        form.setLastName(lastName);
        form.setMobileNumber(mobileNumber);
        form.setAlternativeEmail(alternativeEmail);
        form.setMobileMake( "badger" );
        form.setActivatedButton(CONTINUE_UPDATE);


        Errors errors = new BeanPropertyBindingResult(form, UpdateUserDetailsForm.class.getName());


        validator.validate(form, errors);
        assertTrue(errors.getErrorCount() == 1);
        assertTrue(errors.getFieldError("address.postcode") != null);
    }

    /**
     * Assert that the an error is created if the postcode is too long
     */
    public void testPostcodeTooLong()
    {
        UpdateUserDetailsForm form = new UpdateUserDetailsForm();

        AddressBean aBean = new AddressBean(houseNumber, houseName, null, null, null, null, tooLong, null);
        form.setAddress(aBean);
        createDoB( form );
        createGender( form );
        form.setForename(forename);
        form.setLastName(lastName);
        form.setMobileNumber(mobileNumber);
        form.setAlternativeEmail(alternativeEmail);
        form.setMobileMake( "badger" );
        form.setActivatedButton(CONTINUE_UPDATE);


        Errors errors = new BeanPropertyBindingResult(form, UpdateUserDetailsForm.class.getName());


        validator.validate(form, errors);
        assertTrue(errors.getErrorCount() == 1);
        assertTrue(errors.getFieldError("address.postcode") != null);
    }

    /**
     * TestBirthDay is set in the future. This adds an error to the dateOfBirth.birthYear field
     */
    public void testBirthDay()
    {

        UpdateUserDetailsForm form = new UpdateUserDetailsForm();


        createAddress( form );
        DateOfBirthBean dBean = new DateOfBirthBean("22", "2", "2015");
        form.setDateOfBirth(dBean);
        createGender( form );
        form.setForename(forename);
        form.setLastName(lastName);
        form.setMobileNumber(mobileNumber);
        form.setAlternativeEmail(alternativeEmail);
        form.setMobileMake( "badger" );
        form.setActivatedButton(CONTINUE_UPDATE);


        Errors errors = new BeanPropertyBindingResult(form, UpdateUserDetailsForm.class.getName());

        validator.validate(form, errors);
        assertTrue(errors.getErrorCount() == 1);
        assertTrue(errors.getFieldError("dateOfBirth.birthYear") != null);
    }

    /**
     * It should not be possible to set a day as 'DD'
     *
     */
    public void testBirthDayFailDD()
    {

        UpdateUserDetailsForm form = new UpdateUserDetailsForm();


        createAddress( form );
        DateOfBirthBean dBean = new DateOfBirthBean("DD", "2", "2015");
        form.setDateOfBirth(dBean);
        createGender( form );
        form.setForename(forename);
        form.setLastName(lastName);
        form.setMobileNumber(mobileNumber);
        form.setAlternativeEmail(alternativeEmail);
        form.setMobileMake( "badger" );
        form.setActivatedButton(CONTINUE_UPDATE);


        Errors errors = new BeanPropertyBindingResult(form, UpdateUserDetailsForm.class.getName());

        validator.validate(form, errors);
        assertTrue(errors.getErrorCount() == 1);
        assertTrue(errors.getFieldError("dateOfBirth.birthDay") != null);
    }

    /**
     * testYearFieldYYYY error when the form is submitted with 'YYYY'
     */
    public void testYearFieldYYYY()
    {

        UpdateUserDetailsForm form = new UpdateUserDetailsForm();


        createAddress( form );
        DateOfBirthBean dBean = new DateOfBirthBean("22", "2", "YYYY");
        form.setDateOfBirth(dBean);
        createGender( form );
        form.setForename(forename);
        form.setLastName(lastName);
        form.setMobileNumber(mobileNumber);
        form.setAlternativeEmail(alternativeEmail);
        form.setMobileMake( "badger" );
        form.setActivatedButton(CONTINUE_UPDATE);


        Errors errors = new BeanPropertyBindingResult(form, UpdateUserDetailsForm.class.getName());

        validator.validate(form, errors);
        assertTrue(errors.getErrorCount() == 1);
        assertTrue(errors.getFieldError("dateOfBirth.birthYear") != null);
    }

    /**
     * TestDateWith30DaysInFeb error attached to birthYear field
     */
    public void testDateWith30DaysInFeb()
    {

        UpdateUserDetailsForm form = new UpdateUserDetailsForm();

        createAddress( form );
        DateOfBirthBean dBean = new DateOfBirthBean("30", "2", "1990");
        form.setDateOfBirth(dBean);
        createGender( form );
        form.setForename(forename);
        form.setLastName(lastName);
        form.setMobileNumber(mobileNumber);
        form.setAlternativeEmail(alternativeEmail);
        form.setMobileMake( "badger" );
        form.setActivatedButton(CONTINUE_UPDATE);


        Errors errors = new BeanPropertyBindingResult(form, UpdateUserDetailsForm.class.getName());

        validator.validate(form, errors);
        assertTrue(errors.getErrorCount() == 1);
        assertTrue(errors.getFieldError("dateOfBirth.birthYear") != null);
    }

    /**
     * TestDateZeroMonthValue produces error in birthYear field
     */
    public void testDateZeroMonthValue()
    {

        UpdateUserDetailsForm form = new UpdateUserDetailsForm();

        createAddress( form );
        DateOfBirthBean dBean = new DateOfBirthBean("22", "0", "1990");
        form.setDateOfBirth(dBean);
        createGender( form );
        form.setForename(forename);
        form.setLastName(lastName);
        form.setMobileNumber(mobileNumber);
        form.setAlternativeEmail(alternativeEmail);
        form.setMobileMake( "badger" );
        form.setActivatedButton(CONTINUE_UPDATE);


        Errors errors = new BeanPropertyBindingResult(form, UpdateUserDetailsForm.class.getName());

        validator.validate(form, errors);
        assertTrue(errors.getErrorCount() == 1);
        assertTrue(errors.getFieldError("dateOfBirth.birthMonth") != null);
    }

    /**
     * Birth year invalid char
     */
    public void testBirthYearInvalidChar()
    {

        UpdateUserDetailsForm form = new UpdateUserDetailsForm();

        createAddress( form );
        DateOfBirthBean dBean = new DateOfBirthBean("22", "2", "19-90");
        form.setDateOfBirth(dBean);
        createGender( form );
        form.setForename(forename);
        form.setLastName(lastName);
        form.setMobileNumber(mobileNumber);
        form.setAlternativeEmail(alternativeEmail);
        form.setMobileMake( "badger" );
        form.setActivatedButton(CONTINUE_UPDATE);



        Errors errors = new BeanPropertyBindingResult(form, UpdateUserDetailsForm.class.getName());


        validator.validate(form, errors);
        assertTrue(errors.getErrorCount() == 1);
        assertTrue(errors.getFieldError("dateOfBirth.birthYear") != null);
    }

    /**
     * testEMailField missing email creates error
     */
    public void testEMailField()
    {
        UpdateUserDetailsForm form = new UpdateUserDetailsForm();

        createAddress( form );
        createDoB( form );
        createGender( form );
        form.setForename(forename);
        form.setLastName(lastName);
        form.setMobileNumber(mobileNumber);
        form.setMobileMake( "badger" );
        form.setActivatedButton(CONTINUE_UPDATE);



        Errors errors = new BeanPropertyBindingResult(form, UpdateUserDetailsForm.class.getName());

        validator.validate(form, errors);
        assertTrue(errors.getErrorCount() == 1);
        assertTrue(errors.getFieldError("alternativeEmail") != null);
    }

    /**
     * Email field too long
     */
    public void testAlternativeEMailFieldFail()
    {
        UpdateUserDetailsForm form = new UpdateUserDetailsForm();

        createAddress( form );
        createDoB( form );
        createGender( form );
        form.setForename(forename);
        form.setLastName(lastName);
        form.setAlternativeEmail("aaasdadasd@asdhasjkdhasjhdaskdaskasdjhkj");
        form.setMobileNumber(mobileNumber);
        form.setMobileMake( "badger" );
        form.setActivatedButton(CONTINUE_UPDATE);



        Errors errors = new BeanPropertyBindingResult(form, UpdateUserDetailsForm.class.getName());

        validator.validate(form, errors);
        assertTrue(errors.getErrorCount() == 1);
        assertTrue(errors.getFieldError("alternativeEmail") != null);
    }
//
//    /**
//     * testMobileNumber error when missing
//     */
//    public void testMobileNumber()
//    {
//        UpdateUserDetailsForm form = new UpdateUserDetailsForm();
//
//        createAddress( form );
//        createDoB( form );
//        createGender( form );
//        form.setForename(forename);
//        form.setLastName(lastName);
//        form.setAlternativeEmail(alternativeEmail);
//        form.setMobileMake( "badger" );
//
//        Errors errors = new BeanPropertyBindingResult(form, UpdateUserDetailsForm.class.getName());
//
//        validator.validate(form, errors);
//        assertTrue(errors.getErrorCount() == 1);
//        assertTrue(errors.getFieldError("mobileNumber") != null);
//    }

    /**
     * testGender error when missing
     */
    public void testGender()
    {
        UpdateUserDetailsForm form = new UpdateUserDetailsForm();

        createAddress( form );
        createDoB( form );
        form.setForename(forename);
        form.setLastName(lastName);
        form.setMobileNumber(mobileNumber);
        form.setAlternativeEmail(alternativeEmail);
        form.setMobileMake( "badger" );
        form.setActivatedButton(CONTINUE_UPDATE);

        Errors errors = new BeanPropertyBindingResult(form, UpdateUserDetailsForm.class.getName());
        validator.validate(form, errors);
        assertTrue(errors.getFieldError("gender.gender") != null);
        assertTrue(errors.getErrorCount() == 1);
    }
}
