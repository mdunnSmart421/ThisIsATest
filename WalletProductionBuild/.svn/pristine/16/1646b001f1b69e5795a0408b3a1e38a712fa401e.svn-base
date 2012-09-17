package com.o2.finance.service;

import com.o2.finance.model.UserTO;
import com.o2.www.broadband.avatartypes.UserSummaryType;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import weblogic.xml.security.wsse.UsernameToken;

/**
 * Purpose:
 * com.o2.finance.service
 * User: D Smith
 * Date: 13/07/2011
 */
public class UserSummaryTypeConverter
{


    private static Logger log = LogManager.getLogger( UserSummaryTypeConverter.class );



    private UserSummaryTypeConverter()
    {
        // Only contains static methods
    }

    public static UserTO convert( UserSummaryType user )
    {
        log.info( "convert start." );

        UserTO userTO = new UserTO();


        userTO.setId( user.getId() );
        userTO.setCustomerNumber(  new Integer ( user.getCustnum().intValue() ));
        userTO.setDateOfBirth( user.getDateOfBirth() );
        userTO.setDomain( user.getDomain().getValue() );
        userTO.setForename( user.getForename() );
        userTO.setLastname( user.getLastname() );
        userTO.setMsisdn( user.getMsisdn().getMobilePhoneType() );

        userTO.setSecurityAnswer( user.getSecurityAnswer() );
        userTO.setSecurityQuestion( user.getSecurityQuestion() );


        log.info( "convert ends." );
        return userTO;

    }







}
