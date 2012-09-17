package com.o2.finance.filters;

import com.o2.finance.etc.SessionConstants;
import com.o2.finance.util.TransactionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Purpose:
 * com.o2.finance.filters
 * User: D Smith
 * Date: 04/07/2011
 */
public class MDCFilter implements Filter, SessionConstants
{

    Logger log = LogManager.getLogger( this.getClass() );


    public void init( FilterConfig filterConfig ) throws ServletException
    {

    }

    public void doFilter( ServletRequest request, ServletResponse response, FilterChain filterChain ) throws IOException, ServletException
    {
        // If a session identifier exists on the Session use this,
        // otherwise create a new one.

        String financeSessionId = null;

        if ( request instanceof HttpServletRequest)
        {
            HttpSession session = ( (HttpServletRequest) request ).getSession();

            if ( null != session )
            {
                financeSessionId = (String) ( session.getAttribute( SESSION_ID ) );

                if ( null == financeSessionId || "".equalsIgnoreCase( financeSessionId ) )
                {
                    TransactionUtils.setThreadLocalId();
                    financeSessionId = TransactionUtils.getTransactionId();
                    log.info( "financeSessionId is " + financeSessionId);
                    session.setAttribute( SESSION_ID, financeSessionId );
                }
            }
        }

        try
        {

            if ( null != financeSessionId  )
            {
                MDC.put("financeSessionId", financeSessionId);
            }

            filterChain.doFilter( request, response );

        }
        finally
        {
            MDC.remove( "financeSessionId" );
        }

    }

    public void destroy()
    {

    }
}
