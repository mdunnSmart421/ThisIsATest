package com.o2.finance.service;

import com.o2.finance.exception.FinanceDelegateException;
import com.o2.finance.model.UserTO;

/**
 * Purpose: com.o2.finance.service User: D Smith Date: 16/05/2011
 */
public interface ProductService
{
    public boolean hasUserGotProduct(UserTO customer, String productId);

    public boolean hasMsisdnGotProduct(String msisdn, String productId);

    public boolean validateProductId(String productId) throws FinanceDelegateException;

}
