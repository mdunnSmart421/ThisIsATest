package com.o2.finance.exception;

/**
 * Purpose:
 * com.o2.finance.exception
 * User: D Smith
 * Date: 26/06/2011
 */
public class UserNotFoundException extends FinanceException
{
    private static final long serialVersionUID = -2285094500438906872L;

    public UserNotFoundException( String message, Exception rootException )
    {
        super( message, rootException );
    }

    public UserNotFoundException( String s )
    {
        super( s );
    }
}
