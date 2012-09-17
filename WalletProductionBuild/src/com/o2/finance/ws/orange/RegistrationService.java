/**
 * RegistrationService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:35 LKT)
 */
package com.o2.finance.ws.orange;

/*
 *  RegistrationService java interface
 */
public interface RegistrationService
{
    /**
     * Auto generated method signature
     * 
     * @param suggestUserNameRequest
     */
    public uk.co.o2.registration.registration.registrationtypes.SuggestUserNameResponse suggestUserName(
            uk.co.o2.registration.registration.registrationtypes.SuggestUserNameRequest suggestUserNameRequest)
            throws java.rmi.RemoteException;

    /**
     * Auto generated method signature
     * 
     * @param setPasswordT7RequestType
     */
    public void setPasswordT7(
            uk.co.o2.registration.registration.registrationtypes.SetPasswordT7RequestType setPasswordT7RequestType)
            throws java.rmi.RemoteException;

    /**
     * Auto generated method signature
     * 
     * @param setPasswordT4RequestType
     */
    public void setPasswordT4(
            uk.co.o2.registration.registration.registrationtypes.SetPasswordT4RequestType setPasswordT4RequestType)
            throws java.rmi.RemoteException;

    /**
     * Auto generated method signature
     * 
     * @param setPasswordT1RequestType
     */
    public void setPasswordT1(
            uk.co.o2.registration.registration.registrationtypes.SetPasswordT1RequestType setPasswordT1RequestType)
            throws java.rmi.RemoteException;

    /**
     * Auto generated method signature
     * 
     * @param setPasswordT2RequestType
     */
    public void setPasswordT2(
            uk.co.o2.registration.registration.registrationtypes.SetPasswordT2RequestType setPasswordT2RequestType)
            throws java.rmi.RemoteException;

    /**
     * Auto generated method signature
     * 
     * @param searchByMsisdnRequestType
     */
    public uk.co.o2.registration.registration.registrationtypes.SearchByMsisdnResponseType searchByMsisdn(
            uk.co.o2.registration.registration.registrationtypes.SearchByMsisdnRequestType searchByMsisdnRequestType)
            throws java.rmi.RemoteException;

    /**
     * Auto generated method signature
     * 
     * @param createUserRequest
     */
    public uk.co.o2.registration.registration.registrationtypes.CreateUserResponse createUser(
            uk.co.o2.registration.registration.registrationtypes.CreateUserRequest createUserRequest)
            throws java.rmi.RemoteException;

    /**
     * Auto generated method signature
     * 
     * @param getUserDetailsRequestType
     */
    public uk.co.o2.registration.registration.registrationtypes.GetUserDetailsResponseType getUserDetails(
            uk.co.o2.registration.registration.registrationtypes.GetUserDetailsRequestType getUserDetailsRequestType)
            throws java.rmi.RemoteException;

    /**
     * Auto generated method signature
     * 
     * @param createOrUpdateRoleSetRequestType
     */
    public uk.co.o2.registration.registration.registrationtypes.CreateOrUpdateRoleSetResponseType createOrUpdateRoleSet(
            uk.co.o2.registration.registration.registrationtypes.CreateOrUpdateRoleSetRequestType createOrUpdateRoleSetRequestType)
            throws java.rmi.RemoteException;

    /**
     * Auto generated method signature
     * 
     * @param getPhoneUsersRequestType
     */
    public uk.co.o2.registration.registration.registrationtypes.GetPhoneUsersResponseType getPhoneUsers(
            uk.co.o2.registration.registration.registrationtypes.GetPhoneUsersRequestType getPhoneUsersRequestType)
            throws java.rmi.RemoteException;

    /**
     * Auto generated method signature
     * 
     * @param getAccountChoosersRequestType
     */
    public uk.co.o2.registration.registration.registrationtypes.GetAccountChoosersResponseType getAccountChoosers(
            uk.co.o2.registration.registration.registrationtypes.GetAccountChoosersRequestType getAccountChoosersRequestType)
            throws java.rmi.RemoteException;

    /**
     * Auto generated method signature
     * 
     * @param publishMsisdnRequestType
     */
    public void publishMsisdn(
            uk.co.o2.registration.registration.registrationtypes.PublishMsisdnRequestType publishMsisdnRequestType)
            throws java.rmi.RemoteException;

    /**
     * Auto generated method signature
     * 
     * @param setPasswordT5RequestType
     */
    public void setPasswordT5(
            uk.co.o2.registration.registration.registrationtypes.SetPasswordT5RequestType setPasswordT5RequestType)
            throws java.rmi.RemoteException;

    /**
     * Auto generated method signature
     * 
     * @param getSuperChooserRequestType
     */
    public uk.co.o2.registration.registration.registrationtypes.GetSuperChooserResponseType getSuperChooser(
            uk.co.o2.registration.registration.registrationtypes.GetSuperChooserRequestType getSuperChooserRequestType)
            throws java.rmi.RemoteException;

    /**
     * Auto generated method signature
     * 
     * @param validateMSISDNVerificationCodeRequestType
     */
    public uk.co.o2.registration.registration.registrationtypes.ValidateMSISDNVerificationCodeResponseType validateMSISDNVerificationCode(
            uk.co.o2.registration.registration.registrationtypes.ValidateMSISDNVerificationCodeRequestType validateMSISDNVerificationCodeRequestType)
            throws java.rmi.RemoteException;

    /**
     * Auto generated method signature
     * 
     * @param getRolesForCustomerRequestType
     */
    public uk.co.o2.registration.registration.registrationtypes.GetRolesForCustomerResponseType getRolesForCustomer(
            uk.co.o2.registration.registration.registrationtypes.GetRolesForCustomerRequestType getRolesForCustomerRequestType)
            throws java.rmi.RemoteException;

    /**
     * Auto generated method signature
     * 
     * @param setPasswordT6RequestType
     */
    public void setPasswordT6(
            uk.co.o2.registration.registration.registrationtypes.SetPasswordT6RequestType setPasswordT6RequestType)
            throws java.rmi.RemoteException;

    /**
     * Auto generated method signature
     * 
     * @param getSearchCountRequestType
     */
    public uk.co.o2.registration.registration.registrationtypes.GetSearchCountResponseType getSearchCount(
            uk.co.o2.registration.registration.registrationtypes.GetSearchCountRequestType getSearchCountRequestType)
            throws java.rmi.RemoteException;

    /**
     * Auto generated method signature
     * 
     * @param searchRequestType
     */
    public uk.co.o2.registration.registration.registrationtypes.SearchResponseType search(
            uk.co.o2.registration.registration.registrationtypes.SearchRequestType searchRequestType)
            throws java.rmi.RemoteException;

    /**
     * Auto generated method signature
     * 
     * @param searchForMsisdnRequestType
     */
    public uk.co.o2.registration.registration.registrationtypes.SearchForMsisdnResponseType searchForMsisdn(
            uk.co.o2.registration.registration.registrationtypes.SearchForMsisdnRequestType searchForMsisdnRequestType)
            throws java.rmi.RemoteException;

    /**
     * Auto generated method signature
     * 
     * @param createOrUpdateMsisdnProfileRequestType
     */
    public uk.co.o2.registration.registration.registrationtypes.CreateOrUpdateMsisdnProfileResponseType createOrUpdateMsisdnProfile(
            uk.co.o2.registration.registration.registrationtypes.CreateOrUpdateMsisdnProfileRequestType createOrUpdateMsisdnProfileRequestType)
            throws java.rmi.RemoteException;

    /**
     * Auto generated method signature
     * 
     * @param setPasswordT3RequestType
     */
    public void setPasswordT3(
            uk.co.o2.registration.registration.registrationtypes.SetPasswordT3RequestType setPasswordT3RequestType)
            throws java.rmi.RemoteException;
    //
}
