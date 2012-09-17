/**
 *
 */
package com.o2.finance.beans.validator;

import org.mockito.MockitoTestCase;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import com.o2.finance.beans.AddressBean;
import com.o2.finance.beans.DateOfBirthBean;
import com.o2.finance.beans.EnterUserDetailsForm;
import com.o2.finance.beans.GenderBean;
import com.o2.finance.util.TestSetup;

/**
 * @author SCroft
 */
public class EnterUserDetailsValidatorTest extends MockitoTestCase
{
    // private Logger log = LogManager.getLogger( this.getClass());

    private EnterUserDetailsFormValidator validator = new EnterUserDetailsFormValidator();


    private void populateValidForm( EnterUserDetailsForm form )
    {
        AddressBean address = new AddressBean();
        address.setHouseName( "Wellington House" );
        address.setHouseNumber( "23" );
        address.setPostcode( "IP1 1AA" );
        form.setAddress( address );
        form.setAlternativeEmail( "badger@wombat.com" );
        form.setConfirmAlternativeEmail( "badger@wombat.com" );
        form.setConfirmPassword( "password" );

        DateOfBirthBean dob = new DateOfBirthBean();
        dob.setBirthDay( "1" );
        dob.setBirthMonth( "4" );
        dob.setBirthYear( "1960" );


        form.setDateOfBirth( dob );
        form.setForename( "William" );

        GenderBean gender = new GenderBean();
        gender.setGender( "M" );
        form.setGender( gender );

        form.setLastName( "elephant" );
        form.setMobileMake( "cheapo" );
        form.setMobileNumber( "07123456789" );
        form.setPassword( "password" );

        form.setSecurityAnswer( "Alexander" );
        form.setSecurityQuestion( "Favourite animal" );

        form.setTitle( "Rev" );
        form.setUsername( "honeybadger" );


        form.setWantsO2Marketing( true );
        form.setWantsOtherMarketing( true );

    }


    public void setUp() throws Exception
    {
        super.setUp();
        TestSetup.initialiseLog4j();
        validator = new EnterUserDetailsFormValidator();

    }


    private Errors initTest( EnterUserDetailsForm form )
    {

        populateValidForm( form );

        return new BeanPropertyBindingResult( form, EnterUserDetailsForm.class.getName() );

    }


    /**
     * Address tests
     */

    public void testAddress()
    {

        EnterUserDetailsForm form = new EnterUserDetailsForm();
        Errors errors;


        // Check that form valildates with default test values.
        errors  = initTest( form );
        validator.validate( form, errors );
        assertTrue( errors.getErrorCount() == 0 );


        // Postcode must be present
        form.getAddress( ).setPostcode( null );
        validator.validate( form, errors );

        String fieldName = "address.postcode";

        FieldError fieldError = errors.getFieldError( fieldName );

        assertEquals( "",  (String) fieldError.getRejectedValue() );

        assertEquals( fieldName, fieldError.getField() );

        assertTrue( errors.getErrorCount() == 1);




        errors  = initTest( form );
        form.getAddress( ).setPostcode( "" );
        validator.validate( form, errors );

        fieldError = errors.getFieldError( fieldName );

        assertEquals( "",  (String) fieldError.getRejectedValue() );

        assertEquals( fieldName, fieldError.getField() );

        assertTrue( errors.getErrorCount() == 1);



        // Postcode must match regular expression

        errors  = initTest( form );
        form.getAddress().setPostcode( "1234556" );
        validator.validate( form, errors );

        fieldError = errors.getFieldError( fieldName );

        assertEquals( "1234 556", (String) fieldError.getRejectedValue() );
        assertEquals( fieldName, fieldError.getField()  );
        assertTrue( errors.getErrorCount() == 1 );



        errors  = initTest( form );
        form.getAddress().setPostcode( "ippppp" );
        validator.validate( form, errors );

        fieldError = errors.getFieldError( fieldName );

        assertEquals( "IPP PPP", (String) fieldError.getRejectedValue() );
        assertEquals( fieldName, fieldError.getField()  );
        assertTrue( errors.getErrorCount() == 1 );



        errors  = initTest( form );
        form.getAddress().setPostcode( "ip1111111111111111111111111111111pp" );
        validator.validate( form, errors );
        fieldError = errors.getFieldError( fieldName );

        assertEquals( "ip111111111111111111111111111111 1pp".toUpperCase(), (String) fieldError.getRejectedValue() );
        assertEquals( fieldName, fieldError.getField()  );
        assertTrue( errors.getErrorCount() > 0 );



        //      valid
        errors  = initTest( form );
        form.getAddress().setPostcode( "ip11aa" );
        validator.validate( form, errors );

        assertTrue( errors.getErrorCount() == 0 );


        //      valid
        errors  = initTest( form );
        form.getAddress().setPostcode( "Ip11aa" );
        validator.validate( form, errors );

        assertTrue( errors.getErrorCount() == 0 );


        //      valid
        errors  = initTest( form );
        form.getAddress().setPostcode( "IP11AA" );
        validator.validate( form, errors );

        assertTrue( errors.getErrorCount() == 0 );


        //      valid
        errors  = initTest( form );
        form.getAddress().setPostcode( "IP1 1AA" );
        validator.validate( form, errors );

        assertTrue( errors.getErrorCount() == 0 );




        fieldName = "address.houseNumber";

        // Either houseNumber and/or houseName required.
        errors = initTest( form );
        form.getAddress().setHouseName( "" );
        form.getAddress().setHouseNumber( "" );
        validator.validate( form, errors );


        fieldError = errors.getFieldError( fieldName );
        assertNotNull( fieldError );
        assertTrue( fieldName.equalsIgnoreCase(  fieldError.getField() ) );



        errors = initTest( form );
        form.getAddress().setHouseName( "Buck House" );
        form.getAddress().setHouseNumber( "" );
        validator.validate( form, errors );


        fieldError = errors.getFieldError( fieldName );
        assertNull( fieldError );


        errors = initTest( form );
        form.getAddress().setHouseName( "" );
        form.getAddress().setHouseNumber( "299" );
        validator.validate( form, errors );


        fieldError = errors.getFieldError( fieldName );
        assertNull( fieldError );




        // if present, house number must be numeric
        errors = initTest( form );
        form.getAddress().setHouseName( "" );
        form.getAddress().setHouseNumber( "asdfasfd" );
        validator.validate( form, errors );


        fieldError = errors.getFieldError( fieldName );
        assertNotNull( fieldError );
        assertEquals( fieldName, fieldError.getField() );



        // if present, house name must validate against regex
        errors = initTest( form );
        form.getAddress().setHouseName( "12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789001234567890" );
        form.getAddress().setHouseNumber( "" );
        validator.validate( form, errors );


        fieldName = "address.houseName";

        fieldError = errors.getFieldError( fieldName );
        assertNotNull( fieldError );
        assertTrue( fieldName.equalsIgnoreCase(  fieldError.getField() ) );

    }


    /**
     * Alternative email tests
     */

    public void testAlternativeEmail()
    {

        EnterUserDetailsForm form = new EnterUserDetailsForm();
        Errors errors;


       // Check that form validates with default test values.
        errors  = initTest( form );
        validator.validate( form, errors );
        assertTrue( errors.getErrorCount() == 0 );



        String fieldName = "alternativeEmail";

        // required
        errors = initTest( form );
        form.setAlternativeEmail( "" );

        validator.validate( form, errors );
        FieldError fieldError = errors.getFieldError( fieldName );
        assertEquals( fieldName, fieldError.getField());

        // regex
        errors = initTest( form );
        form.setAlternativeEmail( ".test@domain.co.uk" );

        validator.validate( form, errors );
        fieldError = errors.getFieldError( fieldName );
        assertEquals( fieldName, fieldError.getField() );


    }


    //TODO implement test
    public void testConfirmAlternativeEmail()
    {

        EnterUserDetailsForm form = new EnterUserDetailsForm();
        Errors errors = initTest( form );

        // required

        // Same as AlternativeEmail
    }


    public void testPassword()
    {

        EnterUserDetailsForm form = new EnterUserDetailsForm();
        Errors errors = initTest( form );

       // Check that form valildates with default test values.
        errors  = initTest( form );
        validator.validate( form, errors );
        assertTrue( errors.getErrorCount() == 0 );

        String fieldName = "password";

        //required
        errors  = initTest( form );
        form.setPassword( "" );
        validator.validate( form, errors );

        FieldError fieldError = errors.getFieldError( fieldName );

        assertNotNull( fieldError );
        assertEquals(fieldName, fieldError.getField());


        //regex
        errors  = initTest( form );
        form.setPassword( "123" );
        validator.validate( form, errors );

        fieldError = errors.getFieldError( fieldName );

        assertNotNull( fieldError );
        assertEquals(fieldName, fieldError.getField() );


        errors  = initTest( form );
        form.setPassword( "12345678901234567890" );
        validator.validate( form, errors );

        fieldError = errors.getFieldError( fieldName );

        assertNotNull( fieldError );
        assertEquals(fieldName, fieldError.getField() );



    }

    // TODO implement test (and code being tested)
    public void testConfirmPassword()
    {
        EnterUserDetailsForm form = new EnterUserDetailsForm();
        Errors errors = initTest( form );

       // Check that form valildates with default test values.
        errors  = initTest( form );
        validator.validate( form, errors );
        assertTrue( errors.getErrorCount() == 0 );


        // required

        // matches password
    }

    public void testDateOfBirth()
    {

        EnterUserDetailsForm form = new EnterUserDetailsForm();
        Errors errors = initTest( form );

       // Check that form valildates with default test values.
        errors  = initTest( form );
        validator.validate( form, errors );
        assertTrue( errors.getErrorCount() == 0 );


        String fieldName = "dateOfBirth.birthDay";
        FieldError fieldError;

        // Day of birth is required
        errors  = initTest( form );

        form.getDateOfBirth().setBirthDay( "" );
        validator.validate( form, errors );
        fieldError = errors.getFieldError( fieldName );

        assertNotNull( fieldError );
        assertEquals( fieldName, fieldError.getField() );




        errors  = initTest( form );
        form.getDateOfBirth().setBirthDay( null );
        validator.validate( form, errors );
        fieldError = errors.getFieldError( fieldName );

        assertNotNull( fieldError );
        assertEquals( fieldName, fieldError.getField() );


        // Day of birth is numeric
        errors  = initTest( form );
        form.getDateOfBirth().setBirthDay( "badger" );
        validator.validate( form, errors );
        fieldError = errors.getFieldError( fieldName );

        assertNotNull( fieldError );
        assertEquals( fieldName, fieldError.getField() );



        fieldName  = "dateOfBirth.birthMonth";

        // Month of birth is required
        errors  = initTest( form );
        form.getDateOfBirth().setBirthMonth( "" );
        validator.validate( form, errors );
        fieldError = errors.getFieldError( fieldName );

        assertNotNull( fieldError );
        assertEquals( fieldName, fieldError.getField()  );


        errors  = initTest( form );
        form.getDateOfBirth().setBirthMonth( null );
        validator.validate( form, errors );
        fieldError = errors.getFieldError( fieldName );

        assertNotNull( fieldError );
        assertEquals( fieldName, fieldError.getField() );



        // Month is numeric
        errors  = initTest( form );
        form.getDateOfBirth().setBirthMonth( "wombat");
        validator.validate( form, errors );
        fieldError = errors.getFieldError( fieldName );

        assertNotNull( fieldError );
        assertEquals( fieldName, fieldError.getField() );


        // Month passes regex validation
        errors  = initTest( form );
        form.getDateOfBirth().setBirthMonth( "0123" );
        validator.validate( form, errors );
        fieldError = errors.getFieldError( fieldName );

        assertNotNull( fieldError );
        assertEquals( fieldName, fieldError.getField() );


         fieldName = "dateOfBirth.birthYear";

        // Year is required
        errors  = initTest( form );
        form.getDateOfBirth().setBirthYear( "" );
        validator.validate( form, errors );
        fieldError = errors.getFieldError( fieldName );

        assertNotNull( fieldError );
        assertEquals( fieldName, fieldError.getField() );


        errors  = initTest( form );
        form.getDateOfBirth().setBirthYear( null );
        validator.validate( form, errors );
        fieldError = errors.getFieldError( fieldName );

        assertNotNull( fieldError );
        assertEquals( fieldName, fieldError.getField() );

        // Year is numeric
        errors  = initTest( form );
        form.getDateOfBirth().setBirthYear( "bison" );
        validator.validate( form, errors );
        fieldError = errors.getFieldError( fieldName );

        assertNotNull( fieldError );
        assertEquals( fieldName, fieldError.getField() );


        // Year is passes regex validation
        errors  = initTest( form );
        form.getDateOfBirth().setBirthYear( "buffalo" );
        validator.validate( form, errors );
        fieldError = errors.getFieldError( fieldName );

        assertNotNull( fieldError );
        assertEquals( fieldName, fieldError.getField()  );


        // Date is in the past
        errors  = initTest( form );
        form.getDateOfBirth().setBirthYear( "3001" );
        validator.validate( form, errors );
        fieldError = errors.getFieldError( fieldName );

        assertNotNull( fieldError );
        assertEquals( fieldName, fieldError.getField() );


    }


    public void testForename()
    {

        EnterUserDetailsForm form = new EnterUserDetailsForm();
        Errors errors = initTest( form );

        // Check that form validates with default test values.
        errors  = initTest( form );
        validator.validate( form, errors );
        assertTrue( errors.getErrorCount() == 0 );

        String fieldName = "forename";
        FieldError fieldError;

        // required
        errors  = initTest( form );
        form.setForename( "" );
        validator.validate( form, errors );
        fieldError = errors.getFieldError( fieldName );

        assertNotNull( fieldError );
        assertEquals( fieldName, fieldError.getField() );


        errors  = initTest( form );
        form.setForename( null );
        validator.validate( form, errors );
        fieldError = errors.getFieldError( fieldName );

        assertNotNull( fieldError );
        assertEquals( fieldName, fieldError.getField());

        // regex

        errors  = initTest( form );
        form.setForename( "012346578901234657890123456789" );
        validator.validate( form, errors );
        fieldError = errors.getFieldError( fieldName );

        assertNotNull( fieldError );
        assertEquals( fieldName, fieldError.getField() );


        errors  = initTest( form );
        form.setForename( "~±" );
        validator.validate( form, errors );
        fieldError = errors.getFieldError( fieldName );

        assertNotNull( fieldError );
        assertEquals( fieldName, fieldError.getField() );

    }



    //TODO - implement gender validiation
    public void testGender()
    {

//        EnterUserDetailsForm form = new EnterUserDetailsForm();
//
//        // Check that form validates with default test values.
//        Errors errors  = initTest( form );
//        validator.validate( form, errors );
//        assertTrue( errors.getErrorCount() == 0 );
//
//        String fieldName = "gender.gender";
//        FieldError fieldError;
//
//        // required
//        errors  = initTest( form );
//        form.getGender().setGender( "" );
//        validator.validate( form, errors );
//        fieldError = errors.getFieldError( fieldName );
//
//        assertNotNull( fieldError );
//        assertEquals( fieldName, fieldError.getField() +"x" );
//
//        errors  = initTest( form );
//        form.getGender().setGender( null );
//        validator.validate( form, errors );
//        fieldError = errors.getFieldError( fieldName );
//
//        assertNull( fieldError );
//        assertEquals( fieldName, fieldError.getField() +"x" );
//
//
//
//        // is "M" or "F"
//        errors  = initTest( form );
//        form.getGender().setGender( "Badger" );
//        validator.validate( form, errors );
//        fieldError = errors.getFieldError( fieldName );
//
//        assertNull( fieldError );
//        assertEquals( fieldName, fieldError.getField() +"x" );
//
//
//        errors  = initTest( form );
//        form.getGender().setGender( "M" );
//        validator.validate( form, errors );
//        fieldError = errors.getFieldError( fieldName );
//
//        assertNotNull( fieldError );
//
//
//        errors  = initTest( form );
//        form.getGender().setGender( "m" );
//        validator.validate( form, errors );
//        fieldError = errors.getFieldError( fieldName );
//
//        assertNotNull( fieldError );
//
//
//        errors  = initTest( form );
//        form.getGender().setGender( "F" );
//        validator.validate( form, errors );
//        fieldError = errors.getFieldError( fieldName );
//
//        assertNotNull( fieldError );
//
//
//        errors  = initTest( form );
//        form.getGender().setGender( "f" );
//        validator.validate( form, errors );
//        fieldError = errors.getFieldError( fieldName );
//
//        assertNotNull( fieldError );




    }


    public void testLastName()
    {
        EnterUserDetailsForm form = new EnterUserDetailsForm();


        // Check that form validates with default test values.
        Errors errors  = initTest( form );
        validator.validate( form, errors );
        assertTrue( errors.getErrorCount() == 0 );

        String fieldName = "lastName";
        FieldError fieldError;

        // required
        errors  = initTest( form );
        form.setLastName( "" );
        validator.validate( form, errors );
        fieldError = errors.getFieldError( fieldName );

        assertNotNull( fieldError );
        assertEquals( fieldName, fieldError.getField() );


        errors  = initTest( form );
        form.setLastName( null );
        validator.validate( form, errors );
        fieldError = errors.getFieldError( fieldName );

        assertNotNull( fieldError );
        assertEquals( fieldName, fieldError.getField());

        // regex

        errors  = initTest( form );
        form.setLastName( "012346578901234657890123456789" );
        validator.validate( form, errors );
        fieldError = errors.getFieldError( fieldName );

        assertNotNull( fieldError );
        assertEquals( fieldName, fieldError.getField() );


        errors  = initTest( form );
        form.setLastName( "~±" );
        validator.validate( form, errors );
        fieldError = errors.getFieldError( fieldName );

        assertNotNull( fieldError );
        assertEquals( fieldName, fieldError.getField() );

    }


    //TODO should mobile number be valiated on enterUserDetails form?
    public void testMobileNumber()
    {

//        EnterUserDetailsForm form = new EnterUserDetailsForm();
//        Errors errors = initTest( form );
//
//        // Check that form valildates with default test values.
//        errors  = initTest( form );
//        validator.validate( form, errors );
//        assertTrue( errors.getErrorCount() == 0 );
//
//        String fieldName = "mobileNumber";
//        FieldError fieldError;
//
//        // required
//        errors  = initTest( form );
//        form.setMobileNumber( "" );
//        validator.validate( form, errors );
//        fieldError = errors.getFieldError( fieldName );
//
//        assertNull( fieldError );
//        assertEquals( fieldName, fieldError.getField() + "x" );
//
//        errors  = initTest( form );
//        form.setMobileNumber( null );
//        validator.validate( form, errors );
//        fieldError = errors.getFieldError( fieldName );
//
//        assertNull( fieldError );
//        assertEquals( fieldName, fieldError.getField() + "x" );
//
//
//
//        // regex
//        errors  = initTest( form );
//        form.setMobileNumber( "07123" );
//        validator.validate( form, errors );
//        fieldError = errors.getFieldError( fieldName );
//
//        assertNull( fieldError );
//        assertEquals( fieldName, fieldError.getField() + "x" );
//
//        errors  = initTest( form );
//        form.setMobileNumber( "09789" );
//        validator.validate( form, errors );
//        fieldError = errors.getFieldError( fieldName );
//
//        assertNull( fieldError );
//        assertEquals( fieldName, fieldError.getField() + "x" );
//
//
//        errors  = initTest( form );
//        form.setMobileNumber( "07123456789000000000000" );
//        validator.validate( form, errors );
//        fieldError = errors.getFieldError( fieldName );
//
//        assertNull( fieldError );
//        assertEquals( fieldName, fieldError.getField() + "x" );
//
//        errors  = initTest( form );
//        form.setMobileNumber( "abcdefgh" );
//        validator.validate( form, errors );
//        fieldError = errors.getFieldError( fieldName );
//
//        assertNull( fieldError );
//        assertEquals( fieldName, fieldError.getField() + "x" );


    }


    public void testSecurityAnswer()
    {

        EnterUserDetailsForm form = new EnterUserDetailsForm();
        Errors errors = initTest( form );


       // Check that form valildates with default test values.
        errors  = initTest( form );
        validator.validate( form, errors );
        assertTrue( errors.getErrorCount() == 0 );

        String fieldName = "securityAnswer";
        FieldError fieldError;

        // required

        errors  = initTest( form );
        form.setSecurityAnswer( "" );
        validator.validate( form, errors );
        fieldError = errors.getFieldError( fieldName );

        assertNotNull( fieldError );
        assertEquals( fieldName, fieldError.getField() );


        errors  = initTest( form );
        form.setSecurityAnswer( null );
        validator.validate( form, errors );
        fieldError = errors.getFieldError( fieldName );

        assertNotNull( fieldError );
        assertEquals( fieldName, fieldError.getField() );



        // regex
        errors  = initTest( form );
        form.setSecurityAnswer( "~" );
        validator.validate( form, errors );
        fieldError = errors.getFieldError( fieldName );

        assertNotNull( fieldError );
        assertEquals( fieldName, fieldError.getField()  );


        errors  = initTest( form );
        form.setSecurityAnswer( "123456789012345678901234567890123456789012345678901324567890123456789012345678901234567890" );
        validator.validate( form, errors );
        fieldError = errors.getFieldError( fieldName );

        assertNotNull( fieldError );
        assertEquals( fieldName, fieldError.getField() );



    }




    public void testSecurityQuestion()
    {

        EnterUserDetailsForm form = new EnterUserDetailsForm();
        Errors errors = initTest( form );

       // Check that form valildates with default test values.
        errors  = initTest( form );
        validator.validate( form, errors );
        assertTrue( errors.getErrorCount() == 0 );

        // required



        // regex
    }


}
