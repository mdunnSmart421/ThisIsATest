package com.o2.finance.properties;

import java.util.List;

/**
 * Purpose: com.o2.finance.properties User: D Smith Date: 17/03/2011
 */
public class ProductProperties extends FinanceProperties
{
    private static final String PRODUCT_PREFIX = "productid.";
    private static final String PRODUCT_TITLE_SUFFIX = ".product.name";
    private static final String PRODUCT_COPY_SUFFIX = ".copy";
    private static final String PRODUCT_HANDOFF_SUFFIX = ".handoff";
    private static final String PRODUCT_TARGET_SUFFIX = ".target.url";
    private static final String PRODUCT_RETURN_SUFFIX = ".return.url";
    private static final String FILE_LOCATION = "/finance/product.properties";
    private static final String PRODUCT_ID_KEY = "productids";
    private static final String PRODUCT_POS_BUSINESS_UNIT = ".posbusinessunit";
    private static final String PRODUCT_SMS_COPY = ".sms.copy";
    private static final String PRODUCT_CHECK_DETAILS_COPY = ".check.details.copy";


    protected String getPropertyFile()
    {
        return FILE_LOCATION;
    }

    public String getProductIdValues()
    {
        return getProperty(PRODUCT_ID_KEY);
    }

    public List getProductIdList()
    {
        return getListProperty(PRODUCT_ID_KEY);
    }

    public String getProductTitle(String productId)
    {
        return getProperty(PRODUCT_PREFIX + productId + PRODUCT_TITLE_SUFFIX);
    }

    public String getProductCopy(String productId)
    {
        return getProperty(PRODUCT_PREFIX + productId + PRODUCT_COPY_SUFFIX);
    }

    public String getProductHandoff(String productId)
    {
        return getProperty(PRODUCT_PREFIX + productId + PRODUCT_HANDOFF_SUFFIX);
    }

    public String getProductTargetUrl(String productId)
    {
        return getProperty(PRODUCT_PREFIX + productId + PRODUCT_TARGET_SUFFIX);
    }

    public String getProductReturnUrl(String productId)
    {
        return getProperty(PRODUCT_PREFIX + productId + PRODUCT_RETURN_SUFFIX);
    }


    public String getPosBusinessUnit( String productId)
    {
        return getProperty( PRODUCT_PREFIX + productId + PRODUCT_POS_BUSINESS_UNIT );
    }


    public String getSmsCopy( String productId )
    {
        return getProperty( PRODUCT_PREFIX + productId + PRODUCT_SMS_COPY );
    }


    public String getCheckDetailsCopy( String productId )
    {
        return getProperty( PRODUCT_PREFIX + productId + PRODUCT_CHECK_DETAILS_COPY );
    }


}
