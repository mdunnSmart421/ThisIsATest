package com.o2.finance.service;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Calendar;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.o2.finance.model.UserTO;
import com.o2.www.broadband.avatartypes.AddressType;
import com.o2.www.broadband.avatartypes.ContactMediumType;
import com.o2.www.broadband.avatartypes.CustomerSegmentationType;
import com.o2.www.broadband.avatartypes.EmailAddressType;
import com.o2.www.broadband.avatartypes.GenderType;
import com.o2.www.broadband.avatartypes.ListingDetailType;
import com.o2.www.broadband.avatartypes.ListingLevelType;
import com.o2.www.broadband.avatartypes.MobilePhoneType;
import com.o2.www.broadband.avatartypes.O2DomainType;
import com.o2.www.broadband.avatartypes.OwningBusinessDivisionType;
import com.o2.www.broadband.avatartypes.PhoneNumberType;
import com.o2.www.broadband.avatartypes.PortalMSISDNStatusType;
import com.o2.www.broadband.avatartypes.PostcodeType;
import com.o2.www.broadband.avatartypes.SectorType;
import com.o2.www.broadband.avatartypes.TypeOfCustomerType;
import com.o2.www.broadband.avatartypes.UserCreationType;
import com.o2.www.broadband.avatartypes.UserDataType;
import com.o2.www.broadband.avatartypes.UserRegistrationType;
import com.o2.www.broadband.avatartypes.YesNoType;

/**
 * Allows to map generated service objects to UserTO for calls to Orange Avatar Service to Create and Update User Details
 */
public class AvatarServiceAdapter
{
    private Logger log = LogManager.getLogger(AvatarServiceAdapter.class);

    /**
     * UserTO is mapped to UserCreationType required in CreateUser call
     * 
     * @param userTO
     * @return
     */
    public UserCreationType mapUserToCreationType(UserTO userTO)
    {

        log.info( "mapUserToCreationType start." );

        log.debug("AvatarServiceAdapter :: mapUserToCreationType()  mapping UserTO to Webservice UserCreatioType");
        UserCreationType user = new UserCreationType();
        EmailAddressType emailAddressType = new EmailAddressType();
        PhoneNumberType phoneNumberType = new PhoneNumberType();
        MobilePhoneType mobilePhoneType = new MobilePhoneType();
        AddressType addressType = new AddressType();
        PostcodeType postcodeType = new PostcodeType();
        if (userTO.getHouseNumber() != null || userTO.getHouseName() != null || userTO.getAddressLine1() != null
                || userTO.getAddressLine2() != null || userTO.getTownCity() != null || userTO.getCounty() != null
                || userTO.getPostcode() != null || userTO.getCountry() != null || userTO.getAddressStatus() != null
                || userTO.getPtCaps() != null)
        {
            addressType.setHouseNumber(userTO.getHouseNumber());
            addressType.setHouseName(userTO.getHouseName());
            addressType.setAddressLine1(userTO.getAddressLine1());
            addressType.setAddressLine2(userTO.getAddressLine2());
            addressType.setTownCity(userTO.getTownCity());
            addressType.setCounty(userTO.getCounty());
            postcodeType.setPostcodeType(userTO.getPostcode());
            addressType.setPostcode(postcodeType);
            addressType.setCountry(userTO.getCountry());
            addressType.setStatus(userTO.getAddressStatus());
            addressType.setPTCABS(userTO.getPtCaps());
            user.setAddress(addressType);
            log.debug("AvatarServiceAdapter :: AddressType = " + addressType);
        }

        if (userTO.getAccountManagerEmail() != null)
        {
            emailAddressType.setEmailAddressType(userTO.getAccountManagerEmail());
            user.setAccountManagerEmail(emailAddressType);
        }

        user.setAccountManagerName(userTO.getAccountManagerName());

        if (userTO.getAlternativeContactNumber() != null)
        {
            phoneNumberType.setPhoneNumberType(userTO.getAlternativeContactNumber());
            user.setAlternativeContactNumber(phoneNumberType);
        }

        if (userTO.getAlternativeEmail() != null)
        {
            emailAddressType.setEmailAddressType(userTO.getAlternativeEmail());
            user.setAlternativeEmail(emailAddressType);
        }

        user.setCompanyName(userTO.getCompanyName());

        user.setCompanyRegistrationNumber(userTO.getCompanyRegistrationNumber());

        if (userTO.getCompanyTelephoneNumber() != null)
        {
            phoneNumberType.setPhoneNumberType(userTO.getCompanyTelephoneNumber());
            user.setCompanyTelephoneNumber(phoneNumberType);
        }

        if (userTO.getContactMedium() != null)
        {
            user.setContactMedium(ContactMediumType.Factory.fromValue( userTO.getContactMedium() ));
        }

        user.setCreditVetDate(userTO.getCreditVetDate());

        user.setCreditVetPassed(userTO.getCreditVetPassed());

        if (userTO.getCustomerType() != null)
        {
            TypeOfCustomerType tcust = TypeOfCustomerType.Factory.fromValue( userTO.getCustomerType() );
            user.setCustomerType(tcust);
        }

        Integer custnum = userTO.getCustomerNumber();
        if (custnum != null)
        {
            BigInteger bi = new BigInteger(custnum.toString());
            user.setCustnum(bi);
        }

        user.setDateOfBirth(userTO.getDateOfBirth());

        if (userTO.getAttribute6() != null)
        {
            user.setDqListingDetail(ListingDetailType.Factory.fromValue( userTO.getAttribute6() ));
        }

        if (userTO.getAttribute7() != null)
        {
            user.setDqListingLevel(ListingLevelType.Factory.fromValue( userTO.getAttribute7() ));
        }

        String domain = userTO.getDomain();
        if (domain != null)
        {
            user.setDomain(O2DomainType.Factory.fromValue(domain));
        }

        user.setForename(userTO.getForename());

        String gender = userTO.getGender();
        if (gender != null)
        {
            user.setGender(GenderType.Factory.fromValue(gender));
        }

        user.setGenevaCustomerId(userTO.getGenevaCustId());

        boolean billingContact = userTO.getHasBeenBillingContact();
        user.setHasBeenBillingContact(toYesNo(billingContact));

        boolean hasHadRole = userTO.getHasHadRole();
        user.setHasHadRole(toYesNo(hasHadRole));

        user.setId(userTO.getId());

        user.setInitials(userTO.getInitials());

        if (userTO.getIsEsmeCustomer())
        {
            user.setIsESMECustomer(toYesNo("Y"));
        } else
        {
            user.setIsESMECustomer(toYesNo("N"));
        }

        if (userTO.getJobFunction() != null)
        {
            user.setJobFunction(userTO.getJobFunction());
        }

        if (userTO.getJobTitle() != null)
        {
            user.setJobTitle(userTO.getJobTitle());
        }

        if (userTO.getKey() != null)
        {
            user.setKey(userTO.getKey());
        }

        if (userTO.getLastname() != null)
        {
            user.setLastname(userTO.getLastname());
        }

        if (userTO.getLevel2Password() != null)
        {
            user.setLevel2Password(userTO.getLevel2Password());
        }

        String msisdn = userTO.getMsisdn();
        if (msisdn != null)
        {
            mobilePhoneType.setMobilePhoneType(fixmsisdn(msisdn));
            user.setMsisdn(mobilePhoneType);
        }

        if (userTO.getMsisdnValid() != null)
        {
            user.setMsisdnValid(PortalMSISDNStatusType.Factory.fromValue(userTO.getMsisdnValid()));
        }

        user.setNetwork(userTO.getNetwork());

        if (userTO.getNoCompanyEmployees() != null)
        {
            BigInteger bi2 = new BigInteger(userTO.getNoCompanyEmployees().toString());
            user.setNumberOfEmployees(bi2);
        }

        if (userTO.getOwningBusinessDivision() != null)
        {
            user.setOwningBusinessDivision(OwningBusinessDivisionType.Factory.fromValue( userTO.getOwningBusinessDivision() ));
        }

        user.setPartner(userTO.getPartner());

        user.setPassword(userTO.getPassword());

        user.setPhoneMake(userTO.getPhoneMake());

        user.setPosBusinessUnit(userTO.getPosBusinessUnit());

        user.setReferral(userTO.getReferral());

        user.setReferralDate(userTO.getReferralDate());

        if (userTO.getRegistrationType() != null)
        {
            user.setRegistrationType(UserRegistrationType.Factory.fromValue( userTO.getRegistrationType() ));
        }

        if (userTO.getRiskThreshold() != null)
        {
            BigInteger bi3 = new BigInteger(userTO.getRiskThreshold().toString());
            user.setRiskThreshold(bi3);
        }

        user.setRiskThresholdDate(userTO.getRiskThresholdDate());

        user.setSaleDate(userTO.getSaleDate());

        if (userTO.getSector() != null)
        {
            user.setSector(SectorType.Factory.fromValue( userTO.getSector() ));
        }

        user.setSecurityQuestion(userTO.getSecurityQuestion());

        user.setSecurityAnswer(userTO.getSecurityAnswer());

        if (userTO.getSegmentationType() != null)
        {
            user.setSegmentation(CustomerSegmentationType.Factory.fromValue( userTO.getSegmentationType() ));
        }

        user.setTitle(userTO.getTitle());

        user.setWantsGenieMarketing(toYesNo(userTO.getWantsO2Marketing()));

        user.setWantsOtherMarketing(toYesNo(userTO.getWantsOtherMarketing()));

        log.info( "mapUserToCreationType ends." );
        return user;
    }

    /**
     * UserTO is mapped to UserDataType required in UpdateUser call to Avatar Service
     * 
     * @param userTO
     * @return
     */
    public UserDataType mapUserToUpdateType(UserTO userTO)
    {
        log.info( "mapUserToUpdateType start." );

        log.debug("AvatarServiceAdapter :: mapUserToUpdateType()  mapping UserTO to UserDataType.");

        UserDataType user = new UserDataType();
        EmailAddressType emailAddressType = new EmailAddressType();
        AddressType addressType = new AddressType();
        PostcodeType postcodeType = new PostcodeType();
        PhoneNumberType phoneNumberType = new PhoneNumberType();
        MobilePhoneType mobilePhoneType = new MobilePhoneType();

        if (userTO.getHouseNumber() != null || userTO.getHouseName() != null || userTO.getAddressLine1() != null
                || userTO.getAddressLine2() != null || userTO.getTownCity() != null || userTO.getCounty() != null
                || userTO.getPostcode() != null || userTO.getCountry() != null || userTO.getAddressStatus() != null
                || userTO.getPtCaps() != null)
        {
            addressType.setHouseNumber(userTO.getHouseNumber());
            addressType.setHouseName(userTO.getHouseName());
            addressType.setAddressLine1(userTO.getAddressLine1());
            addressType.setAddressLine2(userTO.getAddressLine2());
            addressType.setTownCity(userTO.getTownCity());
            addressType.setCounty(userTO.getCounty());
            postcodeType.setPostcodeType(userTO.getPostcode());
            addressType.setPostcode(postcodeType);
            addressType.setCountry(userTO.getCountry());
            addressType.setStatus(userTO.getAddressStatus());
            addressType.setPTCABS(userTO.getPtCaps());
            user.setAddress(addressType);
            log.debug("AvatarServiceAdapter :: AddressType = " + addressType);
        }

        if (userTO.getAccountManagerEmail() != null)
        {
            emailAddressType.setEmailAddressType(userTO.getAccountManagerEmail());
            user.setAccountManagerEmail(emailAddressType);
        }

        user.setAccountManagerName(userTO.getAccountManagerName());

        if (userTO.getAlternativeContactNumber() != null)
        {
            phoneNumberType.setPhoneNumberType(userTO.getAlternativeContactNumber());
            user.setAlternativeContactNumber(phoneNumberType);
        }

        if (userTO.getAlternativeEmail() != null)
        {
            emailAddressType.setEmailAddressType(userTO.getAlternativeEmail());
            user.setAlternativeEmail(emailAddressType);
        }

        user.setCompanyName(userTO.getCompanyName());

        user.setCompanyRegistrationNumber(userTO.getCompanyRegistrationNumber());

        if (userTO.getCompanyTelephoneNumber() != null)
        {
            phoneNumberType.setPhoneNumberType(userTO.getCompanyTelephoneNumber());
            user.setCompanyTelephoneNumber(phoneNumberType);
        }

        if (userTO.getContactMedium() != null)
        {
            user.setContactMedium(ContactMediumType.Factory.fromValue( userTO.getContactMedium() ));
        }

        user.setCreditVetDate(userTO.getCreditVetDate());

        user.setCreditVetPassed(userTO.getCreditVetPassed());

        if (userTO.getCustomerType() != null)
        {
            TypeOfCustomerType tcust = TypeOfCustomerType.Factory.fromValue( userTO.getCustomerType() );
            user.setCustomerType(tcust);
        }

        Integer custnum = userTO.getCustomerNumber();
        if (custnum != null)
        {
            BigInteger bi = new BigInteger(custnum.toString());
            user.setCustnum(bi);
        }

        user.setDateOfBirth(userTO.getDateOfBirth());

        if (userTO.getAttribute6() != null)
        {
            user.setDqListingDetail(ListingDetailType.Factory.fromValue( userTO.getAttribute6() ));
        }

        if (userTO.getAttribute7() != null)
        {
            user.setDqListingLevel(ListingLevelType.Factory.fromValue( userTO.getAttribute7() ));
        }

        String domain = userTO.getDomain();

        if (domain != null)
        {
            user.setDomain(O2DomainType.Factory.fromValue(domain));
        }

        user.setForename(userTO.getForename());

        String gender = userTO.getGender();
        if (gender != null)
        {
            user.setGender(GenderType.Factory.fromValue(gender));
        }

        user.setGenevaCustomerId(userTO.getGenevaCustId());

        boolean hasBeenBillingContact = userTO.getHasBeenBillingContact();
        user.setHasBeenBillingContact(toYesNo(hasBeenBillingContact));

        boolean hasHadRole = userTO.getHasHadRole();
        user.setHasHadRole(toYesNo(hasHadRole));

        user.setId(userTO.getId());

        user.setInitials(userTO.getInitials());

        if (userTO.getIsEsmeCustomer())
        {
            user.setIsESMECustomer(toYesNo("Y"));
        } else
        {
            user.setIsESMECustomer(toYesNo("N"));
        }

        if (userTO.getJobFunction() != null)
        {
            user.setJobFunction(userTO.getJobFunction());
        }

        if (userTO.getJobTitle() != null)
        {
            user.setJobTitle(userTO.getJobTitle());
        }

        if (userTO.getKey() != null)
        {
            user.setKey(userTO.getKey());
        }

        if (userTO.getLastname() != null)
        {
            user.setLastname(userTO.getLastname());
        }

        String msisdn = userTO.getMsisdn();
        if (msisdn != null)
        {
            mobilePhoneType.setMobilePhoneType(fixmsisdn(msisdn));
            user.setMsisdn(mobilePhoneType);
        }

        if (userTO.getMsisdnValid() != null)
        {
            user.setMsisdnValid(PortalMSISDNStatusType.Factory.fromValue(userTO.getMsisdnValid()));
        }

        user.setNetwork(userTO.getNetwork());

        if (userTO.getNoCompanyEmployees() != null)
        {
            BigInteger bi2 = new BigInteger(userTO.getNoCompanyEmployees().toString());
            user.setNumberOfEmployees(bi2);
        }

        if (userTO.getOwningBusinessDivision() != null)
        {
            user.setOwningBusinessDivision(OwningBusinessDivisionType.Factory.fromValue( userTO.getOwningBusinessDivision() ));
        }

        user.setPartner(userTO.getPartner());


        user.setPhoneMake(userTO.getPhoneMake());

        user.setPosBusinessUnit(userTO.getPosBusinessUnit());

        user.setReferral(userTO.getReferral());

        user.setReferralDate(userTO.getReferralDate());

        if (userTO.getRegistrationType() != null)
        {
            user.setRegistrationType(UserRegistrationType.Factory.fromValue( userTO.getRegistrationType() ));
        }

        if (userTO.getRiskThreshold() != null)
        {
            BigInteger bi3 = new BigInteger(userTO.getRiskThreshold().toString());
            user.setRiskThreshold(bi3);
        }

        user.setRiskThresholdDate(userTO.getRiskThresholdDate());

        user.setSaleDate(userTO.getSaleDate());
        if (userTO.getSector() != null)
        {
            user.setSector(SectorType.Factory.fromValue( userTO.getSector() ));
        }

        user.setSecurityQuestion(userTO.getSecurityQuestion());

        user.setSecurityAnswer(userTO.getSecurityAnswer());

        if (userTO.getSegmentationType() != null)
        {
            user.setSegmentation(CustomerSegmentationType.Factory.fromValue( userTO.getSegmentationType() ));
        }

        user.setTitle(userTO.getTitle());

        user.setWantsGenieMarketing(toYesNo(userTO.getWantsO2Marketing()));

        user.setWantsOtherMarketing(toYesNo(userTO.getWantsOtherMarketing()));

        log.info( "mapUserToUpdateType ends." );

        return user;
    }

    /**
     * Maps UserDataType returned by Avatar service to UserTO
     * 
     * @param requestData
     *            UserDataType
     * @return
     * @throws ServiceException
     */
    public UserTO mapServiceToUser(UserDataType requestData)
    {
        log.info( "mapServiceToUser start." );

        log.debug("AvatarServiceAdapter :: mapServiceToUser() Starts.");

        UserTO newCust = new UserTO();
        try
        {
            if (requestData.getGenevaCustomerId() != null)
            {
                newCust.setGenevaCustId(requestData.getGenevaCustomerId());
            }
            AddressType addr = requestData.getAddress();
            if (addr != null)
            {
                if (addr.getHouseNumber() != null)
                {
                    newCust.setHouseNumber(addr.getHouseNumber());
                }
                if (addr.getHouseName() != null)
                {
                    newCust.setHouseName(addr.getHouseName());
                }
                if (addr.getAddressLine1() != null)
                {
                    newCust.setAddressLine1(addr.getAddressLine1());
                }
                if (addr.getAddressLine2() != null)
                {
                    newCust.setAddressLine2(addr.getAddressLine2());
                }
                if (addr.getTownCity() != null)
                {
                    newCust.setTownCity(addr.getTownCity());
                }
                if (addr.getCounty() != null)
                {
                    newCust.setCounty(addr.getCounty());
                }
                if (addr.getPostcode().getPostcodeType() != null)
                {
                    newCust.setPostcode(addr.getPostcode().getPostcodeType());
                }
                if (addr.getCountry() != null)
                {
                    newCust.setCountry(addr.getCountry());
                }
                if (addr.getStatus() != null)
                {
                    newCust.setAddressStatus(addr.getStatus());
                }
                if (addr.getPTCABS() != null)
                {
                    newCust.setPtCaps(addr.getPTCABS());
                }
            }
            if (requestData.getAccountManagerEmail() != null)
            {
                newCust.setAccountManagerEmail(requestData.getAccountManagerEmail().getEmailAddressType());
            }
            if (requestData.getAccountManagerName() != null)
            {
                newCust.setAccountManagerName(requestData.getAccountManagerName());
            }
            if (requestData.getAlternativeContactNumber() != null)
            {
                newCust.setAlternativeContactNumber(requestData.getAlternativeContactNumber().getPhoneNumberType());
            }
            if (requestData.getAlternativeEmail() != null)
            {
                newCust.setAlternativeEmail(requestData.getAlternativeEmail().getEmailAddressType());
            }
            String id = requestData.getId();
            if (id != null)
            {
                newCust.setId(id);
            }
            if (requestData.getDomain() != null)
            {
                String emailDomain = requestData.getDomain().toString();
                newCust.setDomain(emailDomain);
            }

            String companyName = requestData.getCompanyName();
            if (companyName != null)
            {
                newCust.setCompanyName(companyName);
            }

            if (requestData.getCompanyTelephoneNumber() != null)
            {
                newCust.setCompanyTelephoneNumber(requestData.getCompanyTelephoneNumber().getPhoneNumberType());
            }

            ContactMediumType contact = requestData.getContactMedium();
            if (contact != null)
            {
                newCust.setContactMedium(contact.toString());
            }

            newCust.setCreditVetDate(requestData.getCreditVetDate());

            String creditPassed = requestData.getCreditVetPassed();
            if (creditPassed != null)
            {
                newCust.setCreditVetPassed(creditPassed);
            }

            TypeOfCustomerType customerType = requestData.getCustomerType();
            if (customerType != null)
            {
                newCust.setCustomerType(customerType.toString());
            }

            BigInteger custNum = requestData.getCustnum();
            if (custNum != null)
            {
                newCust.setCustomerNumber(new Integer(custNum.intValue()));
            }

            newCust.setDateOfBirth(requestData.getDateOfBirth());

            ListingDetailType dqlist = requestData.getDqListingDetail();
            if (dqlist != null)
            {
                newCust.setAttribute6(dqlist.toString());
            }

            ListingLevelType listingLevel = requestData.getDqListingLevel();
            if (listingLevel != null)
            {
                newCust.setAttribute7(listingLevel.getValue());
            }

            O2DomainType domain = requestData.getDomain();
            if (domain != null)
            {
                newCust.setDomain(domain.toString());
            }
            String forename = requestData.getForename();
            if (forename != null)
            {
                newCust.setForename(forename);
            }

            GenderType gender = requestData.getGender();
            if (gender != null)
            {
                newCust.setGender(gender.toString());
            }

            String genevaCustomerId = requestData.getGenevaCustomerId();
            if (genevaCustomerId != null)
            {
                newCust.setGenevaCustId(genevaCustomerId);
            }

            YesNoType hasBeenBillingContact = requestData.getHasBeenBillingContact();
            if (hasBeenBillingContact != null)
            {
                newCust.setHasBeenBillingContact((fromYesNo(hasBeenBillingContact)));
            }

            YesNoType hasHadRole = requestData.getHasHadRole();
            if (hasHadRole != null)
            {
                newCust.setHasHadRole(fromYesNo(hasHadRole));
            }

            String initials = requestData.getInitials();
            if (initials != null)
            {
                newCust.setInitials(initials);
            }

            newCust.setEsmeCustomer(false);
            YesNoType isESME = requestData.getIsESMECustomer();
            if (isESME != null)
            {
                newCust.setEsmeCustomer(isYesNo(isESME));
            }

            String jobFunction = requestData.getJobFunction();
            if (jobFunction != null)
            {
                newCust.setJobFunction(jobFunction);
            }

            String jobTitle = requestData.getJobTitle();
            if (jobTitle != null)
            {
                newCust.setJobTitle(jobTitle);
            }

            String akey = requestData.getKey();
            if (akey != null)
            {
                newCust.setKey(akey);
            }

            String lastName = requestData.getLastname();
            if (lastName != null)
            {
                newCust.setLastname(lastName);
            }

            if (requestData.getMsisdn() != null)
            {
                newCust.setMsisdn(fixmsisdn(requestData.getMsisdn().getMobilePhoneType()));
            }

            PortalMSISDNStatusType msisdnValid = requestData.getMsisdnValid();

            if (msisdnValid != null)
            {
                newCust.setMsisdnValid(msisdnValid.toString());
            }

            String network = requestData.getNetwork();
            if (network != null)
            {
                newCust.setNetwork(network);
            }

            BigInteger numberOfEmployees = requestData.getNumberOfEmployees();
            if (numberOfEmployees != null)
            {
                newCust.setNoCompanyEmployees(Integer.getInteger(numberOfEmployees.toString()));
            }

            OwningBusinessDivisionType owningBusinessDivision = requestData.getOwningBusinessDivision();
            if (owningBusinessDivision != null)
            {
                newCust.setOwningBusinessDivision(owningBusinessDivision.getValue());
            }

            String partner = requestData.getPartner();
            if (partner != null)
            {
                newCust.setPartner(partner);
            }

            String phoneMake = requestData.getPhoneMake();
            if (phoneMake != null)
            {
                newCust.setPhoneMake(phoneMake);
            }

            String posBusinessUnit = requestData.getPosBusinessUnit();
            if (posBusinessUnit != null)
            {
                newCust.setPosBusinessUnit(posBusinessUnit);
            }

            String referral = requestData.getReferral();
            if (referral != null)
            {
                newCust.setReferral(referral);
            }

            newCust.setReferralDate(requestData.getReferralDate());

            UserRegistrationType registrationType = requestData.getRegistrationType();
            if (registrationType != null)
            {
                newCust.setRegistrationType(registrationType.getValue());
            }

            BigInteger riskThreshold = requestData.getRiskThreshold();
            if (riskThreshold != null)
            {
                newCust.setRiskThreshold(Integer.getInteger(riskThreshold.toString()));
            }

            newCust.setRiskThresholdDate(requestData.getRiskThresholdDate());

            newCust.setSaleDate(requestData.getSaleDate());

            SectorType sector = requestData.getSector();
            if (sector != null)
            {
                newCust.setSector(sector.toString());
            }

            String securityQuestion = requestData.getSecurityQuestion();
            if (securityQuestion != null)
            {
                newCust.setSecurityQuestion( securityQuestion );
            }

            String securityAnswer = requestData.getSecurityAnswer();
            if (securityAnswer != null)
            {
                newCust.setSecurityAnswer(securityAnswer);
            }

            CustomerSegmentationType segment = requestData.getSegmentation();
            if (segment != null)
            {
                newCust.setSegmentationType(segment.getValue());
            }
            Calendar reqTime = requestData.getTimeStamp();
            if (reqTime != null)
            {
                Timestamp ts = new Timestamp(reqTime.getTimeInMillis());
                newCust.setModifiedDate(ts);
            }

            String atitle = requestData.getTitle();
            if (atitle != null)
            {
                newCust.setTitle(atitle);
            }

            YesNoType wantsO2 = requestData.getWantsGenieMarketing();
            if (wantsO2 != null)
            {
                newCust.setWantsO2Marketing(fromYesNo(wantsO2));
            }

            YesNoType wantsOther = requestData.getWantsOtherMarketing();
            if (wantsOther != null)
            {
                newCust.setWantsOtherMarketing(fromYesNo(wantsOther));
            }

            newCust.setCompanyRegistrationNumber(requestData.getCompanyRegistrationNumber());

        } catch (Exception e)
        {
            throw new RuntimeException(" [AvatarServiceAdapter.mapServiceToUser] "
                    + "Error in mapping Avatar Service User Type to UserTO . Reason - " + e.getMessage(), e);
        }

        log.info( "mapServiceToUser ends." );
        return newCust;
    }

    /**
     * Set of code stubs to regularize the processing of the YesNoType, a class generated from the WSDL description of a type.
     * 
     * The YesNoType REQUIRES input of strings as case sensitive literals and does not offer a simple boolean compare. Also in
     * this class, this always maps to a Y / N value which requires the same repeated edit.
     * 
     * @param isYes
     * @return
     */
    private static YesNoType toYesNo(String isYes)
    {
        if (isYes != null)
        {
            if (isYes.equalsIgnoreCase("Y"))
            {
                return YesNoType.Factory.fromValue("Yes");
            } else
            {
                return YesNoType.Factory.fromValue("No");
            }
        } else
        {
            return YesNoType.Factory.fromValue("No");
        }
    }

    /**
     * @param isYes
     * @return
     */
    private static YesNoType toYesNo(boolean isYes)
    {
        if (isYes)
        {
            return YesNoType.Factory.fromValue("Yes");
        } else
        {
            return YesNoType.Factory.fromValue("No");
        }
    }

    /**
     * @param isYes
     * @return
     */
    private static boolean fromYesNo(YesNoType isYes)
    {
        if (isYes != null)
        {
            String resultStr = isYes.toString();
            if (resultStr.equalsIgnoreCase("Yes"))
            {
                return true;
            } else
            {
                return false;
            }
        } else
        {
            return false;
        }
    }

    /**
     * @param isYes
     * @return
     */
    private static boolean isYesNo(YesNoType isYes)
    {
        boolean isBroadbandUser = false;
        if (isYes != null && isYes.toString().equalsIgnoreCase("Yes"))
        {
            isBroadbandUser = true;
        }
        return isBroadbandUser;
    }

    /**
     * @param msisdn
     * @return
     */
    private static String fixmsisdn(String msisdn)
    {
        if (msisdn.startsWith("07"))
        {
            msisdn = "447" + msisdn.substring(2);
        }
        return msisdn;
    }
}
