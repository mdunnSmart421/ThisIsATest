/**
 * 
 */
package com.o2.finance.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author SCroft
 * 
 */
/**
 * @author SWatson
 *
 */
public class UpdateUserDetailsForm
{
    private String          title;
    private String          forename;
    private String          lastName;
    private String          mobileNumber;
    private String          mobileMake;
    private String          alternativeEmail;
    private GenderBean      gender;
    private AddressBean     address;
    private DateOfBirthBean dateOfBirth;
    private boolean         isNewAccount;
    private List            titles;
    private Map             months;
    private List            mobileMakes;
    
    private String          activatedButton; 

    public UpdateUserDetailsForm()
    {
    }
    
    public String toString()
    {
	StringBuffer response = new StringBuffer("UpdateUserDetailsForm [");
	response.append("title=" + title + ", ");
	response.append("forename=" + forename + ", ");
	response.append("lastName=" + lastName + ", ");
	response.append("mobileNumber=" + mobileNumber + ", ");
	response.append("mobileMake=" + mobileMake + ", ");	
	response.append("alternativeEmail=" + alternativeEmail + ", ");
	response.append("isNewAccount=" + isNewAccount + ", ");
	response.append("gender=" +  (gender != null ?  gender.toString() : "") + ", ");
	response.append("address=" + (address != null ? address.toString() : "")  + ", ");
	response.append("dateOfBirth=" + (dateOfBirth != null ? dateOfBirth.toString() : "" ));
	response.append("]");
	return response.toString();
    }

    /**
     * @param forename
     * @param lastName
     * @param mobileNumber
     * @param alternativeEmail
     * @param gender
     * @param address
     * @param dateOfBirth
     * @param editable
     */
    public UpdateUserDetailsForm(String title, String forename, String lastName, String mobileNumber, String alternativeEmail,
            GenderBean gender, AddressBean address, DateOfBirthBean dateOfBirth)
    {
        this.title = title;
        this.forename = forename;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.alternativeEmail = alternativeEmail;
        this.gender = gender;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
    }

    public UpdateUserDetailsForm(String title, String forename, String lastName, String mobileNumber, String alternativeEmail,
            GenderBean gender, AddressBean address, DateOfBirthBean dateOfBirth, List titles, Map months)
    {
        this(title, forename, lastName, mobileNumber, alternativeEmail, gender, address, dateOfBirth);
        this.titles = titles;
        this.months = months;
    }

    /**
     * @return the forename
     */
    public String getForename()
    {
        return forename != null ? forename.trim() : "";
    }

    /**
     * @param forename
     *            the forename to set
     */
    public void setForename(String forename)
    {
        this.forename = forename;
    }

    /**
     * @return the lastName
     */
    public String getLastName()
    {
        return lastName != null ? lastName.trim() : "";
    }

    /**
     * @param lastName
     *            the lastName to set
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * @return the mobileNumber
     */
    public String getMobileNumber()
    {
        return mobileNumber != null ? mobileNumber.trim() : "";
    }

    /**
     * @param mobileNumber
     *            the mobileNumber to set
     */
    public void setMobileNumber(String mobileNumber)
    {
        this.mobileNumber = mobileNumber;
    }

    /**
     * @return the alternativeEmail
     */
    public String getAlternativeEmail()
    {
        return alternativeEmail != null ? alternativeEmail.trim() : "";
    }

    /**
     * @param alternativeEmail
     *            the alternativeEmail to set
     */
    public void setAlternativeEmail(String alternativeEmail)
    {
        this.alternativeEmail = alternativeEmail;
    }

    /**
     * @return the gender
     */
    public GenderBean getGender()
    {
        if (gender == null)
            gender = new GenderBean();
        return gender;
    }

    /**
     * @param gender
     *            the gender to set
     */
    public void setGender(GenderBean gender)
    {
        this.gender = gender;
    }

    /**
     * @return the address
     */
    public AddressBean getAddress()
    {
        if (address == null)
            address = new AddressBean();
        return address;
    }

    /**
     * @param address
     *            the address to set
     */
    public void setAddress(AddressBean address)
    {
        this.address = address;
    }

    /**
     * @return the dateOfBirth
     */
    public DateOfBirthBean getDateOfBirth()
    {
        if (dateOfBirth == null)
            dateOfBirth = new DateOfBirthBean();
        return dateOfBirth;
    }

    /**
     * @param dateOfBirth
     *            the dateOfBirth to set
     */
    public void setDateOfBirth(DateOfBirthBean dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * @return the title
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * @param title
     *            the title to set
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * @return the titles
     */
    public List getTitles()
    {
        return titles;
    }

    /**
     * @param titles
     *            the titles to set
     */
    public void setTitles(List titles)
    {
        this.titles = titles;
    }

    /**
     * @return the months
     */
    public Map getMonths()
    {
        return months;
    }

    /**
     * @param months
     *            the months to set
     */
    public void setMonths(Map months)
    {
        this.months = months;
    }


    /**
     * @return the isNewAccount
     */
    public boolean isNewAccount()
    {
        return isNewAccount;
    }

    /**
     * @param isNewAccount the isNewAccount to set
     */
    public void setNewAccount(boolean isNewAccount)
    {
        this.isNewAccount = isNewAccount;
    }


    /**
     * @return the mobileMake
     */
    public String getMobileMake()
    {
        return mobileMake != null ? mobileMake.trim() : "";
    }

    /**
     * @param mobileMake the mobileMake to set
     */
    public void setMobileMake(String mobileMake)
    {
        this.mobileMake = mobileMake;
    }

    /**
     * @return the mobileMakes
     */
    public List getMobileMakes()
    {
        return mobileMakes != null ? mobileMakes : new ArrayList();
    }

    /**
     * @param mobileMakes the mobileMakes to set
     */
    public void setMobileMakes(List mobileMakes)
    {
        this.mobileMakes = mobileMakes;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + ((alternativeEmail == null) ? 0 : alternativeEmail.trim().hashCode());
        result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
        result = prime * result + ((forename == null) ? 0 : forename.trim().hashCode());
        result = prime * result + ((gender == null) ? 0 : gender.hashCode());
        result = prime * result + (isNewAccount ? 1231 : 1237);
        result = prime * result + ((lastName == null) ? 0 : lastName.trim().hashCode());
        result = prime * result + ((mobileNumber == null) ? 0 : mobileNumber.trim().hashCode());
        result = prime * result + ((title == null) ? 0 : title.trim().hashCode());
        return result;
    }

    /* (non-Javadoc)
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
        UpdateUserDetailsForm other = (UpdateUserDetailsForm) obj;
        if (address == null)
        {
            if (other.address != null)
                return false;
        } else if (!address.equals(other.address))
            return false;
        if (alternativeEmail == null)
        {
            if (other.alternativeEmail != null)
                return false;
        } else if (!alternativeEmail.equals(other.alternativeEmail))
            return false;
        if (dateOfBirth == null)
        {
            if (other.dateOfBirth != null)
                return false;
        } else if (!dateOfBirth.equals(other.dateOfBirth))
            return false;
        if (forename == null)
        {
            if (other.forename != null)
                return false;
        } else if (!forename.equals(other.forename))
            return false;
        if (gender == null)
        {
            if (other.gender != null)
                return false;
        } else if (!gender.equals(other.gender))
            return false;
        if (isNewAccount != other.isNewAccount)
            return false;
        if (lastName == null)
        {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        if (mobileNumber == null)
        {
            if (other.mobileNumber != null)
                return false;
        } else if (!mobileNumber.equals(other.mobileNumber))
            return false;
        if (title == null)
        {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        return true;
    }

	public String getActivatedButton() {
		return activatedButton;
	}

	public void setActivatedButton(String activatedButton) {
		this.activatedButton = activatedButton;
	}
}
