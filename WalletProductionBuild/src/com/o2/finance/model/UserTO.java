package com.o2.finance.model;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * UserTO is used to transport data between UI and Business Layer
 * 
 * UserTO
 * 
 */
public class UserTO
{
    private String houseNumber;
    private String houseName;
    private String addressLine1;
    private String addressLine2;
    private String townCity;
    private String county;
    private String postcode;
    private String country;
    private String addressStatus;
    private String ptCaps;
    private String accountManagerEmail;
    private String accountManagerName;
    private String alternativeContactNumber;
    private String alternativeEmail;
    private String companyName;
    private String companyRegistrationNumber;
    private String companyTelephoneNumber;
    private String contactMedium;
    private Date creditVetDate;
    private String creditVetPassed;
    private String customerType;
    private Integer customerNumber;
    private Date dateOfBirth;
    private String attribute6; // DqListingDetail
    private String attribute7; // DqListingLevel
    private String domain;
    private String forename;
    private String gender;
    private String genevaCustId;
    private boolean hasBeenBillingContact;
    private boolean hasHadRole;
    private String id;
    private String initials;
    private boolean isEsmeCustomer;
    private String jobFunction;
    private String jobTitle;
    private String key;
    private String lastname;
    private String level2Password;
    private String msisdn;
    private String msisdnValid;
    private String network;
    private Integer noCompanyEmployees;
    private String owningBusinessDivision;
    private String password;
    private String partner;
    private String phoneMake;
    private String posBusinessUnit;
    private String referral;
    private Date referralDate;
    private String registrationType;
    private Integer riskThreshold;
    private Date riskThresholdDate;
    private Date saleDate;
    private String sector;
    private String securityQuestion;
    private String securityAnswer;
    private String segmentationType;
    private String title;
    private boolean wantsO2Marketing;
    private boolean wantsOtherMarketing;
    private Timestamp modifiedDate;
    private int birthDay;
    private int birthMonth;
    private int birthYear;
    public static final String GENDER_MALE = "M";
    public static final String GENDER_MALE_TEXT = "Male";
    public static final String GENDER_FEMALE = "F";
    public static final String GENDER_FEMALE_TEXT = "Female";
    public static final String GENDER_UNKNOWN = "U";
    public static final String GENDER_UNKNOWN_TEXT = "Unknown";

    Logger log = LogManager.getLogger( this.getClass() );

    /**
	 * 
	 */
    public UserTO()
    {
    }

    /**
     * 
     * @param houseNumber
     * @param houseName
     * @param addressLine1
     * @param addressLine2
     * @param townCity
     * @param county
     * @param postcode
     * @param country
     * @param addressStatus
     * @param ptCaps
     * @param accountManagerEmail
     * @param accountManagerName
     * @param alternativeContactNumber
     * @param alternativeEmail
     * @param companyName
     * @param companyRegistrationNumber
     * @param companyTelephoneNumber
     * @param contactMedium
     * @param creditVetDate
     * @param creditVetPassed
     * @param customerType
     * @param customerNumber
     * @param dateOfBirth
     * @param attribute6
     * @param attribute7
     * @param domain
     * @param forename
     * @param gender
     * @param genevaCustId
     * @param hasBeenBillingContact
     * @param hasHadRole
     * @param id
     * @param initials
     * @param isEsmeCustomer
     * @param jobFunction
     * @param jobTitle
     * @param key
     * @param lastname
     * @param level2Password
     * @param msisdn
     * @param msisdnValid
     * @param network
     * @param noCompanyEmployees
     * @param owningBusinessDivision
     * @param password
     * @param partner
     * @param phoneMake
     * @param posBusinessUnit
     * @param referral
     * @param referralDate
     * @param registrationType
     * @param riskThreshold
     * @param riskThresholdDate
     * @param saleDate
     * @param sector
     * @param securityQuestion
     * @param securityAnswer
     * @param segmentationType
     * @param title
     * @param wantsO2Marketing
     * @param wantsOtherMarketing
     * @param modifiedDate
     * @param birthDay
     * @param birthMonth
     * @param birthYear
     */
    public UserTO(String houseNumber, String houseName, String addressLine1, String addressLine2, String townCity, String county,
            String postcode, String country, String addressStatus, String ptCaps, String accountManagerEmail,
            String accountManagerName, String alternativeContactNumber, String alternativeEmail, String companyName,
            String companyRegistrationNumber, String companyTelephoneNumber, String contactMedium, Date creditVetDate,
            String creditVetPassed, String customerType, Integer customerNumber, Date dateOfBirth, String attribute6,
            String attribute7, String domain, String forename, String gender, String genevaCustId, boolean hasBeenBillingContact,
            boolean hasHadRole, String id, String initials, boolean isEsmeCustomer, String jobFunction, String jobTitle,
            String key, String lastname, String level2Password, String msisdn, String msisdnValid, String network,
            Integer noCompanyEmployees, String owningBusinessDivision, String password, String partner, String phoneMake,
            String posBusinessUnit, String referral, Date referralDate, String registrationType, Integer riskThreshold,
            Date riskThresholdDate, Date saleDate, String sector, String securityQuestion, String securityAnswer,
            String segmentationType, String title, boolean wantsO2Marketing, boolean wantsOtherMarketing, Timestamp modifiedDate,
            int birthDay, int birthMonth, int birthYear)
    {
        this.houseNumber = houseNumber;
        this.houseName = houseName;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.townCity = townCity;
        this.county = county;
        this.postcode = postcode;
        this.country = country;
        this.addressStatus = addressStatus;
        this.ptCaps = ptCaps;
        this.accountManagerEmail = accountManagerEmail;
        this.accountManagerName = accountManagerName;
        this.alternativeContactNumber = alternativeContactNumber;
        this.alternativeEmail = alternativeEmail;
        this.companyName = companyName;
        this.companyRegistrationNumber = companyRegistrationNumber;
        this.companyTelephoneNumber = companyTelephoneNumber;
        this.contactMedium = contactMedium;
        this.creditVetDate = creditVetDate;
        this.creditVetPassed = creditVetPassed;
        this.customerType = customerType;
        this.customerNumber = customerNumber;
        this.dateOfBirth = dateOfBirth;
        this.attribute6 = attribute6;
        this.attribute7 = attribute7;
        this.domain = domain;
        this.forename = forename;
        this.gender = gender;
        this.genevaCustId = genevaCustId;
        this.hasBeenBillingContact = hasBeenBillingContact;
        this.hasHadRole = hasHadRole;
        this.id = id;
        this.initials = initials;
        this.isEsmeCustomer = isEsmeCustomer;
        this.jobFunction = jobFunction;
        this.jobTitle = jobTitle;
        this.key = key;
        this.lastname = lastname;
        this.level2Password = level2Password;
        this.msisdn = msisdn;
        this.msisdnValid = msisdnValid;
        this.network = network;
        this.noCompanyEmployees = noCompanyEmployees;
        this.owningBusinessDivision = owningBusinessDivision;
        this.password = password;
        this.partner = partner;
        this.phoneMake = phoneMake;
        this.posBusinessUnit = posBusinessUnit;
        this.referral = referral;
        this.referralDate = referralDate;
        this.registrationType = registrationType;
        this.riskThreshold = riskThreshold;
        this.riskThresholdDate = riskThresholdDate;
        this.saleDate = saleDate;
        this.sector = sector;
        this.securityQuestion = securityQuestion;
        this.securityAnswer = securityAnswer;
        this.segmentationType = segmentationType;
        this.title = title;
        this.wantsO2Marketing = wantsO2Marketing;
        this.wantsOtherMarketing = wantsOtherMarketing;
        this.modifiedDate = modifiedDate;
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
    }

    /**
     * 
     * @param newUser
     */
    public UserTO(UserTO newUser)
    {
        this(newUser.houseNumber, newUser.houseName, newUser.addressLine1, newUser.addressLine2, newUser.townCity,
                newUser.county, newUser.postcode, newUser.country, newUser.addressStatus, newUser.ptCaps,
                newUser.accountManagerEmail, newUser.accountManagerName, newUser.alternativeContactNumber,
                newUser.alternativeEmail, newUser.companyName, newUser.companyRegistrationNumber, newUser.companyTelephoneNumber,
                newUser.contactMedium, newUser.creditVetDate, newUser.creditVetPassed, newUser.customerType,
                newUser.customerNumber, newUser.dateOfBirth, newUser.attribute6, newUser.attribute7, newUser.domain,
                newUser.forename, newUser.gender, newUser.genevaCustId, newUser.hasBeenBillingContact, newUser.hasHadRole,
                newUser.id, newUser.initials, newUser.isEsmeCustomer, newUser.jobFunction, newUser.jobTitle, newUser.key,
                newUser.lastname, newUser.level2Password, newUser.msisdn, newUser.msisdnValid, newUser.network,
                newUser.noCompanyEmployees, newUser.owningBusinessDivision, newUser.password, newUser.partner, newUser.phoneMake,
                newUser.posBusinessUnit, newUser.referral, newUser.referralDate, newUser.registrationType, newUser.riskThreshold,
                newUser.riskThresholdDate, newUser.saleDate, newUser.sector, newUser.securityQuestion, newUser.securityAnswer,
                newUser.segmentationType, newUser.title, newUser.wantsO2Marketing, newUser.wantsOtherMarketing,
                newUser.modifiedDate, newUser.birthDay, newUser.birthMonth, newUser.birthYear);
    }

    public String getHouseNumber()
    {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber)
    {
        this.houseNumber = houseNumber;
    }

    public String getHouseName()
    {
        return houseName;
    }

    public void setHouseName(String houseName)
    {
        this.houseName = houseName;
    }

    public String getAddressLine1()
    {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1)
    {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2()
    {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2)
    {
        this.addressLine2 = addressLine2;
    }

    public String getTownCity()
    {
        return townCity;
    }

    public void setTownCity(String townCity)
    {
        this.townCity = townCity;
    }

    public String getCounty()
    {
        return county;
    }

    public void setCounty(String county)
    {
        this.county = county;
    }

    public String getPostcode()
    {
        return postcode;
    }

    public void setPostcode(String postcode)
    {
        this.postcode = postcode;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getAddressStatus()
    {
        return addressStatus;
    }

    public void setAddressStatus(String addressStatus)
    {
        this.addressStatus = addressStatus;
    }

    public String getPtCaps()
    {
        return ptCaps;
    }

    public void setPtCaps(String ptCaps)
    {
        this.ptCaps = ptCaps;
    }

    public String getAccountManagerEmail()
    {
        return accountManagerEmail;
    }

    public void setAccountManagerEmail(String accountManagerEmail)
    {
        this.accountManagerEmail = accountManagerEmail;
    }

    public String getAccountManagerName()
    {
        return accountManagerName;
    }

    public void setAccountManagerName(String accountManagerName)
    {
        this.accountManagerName = accountManagerName;
    }

    public String getAlternativeContactNumber()
    {
        return alternativeContactNumber;
    }

    public void setAlternativeContactNumber(String alternativeContactNumber)
    {
        this.alternativeContactNumber = alternativeContactNumber;
    }

    public String getAlternativeEmail()
    {
        if (null != alternativeEmail)
        {
            alternativeEmail = alternativeEmail.toLowerCase();
        }
        return alternativeEmail;
    }

    public void setAlternativeEmail(String alternativeEmail)
    {
        this.alternativeEmail = alternativeEmail;
    }

    public String getCompanyName()
    {
        return companyName;
    }

    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }

    public String getCompanyRegistrationNumber()
    {
        return companyRegistrationNumber;
    }

    public void setCompanyRegistrationNumber(String companyRegistrationNumber)
    {
        this.companyRegistrationNumber = companyRegistrationNumber;
    }

    public String getCompanyTelephoneNumber()
    {
        return companyTelephoneNumber;
    }

    public void setCompanyTelephoneNumber(String companyTelephoneNumber)
    {
        this.companyTelephoneNumber = companyTelephoneNumber;
    }

    public String getContactMedium()
    {
        return contactMedium;
    }

    public void setContactMedium(String contactMedium)
    {
        this.contactMedium = contactMedium;
    }

    public Date getCreditVetDate()
    {
        return creditVetDate;
    }

    public void setCreditVetDate(Date creditVetDate)
    {
        this.creditVetDate = creditVetDate;
    }

    public String getCreditVetPassed()
    {
        return creditVetPassed;
    }

    public void setCreditVetPassed(String creditVetPassed)
    {
        this.creditVetPassed = creditVetPassed;
    }

    public String getCustomerType()
    {
        return customerType;
    }

    public void setCustomerType(String customerType)
    {
        this.customerType = customerType;
    }

    public Integer getCustomerNumber()
    {
        return customerNumber;
    }

    public void setCustomerNumber(Integer customerNumber)
    {
        this.customerNumber = customerNumber;
    }

    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
        if (this.dateOfBirth != null)
        {
            Calendar cal = Calendar.getInstance();
            cal.setTime(getDateOfBirth());
            setBirthDay(cal.get(Calendar.DATE));
            setBirthMonth((cal.get(Calendar.MONTH)) + 1);
            setBirthYear(cal.get(Calendar.YEAR));
        }
    }

    public String getAttribute6()
    {
        return attribute6;
    }

    public void setAttribute6(String attribute6)
    {
        this.attribute6 = attribute6;
    }

    public String getAttribute7()
    {
        return attribute7;
    }

    public void setAttribute7(String attribute7)
    {
        this.attribute7 = attribute7;
    }

    public String getDomain()
    {
        return domain;
    }

    public void setDomain(String domain)
    {
        this.domain = domain;
    }

    public String getForename()
    {
        return forename;
    }

    public void setForename(String forename)
    {
        this.forename = forename;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getGenevaCustId()
    {
        return genevaCustId;
    }

    public void setGenevaCustId(String genevaCustId)
    {
        this.genevaCustId = genevaCustId;
    }

    public boolean getHasBeenBillingContact()
    {
        return hasBeenBillingContact;
    }

    public void setHasBeenBillingContact(boolean hasBeenBillingContact)
    {
        this.hasBeenBillingContact = hasBeenBillingContact;
    }

    public boolean getHasHadRole()
    {
        return hasHadRole;
    }

    public void setHasHadRole(boolean hasHadRole)
    {
        this.hasHadRole = hasHadRole;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getInitials()
    {
        return initials;
    }

    public void setInitials(String initials)
    {
        this.initials = initials;
    }

    public boolean getIsEsmeCustomer()
    {
        return isEsmeCustomer;
    }

    public void setEsmeCustomer(boolean isEsmeCustomer)
    {
        this.isEsmeCustomer = isEsmeCustomer;
    }

    public String getJobFunction()
    {
        return jobFunction;
    }

    public void setJobFunction(String jobFunction)
    {
        this.jobFunction = jobFunction;
    }

    public String getJobTitle()
    {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle)
    {
        this.jobTitle = jobTitle;
    }

    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    public String getLastname()
    {
        return lastname;
    }

    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }

    public String getLevel2Password()
    {
        return level2Password;
    }

    public void setLevel2Password(String level2Password)
    {
        this.level2Password = level2Password;
    }

    public String getMsisdn()
    {
        return msisdn;
    }

    public void setMsisdn(String msisdn)
    {
        this.msisdn = msisdn;
    }

    public String getMsisdnValid()
    {
        return msisdnValid;
    }

    public void setMsisdnValid(String msisdnValid)
    {
        this.msisdnValid = msisdnValid;
    }

    public String getNetwork()
    {
        return network;
    }

    public void setNetwork(String network)
    {
        this.network = network;
    }

    public Integer getNoCompanyEmployees()
    {
        return noCompanyEmployees;
    }

    public void setNoCompanyEmployees(Integer noCompanyEmployees)
    {
        this.noCompanyEmployees = noCompanyEmployees;
    }

    public String getOwningBusinessDivision()
    {
        return owningBusinessDivision;
    }

    public void setOwningBusinessDivision(String owningBusinessDivision)
    {
        this.owningBusinessDivision = owningBusinessDivision;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPartner()
    {
        return partner;
    }

    public void setPartner(String partner)
    {
        this.partner = partner;
    }

    public String getPhoneMake()
    {
        return phoneMake;
    }

    public void setPhoneMake(String phoneMake)
    {
        this.phoneMake = phoneMake;
    }

    public String getPosBusinessUnit()
    {
        return posBusinessUnit;
    }

    public void setPosBusinessUnit(String posBusinessUnit)
    {
        this.posBusinessUnit = posBusinessUnit;
    }

    public String getReferral()
    {
        return referral;
    }

    public void setReferral(String referral)
    {
        this.referral = referral;
    }

    public Date getReferralDate()
    {
        return referralDate;
    }

    public void setReferralDate(Date referralDate)
    {
        this.referralDate = referralDate;
    }

    public String getRegistrationType()
    {
        return registrationType;
    }

    public void setRegistrationType(String registrationType)
    {
        this.registrationType = registrationType;
    }

    public Integer getRiskThreshold()
    {
        return riskThreshold;
    }

    public void setRiskThreshold(Integer riskThreshold)
    {
        this.riskThreshold = riskThreshold;
    }

    public Date getRiskThresholdDate()
    {
        return riskThresholdDate;
    }

    public void setRiskThresholdDate(Date riskThresholdDate)
    {
        this.riskThresholdDate = riskThresholdDate;
    }

    public Date getSaleDate()
    {
        return saleDate;
    }

    public void setSaleDate(Date saleDate)
    {
        this.saleDate = saleDate;
    }

    public String getSector()
    {
        return sector;
    }

    public void setSector(String sector)
    {
        this.sector = sector;
    }

    public String getSecurityQuestion()
    {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion)
    {
        this.securityQuestion = securityQuestion;
    }

    public String getSecurityAnswer()
    {
        return securityAnswer;
    }

    public void setSecurityAnswer(String securityAnswer)
    {
        this.securityAnswer = securityAnswer;
    }

    public String getSegmentationType()
    {
        return segmentationType;
    }

    public void setSegmentationType(String segmentationType)
    {
        this.segmentationType = segmentationType;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public boolean getWantsO2Marketing()
    {
        return wantsO2Marketing;
    }

    public void setWantsO2Marketing(boolean wantsO2Marketing)
    {
        this.wantsO2Marketing = wantsO2Marketing;
    }

    public boolean getWantsOtherMarketing()
    {
        return wantsOtherMarketing;
    }

    public void setWantsOtherMarketing(boolean wantsOtherMarketing)
    {
        this.wantsOtherMarketing = wantsOtherMarketing;
    }

    public Timestamp getModifiedDate()
    {
        return modifiedDate;
    }

    public void setModifiedDate(Timestamp modifiedDate)
    {
        this.modifiedDate = modifiedDate;
    }

    public int getBirthDay()
    {
        return birthDay;
    }

    public void setBirthDay(int birthDay)
    {
        this.birthDay = birthDay;
    }

    public int getBirthMonth()
    {
        return birthMonth;
    }

    public void setBirthMonth(int birthMonth)
    {
        this.birthMonth = birthMonth;
    }

    public int getBirthYear()
    {
        return birthYear;
    }

    public void setBirthYear(int birthYear)
    {
        this.birthYear = birthYear;
    }

    public void setDateOfBirth(int day, int month, int year)
    {
        try
        {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date dateOfBirth = formatter.parse(day + "/" + month + "/" + year);
            setDateOfBirth(dateOfBirth);
        } catch (ParseException pe)
        {
            log.error("Error creating a Date object for Date Of Birth. " + "Root error - " + pe.getMessage());
        }
    }

    public String getGenderText()
    {
        if (getGender() != null)
        {
            if ("M".equalsIgnoreCase(getGender()))
                return GENDER_MALE_TEXT;
            else if ("F".equalsIgnoreCase(getGender()))
                return GENDER_FEMALE_TEXT;
            else
                return GENDER_UNKNOWN_TEXT;
        }
        return GENDER_UNKNOWN_TEXT;
    }

    public void applyUpdates(UserTO newUserTO)
    {
        crossPopulate( newUserTO );
    }

    /**
     * 
     * This method copies all non-null fields from the new UserVO to this one. Null fields are considered not to have been
     * udpated. Primitives are always updated
     * 
     * @param newUserTO
     */
    private void crossPopulate(UserTO newUserTO)
    {
        log.info( "crossPopulate start." );

        try
        {
            Class myClass = Class.forName("com.o2.finance.model.UserTO");
            Field[] myFields = myClass.getDeclaredFields();
            Class fieldClass;
            for (int i = 0; i < myFields.length; i++)
            {
                fieldClass = myFields[i].getType();
                if (Modifier.isFinal(myFields[i].getModifiers()) == false)
                {
                    if (fieldClass.isPrimitive())
                    {
                        myFields[i].set(this, myFields[i].get(newUserTO));
                    } else if (myFields[i].get(newUserTO) != null)
                    {
                        myFields[i].set(this, myFields[i].get(newUserTO));
                    }
                }
            }
        } catch (IllegalAccessException ie)
        {
            log.error("[UserTO.crossPopulate] IllegalAccessException - " + ie.getMessage(), ie);
        } catch (ClassNotFoundException ce)
        {
            log.error("[UserTO.crossPopulate] IllegalAccessException - " + ce.getMessage(), ce);
        }

        log.info( "crossPopulate ends." );

    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((houseNumber == null) ? 0 : houseNumber.hashCode());
        result = prime * result + ((houseName == null) ? 0 : houseName.hashCode());
        result = prime * result + ((addressLine1 == null) ? 0 : addressLine1.hashCode());
        result = prime * result + ((addressLine2 == null) ? 0 : addressLine2.hashCode());
        result = prime * result + ((townCity == null) ? 0 : townCity.hashCode());
        result = prime * result + ((county == null) ? 0 : county.hashCode());
        result = prime * result + ((postcode == null) ? 0 : postcode.hashCode());
        result = prime * result + ((country == null) ? 0 : country.hashCode());
        result = prime * result + ((addressStatus == null) ? 0 : addressStatus.hashCode());
        result = prime * result + ((ptCaps == null) ? 0 : ptCaps.hashCode());
        result = prime * result + ((accountManagerEmail == null) ? 0 : accountManagerEmail.hashCode());
        result = prime * result + ((accountManagerName == null) ? 0 : accountManagerName.hashCode());
        result = prime * result + ((alternativeContactNumber == null) ? 0 : alternativeContactNumber.hashCode());
        result = prime * result + ((alternativeEmail == null) ? 0 : alternativeEmail.hashCode());
        result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
        result = prime * result + ((companyRegistrationNumber == null) ? 0 : companyRegistrationNumber.hashCode());
        result = prime * result + ((companyTelephoneNumber == null) ? 0 : companyTelephoneNumber.hashCode());
        result = prime * result + ((contactMedium == null) ? 0 : contactMedium.hashCode());
        result = prime * result + ((creditVetDate == null) ? 0 : creditVetDate.hashCode());
        result = prime * result + ((creditVetPassed == null) ? 0 : creditVetPassed.hashCode());
        result = prime * result + ((customerType == null) ? 0 : customerType.hashCode());
        result = prime * result + ((customerNumber == null) ? 0 : customerNumber.hashCode());
        result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
        result = prime * result + ((attribute6 == null) ? 0 : attribute6.hashCode());
        result = prime * result + ((attribute7 == null) ? 0 : attribute7.hashCode());
        result = prime * result + ((domain == null) ? 0 : domain.hashCode());
        result = prime * result + ((forename == null) ? 0 : forename.hashCode());
        result = prime * result + ((gender == null) ? 0 : gender.hashCode());
        result = prime * result + ((genevaCustId == null) ? 0 : genevaCustId.hashCode());
        result = prime * result
                + ((new Boolean(hasBeenBillingContact) == null) ? 0 : new Boolean(hasBeenBillingContact).hashCode());
        result = prime * result + ((new Boolean(hasHadRole) == null) ? 0 : new Boolean(hasHadRole).hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((initials == null) ? 0 : initials.hashCode());
        result = prime * result + ((new Boolean(isEsmeCustomer) == null) ? 0 : new Boolean(isEsmeCustomer).hashCode());
        result = prime * result + ((jobFunction == null) ? 0 : jobFunction.hashCode());
        result = prime * result + ((jobTitle == null) ? 0 : jobTitle.hashCode());
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
        result = prime * result + ((level2Password == null) ? 0 : level2Password.hashCode());
        result = prime * result + ((msisdn == null) ? 0 : msisdn.hashCode());
        result = prime * result + ((msisdnValid == null) ? 0 : msisdnValid.hashCode());
        result = prime * result + ((network == null) ? 0 : network.hashCode());
        result = prime * result + ((noCompanyEmployees == null) ? 0 : noCompanyEmployees.hashCode());
        result = prime * result + ((owningBusinessDivision == null) ? 0 : owningBusinessDivision.hashCode());
        result = prime * result + ((partner == null) ? 0 : partner.hashCode());
        result = prime * result + ((phoneMake == null) ? 0 : phoneMake.hashCode());
        result = prime * result + ((posBusinessUnit == null) ? 0 : posBusinessUnit.hashCode());
        result = prime * result + ((referral == null) ? 0 : referral.hashCode());
        result = prime * result + ((referralDate == null) ? 0 : referralDate.hashCode());
        result = prime * result + ((registrationType == null) ? 0 : registrationType.hashCode());
        result = prime * result + ((riskThreshold == null) ? 0 : riskThreshold.hashCode());
        result = prime * result + ((riskThresholdDate == null) ? 0 : riskThresholdDate.hashCode());
        result = prime * result + ((saleDate == null) ? 0 : saleDate.hashCode());
        result = prime * result + ((sector == null) ? 0 : sector.hashCode());
        result = prime * result + ((securityQuestion == null) ? 0 : securityQuestion.hashCode());
        result = prime * result + ((securityAnswer == null) ? 0 : securityAnswer.hashCode());
        result = prime * result + ((segmentationType == null) ? 0 : segmentationType.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((new Boolean(wantsO2Marketing) == null) ? 0 : new Boolean(wantsO2Marketing).hashCode());
        result = prime * result + ((new Boolean(wantsOtherMarketing) == null) ? 0 : new Boolean(wantsOtherMarketing).hashCode());
        result = prime * result + ((modifiedDate == null) ? 0 : modifiedDate.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserTO other = (UserTO) obj;
        if (houseNumber == null)
        {
            if (other.getHouseNumber() != null)
                return false;
        } else if (!houseNumber.equals(other.getHouseNumber()))
        {
            return false;
        }
        if (houseName == null)
        {
            if (other.getHouseName() != null)
                return false;
        } else if (!houseName.equals(other.getHouseName()))
        {
            return false;
        }
        if (addressLine1 == null)
        {
            if (other.getAddressLine1() != null)
                return false;
        } else if (!addressLine1.equals(other.getAddressLine1()))
        {
            return false;
        }
        if (addressLine2 == null)
        {
            if (other.getAddressLine2() != null)
                return false;
        } else if (!addressLine2.equals(other.getAddressLine2()))
        {
            return false;
        }
        if (townCity == null)
        {
            if (other.getTownCity() != null)
                return false;
        } else if (!townCity.equals(other.getTownCity()))
        {
            return false;
        }
        if (county == null)
        {
            if (other.getCounty() != null)
                return false;
        } else if (!county.equals(other.getCounty()))
        {
            return false;
        }
        if (postcode == null)
        {
            if (other.getPostcode() != null)
                return false;
        } else if (!postcode.equals(other.getPostcode()))
        {
            return false;
        }
        if (country == null)
        {
            if (other.getCountry() != null)
                return false;
        } else if (!country.equals(other.getCountry()))
        {
            return false;
        }
        if (addressStatus == null)
        {
            if (other.getAddressStatus() != null)
                return false;
        } else if (!addressStatus.equals(other.getAddressStatus()))
        {
            return false;
        }
        if (ptCaps == null)
        {
            if (other.getPtCaps() != null)
                return false;
        } else if (!ptCaps.equals(other.getPtCaps()))
        {
            return false;
        }
        if (accountManagerEmail == null)
        {
            if (other.getAccountManagerEmail() != null)
                return false;
        } else if (!accountManagerEmail.equals(other.getAccountManagerEmail()))
        {
            return false;
        }
        if (accountManagerName == null)
        {
            if (other.getAccountManagerName() != null)
                return false;
        } else if (!accountManagerName.equals(other.getAccountManagerName()))
        {
            return false;
        }
        if (alternativeContactNumber == null)
        {
            if (other.getAlternativeContactNumber() != null)
                return false;
        } else if (!alternativeContactNumber.equals(other.getAlternativeContactNumber()))
        {
            return false;
        }
        if (alternativeEmail == null)
        {
            if (other.getAlternativeEmail() != null)
                return false;
        } else if (!alternativeEmail.equals(other.getAlternativeEmail()))
        {
            return false;
        }
        if (companyName == null)
        {
            if (other.getCompanyName() != null)
                return false;
        } else if (!companyName.equals(other.getCompanyName()))
        {
            return false;
        }
        if (companyRegistrationNumber == null)
        {
            if (other.getCompanyRegistrationNumber() != null)
                return false;
        } else if (!companyRegistrationNumber.equals(other.getCompanyRegistrationNumber()))
        {
            return false;
        }
        if (companyTelephoneNumber == null)
        {
            if (other.getCompanyTelephoneNumber() != null)
                return false;
        } else if (!companyTelephoneNumber.equals(other.getCompanyTelephoneNumber()))
        {
            return false;
        }
        if (contactMedium == null)
        {
            if (other.getContactMedium() != null)
                return false;
        } else if (!contactMedium.equals(other.getContactMedium()))
        {
            return false;
        }
        if (creditVetDate == null)
        {
            if (other.getCreditVetDate() != null)
                return false;
        } else if (!creditVetDate.equals(other.getCreditVetDate()))
        {
            return false;
        }
        if (creditVetPassed == null)
        {
            if (other.getCreditVetPassed() != null)
                return false;
        } else if (!creditVetPassed.equals(other.getCreditVetPassed()))
        {
            return false;
        }
        if (customerType == null)
        {
            if (other.getCustomerType() != null)
                return false;
        } else if (!customerType.equals(other.getCustomerType()))
        {
            return false;
        }
        if (customerNumber == null)
        {
            if (other.getCustomerNumber() != null)
                return false;
        } else if (!customerNumber.equals(other.getCustomerNumber()))
        {
            return false;
        }
        if (dateOfBirth == null)
        {
            if (other.getDateOfBirth() != null)
                return false;
        } else if (!dateOfBirth.equals(other.getDateOfBirth()))
        {
            return false;
        }
        if (attribute6 == null)
        {
            if (other.getAttribute6() != null)
                return false;
        } else if (!attribute6.equals(other.getAttribute6()))
        {
            return false;
        }
        if (attribute7 == null)
        {
            if (other.getAttribute7() != null)
                return false;
        } else if (!attribute7.equals(other.getAttribute7()))
        {
            return false;
        }
        if (domain == null)
        {
            if (other.getDomain() != null)
                return false;
        } else if (!domain.equals(other.getDomain()))
        {
            return false;
        }
        if (forename == null)
        {
            if (other.getForename() != null)
                return false;
        } else if (!forename.equals(other.getForename()))
        {
            return false;
        }
        if (gender == null)
        {
            if (other.getForename() != null)
                return false;
        } else if (!gender.equals(other.getForename()))
        {
            return false;
        }
        if (genevaCustId == null)
        {
            if (other.getGenevaCustId() != null)
                return false;
        } else if (!genevaCustId.equals(other.getGenevaCustId()))
        {
            return false;
        }
        if (hasBeenBillingContact == false)
        {
            if (other.getHasBeenBillingContact() != false)
                return false;
        } else if (hasBeenBillingContact == true)
        {
            if (other.getHasBeenBillingContact() != true)
                return false;
        }
        if (hasHadRole == false)
        {
            if (other.getHasHadRole() != false)
                return false;
        } else if (hasHadRole == true)
        {
            if (other.getHasHadRole() != true)
                return false;
        }
        if (id == null)
        {
            if (other.getId() != null)
                return false;
        } else if (!id.equals(other.getId()))
        {
            return false;
        }
        if (initials == null)
        {
            if (other.getInitials() != null)
                return false;
        } else if (!initials.equals(other.getInitials()))
        {
            return false;
        }
        if (isEsmeCustomer == false)
        {
            if (other.getIsEsmeCustomer() != false)
                return false;
        } else if (isEsmeCustomer == true)
        {
            if (other.getIsEsmeCustomer() != true)
                return false;
        }
        if (jobFunction == null)
        {
            if (other.getJobFunction() != null)
                return false;
        } else if (!jobFunction.equals(other.getJobFunction()))
        {
            return false;
        }
        if (jobTitle == null)
        {
            if (other.getJobTitle() != null)
                return false;
        } else if (!jobTitle.equals(other.getJobTitle()))
        {
            return false;
        }
        if (key == null)
        {
            if (other.getKey() != null)
                return false;
        } else if (!key.equals(other.getKey()))
        {
            return false;
        }
        if (lastname == null)
        {
            if (other.getLastname() != null)
                return false;
        } else if (!lastname.equals(other.getLastname()))
        {
            return false;
        }
        if (level2Password == null)
        {
            if (other.getLevel2Password() != null)
                return false;
        } else if (!level2Password.equals(other.getLevel2Password()))
        {
            return false;
        }
        if (msisdn == null)
        {
            if (other.getMsisdn() != null)
                return false;
        } else if (!msisdn.equals(other.getMsisdn()))
        {
            return false;
        }
        if (msisdnValid == null)
        {
            if (other.getMsisdnValid() != null)
                return false;
        } else if (!msisdnValid.equals(other.getMsisdnValid()))
        {
            return false;
        }
        if (network == null)
        {
            if (other.getNetwork() != null)
                return false;
        } else if (!network.equals(other.getNetwork()))
        {
            return false;
        }
        if (noCompanyEmployees == null)
        {
            if (other.getNoCompanyEmployees() != null)
                return false;
        } else if (!noCompanyEmployees.equals(other.getNoCompanyEmployees()))
        {
            return false;
        }
        if (owningBusinessDivision == null)
        {
            if (other.getOwningBusinessDivision() != null)
                return false;
        } else if (!owningBusinessDivision.equals(other.getOwningBusinessDivision()))
        {
            return false;
        }
        if (password == null)
        {
            if (other.getPassword() != null)
                return false;
        } else if (!password.equals(other.getPassword()))
        {
            return false;
        }
        if (partner == null)
        {
            if (other.getPartner() != null)
                return false;
        } else if (!partner.equals(other.getPartner()))
        {
            return false;
        }
        if (phoneMake == null)
        {
            if (other.getPhoneMake() != null)
                return false;
        } else if (!phoneMake.equals(other.getPhoneMake()))
        {
            return false;
        }
        if (posBusinessUnit == null)
        {
            if (other.getPosBusinessUnit() != null)
                return false;
        } else if (!posBusinessUnit.equals(other.getPosBusinessUnit()))
        {
            return false;
        }
        if (referral == null)
        {
            if (other.getReferral() != null)
                return false;
        } else if (!referral.equals(other.getReferral()))
        {
            return false;
        }
        if (referralDate == null)
        {
            if (other.getReferralDate() != null)
                return false;
        } else if (!referralDate.equals(other.getReferralDate()))
        {
            return false;
        }
        if (registrationType == null)
        {
            if (other.getRegistrationType() != null)
                return false;
        } else if (!registrationType.equals(other.getRegistrationType()))
        {
            return false;
        }
        if (riskThreshold == null)
        {
            if (other.getRiskThreshold() != null)
                return false;
        } else if (!riskThreshold.equals(other.getRiskThreshold()))
        {
            return false;
        }
        if (riskThresholdDate == null)
        {
            if (other.getRiskThresholdDate() != null)
                return false;
        } else if (!riskThresholdDate.equals(other.getRiskThresholdDate()))
        {
            return false;
        }
        if (saleDate == null)
        {
            if (other.getSaleDate() != null)
                return false;
        } else if (!saleDate.equals(other.getSaleDate()))
        {
            return false;
        }
        if (sector == null)
        {
            if (other.getSector() != null)
                return false;
        } else if (!sector.equals(other.getSector()))
        {
            return false;
        }
        if (securityQuestion == null)
        {
            if (other.getSecurityQuestion() != null)
                return false;
        } else if (!securityQuestion.equals(other.getSecurityQuestion()))
        {
            return false;
        }
        if (securityAnswer == null)
        {
            if (other.getSecurityAnswer() != null)
                return false;
        } else if (!securityAnswer.equals(other.getSecurityAnswer()))
        {
            return false;
        }
        if (segmentationType == null)
        {
            if (other.getSegmentationType() != null)
                return false;
        } else if (!segmentationType.equals(other.getSegmentationType()))
        {
            return false;
        }
        if (title == null)
        {
            if (other.getTitle() != null)
                return false;
        } else if (!title.equals(other.getTitle()))
        {
            return false;
        }
        if (modifiedDate == null)
        {
            if (other.getModifiedDate() != null)
                return false;
        } else if (!modifiedDate.equals(other.getModifiedDate()))
        {
            return false;
        }
        if (wantsO2Marketing == false)
        {
            if (other.getWantsO2Marketing() != false)
                return false;
        } else if (wantsO2Marketing == true)
        {
            if (other.getWantsO2Marketing() != true)
                return false;
        }
        if (wantsOtherMarketing == false)
        {
            if (other.getWantsOtherMarketing() != false)
                return false;
        } else if (wantsOtherMarketing == true)
        {
            if (other.getWantsOtherMarketing() != true)
                return false;
        }
        return true;
    }


    public String toString()
    {
        return "UserTO{" +
                "accountManagerEmail='" + accountManagerEmail + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", houseName='" + houseName + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", townCity='" + townCity + '\'' +
                ", county='" + county + '\'' +
                ", postcode='" + postcode + '\'' +
                ", country='" + country + '\'' +
                ", addressStatus='" + addressStatus + '\'' +
                ", ptCaps='" + ptCaps + '\'' +
                ", accountManagerName='" + accountManagerName + '\'' +
                ", alternativeContactNumber='" + alternativeContactNumber + '\'' +
                ", alternativeEmail='" + alternativeEmail + '\'' +
                ", companyName='" + companyName + '\'' +
                ", companyRegistrationNumber='" + companyRegistrationNumber + '\'' +
                ", companyTelephoneNumber='" + companyTelephoneNumber + '\'' +
                ", contactMedium='" + contactMedium + '\'' +
                ", creditVetDate=" + creditVetDate +
                ", creditVetPassed='" + creditVetPassed + '\'' +
                ", customerType='" + customerType + '\'' +
                ", customerNumber=" + customerNumber +
                ", dateOfBirth=" + dateOfBirth +
                ", attribute6='" + attribute6 + '\'' +
                ", attribute7='" + attribute7 + '\'' +
                ", domain='" + domain + '\'' +
                ", forename='" + forename + '\'' +
                ", gender='" + gender + '\'' +
                ", genevaCustId='" + genevaCustId + '\'' +
                ", hasBeenBillingContact=" + hasBeenBillingContact +
                ", hasHadRole=" + hasHadRole +
                ", id='" + id + '\'' +
                ", initials='" + initials + '\'' +
                ", isEsmeCustomer=" + isEsmeCustomer +
                ", jobFunction='" + jobFunction + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", key='" + key + '\'' +
                ", lastname='" + lastname + '\'' +
                ", level2Password='" + level2Password + '\'' +
                ", msisdn='" + msisdn + '\'' +
                ", msisdnValid='" + msisdnValid + '\'' +
                ", network='" + network + '\'' +
                ", noCompanyEmployees=" + noCompanyEmployees +
                ", owningBusinessDivision='" + owningBusinessDivision + '\'' +
                ", password='" + password + '\'' +
                ", partner='" + partner + '\'' +
                ", phoneMake='" + phoneMake + '\'' +
                ", posBusinessUnit='" + posBusinessUnit + '\'' +
                ", referral='" + referral + '\'' +
                ", referralDate=" + referralDate +
                ", registrationType='" + registrationType + '\'' +
                ", riskThreshold=" + riskThreshold +
                ", riskThresholdDate=" + riskThresholdDate +
                ", saleDate=" + saleDate +
                ", sector='" + sector + '\'' +
                ", securityQuestion='" + securityQuestion + '\'' +
                ", securityAnswer='" + securityAnswer + '\'' +
                ", segmentationType='" + segmentationType + '\'' +
                ", title='" + title + '\'' +
                ", wantsO2Marketing=" + wantsO2Marketing +
                ", wantsOtherMarketing=" + wantsOtherMarketing +
                ", modifiedDate=" + modifiedDate +
                ", birthDay=" + birthDay +
                ", birthMonth=" + birthMonth +
                ", birthYear=" + birthYear +
                '}';
    }
}
