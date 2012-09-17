package com.o2.finance.properties;

/**
 * PageIncludesProperties This class is for use in JSP pages that need to query the page_includes.properties file without using a
 * custom tag. To a degree this duplicates functionality available in the O2 custom tag library, but is required to get around the
 * limitation of not being able to use the resolved results of the O2 tag calls inside the I/O tags.
 * <p/>
 * Developed by Smart421 (www.smart421.com). (c) Copyright 2008 Telefónica O2 UK Limited..
 */
public class PageIncludesProperties extends FinanceProperties
{
    private static final String FILE_LOCATION = "/finance/page_includes.properties";
    private static final String PROTOCOL_KEY = "includes.protocol";
    private static final String SERVER_KEY = "includes.server";
    private static final String TOPNAV_KEY = "includes.reg.topnav";
    private static final String LEFTNAV_KEY = "includes.reg.leftnav";
    private static final String FOOTER_KEY = "includes.reg.footer";

    protected String getPropertyFile()
    {
        return FILE_LOCATION;
    }

    public String getProtocol()
    {
        return getProperty(PROTOCOL_KEY);
    }

    public String getServer()
    {
        return getProperty(SERVER_KEY);
    }

    public String getRegTopnav()
    {
        return getProperty(TOPNAV_KEY);
    }

    public String getRegLeftnav()
    {
        return getProperty(LEFTNAV_KEY);
    }

    public String getRegFooter()
    {
        return getProperty(FOOTER_KEY);
    }
}
