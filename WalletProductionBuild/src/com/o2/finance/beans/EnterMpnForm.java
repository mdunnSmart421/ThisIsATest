package com.o2.finance.beans;

/**
 * Purpose: com.o2.finance.beans User: D Smith Date: 21/05/2011
 */
public class EnterMpnForm
{
    private String msisdn;
    private String newMsisdn;
    private boolean resentRequest;

    public EnterMpnForm()
    {
    }

    public EnterMpnForm(String msisdn)
    {
        this(msisdn, null, false);
    }

    /**
     * @param msisdn
     * @param resentRequest
     */
    public EnterMpnForm(String msisdn, boolean resentRequest)
    {
        this(msisdn, null, resentRequest);
    }

    /**
     * @param msisdn
     * @param newMsisdn
     * @param resentRequest
     */
    public EnterMpnForm(String msisdn, String newMsisdn, boolean resentRequest)
    {
        this.msisdn = msisdn;
        this.newMsisdn = newMsisdn;
        this.resentRequest = resentRequest;
    }

    public String getMsisdn()
    {
        return msisdn != null ? msisdn.trim() : "";
    }

    public void setMsisdn(String msisdn)
    {
        this.msisdn = msisdn;
    }

    /**
     * @return the newMsisdn
     */
    public String getNewMsisdn()
    {
        return newMsisdn != null ? newMsisdn.trim() : "";
    }

    /**
     * @param newMsisdn
     *            the newMsisdn to set
     */
    public void setNewMsisdn(String newMsisdn)
    {
        this.newMsisdn = newMsisdn;
    }

    /**
     * @return the resentRequest
     */
    public boolean isResentRequest()
    {
        return resentRequest;
    }

    /**
     * @param resentRequest
     *            the resentRequest to set
     */
    public void setResentRequest(boolean resentRequest)
    {
        this.resentRequest = resentRequest;
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
        result = prime * result + ((msisdn == null) ? 0 : msisdn.trim().hashCode());
        result = prime * result + ((newMsisdn == null) ? 0 : newMsisdn.trim().hashCode());
        result = prime * result + (resentRequest ? 1231 : 1237);
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
        EnterMpnForm other = (EnterMpnForm) obj;
        if (msisdn == null)
        {
            if (other.msisdn != null)
                return false;
        } else if (!msisdn.equals(other.msisdn))
            return false;
        if (newMsisdn == null)
        {
            if (other.newMsisdn != null)
                return false;
        } else if (!newMsisdn.equals(other.newMsisdn))
            return false;
        if (resentRequest != other.resentRequest)
            return false;
        return true;
    }
}
