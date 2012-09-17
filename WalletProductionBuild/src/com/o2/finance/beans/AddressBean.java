package com.o2.finance.beans;

import org.apache.commons.lang.StringUtils;

public class AddressBean
{
    private String houseNumber;
    private String houseName;
    private String addressLine1;
    private String addressLine2;
    private String townOrCity;
    private String county;
    private String postcode;
    private String country;

    public AddressBean()
    {
    }

    /**
     * @param houseNumber
     * @param houseNam
     * @param postcode
     * @param address
     */
    public AddressBean(String houseNumber, String houseName, String addressLine1, String addressLine2, String townOrCity,
            String county, String postcode, String country)
    {
        this.houseNumber = houseNumber;
        this.houseName = houseName;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.townOrCity = townOrCity;
        this.county = county;
        this.postcode = postcode;
        this.country = country;
    }

    public AddressBean(AddressBean bean)
    {
        this.houseNumber  = bean.houseNumber;
        this.houseName    = bean.houseName;
        this.addressLine1 = bean.addressLine1;
        this.addressLine2 = bean.addressLine2;
        this.townOrCity   = bean.townOrCity;
        this.county       = bean.county;
        this.setPostcode(bean.postcode);
        this.country      = bean.country;
    }


    /**
     * @return the houseNumber
     */
    public String getHouseNumber()
    {
        return houseNumber != null ? houseNumber.trim() : "";
    }

    /**
     * @param houseNumber
     *            the houseNumber to set
     */
    public void setHouseNumber(String houseNumber)
    {
        this.houseNumber = houseNumber;
    }

    /**
     * @return the houseNam
     */
    public String getHouseName()
    {
        return houseName != null ? houseName.trim() : "";
    }

    /**
     * @param houseNam
     *            the houseNam to set
     */
    public void setHouseName(String houseName)
    {
        this.houseName = houseName;
    }

    /**
     * @return the postcode
     */
    public String getPostcode()
    {
        return postcode != null ? postcode.trim() : "";
    }

    /**
     * @param postcode
     *            the postcode to set
     */
    public void setPostcode(String postcode)
    {
	if (( null != postcode) && (!StringUtils.contains(postcode, " ") ) && ( postcode.trim().length() > 0  )  )
	{
	    StringBuffer fixedPostcode = new StringBuffer(StringUtils.substring(postcode, 0, postcode.length()-3));
	    fixedPostcode.append(" ");
	    fixedPostcode.append(StringUtils.substring(postcode, postcode.length()-3));
	    this.postcode = fixedPostcode.toString().toUpperCase();
	}
	else
	{
	    this.postcode = postcode;
	}
    }

    /**
     * @return the addressLine1
     */
    public String getAddressLine1()
    {
        return addressLine1 != null ? addressLine1.trim() : "";
    }

    /**
     * @param addressLine1
     *            the addressLine1 to set
     */
    public void setAddressLine1(String addressLine1)
    {
        this.addressLine1 = addressLine1;
    }

    /**
     * @return the addressLine2
     */
    public String getAddressLine2()
    {
        return addressLine2 != null ? addressLine2.trim() : "";
    }

    /**
     * @param addressLine2
     *            the addressLine2 to set
     */
    public void setAddressLine2(String addressLine2)
    {
        this.addressLine2 = addressLine2;
    }

    /**
     * @return the townOrCity
     */
    public String getTownOrCity()
    {
        return townOrCity != null ? townOrCity.trim() : "";
    }

    /**
     * @param townOrCity
     *            the townOrCity to set
     */
    public void setTownOrCity(String townOrCity)
    {
        this.townOrCity = townOrCity;
    }

//    /**
//     * @return concatenation of the address details
//     */
//    public String getAddress()
//    {
//        String addressText = (getHouseNumber().trim().length() > 0 ? getHouseNumber() + ", " : "")
//                + (getHouseName().trim().length() > 0 ? getHouseName() + ", " : "")
//                + (getAddressLine1().trim().length() > 0 ? getAddressLine1() + ", " : "")
//                + (getAddressLine2().trim().length() > 0 ? getAddressLine2() + ", " : "")
//                + (getTownOrCity().trim().length() > 0 ? getTownOrCity() + ", " : "")
//                + (getCounty().trim().length() > 0 ? getCounty() + ", " : "")
//                + (getPostcode().trim().length() > 0 ? getPostcode() + ", " : "")
//                + (getCountry().trim().length() > 0 ? getCountry() : "")
//                ;
//
//        return addressText.trim().length() > 0 ? addressText : "";
//    }



   /**
     * @return concatenation of the address details
     */
    public String getAddress()
    {
        String addressText = (getHouseName().trim().length() > 0 ? getHouseName() + ", " : "")
                + (getHouseNumber().trim().length() > 0 ? getHouseNumber() + ", " : "")
                + (getAddressLine1().trim().length() > 0 ? getAddressLine1() + ", " : "")
                + (getAddressLine2().trim().length() > 0 ? getAddressLine2() + ", " : "")
                + (getTownOrCity().trim().length() > 0 ? getTownOrCity() + ", " : "")
                + (getCounty().trim().length() > 0 ? getCounty() + ", " : "")
                + (getPostcode().trim().length() > 0 ? getPostcode() + ", " : "")
                + (getCountry().trim().length() > 0 ? getCountry() : "")
                ;

        return addressText.trim().length() > 0 ? addressText : "";
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
        result = prime * result + ((addressLine1 == null) ? 0 : addressLine1.trim().hashCode());
        result = prime * result + ((addressLine2 == null) ? 0 : addressLine2.trim().hashCode());
        result = prime * result + ((houseName == null) ? 0 : houseName.trim().hashCode());
        result = prime * result + ((houseNumber == null) ? 0 : houseNumber.trim().hashCode());
        result = prime * result + ((postcode == null) ? 0 : postcode.trim().hashCode());
        result = prime * result + ((townOrCity == null) ? 0 : townOrCity.trim().hashCode());
        result = prime * result + ((county == null) ? 0 : county.trim().hashCode());
        result = prime * result + ((country == null) ? 0 : country.trim().hashCode());
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
        AddressBean other = (AddressBean) obj;
        if (addressLine1 == null)
        {
            if (other.addressLine1 != null)
                return false;
        } else if (!addressLine1.equals(other.addressLine1))
            return false;
        if (addressLine2 == null)
        {
            if (other.addressLine2 != null)
                return false;
        } else if (!addressLine2.equals(other.addressLine2))
            return false;
        if (houseName == null)
        {
            if (other.houseName != null)
                return false;
        } else if (!houseName.equals(other.houseName))
            return false;
        if (houseNumber == null)
        {
            if (other.houseNumber != null)
                return false;
        } else if (!houseNumber.equals(other.houseNumber))
            return false;
        if (postcode == null)
        {
            if (other.postcode != null)
                return false;
        } else if (!postcode.equals(other.postcode))
            return false;
        if (townOrCity == null)
        {
            if (other.townOrCity != null)
                return false;
        } else if (!townOrCity.equals(other.townOrCity))
            return false;
        return true;
    }


    public String toString()
    {
        return "AddressBean{" +
                "addressLine1='" + getAddressLine1() + '\'' +
                ", houseNumber='" + getHouseNumber() + '\'' +
                ", houseName='" + getHouseName() + '\'' +
                ", addressLine2='" + getAddressLine2() + '\'' +
                ", townOrCity='" + getTownOrCity() + '\'' +
                ", county='" + getCounty() + '\'' +
                ", postcode='" + getPostcode() + '\'' +
                ", country='" + getCountry() + '\'' +
                '}';
    }

    /**
     * @param county the county to set
     */
    public void setCounty(String county)
    {
        this.county = county;
    }

    /**
     * @return the county
     */
    public String getCounty()
    {
        return county != null ? county.trim() : "";
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country)
    {
	    this.country = country;
    }

    /**
     * @return the country
     */
    public String getCountry()
    {
        return country != null ? country.trim() : "";
    }
}
