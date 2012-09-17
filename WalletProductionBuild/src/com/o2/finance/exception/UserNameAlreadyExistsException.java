package com.o2.finance.exception;

/**
 * Purpose: Thrown when the createUser call fails due to the chosen username already in use com.o2.finance.exception User: Vijay
 * Kancherla Date: 21/06/2011
 */
public class UserNameAlreadyExistsException extends FinanceException
{
    private static final long serialVersionUID = 21062011132416L;

    /**
     * Non-default constructor
     * 
     * @param message
     * @param rootException
     */
    public UserNameAlreadyExistsException(String message, Exception rootException)
    {
        super(message, rootException);
    }

    public UserNameAlreadyExistsException(String message)
    {
        super(message);
    }
}
