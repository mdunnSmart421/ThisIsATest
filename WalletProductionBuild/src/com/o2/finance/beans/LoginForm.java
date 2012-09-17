package com.o2.finance.beans;

import com.o2.finance.model.FinanceLocalModel;

/**
 * Purpose:
 * com.o2.finance.beans
 * User: D Smith
 * Date: 29/10/2011
 */
public class LoginForm
{

    private String username;
    private String password;
    private String loginURL;
    private String returnURL;
    private String failureURL;

    public boolean getSkipRedirects()
    {
        return true;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword( String password )
    {
        this.password = password;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername( String username )
    {
        this.username = username;
    }


    public String getFailureURL()
    {
        return failureURL;
    }

    public void setFailureURL( String failureURL )
    {
        this.failureURL = failureURL;
    }

    public String getLoginURL()
    {
        return loginURL;
    }

    public void setLoginURL( String loginURL )
    {
        this.loginURL = loginURL;
    }

    public String getReturnURL()
    {
        return returnURL;
    }

    public void setReturnURL( String returnURL )
    {
        this.returnURL = returnURL;
    }
}
