package com.o2.finance.properties;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;

import com.o2.finance.util.PropertyLoader;

public abstract class FinanceProperties
{
    private Properties properties;

    protected FinanceProperties()
    {
        try
        {
            properties = PropertyLoader.getProperties(getPropertyFile());
        } catch (IOException e)
        {
            throw new RuntimeException("Error reading properties file : " + getPropertyFile(), e);
        }
    }

    protected abstract String getPropertyFile();

    public String getProperty(String property)
    {
        return properties.getProperty(property);
    }

    public boolean getBooleanProperty(String property)
    {
        return "true".equalsIgnoreCase(getProperty(property)) || "y".equalsIgnoreCase(getProperty(property));
    }

    public int getIntProperty(String property)
    {
        return Integer.parseInt(getProperty(property));
    }

    public String getProperty(String property, String defaultValue)
    {
        return properties.getProperty(property, defaultValue);
    }

    public boolean getBooleanProperty(String property, String defaultValue)
    {
        return "true".equalsIgnoreCase(getProperty(property, defaultValue))
                || "y".equalsIgnoreCase(getProperty(property, defaultValue));
    }

    public int getIntProperty(String property, String defaultValue)
    {
        return Integer.parseInt(getProperty(property, defaultValue));
    }

    public List getListProperty(String property)
    {
        return toList(getProperty(property));
    }

    public List getListProperty(String property, String defaultValue)
    {
        return toList(getProperty(property, defaultValue));
    }

    private List toList(String value)
    {
        List values = new ArrayList();
        if (value != null && value.trim().length() > 0)
        {
            StringTokenizer tokens = new StringTokenizer(value, ",");
            while (tokens.hasMoreTokens())
            {
                String token = tokens.nextToken();
                if (token != null && token.trim().length() > 0)
                {
                    values.add(token.trim());
                }
            }
        }
        return values;
    }
}
