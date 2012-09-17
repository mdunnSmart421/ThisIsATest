package com.o2.finance.beans.validator;

import com.o2.finance.beans.EnterMpnForm;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Purpose:
 * com.o2.finance.beans.validator
 * User: D Smith
 * Date: 04/07/2011
 */
public class ExistingMpnFormValidator implements Validator
{

    Logger log = LogManager.getLogger( this.getClass() );

    public boolean supports( Class aClass )
    {
        return EnterMpnForm.class.equals(aClass);
    }

    public void validate( Object o, Errors errors )
    {

        log.info( "validate start." );

        EnterMpnForm form = (EnterMpnForm) o;

        O2ValidationUtils.validateMsisdn( errors, form.getNewMsisdn(), "newMsisdn" );

        log.info( "validate ends." );

    }
}
