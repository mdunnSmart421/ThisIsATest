package com.o2.finance.util.exception;

public class NamePropertiesNotFoundException extends Exception
{
    private static final long serialVersionUID = 989481101969875783L;

    public NamePropertiesNotFoundException(String message, Exception rootException)
    {
        super(message, rootException);
    }
}
