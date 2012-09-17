/**
 * Developed by Smart421 (www.smart421.com).
 * (c) Copyright 2011 Telefonica O2 UK Limited.
 */
package com.o2.finance.splash;

import java.io.File;
import java.io.FileFilter;

import com.o2.finance.properties.PropertyManager;

public class SplashFileFilter implements FileFilter
{
    private Object[] products;
    private Object[] devices;

    /* (non-Javadoc)
     * @see java.io.FileFilter#accept(java.io.File)
     */
    public boolean accept(File file)
    {
	products = PropertyManager.getProductProps().getProductIdList().toArray();
	devices = PropertyManager.getDeviceProperties().getDeviceList().toArray();
	boolean response = false;
	for (int i = 0; i < products.length; i++)
	{
	    if (file.getName().toLowerCase().endsWith((String) products[i]) || 
		    file.getName().toLowerCase().endsWith(PropertyManager.getApplicationProperties().getSplashAllKeyword()))
	    {
		for (int j = 0; j < devices.length; j++)
		{
		    if (file.getName().toLowerCase().startsWith((String) devices[j]))
		    {
			response = true;
		    }
		}
	    }
	}
	return response;
    }
}
