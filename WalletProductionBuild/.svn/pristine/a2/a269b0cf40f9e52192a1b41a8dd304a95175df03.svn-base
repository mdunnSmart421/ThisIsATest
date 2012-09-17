package com.o2.finance.service;

import com.o2.finance.exception.AuthenticationServiceException;
import com.o2.finance.exception.unchecked.RuntimeServiceException;
import com.o2.finance.properties.ApplicationProperties;
import com.o2.finance.properties.PropertyManager;
import com.o2.finance.ws.onlineCustomer.client.onlineCustomer.GetPortalProfileFault;
import com.o2.finance.ws.onlineCustomer.client.onlineCustomer.LoginFault;
import com.o2.finance.ws.onlineCustomer.client.onlineCustomer.OnlineCustomerService;
import com.o2.finance.ws.onlineCustomer.client.onlineCustomer.OnlineCustomerServiceStub;
import com.o2.finance.ws.onlineCustomer.client.onlineCustomer.VerifyFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.rampart.RampartMessageData;
import uk.co.o2.soa.coredata_1.CustomerIDType;
import uk.co.o2.soa.coredata_1.PortalIDType;
import uk.co.o2.soa.coredata_1.StatusCodeType;
import uk.co.o2.soa.onlinecustomerdata_1.GetPortalProfile;
import uk.co.o2.soa.onlinecustomerdata_1.GetPortalProfileE;
import uk.co.o2.soa.onlinecustomerdata_1.GetPortalProfileResponse;
import uk.co.o2.soa.onlinecustomerdata_1.GetPortalProfileResponseE;
import uk.co.o2.soa.onlinecustomerdata_1.Login;
import uk.co.o2.soa.onlinecustomerdata_1.LoginE;
import uk.co.o2.soa.onlinecustomerdata_1.LoginResponse;
import uk.co.o2.soa.onlinecustomerdata_1.LoginResponseE;
import uk.co.o2.soa.onlinecustomerdata_1.PortalProfile;
import uk.co.o2.soa.onlinecustomerdata_1.Verify;
import uk.co.o2.soa.onlinecustomerdata_1.VerifyE;
import uk.co.o2.soa.onlinecustomerdata_1.VerifyResponse;
import uk.co.o2.soa.onlinecustomerdata_1.VerifyResponseE;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

//import uk.co.o2.soa.onlinecustomerdata_1.GetPortalProfile;

/**
 * Purpose: com.o2.finance.service User: D Smith Date: 17/03/2011
 */
public class AuthenticationServiceImpl extends TwoWaySSLSupportingService implements AuthenticationService
{
    private static Logger log = LogManager.getLogger(AuthenticationServiceImpl.class);

//    private PaaService paaService;
    private Map paaErrorMap;


    private OnlineCustomerService onlineService ;

    private AuthenticationServiceImpl()
    {
        super();
//        initPAAService();

        fillErrorMap();

        initOnlineService();

    }

    public static AuthenticationServiceImpl createAuthenticationServiceImpl()
    {
        return new AuthenticationServiceImpl();
    }


    public boolean isUserLoggedIn( String userId, String authToken ) throws AuthenticationServiceException
    {
        // Call the appropriate service
        return verifyLoggedInStatus_onlineService( userId, authToken );
//        return verifyLoggedInStatus_paaService( userId, authToken );
    }


//    /**
//     * Authenticate a user against PAA
//     *
//     * @param username
//     * @param password
//     * @return
//     */
//    public AuthByNameResponse authByName( String username, String password ) throws AuthenticationServiceException
//    {
//
//        log.debug( "authByName: start." );
//
//        AuthByNameResponseE authByNameResponseE;
//        AuthByNameResponse authByNameResponse;
//        try
//        {
//            AuthByName authByName = new AuthByName();
//            AuthByNameE authByNameE = new AuthByNameE();
//            // set the required parameters
//            authByName.setUsername( username );
//            authByName.setPassword( password );
//            authByNameE.setAuthByName( authByName );
//
//            // invoke the service method
//            authByNameResponseE = paaService.authByName( authByNameE );
//            authByNameResponse = authByNameResponseE.getAuthByNameResponse();
//
//        }
//        catch (AxisFault axisFault)
//        {
//
//            //Always runtime
//            throw new RuntimeFinanceException( this.getClass(), "authByName", axisFault );
//
//        }
//        catch (RemoteException re)
//        {
//            throw new RuntimeFinanceException(  this.getClass(), "authByName", re );
//
//        }
//        catch (AuthByNameFault ex)
//        {
//            if ( null == ex.getFaultMessage() )
//            {
//                throw new RuntimeFinanceException( this.getClass(), "authByName", "FaultMessage is null.",  ex );
//            }
//
//            if ( null == ex.getFaultMessage().getAuthByNameFault() )
//            {
//                throw new RuntimeFinanceException( this.getClass(), "authByName", "AuthByNameFault is null.", ex );
//            }
//
//            if ( null == ex.getFaultMessage().getAuthByNameFault().getSOAFaultCode())
//            {
//                throw new RuntimeFinanceException( this.getClass(), "authByName", "SOAFaultCode is null.",  ex );
//            }
//
//
//            String faultCode = ex.getFaultMessage().getAuthByNameFault().getSOAFaultCode();
//
//            if ( isFaultChecked( faultCode ) )
//            {
//                throw new AuthenticationServiceException( ex.getMessage(), ex, faultCode );
//            } else
//            {
//                throw new RuntimeServiceException( this.getClass(), "authByName", ex, faultCode );
//            }
//
//        }
//
//        log.debug( "authByName end." );
//
//        return authByNameResponse;
//    }


    public String getUsername( String userId, String authToken ) throws AuthenticationServiceException
    {
        log.debug( "getUsername: start." );

        log.info( "getUsername ends." );
        return getUsername_onlineService( userId, authToken );
//        return getUsername_paaService( userId, authToken );

    }


    boolean verifyLoggedInStatus_onlineService( String userId, String authToken ) throws AuthenticationServiceException
    {
        log.info( "verifyLoggedInStatus_onlineService start." );


        boolean userLoggedIn = false;
        // Validate input parameters
        if (userId == null || authToken == null || userId.trim().length() == 0 || authToken.trim().length() == 0)
        {
            log.info( "user id and/or authtoken empty, therefore user not logged in." );
            return userLoggedIn;
        }

        log.debug( "Creating verification call for user " + userId + " with authtoken " + authToken);
        VerifyE verifyE = new VerifyE();

        Verify verify = new Verify();

        verify.setAuthToken( authToken );

        CustomerIDType id = new CustomerIDType();
        id.setCustomerIDType( userId );

        verify.setCustomerID( id );
        verifyE.setVerify( verify );

        // invoke business method
        VerifyResponseE response = null;
        try
        {
            log.debug( "Invoking verify service." );
            response = onlineService.verify( verifyE );
        }
        catch (RemoteException e)
        {
//            log.debug( "Caught exception " + e.toString() );
            log.error( e.getMessage(), e );
            throw new RuntimeServiceException( this.getClass(), "verifyLoggedInStatus_onlineService", e );
        }
        catch (VerifyFault verifyFault)
        {
            log.error( verifyFault.getMessage(), verifyFault );
            throw new RuntimeServiceException( this.getClass(), "verifyLoggedInStatus_onlineService", verifyFault );
        }


        log.debug( "Reading response." );
        VerifyResponse verifyResponse = response.getVerifyResponse();

        StatusCodeType statusCodeType = verifyResponse.getResult();

        log.debug( "Received status code " + statusCodeType.getValue() );

        String status = statusCodeType.getValue();

        if ( StatusCodeType.success.getValue().equalsIgnoreCase( status ) )
        {
            log.debug( "User is logged in." );
            userLoggedIn = true;
        } else
        {
            String description = verifyResponse.getDescription();
            log.info( "Result of login verification of " + userId + " is " + status + " - " + description );
            userLoggedIn = false;
        }

        log.info( "verifyLoggedInStatus_onlineService ends." );
        return userLoggedIn;
    }


//    private boolean verifyLoggedInStatus_paaService( String userId, String authToken ) throws AuthenticationServiceException
//    {
//        log.debug("verifyLoggedInStatus_paaService: start.");
//
//        boolean userLoggedIn = false;
//        // Validate input parameters
//        if (userId == null || authToken == null || userId.trim().length() == 0 || authToken.trim().length() == 0)
//        {
//            return userLoggedIn;
//        }
//        ValidateAuthToken validateAuthToken = new ValidateAuthToken();
//        ValidateAuthTokenE validateAuthTokenE = new ValidateAuthTokenE();
//        try
//        {
//            // Call appropriate method on service ...
//            validateAuthToken.setUserId( userId );
//            validateAuthToken.setAuthToken( authToken );
//            validateAuthTokenE.setValidateAuthToken( validateAuthToken );
//
//            // invoke the service method
//            ValidateAuthTokenResponseE response = paaService.validateAuthToken(validateAuthTokenE);
//            String result = response.getValidateAuthTokenResponse().getResult();
//            if (result != null && result.equalsIgnoreCase("SUCCESS"))
//            {
//                userLoggedIn = true;
//            }
//        }
//        catch (AxisFault axisFault)
//        {
//
//            throw new RuntimeFinanceException( this.getClass(), "getUsername", axisFault );
//
//        }
//        catch (RemoteException re)
//        {
//            throw new RuntimeFinanceException( this.getClass(), "verifyLoggedInStatus_paaService", re );
//
//        }
//        catch (ValidateAuthTokenFault ex)
//        {
//            if ( null == ex.getFaultMessage() )
//            {
//                throw new RuntimeFinanceException( this.getClass(), "verifyLoggedInStatus_paaService", "FaultMessage is null.",  ex );
//            }
//
//            if ( null == ex.getFaultMessage().getValidateAuthTokenFault() )
//            {
//                throw new RuntimeFinanceException( this.getClass(), "verifyLoggedInStatus_paaService", "getValidateAuthTokenFault is null.", ex );
//            }
//
//            if ( null == ex.getFaultMessage().getValidateAuthTokenFault().getSOAFaultCode())
//            {
//                throw new RuntimeFinanceException( this.getClass(), "verifyLoggedInStatus_paaService", "SOAFaultCode is null.",  ex );
//            }
//
//
//            String faultCode = ex.getFaultMessage().getValidateAuthTokenFault().getSOAFaultCode();
//
//            if ( isFaultChecked( faultCode ) )
//            {
//                throw new AuthenticationServiceException( ex.getMessage(), ex, faultCode );
//            } else
//            {
//                throw new RuntimeServiceException( this.getClass(), "verifyLoggedInStatus_paaService", ex, faultCode );
//            }
//        }
//
//        log.debug( "verifyLoggedInStatus_paaService end." );
//
//        return userLoggedIn;
//    }


    String getUsername_onlineService( String userId, String authToken ) throws AuthenticationServiceException
    {
        log.info( "getUsername_onlineService start." );

        String portalUsername = null;

        // Validate input parameters
        if (validateUsernameParameters( userId, authToken ))
        {
            GetPortalProfile profile = new GetPortalProfile();
            profile.setAuthToken( authToken );

            CustomerIDType id = new CustomerIDType();
            id.setCustomerIDType( userId );

            profile.setCustomerID( id );

            GetPortalProfileE portalProfileE = new GetPortalProfileE();

            portalProfileE.setGetPortalProfile( profile );

            try
            {
                GetPortalProfileResponseE response = onlineService.getPortalProfile( portalProfileE );

                GetPortalProfileResponse profileResponse = response.getGetPortalProfileResponse();

                PortalProfile portalProfile = profileResponse.getPortalProfile();
                PortalIDType idType = portalProfile.getPortalID();
                portalUsername = idType.getPortalIDType();

            }
            catch (RemoteException e)
            {
                log.error( e.getMessage(), e );
                throw new RuntimeServiceException( this.getClass(), "getUsername_onlineService", e );
            }
            catch (GetPortalProfileFault e)
            {
                log.error( e.getMessage(), e );
                throw new RuntimeServiceException( this.getClass(), "getUsername_onlineService", e );
            }
        }

        log.info( "getUsername_onlineService ends." );
        return portalUsername;
    }



    void logUserIn( String username, String password )
    {
        LoginE loginE = new LoginE();

        Login login = new Login();
        PortalIDType portalIDType = new PortalIDType();
        portalIDType.setPortalIDType( username );

        login.setPassword( password );
        login.setUsername( portalIDType );

        loginE.setLogin( login );

        try
        {
            LoginResponseE loginResponseE =  onlineService.login( loginE );

            LoginResponse loginResponse = loginResponseE.getLoginResponse();

            StatusCodeType statusCode =  loginResponse.getResult();
            if ( StatusCodeType.success.getValue().equalsIgnoreCase( statusCode.getValue()  ) )
            {
                String authToken =  loginResponse.getAuthToken();
                CustomerIDType customerIDType = loginResponse.getCustomerID();
                String customerId =  customerIDType.getCustomerIDType();

//                OnlineCustomer customer = loginResponse.getOnlineCustomer();

                // TODO - finish this in the office

            }

        }
        catch (RemoteException e)
        {
            log.error( e.getMessage(), e );
            throw new RuntimeServiceException( this.getClass(), "logUserIn", e );

        }
        catch (LoginFault e)
        {
            log.error( e.getMessage(), e );
            throw new RuntimeServiceException( this.getClass(), "logUserIn", e );

        }
    }


//    String getUsername_paaService( String userId, String authToken ) throws AuthenticationServiceException
//    {
//        log.debug( "getUsername_paaService: start." );
//
//        GetUserDetailsResponse getUserDetailsResponse = null;
//
//        String portalUsername = null;
//
//
//        // Validate input parameters
//        if ( validateUsernameParameters(userId, authToken) )
//        {
//
//            GetUserDetails getUserDetails = new GetUserDetails();
//            GetUserDetailsE getUserDetailsE = new GetUserDetailsE();
//
//            try
//            {
//                // Call appropriate method on service ...
//                getUserDetails.setUserId( userId );
//                getUserDetails.setAuthToken( authToken );
//                getUserDetailsE.setGetUserDetails( getUserDetails );
//
//                // invoke the service method
//                GetUserDetailsResponseE response = paaService.getUserDetails( getUserDetailsE );
//                getUserDetailsResponse = response.getGetUserDetailsResponse();
//
//            }
//            catch (AxisFault axisFault)
//            {
//                throw new RuntimeFinanceException( this.getClass(), "getUsername_paaService", axisFault );
//            }
//            catch (RemoteException re)
//            {
//
//                throw new RuntimeFinanceException( this.getClass(), "getUsername_paaService", re );
//
//            }
//            catch (GetUserDetailsFault ex)
//            {
//                if (null == ex.getFaultMessage())
//                {
//                    throw new RuntimeFinanceException( this.getClass(), "getUsername_paaService", "FaultMessage is null.", ex );
//                }
//
//                if (null == ex.getFaultMessage().getGetUserDetailsFault())
//                {
//                    throw new RuntimeFinanceException( this.getClass(), "getUsername_paaService", "getGetUserDetailsFault is null.", ex );
//                }
//
//                if (null == ex.getFaultMessage().getGetUserDetailsFault().getSOAFaultCode())
//                {
//                    throw new RuntimeFinanceException( this.getClass(), "getUsername_paaService", "SOAFaultCode is null.", ex );
//                }
//
//
//                String faultCode = ex.getFaultMessage().getGetUserDetailsFault().getSOAFaultCode();
//
//                if (isFaultChecked( faultCode ))
//                {
//                    throw new AuthenticationServiceException( ex.getMessage(), ex, faultCode );
//                } else
//                {
//                    throw new RuntimeServiceException( this.getClass(), "getUsername_paaService", ex, faultCode );
//                }
//
//            }
//
//
//            if (null != getUserDetailsResponse.getPortalUserName())
//            {
//                portalUsername = getUserDetailsResponse.getPortalUserName();
//            }
//        }
//
//        log.debug( "getUsername_paaService end." );
//
//        return portalUsername;
//
//    }



    private boolean validateUsernameParameters( String userId, String authToken )
    {
        if (!( userId == null || authToken == null || userId.trim().length() == 0 || authToken.trim().length() == 0 ))
        {
            return true;
        } else
        {
            return false;
        }
    }


    private boolean isFaultChecked( String errorNumber )
    {

        boolean result = false;

        if ( paaErrorMap.containsKey( errorNumber.toUpperCase() ) )
        {
            result =  (( ErrorMapEntry ) paaErrorMap.get( errorNumber.toUpperCase() )).checked;
        }
        else
        {
            // Could not find error in map so indicate that unchecked exception should be thrown
            result = false;
        }

        return result;

    }


//    /*
//    * Loads the WS-Security information required to authenticate against
//    * the web service.
//    */
//    private void initPAAService()
//    {
//        log.info( "initPAAService start." );
//
//        ApplicationProperties props     = PropertyManager.getApplicationProperties();
//        String                endPoint  = props.getPaaServiceEndPoint();
//        boolean               isSecured = props.getPaaWsSecurityOn();
//
//        try
//        {
//            /*
//            * Create a STUB with an AXIS2 configuration containing the RAMPART
//            * WS-Security settings
//            */
//            log.debug( "Getting PAA stub." );
//            PaaServiceStub stub = new PaaServiceStub(getConfigurationContext(), endPoint);
//
//            if(isSecured)
//            {
//                log.debug( "Call is secured for PAA stub." );
//                String username = props.getPaaWsSecurityUsername();
//                String password = props.getPaaWsSecurityPasswd();
//                String policy   = props.getAxis2RampartPolicy();
//
//                log.debug( "Setting up secure connection for PAA stub." );
//                ServiceClient client  = stub._getServiceClient();
//                // Add policy data along with authentication.
//                Options       options = client.getOptions();
//                options.setProperty(RampartMessageData.KEY_RAMPART_POLICY, loadPolicy(policy));
//                options.setUserName(username);
//                options.setPassword(password);
//                // Engages module if not previously engaged.
//                client.engageModule("rampart");
//            }
//            this.paaService = stub;
//        }
//        catch(Exception e)
//        {
//            throw new RuntimeException(e);
//        }
//
//        log.info( "initPAAService ends." );
//    }


    private void initOnlineService()
    {
        log.info( "initOnlineService start." );

        ApplicationProperties props = PropertyManager.getApplicationProperties();
        String endPoint = props.getOnlineCustomerServiceEndpoint();
        boolean isSecured = props.getOnlineWsSecurityOn();

        try
        {
            /*
            * Create a STUB with an AXIS2 configuration containing the RAMPART
            * WS-Security settings
            */
            OnlineCustomerServiceStub stub = new OnlineCustomerServiceStub( getConfigurationContext(), endPoint );
            if (isSecured)
            {
                log.debug( "Call is secured for OnlineCustomer stub." );
                String  username = props.getOnlineWsSecurityUsername();
                String password = props.getOnlineWsSecurityPasswd();
                String policy = props.getAxis2RampartPolicy();

                log.debug( "Getting client." );
                ServiceClient client = stub._getServiceClient( );
                // Add policy data along with authentication.

                log.debug( "Setting client options." );
                Options options = client.getOptions();
                options.setProperty( RampartMessageData.KEY_RAMPART_POLICY, loadPolicy( policy ) );
                options.setUserName( username );
                options.setPassword( password );

                log.debug( "Engaging rampart module." );
                // Engages module if not previously engaged.
                client.engageModule( "rampart" );
            }

            this.onlineService = stub;

        } catch (Exception e)
        {
            log.debug( "Caught exception: " + e.toString());
            throw new RuntimeException( e );
        }


        log.info( "initOnlineService ends." );
    }


    private void fillErrorMap()
    {
        paaErrorMap = new HashMap();
        paaErrorMap.put( "PAA001F", new ErrorMapEntry("PAA001F", false ) );
        paaErrorMap.put( "PAA002F", new ErrorMapEntry("PAA002F", false ) );
        paaErrorMap.put( "PAA003F", new ErrorMapEntry("PAA003F", false ) );
        paaErrorMap.put( "PAA004F", new ErrorMapEntry("PAA004F", false ) );

        paaErrorMap.put( "PAA2001E", new ErrorMapEntry("PAA001E", false ) );
        paaErrorMap.put( "PAA2002E", new ErrorMapEntry("PAA002E", true ) );
        paaErrorMap.put( "PAA2003E", new ErrorMapEntry("PAA003E", true ) );
        paaErrorMap.put( "PAA2005E", new ErrorMapEntry("PAA005E", false ) );
        paaErrorMap.put( "PAA2007E", new ErrorMapEntry("PAA007E", false ) );
        paaErrorMap.put( "PAA2008E", new ErrorMapEntry("PAA008E", false ) );
        paaErrorMap.put( "PAA2011E", new ErrorMapEntry("PAA011E", true ) );
        paaErrorMap.put( "PAA2012E", new ErrorMapEntry("PAA012E", true ) );
        paaErrorMap.put( "PAA2013E", new ErrorMapEntry("PAA013E", false ) );
        paaErrorMap.put( "PAA2014E", new ErrorMapEntry("PAA014E", false ) );
        paaErrorMap.put( "PAA2015E", new ErrorMapEntry("PAA015E", false ) );
        paaErrorMap.put( "PAA2016E", new ErrorMapEntry("PAA016E", false ) );
        paaErrorMap.put( "PAA2018E", new ErrorMapEntry("PAA018E", false ) );
        paaErrorMap.put( "PAA2019E", new ErrorMapEntry("PAA019E", false ) );

    }


    private class ErrorMapEntry
    {
        public String  errorCode;
        public boolean checked;

        private ErrorMapEntry( String errorCode, boolean checked )
        {
            this.errorCode = errorCode;
            this.checked   = checked;
        }

        /* (non-Javadoc)
         * @see java.lang.Object#hashCode()
         */
        public int hashCode()
        {
            final int prime = 31;
            int result = 1;
            result = prime * result + getOuterType().hashCode();
            result = prime * result + (checked ? 1231 : 1237);
            result = prime * result + ((errorCode == null) ? 0 : errorCode.hashCode());
            return result;
        }

        /* (non-Javadoc)
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
            ErrorMapEntry other = (ErrorMapEntry) obj;
            if (!getOuterType().equals(other.getOuterType()))
                return false;
            if (checked != other.checked)
                return false;
            if (errorCode == null)
            {
                if (other.errorCode != null)
                    return false;
            } else if (!errorCode.equals(other.errorCode))
                return false;
            return true;
        }

        private AuthenticationServiceImpl getOuterType()
        {
            return AuthenticationServiceImpl.this;
        }
    }
}
