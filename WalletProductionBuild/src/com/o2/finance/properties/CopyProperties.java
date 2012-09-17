package com.o2.finance.properties;

/**
 * Purpose:
 * com.o2.finance.properties
 * User: D Smith
 * Date: 15/08/2011
 */
public class CopyProperties extends FinanceProperties
{

    private static final String FILE_LOCATION = "/finance/copy.properties";

    private static final String ADDRESS_FOUND_HEADER = "paf.address.found.header.copy";
    private static final String ADDRESS_NOT_FOUND_HEADER = "paf.address.not.found.header.copy";
    private static final String ADDRESS_FOUND_BODY = "paf.address.found.body.copy";
    private static final String ADDRESS_FOUND_MOBILE_BODY = "paf.address.found.body.mobile.copy";
    private static final String ADDRESS_NOT_FOUND_BODY = "paf.address.not.found.body.copy";

    private static final String BUSY_HEADER_TEXT = "busy.header.text";
    private static final String BUSY_BODY_TEXT = "busy.body.text";
    private static final String BUSY_RETURN_URL = "busy.return.url";
    private static final String BUSY_BUTTON_LABEL = "busy.button.label";








    protected String getPropertyFile()
    {
        return FILE_LOCATION;
    }



    public String getAddressFoundHeader()
    {
        return getProperty( ADDRESS_FOUND_HEADER );
    }


    public String getAddressNotFoundHeader()
    {
        return getProperty( ADDRESS_NOT_FOUND_HEADER );
    }


    public String getAddressFoundBody()
    {
        return getProperty( ADDRESS_FOUND_BODY );
    }


    public String getAddressNotFoundBody()
    {
        return getProperty( ADDRESS_NOT_FOUND_BODY );
    }


    public String getBusyBodyText()
    {
        return getProperty( BUSY_BODY_TEXT );
    }

    public String getBusyButtonLabel()
    {
        return getProperty( BUSY_BUTTON_LABEL );
    }

    public String getBusyHeaderText()
    {
        return getProperty( BUSY_HEADER_TEXT );
    }

    public String getBusyReturnUrl()
    {
        return getProperty( BUSY_RETURN_URL );
    }

	public String getAddressFoundMobileBody() {
		return getProperty( ADDRESS_FOUND_MOBILE_BODY );
	}







}
