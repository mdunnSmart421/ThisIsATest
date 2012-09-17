package com.o2.finance.beans;

/**
 * Purpose: com.o2.finance.beans User: D Smith Date: 22/05/2011
 */
public class EnterOtacForm
{
    private String msisdn;
    private String verificationCode;

    /**
     * @return the verificationCode
     */
    public String getVerificationCode()
    {
        return verificationCode;
    }

    /**
     * @param verificationCode
     *            the verificationCode to set
     */
    public void setVerificationCode(String verificationCode)
    {
        this.verificationCode = verificationCode;
    }

    /**
     * @return the msisdn
     */
    public String getMsisdn()
    {
        return msisdn;
    }

    /**
     * @param msisdn
     *            the msisdn to set
     */
    public void setMsisdn(String msisdn)
    {
        this.msisdn = msisdn;
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
        result = prime * result + ((msisdn == null) ? 0 : msisdn.hashCode());
        result = prime * result + ((verificationCode == null) ? 0 : verificationCode.hashCode());
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
        EnterOtacForm other = (EnterOtacForm) obj;
        if (msisdn == null)
        {
            if (other.msisdn != null)
                return false;
        } else if (!msisdn.equals(other.msisdn))
            return false;
        if (verificationCode == null)
        {
            if (other.verificationCode != null)
                return false;
        } else if (!verificationCode.equals(other.verificationCode))
            return false;
        return true;
    }
}
