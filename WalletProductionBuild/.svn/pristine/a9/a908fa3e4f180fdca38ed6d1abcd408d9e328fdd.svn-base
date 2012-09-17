package com.o2.finance.beans;

public class StoredUserDetailsBean
{
    private String storedMsisdn;
    private String productName;
    private String productId;
    private String existingUsername;

    public StoredUserDetailsBean()
    {
    }

    /**
     * @param storedMsisdn
     * @param productName
     * @param productId
     * @param existingUsername
     */
    public StoredUserDetailsBean(String storedMsisdn, String productName, String productId, String existingUsername)
    {
        this.storedMsisdn = storedMsisdn;
        this.productName = productName;
        this.productId = productId;
        this.existingUsername = existingUsername;
    }

    /**
     * @return the storedMsisdn
     */
    public String getStoredMsisdn()
    {
        return storedMsisdn != null ? storedMsisdn.trim() : "";
    }

    /**
     * @param storedMsisdn
     *            the storedMsisdn to set
     */
    public void setStoredMsisdn(String storedMsisdn)
    {
        this.storedMsisdn = storedMsisdn;
    }

    /**
     * @return the productName
     */
    public String getProductName()
    {
        return productName != null ? productName.trim() : "";
    }

    /**
     * @param productName
     *            the productName to set
     */
    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    /**
     * @return the productId
     */
    public String getProductId()
    {
        return productId != null ? productId.trim() : "";
    }

    /**
     * @param productId
     *            the productId to set
     */
    public void setProductId(String productId)
    {
        this.productId = productId;
    }

    /**
     * @return the existingUsername
     */
    public String getExistingUsername()
    {
        return existingUsername != null ? existingUsername.trim() : "";
    }

    /**
     * @param existingUsername
     *            the existingUsername to set
     */
    public void setExistingUsername(String existingUsername)
    {
        this.existingUsername = existingUsername;
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
        result = prime * result + ((existingUsername == null) ? 0 : existingUsername.trim().hashCode());
        result = prime * result + ((productId == null) ? 0 : productId.trim().hashCode());
        result = prime * result + ((productName == null) ? 0 : productName.trim().hashCode());
        result = prime * result + ((storedMsisdn == null) ? 0 : storedMsisdn.trim().hashCode());
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
        StoredUserDetailsBean other = (StoredUserDetailsBean) obj;
        if (existingUsername == null)
        {
            if (other.existingUsername != null)
                return false;
        } else if (!existingUsername.equals(other.existingUsername))
            return false;
        if (productId == null)
        {
            if (other.productId != null)
                return false;
        } else if (!productId.equals(other.productId))
            return false;
        if (productName == null)
        {
            if (other.productName != null)
                return false;
        } else if (!productName.equals(other.productName))
            return false;
        if (storedMsisdn == null)
        {
            if (other.storedMsisdn != null)
                return false;
        } else if (!storedMsisdn.equals(other.storedMsisdn))
            return false;
        return true;
    }
}
