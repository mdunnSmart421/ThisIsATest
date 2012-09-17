package com.o2.finance.service;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.apache.axis2.AxisFault;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import uk.co.o2.registration.registration.registrationtypes.GetUserDetailsRequestType;
import uk.co.o2.registration.registration.registrationtypes.GetUserDetailsResponseType;

import com.o2.finance.exception.FinanceServiceOtacTriesExceededException;
import com.o2.finance.exception.FinanceServiceVerificationCodeTriesExceededException;
import com.o2.finance.exception.MaxSecondaryAccsExceededException;
import com.o2.finance.exception.MsisdnBarredException;
import com.o2.finance.exception.UserNameAlreadyExistsException;
import com.o2.finance.exception.UserNotFoundException;
import com.o2.finance.exception.UsernameExistsInReservedUsernameTableException;
import com.o2.finance.exception.unchecked.RuntimeServiceException;
import com.o2.finance.properties.PropertyManager;
import com.o2.finance.util.MsisdnConverter;
import com.o2.finance.ws.orange.client.registrationservice.RegistrationServiceStub;
import com.o2.finance.ws.www.broadband.AvatarServiceStub;
import com.o2.smart421.ws.otac.OtacServicePortType;
import com.o2.smart421.ws.otac.OtacService_Impl;
import com.o2.smart421.ws.otac.model.FaultType;
import com.o2.smart421.ws.otac.model.GenerateOtacRequestType;
import com.o2.smart421.ws.otac.model.GenerateOtacResponseType;
import com.o2.smart421.ws.otac.model.ProcessFlowType;
import com.o2.smart421.ws.otac.model.VerifyOtacRequestType;
import com.o2.smart421.ws.otac.model.VerifyOtacResponseType;
import com.o2.www.broadband.avatartypes.CreateUserRequest;
import com.o2.www.broadband.avatartypes.CreateUserRequestType;
import com.o2.www.broadband.avatartypes.CreateUserResponse;
import com.o2.www.broadband.avatartypes.CreateUserResponseType;
import com.o2.www.broadband.avatartypes.MobilePhoneType;
import com.o2.www.broadband.avatartypes.NamePairType;
import com.o2.www.broadband.avatartypes.SearchForUsersByMSISDNRequest;
import com.o2.www.broadband.avatartypes.SearchForUsersByMSISDNRequestType;
import com.o2.www.broadband.avatartypes.SearchForUsersByMSISDNResponse;
import com.o2.www.broadband.avatartypes.SuggestUserNameRequest;
import com.o2.www.broadband.avatartypes.SuggestUserNameRequestType;
import com.o2.www.broadband.avatartypes.SuggestUserNameResponse;
import com.o2.www.broadband.avatartypes.UpdateUserRequest;
import com.o2.www.broadband.avatartypes.UpdateUserRequestType;
import com.o2.www.broadband.avatartypes.UpdateUserResponse;
import com.o2.www.broadband.avatartypes.UpdateUserResponseType;
import com.o2.www.broadband.avatartypes.UserListType;
import com.o2.www.broadband.avatartypes.UserSummaryType;
import com.o2.www.broadband.avatartypes.UsernameSuggestionsType;

/**
 * Purpose: com.o2.finance.service User: D Smith Date: 18/03/2011
 */
public class OrangeServiceImpl implements OrangeService
{
    private Logger log = LogManager.getLogger(OrangeServiceImpl.class);


    private static final String VERIFICATION_CODE_TRIES_EXCEEDED = "40001";
    private static final String OTAC_TRIES_EXCEEDED = "40002";

    private OrangeServiceImpl()
    {
    }

    public static OrangeServiceImpl createOrangeServiceImpl()
    {
        return new OrangeServiceImpl();
    }


    /**
     * Contact Orange Avatar service to request an list of username suggestions based
     * on the provided forename and surname.
     * @param forename
     * @param lastname
     * @return
     */
    public UsernameSuggestionsType suggestUserName(String forename, String lastname)
    {

        log.info( "suggestUserName start." );

        //Prepare request
        SuggestUserNameRequest userNameRequest = new SuggestUserNameRequest();
        SuggestUserNameRequestType userNameRequestType = new SuggestUserNameRequestType();
        SuggestUserNameResponse userNameResponse;
        NamePairType namePairType = new NamePairType();
        UsernameSuggestionsType userNameSuggestions;

        AvatarServiceStub stub;
        String avatarServiceEndPoint = PropertyManager.getApplicationProperties().getAvatarServiceEndPoint();
        try
        {
            stub = new AvatarServiceStub(avatarServiceEndPoint);

            namePairType.setForename(forename);
            namePairType.setLastname(lastname);
            userNameRequestType.setUserNameComponents(namePairType);
            userNameRequest.setSuggestUserNameRequest(userNameRequestType);
            userNameResponse = stub.suggestUserName(userNameRequest);

            userNameSuggestions = userNameResponse.getSuggestUserNameResponse().getUsernameSuggestions();


            //TODO What happens if a username suggestion can't be generated?
        } catch (AxisFault axisFault)
        {
            log.error( axisFault.getMessage(), axisFault );
        	throw new RuntimeServiceException(this.getClass(), "suggestUserName" , axisFault);

        } catch (RemoteException re)
        {
            log.error( re.getMessage(), re );
        	throw new RuntimeServiceException(this.getClass(), "suggestUserName" , re);
        }

        log.info( "suggestUserName ends." );
        return userNameSuggestions;
    }

    public UpdateUserResponseType updateUser(UpdateUserRequestType updateUserRequestType)
    {

        log.info( "updateUser start." );

        UpdateUserRequest updateUserRequest = new UpdateUserRequest();
        UpdateUserResponse updateUserResponse;

        AvatarServiceStub stub;
        String avatarServiceEndPoint = PropertyManager.getApplicationProperties().getAvatarServiceEndPoint();
        try
        {
            stub = new AvatarServiceStub(avatarServiceEndPoint);
            updateUserRequest.setUpdateUserRequest(updateUserRequestType);

            updateUserResponse = stub.updateUser(updateUserRequest);

        } catch (AxisFault axisFault)
        {
            log.error( axisFault.getMessage(), axisFault );
            throw new RuntimeServiceException(this.getClass(), "updateUser", axisFault);

        } catch (RemoteException re)
        {
            log.error( re.getMessage(), re );
        	throw new RuntimeServiceException(this.getClass(), "updateUser", re);
        }

        log.info( "updateUser ends." );
        return updateUserResponse.getUpdateUserResponse();
    }

    public CreateUserResponseType createUser(CreateUserRequestType createUserRequesType) throws MsisdnBarredException,
            MaxSecondaryAccsExceededException, UserNameAlreadyExistsException, UsernameExistsInReservedUsernameTableException
    {

        log.info( "createUser start." );
        CreateUserRequest createUserRequest = new CreateUserRequest();
        CreateUserResponse createUserResponse;

        AvatarServiceStub stub;
        String avatarServiceEndPoint = PropertyManager.getApplicationProperties().getAvatarServiceEndPoint();

        try
        {
            stub = new AvatarServiceStub(avatarServiceEndPoint);
            createUserRequest.setCreateUserRequest(createUserRequesType);

            createUserResponse = stub.createUser(createUserRequest);

        } catch (AxisFault axisFault)
        {

            if ( null != axisFault.getFaultCode() )
            {
                if ("1002".equalsIgnoreCase( axisFault.getFaultCode().getLocalPart() ))
                {
                    log.info( "Username already exists." );

                    throw new UserNameAlreadyExistsException( "User name already exists." );
                }
                else if ("1004".equalsIgnoreCase( axisFault.getFaultCode().getLocalPart() ))
                {
                	log.info("Username exists in reservedUsername table. ");
                	//throw UserNameAlreadyExistsException as reservedusernameException will be treated the same
                	// as UserNameAlreadyExistsException.
                	throw new UsernameExistsInReservedUsernameTableException("Username exists in reservedUsername table." );
                }
            }

            log.error( axisFault.getMessage(), axisFault );
            throw new RuntimeServiceException(this.getClass(),"createUser", axisFault);

        } catch (RemoteException re)
        {
            log.error( re.getMessage(), re );
        	throw new RuntimeServiceException(this.getClass(),"createUser", re);
        }


        log.info( "createUser ends." );
        return createUserResponse.getCreateUserResponse();
    }

    /**
     * For a given msisdn, find a list of the users who have this as their contact number.
     * @param msisdn  Phone number being searched for.
     * @return List of users.
     */
    public ArrayList searchForUsersByMsisdn(String msisdn)
    {
        log.info( "searchForUsersByMsisdn start." );
        AvatarServiceStub stub;
        ArrayList users = new ArrayList();

        String avatarServiceEndPoint = PropertyManager.getApplicationProperties().getAvatarServiceEndPoint();
        try
        {
            log.info( "Creating stub." );
            stub = new AvatarServiceStub(avatarServiceEndPoint);

            SearchForUsersByMSISDNRequest request = new SearchForUsersByMSISDNRequest();
            SearchForUsersByMSISDNRequestType requestType = new SearchForUsersByMSISDNRequestType();
            MobilePhoneType mpnType = new MobilePhoneType();
            mpnType.setMobilePhoneType(msisdn);
            requestType.setMsisdn(mpnType);
            request.setSearchForUsersByMSISDNRequest(requestType);

            log.info( "Making call to search for users by msisdn service." );
            SearchForUsersByMSISDNResponse response = stub.searchForUsersByMSISDN(request);

            UserListType userList = response.getSearchForUsersByMSISDNResponse().getUsers();

            log.info("Found " + userList.getTotal() + " users.");

            if (userList.getTotal().longValue() > 0)
            {
                for (int i = 0; i < userList.getUser().length; i++)
                {
                    UserSummaryType userSummary = userList.getUser()[i];

                    users.add( UserSummaryTypeConverter.convert( userSummary )  );
                    log.info("user : " + userSummary.getId());

                }
            }
        } catch (AxisFault axisFault)
        {
            log.error( axisFault.getMessage(), axisFault );
        	throw new RuntimeServiceException(this.getClass(), "searchForUsersByMsisdn" , axisFault);

        } catch (RemoteException e)
        {
            log.error( e.getMessage(), e );
        	throw new RuntimeServiceException(this.getClass(), "searchForUsersByMsisdn" , e);
        }


        log.info( "searchForUsersByMsisdn ends." );
        return users;
    }


    /**
     *
     * @param custId
     * @return
     */
    public boolean isCustomerPostPay(int custId)
    {
        return false; // To change body of implemented methods use File | Settings | File Templates.
    }



    /**
     * Generate an OTAC (One time access code for the given msisdn.
     * The otac will only be valid for a defined period of time.
     * @param msisdn Phone number to send OTAC to.
     * @return
     * @throws FinanceServiceVerificationCodeTriesExceededException Exception thrown when user has requested too many
     * Otacs in s predefined period of time.
     */
    public String generateOtac(String msisdn) throws FinanceServiceVerificationCodeTriesExceededException
    {
        log.info( "generateOtac start." );

        String otac;

        if (null == msisdn)
        {
            RuntimeServiceException error = new RuntimeServiceException(this.getClass(), "generateOtac" , null);
            log.error( error.getMessage(), error );
            throw error;
        }

        // ensure msisdn is in international format
        String convertedMsisdn = MsisdnConverter.msisdnToInternational(msisdn);
        String endPoint = PropertyManager.getApplicationProperties().getOtacServiceEndPoint();

        try
        {

            OtacServicePortType port = new OtacService_Impl(endPoint).getOtacServicePortType();
            GenerateOtacRequestType request = new GenerateOtacRequestType();
            request.setMsisdn(convertedMsisdn);
            request.setFlow(ProcessFlowType.verifymsisdn);

            log.info( "Making call to otac service." );
            GenerateOtacResponseType response = port.generateOtac(request);

            if (response._isSetFault())
            {

                log.info( "Processing fault." );
                FaultType fault = response.getFault();

                if (null == fault)
                {


                    RuntimeServiceException error = new RuntimeServiceException(this.getClass(), "generateOtac" , null);
                    log.error("Fault is null", error);
                    throw error;

                }

                String faultCode = response.getFault().getFaultcode();
                if (VERIFICATION_CODE_TRIES_EXCEEDED.equalsIgnoreCase( faultCode ))
                {
                    throw new FinanceServiceVerificationCodeTriesExceededException(fault.getFaultcode(), fault.getFaultstring(),
                            fault.getDetail());
                } else
                {
                	RuntimeServiceException error = new RuntimeServiceException(this.getClass(), "generateOtac" , null);
                    log.error( error.getMessage(), error );
                    throw error;
                }
            } else
            {
                otac = response.getOtac();
                log.info( "Msisdn " + msisdn + " got OTAC " + otac );
            }
        } catch (IOException e)
        {
        	RuntimeServiceException error = new RuntimeServiceException(this.getClass(), "generateOtac" , e);
            log.error( error.getMessage(), error );
            throw error;
        }

        log.info( "generateOtac ends." );
        return otac;
    }

    /**
     * Verify that the OTAC (one time access code) matches that which was generated for the given msisdn
     *
     * @param msisdn
     * @param otac
     * @return
     * @throws FinanceServiceOtacTriesExceededException
     */
    public boolean verifyOtac(String msisdn, String otac) throws FinanceServiceOtacTriesExceededException
    {

        log.info("verifyOtac.start.");

        boolean isVerified = false;
        String convertedMsisdn = MsisdnConverter.msisdnToInternational(msisdn);
        String endPoint = PropertyManager.getApplicationProperties().getOtacServiceEndPoint();

        try
        {
            {
                log.debug("Creating otacService port.");
                OtacServicePortType port = new OtacService_Impl(endPoint).getOtacServicePortType();
                VerifyOtacRequestType request = new VerifyOtacRequestType();
                request.setMsisdn(convertedMsisdn);
                request.setOtac(otac);
                request.setFlow(ProcessFlowType.verifymsisdn);

                log.debug("Making call to service.");
                VerifyOtacResponseType response = port.verifyOtac(request);
                if (response._isSetFault())
                {
                    log.debug("Verify otac response has fault.");
                    FaultType fault = response.getFault();
                    if (null == fault)
                    {
                        RuntimeServiceException error = new RuntimeServiceException(this.getClass(), "verifyOtac", null);
                        log.error("Fault is null", error);
                        throw error;
                    }
                    //TODO check for otac expired - is this a valid exception?


                    String faultCode = response.getFault().getFaultcode();
                    if (OTAC_TRIES_EXCEEDED.equalsIgnoreCase( faultCode ))
                    {
                        throw new FinanceServiceOtacTriesExceededException(fault.getFaultcode(), fault.getFaultstring(),
                                fault.getDetail());
                    } else
                    {
                    	RuntimeServiceException error = new RuntimeServiceException(this.getClass(), "verifyOtac", null);
                        log.error( error.getMessage(), error );
                        throw error;
                    }
                } else
                {
                    isVerified = response.getValid();
                }
            }
        } catch (IOException e)
        {
            log.error( e.getMessage(), e );
        	throw new RuntimeServiceException(this.getClass(), "verifyOtac" , e);
        }
        log.info("verifyOtac.ends.");
        return isVerified;
    }





    /**
     * Call Orange registration service to get detail for a user based on username
     * @param userRequest GetUserDetailsRequestType object contacting username
     * @return
     */
    public GetUserDetailsResponseType getUserDetails(GetUserDetailsRequestType userRequest) throws UserNotFoundException
    {

        log.info( "getUsername start." );
        GetUserDetailsResponseType userDetails;
        String registrationServiceEndPoint = PropertyManager.getApplicationProperties().getRegistrationServiceEndPoint();
        String registrationDomain = PropertyManager.getApplicationProperties().getRegistrationDomain();
        RegistrationServiceStub stub;
        try
        {
            log.debug( "Create stub." );
            stub = new RegistrationServiceStub(registrationServiceEndPoint);
            userRequest.setDomain(registrationDomain);

            log.debug( "Send request." );
            userDetails = stub.getUserDetails(userRequest);


        } catch (AxisFault axisFault)
        {
        	axisFault.printStackTrace();

            if ( "1021".equalsIgnoreCase(  axisFault.getFaultCode().getLocalPart() ) )
            {
                throw new UserNotFoundException("User not found.", axisFault );
            } else
            {

                RuntimeServiceException error = new RuntimeServiceException(this.getClass(),"getUsername", axisFault);
                log.error( error.getMessage(), error );
                throw error;
            }



        } catch (RemoteException re)
        {

        	RuntimeServiceException error = new RuntimeServiceException(this.getClass(),"getUsername", re);
            log.error( error.getMessage(), error );
            throw error;
        }

        log.info( "getUsername ends." );
        return userDetails;
    }
}
