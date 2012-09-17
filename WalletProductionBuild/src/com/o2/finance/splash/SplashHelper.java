/**
 * Developed by Smart421 (www.smart421.com).
 * (c) Copyright 2011 Telefonica O2 UK Limited.
 */
package com.o2.finance.splash;

public interface SplashHelper
{
    /**
     * Reads the in memory properties to determine if device:product pair should be splashed or not.
     * @param device Device using the service
     * @param product Product being registered for
     * @return boolean stating if device/product should be splashed or not
     */
    public boolean isSplashed(String device, String product);
    
    /**
     * Read the current state of splash files
     */
    public void readState();
}
