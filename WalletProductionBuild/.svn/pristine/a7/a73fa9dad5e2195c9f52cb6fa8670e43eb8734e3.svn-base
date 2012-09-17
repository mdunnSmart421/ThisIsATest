package com.o2.finance.facade;

import com.o2.finance.beans.FriendlyUsernameLabelBean;
import com.o2.finance.exception.AddressNotFoundException;
import com.o2.finance.exception.FinanceDelegateException;
import com.o2.finance.exception.FinanceException;
import com.o2.finance.exception.FinanceServiceOtacTriesExceededException;
import com.o2.finance.exception.FinanceServiceSLMBreachException;
import com.o2.finance.exception.FinanceServiceVerificationCodeTriesExceededException;
import com.o2.finance.exception.MaxSecondaryAccsExceededException;
import com.o2.finance.exception.MsisdnBarredException;
import com.o2.finance.exception.NotImplementedException;
import com.o2.finance.exception.SearchServiceIdentitiesExceededException;
import com.o2.finance.exception.UserNameAlreadyExistsException;
import com.o2.finance.exception.UserNotFoundException;
import com.o2.finance.exception.UsernameExistsInReservedUsernameTableException;
import com.o2.finance.exception.unchecked.RuntimeFinanceException;
import com.o2.finance.model.UserTO;
import com.o2.finance.properties.PropertyManager;
import com.o2.finance.service.*;
import com.o2.www.broadband.avatartypes.CreateUserRequestType;
import com.o2.www.broadband.avatartypes.CreateUserResponseType;
import com.o2.www.broadband.avatartypes.UpdateUserRequestType;
import com.o2.www.broadband.avatartypes.UpdateUserResponseType;
import com.o2.www.broadband.avatartypes.UserCreationType;
import com.o2.www.broadband.avatartypes.UserDataType;
import com.o2.www.broadband.avatartypes.UsernameSuggestionsType;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import uk.co.o2.registration.registration.registrationtypes.GetUserDetailsRequestType;
import uk.co.o2.registration.registration.registrationtypes.GetUserDetailsResponseType;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Purpose: com.o2.finance.facade User: D Smith Date: 29/05/2011
 */
public class FinanceFacade
{
    Logger log = LogManager.getLogger(this.getClass());
    private ProductService productService;
    
    /**
     * Return a UserTO that corresponds to the given unique portal user name.
     * 
     * @param id
     *            - unique user id
     * @return UserTO, null if no user found.
     */
    public UserTO getUserByUsername(String userName)
    {
        log.info( "getUserByUsername start." );

        UserTO userTO = null;

        if (userName != null && userName.length() > 0)
        {
            OrangeService orangeService = OrangeServiceImpl.createOrangeServiceImpl();
            GetUserDetailsRequestType userRequest = new GetUserDetailsRequestType();
            GetUserDetailsResponseType userResponse;

            userRequest.setUsername( userName );

            try
            {
                try
                {
                    userResponse = orangeService.getUserDetails( userRequest );
                    UserTOAdapter adapter = new UserTOAdapter();
                    userTO = adapter.fromXML( userResponse.get_return() );

                }
                catch (UserNotFoundException e)
                {
                    log.error( "User not found: username = " + userName );
                }
            }
            catch (SAXException sae)
            {
                log.error( sae.getMessage(), sae );
                throw new RuntimeFinanceException( this.getClass(), "getUserByUsername", sae );
            }
            catch (IOException ioe)
            {
                log.error( ioe.getMessage(), ioe );
                throw new RuntimeFinanceException( this.getClass(), "getUserByUsername", ioe );
            }
            catch (ParserConfigurationException pce)
            {
                log.error( pce.getMessage(), pce );
                throw new RuntimeFinanceException( this.getClass(), "getUserByUsername", pce );
            }
        }
        log.info( "getUserByUsername ends." );

        return userTO;
    }

    /**
     * Obtains the username from the user id (MID) and authentication token (MAT)
     * 
     * @param userId
     *            user id (MID)
     * @param authToken
     *            authentication token (MAT)
     * @return username
     */
    public String getUsernameFromId(String userId, String authToken) throws FinanceException
    {
        log.info( "getUsernameFromId start." );

//        AuthenticationService service = AuthenticationServiceImpl.createAuthenticationServiceImpl();
        AuthenticationService service =  JaxRpcAuthenticationSoaServiceImpl.createJaxRpcAuthenticationSoaServiceImpl();

        String userName = service.getUsername( userId, authToken );

        log.info( "getUsernameFromId ends." );

        return userName;
    }

    /**
     * Returns all {@link com.o2.finance.model.UserTO} that correspond to the given unique MSISDN.
     * 
     * @param msisdn
     *            - MSISDN
     * @return Map containing {@link com.o2.finance.model.UserTO} objects keyed by their unique id, if
     *         no accounts are found an empty map is returned.
     */
    public Map getUsersByMsisdn(String msisdn) throws SearchServiceIdentitiesExceededException
    {
        log.info("getUsersByMsisdn:begin");
        
        Map usersMap          = new TreeMap();
        UserTO userTO         = null;
        
        log.info("About to call the Orange Search Service");
        SearchService service1 = SearchServiceImpl.createSearchServiceImpl();
        service1.searchForUsersByMsisdn(  msisdn );
        List<FriendlyUsernameLabelBean> orangeUsersList = service1.searchForUsersByMsisdn(  msisdn );        
        if(orangeUsersList.size() > 0 ) {
          log.info("Orange Search Service returned list of size " + orangeUsersList.size());
                    
          	for ( int i=0; i<orangeUsersList.size(); i++ )
          	{          		
          		FriendlyUsernameLabelBean fulb = (FriendlyUsernameLabelBean) orangeUsersList.get(i);        		          		          		
          		usersMap.put(fulb.getPortalId(), fulb);
          	}        	          
        }
        else {
          log.info("Orange Search Service did not return a list"); 	
        }
                   
        log.info("getUsersByMsisdn:end");        
        return usersMap;
    }

    /**
     * Searches PAF for addresses with corresponding: house number / name postcode
     * 
     * @param houseNumber
     * @param houseName
     * @param postcode
     * @return List of {@link com.o2.finance.beans.AddressBean}
     * @throws FinanceException
     */
    public List findAddress(String houseNumber, String houseName, String postcode) throws  AddressNotFoundException
    {
        log.info("findAddress:begin");

        PafService pafService = new PafServiceImpl();

        List addresses = pafService.findAddress(houseNumber, houseName, postcode);

        log.info("findAddress:end");

        return addresses;
    }

    /**
     * Requests a verification code (OTAC) for a given MSISDN.
     * 
     * @param msisdn
     * @return String - OTAC
     * @throws FinanceServiceSLMBreachException 
     * @throws FinanceException
     */
    public String sendOtac(String msisdn, String message) throws FinanceServiceVerificationCodeTriesExceededException, FinanceServiceSLMBreachException
    {
        log.info("sendOtac: begin.");

        OrangeService service = OrangeServiceImpl.createOrangeServiceImpl();

        String otac = service.generateOtac( msisdn );

        SmsService sendMessageService = JaxRpcSendSmsSoaServiceImpl.createJaxRpcSendSmsSoaServiceImpl();

        message = message.replaceAll( "\\$1", otac );
        if (PropertyManager.getApplicationProperties().getSendMessage())
        {
            log.info( "Sending SMS message." );
            sendMessageService.sendSMS( msisdn, message );
        } else
        {
            log.info( "NOT sending sms message." );
        }


        log.info("sendOtac: end.");

        return otac;
    }

    /**
     * Authenticates based upon a user name
     * 
     * @param username
     *            user name
     * @param authFromRequest
     *            true if authenticate from request
     * @return is user logged in
     * @throws FinanceException
     */
    public boolean isUserLoggedIn(String username, boolean authFromRequest)
    {
        log.info("isUserLoggedIn:begin");
        log.info("isUserLoggedIn:end");
        return authFromRequest && username != null && username.trim().length() > 0;
    }

    /**
     * Authenticates based upon a user id and authorisation token
     * 
     * @param userId
     *            unique user id (MID)
     * @param authToken
     *            authentication token (MAT)
     * @param authFromRequest
     *            true if authenticate from request
     * @return is user logged in
     * @throws FinanceException
     * @throws FinanceServiceSLMBreachException
     */
    public boolean isUserLoggedIn(String userId, String authToken, boolean authFromRequest) throws FinanceException
    {
        if (log.isInfoEnabled())
        {
            log.info("isUserLoggedIn:begin");
        }
        boolean result = false;
        if (authFromRequest)
        {
            result = isUserLoggedIn(userId, authFromRequest);

        }

        else if( null == userId || null == authToken || "".equalsIgnoreCase( userId ) || "".equalsIgnoreCase( authToken ) )
        {
            result = false;

        }
        else
        {
            AuthenticationService service = JaxRpcAuthenticationSoaServiceImpl.createJaxRpcAuthenticationSoaServiceImpl();
            result = service.isUserLoggedIn(userId, authToken);
        }
        if (log.isInfoEnabled())
        {
            log.info("isUserLoggedIn:end");
        }
        return result;
    }

    /**
     * Check the productId is registered as a O2 product
     * 
     * @param productID
     * @return
     */
    public boolean validateProductId(String productID) throws FinanceDelegateException
    {
        log.info( "validateProductId start." );

        boolean result;
        result = productService.validateProductId(productID);

        log.info( "validateProductId ends." );

        return result;
    }

    /**
     * Calls to Avatar Service in Orange to Create User Account
     * 
     * @param userTO
     * @return the userTO that is read back from database
     * @throws UsernameExistsInReservedUsernameTableException 
     * @throws FinanceException
     */
    public UserTO createUser(UserTO userTO) throws MsisdnBarredException, MaxSecondaryAccsExceededException,
            UserNameAlreadyExistsException, UsernameExistsInReservedUsernameTableException
    {
        log.info("createUser:begin");

        OrangeService orangeService = OrangeServiceImpl.createOrangeServiceImpl();

        CreateUserRequestType createUserRequestType = new CreateUserRequestType();
        CreateUserResponseType createUserResponseType;
        UserCreationType createUserDataType;



        // Map UserTO to UserCreationType
        AvatarServiceAdapter adapter = new AvatarServiceAdapter();
        createUserDataType = adapter.mapUserToCreationType(userTO);
        createUserRequestType.setUser( createUserDataType );

        log.info( "Calling orange createUser." );
        log.debug( "User to create: " + userTO.toString() );


        createUserResponseType = orangeService.createUser(createUserRequestType);

        log.info( "CreateUser returned - used id: " + createUserResponseType.getUser().getId() );

        // Map UserDataType to UserTO
        UserTO createdUser = adapter.mapServiceToUser(createUserResponseType.getUser());


        log.info("createUser:end");
        return createdUser;
    }
    
    /**
     * 
     * @param productId
     * @return
     * @throws FinanceException
     */
    public String getHandoffDestination(String productId) throws FinanceException
    {
        throw new NotImplementedException("getHandoffDestination");
    }
    
    
    /**
     * 
     * @param user
     * @return
     */
    public boolean isUserPostPay(UserTO user)
    {
        boolean result;

        log.info("isUserPostPay: begin.");

        OrangeService service = OrangeServiceImpl.createOrangeServiceImpl();

        log.info( "Calling orange - is user postpay." );
        result = service.isCustomerPostPay( user.getCustomerNumber().intValue() );

        log.info("isUserPostPay: end.");

        return result;
    }
    
    
    /**
     * 
     * 
     * @param msisdn
     * @param otac
     * @return
     * @throws FinanceServiceOtacTriesExceededException
     */
    public boolean verifyOtac(String msisdn, String otac) throws FinanceServiceOtacTriesExceededException
    {
        log.info( "verifyOtac start." );

        boolean result;

        OrangeService service = OrangeServiceImpl.createOrangeServiceImpl();

        log.info( "Calling orange - verifyOtac." );

        result =  service.verifyOtac(msisdn, otac);

        log.info( "verifyOtac ends." );

        return result;

    }

    /**
     * Calls to Avatar Service in Orange to Update User Account
     * 
     * @param user
     * @return
     * @throws FinanceException
     */
    public UserTO updateUser(UserTO user)
    {

        log.info( "updateUser start." );

        OrangeService orangeService = OrangeServiceImpl.createOrangeServiceImpl();
        UpdateUserRequestType updateUserRequestType = new UpdateUserRequestType();
        UpdateUserResponseType updateUserResponseType;

        UserDataType updteUserDataType;

        AvatarServiceAdapter adapter = new AvatarServiceAdapter();

        // Map UserTO to UserDataType
        updteUserDataType = adapter.mapUserToUpdateType(user);
        updateUserRequestType.setUser( updteUserDataType );

        log.info( "Calling orange - updateUser (user id is " + user.getId() + ")" );
        updateUserResponseType = orangeService.updateUser(updateUserRequestType);
        log.info( "Returned from orange." );


        // Map UserDataType to UserTO
        UserTO updatedUser = adapter.mapServiceToUser(updateUserResponseType.getUser());

        log.info( "updateUser ends." );

        return updatedUser;
    }
    
    
    /**
     * 
     * @param msisdn
     * @param productId
     * @return
     * @throws FinanceException
     */
    public boolean hasMsisdnGotProduct(String msisdn, String productId) throws FinanceException
    {
        log.info( "hasMsisdnGotProduct start." );

        boolean result;

        result = productService.hasMsisdnGotProduct( msisdn, productId );

        if ( result )
        {
            log.info( "Msisdn " + msisdn + " already has product " + productId );
        } else
        {
            log.info( "Msisdn " + msisdn + " does not have product " + productId );
        }

        log.info( "hasMsisdnGotProduct ends." );
        return result;


    }

    
    /**
     * 
     * Calls Orange service for username suggestions
     * 
     * @param forename
     * @param lastname
     * @return
     */
    public List suggestUserName(String forename, String lastname)
    {
        log.info( "suggestUserName start." );


        List suggestions = null;

        if (!( forename == null || forename.length() == 0 || lastname == null || lastname.length() == 0 ))
        {

            OrangeService orangeService = OrangeServiceImpl.createOrangeServiceImpl();

            log.info( "Calling orange suggestUsername." );
            UsernameSuggestionsType userNameSuggestions = orangeService.suggestUserName( forename, lastname );

            log.info( "suggestUsername returned" );
            suggestions = Arrays.asList( userNameSuggestions.getSuggestion() );

            log.info( "suggestUserName ends." );

        }


        log.info( "suggestUserName ends." );

        return suggestions;
    }

    /**
     * 
     * @return
     */
    public ProductService getProductService()
    {
        return productService;
    }

    /**
     * 
     * @param productService
     */
    public void setProductService(ProductService productService)
    {
        this.productService = productService;
    }
}
