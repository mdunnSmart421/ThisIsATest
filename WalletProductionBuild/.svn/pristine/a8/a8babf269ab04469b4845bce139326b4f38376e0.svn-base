/**
 * 
 */
package com.o2.finance.beans.validator;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.o2.finance.beans.ChooseAccountForm;

/**
 * @author SCroft
 * 
 */
public class DisplayAssociatedAccountsFormValidator implements Validator
{
    Logger log = LogManager.getLogger(this.getClass());

    /**
     * Names the class that can be validated, called first
     */
    public boolean supports(Class aClass)
    {
        return ChooseAccountForm.class.equals(aClass);
    }

    /**
     * Receives the object to be validated. Casts it to the class.
     * 
     */
    public void validate(Object o, Errors errors)
    {


        //TODO Why is this validator not implemented?

        log.debug("Validating form " + o.getClass().getName());
        // ChooseAccountForm form = (ChooseAccountForm) o;
        // TODO third param is ref to message in prop file/resource bundle
        // the path maps to the 2nd argument in the validation method
        // ValidationUtils.rejectIfEmptyOrWhitespace( errors, field/input path, message which references a string in a resource
        // bundle );
        // Error message is defined in ValidationConstants, that is mapped in the <bean id="messageSource"
        // class="org.springframework.context.support.ResourceBundleMessageSource">
        // ValidationUtils.rejectIfEmptyOrWhitespace( errors, "msisdn", ValidationConstants.MSISDN_REQUIRED );
    }
}
