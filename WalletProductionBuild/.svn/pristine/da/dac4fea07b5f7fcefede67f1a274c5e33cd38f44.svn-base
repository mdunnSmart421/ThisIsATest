package com.o2.finance.beans.validator;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.o2.finance.beans.AddressBean;
import com.o2.finance.beans.DateOfBirthBean;
import com.o2.finance.beans.UpdateUserDetailsForm;
import com.o2.finance.etc.RequestParameterConstants;

/**
 * @author SCroft
 * 
 */
public class UpdateUserDetailsFormValidator implements Validator, RequestParameterConstants
{
    private Logger log = LogManager.getLogger(this.getClass());
    private Errors errors;
    private PafFormValidator pafValidator;

    public UpdateUserDetailsFormValidator()
    {
    }

    /**
     * Names the class that can be validated, called first
     */
    public boolean supports(Class aClass)
    {
        return UpdateUserDetailsForm.class.equals(aClass);
    }

    /**
     * Receives the object to be validated. Casts it to the class.
     * 
     */
    public void validate(Object o, Errors errors)
    {
        log.info( "validate update user details start." );

        log.info( "Validating form " + o.getClass().getName() );

        this.errors = errors;

        // Items to validate
        UpdateUserDetailsForm form = (UpdateUserDetailsForm) o;
        
        if (PAF_LOOKUP_BUTTON.equals(form.getActivatedButton()))
        {
        	pafValidator.validate( form, errors );
        }
        else if (CONTINUE_UPDATE.equals(form.getActivatedButton()))
        {
        	DateOfBirthBean dateOfBirth = form.getDateOfBirth();
            AddressBean address = form.getAddress();
            
            O2ValidationUtils.validateTitle( errors, form.getTitle() );
            
            O2ValidationUtils.validateForename( errors, form.getForename() );

            O2ValidationUtils.validateLastName( errors, form.getLastName() );

            O2ValidationUtils.validateGender( errors, form.getGender() );

            O2ValidationUtils.validateDateOfBirth( errors, dateOfBirth );

            O2ValidationUtils.validateAddress( errors, address );

            O2ValidationUtils.validateMobileMake(errors, form.getMobileMake());

            O2ValidationUtils.validateAlternativeEmail( errors, form.getAlternativeEmail() );
        }
        else if (CONTINUE_CONFIRM.equals(form.getActivatedButton()))
        {
        	/*
             * The page is submitted from the confirmDetailsPage, do not
             * perform any validation as there are no user editable fields.
             */
        }

        log.info( "validate update user details ends." );

    }

    /**
     * @return the errors
     */
    public Errors getErrors()
    {
        return errors;
    }

	public void setPafValidator(PafFormValidator pafValidator) {
		this.pafValidator = pafValidator;
	}
}
