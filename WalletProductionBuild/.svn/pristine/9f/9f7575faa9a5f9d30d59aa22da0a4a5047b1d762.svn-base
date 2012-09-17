package com.o2.finance.beans.validator;

import com.o2.finance.beans.EnterMpnForm;
import junit.framework.TestCase;
import org.apache.commons.validator.EmailValidator;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

//import com.dominicsayers.isemail.IsEMail;

/**
 * Purpose:
 * com.o2.finance.beans.validator
 * User: D Smith
 * Date: 11/08/2011
 */
public class O2ValidationUtilsTest extends TestCase
{





    public void testValidateAlternativeEmail() throws Exception
    {



//        assertTrue(  EmailValidator.getInstance().isValid( "first.last@iana.org" ));

/*****
An email address must consist of a local part and a domain part separated by an @ symbol (x40) with a combined length of no more than 254 characters.
Local Part:
A non-quoted local part may consist of alpha (a-z) (A-Z) numeric (0-9) and the following characters: -_
Dots may also be present in the local part, but cannot be the first or last character, or adjacent to another dot (.)
Maximum length of the local part is 64 characters.
Domain Part:
Domain part consists of dot separated labels of 1 to 63 characters each, up to a maximum total length of 255 characters (including dot delimiters).
Domain labels must begin and end with an alpha (a-z) (A-Z) or numeric (0-9) character and may include hyphens (-). In addition, the TLD (last label) must contain at least one alpha character or hyphen (not all numeric), and be at least two characters.

*
*/




        assertFalse( O2ValidationUtils.validateEmail( ".@gmail.com" )  );
        assertTrue( O2ValidationUtils.validateEmail( "test@domain.co.uk" ));

        assertTrue( O2ValidationUtils.validateEmail( "test-@domain.co.uk" ));
        assertTrue( O2ValidationUtils.validateEmail( "test_@domain.co.uk" ));
        assertTrue( O2ValidationUtils.validateEmail( "te143214234st@domain.co.uk" ));

        assertFalse(O2ValidationUtils.validateEmail( ".test@domain.co.uk" ));
        assertFalse(O2ValidationUtils.validateEmail( "test.@domain.co.uk" ));
        assertFalse(O2ValidationUtils.validateEmail( "te..st@domain.co.uk" ));

        // local part too long -
        assertFalse( O2ValidationUtils.validateEmail( "123456489012345678901234567890123456789012345678901234567890123456789@domain.com" ) );

//Domain Part:
//Domain labels must begin and end with an alpha (a-z) (A-Z) or numeric (0-9) character and may include hyphens (-).
//In addition, the TLD (last label) must contain at least one alpha character or hyphen (not all numeric), and be at least two characters.





//Domain part consists of dot separated labels of 1 to 63 characters each, up to a maximum total length of 255 characters
//(including dot delimiters).
        assertFalse( O2ValidationUtils.validateEmail( "test@1234567890123456789012345678901234567890132456798012345678901234.co.uk" ) );
        assertFalse( O2ValidationUtils.validateEmail( "test@o2.1234567890123456789012345678901234567890132456798012345678901234.uk" ) );
        assertFalse( O2ValidationUtils.validateEmail( "test@o2.co.1234567890123456789012345678901234567890132456798012345678901234" ) );

        StringBuffer val= new StringBuffer();
        for (int i = 0; i < 63; i ++)
        {
            val.append( "x" );
        }
        String domainPart = val.toString();


        StringBuffer address = new StringBuffer( );
        address.append( "test@" ).append( domainPart );
        for (int i = 0; i < 5 ; i++)
        {
            address.append( "." ).append( domainPart );
        }




        assertFalse( O2ValidationUtils.validateEmail( address.toString() ) );

        //Domain labels must begin and end with an alpha (a-z) (A-Z) or numeric (0-9) character and may include hyphens (-).
        assertFalse(O2ValidationUtils.validateEmail("test@-o2.co.uk"));
        assertFalse(O2ValidationUtils.validateEmail("test@o2-.co.uk"));
        assertFalse(O2ValidationUtils.validateEmail("test@o2.-co.uk"));
        assertFalse(O2ValidationUtils.validateEmail("test@o2.co-.uk"));

        assertTrue(O2ValidationUtils.validateEmail( "test@o-2.co.uk" ));
        assertTrue(O2ValidationUtils.validateEmail( "test@o2.c-o.uk" ));


        //In addition, the TLD (last label) must contain at least one alpha character or hyphen (not all numeric), and be at least two characters.
        assertFalse(O2ValidationUtils.validateEmail( "test@o2.co." ));
        assertFalse(O2ValidationUtils.validateEmail( "test@o2.co.1" ));
        assertFalse(O2ValidationUtils.validateEmail( "test@o2.co.12" ));
        assertFalse(O2ValidationUtils.validateEmail( "test@o2.co.123" ));
        assertFalse(O2ValidationUtils.validateEmail( "test@o2.co.a" ));
        assertTrue(O2ValidationUtils.validateEmail( "test@o2.co.ab" ));



        assertFalse(O2ValidationUtils.validateEmail( "test@o2.co.u-k" ));
//        assertTrue(O2ValidationUtils.validateEmail("t@smart421.com"));


    }



}
