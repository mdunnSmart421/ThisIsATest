/**
 * Developed by Smart421 (www.smart421.com).
 * (c) Copyright 2011 Telefonica O2 UK Limited.
 */
package com.o2.finance.splash;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.o2.finance.properties.PropertyManager;
import com.o2.finance.properties.SplashFiles;

import edu.emory.mathcs.backport.java.util.Collections;

/**
 * Created by IntelliJ IDEA. User: dave, Chris Coe Date: 21/11/2011 Time: 14:12 To change this template use File | Settings | File
 * Templates.
 */
public class SplashHelperImpl implements SplashHelper
{
    private static Map IS_SPLASHED;

    private Logger log = LogManager.getLogger(this.getClass());

    static
    {
	unsplashEverything();
    }

    /**
     * Returns a HashMap for all devices and products loaded from properties with a default splash value of false
     * 
     * @return Map of default splash values for all products and devices
     */
    private static Map unsplashEverything()
    {
	Map splashFilesMap = Collections.synchronizedMap(new HashMap());
	List devices = PropertyManager.getDeviceProperties().getDeviceList();
	for (int i = 0; i < devices.size(); i++)
	{
	    splashFilesMap.put(devices.get(i), generateProductsHashMap(false));
	}
	IS_SPLASHED = splashFilesMap;
	System.out.println("Devices and products from properties = " + IS_SPLASHED.toString());
	return IS_SPLASHED;
    }

    /**
     * Creates a HashMap for all products with the supplied boolean as the splash flag
     * 
     * @param splashed
     *            Boolean value
     * @return HashMap
     */
    private static HashMap generateProductsHashMap(boolean splashed)
    {
	HashMap response = new HashMap();
	List products = PropertyManager.getProductProps().getProductIdList();
	products.add(PropertyManager.getApplicationProperties().getSplashAllKeyword());
	Iterator it = products.iterator();
	while (it.hasNext())
	{
	    String productId = (String) it.next();
	    response.put(productId, new Boolean(splashed));
	}
	return response;
    }
   
    /**
     * Constructor reads state from file
     */
    public SplashHelperImpl()
    {

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.o2.finance.splash.SplashHelper#readState()
     */
    public synchronized void readState()
    {
	log.debug("Reset splashfile settings to default false values");
	unsplashEverything();
	log.debug("Read new splashfile settings from disk");
	PropertyManager.getSplashFiles().loadSplashFiles();
	String[] splashFiles = PropertyManager.getSplashFiles().getSplashFilesArray();
	for (int i = 0; i < splashFiles.length; i++)
	{
	    String[] splashFile = StringUtils.split(splashFiles[i], ".");
	    if (IS_SPLASHED.containsKey(splashFile[0]))
	    {
		HashMap stopHashMap = (HashMap) IS_SPLASHED.get(splashFile[0]);
		if (stopHashMap.containsKey(splashFile[1]) || 
			StringUtils.equalsIgnoreCase(PropertyManager.getApplicationProperties().getSplashAllKeyword(), splashFile[1]))
		{
		    log.debug("Splashfile found for device " + splashFile[0] + " and product " + splashFile[1]);
		    stopHashMap.remove(splashFile[1]);
		    stopHashMap.put(splashFile[1], new Boolean(true));
		}
	    }
	}
	log.debug("Splash status - " + IS_SPLASHED.toString());
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.o2.finance.splash.SplashHelper#isSplashed(java.lang.String, java.lang.String)
     */
    public boolean isSplashed(String device, String product)
    {
	boolean response = false;
	
	if (SplashFiles.isAllDevicesAllProducts())
	{
	    log.debug("splash all products [" + product + "] for all devices [" + device + "] - return TRUE");
	    return true;
	}
	if (SplashFiles.isAllDevicesSpecificProduct())
	{
	    HashMap allDevicesProducts = (HashMap) IS_SPLASHED.get(PropertyManager.getApplicationProperties().getSplashAllKeyword());
	    if (allDevicesProducts.containsKey(product))
	    {
		response = ((Boolean) allDevicesProducts.get(product)).booleanValue();
		if (response)
		{
		    log.debug("splash a specific product  [" + product + "]for all devices [" + device + "] - return TRUE");
		    return response;
		}
	    }
	}
	if (SplashFiles.isAllMobileAllProducts() &&
		PropertyManager.getDeviceProperties().getMobileDeviceList().contains(device))
	{
	    log.debug("splash all products [" + product + "] for all mobile devices [" + device + "] - return TRUE");
	    return true;
	}
	if (SplashFiles.isAllMobileSpecificProduct() &&
		PropertyManager.getDeviceProperties().getMobileDeviceList().contains(device))
	{
	    HashMap mobileProducts = (HashMap) IS_SPLASHED.get(PropertyManager.getApplicationProperties().getSplashAllMobileKeyword());
	    if (mobileProducts.containsKey(product))
	    {
		response = ((Boolean) mobileProducts.get(product)).booleanValue();
		
		if (response)
		{
		    log.debug("splash a specific product  [" + product + "]for all mobile devices [" + device + "] - return TRUE");
		    return response;
		}
	    }
	}
	if (SplashFiles.isSpecificDeviceSpecificProducts())
	{
	    HashMap specificProducts = (HashMap) IS_SPLASHED.get(device);
	    if (specificProducts.containsKey(product))
	    {
		response = ((Boolean) specificProducts.get(product)).booleanValue();
		if (response)
		{
		    log.debug("splash a specific product  [" + product + "]for all mobile devices [" + device + "] - return TRUE");
		    return true;
		}
	    }
	    log.debug("splash a specific product for a specific device");
	}
	if (SplashFiles.isSpecificDeviceAllProducts())
	{
	    HashMap allProducts = (HashMap) IS_SPLASHED.get(device);
	    if (allProducts.containsKey(PropertyManager.getApplicationProperties().getSplashAllKeyword()))
	    {
		response = ((Boolean) allProducts.get(PropertyManager.getApplicationProperties().getSplashAllKeyword())).booleanValue();
		if (response)
		{
		    log.debug("splash all products [" + product + "] for a specific device [" + device + "] - return TRUE");
		    return response;
		}
	    }
	}
	return response;
    }
}
