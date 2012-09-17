/**
 * 
 */
package com.o2.finance.exception;

/**
 * @author ccoe
 *
 */
public class FinanceServiceSLMBreachException extends FinanceServiceException
{
    private static final long serialVersionUID = -4402014651276481664L;
    
    private String faultString;
    private String faultCode;
    private String faultDetail;
    
    public FinanceServiceSLMBreachException(String faultCode, String faultString, String faultDetail)
    {
        super(faultString);
        this.faultString = faultString;
        this.faultCode = faultCode;
        this.faultDetail = faultDetail;
    }
    
    /**
     * @return the faultString
     */
    public String getFaultString()
    {
        return faultString;
    }

    /**
     * @param faultString the faultString to set
     */
    public void setFaultString(String faultString)
    {
        this.faultString = faultString;
    }

    /**
     * @return the faultCode
     */
    public String getFaultCode()
    {
        return faultCode;
    }

    /**
     * @param faultCode the faultCode to set
     */
    public void setFaultCode(String faultCode)
    {
        this.faultCode = faultCode;
    }

    /**
     * @return the faultDetail
     */
    public String getFaultDetail()
    {
        return faultDetail;
    }

    /**
     * @param faultDetail the faultDetail to set
     */
    public void setFaultDetail(String faultDetail)
    {
        this.faultDetail = faultDetail;
    }
}
