package com.o2.finance.service;

import java.util.Date;
import java.util.Random;

import com.o2.finance.properties.PropertyManager;
import uk.co.o2.registration.registration.registrationtypes.GetUserDetailsRequestType;
import uk.co.o2.registration.registration.registrationtypes.GetUserDetailsResponseType;

import junit.framework.TestCase;

import com.o2.finance.model.UserTO;
import com.o2.finance.util.TestSetup;
import com.o2.www.broadband.avatartypes.CreateUserRequestType;
import com.o2.www.broadband.avatartypes.CreateUserResponseType;
import com.o2.www.broadband.avatartypes.MobilePhoneType;
import com.o2.www.broadband.avatartypes.O2DomainType;
import com.o2.www.broadband.avatartypes.UpdateUserRequestType;
import com.o2.www.broadband.avatartypes.UpdateUserResponseType;
import com.o2.www.broadband.avatartypes.UserCreationType;
import com.o2.www.broadband.avatartypes.UserDataType;
import com.o2.www.broadband.avatartypes.UsernameSuggestionsType;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Purpose: com.o2.finance.service User: D Smith Date: 24/05/2011
 */
public class OrangeServiceImplTest extends TestCase
{
    Logger log = LogManager.getLogger(this.getClass());

    public void setUp() throws Exception
    {
        TestSetup.initialiseLog4j();
    }

    public void testUpdateUser() throws Exception
    {
        OrangeService service = OrangeServiceImpl.createOrangeServiceImpl();
        // Create New User
        UserCreationType createUser = new UserCreationType();
        createUser.setDomain(O2DomainType.Factory.fromValue("ref.o2.co.uk"));
        MobilePhoneType mobilePhoneType = new MobilePhoneType();
        mobilePhoneType.setMobilePhoneType(generateRandomMsisdn());
        createUser.setMsisdn(mobilePhoneType);
        createUser.setId("test" + mobilePhoneType.getMobilePhoneType());
        createUser.setForename("Test" + mobilePhoneType.getMobilePhoneType());
        createUser.setLastname("Junit");
        createUser.setPassword("password");
        createUser.setSecurityQuestion("password");
        createUser.setSecurityAnswer("password");
        CreateUserRequestType createUserRequestType = new CreateUserRequestType();
        createUserRequestType.setUser(createUser);
        CreateUserResponseType createUserResponse = service.createUser(createUserRequestType);
        // Update user
        UserDataType user = new UserDataType();
        user.setDomain(createUserResponse.getUser().getDomain());
        user.setId(createUserResponse.getUser().getId());
        // Update Company Name
        user.setCompanyName("Smart421");
        UpdateUserRequestType updateUserRequestType = new UpdateUserRequestType();
        updateUserRequestType.setUser(user);
        UpdateUserResponseType updateUserResponse = service.updateUser(updateUserRequestType);
        assertNotNull(updateUserResponse.getUser().getId());
    }

    public void testCreateUser() throws Exception
    {
        OrangeService service = OrangeServiceImpl.createOrangeServiceImpl();
        UserCreationType user = new UserCreationType();
        user.setDomain(O2DomainType.Factory.fromValue("ref.o2.co.uk"));
        MobilePhoneType mobilePhoneType = new MobilePhoneType();
        mobilePhoneType.setMobilePhoneType(generateRandomMsisdn());
        user.setMsisdn(mobilePhoneType);
        user.setId("test" + mobilePhoneType.getMobilePhoneType());
        user.setForename("Test" + mobilePhoneType.getMobilePhoneType());
        user.setLastname("Junit");
        user.setPassword("password");
        user.setSecurityQuestion("password");
        user.setSecurityAnswer("password");
        CreateUserRequestType createUserRequestType = new CreateUserRequestType();
        createUserRequestType.setUser(user);
        CreateUserResponseType createUserResponse = service.createUser(createUserRequestType);
        assertNotNull(createUserResponse.getUser().getId());
    }

    public void testGetUserDetails() throws Exception
    {

        AvatarServiceAdapter avatarServiceAdapter = new AvatarServiceAdapter();
        UserTO userToCreate = createNewUserTO();

        OrangeService service = OrangeServiceImpl.createOrangeServiceImpl();

        // first crate a user.
        CreateUserRequestType createUserRequestType = new CreateUserRequestType();
        UserCreationType userCreationType = avatarServiceAdapter.mapUserToCreationType( userToCreate );

        createUserRequestType.setUser( userCreationType );
        CreateUserResponseType createdUserResponseType =  service.createUser( createUserRequestType );

        assertNotNull( createdUserResponseType.getUser() );
        UserDataType createdUser = createdUserResponseType.getUser();


        GetUserDetailsRequestType request = new GetUserDetailsRequestType();
        GetUserDetailsResponseType response = new GetUserDetailsResponseType();


        request.setCustnum( createdUser.getCustnum().intValue() );
        request.setDomain( createdUser.getDomain().getValue() );
        request.setUsername( createdUser.getId() );


        response = service.getUserDetails(request);
        System.out.println(response.get_return());

        UserTOAdapter adapter = new UserTOAdapter();
        UserTO foundUser = adapter.fromXML(response.get_return());

        assertNotNull(foundUser.getId() );
        assertEquals( userToCreate.getId(), foundUser.getId()  );
        assertEquals( userToCreate.getDomain(), foundUser.getDomain() );
        assertEquals( createdUser.getCustnum().intValue(), foundUser.getCustomerNumber().intValue() );




    }

    public void testSuggestUserName() throws Exception
    {
        OrangeService service = OrangeServiceImpl.createOrangeServiceImpl();
        UsernameSuggestionsType suggestionType = new UsernameSuggestionsType();
        suggestionType = service.suggestUserName("test", "atSmart");
        assertNotNull(suggestionType.getSuggestion());
    }

    public void testAdapter() throws Exception
    {
        UserTOAdapter adapter = new UserTOAdapter();
        UserTO userTO = adapter
                .fromXML("<userDetails><user GenevaCustomerId='3398423'"
                        + " MSISDNvalid='Yes' SecurityAnswer='Star' SecurityQuestion='Blue' contactMedium='Email' "
                        + "custnum='380084' customerType='CON' domain='stf.ref.o2.co.uk' forename='pooey' "
                        + " gender='F' hasBeenBillingContact='Yes' hasHadRole='Yes' id='santa7' "
                        + "jobFunction='tester' jobTitle='tester' "
                        + "lastname='SANATA' owningBusinessDivision='Online' password='santa7' "
                        + "registrationType='P' saleDate='2010-10-01' alternativeEmail='debbie@stb.stb' dateOfBirth='1977-05-24' "
                        + "accountManagerEmail='smart.com' accountManagerName='test manager' alternativeContactNumber='01962810000' "
                        + "isESMECustomer='Yes' partner='consu' "
                        + "segmentation='Bronze' title='mr' wantsGenieMarketting='Yes' wantsOtherMarketting='Yes' "
                        + " MSISDN='07590711159' network='o2' noCompanyEmployees='20' referralDate='2011-05-01' >"
                        + "<Address><houseNumber>1</houseNumber><addressLine1>75 HAMPSTEAD ROAD</addressLine1><townCity>LONDON</townCity>"
                        + "<county>LONDON</county><postcode>NW1 2PL</postcode><country>UK</country></Address>"
                        + "</user></userDetails>");
        // System.out.println(userTO.toString());
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

 private UserTO createNewUserTO()
    {
        UserTO user = new UserTO();

        user.setDomain( PropertyManager.getApplicationProperties().getRegistrationDomain());
        user.setMsisdn( generateRandomMsisdn() );
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

}
