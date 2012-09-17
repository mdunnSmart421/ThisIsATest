package com.o2.finance.beans.validator;

import com.o2.finance.beans.AddressBean;
import com.o2.finance.beans.DateOfBirthBean;
import com.o2.finance.beans.EnterUserDetailsForm;
import com.o2.finance.beans.GenderBean;
import com.rsa.certj.cert.attributes.DateOfBirth;
import junit.framework.TestCase;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: dave
 * Date: 16/11/2011
 * Time: 19:29
 * To change this template use File | Settings | File Templates.
 */
public class EnterUserDetailsFormValidatorTest extends TestCase {

    /*  Validate the following fields to ensure max length is checked
        houseNumber
        postcode
        birthday
        birthYear
        password
        confirmPassword

    */

    private EnterUserDetailsForm createValidForm()
    {
        EnterUserDetailsForm form = new EnterUserDetailsForm();
        form.setTitle("Mr");
        form.setForename("Dave");
        form.setLastName("Smith");

        AddressBean address = new AddressBean();
        address.setHouseName("badger");
        address.setPostcode("IP2 8PN");
        form.setAddress( address );

        GenderBean gender = new GenderBean();
        gender.setGender("M");

        form.setGender( gender );

        DateOfBirthBean dateOfBirth = new DateOfBirthBean();
        dateOfBirth.setBirthDay("1");
        dateOfBirth.setBirthMonth("4");
        dateOfBirth.setBirthYear("1960");

        form.setDateOfBirth( dateOfBirth );

        form.setMobileMake("iPhone");
        form.setAlternativeEmail("test@smart421.com");
        form.setConfirmAlternativeEmail("test@smart421.com");
        form.setUsername("badger1234");
        form.setPassword("password");
        form.setConfirmPassword("password");
        form.setSecurityQuestion("Favourite animal");
        form.setSecurityAnswer("Badger");

        return form;

    }



    private EnterUserDetailsFormValidator validator;
    private EnterUserDetailsForm form;
    private Errors errors;



    public void setUp() throws Exception
    {
        validator = new EnterUserDetailsFormValidator();
        form = createValidForm();
        errors = new BeanPropertyBindingResult(form, EnterUserDetailsForm.class.getName());
    }

    public void testValidateFieldLengths() throws Exception {

        validator.validate( form, errors );
        assertTrue( errors.getErrorCount() == 0 );
    }

    public void testForename() throws Exception {

        // Max length forename is 20 characters (despite interface allowing max 30 chars)
        form.setForename("BobbyBobbybobbybobbyz");

        validator.validate( form, errors );
        assertTrue( errors.getFieldErrorCount("forename") == 1 );


        assertTrue(errors.getErrorCount() == 1);

    }


    public void testLastname() throws Exception {
        // Max length surname  20 characters (despite interface allowing max 30 chars)
        form.setLastName("smithsmithsmithsmithz");

        validator.validate( form, errors );

        assertTrue(errors.getFieldErrorCount("lastName" ) ==  1);
    }


    public void testHouseNumber() throws Exception {

        // Max length housenumber = 5
        form.getAddress().setHouseNumber("12345645678");
        validator.validate(form, errors);

        assertTrue(errors.getFieldErrorCount("address.houseNumber") == 1);

    }


    public void testHouseName() throws Exception {
        // Max length of housename is 80 characters
        form.getAddress().setHouseName("BadgerBadgerBadgerBadgerBadgerBadgerBadgerBadgerBadgerBadgerBadgerBadgerBadgerBadgerBadgerBadger");
        validator.validate(form, errors);

        assertTrue(errors.getFieldErrorCount("address.houseName") == 1);
    }

    // regex for postcode does not specify max length as implicit in regex construction

    public void testBirthDay() throws Exception {
        // Max length of birthDay is 2 characters
        form.getDateOfBirth().setBirthDay("123");

        validator.validate(form, errors);

        assertTrue(errors.getFieldErrorCount( "dateOfBirth.birthYear" ) == 1);
    }

    public void testBirthYear() throws Exception {
        // Max length of birthYear is 4 characters

        form.getDateOfBirth().setBirthYear("19603");

        validator.validate(form, errors);

        assertTrue(errors.getFieldErrorCount( "dateOfBirth.birthYear" ) == 1);
    }

    public void testEmailAddress() throws Exception {
        // Max length of email field is 127 characters

        String namePart = "test";
        String domainPart = "";
        String tldPart = "com";


        char[] domain = new char[127];
        for( int i=0; i< domain.length; i++)
        {
            domain[i]='x';
        }


       System.out.println( String.valueOf(domain));
        domainPart =  String.valueOf(domain);

        String address = namePart + "@" + domainPart + "." + tldPart;

        form.setAlternativeEmail(address);
        form.setConfirmAlternativeEmail(address);
        validator.validate(form, errors);

        assertTrue( errors.getFieldErrorCount("alternativeEmail") ==1 );



    }

    public void testUsername() throws Exception {
        //To change body of created methods use File | Settings | File Templates.
    }

    public void testPassword() throws Exception {
        //To change body of created methods use File | Settings | File Templates.
    }

    public void testSecurityAnswer() throws Exception {
        //To change body of created methods use File | Settings | File Templates.
    }
}

