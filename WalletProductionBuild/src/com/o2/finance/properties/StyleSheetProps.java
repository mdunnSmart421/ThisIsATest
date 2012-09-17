/**
 * File: StyleSheetProps
 * Project: Timberlake
 * 
 * @author csimms
 * Developed by Smart421 (www.smart421.com).
 * (c) Copyright 2008 Telefónica O2 UK Limited..
 */
package com.o2.finance.properties;

/**
 * Similar to Nav Props, this manages the creation of the stylesheet urls for inclusion in the web pages. The majority of style
 * sheets are actually included as part of the navigation pages pulled from the O2 vignette server. However, currently style
 * sheets such as eservices need to be added by the O2 Orange application.
 * 
 * @author GBarnes
 * 
 *         Developed by Smart421 (www.smart421.com). (c) Copyright 2008 Telefónica O2 UK Limited..
 */
public class StyleSheetProps extends FinanceProperties
{
    private static final String FILE_LOCATION = "/finance/stylesheet.properties";
    private static final String CSS_PROTOCOL = "css.protocol";
    private static final String CSS_SERVER = "css.server";
    private static final String CSS_ESERVICES = "css.eservices.url";

    protected String getPropertyFile()
    {
        return FILE_LOCATION;
    }

    public String getProtocol()
    {
        return getProperty(CSS_PROTOCOL);
    }

    public String getServer()
    {
        return getProperty(CSS_SERVER);
    }

    public String getEservices()
    {
        return getProperty(CSS_ESERVICES);
    }
}
