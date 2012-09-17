package com.o2.finance.exception;



/**
 * Purpose: Thrown when the createUser call fails due to the chosen username is in the reservedusername table.
 * mdunn Date: 30/04/2012
 */
public class UsernameExistsInReservedUsernameTableException extends FinanceException
{
	 /**
	 * 
	 */
	private static final long serialVersionUID = -1785606630930019020L;

	/**
     * Non-default constructor
     * 
     * @param message
     * @param rootException
     */
    public UsernameExistsInReservedUsernameTableException(String message, Exception rootException)
    {
        super(message, rootException);
    }

    public UsernameExistsInReservedUsernameTableException(String message)
    {
        super(message);
    }
}


