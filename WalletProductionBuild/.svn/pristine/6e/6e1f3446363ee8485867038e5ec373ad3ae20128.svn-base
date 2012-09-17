package com.o2.finance.util;

import org.apache.log4j.PropertyConfigurator;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Properties;

/**
 * Purpose: com.o2.finance.util User: D Smith Date: 15/03/2011
 */
public class TestSetup
{
    public static void initialiseLog4j()
    {
        String propFile = "/finance.log.properties";
        try
        {
            // load log4j properties
            Properties props = PropertyLoader.getProperties(propFile);
            PropertyConfigurator.configure(props);
        } catch (Exception ex)
        {
            // CHECKSTYLE:OFF - This enables us to print to the console
            System.err.println("Lg4jInit **ERROR** Initializing Log4J from properties file - " + propFile + " : "
                    + ex.getMessage());
            // CHECKSTYLE:ON
            ex.printStackTrace();
        }
    }

    public static HttpServletRequest createRequest()
    {
        HttpServletRequest request = (HttpServletRequest) Mockito.mock(HttpServletRequest.class);
        HttpSession session = (HttpSession) Mockito.mock(HttpSession.class);
        Mockito.when(request.getSession()).thenReturn(session);
        // Mockito.when( session.setAttribute(
        // SessionConstants.FINANCE_MODEL,Mockito.any( FinanceLocalModel.class ) ) ).thenReturn( "gad" )
        // Mockito.when( session.getAttribute( Mockito.anyString() ) ).thenAnswer( new Answer()
        // {
        // public Object answer( InvocationOnMock invocationOnMock ) throws Throwable
        // {
        // return "asdfasdf";
        // }
        // } );
        return request;
    }

    public static HttpServletResponse createResponse()
    {
        return (HttpServletResponse) Mockito.mock(HttpServletResponse.class);
    }

    public static HttpSession createSession()
    {
        return (HttpSession) Mockito.mock(HttpSession.class);
    }
}
// request.getSession().setAttribute( SessionConstants.FINANCE_MODEL, model );
// request.getSession().setAttribute( "test", "wombat" );
// Mockito.when( request.getSession().getAttribute( SessionConstants.FINANCE_MODEL ) ).thenAnswer( new Answer()
// {
// public Object answer( InvocationOnMock invocationOnMock ) throws Throwable
// {
// return new FinanceLocalModel();
// }
// } );