package com.o2.finance.service;

import com.o2.finance.etc.ExceptionConstants;
import com.o2.finance.exception.AuthenticationServiceException;
import com.o2.finance.exception.FinanceServiceSLMBreachException;
import com.o2.finance.exception.unchecked.RuntimeServiceException;
import com.o2.finance.properties.ApplicationProperties;
import com.o2.finance.properties.PropertyManager;
import com.o2.finance.service.adapter.SoaServiceClientAdapter;
import com.o2.smart421.ws.onlineCustomer.OnlineCustomerPort;
import com.o2.smart421.ws.onlineCustomer.OnlineCustomerService_Impl;
import com.o2.smart421.ws.onlineCustomer.model.GetPortalProfile;
import com.o2.smart421.ws.onlineCustomer.model.GetPortalProfileResponse;
import com.o2.smart421.ws.onlineCustomer.model.PortalProfile;
import com.o2.smart421.ws.onlineCustomer.model.SOAFaultType;
import com.o2.smart421.ws.onlineCustomer.model.StatusCodeType;
import com.o2.smart421.ws.onlineCustomer.model.Verify;
import com.o2.smart421.ws.onlineCustomer.model.VerifyResponse;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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
public class JaxRpcAuthenticationSoaServiceImpl extends SoaServiceClientAdapter implements AuthenticationService, ExceptionConstants
{


	private static final String PORTAL_SHOULD_HAVE_MSISDN = "onlinecustomer-11220-3003-E";

	private static final String AUTHENTICATION_FAILED = "onlinecustomer-11220-3000-E";

    private static Logger log = LogManager.getLogger( JaxRpcAuthenticationSoaServiceImpl.class );


    private static final String PORTNAME = "OnlineCustomerPort";

//    private OnlineCustomerPort port;
//    private ServiceImpl serviceImplementation;


    private JaxRpcAuthenticationSoaServiceImpl()
    {
        init();
    }

    public static JaxRpcAuthenticationSoaServiceImpl createJaxRpcAuthenticationSoaServiceImpl()
    {
        return new JaxRpcAuthenticationSoaServiceImpl();
    }

    private void init()
    {
        log.info( "init start." );


        ApplicationProperties props = PropertyManager.getApplicationProperties();

        log.info( "Creating service implementation." );
        try
        {
            serviceImplementation = new OnlineCustomerService_Impl();
        }
        catch (IOException e)
        {
            log.error( e.getMessage(), e );
            throw new RuntimeServiceException( this.getClass(), "init", e );

        }


        String endPoint = props.getOnlineCustomerServiceEndpoint();

        log.info( "Creating service port." );

        port = ( (OnlineCustomerService_Impl) serviceImplementation).getOnlineCustomerPort();

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



    public boolean isUserLoggedIn( String userId, String authToken ) throws AuthenticationServiceException, FinanceServiceSLMBreachException
    {


        log.info( "isUserLoggedIn start." );

        boolean response = false;

        try
        {

            Verify verify = new Verify();

            verify.setCustomerID( userId );
            verify.setAuthToken( authToken );

            log.debug( "Calling web service." );
            VerifyResponse verifyResponse = (( OnlineCustomerPort) port).verify( verify );

            StatusCodeType statusCode = verifyResponse.getResult();

            if (statusCode.getValue().equalsIgnoreCase( StatusCodeType.success.getValue() ))
            {
                log.debug( "User is logged in." );
                response = true;

            } else
            {
                String description = verifyResponse.getDescription();
                log.info( "Result of login verification of" + userId + " is " + statusCode.getValue() + " - " +
                        description );

                response = false;

            }

        }
        catch (IOException e)
        {
            log.error( e.getMessage(), e );
            throw new RuntimeServiceException( this.getClass(), "isUserLoggedIn", e );
        }
        catch (SOAFaultType soaFaultType)
        {

            if ( SLM_BREACH_DESCRIPTION.equalsIgnoreCase( soaFaultType.getFaultDescription()) )
            {
                log.debug( "Caught SLM Breach for service OnlineCustomer.verify." );

                throw new FinanceServiceSLMBreachException(
                    soaFaultType.getSOAFaultCode(), soaFaultType.getFaultDescription(), null);

            }  else
            {
            	log.error("!!!!!!!!!"+soaFaultType.getSOAFaultCode()	);
                
                if(PORTAL_SHOULD_HAVE_MSISDN.equals(soaFaultType.getSOAFaultCode()))
                {
             	   	//<Portal Account should be associated with a valid MSISDN>	
                	
            			log.error("!!!!!!!!!"+soaFaultType.getSOAFaultCode());
            			log.error("!!!!!!!!!");
            			throw new AuthenticationServiceException( soaFaultType.getMessage(), soaFaultType, soaFaultType.getSOAFaultCode() );
                }
                
             	if(AUTHENTICATION_FAILED.equals(soaFaultType.getSOAFaultCode()))
             	{
             		//Authentication failed due to incorrect customerid or authtoken
             		
             		log.error("!!!!!!!!!"+soaFaultType.getSOAFaultCode());
             		log.error("!!!!!!!!!");
             		throw new AuthenticationServiceException( soaFaultType.getMessage(), soaFaultType, soaFaultType.getSOAFaultCode() );
             	}
            	//onlinecustomer-11220-3002-E
             	//Failed to retrieve user details
             	
            	log.error( soaFaultType.getMessage(), soaFaultType );

                String faultCode = soaFaultType.getSOAFaultCode();
                throw new RuntimeServiceException( this.getClass(), "isUserLoggedIn", soaFaultType, faultCode);
            }

        }

        log.info( "isUserLoggedIn ends." );
        return response;


    }

    public String getUsername( String userId, String authToken ) throws AuthenticationServiceException, FinanceServiceSLMBreachException
    {
        log.info( "getUsername start." );

        String portalId = null;

        GetPortalProfile getPortalProfile = new GetPortalProfile();              
        getPortalProfile.setCustomerID(userId);
        getPortalProfile.setAuthToken( authToken );

        try
        {
            log.info( "Calling web service." );
            GetPortalProfileResponse response =(( OnlineCustomerPort) port).getPortalProfile( getPortalProfile );

            PortalProfile profile = response.getPortalProfile();

            portalId = profile.getPortalID();
            log.info( "Portal ID [" + portalId  + "] found for userId [" +
                    userId + "] and authToken [" + authToken + "]");

        }
        catch (IOException e)
        {
            log.error( e.getMessage(), e );
            throw new RuntimeServiceException( this.getClass(), "getUsername", e );
        }
        catch (SOAFaultType soaFaultType)
        {

            if ( SLM_BREACH_DESCRIPTION.equalsIgnoreCase( soaFaultType.getFaultDescription()) )
            {
                log.debug( "Caught SLM Breach for service OnlineCustomer.getPortalProfile." );

                throw new FinanceServiceSLMBreachException(
                    soaFaultType.getSOAFaultCode(), soaFaultType.getFaultDescription(), null);

            }  else
            {
               log.error("!!!!!!!!!"+soaFaultType.getSOAFaultCode()	);
               log.error( soaFaultType.getMessage(), soaFaultType );
               if(PORTAL_SHOULD_HAVE_MSISDN.equals(soaFaultType.getSOAFaultCode()))
               {
            	   	//<Portal Account should be associated with a valid MSISDN>	
               		log.error("!!!!!!!!!");
           			log.error("!!!!!!!!!"+soaFaultType.getSOAFaultCode());
           			log.error("!!!!!!!!!");
           			throw new AuthenticationServiceException( soaFaultType.getMessage(), soaFaultType, soaFaultType.getSOAFaultCode() );
               }
               
            	if(AUTHENTICATION_FAILED.equals(soaFaultType.getSOAFaultCode()))
            	{
            		//Authentication failed due to incorrect customerid or authtoken
            		log.error("!!!!!!!!!");
            		log.error("!!!!!!!!!"+soaFaultType.getSOAFaultCode());
            		log.error("!!!!!!!!!");
            		throw new AuthenticationServiceException( soaFaultType.getMessage(), soaFaultType, soaFaultType.getSOAFaultCode() );
            	}
            	//onlinecustomer-11220-3002-E
            	//Failed to retrieve user details
            	
            	
                String faultCode = soaFaultType.getSOAFaultCode();
                throw new RuntimeServiceException( this.getClass(), "getUsername", soaFaultType, faultCode);
            }

        }


        log.info( "getUsername ends." );
        return portalId;

    }


}
