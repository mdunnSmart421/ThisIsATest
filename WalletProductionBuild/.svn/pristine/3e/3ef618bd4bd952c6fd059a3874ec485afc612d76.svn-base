package com.o2.finance.facade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.o2.finance.properties.PropertyManager;
import org.mockito.MockitoTestCase;

import com.o2.finance.model.UserTO;
import com.o2.finance.util.TestSetup;

/**
 * Purpose: com.o2.finance.service User: Date:
 */
public class FinanceFacadeTest extends MockitoTestCase
{
    public void setUp() throws Exception
    {
        TestSetup.initialiseLog4j();
    }

    public void testUpdateUser() throws Exception
    {
        FinanceFacade facade = new FinanceFacade();
        UserTO user = new UserTO();
        user.setDomain("ref.o2.co.uk");
        user.setMsisdn(generateRandomMsisdn());
        user.setId("test_" + generateRandomMsisdn());
        user.setForename("Test Finance");
        user.setLastname("Junit");
        user.setPassword("password");
        user.setSecurityQuestion("password");
        user.setSecurityAnswer("password");
        UserTO newUser = facade.createUser(user);
        assertNotNull(newUser.getCustomerNumber());
        // Update user
        UserTO updateUser = new UserTO();
        updateUser.setDomain(newUser.getDomain());
        updateUser.setId(newUser.getId());
        // Update Company Name
        updateUser.setCompanyName("Smart421");
        updateUser.setAccountManagerEmail("test@smart421.com");
        updateUser.setAccountManagerName("Smart Manager");
        updateUser.setAddressLine1("Felaw Maltings");
        updateUser.setAddressLine2("Felaw Street");
        updateUser.setAddressStatus("Validated");
        updateUser.setAlternativeContactNumber("01473 421421");
        updateUser.setAlternativeEmail("altemail@smart421.com");
        updateUser.setAttribute6("Ex-Directory");
        updateUser.setAttribute7("Not Opted");
        updateUser.setCompanyName("KCOM");
        updateUser.setCompanyTelephoneNumber("01473 421421");
        updateUser.setTownCity("Ipswich");
        updateUser.setPostcode("IP12 8PN");
        updateUser.setCountry("UK");
        updateUser.setCompanyRegistrationNumber("122345");
        updateUser.setContactMedium("Email");
        updateUser.setCounty("Suffolk");
        updateUser.setCreditVetDate(new Date());
        updateUser.setCustomerType("CON");
        updateUser.setDateOfBirth(new Date());
        updateUser.setEsmeCustomer(true);
        updateUser.setGender("M");
        updateUser.setGenevaCustId("1242425");
        updateUser.setHouseNumber("10");
        updateUser.setHasHadRole(false);
        updateUser.setHasBeenBillingContact(false);
        updateUser.setInitials("S");
        updateUser.setJobFunction("Administrator");
        updateUser.setJobTitle("Director");
        updateUser.setMsisdnValid("Yes");
        UserTO updatedUser = facade.updateUser(updateUser);
        assertNotNull(updatedUser.getId());
    }

    public void testCreateUserMininmum() throws Exception
    {
        FinanceFacade facade = new FinanceFacade();
        UserTO user = new UserTO();
        user.setDomain("ref.o2.co.uk");
        user.setMsisdn(generateRandomMsisdn());
        user.setId("test_" + generateRandomMsisdn());
        user.setForename("Test Finance");
        user.setLastname("Junit");
        user.setPassword("password");
        user.setSecurityQuestion("password");
        user.setSecurityAnswer("password");
        UserTO newUser = facade.createUser(user);
        assertNotNull(newUser.getCustomerNumber());
    }

    public void testCreateUser() throws Exception
    {
        FinanceFacade facade = new FinanceFacade();
        UserTO user =   createNewUserTO();

        UserTO newUser = facade.createUser(user);
        assertNotNull(newUser.getCustomerNumber());
    }

    private UserTO createNewUserTO()
    {
        UserTO user = new UserTO();

        user.setDomain( PropertyManager.getApplicationProperties().getRegistrationDomain());
        user.setMsisdn(generateRandomMsisdn());
        user.setId("test_" + generateRandomMsisdn());
        user.setForename("Test Finance");
        user.setLastname("Junit");
        user.setPassword("password");
        user.setSecurityQuestion("password");
        user.setSecurityAnswer("password");
        user.setAccountManagerEmail("test@smart421.com");
        user.setAccountManagerName("Smart Manager");
        user.setAddressLine1("Felaw Maltings");
        user.setAddressLine2("Felaw Street");
        user.setAddressStatus("Validated");
        user.setAlternativeContactNumber("01473 421421");
        user.setAlternativeEmail("altemail@smart421.com");
        user.setAttribute6("Ex-Directory");
        user.setAttribute7("Not Opted");
        user.setCompanyName("KCOM");
        user.setCompanyTelephoneNumber("01473 421421");
        user.setTownCity("Ipswich");
        user.setPostcode("IP12 8PN");
        user.setCountry("UK");
        user.setCompanyRegistrationNumber("122345");
        user.setContactMedium("Email");
        user.setCounty("Suffolk");
        user.setCreditVetDate(new Date());
        user.setCustomerType("CON");
        user.setDateOfBirth(new Date());
        user.setEsmeCustomer(true);
        user.setGender("M");
        user.setGenevaCustId("1242425");
        user.setHouseNumber("10");
        user.setHasHadRole(false);
        user.setHasBeenBillingContact(false);
        user.setInitials("S");
        user.setJobFunction("Administrator");
        user.setJobTitle("Director");
        user.setMsisdnValid("Yes");
        user.setPosBusinessUnit( "BADGER" );

        return user;
    }

    public void testGetUserDetails() throws Exception
    {
        FinanceFacade facade = new FinanceFacade();

        UserTO userToCreate = createNewUserTO();

        UserTO createdUser = facade.createUser( userToCreate );

        assertNotNull( createdUser );

        UserTO user;
        user = facade.getUserByUsername(createdUser.getId());
        assertNotNull(user);
    }

    public void testSuggestUserName() throws Exception
    {
        FinanceFacade facade = new FinanceFacade();
        List suggestions = new ArrayList();
        suggestions = facade.suggestUserName("test", "tester");
        assertNotNull(suggestions.get(0));
        System.out.println(suggestions.get(0));
    }

    public void testSuggestUserNameFail() throws Exception
    {
        FinanceFacade facade = new FinanceFacade();
        List suggestions = new ArrayList();
        suggestions = facade.suggestUserName("", null);
        assertNull(suggestions);
    }

    private String generateRandomMsisdn()
    {
        Random random = new Random();
        StringBuffer buff = new StringBuffer();
        buff.append("447");
        for (int i = 0; i < 9; i++)
        {
            buff.append(random.nextInt(10));
        }
        return buff.toString();
    }
}
