package com.o2.finance.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.o2.finance.util.exception.NamePropertiesNotFoundException;

/**
 * Used to hold properties files used by the application. Will load and store a file if it does not already have it when asked for
 * it.
 * 
 * This class should be loaded on app server startup, and a ref to it should be held for the lifetime of the app server
 * 
 * However, this is not loaded at app server startup for many of the properties files to be loaded.
 */
public class PropertyLoader
{
    /*
     * History: 10/03/2003 BJB - recoded to provide additional parameter on getProperties to enable caller to specify that
     * Phase2Exception should not be called. Also added 'classLock' static var to enable synchronisation of property file loading.
     */
    private static Map properties = new HashMap();
    private static final Object classLock = PropertyLoader.class;

    /**
     * Loads the properties file with the given name
     * 
     * @param propertiesName
     *            The name of the resource (file) containing the properties to be loaded
     * 
     * @return The Properties object loaded from the resource
     * @exception NamePropertiesNotFoundException
     * @exception IOException
     */
    public static Properties getProperties(String propertiesName) throws IOException
    {
        Properties props = (Properties) properties.get(propertiesName);
        if (props == null)
        {
            synchronized (classLock)
            {
                // classLock is a static final instance of PropertyLoader.class
                // This will lock the class to enable loading of this properties file
                // in a thread safe manner, without always synchronising the entire method
                // which would result in a major performance bottleneck.
                props = new Properties();
                InputStream is = PropertyLoader.class.getResourceAsStream(propertiesName);
                if (is != null)
                {
                    props.load(is);
                    properties.put(propertiesName, props);
                    is.close();
                } else
                {
                    throw new IOException("Properties file : " + propertiesName + " not found.");
                }
            }
        }
        return props;
    }
}
