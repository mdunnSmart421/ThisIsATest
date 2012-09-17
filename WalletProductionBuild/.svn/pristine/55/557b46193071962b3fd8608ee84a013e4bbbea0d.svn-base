/**
 * 
 */
package com.o2.finance.util;

import org.apache.commons.lang.StringEscapeUtils;

import com.o2.finance.etc.FinanceConstants;

/**
 * @author SCroft
 * 
 */
public class InputFilter
{
    private static org.apache.log4j.Logger logger = org.apache.log4j.LogManager.getLogger(InputFilter.class.getName());

    /**
     * Filter strings, used in old and new msisdn
     * 
     * @param storedMsisdn
     *            or new msisdn
     * @return String
     */
    public static String filterString(String toFilter)
    {
        logger.debug("input string toFilter = " + toFilter);
        String validChar = StringFunctions.acceptValidCharacters(MsisdnConverter.msisdnToNational(toFilter),
                FinanceConstants.DISALLOWED_XSS_CHARACTERS);
        String escapedStr = StringEscapeUtils.escapeHtml(validChar);
        logger.debug("output string toFilter = " + toFilter);
        return escapedStr;
    }
}
