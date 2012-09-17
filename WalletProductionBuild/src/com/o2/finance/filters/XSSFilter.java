package com.o2.finance.filters;

import java.io.IOException;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import com.o2.registration.model.FeedbackVO;


/**
 * 
 * Filter to validate HTTP request query params to ensure that 
 * they does not contain any of the following chars - ", &, ', < and >.
 * This is to prevent XSS (Cross-Site Scripting) attacks.
  
 * @author Vkancherla
 * @date 16 Aug 2010
 */
public class XSSFilter implements Filter
{
	private static Logger log = LogManager.getLogger(XSSFilter.class);
	
    private static final String CLASS_NAME = "XSSFilter";

    private static final String XSS_CHARS_SEARCH_REGEX="[\"&'<>]";
    
    public void init(FilterConfig config) throws ServletException 
	{
    	//  Not required but have to implement for interface javax.servlet.filter
	}

   
    /***
     * doFilter implementation - ensure that if there are any
     * request query params present, that they do not contain
     * any XSS blacklisted chars.
     * 
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    public void doFilter( ServletRequest servletRequest, 
    		ServletResponse servletResponse, FilterChain filterChain ) 
    		throws IOException, ServletException
    {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        if ( null != request.getQueryString() )
        {
        	      	
        	String requestURL = request.getRequestURL().toString();
        	String requestURI = request.getRequestURI();

        	Pattern pattern = Pattern.compile(XSS_CHARS_SEARCH_REGEX);        	
        	
        	StringTokenizer sTokenzier = 
        		new StringTokenizer(request.getQueryString(), "&");
        	    	
        	while ( sTokenzier.hasMoreTokens() )
        	{
        		String queryParamValue = sTokenzier.nextToken();
        		   		
        		Matcher matcher = pattern.matcher(queryParamValue);
        		
        		if ( matcher.find() )
        		{
        			logXssValidation( "doFilter", " *** The URL ["+requestURL+"] " 
        					+ " contains the Param-Value pair [" + queryParamValue
        					+ "] which contains chars that can potentially be" 
        					+ " used for XSS attacks *** " );
        			
        			FeedbackVO feedback = new FeedbackVO();
        			feedback.setDesc("Disallowed characters found in the request.");
        			request.setAttribute("feedback", feedback);
                	
        			String responseURL = requestURL.replaceAll(requestURI, "/error.jsp");
        			
                	HttpServletResponse response = (HttpServletResponse) servletResponse;
        			response.sendRedirect(responseURL);
        			
        			return;
        		}		    
        	}        	
        }
        
        filterChain.doFilter( servletRequest, servletResponse );

    }

    /***
     * Implementation (empty) of destroy method.
     */
    public void destroy()
    {
        // Not required but have to implement for interface javax.servlet.filter
    }


	/***
     * Helper method to try and ensure consistency of logged messages from this class
     * @param methodName name of method wanting to log a message
     * @param message the message being logged
     */
    private static void logXssValidation(String methodName, String message )
    {
        log.debug( "[" + CLASS_NAME + "." + methodName + "] : " + message);

    }

}
