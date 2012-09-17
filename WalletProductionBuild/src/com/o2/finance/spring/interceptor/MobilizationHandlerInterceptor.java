package com.o2.finance.spring.interceptor;

import com.o2.finance.etc.RequestParameterConstants;
import com.o2.finance.model.FinanceLocalModel;
import com.o2.finance.util.CookieUtils;
import com.o2.finance.util.MobileThemeSupportHelper;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Purpose: Determine if mobile version of pages should be displayed if response is a redirect.
 * com.o2.finance.spring
 * User: D Smith
 * Date: 25/08/2011
 */
public class MobilizationHandlerInterceptor implements HandlerInterceptor, RequestParameterConstants
{

    Logger log = LogManager.getLogger( this.getClass() );


    private FinanceLocalModel localModel;


    public boolean preHandle( HttpServletRequest request, HttpServletResponse response, Object o ) throws Exception
    {
        return true;
    }

    public void postHandle( HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView ) throws Exception
    {


//        if ( ( null != localModel ) && ( null != localModel.getTheme() ) )
//        {
//            setDeviceCookie( request, response, localModel.getTheme() );
//        }


        // Only need to deal with redirects...
        if (null != modelAndView.getViewName() && !modelAndView.getViewName().toLowerCase().startsWith( "redirect:" ))
        {



            modelAndView.setViewName( MobileThemeSupportHelper.getViewName( modelAndView, localModel, request ) );
        }
    }

    public void afterCompletion( HttpServletRequest request, HttpServletResponse response, Object o, Exception e ) throws Exception
    {
        //
    }


    public FinanceLocalModel getLocalModel()
    {
        return localModel;
    }

    public void setLocalModel( FinanceLocalModel localModel )
    {
        this.localModel = localModel;
    }


//    /**
//     * Ensures that cookie is set
//     * @param request
//     * @param response
//     * @param theme
//     */
//    private void setDeviceCookie( HttpServletRequest request, HttpServletResponse response, String theme )
//    {
//            CookieUtils.setCookie(request, response, "theme", theme );
//    }


}
