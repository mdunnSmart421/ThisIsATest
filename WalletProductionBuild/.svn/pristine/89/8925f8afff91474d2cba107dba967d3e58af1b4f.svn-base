package com.o2.finance.service;

import java.io.InputStream;
import java.net.URL;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.context.ConfigurationContextFactory;
import org.apache.axis2.description.TransportOutDescription;
import org.apache.axis2.engine.AxisConfiguration;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.neethi.Policy;
import org.apache.neethi.PolicyEngine;

import com.o2.finance.properties.ApplicationProperties;
import com.o2.finance.properties.PropertyManager;
import com.o2.finance.protocol.ProtocolRegistry;

/**
 * This is a super class for all services that communicate with a web service and
 * must authenticate using Two Way SSL.
 * 
 * @author SWatson
 *
 */
public class TwoWaySSLSupportingService
{
    Logger log = LogManager.getLogger( this.getClass() );
    private static ConfigurationContext context;

    /**
     * Default constructor, registers the protocols required
     * for two way ssl.
     */
    protected TwoWaySSLSupportingService()
    {
        ProtocolRegistry.registerTwoWaySSLProtocol();
    }
    
    /**
     * Creates an AXIS2 configuration context that handles two way SSL,
     * and allows for AXIS2 WS-* extension modules to be applied, for
     * example <i>Rampart</i> which allows WS-Security policies to be
     * applied to SOAP web service requests. 
     * 
     * @return ConfigurationContext
     * @throws Exception
     */
    protected synchronized ConfigurationContext getConfigurationContext()
    throws Exception
    {
        log.info( "getConfigurationContext start." );

        if(context == null)
        {
	        ApplicationProperties props = PropertyManager.getApplicationProperties();
	
	        log.debug( "Getting AXIS2 configuration." );
	        // Path to basic default AXIS2 configuration file on the classpath.
	        String axis2Config     = props.getAxis2Config();
	        URL axis2xml           = this.getClass().getResource(axis2Config);
	
	        log.debug( "axis2xml url is " + axis2xml.toString() );
	
	
	        log.debug( "Getting path to axis2 repository." );
	        // Path to the repository containing any WS-* extension modules.
	        String axis2Repository = props.getAxis2Repository();
	        URL repository         = null;
	
	        if(axis2Repository != null && axis2Repository.trim().length() > 0)
	        {
	            repository = this.getClass().getResource(axis2Repository);
	        }
	
	        if ( null == repository )
	        {
	            log.debug( "repository is null." );
	        } else
	        {
	            log.debug( "repository url is " + repository.toString() );
	        }
	        
	        if(axis2xml != null)
	        {
	            /*
	             * AXIS2 configuration has been specified so use it.
	             * This should contain a module setting for rampart
	             */
	            log.debug( "Creating custom axis configuration." );
	            context = ConfigurationContextFactory.createConfigurationContextFromURIs(axis2xml, repository);
	        }
	        else
	        {
	            // No AXIS" configuration has been specified so use the default (see AXIS2 docs)
	            log.debug( "Using default axis configuration." );
	            context = ConfigurationContextFactory.createDefaultConfigurationContext();
	        }
        }
	        
        /*
         * Obtain the AxisConfiguration and add the TransportOut handling for
         * the HTTPC protocol see ProtocolRegistry.registerTwoWaySSLProtocol().
         * 
         * Basically copies all the settings from HTTPS
         */
        log.debug( "Configuring protocols." );
        AxisConfiguration config  = context.getAxisConfiguration();

        TransportOutDescription httpsout = config.getTransportOut("https");

        log.debug( "Creating httpc protocol handler." );
        TransportOutDescription httpcout = new TransportOutDescription("httpc");


        httpcout.setFaultFlow(httpsout.getFaultFlow());
        httpcout.setFaultPhase(httpsout.getFaultPhase());
        httpcout.setOutFlow(httpsout.getOutFlow());
        httpcout.setOutPhase(httpsout.getOutPhase());
        httpcout.setSender(httpsout.getSender());

        log.debug( "Adding httpc handler to config." );
        config.addTransportOut(httpcout);
        
        log.info( "getConfigurationContext ends." );

        return context;
    }

    /**
     * Loads the WS Policy document.
     * 
     * @param name - classpath: location for the WS policy document
     * @return Policy
     * @throws XMLStreamException
     */
    protected Policy loadPolicy(String name) 
    throws XMLStreamException 
    {
        InputStream   resource = this.getClass().getResourceAsStream(name);
        StAXOMBuilder builder  = new StAXOMBuilder(resource);
        Policy        policy   = PolicyEngine.getPolicy(builder.getDocumentElement());
        
        return policy;
    }
}
