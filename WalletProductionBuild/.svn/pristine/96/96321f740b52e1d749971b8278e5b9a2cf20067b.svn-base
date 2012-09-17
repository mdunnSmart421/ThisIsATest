package com.o2.finance.util;

/**
 * @author 
 *
 * Replaces reserved XML characters with their Entity equivalents
 */
import org.apache.regexp.RE;
import org.apache.regexp.RESyntaxException;

public class XMLCleaner
{
    private static final int XML_ENTITY = 0;
    private static final int XML_CHAR = 1;
    private static final String[][] XML_ENTITIES =
    {
    { "&amp;", "&" },
    { "&apos;", "'" },
    { "&quot;", "\"" },
    { "&lt;", "<" },
    { "&gt;", ">" } };

    // Replaces reserved XML characters with their entity equivalents
    public static String replaceXmlCharacters(String sIn) throws RESyntaxException
    {
        RE regexp = null;
        String sOut = new String(sIn);
        // Loop through the XML character / entity list
        for (int i = 0; i < XML_ENTITIES.length; i++)
        {
            // Create a new regular expression that will search for the current XML charcter
            regexp = new RE(XML_ENTITIES[i][XML_CHAR]);
            // Replace all occurances of the XML character with the equivalent entity
            sOut = regexp.subst(sOut, XML_ENTITIES[i][XML_ENTITY], RE.REPLACE_ALL);
        }
        // Return the
        return sOut;
    }
}