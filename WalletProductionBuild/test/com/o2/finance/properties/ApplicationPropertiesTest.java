package com.o2.finance.properties;

import junit.framework.TestCase;

/**
 * Purpose:
 * com.o2.finance.properties
 * User: D Smith
 * Date: 15/08/2011
 */
public class ApplicationPropertiesTest extends TestCase
{
    public void testGetSendMessage() throws Exception
    {


        if (PropertyManager.getApplicationProperties().getSendMessage())
        {
           System.out.println( "It's true" );
        }   else
        {
           System.out.println( "It's false" );
        }

    }
}
