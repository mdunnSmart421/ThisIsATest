package com.o2.finance.beans;

public class EditableUserDetailFlags
{
    private boolean forename;
    private boolean lastName;
    private boolean gender;
    private boolean dateOfBirth;

    public EditableUserDetailFlags()
    {
    }

    /**
     * @param forename
     * @param lastName
     * @param gender
     * @param dateOfBirth
     */
    public EditableUserDetailFlags(boolean forename, boolean lastName, boolean gender, boolean dateOfBirth)
    {
        this.forename = forename;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * @return the firstname
     */
    public boolean isForename()
    {
        return forename;
    }

    /**
     * @return the lastName
     */
    public boolean isLastName()
    {
        return lastName;
    }

    /**
     * @return the gender
     */
    public boolean isGender()
    {
        return gender;
    }

    /**
     * @return the dateOfBirth
     */
    public boolean isDateOfBirth()
    {
        return dateOfBirth;
    }

    /**
     * @param forename
     *            the firstname to set
     */
    public void setForename(boolean forename)
    {
        this.forename = forename;
    }

    /**
     * @param lastName
     *            the lastName to set
     */
    public void setLastName(boolean lastName)
    {
        this.lastName = lastName;
    }

    /**
     * @param gender
     *            the gender to set
     */
    public void setGender(boolean gender)
    {
        this.gender = gender;
    }

    /**
     * @param dateOfBirth
     *            the dateOfBirth to set
     */
    public void setDateOfBirth(boolean dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
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
        result = prime * result + (dateOfBirth ? 1231 : 1237);
        result = prime * result + (forename ? 1231 : 1237);
        result = prime * result + (gender ? 1231 : 1237);
        result = prime * result + (lastName ? 1231 : 1237);
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
        EditableUserDetailFlags other = (EditableUserDetailFlags) obj;
        if (dateOfBirth != other.dateOfBirth)
            return false;
        if (forename != other.forename)
            return false;
        if (gender != other.gender)
            return false;
        if (lastName != other.lastName)
            return false;
        return true;
    }
}