package com.o2.finance.exception.unchecked;

/**
 * Purpose:
 * com.o2.finance.exception.unchecked
 * User: D Smith
 * Date: 22/06/2011
 */
public class RuntimeServiceException extends RuntimeFinanceException
{
    private static final long serialVersionUID = -7202514867518627170L;

    private String errorNumber = "";


    public RuntimeServiceException( Class clazz, String methodName, Throwable throwable )
    {
        super( clazz, methodName, throwable );
    }

    public RuntimeServiceException( Class clazz, String methodName, Throwable throwable, String errorNumber)
    {
        super( clazz, methodName, throwable );
        this.errorNumber = errorNumber;
    }

}
