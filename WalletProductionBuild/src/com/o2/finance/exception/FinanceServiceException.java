package com.o2.finance.exception;

/**
 * Purpose: com.o2.finance.exception User: D Smith Date: 05/06/2011
 */
public class FinanceServiceException extends FinanceException
{
    private static final long serialVersionUID = 253883549184844704L;

    private String errorCode;


    public FinanceServiceException(String message, Exception rootException)
    {
        super(message, rootException);
    }

    public FinanceServiceException(String s)
    {
        super(s);
    }

    public FinanceServiceException( String message, Exception rootException, String errorCode )
    {
        super( message, rootException );
        this.errorCode = errorCode;
    }

    public FinanceServiceException( String s, String errorCode )
    {
        super( s );
        this.errorCode = errorCode;
    }


    public String getErrorCode()
    {
        return errorCode;
    }


    public String toString()
    {

        StringBuffer buffer = new StringBuffer(  );


        buffer.append(super.toString());
        if ( null != errorCode && !"".equalsIgnoreCase( errorCode ))
        {
            buffer.append( "\nError Code:" ).append( errorCode );
        }
        return buffer.toString();
    }
}
