/**
 *
 */
package com.o2.finance.beans.validator;

import com.o2.finance.beans.EnterOtacForm;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.o2.finance.etc.ValidationMessageConstants;
import com.o2.finance.properties.PropertyManager;

/**
 * @author SCroft / D Smith
 */
public class EnterOtacFormValidator implements Validator
{
    Logger log = LogManager.getLogger( this.getClass() );

    /**
     * Names the class that can be validated, called first
     */
    public boolean supports( Class aClass )
    {
        return EnterOtacForm.class.equals( aClass );
    }

    /**
     * Receives the object to be validated. Casts it to the class.
     */
    public void validate( Object o, Errors errors )
    {
        log.info( "validate start." );

        EnterOtacForm form = (EnterOtacForm) o;
        String otac = form.getVerificationCode();

        // otac is not empty
        ValidationUtils.rejectIfEmptyOrWhitespace( errors, "verificationCode", ValidationMessageConstants.ENTER_OTAC_MISSING );

        if (!errors.hasFieldErrors( "verificationCode" ))
        {
            	
        	// validate against regex
            if (!otac.matches( PropertyManager.getValidatorRegexProperties().getOtacRegex() ))
            {
            	boolean containsALetter = false;
            	for ( int i = 0 ; i < otac.length(); i++  )
                {
                	if ( !Character.isDigit( otac.charAt( i ) ) )
                	{
                		containsALetter = true;
                		break;
                	}
                }
            	
            	if ( containsALetter )
            	{
            		errors.rejectValue( "verificationCode", ValidationMessageConstants.ENTER_OTAC_INVALID_CONTAINS_A_NUMBER );
            	}
            	else
            	{
            		errors.rejectValue( "verificationCode", ValidationMessageConstants.ENTER_OTAC_INVALID_VERIFICATION_CODE );
            	}
            }
        }

        log.info( "validate ends." );
    }
}