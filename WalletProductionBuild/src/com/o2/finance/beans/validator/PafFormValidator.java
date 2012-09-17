package com.o2.finance.beans.validator;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.o2.finance.beans.EnterUserDetailsForm;
import com.o2.finance.beans.UpdateUserDetailsForm;

/**
 * Purpose:
 * com.o2.finance.beans.validator
 * User: D Smith
 * Date: 24/06/2011
 */
public class PafFormValidator implements Validator
{

    Logger log = LogManager.getLogger( this.getClass() );

    public boolean supports( Class aClass )
    {
        boolean supports = false;
    	
    	if ( EnterUserDetailsForm.class.equals(aClass) ||     
        	 UpdateUserDetailsForm.class.equals(aClass) )
    	{
    		supports = true;
    	}
    	
    	return supports;
    }

    public void validate( Object o, Errors errors )
    {
        log.info( "validate start." );
        
        UpdateUserDetailsForm form = null;
        
        if ( EnterUserDetailsForm.class.isInstance(o) )
        {
        	form = (EnterUserDetailsForm) o;
        }
        else
        {
        	form = (UpdateUserDetailsForm) o;
        }

        O2ValidationUtils.validateAddress( errors, form.getAddress());


        log.info( "validate ends." );

    }
}
