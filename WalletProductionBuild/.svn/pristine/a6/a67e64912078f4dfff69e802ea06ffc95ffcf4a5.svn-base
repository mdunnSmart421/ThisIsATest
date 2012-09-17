package com.o2.finance.service;


import com.o2.finance.etc.ExceptionConstants;
import com.o2.finance.exception.FinanceServiceSLMBreachException;
import com.o2.finance.exception.unchecked.RuntimeServiceException;
import com.o2.finance.properties.ApplicationProperties;
import com.o2.finance.properties.PropertyManager;
import com.o2.finance.service.adapter.SoaServiceClientAdapter;

import com.o2.smart421.ws.sms.SendMessagePortType;
import com.o2.smart421.ws.sms.model.MessageType;
import com.o2.smart421.ws.sms.model.SOAFaultType;
import com.o2.smart421.ws.sms.model.SendSMS;
import com.o2.smart421.ws.sms.model.SendSMSResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.o2.smart421.ws.sms.SendMessage_Impl;
import weblogic.webservice.core.rpc.StubImpl;

import javax.xml.namespace.QName;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Purpose:
 * com.o2.finance.service
 * User: D Smith
 * Date: 09/07/2011
 */
public class JaxRpcSendSmsSoaServiceImpl extends SoaServiceClientAdapter implements SmsService, ExceptionConstants
{

    private static Logger log = LogManager.getLogger( JaxRpcSendSmsSoaServiceImpl.class );

    private static final String PORTNAME = "SendMessagePortType";

//    private SendMessagePortType port;



    private JaxRpcSendSmsSoaServiceImpl()
    {
        init();
    }

    public static JaxRpcSendSmsSoaServiceImpl createJaxRpcSendSmsSoaServiceImpl()
    {
        return new JaxRpcSendSmsSoaServiceImpl();
    }


    private void init()
    {
        log.info( "init start." );

        ApplicationProperties props = PropertyManager.getApplicationProperties();


        log.info( "Creating service implementation." );

        try
        {
            serviceImplementation = new SendMessage_Impl(  );
        }
        catch (IOException e)
        {
            log.error( e.getMessage(), e );
            throw new RuntimeServiceException( this.getClass(), "init", e );
        }


        String endPoint = props.getSmsServiceEndpoint();

        port = (( SendMessage_Impl ) serviceImplementation ).getSendMessagePortType();
        log.info( "Port created." );

        portName = new QName( endPoint, PORTNAME );


        try
        {
            ((StubImpl) port)._setTargetEndpoint( new URL( endPoint ) );
            log.info( "Endpoint set on port." );
        }
        catch (MalformedURLException e)
        {
            log.error( e.getMessage(), e );
            throw new RuntimeServiceException( this.getClass(), "init", e );
        }

        setupHandlers();

        log.info( "init ends." );

    }


    public void sendSMS( String msisdn, String message ) throws FinanceServiceSLMBreachException
    {
        log.info( "sendSMS start." );

        ApplicationProperties properties = PropertyManager.getApplicationProperties();

        try
        {
            log.debug( "Creating sms port." );
            String endpoint = properties.getSmsServiceEndpoint();

			String smsServiceTTL = properties.getSmsServiceTtl();
			String smsServiceMTProfile = properties.getSmsServiceMtProfile();
			String smsServiceMessageType = properties.getSmsServiceMessageType();


            SendSMS sendSMS = new SendSMS();
			sendSMS.setTtl(Integer.parseInt(smsServiceTTL));
			sendSMS.setMtProfile(smsServiceMTProfile);
            sendSMS.setMessageType( MessageType.fromValue( smsServiceMessageType ) );
			sendSMS.setMessage(message);

            // only ever sending to one msisdn
            String[] msisdnArray = new String[1];

            msisdnArray[0] = msisdn;

            sendSMS.setMsisdnList( msisdnArray );

            log.info( "Sending sms to msisdn " + msisdn );
            SendSMSResponse response =  (( SendMessagePortType) port).sendSMS( sendSMS );

            if ( null != response && null != response.getResult())
            {
                log.info( "SMS result was " + response.getResult().toString() );
            }
        }
        catch (IOException e)
        {
            log.error( e.getMessage(), e );
            throw new RuntimeServiceException( this.getClass(), "sendSMS", e );
        }
        catch (SOAFaultType soaFaultType)
        {

            if ( SLM_BREACH_DESCRIPTION.equalsIgnoreCase( soaFaultType.getFaultDescription()) )
            {
                log.debug( "Caught SLM Breach for service SendSMS.sendSMS." );

                throw new FinanceServiceSLMBreachException(
                    soaFaultType.getSOAFaultCode(), soaFaultType.getFaultDescription(), null);

            }  else
            {
                log.error( soaFaultType.getMessage(), soaFaultType );

                String faultCode = soaFaultType.getSOAFaultCode();
                throw new RuntimeServiceException( this.getClass(), "sendSMS", soaFaultType, faultCode);
            }

        }

        log.info( "sendSMS ends." );
    }

}
