package com.o2.finance.exception;

/**
 * Purpose: com.o2.finance.exception User: D Smith Date: 17/03/2011
 */
public class FinanceException extends Exception
{
    private static final long serialVersionUID = 6291826471648067752L;
    private Exception rootException;

    /**
     * Non-default constructor
     * 
     * @param message
     * @param rootException
     */
    public FinanceException(String message, Exception rootException)
    {
        super(message, rootException);
    }

    /**
     * Gets the root exception
     * 
     * @return Exception
     */
    public Exception getRootException()
    {
        return this.rootException;
    }

    public FinanceException(String s)
    {
        super(s);
    }
}
