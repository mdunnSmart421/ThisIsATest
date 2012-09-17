package com.o2.finance.service;

import com.o2.finance.exception.FinanceDelegateException;
import com.o2.finance.model.UserTO;
import com.o2.finance.properties.ProductProperties;
import com.o2.finance.properties.PropertyManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Purpose: com.o2.finance.service User: D Smith Date: 16/05/2011
 */
public class ProductServiceImpl implements ProductService
{
    Logger log = LogManager.getLogger( this.getClass() );

    public boolean hasUserGotProduct(UserTO customer, String productId)
    {
        return false; // To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean hasMsisdnGotProduct(String msisdn, String productId)
    {
        return false; // To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean validateProductId(String productId) throws FinanceDelegateException
    {

        log.info( "validateProductId start." );

        boolean result = false;

        log.info( "Validating productId: " + productId );

        // Null is not valid
        if (null == productId)
        {
            log.info( "productId is null, returning false" );
            return false;
        }
        ProductProperties properties = PropertyManager.getProductProps();
        String productIdValues = properties.getProductIdValues();
        String[] values = productIdValues.split(",");
        for (int i = 0; i < values.length; i++)
        {
            if (productId.equalsIgnoreCase(values[i]))
            {
                log.info( "Matched productId, returning true" );
                result = true;
                break;
            }
        }
        if (! result )
        {
            log.info("finished searching, productId not found, returning false");
        }

        return result;
    }

}
