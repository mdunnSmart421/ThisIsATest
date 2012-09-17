/**
 * 
 */
package com.o2.finance.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SCroft / D Smith
 * 
 */
public class ChooseAccountForm {

    private String msisdn;
    private String account;
    private List accounts;
    private int accountsListSize;

    public ChooseAccountForm()
    {
    }

    /**
     * @param msisdn
     * @param account
     * @param accounts
     */
    public ChooseAccountForm(String msisdn, String account, List accounts)
    {
        this.msisdn = msisdn;
        this.account = account;
        this.accounts = accounts;
        this.accountsListSize = this.accounts.size();
    }

    public String getAccount()
    {
        return account;
    }

    public void setAccount(String account)
    {
        this.account = account;
    }

    /**
     * @return the accounts
     */
    public List getAccounts()
    {
        return accounts != null ? accounts : new ArrayList();
    }

    /**
     * @param accounts
     *            the accounts to set
     */
    public void setAccounts(List accounts)
    {
        this.accounts = accounts;
        this.accountsListSize = this.accounts.size();
    }

    /**	     
     */
    public int getAccountsListSize()
    {
        return accountsListSize;
    }	    
    
    /**
     * @param size
     *            the accountsListSize to set
     */
    public void setAccountsListSize(int size)
    {
        this.accountsListSize = size;
    }	    
    
    
    /**
     * @return the msisdn
     */
    public String getMsisdn()
    {
        return msisdn != null ? msisdn.trim() : "";
    }

    /**
     * @param msisdn
     *            the msisdn to set
     */
    public void setMsisdn(String msisdn)
    {
        this.msisdn = msisdn;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((account == null) ? 0 : account.hashCode());
        result = prime * result + ((msisdn == null) ? 0 : msisdn.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ChooseAccountForm other = (ChooseAccountForm) obj;
        if (account == null)
        {
            if (other.account != null)
                return false;
        } else if (!account.equals(other.account))
            return false;
        if (msisdn == null)
        {
            if (other.msisdn != null)
                return false;
        } else if (!msisdn.equals(other.msisdn))
            return false;
        return true;
    }
}
