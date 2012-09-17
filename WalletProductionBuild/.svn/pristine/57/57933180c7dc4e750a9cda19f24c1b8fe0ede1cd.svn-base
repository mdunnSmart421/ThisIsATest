package com.o2.finance.taglib;

/**
 * Tag library to access Verification Code Maximum Delay set in properties file
 * 
 * SendVerificationCodeWait
 * 
 */
public class SendVerificationCodeWait extends ProductRegistrationTag
{
    private static final long serialVersionUID = 1L;
    private static final String PROPERTY_FILE = "/finance/application.properties";
    private static final String MAX_WAIT_MINUTES = "verification.code.max.wait.minutes";

    protected String getPropertyFileName()
    {
        return PROPERTY_FILE;
    }

    protected String getProtocol()
    {
        return "";
    }

    protected String getUri()
    {
        return MAX_WAIT_MINUTES;
    }

    protected String buildOutString(String protocol, String uri)
    {
        return getUri();
    }
}
