/**
 * Developed by Smart421 (www.smart421.com).
 * (c) Copyright 2011 Telefonica O2 UK Limited.
 */
package com.o2.finance.properties;

import java.io.File;
import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.o2.finance.splash.SplashFileFilter;

public class SplashFiles
{
    private PropertyManager propertyManager;
    
    private static final String FOLDER_LOCATION = "/finance/splash/";
    
    private static String [] splashFiles = new String[0];

    private Logger log = LogManager.getLogger(this.getClass());
    
    private static boolean allDevicesAllProducts;
    
    private static boolean allDevicesSpecificProduct;
    
    private static boolean allMobileAllProducts;
    
    private static boolean allMobileSpecificProduct;
    
    private static boolean specificDeviceAllProducts;
    
    private static boolean specificDeviceSpecificProducts;
    
    /**
     * Default constructor
     */
    public SplashFiles()
    {
//	propertyManager = PropertyManager.getInstance();
    }
    
    /**
     * Reads file names from the splash file folder that match a filter pattern. All matching files present are loaded into the
     * static string array.
     */
    public synchronized void loadSplashFiles()
    {
	log.debug("Loading splash files");
	Resource splashResource = new ClassPathResource(getPropertyFile());
	File folder;
	try
	{
	    setAllDevicesAllProducts(false);
	    setAllDevicesSpecificProduct(false);
	    setAllMobileAllProducts(false);
	    setAllMobileSpecificProduct(false);
	    setSpecificDeviceAllProducts(false);
	    setSpecificDeviceSpecificProducts(false);
	    folder = splashResource.getFile();
	    File [] files = folder.listFiles(new SplashFileFilter());
	    splashFiles = new String [files.length];
	    for (int i = 0; i < files.length; i++)
	    {
		log.info("Found splash file " + i + " - " + files[i].getName());
		updateSplashAllBooleans(files[i]);
		splashFiles[i] = files[i].getName();
	    }
	} catch (IOException e)
	{
	    log.error("IOException caught while loading splash files");
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }
    
    /**
     * Takes a File, reads the file name, and compares the start and end with the splash all keywords. If the name ends with the 
     * 'all' keyword, the allProducts boolean will be set to true. If the name starts with the 'all' keyword, the allDevices 
     * boolean will be set to true. If the name starts with the 'allMobiles' keyword, the allMobileDevices boolean will be set
     * to true.
     * @param file
     */
    protected void updateSplashAllBooleans(File file)
    {
	String [] fileName = StringUtils.split(file.getName(), ".");
	boolean productsAll = StringUtils.equalsIgnoreCase(fileName[1],propertyManager.getApplicationProperties().getSplashAllKeyword());
	boolean devicesAll = StringUtils.equalsIgnoreCase(fileName[0], propertyManager.getApplicationProperties().getSplashAllKeyword());
	boolean mobileDevicesAll = StringUtils.equalsIgnoreCase(fileName[0], propertyManager.getApplicationProperties().getSplashAllMobileKeyword());
	if (devicesAll && productsAll)
	{
	    setAllDevicesAllProducts(true);
	}
	else if (devicesAll && !productsAll)
	{
	    setAllDevicesSpecificProduct(true);
	}
	else if (mobileDevicesAll && productsAll)
	{
	    setAllMobileAllProducts(true);
	}
	else if (mobileDevicesAll && !productsAll)
	{
	    setAllMobileSpecificProduct(true);
	}
	else if (!devicesAll && productsAll)
	{
	    setSpecificDeviceAllProducts(true);
	}
	else if (!devicesAll && !productsAll)
	{
	    setSpecificDeviceSpecificProducts(true);
	}
    }

    /**
     * Returns the property file location
     * @return String property file location
     */
    protected String getPropertyFile()
    {
        return FOLDER_LOCATION;
    }

    /**
     * Returns the string array of splash files
     * @return String array of splash files
     */
    public String [] getSplashFilesArray()
    {
        return splashFiles;
    }

    /**
     * @return the allDevicesAllProducts
     */
    public static synchronized boolean isAllDevicesAllProducts()
    {
        return allDevicesAllProducts;
    }

    /**
     * @param allDevicesAllProducts the allDevicesAllProducts to set
     */
    protected static synchronized void setAllDevicesAllProducts(boolean allDevicesAllProducts)
    {
        SplashFiles.allDevicesAllProducts = allDevicesAllProducts;
    }

    /**
     * @return the allDevicesSpecificProduct
     */
    public static synchronized boolean isAllDevicesSpecificProduct()
    {
        return allDevicesSpecificProduct;
    }

    /**
     * @param allDevicesSpecificProduct the allDevicesSpecificProduct to set
     */
    protected static synchronized void setAllDevicesSpecificProduct(boolean allDevicesSpecificProduct)
    {
        SplashFiles.allDevicesSpecificProduct = allDevicesSpecificProduct;
    }

    /**
     * @return the allMobileAllProducts
     */
    public static synchronized boolean isAllMobileAllProducts()
    {
        return allMobileAllProducts;
    }

    /**
     * @param allMobileAllProducts the allMobileAllProducts to set
     */
    protected static synchronized void setAllMobileAllProducts(boolean allMobileAllProducts)
    {
        SplashFiles.allMobileAllProducts = allMobileAllProducts;
    }

    /**
     * @return the allMobileSpecificProduct
     */
    public static synchronized boolean isAllMobileSpecificProduct()
    {
        return allMobileSpecificProduct;
    }

    /**
     * @param allMobileSpecificProduct the allMobileSpecificProduct to set
     */
    protected static synchronized void setAllMobileSpecificProduct(boolean allMobileSpecificProduct)
    {
        SplashFiles.allMobileSpecificProduct = allMobileSpecificProduct;
    }

    /**
     * @return the specificDeviceAllProducts
     */
    public static synchronized boolean isSpecificDeviceAllProducts()
    {
        return specificDeviceAllProducts;
    }

    /**
     * @param specificDeviceAllProducts the specificDeviceAllProducts to set
     */
    protected static synchronized void setSpecificDeviceAllProducts(boolean specificDeviceAllProducts)
    {
        SplashFiles.specificDeviceAllProducts = specificDeviceAllProducts;
    }

    /**
     * @return the specificDeviceSpecificProducts
     */
    public static synchronized boolean isSpecificDeviceSpecificProducts()
    {
        return specificDeviceSpecificProducts;
    }

    /**
     * @param specificDeviceSpecificProducts the specificDeviceSpecificProducts to set
     */
    protected static synchronized void setSpecificDeviceSpecificProducts(boolean specificDeviceSpecificProducts)
    {
        SplashFiles.specificDeviceSpecificProducts = specificDeviceSpecificProducts;
    }

    /**
     * @param propertyManager the propertyManager to set
     */
    public void setPropertyManager(PropertyManager propertyManager)
    {
        this.propertyManager = propertyManager;
    }
}
