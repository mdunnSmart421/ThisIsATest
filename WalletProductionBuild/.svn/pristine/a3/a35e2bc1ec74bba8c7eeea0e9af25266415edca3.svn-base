/**
 * Developed by Smart421 (www.smart421.com).
 * (c) Copyright 2011 Telefonica O2 UK Limited.
 */
package com.o2.finance.filters;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.o2.finance.etc.ApplicationConstants;
import com.o2.finance.etc.DeviceConstants;
import com.o2.finance.etc.RequestParameterConstants;
import com.o2.finance.properties.PropertyManager;
import com.o2.finance.splash.SplashHelper;
import com.o2.finance.util.CookieUtils;

/**
 * Created by IntelliJ IDEA. User: dave Date: 21/11/2011 Time: 14:36 To change this template use File | Settings | File Templates.
 */
public class SplashFilter implements Filter, DeviceConstants, RequestParameterConstants, ApplicationConstants
{
    private SplashHelper splashHelper;

    private Logger log = LogManager.getLogger(this.getClass());

    /**
     * Default constructor
     */
    public SplashFilter()
    {

    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    public void init(FilterConfig filterConfig) throws ServletException
    {

    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException,
	    ServletException
    {
	log.debug("Entered splash filter");
	if (!StringUtils.equals(PropertyManager.getApplicationProperties().getSplashUri(),
		((HttpServletRequest) request).getRequestURI()))
	{
	    String device = getDevice(request, response);
	    log.info("Device type has been set to " + device);
	    String productId = getProduct(request, response);
	    log.info("Product type has been set to " + productId);
	    
	    log.info("Check if device " + device + " for product " + productId + " should  be splashed");
	    final boolean doSplash = splashHelper.isSplashed(device, productId);
	    log.info("Splash me = " + doSplash);

	    if (doSplash)
	    {
		((HttpServletResponse) response).sendRedirect(PropertyManager.getApplicationProperties().getSplashPageUrl());
	    }
	}
	filterChain.doFilter(request, response);
    }
    
    /**
     * Returns the device based upon the presence of the request parameter or the theme cookie. If none are present then the
     * default value of web is used
     * @param request
     * @param response
     * @return
     */
    private String getDevice(ServletRequest request, ServletResponse response)
    {
	String requestDevice = request.getParameter(DEVICE);
	String device = DeviceConstants.WEB;
	log.debug("Check to see if device parameter is present on the request");
	if (isDeviceParameterPresent(requestDevice))
	{
	    log.debug("Device parameter has been found on request");
	    device = requestDevice;
	    CookieUtils.setCookie((HttpServletRequest) request, (HttpServletResponse) response, THEME_COOKIE_NAME,
		    requestDevice, true);
	} else
	{
	    log.debug("Device parameter has not been found on request");
	    log.debug("Check to see if theme cookie is present");
	    requestDevice = CookieUtils.getCookieValue(THEME_COOKIE_NAME, (HttpServletRequest) request);
	    if (isDeviceParameterPresent(requestDevice))
	    {
		log.debug("Device theme cookie found");
		device = requestDevice;
	    } else
	    {
		log.debug("Device theme cookie has not been found");
		log.debug("Source must be web");
	    }
	}
	return device;
    }
    
    /**
     * Returns the product based upon the presence of the request parameter or the product cookie. If none are present then an
     * error is thrown
     * @param request
     * @param response
     * @return
     */
    private String getProduct(ServletRequest request, ServletResponse response)
    {
	String requestProductId = request.getParameter(PRODUCT_ID);
	String productId = "";
	log.debug("Check to see if product parameter is present");
	if (isProductParameterPresent(requestProductId))
	{
	    log.debug("ProductID found on request");
	    productId = requestProductId;
	    CookieUtils.setCookie((HttpServletRequest) request, (HttpServletResponse) response, PRODUCT_COOKIE_NAME,
		    requestProductId, true);
	} else
	{
	    log.debug("ProductID parameter has not been found on request");
	    log.debug("Check to see if product cookie is present");
	    requestProductId = CookieUtils.getCookieValue(PRODUCT_COOKIE_NAME, (HttpServletRequest) request);
	    if (isProductParameterPresent(requestProductId))
	    {
		log.debug("ProductId cookie found");
		productId = requestProductId;
	    } else
	    {
		log.debug("ProductId cookie has not been found");
		// TODO ERROR
	    }
	}
	return productId;
    }

    /**
     * Takes a string value containing the device type and compares that to a property list of devices. Returns true if the
     * property is present, false if it is not.
     * 
     * @param device
     *            String value for type of device
     * @return boolean True if device value is present in properties, false otherwise
     */
    private boolean isDeviceParameterPresent(String device)
    {
	final List devices = PropertyManager.getDeviceProperties().getDeviceList();
	return devices.contains(device);
    }

    /**
     * Takes a string value containing the product id and compares that to a property list of products. Returns true if the
     * property is present, false if it is not.
     * 
     * @param product
     *            String value for type of product
     * @return boolean True if property value is present in properties, false otherwise
     */
    private boolean isProductParameterPresent(String product)
    {
	final List products = PropertyManager.getProductProps().getProductIdList();
	return products.contains(product);
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.Filter#destroy()
     */
    public void destroy()
    {

    }

    /**
     * @param splashHelper
     *            the splashHelper to set
     */
    public void setSplashHelper(SplashHelper splashHelper)
    {
	this.splashHelper = splashHelper;
    }
}
