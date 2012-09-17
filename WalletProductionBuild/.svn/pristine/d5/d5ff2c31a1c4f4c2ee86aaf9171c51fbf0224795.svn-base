/**
 * 
 */
package com.o2.finance.beans.validator;

import junit.framework.Assert;

import org.mockito.MockitoTestCase;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import com.o2.finance.beans.EnterMpnForm;
import com.o2.finance.util.TestSetup;

/**
 * @author SCroft / D Smith Test class for EnterMpnFormValidator
 */
public class EnterMpnFormValidatorTest extends MockitoTestCase
{
    private EnterMpnFormValidator validator;
    private EnterMpnForm form;

    public void setUp() throws Exception
    {
        super.setUp();
        TestSetup.initialiseLog4j();
        validator = new EnterMpnFormValidator();
        form = new EnterMpnForm();
    }

    /**
     * Submit form with a null msisdn
     * 
     * @throws Exception
     */
    public void testNullMsisdn() throws Exception
    {
        Errors errors = new BeanPropertyBindingResult(form, EnterMpnForm.class.getName());
        form.setMsisdn(null);
        validator.validate(form, errors);
        assertTrue(errors.hasFieldErrors("msisdn"));
        assertTrue(errors.getErrorCount() == 1);
    }

    /**
     * Msisdn is a string, submit a word as msisdn
     */
    public void testValidateInvalidMsisdn()
    {
        Errors errors = new BeanPropertyBindingResult(form, EnterMpnForm.class.getName());
        // msidn should match regex
        form.setMsisdn("testmsisdn");
        validator.validate(form, errors);
        // expect fail
        Assert.assertTrue(errors.hasFieldErrors("msisdn"));
        // expect no other errors
        Assert.assertTrue(errors.getErrorCount() == 1);
    }

    /**
     * Test: Submit a valid msisdn
     */
    public void testValidMsisdn()
    {
        Errors errors = new BeanPropertyBindingResult(form, EnterMpnForm.class.getName());
        // Msisdn is correct
        form.setMsisdn("07345678901");
        validator.validate(form, errors);
        // There should be no field errors for msisdn
        assertFalse(errors.hasFieldErrors("msisdn"));
        // There should be no other errors
        assertTrue(errors.getErrorCount() == 0);
    }

    /**
     * Submit a msisdn with too many digits
     * 
     * @throws Exception
     */
    public void testLargeMsisdn() throws Exception
    {
        Errors errors = new BeanPropertyBindingResult(form, EnterMpnForm.class.getName());
        form.setMsisdn("07345678901123456789");
        validator.validate(form, errors);

        // There should be errors for msisdn as it is too large
        assertTrue(errors.hasFieldErrors("msisdn"));
        // There should only be one error
        assertTrue(errors.getErrorCount() == 1);
    }





    /**
     * Submit a msisdn with too few numbers
     * 
     * @throws Exception
     */
    public void testSmallMsisdn() throws Exception
    {
        Errors errors = new BeanPropertyBindingResult(form, EnterMpnForm.class.getName());
        form.setMsisdn("073");
        validator.validate(form, errors);
        // There should be errors for msisdn as it is too large
        assertTrue(errors.hasFieldErrors("msisdn"));
        // There should only be one error
        assertTrue(errors.getErrorCount() == 1);
    }

    /**
     * Test a msisdn that starting without 07 is rejected
     * 
     * @throws Exception
     */
    public void testMsisdnStartsIncorrectly() throws Exception
    {
        Errors errors = new BeanPropertyBindingResult(form, EnterMpnForm.class.getName());
        form.setMsisdn("70123456789");
        validator.validate(form, errors);
        // There should be errors for msisdn that does not start with 07
        assertTrue(errors.hasFieldErrors("msisdn"));
        // There should only be one error
        assertTrue(errors.getErrorCount() == 1);
    }
}
