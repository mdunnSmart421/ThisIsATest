package com.o2.finance.servlet;

import java.io.InputStream;
import java.util.Properties;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.PropertyConfigurator;

import com.o2.finance.util.PropertyLoader;

/**
 * Purpose: com.o2.finance.servlet User: D Smith Date: Mar 13, 2011
 */
public class Log4jInit extends HttpServlet
{
    private static final long serialVersionUID = -4051271148937684354L;

    public void init()
    {
        initialiseLog4j();
    }

    private void initialiseLog4j()
    {
        String logFilePath = null;
        try
        {
            Properties props = null;
            logFilePath = getServletConfig().getInitParameter("log4j-init-file");
            if (logFilePath != null && logFilePath.trim().length() > 0)
            {
                InputStream is = getServletContext().getResourceAsStream(logFilePath);
                props = new Properties();
                props.load(is);
            } else
            {
                props = PropertyLoader.getProperties(logFilePath);
            }
            PropertyConfigurator.configure(props);
        } catch (Exception ex)
        {
            // CHECKSTYLE:OFF - This enables us to print to the console
            System.err.println("Log4jInit **ERROR** Initializing Log4J from properties file - " + logFilePath
                    + " : " + ex.getMessage());
            // CHECKSTYLE:ON
            ex.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res)
    {
    }
}
