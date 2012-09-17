package com.o2.finance.exception;

/**
 * Purpose: com.o2.finance.exception User: D Smith Date: 13/06/2011
 */
public class FinanceServiceVerificationCodeTriesExceededException extends FinanceServiceException
{
    private static final long serialVersionUID = -7759024979299733268L;
    private String faultString;
    private String faultCode;
    private String faultDetail;

    public FinanceServiceVerificationCodeTriesExceededException(String faultCode, String faultString, String faultDetail)
    {
        super(faultString);
        this.faultString = faultString;
        this.faultCode = faultCode;
        this.faultDetail = faultDetail;
    }

    public String getFaultCode()
    {
        return faultCode;
    }

    public String getFaultDetail()
    {
        return faultDetail;
    }

    public String getFaultString()
    {
        return faultString;
    }
}
