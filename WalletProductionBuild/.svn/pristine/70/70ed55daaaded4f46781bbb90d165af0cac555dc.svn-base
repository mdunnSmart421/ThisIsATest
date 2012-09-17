/**
 * Developed by Smart421 (www.smart421.com).
 * (c) Copyright 2011 Telefonica O2 UK Limited.
 */
package com.o2.finance.properties;

import java.util.List;

public class DeviceProperties extends FinanceProperties
{
    private static final String FILE_LOCATION = "/finance/device.properties";
    
    private static final String DEVICES = "deviceids";
    
    private static final String MOBILE_DEVICES = "mobileids";

    /**
     * Default constructor
     */
    public DeviceProperties()
    {
	
    }

    /* (non-Javadoc)
     * @see com.o2.finance.properties.FinanceProperties#getPropertyFile()
     */
    protected String getPropertyFile()
    {
        return FILE_LOCATION;
    }

    /**
     * Returns the list of devices as a String from the properties file
     * @return String list of devices
     */
    public String getDeviceValues()
    {
        return getProperty(DEVICES);
    }

    /**
     * Returns the list of devices as a List from the properties file
     * @return List of devices
     */
    public List getDeviceList()
    {
        return getListProperty(DEVICES);
    }
    
    /**
     * Returns the list of mobile devices as a String from the properties file
     * @return String list of devices
     */
    public String getMobileDeviceValues()
    {
	return getProperty(MOBILE_DEVICES);
    }
    
    /**
     * Returns the list of mobile devices as a List from the properties file
     * @return List of devices
     */
    public List getMobileDeviceList()
    {
	return getListProperty(MOBILE_DEVICES);
    }
    
//    public String getNonMobileDeviceValues()
//    {
//	List all = getDeviceList();
//	List mobile = getMobileDeviceList();
//	StringBuffer nonMobile = new StringBuffer();
//	Iterator it = all.iterator();
//	int count = 0;
//	while (it.hasNext())
//	{
//	    if (count > 0)
//	    {
//		nonMobile.append(",");
//	    }
//	    String device = (String) it.next();
//	    if (!mobile.contains(device))
//	    {
//		nonMobile.append(device);
//	    }
//	}
//	return nonMobile.toString();
//    }
    
//    public List getNonMobileDeviceList()
//    {
//	List all = getDeviceList();
//	List mobile = getMobileDeviceList();
//	List nonMobile = new ArrayList();
//	Iterator it = all.iterator();
//	while (it.hasNext())
//	{
//	    String device = (String) it.next();
//	    if (!mobile.contains(device))
//	    {
//		nonMobile.add(device);
//	    }
//	}
//	return nonMobile;
//    }
    
//    public List getDevicesExcludingThis(String deviceToExclude)
//    {
//	List all = getDeviceList();
//	while (all.contains(deviceToExclude))
//	{
//	    all.remove(deviceToExclude);
//	}
//	return all;
//    }
}
