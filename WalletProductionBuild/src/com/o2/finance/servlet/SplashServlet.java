/**
 * Developed by Smart421 (www.smart421.com).
 * (c) Copyright 2011 Telefonica O2 UK Limited.
 */
package com.o2.finance.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.o2.finance.properties.PropertyManager;
import com.o2.finance.splash.SplashHelper;
import com.o2.finance.splash.SplashHelperImpl;

/**
 * Created by IntelliJ IDEA.
 * User: dave
 * Date: 18/11/2011
 * Time: 15:34
 * To change this template use File | Settings | File Templates.
 */
public class SplashServlet extends HttpServlet
{
    /**
     * 
     */
    private static final long serialVersionUID = -1610224508529674020L;

    private SplashHelper splashHelper;
    
    private Logger log = LogManager.getLogger(this.getClass());
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
	log.debug("Entered splash servlet");
	splashHelper = new SplashHelperImpl();
	if (StringUtils.isNotBlank(req.getRemoteAddr()) && isIPAddressOnWhitelist(req.getRemoteAddr()))
	{
	    log.info("Authorised IP address (" + req.getRemoteAddr() + ") has requested a splash file reload");
	    splashHelper.readState();
	}
	resp.sendRedirect(PropertyManager.getApplicationProperties().getSplashPageUrl());
    }
    
    /**
     * Returns boolean showing whether the passed address is present in the properties whitelist of allowed IP addresses
     * @param address String IP Address
     * @return boolean true if IP address is authorised, false otherwise
     */
    private boolean isIPAddressOnWhitelist(String address)
    {
	List whitelist = PropertyManager.getApplicationProperties().getSplashWhiteListList();
	return whitelist.contains(StringUtils.lowerCase(address));
    }
    
    /**
     * Setter for SplashHelper
     * @param splashHelper
     */
    public void setSplashHelper(SplashHelper splashHelper)
    {
        this.splashHelper = splashHelper;
    }
}
