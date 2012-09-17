package com.o2.finance.exception;

/**
 * Purpose:
 * com.o2.finance.exception
 * User: D Smith
 * Date: 23/06/2011
 */
public class AddressNotFoundException extends Exception
{
    private static final long serialVersionUID = 8003498301899381410L;

    public AddressNotFoundException()
    {
    }

    public AddressNotFoundException( String s )
    {
        super( s );
    }

    public AddressNotFoundException( String s, Throwable throwable )
    {
        super( s, throwable );
    }

    public AddressNotFoundException( Throwable throwable )
    {
        super( throwable );
    }
}
