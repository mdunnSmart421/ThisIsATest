package com.o2.finance.util;

import com.o2.finance.etc.DeviceConstants;
import com.o2.finance.etc.RequestParameterConstants;
import com.o2.finance.model.FinanceLocalModel;
import org.apache.commons.httpclient.Cookie;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.xpath.operations.And;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Hashtable;


/**
 * Purpose: provides utility methods to verify whether the requests are 
 * coming from a mobile device or not. And, also helps to load the correct
 * version of the jsp page (mobile/regular)
 * 
 * @author vkancherla  / D Smith
 * date 12.Oct.2011
 */
public final class MobileThemeSupportHelper implements DeviceConstants, RequestParameterConstants
{


    static HashMap deviceMapping = new HashMap(  );


    {
        deviceMapping.put( IPHONE, IPHONE );
        deviceMapping.put( ANDROID, ANDROID );
        deviceMapping.put( BLACKBERRY, BLACKBERRY );

    }

    static final Logger log = LogManager.getLogger( MobileThemeSupportHelper.class );

    /***
     * Determine the theme to use based on device name
     * @param device Name of device
     * @return Name of theme to use.
     */
    private static String getTheme( String device )
    {

        log.info( "getTheme start." );

        String theme = WEB;

        if (!( null == device ) && !( "".equalsIgnoreCase( device ) ))
        {
            log.debug( "Determining theme from device" );
            if (device.equalsIgnoreCase( IPHONE ))
            {
                theme = IPHONE;
            } else if (device.equalsIgnoreCase( BLACKBERRY ))
            {
                theme = BLACKBERRY;

            } else if (device.equalsIgnoreCase( ANDROID ))
            {
                theme = ANDROID;
            }
        }

        log.debug( "Theme determined as " + theme);

        log.info( "getTheme ends." );
        return theme;
    }


    /***
     * Determine theme to use based on request parameter 'device'
     * @param request HttpServletRequest
     * @return Name of theme to use.
     */
    public static String determineTheme( HttpServletRequest request )
    {
        log.info( "determineTheme start." );
        log.debug( "Reading device from request parameter." );

        String device = request.getParameter( DEVICE );

        String theme = getTheme( device );

        log.debug( "Theme determined as [" + theme + "].");

        log.info( "determineTheme ends." );

        return theme;

    }


//
//    /**
//     * Examines the modelAndView to retrieve the viewName requested, and alters this to return the equivalent
//     * mobile view page is destined for a recognised mobile device.
//     * @param modelAndView being requested
//     * @param model FinanceLocalModel containing session data.
//     * @param request HttpServletRequest.
//     * @return Name of view to be displayed.
//     */
//    public static String getViewName( ModelAndView modelAndView, FinanceLocalModel model, HttpServletRequest request )
//    {
//        log.info( "getViewName start." );
//        String requestedViewName = modelAndView.getViewName();
//
//        log.debug( "Requested viewname is " + requestedViewName );
//
//        String viewName =  getViewName( requestedViewName, model, request );
//
//
//
//        log.debug( "Viewname is now " + viewName );
//
//
//        log.info( "getViewName ends." );
//
//        return viewName;
//
//    }

    public static String getViewName( ModelAndView modelAndView, FinanceLocalModel model, HttpServletRequest request )
    {
        log.info( "getViewName start." );

        String requestedViewName = modelAndView.getViewName();

        log.debug( "Requested viewname is " + requestedViewName );

        String themeName;
        if ( ( null != model ) && ( null != model.getTheme()) )
        {
            themeName = getThemeName( model );
        } else
        {
            themeName = getThemeName( request );
        }


        String viewName = getViewName( requestedViewName, themeName);
        log.debug( "Viewname is now " + viewName );

        log.info( "getViewName ends." );

        return viewName;


    }





    /***
     * Try and get the name of the theme to use from cookies
     * @param request
     * @return name of theme
     */
    public static String getThemeName( HttpServletRequest request )
    {
        log.info( "getThemeName start." );

        String theme;

        theme = CookieUtils.getCookieValue( "theme", request );

        log.debug( "Theme determined from cookies to be [" + theme + "]." );

        log.info( "getThemeName ends." );

        return theme;
    }


    public static String getThemeName( FinanceLocalModel model )
    {
        // Get the theme from the localModel
        log.info( "getThemeName start." );

        String theme = null;

        if (( null != model ) && ( null != model.getTheme() ) )
        {
            theme = model.getTheme();
        }


        log.debug( "Theme determined from FinanceLocalModel to be [" + theme + "]." );


        log.info( "getThemeName ends." );

        return theme;

    }



//    /***
//     *  If theme is set on session, or as a cookie, then
//     ensure that the mobile equivalent page is requested.
//     Otherwise, the page to be displayed is not altered.
//
//     * @param viewName
//     * @param model
//     * @param request
//     * @return
//     */
//
//    public static String getViewName( String viewName, FinanceLocalModel model, HttpServletRequest request )
//    {
//        log.info( "getViewName start." );
//        String theme;
//
//        // Read the theme from the localModel if model not null
//        if (( null != model ) && ( null != model.getTheme() ))
//        {
//            log.debug( "Reading theme from local model." );
//            theme = model.getTheme();
//        } else // look for theme cookie
//        {
//
//            theme = CookieUtils.getCookieValue( "theme", request );
//
//        }
//
//
//        if (isMobileTheme( theme ))
//        {
//            log.debug( "Mobile theme detected." );
//            viewName = "mobile/" + viewName;
//        }
//
//
//        log.info( "getViewName ends." );
//
//        return viewName;
//    }


    /***
     *
     * @param viewName
     * @param theme
     * @return
     */
    public static String getViewName( String viewName, String theme )
    {
        log.info( "getViewName start." );

        if (isMobileTheme( theme ))
        {
            log.debug( "Mobile theme detected." );
            viewName = "mobile/" + viewName;

        }

        log.info( "getViewName ends." );

        return viewName;

    }



    /**
     * Determines if a mobile theme is being used based upon theme name
     * @param theme Name of theme being used in this session.
     * @return boolean to indicate if a mobile theme should be used.
     */
    public static boolean isMobileTheme( String theme )
    {

        // if the theme is null, then this is not a mobile page.

        return  (
                ( IPHONE.equalsIgnoreCase( theme )  )  ||
                ( BLACKBERRY.equalsIgnoreCase( theme ) ||
                ( ANDROID.equalsIgnoreCase( theme )) )
            );

    }


}
