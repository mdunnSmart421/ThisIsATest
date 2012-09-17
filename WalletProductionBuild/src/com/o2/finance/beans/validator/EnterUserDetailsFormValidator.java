/**
 *
 */
package com.o2.finance.beans.validator;

import java.util.Iterator;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;

import com.o2.finance.beans.EnterUserDetailsForm;
import com.o2.finance.etc.RequestParameterConstants;

/**
 * @author SCroft
 */
public class EnterUserDetailsFormValidator implements Validator, RequestParameterConstants
{
    Logger log = LogManager.getLogger( this.getClass() );
    
    private PafFormValidator pafValidator;
    
    /**
     * Names the class that can be validated, called first
     */
    public boolean supports( Class aClass )
    {
        return EnterUserDetailsForm.class.equals( aClass );
    }

    /**
     * Receives the object to be validated. Casts it to the class.
     */
    public void validate( Object o, Errors errors )
    {
        log.info( "validate start." );

        EnterUserDetailsForm form = (EnterUserDetailsForm) o;
        
        if (PAF_LOOKUP_BUTTON.equals(form.getActivatedButton()))
        {
        	// the PAF lookup button was activated on the page, validate
        	// PAF fields only
        	pafValidator.validate( form, errors );
        }
        else
        {
        	O2ValidationUtils.validateTitle( errors, form.getTitle() );
        	
        	O2ValidationUtils.validateForename( errors, form.getForename() );

            O2ValidationUtils.validateLastName( errors, form.getLastName() );

            O2ValidationUtils.validateAddress( errors, form.getAddress() );

            O2ValidationUtils.validateDateOfBirth( errors, form.getDateOfBirth() );

            O2ValidationUtils.validateMobileMake(errors, form.getMobileMake());

            O2ValidationUtils.validateAlternativeEmail( errors, form.getAlternativeEmail() );

            O2ValidationUtils.validateConfirmEmail( errors, form.getConfirmAlternativeEmail(), form.getAlternativeEmail() );

            O2ValidationUtils.validatePassword( errors, form.getPassword() );

            O2ValidationUtils.validateConfirmPassword( errors, form.getConfirmPassword(), form.getPassword());

            O2ValidationUtils.validateUsername( errors, form.getUsername() );

            O2ValidationUtils.validateSecurityQuestion( errors, form.getSecurityQuestion() );

            O2ValidationUtils.validateSecurityAnswer( errors, form.getSecurityAnswer() );

            O2ValidationUtils.validateGender( errors, form.getGender() );

            Iterator it = errors.getFieldErrors().iterator();
            while (it.hasNext())
            {
                FieldError error  =  ( FieldError ) it.next();
                log.debug( "Validation error " + error.getCode() + " field: "  + error.getField() );
            }

        }

        
        log.info( "validate ends." );

    }

	public void setPafValidator(PafFormValidator pafValidator) {
		this.pafValidator = pafValidator;
	}


}
