package com.o2.finance.service.handler;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.xml.namespace.QName;
import javax.xml.rpc.handler.Handler;
import javax.xml.rpc.handler.HandlerInfo;
import javax.xml.rpc.handler.MessageContext;
import javax.xml.rpc.handler.soap.SOAPMessageContext;
import javax.xml.soap.SOAPPart;

/**
 * Purpose:
 * com.o2.finance.service.handler
 * User: D Smith
 * Date: 09/07/2011
 */
public class LoggingHandler implements Handler
{
    private HandlerInfo handlerInfo;

    Logger log = LogManager.getLogger( this.getClass() );

    public boolean handleRequest( MessageContext messageContext )
    {
        log.info( "handleRequest start." );
        log.info( "Request:" + getMessage( (SOAPMessageContext) messageContext ) );
        log.info( "handleRequest ends." );
        return true;
    }

    public boolean handleResponse( MessageContext messageContext )
    {
        log.info( "handleResponse start." );

        log.info( "Response:" + getMessage( (SOAPMessageContext) messageContext ) );

        log.info( "handleResponse ends." );
        return true;

    }

    private String getMessage( SOAPMessageContext messageContext )
    {
        return messageContext.getMessage().getSOAPPart().toString();
    }

    public boolean handleFault( MessageContext messageContext )
    {
        log.info( "handleFault start." );

        log.info( "Fault:" + getMessage( (SOAPMessageContext) messageContext ) );

        log.info( "handleFault ends." );

        return true;
    }

    public void init( HandlerInfo handlerInfo )
    {
        this.handlerInfo = handlerInfo;
    }

    public void destroy()
    {
        //
    }

    public QName[] getHeaders()
    {
        return handlerInfo.getHeaders();
    }
}
