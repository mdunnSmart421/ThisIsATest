package com.o2.finance.exception;

/**
 * Purpose:
 * com.o2.finance.exception
 * User: D Smith
 * Date: 22/06/2011
 */
public class AuthenticationServiceException extends FinanceServiceException
{
    private static final long serialVersionUID = 2276807497798274290L;

    public AuthenticationServiceException( String message, Exception rootException )
    {
        super( message, rootException );
    }

    public AuthenticationServiceException( String message, Exception rootException, String errorCode )
    {
        super( message, rootException, errorCode );
    }

    public AuthenticationServiceException( String s )
    {
        super( s );
    }

    public AuthenticationServiceException( String s, String errorCode )
    {
        super( s, errorCode );
    }






}
