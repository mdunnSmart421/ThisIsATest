package com.o2.finance.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * A collection of static string manipulation routines that will not throw a null pointer exception
 * 
 * Developed by Smart421 (www.smart421.com). (c) Copyright 2008 Telefónica O2 UK Limited..
 */
public final class StringFunctions
{
    /**
     * Private constructor to avoid multiple instances of the class
     */
    private StringFunctions()
    {
    }

    /**
     * Indicates if a string contains: null, no content, only contain spaces
     * 
     * @param str
     * @return
     */
    public static boolean isEmpty(String str)
    {
        return str == null || str.trim().length() == 0;
    }

    /**
     * Returns the given string to lower case
     * 
     * @param sIn
     * @return
     */
    public static String toLowerCase(String sIn)
    {
        String sOut = null;
        if (sIn != null)
        {
            sOut = sIn.toLowerCase();
        }
        return sOut;
    }

    /**
     * Prepares a call to dropInvalidChars by creating a HashSet of allowed characters in the given string
     * 
     * @param inString
     * @param allowedChars
     * @return
     */
    public static String dropInvalidChars(String inString, String allowedChars)
    {
        HashSet validChars = new HashSet();
        int allowedCharsLength = allowedChars.length();
        for (int i = 0; i < allowedCharsLength; i = i + 1)
        {
            validChars.add(allowedChars.substring(i, i + 1));
        }
        return dropInvalidChars(inString, validChars);
    }

    /**
     * Drops characters from the given string that are not specified in the allowedChars hashset
     * 
     * @param inString
     * @param allowedChars
     * @return
     */
    public static String dropInvalidChars(String inString, HashSet allowedChars)
    {
        StringBuffer sb = new StringBuffer();
        int inStringLength = inString.length();
        String inChar = "";
        for (int i = 0; i < inStringLength; i = i + 1)
        {
            inChar = inString.substring(i, i + 1);
            if (allowedChars.contains(inChar))
            {
                sb.append(inChar);
            }
        }
        return sb.toString();
    }

    /**
     * Returns valid characters from the given string after removing characters passed in the disAllowedChars string
     * 
     * @param inString
     * @param disAllowedChars
     * @return
     */
    public static String acceptValidCharacters(String inString, String disAllowedChars)
    {
        StringBuffer sb = new StringBuffer();
        char inChar;
        for (int i = 0; i < inString.length(); i++)
        {
            inChar = inString.charAt(i);
            if (disAllowedChars.indexOf(inChar) == -1)
            {
                sb.append(inChar);
            }
        }
        return sb.toString();
    }

    /**
     * Checks for the disallowed characters in a given string
     * 
     * @param inString
     * @param disAllowedChars
     * @return
     */
    public static boolean hasDisallowedCharacters(String inString, String disAllowedChars)
    {
        char inChar;
        boolean disAllowedCharsFound = false;
        for (int i = 0; i < inString.length(); i++)
        {
            inChar = inString.charAt(i);
            if (disAllowedChars.indexOf(inChar) >= 0)
            {
                disAllowedCharsFound = true;
                break;
            }
        }
        return disAllowedCharsFound;
    }

    /**
     * Maintains collection of security fields and returns true for the input field found in the collection
     * 
     * @param fieldName
     * @return boolean
     */
    public static boolean isFieldSecure(String fieldName)
    {
        List suppressLogFields = new ArrayList();
        suppressLogFields.add("in_password");
        suppressLogFields.add("in_confirmPassword");
        suppressLogFields.add("in_securityAnswer");
        return suppressLogFields.contains(fieldName);
    }
}
