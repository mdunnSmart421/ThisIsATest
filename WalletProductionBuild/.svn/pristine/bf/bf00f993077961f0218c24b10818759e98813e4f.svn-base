package com.o2.finance.beans;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateOfBirthBean
{
    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("dd MMMM yyyy");
    public static final String DIGIT_ONLY_PATTERN = "[0-9]+";
    private String birthDay;
    private String birthMonth;
    private String birthYear;

    public DateOfBirthBean()
    {
    }

    /**
     * @param birthDay
     * @param birthMonth
     * @param birthYear
     * @param dateOfBirth
     */
    public DateOfBirthBean(String birthDay, String birthMonth, String birthYear)
    {
        this.birthDay = birthDay.trim();
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
    }

    /**
     * @param birthDay
     * @param birthMonth
     * @param birthYear
     * @param dateOfBirth
     */
    public DateOfBirthBean(int birthDay, int birthMonth, int birthYear)
    {
        this.birthDay = Integer.toString(birthDay);
        this.birthMonth = Integer.toString(birthMonth);
        this.birthYear = Integer.toString(birthYear);
    }

    /**
     * @return the birthDay
     */
    public String getBirthDay()
    {
        return birthDay != null ? birthDay : "DD";
    }

    /**
     * @param birthDay
     *            the birthDay to set
     */
    public void setBirthDay(String birthDay)
    {
//        this.birthDay = birthDay.trim();
        this.birthDay = birthDay != null ? birthDay.trim() : "";
    }

    /**
     * @return the birthMonth
     */
    public String getBirthMonth()
    {
        return birthMonth != null ? birthMonth : "";
    }

    /**
     * @param birthMonth
     *            the birthMonth to set
     */
    public void setBirthMonth(String birthMonth)
    {
        this.birthMonth = birthMonth;
    }

    /**
     * @return the birthYear
     */
    public String getBirthYear()
    {
        return birthYear != null ? birthYear : "YYYY";
    }

    /**
     * @param birthYear
     *            the birthYear to set
     */
    public void setBirthYear(String birthYear)
    {
        this.birthYear = birthYear;
    }

    /**
     * @return the dateOfBirth
     */
    public String getDateOfBirth()
    {
        /*
         * Only return a value of numeric values have been supplied for the birth day, month and year. If these values are not
         * present then a date of birth has not been entered and only the string display defaults will be available.
         * 
         * Where a date of birth is available this will be formatted as per the 'dd MMMM yyyy' i.e 1 January 1970
         */
        String dateOfBirth = "";
        if (getBirthDay().trim().matches(DIGIT_ONLY_PATTERN) && getBirthMonth().trim().matches(DIGIT_ONLY_PATTERN)
                && getBirthYear().trim().matches(DIGIT_ONLY_PATTERN))
        {
            Calendar cal = Calendar.getInstance();
            cal.set(Integer.parseInt(getBirthYear().trim()), Integer.parseInt(getBirthMonth().trim()) - 1,
                    Integer.parseInt(getBirthDay().trim()), 0, 0, 0);
            dateOfBirth = FORMATTER.format(cal.getTime());
            ;
        }
        return dateOfBirth;
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
        result = prime * result + ((birthDay == null) ? 0 : birthDay.hashCode());
        result = prime * result + ((birthMonth == null) ? 0 : birthMonth.hashCode());
        result = prime * result + ((birthYear == null) ? 0 : birthYear.hashCode());
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
        DateOfBirthBean other = (DateOfBirthBean) obj;
        if (birthDay == null)
        {
            if (other.birthDay != null)
                return false;
        } else if (!birthDay.equals(other.birthDay))
            return false;
        if (birthMonth == null)
        {
            if (other.birthMonth != null)
                return false;
        } else if (!birthMonth.equals(other.birthMonth))
            return false;
        if (birthYear == null)
        {
            if (other.birthYear != null)
                return false;
        } else if (!birthYear.equals(other.birthYear))
            return false;
        return true;
    }

    public String toString()
    {
        StringBuffer buffer = new StringBuffer(  );

        buffer.append( "Year: " ).append( birthYear );
        buffer.append( ", Month: " ).append( birthMonth );
        buffer.append( ", Day: " ).append( birthDay );

        return buffer.toString();

    }
}
