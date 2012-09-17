package com.o2.finance.service;

import java.rmi.RemoteException;

import com.o2.finance.properties.ApplicationProperties;
import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.rampart.RampartMessageData;

import com.o2.finance.exception.unchecked.RuntimeServiceException;
import com.o2.finance.properties.PropertyManager;
import com.o2.finance.ws.sms.client.smsservice.SendMessage;
import com.o2.finance.ws.sms.client.smsservice.SendMessageStub;
import com.o2.finance.ws.sms.client.smsservice.SendSMSFault;

import uk.co.o2.soa.coredata_1.MsisdnType;
import uk.co.o2.soa.sendmessagedata_1.MessageType;
import uk.co.o2.soa.sendmessagedata_1.MsisdnList;
import uk.co.o2.soa.sendmessagedata_1.SendSMS;
import uk.co.o2.soa.sendmessagedata_1.SendSMSE;

public class SmsServiceImpl extends TwoWaySSLSupportingService implements SmsService
{

	static Logger log = LogManager.getLogger(SmsServiceImpl.class);
    private SendMessage service;

	private SmsServiceImpl()
	{
		super();
		init();
	}

	
    private void init()
   {

    	log.info( "init start." );

        ApplicationProperties props     = PropertyManager.getApplicationProperties();
        String                endPoint  = props.getSmsServiceEndpoint();
        boolean               isSecured = props.getPaaWsSecurityOn();
        
        try
        {
            SendMessageStub stub = new SendMessageStub(getConfigurationContext(), endPoint);
            if(isSecured)
            {
            	log.debug( "Call is secured." );
                String username = props.getPaaWsSecurityUsername();
                String password = props.getPaaWsSecurityPasswd();
                String policy   = props.getAxis2RampartPolicy();
                
                log.debug( "Setting up secure connection." );
                ServiceClient client  = stub._getServiceClient();
                Options       options = client.getOptions();
                options.setProperty(RampartMessageData.KEY_RAMPART_POLICY, loadPolicy(policy));
                options.setUserName(username);
                options.setPassword(password);
                client.engageModule("rampart");        
            }
            this.service = stub;
        }
        catch(Exception e)
        {
            throw new RuntimeException(e);
        }

        log.info( "init ends." );
    }


	public static SmsServiceImpl createSmsServiceImpl()
	{
		return new SmsServiceImpl();
	}

	public void sendSMS(String msisdn, String message) 
	{
		log.info( "sendSMS: start." );
		
		try
		{
            ApplicationProperties properties = PropertyManager.getApplicationProperties();
			
			String smsServiceTTL = properties.getSmsServiceTtl();
			String smsServiceMTProfile = properties.getSmsServiceMtProfile();
			String smsServiceMessageType = properties.getSmsServiceMessageType();

			SendSMS sendSMS = new SendSMS();
			
			sendSMS.setTtl(Integer.parseInt(smsServiceTTL));
			sendSMS.setMtProfile(smsServiceMTProfile);
			sendSMS.setMessageType(MessageType.Factory.fromValue(smsServiceMessageType));
			sendSMS.setMessage(message);
			
			MsisdnList msisdnList = new MsisdnList();			
			MsisdnType[] msisdnTypes = {new MsisdnType()};
			msisdnTypes[0].setMsisdnType(msisdn);
			msisdnList.setMsisdn(msisdnTypes);
			sendSMS.setMsisdnList(msisdnList);
						
			SendSMSE sendSMSE = new SendSMSE();			
			sendSMSE.setSendSMS(sendSMS);
            log.info( "Sending sms: " + message + " to msisdn " + msisdn );
			service.sendSMS(sendSMSE);
			
		}
		catch (AxisFault axisFault)
		{
            log.error( axisFault.getMessage(), axisFault );
			throw new RuntimeServiceException( this.getClass(), "sendSMS", axisFault );
		}
		catch (RemoteException re)
		{
            log.error( re.getMessage(), re );
			throw new RuntimeServiceException( this.getClass(), "sendSMS", re );
		}
		catch (SendSMSFault sme)
		{
            log.error( sme.getMessage(), sme );
			String faultCode = sme.getFaultMessage().getSendSMSFault().getSOAFaultCode();
			throw new RuntimeServiceException( this.getClass(), "sendSMS", sme, faultCode );
		}
		
		log.info( "sendSMS: end." );		
	}

}
