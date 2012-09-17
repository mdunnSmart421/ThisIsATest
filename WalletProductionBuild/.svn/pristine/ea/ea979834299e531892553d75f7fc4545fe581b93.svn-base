package com.o2.finance.properties;

/**
 * @author SWatson
 * 
 */
public class FeedbackProperties extends FinanceProperties
{
    private static final String FILE_LOCATION = "/finance/feedback.properties";
    private static final String MESSAGE_OTAC_RESEND = "otac.sent.new.verification.code.to.msisdn";
    private static final String MESSAGE_OTAC_REQUESTS_EXCEEDED = "otac.verification.code.exceeded.mobile.number";
    private static final String MESSAGE_OTAC_INCORRECT = "otac.verification.code.entered.not.match.sent.your.mobile";
    private static final String MESSAGE_BARRED_MSISDN = "registration.failed.barred.msisdn";
    private static final String MESSAGE_MAX_SECONDARY_ACCOUNTS_LIMIT_REACHED = "registration.failed.max.secondary.accounts.limit.reached";
    private static final String MESSAGE_USERNAME_ALREADY_EXISTS = "registration.failed.user.username.already.exists";
    private static final String MESSAGE_INVALID_PRODUCT_ID = "invalid.product.id";
    private static final String MESSAGE_MISSING_PRODUCT_ID = "missing.product.id";
    private static final String SEARCH_SERVICE_IDENTITY_LIMIT_EXCEEDED = "search.service.identity.limit.exceeded";
    

    protected String getPropertyFile()
    {
        return FILE_LOCATION;
    }

    public String getOtacResendMessage()
    {
        return getProperty(MESSAGE_OTAC_RESEND);
    }

    public String getOtacRequestsExceededMessage()
    {
        return getProperty(MESSAGE_OTAC_REQUESTS_EXCEEDED);
    }

    public String getOtacIncorrectMessage()
    {
        return getProperty(MESSAGE_OTAC_INCORRECT);
    }

    public String getMsisdnBarredMessage()
    {
        return getProperty(MESSAGE_BARRED_MSISDN);
    }

    public String getMaxSecondaryAccsReachedMessage()
    {
        return getProperty(MESSAGE_MAX_SECONDARY_ACCOUNTS_LIMIT_REACHED);
    }

    public String getUsernameExistsMessage()
    {
        return getProperty(MESSAGE_USERNAME_ALREADY_EXISTS);
    }

    public String getMissingProductIdMessage()
    {
        return getProperty(MESSAGE_MISSING_PRODUCT_ID);
    }

    public String getInvalidProductIdMessage()
    {
        return getProperty(MESSAGE_INVALID_PRODUCT_ID);
    }
    
    public String getSearchServiceIdentityLimitExceededMessage()
    {
        return getProperty(SEARCH_SERVICE_IDENTITY_LIMIT_EXCEEDED);
    }
    
}
