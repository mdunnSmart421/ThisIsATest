package com.o2.finance.exception;

/**
 * Purpose: com.o2.finance.exception User: D Smith Date: 18/03/2011
 */
public class VerificationCodeTriesExceededException extends FinanceException
{
    private static final long serialVersionUID = 7063990871299389392L;

    /**
     * Non-default constructor
     * 
     * @param message
     * @param rootException
     */
    public VerificationCodeTriesExceededException(String message, Exception rootException)
    {
        super(message, rootException);
    }

    public VerificationCodeTriesExceededException(String message)
    {
        super(message);
    }
}
