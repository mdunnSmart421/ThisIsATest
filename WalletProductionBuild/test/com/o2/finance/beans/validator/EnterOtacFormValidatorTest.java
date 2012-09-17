/**
 * 
 */
package com.o2.finance.beans.validator;

import junit.framework.TestCase;

import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import com.o2.finance.beans.EnterOtacForm;
import com.o2.finance.util.TestSetup;

/**
 * @author SCroft
 * 
 */
public class EnterOtacFormValidatorTest extends TestCase
{
    private EnterOtacFormValidator validator;
    private EnterOtacForm form;
    private Errors errors;
    private String testStr;

    /**
     * Test setUp
     */
    public void setUp() throws Exception
    {
        super.setUp();
        TestSetup.initialiseLog4j();
        validator = new EnterOtacFormValidator();
        form = new EnterOtacForm();
        errors = new BeanPropertyBindingResult(form, EnterOtacForm.class.getName());
        testStr = "testname";
    }

    /**
     * Test accessors with no errors
     */
    public void testOtacFieldDefaultNull()
    {
        validator.validate(form, errors);
        assertTrue(errors.hasErrors()); // cannot be null
    }

    /**
     * Test field cannot be left empty
     */
    public void testCannotBeEmpty()
    {
        form.setVerificationCode("");
        validator.validate(form, errors);
        assertTrue(errors.hasErrors());
    }

    /**
     * Positive test with valid otac string
     */
    public void testValidStringPositiveTest()
    {
        form.setVerificationCode("123456");
        validator.validate(form, errors);
        assertTrue(!errors.hasErrors());
    }

    /**
     * Negative regex test with invalid string
     */
    public void testInvalidStringPositiveTest()
    {
        form.setVerificationCode(testStr);
        validator.validate(form, errors);
        assertTrue(errors.hasErrors());
    }

    /*
    OTAC too long
     */
    public void testOtacTooLong()
    {
        form.setVerificationCode("123456789");
        validator.validate(form, errors);
        assertTrue(errors.hasErrors());
    }



    /**
     * A null otac should generate an error
     */
    public void testNullOtac()
    {
        assertTrue(!errors.hasErrors());
        form.setVerificationCode(null);
        validator.validate(form, errors);
        assertTrue(errors.hasErrors());
    }

    /**
     * Test5DigitOtac error generated
     */
    public void test5DigitOtac()
    {
        assertTrue(errors.getFieldErrorCount("verification") == 0);
        form.setVerificationCode("12345");
        validator.validate(form, errors);
        assertTrue(errors.getFieldErrorCount("verificationCode") == 1);
    }

    /**
     * Test7DigitOtac error generated
     */
    public void test7DigitOtac()
    {
        assertTrue(errors.getFieldErrorCount("verification") == 0);
        form.setVerificationCode("1234567");
        validator.validate(form, errors);
        assertTrue(errors.getFieldErrorCount("verificationCode") == 1);
    }

    /**
     * test6DigitOtacWithLetter error generated
     */
    public void test6DigitOtacWithLetter()
    {
        assertTrue(errors.getFieldErrorCount("verification") == 0);
        form.setVerificationCode("12345e");
        validator.validate(form, errors);
        assertTrue(errors.getFieldErrorCount("verificationCode") == 1);
    }
}
