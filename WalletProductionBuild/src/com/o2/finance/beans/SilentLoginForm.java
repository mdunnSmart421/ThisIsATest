package com.o2.finance.beans;

public class SilentLoginForm 
{
	private String username;
	private String password;
	private String loginURL;
	private String returnURL;
	private String failureURL;
	
	public SilentLoginForm()
	{
		
	}
	
	public SilentLoginForm ( String username, String password, String loginURL, String returnURL, String failureURL )
	{
		this.username   = username;
		this.password   = password;
		this.loginURL   = loginURL;
		this.returnURL  = returnURL;
		this.failureURL = failureURL;
	}

	public String getUsername() {
		return ( username != null ? username : "" );
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return ( password != null ? password : "" );
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLoginURL() {
		return ( loginURL != null ? loginURL : "" );
	}

	public void setLoginURL(String loginURL) {
		this.loginURL = loginURL;
	}

	public String getReturnURL() {
		return ( returnURL != null ? returnURL : "" );
	}

	public void setReturnURL(String returnURL) {
		this.returnURL = returnURL;
	}

	public String getFailureURL() {
		return failureURL;
	}

	public void setFailureURL(String failureURL) {
		this.failureURL = failureURL;
	}

}
