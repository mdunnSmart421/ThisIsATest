package com.o2.finance.service.adapter;

import com.o2.finance.exception.unchecked.RuntimeServiceException;
import com.o2.finance.properties.PropertyManager;
import com.o2.finance.service.handler.LoggingHandler;
import com.sun.crypto.provider.SunJCE;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import weblogic.webservice.client.SSLAdapterFactory;
import weblogic.webservice.client.WLSSLAdapter;
import weblogic.webservice.context.WebServiceContext;
import weblogic.webservice.core.handler.WSSEClientHandler;
import weblogic.webservice.core.rpc.ServiceImpl;
import weblogic.webservice.core.rpc.StubImpl;
import weblogic.xml.security.wsse.Security;
import weblogic.xml.security.wsse.SecurityElementFactory;
import weblogic.xml.security.wsse.Token;

import javax.xml.namespace.QName;
import javax.xml.rpc.handler.Handler;
import javax.xml.rpc.handler.HandlerInfo;
import javax.xml.rpc.handler.HandlerRegistry;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.rmi.Remote;
import java.security.KeyManagementException;
import java.util.ArrayList;

/**
 * Purpose:
 * com.o2.finance.service.adapter
 * User: D Smith
 * Date: 09/07/2011
 */
public abstract class SoaServiceClientAdapter
{


    //TODO logging
    Logger log = LogManager.getLogger( this.getClass() );

    protected QName portName;

    protected Remote port;

    protected ServiceImpl  serviceImplementation;


    private final String SSLADAPTER = "weblogic.webservice.client.ssladapter";

//    protected void addHandler( Handler handler ) //, ServiceImpl service, String endpoint, String port)
//    {
//        log.info( "addHandler start." );
//        HandlerInfo handlerInfo = new HandlerInfo( handler.getClass(), null, null );
//
//        addHandlerInfo( handlerInfo );
//        log.info( "addHandler ends." );
//
//    }

//    private void addHandlerInfo( HandlerInfo handlerInfo )
//    {
//        log.info( "addHandlerInfo start." );
//        HandlerRegistry registry = getServiceImpl().getHandlerRegistry();
//
//        registry.getHandlerChain( getPortName() ).add( handlerInfo );
//        log.info( "addHandlerInfo ends." );
//    }


    protected void setupBasicSecurityHeaderHandler()
    {
        log.info( "setupBasicSecurityHeaderHandler start." );
        String username = PropertyManager.getApplicationProperties().getSoaWsSecurityUsername();
        log.debug( "username is" + username  );

        String password = PropertyManager.getApplicationProperties().getSoaWsSecurityPassword();
        log.debug( "password is " + password );

        SecurityElementFactory factory = SecurityElementFactory.getDefaultFactory();
        log.debug( "Factory created" );

        Token token = factory.createToken( username, password );
        log.debug( "Token created" );

        Security security = factory.createSecurity( null );
        log.debug( "security created." );

        security.addToken( token );
        log.debug( "token added to security." );



        WebServiceContext context = serviceImplementation.context();
        log.debug( "Got context." );

        context.getSession().setAttribute( WSSEClientHandler.REQUEST_SECURITY, security );
        log.debug( "Setting security property." );

//        addHandlerInfo( new HandlerInfo( WSSEClientHandler.class, null, null ) );
        log.info( "setupBasicSecurityHeaderHandler ends." );

    }


    protected HandlerInfo getTwoWaySSLHandlerInfo()
    {
        log.info( "getTwoWaySSLHandlerInfo start." );


        HandlerInfo handlerInfo = null;

        WLSSLAdapter adapter = new WLSSLAdapter();

        String password = PropertyManager.getApplicationProperties().getTwoWayClientKeyPassword();

        try
        {

            adapter.setVerbose( true );

            // set identity certificate
            adapter.loadLocalIdentity( getClientIdentityCertificate(), password.toCharArray() );


            // set trust store

            String trustedKeystore =  PropertyManager.getApplicationProperties().getTwoWaySSLClientTrustedStore();
            log.info( "Trusted keystore file is " + trustedKeystore );

            adapter.setTrustedCertificatesFile( trustedKeystore );

            SSLAdapterFactory.getDefaultFactory().setDefaultAdapter( adapter );
            SSLAdapterFactory.getDefaultFactory().setUseDefaultAdapter( true );

            (( StubImpl ) port )._setProperty( SSLADAPTER, SSLAdapterFactory.getDefaultFactory().getDefaultAdapter() );

        }
        catch (KeyManagementException e)
        {
            log.error( e.getMessage(), e );
            throw new RuntimeServiceException( this.getClass(), "getTwoWaySSLHandlerInfo", e );
        }

        log.info( "getTwoWaySSLHandlerInfo ends." );
        return handlerInfo;

    }



    private InputStream getClientIdentityCertificate()
    {
        log.info( "getClientIdentityCertificate start." );

        InputStream stream =  this.getClass().getResourceAsStream( PropertyManager.getApplicationProperties().getTwoWayClientKeyFile() );

        log.info( "getClientIdentityCertificate ends." );
        return stream;

    }


    protected void setHandlerChain( ArrayList serviceHandlers )
    {
        HandlerRegistry registry = serviceImplementation.getHandlerRegistry();
        registry.setHandlerChain( portName,  serviceHandlers );
    }




    protected void setupHandlers()
    {
        ArrayList handlers = new ArrayList();
        log.info( "Add handler to log inbound and outbound messages" );

        handlers.add(  new HandlerInfo( LoggingHandler.class, null, null  ) );

        if ( PropertyManager.getApplicationProperties().getSoaWsSecurityOn() )
        {

            log.info( "add handler for basic WSSE auth." );
            setupBasicSecurityHeaderHandler();


            log.info( "Initialise two way SSL." );
            getTwoWaySSLHandlerInfo();

            handlers.add( new HandlerInfo( WSSEClientHandler.class, null, null ) );
        }


        setHandlerChain( handlers  );


    }

}
