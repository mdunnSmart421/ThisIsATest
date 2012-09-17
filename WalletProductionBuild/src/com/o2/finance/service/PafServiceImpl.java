package com.o2.finance.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.o2.finance.beans.AddressBean;
import com.o2.finance.exception.AddressNotFoundException;
import com.o2.finance.exception.unchecked.RuntimeServiceException;
import com.o2.finance.properties.PropertyManager;
import com.o2.smart421.ws.paf.PafPortType;
import com.o2.smart421.ws.paf.PafService_Impl;
import com.o2.smart421.ws.paf.model.AddressType;
import com.o2.smart421.ws.paf.model.PafFaultType;
import com.o2.smart421.ws.paf.model.RequestAddressType;
import com.o2.smart421.ws.paf.model.SearchAddress;

/**
 * Purpose: com.o2.finance.service User: D Smith Date: 16/05/2011
 */
public class PafServiceImpl implements PafService
{

    Logger log = LogManager.getLogger( this.getClass() );

    public List findAddress(String houseNumber, String houseName, String postcode) throws AddressNotFoundException
    {

        log.info( "findAddress start." );

        List result = new ArrayList();
        String endPoint = PropertyManager.getApplicationProperties().getPafServiceEndPoint();
        try
        {
            PafPortType port = new PafService_Impl(endPoint).getPafPortType();

            SearchAddress search = new SearchAddress();
            RequestAddressType requestAddressType = new RequestAddressType();
            requestAddressType.setPostcode(postcode);
            requestAddressType.setBuildingNumber(houseNumber);
            requestAddressType.setBuildingName(houseName);
            search.setAddress(requestAddressType);

            log.info( "Making call to address service." );
            AddressType[] addresses = port.searchAddress(search);

            log.info( "Found " + addresses.length + " addresses.");
            // Convert to list of AddressBean
            for (int i = 0; i < addresses.length; i++ )
            {
                result.add( convert( addresses[i] ) );
            }


        } catch (IOException e)
        {
            log.error( e.getMessage(), e );
            throw new RuntimeServiceException(this.getClass(), "findAddress", e, null);

        } catch (PafFaultType pafFaultType)
        {


            String description = pafFaultType.getFaultDescription();
            if ( null != description && "No Matching Addresses".equalsIgnoreCase( description ) )
            {
                log.info( "No matching address found." );
            } else
            {
            log.error(pafFaultType.getMessage(), pafFaultType);
            }

            return result;
        }

        log.info( "findAddress ends." );
        return result;

    }

    private AddressBean convert(  AddressType address )
    {
        log.info( "convert start." );

        AddressBean result = new AddressBean();

        result.setHouseName( this.getFullBuildingName( address ) );
        result.setHouseNumber( address.getBuildingNumber() );

        result.setAddressLine1( address.getStreet() );
        result.setAddressLine2( address.getDependentStreet() );

        result.setTownOrCity( address.getPostTown() );
        result.setCounty(address.getCounty());
        result.setCountry("GB");

        result.setPostcode( address.getPostcode() );

        log.info( "convert ends." );

        return result;

    }

    private static final String BUILDING_NAME_CONCAT_STRING = ",";
	private static final int MAX_BUILDING_NAME_LENGTH = 80;

    private String getFullBuildingName( AddressType address )
	{
        log.info( "getFullBuildingName start." );

		StringBuffer fullBuildingName = new StringBuffer();

		if (address.getOrganisation() != null && ! address.getOrganisation().equals( "" ))
		{
			fullBuildingName.append(address.getOrganisation()).append(BUILDING_NAME_CONCAT_STRING);
		}
		if (address.getSubBuildingName() != null && !address.getSubBuildingName().equals( "" ))
		{
			fullBuildingName.append(address.getSubBuildingName()).append(BUILDING_NAME_CONCAT_STRING);
		}
		if (address.getBuildingName() != null && ! address.getBuildingName().equals( "" ))
		{
			fullBuildingName.append( address.getBuildingName() );
		}

		String fullBuildingNameString = fullBuildingName.toString();

		// If the String ends with the concat String remove it
		if (fullBuildingNameString.endsWith(BUILDING_NAME_CONCAT_STRING))
		{
			fullBuildingNameString = fullBuildingNameString.substring(
					0, fullBuildingNameString.length() - BUILDING_NAME_CONCAT_STRING.length());
		}

		// If the building name String is greater than the allowed length substring it.
		if (fullBuildingNameString.length() > MAX_BUILDING_NAME_LENGTH)
		{
			fullBuildingNameString = fullBuildingNameString.substring(0, MAX_BUILDING_NAME_LENGTH);
		}

        log.info( "getFullBuildingName ends." );

		return fullBuildingNameString;
	}


}
