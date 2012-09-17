/**
 * 
 */
package com.o2.finance.beans.validator;

import com.o2.finance.beans.AddressBean;
import com.o2.finance.beans.DateOfBirthBean;
import com.o2.finance.beans.GenderBean;
import com.o2.finance.etc.ValidationMessageConstants;
import com.o2.finance.properties.PropertyManager;
import com.o2.finance.properties.ValidationRegexProperties;
import org.apache.commons.validator.EmailValidator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * @author SCroft Class to validate fields
 * D Smith 26 June 11 - refactored to static methods only
 */
public class O2ValidationUtils implements ValidationMessageConstants
{
    private static Logger log = LogManager.getLogger(O2ValidationUtils.class);

    private static ValidationRegexProperties regexProperties =  PropertyManager.getValidatorRegexProperties();

    private O2ValidationUtils()
    {
        // Hidden constructor (only static methods)
    }

    public static void validateGender( Errors errors, GenderBean gender  )
    {
        log.info( "validateGender start." );

        String fieldName = "gender.gender";

        // Gender is required
        ValidationUtils.rejectIfEmptyOrWhitespace( errors, fieldName, GENDER_INVALID );

        if ( errors.getFieldErrorCount( fieldName ) == 0)
        {
            // TODO - is gender case sensitive?
            if  (! (gender.getGender().equalsIgnoreCase("m") || gender.getGender().equalsIgnoreCase("f")))
            {
                errors.rejectValue("gender.gender", GENDER_INVALID);
            }
        }

        log.info( "validateGender ends." );

    }




    public static void validateUsername( Errors errors, String username )
    {
        log.info( "validateUsername start." );

        String fieldName = "username";

        // required
        ValidationUtils.rejectIfEmptyOrWhitespace( errors, fieldName, USERNAME_REQUIRED );

        // regex
        if ( errors.getFieldErrorCount( fieldName) == 0)
        {
            validateRegularExpression( errors, fieldName, username, regexProperties.getUsernameRegex(),
                    USERNAME_INVALID );
        }

        log.info( "validateUsername ends." );
    }

    public static void validatePassword( Errors errors, String password)
    {

        log.info( "validatePassword start." );

        String fieldName = "password";

        // required
        ValidationUtils.rejectIfEmptyOrWhitespace( errors, fieldName,  PASSWORD_REQUIRED );


        // regex
        if ( errors.getFieldErrorCount( fieldName) == 0)
        {
            validateRegularExpression( errors, fieldName, password, regexProperties.getPasswordRegex(),
                    PASSWORD_INVALID);
        }

        log.info( "validatePassword ends." );
    }


    public static void validateConfirmPassword( Errors errors, String confirmPassword, String password)
    {
        log.info( "validateConfirmPassword start." );
        // required
        String fieldName = "confirmPassword";

        ValidationUtils.rejectIfEmptyOrWhitespace( errors, fieldName, PASSWORD_MISMATCH );

        // matches password
        if (errors.getFieldErrorCount( fieldName ) == 0)
        {
            if ( ! confirmPassword.equals( password ))
            {
                errors.rejectValue( fieldName, PASSWORD_MISMATCH );
            }
        }

        log.info( "validateConfirmPassword ends." );

    }


    public static void validateConfirmEmail( Errors errors, String confirmEmail, String alternativeEmail )
    {
        log.info( "validateConfirmEmail start." );


        String fieldName = "confirmAlternativeEmail";

        // required
        ValidationUtils.rejectIfEmptyOrWhitespace( errors, fieldName, EMAIL_CONFIRM );

        if ( errors.getFieldErrorCount( fieldName ) == 0)
        {
            if (! confirmEmail.equals( alternativeEmail ) )
            {
                log.debug( "Email and confirm email do not match." );
                //email_mismatch
                errors.rejectValue( fieldName, EMAIL_MISMATCH );
            }
        }

        // matches alternativeEmail

        log.info( "validateConfirmEmail ends." );

    }


    public static void validateSecurityQuestion( Errors errors, String securityQuestion )
    {
        log.info( "validateSecurityQuestion start." );

        String fieldName = "securityQuestion";

        // required
        ValidationUtils.rejectIfEmptyOrWhitespace( errors, fieldName, securityQuestion,
                SECURITY_QUESTION_MISSING );

        // regex
        if ( errors.getFieldErrorCount( fieldName ) == 0)
        {
            validateRegularExpression( errors, fieldName, securityQuestion,
                    regexProperties.getSecurityQuestionRegex(), SECURITY_QUESTION_MISSING);
        }

        log.info( "validateSecurityQuestion ends." );

    }

    public static void validateSecurityAnswer( Errors errors, String securityAnswer )
    {
        log.info( "validateSecurityAnswer start." );

        String fieldName = "securityAnswer";

        // required
        ValidationUtils.rejectIfEmptyOrWhitespace( errors, fieldName, SECURITY_ANSWER_MISSING);

        // regex
        if ( errors.getFieldErrorCount( fieldName ) == 0  )
        {
            validateRegularExpression( errors, fieldName, securityAnswer,
                    regexProperties.getSecurityAnswerRegex(), SECURITY_ANSWER_INVALID);
        }

        log.info( "validateSecurityAnswer ends." );
    }


    public static void validateAlternativeEmail( Errors errors, String email )
    {
        log.info( "validateAlternativeEmail start." );

        String fieldName = "alternativeEmail";
        // required
        ValidationUtils.rejectIfEmptyOrWhitespace( errors, fieldName, EMAIL_ADDRESS_INVALID );

        if (errors.getFieldErrorCount( fieldName ) == 0)
        {

            boolean valid = validateEmail( email );
            // external validator
//            boolean valid = EmailValidator.getInstance().isValid( email );

            if (!valid)
            {
                errors.rejectValue( fieldName, EMAIL_ADDRESS_INVALID );
            }

        }

        log.info( "validateAlternativeEmail ends." );
    }



    /**
     * Check that date a valid date and is in the past.
     * Also check that the date is not more than 100 years in the past
     *
     * @param errors
     * @param dateOfBirth
     */
    private static void validateDate( Errors errors, DateOfBirthBean dateOfBirth )
    {

        log.info( "validateDate start." );

        String dayPart = dateOfBirth.getBirthDay();
        String monthPart = dateOfBirth.getBirthMonth();
        String yearPart = dateOfBirth.getBirthYear();


        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setLenient( false );

        try
        {
            calendar.set( Integer.parseInt( yearPart ), Integer.parseInt( monthPart ) -1, Integer.parseInt( dayPart ) );

            Date date = calendar.getTime();
            if (!date.before( new Date() ))
            {
                errors.rejectValue( "dateOfBirth.birthYear", INVALID_DATE );
            }
            
            //Additional check to make sure date is not more than configurable number of years in the past  
            //This is no longer required as this check is only to be done in the LegacyDataValidationController class
            //which will reset the users DOB to the default values of DD MM YYYY if they meet this check.
//            Date legacyYearsInPastConfiguableDate = new Date();	     		        		        
//            legacyYearsInPastConfiguableDate.setYear(legacyYearsInPastConfiguableDate.getYear() - regexProperties.getLegacyYearsInPast());	        	        
//            if (date.before(legacyYearsInPastConfiguableDate)) 
//            {
//            	errors.rejectValue( "dateOfBirth.birthYear", INVALID_DATE_OF_BIRTH );            	
//            }
                        
        }
        catch (NumberFormatException e)
        {
            errors.rejectValue( "dateOfBirth.birthYear", CHECK_DATE_OF_BIRTH );
        }
        catch ( IllegalArgumentException e )
        {
            log.info( "Illegal date entered: " + (dateOfBirth != null ? dateOfBirth.toString() : "") );
            errors.rejectValue( "dateOfBirth.birthYear", CHECK_DATE_OF_BIRTH );
        }

        log.info( "validateDate ends." );
    }





    public static void validateDateOfBirth( Errors errors, DateOfBirthBean dateOfBirth )
    {

        log.info( "validateDateOfBirth start." );


        boolean continueValidation = true;


        // Day of birth validation
        String dayFieldName = "dateOfBirth.birthDay";


        if ( null == dateOfBirth.getBirthDay() )
        {
            errors.rejectValue( dayFieldName, ENTER_DATE_OF_BIRTH );
            continueValidation = (errors.getFieldErrorCount( dayFieldName ) == 0);
        }


        // Day of birth is required
        if ( continueValidation )
        {
            ValidationUtils.rejectIfEmptyOrWhitespace( errors, dayFieldName, ENTER_DATE_OF_BIRTH );
             continueValidation = ( errors.getFieldErrorCount( dayFieldName ) == 0 );
        }


        // Day of birth is numeric
        if ( continueValidation )
        {
            validateRegularExpression( errors, dayFieldName, dateOfBirth.getBirthDay(), regexProperties.getNumberRegex(), CHECK_DATE_OF_BIRTH );
            continueValidation = ( errors.getFieldErrorCount( dayFieldName ) == 0 );
        }





        // Month of birth validation
        String monthFieldName = "dateOfBirth.birthMonth";

        if ( null == dateOfBirth.getBirthMonth() )
        {
            errors.rejectValue( dayFieldName, ENTER_DATE_OF_BIRTH );
            continueValidation = (errors.getFieldErrorCount( dayFieldName ) == 0);
        }


        // Month of birth is required
        if ( continueValidation )
        {
            ValidationUtils.rejectIfEmptyOrWhitespace( errors, monthFieldName, ENTER_DATE_OF_BIRTH );
            continueValidation = (errors.getFieldErrorCount( monthFieldName ) == 0);
        }

        // Month of birth is numeric
        if ( continueValidation )
        {
            validateRegularExpression( errors, monthFieldName, dateOfBirth.getBirthMonth(), regexProperties.getNumberRegex(), CHECK_DATE_OF_BIRTH );
            continueValidation = ( errors.getFieldErrorCount( monthFieldName ) == 0 );
        }


        // Month of birth matches regular expression
        if ( continueValidation )
        {
            validateRegularExpression( errors, monthFieldName, dateOfBirth.getBirthMonth(), regexProperties.getBirthMonthRegex() , INVALID_MONTH );
            continueValidation = ( errors.getFieldErrorCount( monthFieldName ) == 0 );
        }


        // Year of birth validation
        String yearFieldName = "dateOfBirth.birthYear";


        if ( null == dateOfBirth.getBirthYear() )
        {
            errors.rejectValue( dayFieldName, ENTER_DATE_OF_BIRTH );
            continueValidation = (errors.getFieldErrorCount( dayFieldName ) == 0);
        }

        // Year of birth is required
        if ( continueValidation )
        {
            ValidationUtils.rejectIfEmptyOrWhitespace( errors, yearFieldName, ENTER_DATE_OF_BIRTH );
            continueValidation = ( errors.getFieldErrorCount( yearFieldName ) == 0 );
        }



        // Year of birth is numeric
        if ( continueValidation )
        {
            validateRegularExpression( errors, yearFieldName, dateOfBirth.getBirthYear(), regexProperties.getNumberRegex(), CHECK_DATE_OF_BIRTH );
            continueValidation = ( errors.getFieldErrorCount( yearFieldName ) == 0 );
        }


        // Year of birth matches regular expression
        if ( continueValidation )
        {
            validateRegularExpression( errors, yearFieldName, dateOfBirth.getBirthYear(), regexProperties.getBirthYearRegex(), INVALID_YEAR );
            continueValidation = ( errors.getFieldErrorCount( yearFieldName ) == 0 );
        }


        // DateOfBirth is in the past
        if ( continueValidation )
        {
            validateDate( errors, dateOfBirth );
        }


        log.info( "validateDateOfBirth ends." );
    }




    /**
     * Validate field with regular expression.
     * @param errors
     * @param fieldName
     * @param fieldValue
     * @param regEx
     * @param errorCode
     */
    private static void validateRegularExpression( Errors errors, String fieldName, String fieldValue, String regEx, String errorCode )
    {
        if (null != fieldValue && !"".equalsIgnoreCase( fieldValue ))
        {
            if (!fieldValue.matches( regEx ))
            {
                errors.rejectValue( fieldName, errorCode );
            }
        }
    }


    /**
     * Validate the address bean
     *
     * @param address
     */
    public static void validateAddress(Errors errors,  AddressBean address)
    {
        log.info( "validateAddress start." );



        // fields to validate
        String houseNumberValue = address.getHouseNumber();
        String houseNumberFieldName = "address.houseNumber";

        String houseNameValue = address.getHouseName();
        String houseNameFieldName = "address.houseName";

        String postCode = address.getPostcode();
        String postCodeFieldName = "address.postcode";






        // Postcode must be present
        ValidationUtils.rejectIfEmptyOrWhitespace( errors, postCodeFieldName, POSTCODE_MISSING );

        if ( errors.getFieldErrorCount( postCodeFieldName) == 0)
        {
            // Postcode must match regular expression
            validateRegularExpression( errors, postCodeFieldName, postCode, regexProperties.getPostCodeRegex(), POSTCODE_INVALID );
        }

        // Either houseNumber and/or houseName required.
        boolean houseNumberPresent = ! ( null == address.getHouseNumber() || "".equalsIgnoreCase( address.getHouseNumber() ) );
        boolean houseNamePresent = ! ( null == address.getHouseName() || "".equalsIgnoreCase( address.getHouseName() ));

        if (! (  houseNumberPresent || houseNamePresent ) )
        {
            errors.rejectValue( houseNumberFieldName, HOUSE_NAME_AND_NUMBER_MISSING );
        }


        // if present, house number must be numeric
        if ( ( errors.getFieldErrorCount( houseNumberFieldName ) == 0  ) && ( houseNumberPresent )  )
        {
                validateRegularExpression(errors, houseNumberFieldName, houseNumberValue, regexProperties.getNumberRegex(),
                     HOUSE_NUMBER_INVALID );
        }


        // if present, house name must validate against regex
        if ( (errors.getFieldErrorCount( houseNumberFieldName ) == 0) && ( houseNamePresent ) )
        {
                validateRegularExpression( errors, houseNameFieldName, houseNameValue, regexProperties.getHouseNameRegex(),
                        HOUSE_NAME_INVALID );
        }


                // If housenumber is present, if cannot be more than 5 characters long
        if ( (errors.getFieldErrorCount( houseNumberFieldName ) == 0) && ( houseNamePresent ) )
        {
            if (houseNumberValue.length() > 5)
            {
                errors.rejectValue( houseNumberFieldName, HOUSE_NUMBER_INVALID );
            }
        }


        log.info( "validateAddress ends." );

    }


    public static void validateTitle( Errors errors, String title )
    {
        log.info( "validateTitle start." );

        String fieldName = "title";

        // title is required
        ValidationUtils.rejectIfEmptyOrWhitespace( errors, fieldName, TITLE_INVALID );

        if ( errors.getFieldErrorCount( fieldName) == 0)
        {
            // validate against regex
            validateRegularExpression( errors, fieldName, title, regexProperties.getFirstNameRegex(), TITLE_INVALID  );
        }

        log.info( "validateTitle ends." );
    }

    
    public static void validateForename( Errors errors, String forename )
    {
        log.info( "validateForename start." );

        String fieldName = "forename";

        // forename is required
        ValidationUtils.rejectIfEmptyOrWhitespace( errors, fieldName, FORENAME_INVALID );

        if ( errors.getFieldErrorCount( fieldName) == 0)
        {
            // validate against regex
            validateRegularExpression( errors, fieldName, forename, regexProperties.getFirstNameRegex(), FORENAME_INVALID  );
        }

        log.info( "validateForename ends." );
    }


    public static void validateLastName( Errors errors, String lastName )
    {

        log.info( "validateLastName start." );

        String fieldName = "lastName";

        // forename is required
        ValidationUtils.rejectIfEmptyOrWhitespace( errors, fieldName, LASTNAME_INVALID );

        if ( errors.getFieldErrorCount( fieldName) == 0)
        {
            // validate against regex
            validateRegularExpression( errors, fieldName, lastName, regexProperties.getLastNameRegex(), LASTNAME_INVALID  );
        }

        log.info( "validateLastName ends." );
    }


    public static void validateMobileMake( Errors errors, String mobileMake )
    {
        log.info( "validateMobileMake start." );

        String fieldName = "mobileMake";

        // required
        ValidationUtils.rejectIfEmptyOrWhitespace( errors, fieldName, MOBILE_MAKE_INVALID );

        // regex
        if ( errors.getFieldErrorCount( fieldName) == 0 )
        {
            validateRegularExpression( errors, fieldName, mobileMake,
                    regexProperties.getMobileMakeRegex(), MOBILE_MAKE_INVALID);
        }

        log.info( "validateMobileMake ends." );
    }


    public static void validateMsisdn( Errors errors, String msisdn, String path)
    {
        log.info( "validateMsisdn start." );

//        String fieldName = "mobileNumber";

        // required
        ValidationUtils.rejectIfEmptyOrWhitespace( errors, path, MSISDN_REQUIRED );

        // regex
        if ( errors.getFieldErrorCount( path ) == 0 )
        {
            validateRegularExpression( errors, path, msisdn,
                    regexProperties.getMsisdnRegex(), MSISDN_INVALID);
        }

        log.info( "validateMsisdn ends." );

    }





    public static boolean validateEmail( String email )
    {
        boolean result = EmailValidator.getInstance().isValid( email );

        // perform additional validation;


        if ( result )
        {
            // local part shall not be more than 64 chars long
            int index = email.lastIndexOf( "@" );
            String localPart = email.substring( 0, index   );

            result = localPart.length() < 65;

        }

        int index = email.lastIndexOf( "@" );
        String domainPart = email.substring( index + 1);

        if ( result )
        {
            //Domain part consists of dot separated labels of 1 to 63 characters each...

            String[] dotArray = domainPart.split( "[.]" );

            for (int i=0; i < dotArray.length; i++)
            {
                if ( dotArray[i].length() > 63 )
                {
                    result = false;
                    break;
                }


                // Domain labels must begin and end with an alpha (a-z) (A-Z) or numeric (0-9)
                // character and may include hyphens (-).

                char initialCharacter = dotArray[i].charAt( 0 );
                char finalCharacter = dotArray[i].charAt( dotArray[i].length() -1 );

                if (! isAlphaNumeric( initialCharacter ) || ! isAlphaNumeric( finalCharacter ))
                {
                    result = false;
                }

            }

        }

        if ( result )
        {
            // ... up to a maximum total length of 255 characters (including dot delimiters).
            result = ( domainPart.length() < 256 );

        }



        return result;

    }


    private static boolean isAlpha( char character )
    {
        return character >= 'a' && character <= 'z' || character >= 'A' && character <= 'Z';
    }


    private static boolean  isNumeric( char character )
    {
        return character >= '0' && character <= '9';


    }



    private static boolean isAlphaNumeric( char character)
    {
        return isNumeric( character ) || isAlpha( character );

    }





}
