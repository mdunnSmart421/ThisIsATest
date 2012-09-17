/**
 *
 */
package com.o2.finance.properties;

/**
 * @author D Smith
 */
public class ValidationRegexProperties extends FinanceProperties
{
    private static final String FILE_LOCATION = "/finance/validation-rules.properties";
    private static final String MSISDN = "msisdnRegex";
    private static final String OTAC = "otacRegex";
    private static final String FIRSTNAME = "firstNameRegex";
    private static final String LASTNAME = "lastNameRegex";
    private static final String HOUSE_NAME = "houseNameRegex";
    private static final String POSTCODE = "postcodeRegex";

    private static final String BIRTH_DAY = "birthDayRegex";
    private static final String BIRTH_MONTH = "birthMonthRegex";
    private static final String BIRTH_YEAR = "birthYearRegex";

    private static final String USERNAME = "usernameRegex";
    private static final String PASSWORD = "passwordRegex";
    private static final String SECURITY_QUESTION = "securityQuestionRegex";
    private static final String SECURITY_ANSWER = "securityAnswerRegex";
    private static final String EMAIL = "emailRegex";
    private static final String NUMBER_REGEX = "numberRegex";
    private static final String HOUSENUMBER = NUMBER_REGEX;

    private static final String MOBILE_MAKE = "mobileMakeRegex";
    private static final String EMAIL_COMMON_REGEX = "emailCommonRegex";
    
    private static final String LEGACY_YEARS_IN_PAST = "legacyYearsInPast";
    

    protected String getPropertyFile()
    {
        return FILE_LOCATION;
    }

    public String getNumberRegex()
    {
        return getProperty(NUMBER_REGEX);
    }

    public String getHouseNumberRegex()
    {
        return getProperty(HOUSENUMBER);
    }

    public String getBirthDayRegex()
    {
        return getProperty(BIRTH_DAY);
    }

    public String getMobileMakeRegex()
    {
        return getProperty(MOBILE_MAKE);
    }

    public String getBirthMonthRegex()
    {
        return getProperty(BIRTH_MONTH);
    }

    public String getBirthYearRegex()
    {
        return getProperty(BIRTH_YEAR);
    }

    public String getEmailRegex()
    {
        return getProperty(EMAIL);
    }

    public String getFirstNameRegex()
    {
        return getProperty(FIRSTNAME);
    }

    public String getHouseNameRegex()
    {
        return getProperty(HOUSE_NAME);
    }

    public String getLastNameRegex()
    {
        return getProperty(LASTNAME);
    }

    public String getMsisdnRegex()
    {
        return getProperty(MSISDN);
    }

    public String getOtacRegex()
    {
        return getProperty(OTAC);
    }

    public String getPasswordRegex()
    {
        return getProperty(PASSWORD);
    }

    public String getPostCodeRegex()
    {
        return getProperty(POSTCODE);
    }

    public String getEmailCommonRegex()
    {
        return getProperty(EMAIL_COMMON_REGEX);
    }

    public String getSecurityAnswerRegex()
    {
        return getProperty(SECURITY_ANSWER);
    }

    public String getSecurityQuestionRegex()
    {
        return getProperty(SECURITY_QUESTION);
    }

    public String getUsernameRegex()
    {
        return getProperty(USERNAME);
    }
    
    public int getLegacyYearsInPast()
    {
        return getIntProperty(LEGACY_YEARS_IN_PAST);
    }
    
}
