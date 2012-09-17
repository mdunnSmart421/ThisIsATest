/**
 * Developed by Smart421 (www.smart421.com).
 * (c) Copyright 2011 Telefonica O2 UK Limited.
 */
package com.o2.finance.properties;

/**
 * Purpose: com.o2.finance.properties User: D Smith Date: 17/03/2011
 */
public class PropertyManager
{
    private static PropertyManager instance;
    private ApplicationProperties application;
    private PageIncludesProperties pageIncludes;
    private StyleSheetProps stylesheets;
    private ValidationRegexProperties validatorregex;
    private FeedbackProperties feedback;
    private ProductProperties products;
    private CopyProperties copy;
    private DeviceProperties devices;
    private SplashFiles splashFiles;

    /**
     * Default constructor
     */
    private PropertyManager()
    {
	
    }

    /**
     * Returns static instance
     * @return PropertyManager
     */
    public static PropertyManager getInstance()
    {
        if (instance == null)
        {
            init();
        }
        return instance;
    }

    /**
     * Initializes instance
     */
    protected static synchronized void init()
    {
        if (instance == null)
        {
            final PropertyManager manager = new PropertyManager();
            manager.application = new ApplicationProperties();
            manager.pageIncludes = new PageIncludesProperties();
            manager.stylesheets = new StyleSheetProps();
            manager.validatorregex = new ValidationRegexProperties();
            manager.feedback = new FeedbackProperties();
            manager.products = new ProductProperties();
            manager.copy = new CopyProperties();
            manager.devices = new DeviceProperties();
            manager.splashFiles = new SplashFiles();
            instance = manager;
        }
    }

    public static ApplicationProperties getApplicationProperties()
    {
        return getInstance().application;
    }

    public static ValidationRegexProperties getValidatorRegexProperties()
    {
        return getInstance().validatorregex;
    }

    public static PageIncludesProperties getPageIncludesProperties()
    {
        return getInstance().pageIncludes;
    }

    public static StyleSheetProps getStyleSheetProps()
    {
        return getInstance().stylesheets;
    }

    public static FeedbackProperties getFeedbackProps()
    {
        return getInstance().feedback;
    }

    public static ProductProperties getProductProps()
    {
        return getInstance().products;
    }

    public static CopyProperties getCopyProps()
    {
        return getInstance().copy;
    }

    public static DeviceProperties getDeviceProperties()
    {
	return getInstance().devices;
    }
    
    /**
     * Returns the SplashFiles instance which provides functionality to load the splash files from disk
     * @return SplashFiles
     */
    public static SplashFiles getSplashFiles()
    {
	return getInstance().splashFiles;
    }
}
