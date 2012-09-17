package com.o2.finance.model;

import com.o2.finance.beans.ProductBean;

/**
 * Set of local objects to be used by individual servlet actions within current session
 * <p/>
 * Developed by Smart421 (www.smart421.com). (c) Copyright 2011 Telef�nica O2 UK Limited..
 */
public class FinanceLocalModel
{
    private long        userUID;
    private UserTO      user;
    private String      OTAC;
    private String      msisdn;
    private String      processName;
    private String      productOfferCode;
    private String      advertisingCode;
    private String      toLoginAs;
    private Long        applicationRef;
    private ProductBean product;
    private boolean     isMsisdnVerified;
    private boolean     isPafUpdated;
    private boolean     isPostPay;
    private boolean     isLoggedIn;
    private boolean     isNewAccount;
    private String      returnUrl;

    private String theme;

    private String originalMsisdn;
    
    private boolean bypassLegacyCheck;
    
    private boolean sessionTimedOut = false;

    public boolean isSessionTimedOut() {
		return sessionTimedOut;
	}



	public void setSessionTimedOut(boolean sessionTimedOut) {
		this.sessionTimedOut = sessionTimedOut;
	}



	public String getOriginalMsisdn() {
		return originalMsisdn;
	}



	public void setOriginalMsisdn(String originalMsisdn) {
		this.originalMsisdn = originalMsisdn;
	}

	private boolean journeyInitialised = false;
	/**
	 * 
	 */
	private boolean legacyChecksPassed = false;


    public boolean isLegacyChecksPassed() {
		return legacyChecksPassed;
	}



	public void setLegacyChecksPassed(boolean legacyChecksPassed) {
		this.legacyChecksPassed = legacyChecksPassed;
	}



	public void clear()
    {
        userUID = 0;
        user = null;
        OTAC = "";
        msisdn = "";
        
        originalMsisdn = "";
        
        processName = "";
        productOfferCode = "";
        advertisingCode = "";
        toLoginAs = "";
        applicationRef = new Long(0);
        product = null;
        isMsisdnVerified = false;
        isPafUpdated = false;
        isPostPay = false;
        isLoggedIn = false;
        isNewAccount = false;
        returnUrl = null;
        theme = null;
        
        legacyChecksPassed = false;
        bypassLegacyCheck = false;
        sessionTimedOut = false;
    }



    public boolean isBypassLegacyCheck() {
		return bypassLegacyCheck;
	}



	public void setBypassLegacyCheck(boolean bypassLegacyCheck) {
		this.bypassLegacyCheck = bypassLegacyCheck;
	}



	public UserTO getUser()
    {
        return user;
    }

    public void setUser(UserTO user)
    {
        this.user = user;
    }

    public ProductBean getProduct()
    {
        return product;
    }

    public void setProduct(ProductBean product)
    {
        this.product = product;
    }

    public boolean isMsisdnVerified()
    {
        return isMsisdnVerified;
    }

    public void setMsisdnVerified(boolean msisdnVerified)
    {
        isMsisdnVerified = msisdnVerified;
    }

    public String getMsisdn()
    {
        return msisdn;
    }

    public void setMsisdn(String msisdn)
    {
        this.msisdn = msisdn;
    }

    public String getOTAC()
    {
        return OTAC;
    }

    public void setOTAC(String OTAC)
    {
        this.OTAC = OTAC;
    }

    /**
     * @return the isPafUpdated
     */
    public boolean isPafUpdated()
    {
        return isPafUpdated;
    }

    /**
     * @param isPafUpdated
     *            the isPafUpdated to set
     */
    public void setPafUpdated(boolean isPafUpdated)
    {
        this.isPafUpdated = isPafUpdated;
    }

    /**
     * @return the isPostPay
     */
    public boolean isPostPay()
    {
        return isPostPay;
    }

    /**
     * @param isPostPay
     *            the isPostPay to set
     */
    public void setPostPay(boolean isPostPay)
    {
        this.isPostPay = isPostPay;
    }

    /**
     * @return the processName
     */
    public String getProcessName()
    {
        return processName;
    }

    /**
     * @param processName
     *            the processName to set
     */
    public void setProcessName(String processName)
    {
        this.processName = processName;
    }

    /**
     * @return the productOfferCode
     */
    public String getProductOfferCode()
    {
        return productOfferCode;
    }

    /**
     * @param productOfferCode
     *            the productOfferCode to set
     */
    public void setProductOfferCode(String productOfferCode)
    {
        this.productOfferCode = productOfferCode;
    }

    /**
     * @return the applicationRef
     */
    public Long getApplicationRef()
    {
        return applicationRef;
    }

    /**
     * @param applicationRef
     *            the applicationRef to set
     */
    public void setApplicationRef(Long applicationRef)
    {
        this.applicationRef = applicationRef;
    }

    /**
     * @return the advertisingCode
     */
    public String getAdvertisingCode()
    {
        return advertisingCode;
    }

    /**
     * @param advertisingCode
     *            the advertisingCode to set
     */
    public void setAdvertisingCode(String advertisingCode)
    {
        this.advertisingCode = advertisingCode;
    }

    /**
     * @return the userUID
     */
    public long getUserUID()
    {
        return userUID;
    }

    /**
     * @param userUID
     *            the userUID to set
     */
    public void setUserUID(long userUID)
    {
        this.userUID = userUID;
    }

    /**
     * @return the isLoggedIn
     */
    public boolean isLoggedIn()
    {
        return isLoggedIn;
    }

    /**
     * @param isLoggedIn the isLoggedIn to set
     */
    public void setLoggedIn(boolean isLoggedIn)
    {
        this.isLoggedIn = isLoggedIn;
    }

    /**
     * @return the toLoginAs
     */
    public String getToLoginAs()
    {
        return toLoginAs;
    }

    /**
     * @param toLoginAs the toLoginAs to set
     */
    public void setToLoginAs(String toLoginAs)
    {
        this.toLoginAs = toLoginAs;
    }

    /**
     * @return the isNewAccount
     */
    public boolean isNewAccount()
    {
        return isNewAccount;
    }

    /**
     * @param isNewAccount the isNewAccount to set
     */
    public void setNewAccount(boolean isNewAccount)
    {
        this.isNewAccount = isNewAccount;
    }


    public boolean isJourneyInitialised()
    {
        return journeyInitialised;
    }

    public void setJourneyInitialised( boolean journeyInitialised )
    {
        this.journeyInitialised = journeyInitialised;
    }


    public String getReturnUrl()
    {
        return returnUrl;
    }

    public void setReturnUrl( String returnUrl )
    {
        this.returnUrl = returnUrl;
    }


    public String getTheme()
    {
        return theme;
    }

    public void setTheme( String theme )
    {
        this.theme = theme;
    }



	public boolean databaseMobileUpdated() {
		
		return legacyChecksPassed ;
	}
}


