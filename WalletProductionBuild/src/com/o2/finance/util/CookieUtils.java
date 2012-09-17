/**
 * Developed by Smart421 (www.smart421.com).
 * (c) Copyright 2011 Telefonica O2 UK Limited.
 */
package com.o2.finance.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Purpose: Get cookie values from the HTTP request
 */
public final class CookieUtils
{
    private static final Logger log = LogManager.getLogger( CookieUtils.class );

    /**
     * Private constructor to avoid multiple instances of the class
     */
    private CookieUtils()
    {
	
    }

    /**
     * Method to find a cookie in the HTTP request.
     * 
     * @param cookieName
     *            is the name of the cookie to search for
     * @param request
     *            the HTTPServletRequest containing the cookies
     * @return String is the value of the cookie otherwise "" is returned.
     */
    public static String getCookieValue(String cookieName, HttpServletRequest request)
    {
        log.info( "getCookieValue start." );
        Cookie[] cookies;
        cookies = request.getCookies();

        String result = "";

        if ( null != cookies )
        {
            for (int i = 0; i < cookies.length; i++)
            {
                if ((cookies[i].getName() != null) && (cookies[i].getName().equalsIgnoreCase(cookieName)))
                {
                    result = cookies[i].getValue();
                    log.debug( "Cookie name [" + cookieName + "] has value [" + result + "]." );
                    break;
                }
            }
        }
        log.info( "getCookieValue ends." );
        return result;
    }

    private static boolean isCookieSet( HttpServletRequest request, String cookieName)
    {
        log.info( "isCookieSet start." );

        boolean result = false;

        Cookie[] cookies = request.getCookies();
        if (null != cookies )
        {
            for ( int i = 0; i < cookies.length; i++)
            {
                if (( cookies[i].getName() != null ) && ( cookies[i].getName().endsWith( cookieName ) ) )
                {
                    log.debug( "Cookie named [" + cookieName + "] found." );
                    result = true;
                    break;
                }
            }
        }
        log.info( "isCookieSet ends." );
        return result;
    }

    /***
     * Sets a cookie with the supplied name and value. If a cookie with the same name is found, it will not be changed.
     * 
     * Note, this will fail if the user's clock is more than a year out of date.
     * @param request
     * @param response
     * @param cookieName
     * @param cookieValue
     * @param domain
     */
    public static void setCookie(HttpServletRequest request,  HttpServletResponse response, String cookieName, String cookieValue )
    {
        setCookie(request, response, cookieName, cookieValue, false);
    }
    
    /**
     * Sets a cookie with the supplied name and value. If the boolean value is true, any existing cookie with the same name will 
     * be replaced, otherwise the cookie will not be changed.
     * 
     * Note, this will fail if the user's clock is more than a year out of date.
     * @param request
     * @param response
     * @param cookieName
     * @param cookieValue
     * @param replaceExisting
     */
    public static void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName, String cookieValue, boolean replaceExisting)
    {
	log.info( "setCookie start." );
        final int SECONDS_PER_YEAR = 60*60*24*365;
        
        if (replaceExisting || ! isCookieSet( request, cookieName ))
        {
            Cookie cookie = new Cookie( cookieName, cookieValue);
            cookie.setMaxAge( SECONDS_PER_YEAR );

            log.debug( "Setting cookie [" + cookieName + "] with value [" + cookieValue + "].");
            response.addCookie( cookie );
        }

        log.info( "setCookie ends." );
    }
}
