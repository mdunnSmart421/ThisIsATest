package com.o2.finance.taglib;

/**
 * 
 * Tag library for recovering url following Exit button click on remind pages
 * 
 * @author
 * 
 */
public class ProductRegistrationExit extends ProductRegistrationTag
{
    private static final long serialVersionUID = 1L;
    private static final String PROPERTY_FILE = "/finance/application.properties";
    private static final String ENV_URL = "page.cancel.link.setting";
    private static final String URL_PROTOCOL = "page.cancel.link.protocol.setting";

    protected String getPropertyFileName()
    {
        return PROPERTY_FILE;
    }

    protected String getProtocol()
    {
        return URL_PROTOCOL;
    }

    protected String getUri()
    {
        return ENV_URL;
    }

    protected String buildOutString(String protocol, String uri)
    {
        return "<a tabindex=\"500\" class=\"bbLinkButton allTxtRight marginRight5\" href=\"" + protocol + uri
                + "\" title=\"Exit\">Exit</a>";
    }
}
