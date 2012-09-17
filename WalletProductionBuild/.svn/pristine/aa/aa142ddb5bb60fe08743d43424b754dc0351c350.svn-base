package com.o2.finance.service;

/**
 * Created by IntelliJ IDEA.
 * User: dave
 * Date: 26/02/2012
 * Time: 09:36
 * To change this template use File | Settings | File Templates.
 */


import com.o2.finance.properties.ApplicationProperties;
import com.o2.finance.properties.PropertyManager;
import com.o2.finance.protocol.ProtocolRegistry;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.apache.axis2.AxisFault;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.context.ConfigurationContextFactory;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.neethi.Policy;
import org.apache.neethi.PolicyEngine;

import javax.xml.stream.XMLStreamException;
import java.io.InputStream;
import java.net.URL;

/**
 * This is a super class for all axis services that require basic auth
 */
public class BasicAuthSupportingService
{
    Logger log = LogManager.getLogger(this.getClass());
    private static ConfigurationContext context;

    protected BasicAuthSupportingService() {
//        ProtocolRegistry.registerTwoWaySSLProtocol();
    }

    protected synchronized ConfigurationContext getConfigurationContext() throws Exception {
        log.info("getConfigurationContext start.");

        if(context == null)
        {
            log.info("getConfigurationContext context==null.");
        	ApplicationProperties props = PropertyManager.getApplicationProperties();

	        log.debug("Getting AXIS2 configuration.");
	
	        // Path to basic default ACIS configuration file on the classpath
	        String axis2Config = props.getAxis2Config();
	        URL axis2xml = this.getClass().getResource(axis2Config);
	
	        log.debug("axis2 url is " + axis2xml.toString());
	
	        // Path to the repository containing an WS-* extension modules
	        String axis2Repository = props.getAxis2Repository();
	        URL repository  = null;
	
	        if ( axis2Repository != null  && axis2Repository.trim().length() > 0)
	        {
	            repository = this.getClass().getResource(axis2Repository);
	        }
	
	        if ( null == repository )
	        {
	            log.debug("repository is null,");
	        } else
	        {
	            log.debug("repository url is " + repository.toExternalForm());
	        }
	
	        if ( axis2xml != null )
	        {
	            /*
	             * Axis2 configuratiokn has been specified so use it.
	             * This should contain a module for rampart
	             */
	            log.debug("Creating custom axis configuration.");
	            context = ConfigurationContextFactory.createConfigurationContextFromURIs(axis2xml,repository);
	        } else
	        {
	            // No AXIS2 configuration has been specified so use the default (see AXIS2 docs)
	            log.debug("Using default axis configuration.");
	            context = ConfigurationContextFactory.createDefaultConfigurationContext();
	        }
        }
        
        log.info("getConfigurationContext ends.");
        return context;


    }


  /**
     * Loads the WS Policy document.
     *
     * @param name - classpath: location for the WS policy document
     * @return Policy
     * @throws javax.xml.stream.XMLStreamException
     */
    protected Policy loadPolicy(String name)
    throws XMLStreamException
    {
        InputStream resource = this.getClass().getResourceAsStream(name);
        StAXOMBuilder builder  = new StAXOMBuilder(resource);

        Policy        policy   = PolicyEngine.getPolicy(builder.getDocumentElement());

        return policy;
    }


}
