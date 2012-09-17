package com.o2.finance.beans;

import com.o2.finance.properties.CopyProperties;
import com.o2.finance.properties.PropertyManager;

import java.util.ArrayList;
import java.util.List;

public class PafLookupForm
{
    public AddressBean address;
    public String current;
    public List pafList;

    public String AddressFoundHeaderCopy;
    public String AddressFoundBodyCopy;
    public String AddressNotFoundHeaderCopy;
    public String AddressNotFoundBodyCopy;
    public String addressFoundBodyMobileCopy;

    private CopyProperties properties = PropertyManager.getCopyProps();

    {
        AddressFoundHeaderCopy = properties.getAddressFoundHeader();
        AddressFoundBodyCopy = properties.getAddressFoundBody();
        AddressNotFoundHeaderCopy = properties.getAddressNotFoundHeader();
        AddressNotFoundBodyCopy = properties.getAddressNotFoundBody();
        addressFoundBodyMobileCopy = properties.getAddressFoundMobileBody();
    }



    public PafLookupForm()
    {
    }

    public PafLookupForm(AddressBean address, List pafList)
    {
        this.pafList = pafList;
        this.address = address;
        this.current = address != null ? address.getAddress() : "";
    }

    /**
     * @return the pafList
     */
    public List getPafList()
    {
        return pafList != null ? pafList : new ArrayList();
    }

    /**
     * @param pafList
     *            the pafList to set
     */
    public void setPafList(List pafList)
    {
        this.pafList = pafList;
    }

    /**
     * @return the address
     */
    public AddressBean getAddress()
    {
        return address != null ? address : new AddressBean();
    }

    /**
     * @param address
     *            the address to set
     */
    public void setAddress(AddressBean address)
    {
        this.address = address;
        this.current = address != null ? address.getAddress() : "";
    }

    /**
     * @return the current
     */
    public String getCurrent()
    {
        return current;
    }

    public int getSize()
    {
        return getPafList().size();
    }


    public String getAddressFoundBodyCopy()
    {
        return AddressFoundBodyCopy;
    }

    public String getAddressFoundHeaderCopy()
    {
        return AddressFoundHeaderCopy;
    }

    public String getAddressNotFoundBodyCopy()
    {
        return AddressNotFoundBodyCopy;
    }

    public String getAddressNotFoundHeaderCopy()
    {
        return AddressNotFoundHeaderCopy;
    }
    
    public String getAddressFoundBodyMobileCopy() {
		return addressFoundBodyMobileCopy;
	}

    
	
}
