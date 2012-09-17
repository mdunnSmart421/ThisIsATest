package com.o2.finance.beans.validator;

import com.o2.finance.beans.EnterMpnForm;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Purpose: com.o2.finance.beans.validator User: D Smith Date: 22/05/2011
 * 
 * Process. Add a input to the jsp page Declare it in the backing bean which is mapped in the xml as CommandClass validate it
 * using the path field from the form
 */
public class EnterMpnFormValidator implements Validator
{
    private Logger log = LogManager.getLogger(this.getClass());

    /**
     * Names the class that can be validated, called first
     */
    public boolean supports(Class aClass)
    {
        return EnterMpnForm.class.equals(aClass);
    }

    /**
     * Receives the object to be validated.
     * 
     */
    public void validate(Object o, Errors errors)
    {
        log.info( "validate start." );

        EnterMpnForm form = (EnterMpnForm) o;

        O2ValidationUtils.validateMsisdn( errors, form.getMsisdn(), "msisdn" );

        log.info( "validate ends." );
    }
}
