package com.o2.finance.beans;

public class GenderBean
{
    private String gender;
    private String genderText;

    public GenderBean()
    {
    }
    
    public String toString()
    {
	StringBuffer response = new StringBuffer("GenderBean [");
	response.append("gender=" + gender + ", ");
	response.append("genderText=" + genderText);
	response.append("]");
	return response.toString();
    }

    /**
     * @param gender
     * @param genderText
     * @param genderMale
     * @param genderFemale
     */
    public GenderBean(String gender, String genderText)
    {
        setGender(gender);
        this.genderText = genderText;
    }

    /**
     * @return the gender
     */
    public String getGender()
    {
        return gender != null ? gender : "";
    }

    /**
     * @param gender
     *            the gender to set
     */
    public void setGender(String gender)
    {
        this.gender = gender;
    }

    /**
     * @return the genderText
     */
    public String getGenderText()
    {
        return genderText != null ? genderText : "";
    }

    /**
     * @param genderText
     *            the genderText to set
     */
    public void setGenderText(String genderText)
    {
        this.genderText = genderText;
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
        result = prime * result + ((gender == null) ? 0 : gender.hashCode());
        result = prime * result + ((genderText == null) ? 0 : genderText.hashCode());
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
        GenderBean other = (GenderBean) obj;
        if (gender == null)
        {
            if (other.gender != null)
                return false;
        } else if (!gender.equals(other.gender))
            return false;
        if (genderText == null)
        {
            if (other.genderText != null)
                return false;
        } else if (!genderText.equals(other.genderText))
            return false;
        return true;
    }
}
