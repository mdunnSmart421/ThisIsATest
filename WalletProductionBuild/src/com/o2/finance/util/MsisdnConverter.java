package com.o2.finance.util;

/**
 * @author scresswell
 * 
 *         To change this generated comment edit the template variable "typecomment": Window>Preferences>Java>Templates. To enable
 *         and disable the creation of type comments go to Window>Preferences>Java>Code Generation.
 * 
 *         Developed by Smart421 (www.smart421.com). (c) Copyright 2008 Telefónica O2 UK Limited..
 */
public final class MsisdnConverter
{
    private static final String INTERNATIONAL_PREFIX = "447";
    private static final int IP_LENGTH = INTERNATIONAL_PREFIX.length();
    private static final String NATIONAL_PREFIX = "07";
    private static final int NP_LENGTH = NATIONAL_PREFIX.length();

    /**
     * Private constructor to avoid multiple instances of the helper class
     */
    private MsisdnConverter()
    {
    }

    /**
     * Converts international msisdn to national format Number passed in should be a 44 number, 12 digits long. Removes the first
     * two digits (44) and prefixes a zero. If it does not begin 44, simply returns the provided number
     * 
     * @param msisdn
     *            Mobile number in international format
     * @return mobile number in 07-format.
     */
    public static String msisdnToInternational(String msisdn)
    {
        String international = msisdn;
        if (msisdn == null)
        {
            international = "";
        } else if (msisdn.length() < NP_LENGTH)
        {
            // Leave it as is (stops string out of bounds exception).
        } else if (msisdn.substring(0, NP_LENGTH).equals(NATIONAL_PREFIX))
        {
            international = INTERNATIONAL_PREFIX + msisdn.substring(NP_LENGTH);
        }
        return international;
    }

    /**
     * Converts international msisdn to national format Number passed in should be a 44 number, 12 digits long. Removes the first
     * two digits (44) and prefixes a zero. If it does not begin 44, simply returns the provided number
     * 
     * @param msisdn
     *            Mobile number in international format
     * @return mobile number in 07-format.
     */
    public static String msisdnToNational(String msisdn)
    {
        String national = msisdn;
        if (msisdn == null)
        {
            national = "";
        } else if (msisdn.length() < IP_LENGTH)
        {
            // Leave it as is (stops string out of bounds exception).
        } else if (msisdn.substring(0, IP_LENGTH).equals(INTERNATIONAL_PREFIX))
        {
            national = NATIONAL_PREFIX + msisdn.substring(IP_LENGTH);
        }
        return national;
    }
}
