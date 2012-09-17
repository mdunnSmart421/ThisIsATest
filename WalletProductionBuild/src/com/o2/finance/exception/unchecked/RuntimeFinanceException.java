package com.o2.finance.exception.unchecked;

import org.apache.axis2.AxisFault;

/**
 * Purpose: com.o2.finance.exception.unchecked User: D Smith Date: 22/06/2011
 */
public class RuntimeFinanceException extends RuntimeException
{
    private static final long serialVersionUID = 7247290004395863959L;

    String message;

    String faultCode = "";
    String faultDetail = "";


    public RuntimeFinanceException( Class clazz, String methodName, Throwable throwable )
    {
        super(throwable);
        String className = clazz.getName();
        this.message = formatError(className, methodName, throwable);

        if ( null != throwable )
        {
            processThrowable( throwable );
        }
    }


    private void processThrowable( Throwable ex )
    {
        if ( ex instanceof AxisFault )
        {

            AxisFault fault = ( AxisFault ) ex;

            if ( null != fault.getFaultCode() )
            {
                this.faultCode =   fault.getFaultCode().getLocalPart();
            }


            if (null != fault.getDetail() )
            {
                this.faultDetail = fault.getDetail().getText();
            }

        }
    }



    public RuntimeFinanceException( Class clazz, String methodName, String message, Throwable throwable )
    {
        super( throwable );
        this.message = formatError( clazz.getName(), methodName, message, throwable );

    }

    private String formatError(String className, String methodName, Throwable ex)
    {
        StringBuffer buffer = new StringBuffer();
        buffer.append("[").append(className).append(".").append(methodName).append("]");
        if ( null != ex )
        {
            buffer.append(" [").append(ex.getMessage()).append("]");

        }

        return buffer.toString();
    }



    private String formatError(String className, String methodname, String message, Throwable ex)
    {
        StringBuffer buffer = new StringBuffer(  );
        buffer.append( formatError( className, methodname, ex   ) );
        buffer.append( " " ).append( message );
        return buffer.toString();
    }



    public String getMessage()
    {
        return message;
    }

    public String toString()
    {
        StringBuffer buffer = new StringBuffer();

        buffer.append(super.toString());
        if ( null != faultCode && ! "".equalsIgnoreCase( faultCode  ))
        {
            buffer.append( "\nfault code:" + this.faultCode );
        }

        if ( null != faultDetail && ! "".equalsIgnoreCase( faultDetail  ))
        buffer.append( "\nfault detail:" + this.faultDetail );
        return buffer.toString();
    }
}
