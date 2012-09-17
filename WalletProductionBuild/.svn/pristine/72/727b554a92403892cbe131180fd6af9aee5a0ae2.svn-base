package com.o2.finance.service;

import java.util.ArrayList;

import com.o2.finance.exception.UserNotFoundException;
import uk.co.o2.registration.registration.registrationtypes.GetUserDetailsRequestType;
import uk.co.o2.registration.registration.registrationtypes.GetUserDetailsResponseType;

import com.o2.finance.exception.FinanceServiceOtacTriesExceededException;
import com.o2.finance.exception.FinanceServiceVerificationCodeTriesExceededException;
import com.o2.finance.exception.MaxSecondaryAccsExceededException;
import com.o2.finance.exception.MsisdnBarredException;
import com.o2.finance.exception.UserNameAlreadyExistsException;
import com.o2.finance.exception.UsernameExistsInReservedUsernameTableException;
import com.o2.www.broadband.avatartypes.CreateUserRequestType;
import com.o2.www.broadband.avatartypes.CreateUserResponseType;
import com.o2.www.broadband.avatartypes.UpdateUserRequestType;
import com.o2.www.broadband.avatartypes.UpdateUserResponseType;
import com.o2.www.broadband.avatartypes.UsernameSuggestionsType;

/**
 * Purpose: com.o2.finance.service User: D Smith Date: 13/05/2011
 */
public interface OrangeService
{
    public UsernameSuggestionsType suggestUserName(String forename, String lastname);

    public UpdateUserResponseType updateUser(UpdateUserRequestType customer);

    public CreateUserResponseType createUser(CreateUserRequestType customer) throws MsisdnBarredException,
            MaxSecondaryAccsExceededException, UserNameAlreadyExistsException, UsernameExistsInReservedUsernameTableException;

    public GetUserDetailsResponseType getUserDetails(GetUserDetailsRequestType userRequest) throws UserNotFoundException;

    public ArrayList searchForUsersByMsisdn(String msisdn);

    public boolean isCustomerPostPay(int custId);

    public String generateOtac(String msisdn) throws FinanceServiceVerificationCodeTriesExceededException;

    public boolean verifyOtac(String msisdn, String otac) throws FinanceServiceOtacTriesExceededException;
}
