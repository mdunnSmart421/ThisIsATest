package com.o2.finance.protocol;

import java.io.IOException;
import java.net.URL;
import java.security.GeneralSecurityException;

import org.apache.commons.httpclient.contrib.ssl.AuthSSLProtocolSocketFactory;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.httpclient.protocol.ProtocolSocketFactory;
import org.apache.commons.ssl.HttpSecureProtocol;

import com.o2.finance.properties.ApplicationProperties;
import com.o2.finance.properties.PropertyManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * This class is responsible for registering a new protocol to be used for two
 * way SSL without having to override the existing default settings of HTTPS.
 * 
 * The protocol HTTPC is created and registered to user HttpClients 
 * <i>AuthSSLProtocolSocketFactory</i> to manage the client side certificate.
 * 
 * Certificate keystore locations and passwords are held in {@link ApplicationProperties}
 * 
 * The HTTPC uses the same protocol handler as HTTPS and is located in the package
 * <i>com.o2.finance.protocol</i> the System.property <i>java.protocol.handler.pkgs</i>
 * is set programmatically within this class to point to this pachkage.
 * 
 * @author SWatson
 *
 */
public class ProtocolRegistry
{


    static Logger log = LogManager.getLogger( ProtocolRegistry.class );

    private static ProtocolRegistry instance;
    
    private ProtocolRegistry(){};
    
    public static void registerTwoWaySSLProtocol()
    {
        getInstance();
    }
    
    private static ProtocolRegistry getInstance()
    {
        if(instance == null)
        {
            init();
        }
        
        return instance;
    }
    
    private static synchronized void init()
    {
        log.info( "init start." );
        if(instance == null)
        {
            log.debug( "Creating new ProtocolRegistry." );
            ProtocolRegistry registry = new ProtocolRegistry();
            
            // Load keystore information from the properties file
            log.debug( "Loading keystores." );
            ApplicationProperties props = PropertyManager.getApplicationProperties();
            String  keystorePath        = props.getTwoWaySSLClientKeystore();
            String  trustedPath         = props.getTwoWaySSLClientTrustedStore();
            boolean checkHostname       = props.getTwoWaySSLClientCheckHostname();

            log.debug( "Keystore path is " + keystorePath );
            log.debug( "Trusted path is " + trustedPath );

            URL    keystore          = null;
            String keystorePasswd    = null;

            if(keystorePath != null && keystorePath.trim().length() > 0)
            {
                keystore       = registry.getClass().getResource(keystorePath);
                if ( null == keystore )
                {
                    log.debug( "Keystore url is null.");

                } else
                {
                    log.debug( "Keystore url is " + keystore.toString() );
                }
                keystorePasswd = props.getTwoWaySSLClientKeystorePasswd();
            }
            
            /*
             * It is only necessary to have a trusted store if the server uses a 
             * certificate that is not covered by the default trusted parties.
             * see $JAVA_HOME/jre/lib/security/cacerts
             */
            URL    trusted       = null;
            String trustedPasswd = null;


            // java store used for trust if trusted  & trustedPasswd


            if(trustedPath != null && trustedPath.trim().length() > 0)
            {
                log.debug( "Getting path to custom trust store." );
                trusted       = registry.getClass().getResource(trustedPath);
                trustedPasswd = props.getTwoWaySSLClientTrustedStorePasswd();
            }




            try
            {
                log.debug( "Creating new protocol." );
                ProtocolSocketFactory protocol = new AuthSSLProtocolSocketFactory(keystore, 
                                                                                  keystorePasswd, 
                                                                                  trusted,
                                                                                  trustedPasswd);
                if (protocol instanceof HttpSecureProtocol)
                {
                    ((HttpSecureProtocol) protocol).setCheckHostname(checkHostname);
                }
                
                /*
                 * Clone the HTTPS registered protocol replace the ProtocolSocketFactory to use 
                 * AuthSSLProtocolSocketFactory and register as HTTPC.
                 */
                Protocol https = Protocol.getProtocol("https");
                log.debug( "Unregistering httpc protocol." );
                Protocol.unregisterProtocol("httpc");
                log.debug( "Registering httpc protocol based on current https protocol." );
                Protocol.registerProtocol("httpc", new Protocol(https.getScheme(), protocol, https.getDefaultPort()));
                
                // Points to the protocol handler for HTTPC
                log.debug( "Setting system property to use new protocol." );
                        System.setProperty( "java.protocol.handler.pkgs", "com.o2.finance.protocol" );
                
                instance = registry;
            } 
            catch (GeneralSecurityException gse)
            {
                log.debug( "Caught exception " + gse.toString() );
                throw new RuntimeException(gse);
            } 
            catch (IOException ioe)
            {
                log.debug( "Caught exception " + ioe.toString() );
                throw new RuntimeException(ioe);
            }
            
        }
    }
}
