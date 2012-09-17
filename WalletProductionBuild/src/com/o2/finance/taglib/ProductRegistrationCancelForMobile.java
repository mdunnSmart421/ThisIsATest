package com.o2.finance.taglib;

/**
 * 
 * Tag library for generating the 
 * 
 * @author Vijay Kancherla, 09Nov2011
 * 
 */
public class ProductRegistrationCancelForMobile extends ProductRegistrationTag
{
  
	private static final long serialVersionUID = 8388332057447015680L;
	private static final String PROPERTY_FILE  = "/finance/application.properties";
    private static final String THE_URL        = "registration.mobile.cancel.link.uri";
    private static final String THE_PROTOCOL   = "registration.mobile.cancel.link.protocol";

    protected String getPropertyFileName()
    {
        return PROPERTY_FILE;
    }

    protected String getProtocol()
    {
        return THE_PROTOCOL;
    }

    protected String getUri()
    {
        return THE_URL;
    }

    protected String buildOutString(String protocol, String uri)
    {
        return "<a href=\"" + protocol + uri + "\" title=\"Cancel\">Cancel</a>";
    }
}
