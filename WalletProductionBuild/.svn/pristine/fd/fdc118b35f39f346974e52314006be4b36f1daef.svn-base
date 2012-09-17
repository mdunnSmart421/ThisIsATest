package com.o2.finance.service;

import com.o2.finance.exception.AuthenticationServiceException;
import com.o2.finance.exception.FinanceServiceSLMBreachException;

/**
 * Purpose:
 * com.o2.finance.service
 * User: D Smith
 * Date: 13/05/2011
 */
public interface AuthenticationService
{
    public boolean isUserLoggedIn( String userId, String authToken ) throws AuthenticationServiceException, FinanceServiceSLMBreachException;

//    public AuthByNameResponse authByName(String username, String password) throws FinanceException;

    public String getUsername( String userId, String authToken ) throws AuthenticationServiceException, FinanceServiceSLMBreachException;


}
