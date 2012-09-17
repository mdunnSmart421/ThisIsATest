/**
 * 
 */
package com.o2.finance.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @author VKancherla
 * 
 */
public class EnterUserDetailsForm 
extends UpdateUserDetailsForm
{
    private String                confirmAlternativeEmail;
    private String                username;
    private String                password;
    private String                confirmPassword;
    private String                securityQuestion;
    private String                securityAnswer;
    private boolean               wantsO2Marketing;
    private boolean               wantsOtherMarketing;
    private List                  securityQuestions;
    private StoredUserDetailsBean storedUserDetailsBean;
    private AddressBean           copyOfPAFConfirmedAddress;

    private boolean PafAddress;
    

	public EnterUserDetailsForm()
    {
        super();
    }
	
	/**
	 * 
	 * @param title
	 * @param foreName
	 * @param lastName
	 * @param mobileNumber
	 * @param alternativeEmail
	 * @param confirmAlternativeEmail
	 * @param username
	 * @param password
	 * @param confirmPassword
	 * @param securityQuestion
	 * @param securityAnswer
	 * @param wantsO2Marketing
	 * @param wantsOtherMarketing
	 * @param securityQuestions
	 * @param gender
	 * @param address
	 * @param dateOfBirth
	 * @param storedUserDetailsBean
	 */
    public EnterUserDetailsForm( String title, String foreName, String lastName, String mobileNumber, String alternativeEmail,
                                 String confirmAlternativeEmail, String username, String password, String confirmPassword,
                                 String securityQuestion, String securityAnswer, boolean wantsO2Marketing, boolean wantsOtherMarketing,
                                 List securityQuestions, GenderBean gender, AddressBean address, DateOfBirthBean dateOfBirth,
                                 StoredUserDetailsBean storedUserDetailsBean)
    {
        super( title, foreName, lastName, mobileNumber, confirmAlternativeEmail, gender, address, dateOfBirth );
        this.confirmAlternativeEmail   = confirmAlternativeEmail;
        this.username                  = username;
        this.password                  = password;
        this.confirmPassword           = confirmPassword;
        this.securityQuestion          = securityQuestion;
        this.securityAnswer            = securityAnswer;
        this.wantsO2Marketing          = wantsO2Marketing;
        this.wantsOtherMarketing       = wantsOtherMarketing;
        this.securityQuestions         = securityQuestions;
        this.storedUserDetailsBean     = storedUserDetailsBean;
    }

    /**
     * 
     * @param title
     * @param foreName
     * @param lastName
     * @param mobileNumber
     * @param alternativeEmail
     * @param confirmAlternativeEmail
     * @param username
     * @param password
     * @param confirmPassword
     * @param securityQuestion
     * @param securityAnswer
     * @param wantsO2Marketing
     * @param wantsOtherMarketing
     * @param securityQuestions
     * @param gender
     * @param address
     * @param dateOfBirth
     * @param storedUserDetailsBean
     * @param copyOfPAFConfirmedAddress
     */
    public EnterUserDetailsForm( String title, String foreName, String lastName, String mobileNumber, String alternativeEmail,
                                 String confirmAlternativeEmail, String username, String password, String confirmPassword,
                                 String securityQuestion, String securityAnswer, boolean wantsO2Marketing, boolean wantsOtherMarketing,
                                 List securityQuestions, GenderBean gender, AddressBean address, DateOfBirthBean dateOfBirth,
                                 StoredUserDetailsBean storedUserDetailsBean, AddressBean copyOfPAFConfirmedAddress)
    {
       this( title, 
    		 foreName, 
    		 lastName, 
    		 mobileNumber, 
    		 alternativeEmail,
             confirmAlternativeEmail, 
             username, 
             password, 
             confirmPassword,
             securityQuestion, 
             securityAnswer, 
             wantsO2Marketing, 
             wantsOtherMarketing,
             securityQuestions, 
             gender, 
             address, 
             dateOfBirth,
             storedUserDetailsBean);
        this.copyOfPAFConfirmedAddress = copyOfPAFConfirmedAddress;
    }

    /**
     * @return
     */
    public String getConfirmAlternativeEmail()
    {
        return confirmAlternativeEmail != null ? confirmAlternativeEmail.trim() : "";
    }

    /**
     * 
     * @param confirmAlternativeEmail
     */
    public void setConfirmAlternativeEmail(String confirmAlternativeEmail)
    {
        this.confirmAlternativeEmail = confirmAlternativeEmail;
    }

    public String getUsername()
    {
        return username != null ? username.trim() : "";
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password != null ? password.trim() : "";
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getConfirmPassword()
    {
        return confirmPassword != null ? confirmPassword.trim() : "";
    }

    public void setConfirmPassword(String confirmPassword)
    {
        this.confirmPassword = confirmPassword;
    }

    public String getSecurityQuestion()
    {
        return securityQuestion != null ? securityQuestion.trim() : "";
    }

    public void setSecurityQuestion(String securityQuestion)
    {
        this.securityQuestion = securityQuestion;
    }

    public String getSecurityAnswer()
    {
        return securityAnswer != null ? securityAnswer.trim() : "";
    }

    public void setSecurityAnswer(String securityAnswer)
    {
        this.securityAnswer = securityAnswer;
    }

    public boolean isWantsO2Marketing()
    {
        return wantsO2Marketing;
    }

    public void setWantsO2Marketing(boolean wantsO2Marketing)
    {
        this.wantsO2Marketing = wantsO2Marketing;
    }

    public boolean isWantsOtherMarketing()
    {
        return wantsOtherMarketing;
    }

    public void setWantsOtherMarketing(boolean wantsOtherMarketing)
    {
        this.wantsOtherMarketing = wantsOtherMarketing;
    }

    public StoredUserDetailsBean getStoredUserDetailsBean()
    {
        return storedUserDetailsBean != null ? storedUserDetailsBean : new StoredUserDetailsBean();
    }

    public void setStoredUserDetailsBean(StoredUserDetailsBean storedUserDetailsBean)
    {
        this.storedUserDetailsBean = storedUserDetailsBean;
    }

    public void setSecurityQuestions(List securityQuestions)
    {
        this.securityQuestions = securityQuestions;
    }

    public List getSecurityQuestions()
    {
        return securityQuestions != null ? securityQuestions : new ArrayList();
    }
    
    public AddressBean getcopyOfPAFConfirmedAddress()
    {
    	if (copyOfPAFConfirmedAddress == null)
    	{
    		copyOfPAFConfirmedAddress = new AddressBean();
    	}
    	
        return copyOfPAFConfirmedAddress;
	}

	public void setCopyOfPAFConfirmedAddress(AddressBean copyOfPAFConfirmedAddress)
	{
		this.copyOfPAFConfirmedAddress = copyOfPAFConfirmedAddress;
	}
    public boolean isPafAddress()
    {
        return PafAddress;
    }

    public void setPafAddress( boolean pafAddress )
    {
        PafAddress = pafAddress;
    }


}



