package com.o2.finance.taglib;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

import com.o2.registration.phase2.exception.NamePropertiesNotFoundException;
import com.o2.registration.phase2.util.PropertyLoader;

/**
 * Provide the base builder class.
 * 
 * This class build out strings based upon a template provided by a sub-class.
 * 
 * By default a given properties file is loaded and protocol and URI parameters are read and passed to the string build process.
 * 
 * @author swatson
 */
public abstract class ProductRegistrationTag extends TagSupport
{
    private static final long serialVersionUID = 7120863512222942984L;
    private static final Logger LOG = Logger.getLogger(ProductRegistrationTag.class.getName());

    /**
     * Provides a properties file where protocol and uri values are stored. These will be passed to the
     * {@link #buildOutString(String,String)} method.
     * 
     * @return property file path i.e. /finance/application.properties
     */
    protected abstract String getPropertyFileName();

    /**
     * Provides the property key for looking up the protocol value in the properties file {@link #getPropertyFileName()}
     * 
     * @return property name for protocol
     */
    protected abstract String getProtocol();

    /**
     * Provides the property key for looking up the URI value in the properties file {@link #getPropertyFileName()}
     * 
     * @return property name for URI
     */
    protected abstract String getUri();

    /**
     * Builds an 'out' string based upon a protocol and URI.
     * 
     * @param protocol
     * @param uri
     * @return out value
     */
    protected abstract String buildOutString(String protocol, String uri);

    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.jsp.tagext.TagSupport#doEndTag()
     */
    public int doEndTag() throws JspException
    {
        return EVAL_PAGE;
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()
     */
    public int doStartTag() throws JspException
    {
        try
        {
            /*
             * Load the properties from the given file and build an 'out' string.
             */
            Properties props = PropertyLoader.getProperties(getPropertyFileName());
            String protocol = props.getProperty(getProtocol());
            String uri = props.getProperty(getUri());
            if (null != uri)
            {
                pageContext.getOut().print(buildOutString(protocol, uri));
            }
        } catch (NamePropertiesNotFoundException ex)
        {
            LOG.error(ex);
        } catch (IOException ex)
        {
            LOG.error(ex);
        }
        return SKIP_BODY;
    }
}
