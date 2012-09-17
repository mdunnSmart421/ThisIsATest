package com.o2.finance.spring.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.o2.finance.beans.AddressBean;
import com.o2.finance.beans.EnterUserDetailsForm;
import com.o2.finance.beans.StoredUserDetailsBean;
import com.o2.finance.etc.FinanceConstants;
import com.o2.finance.etc.RequestParameterConstants;
import com.o2.finance.exception.MaxSecondaryAccsExceededException;
import com.o2.finance.exception.MsisdnBarredException;
import com.o2.finance.exception.UserNameAlreadyExistsException;
import com.o2.finance.exception.UsernameExistsInReservedUsernameTableException;
import com.o2.finance.facade.FinanceFacade;
import com.o2.finance.model.FeedbackTO;
import com.o2.finance.model.FinanceLocalModel;
import com.o2.finance.model.UserTO;
import com.o2.finance.properties.PropertyManager;
import com.o2.finance.util.MsisdnConverter;

/**
 * Purpose: Captures the user details entered via the enterUserDetails.jsp and calls the Orange Service to create a new user in
 * Orange. If a user is successfully created, he is forwarded to the updateUserDetails.jsp page for confirmation.
 * com.o2.finance.spring.controller User: D Smith Date: 20/05/2011
 */
public class EnterUserDetailsController extends SimpleFormController implements FinanceConstants, RequestParameterConstants
{

    private FinanceLocalModel localModel;
    private FinanceFacade     facade;
    private String            addressLookupView;
    private String            pafCallback;
    private String            initialView;
    private String 		      silentLoginView;
    private Logger            log = LogManager.getLogger( this.getClass() );
    
   /**
    * This overridden onBind method gets called after the form values are bound
    * to the command object and just before the validator is invoked. This 
    * method give us the ability to do custom binding on the command object 
    */
    protected void onBind ( HttpServletRequest request, Object command )
    {
    	log.info( "onBind start." );
    	
    	EnterUserDetailsForm form = ( EnterUserDetailsForm ) command;
    	
    	/*
    	 * set a flag to indicate to the validator whether to validate
    	 * all fields or only PAF specific fields
    	 */
    	if ( doPAFLookUp( request ) )
        {
            form.setActivatedButton( PAF_LOOKUP_BUTTON );

        } else
        {
            form.setActivatedButton( CONTINUE_BUTTON );
        }
    	
    	log.info( "onBind end." );
    }


    /**
     *
     */
    protected ModelAndView onSubmit( HttpServletRequest request, HttpServletResponse response, Object command, BindException errors )
            throws Exception
    {


        log.info( "EnterUserDetailsController onSubmit start." );

        ModelAndView mav          = null;
        UserTO user               = null;
        EnterUserDetailsForm form = (EnterUserDetailsForm) command;
        FeedbackTO feedBack       = null;
        String fbMessage          = null;


        if (localModel.isJourneyInitialised())
        {
            if (errors != null && errors.hasErrors())
            {
                /*
                * Validation errors exist so return to the data entry form to display the validation messages.
                */
                mav = showForm( request, response, errors );

            } else
            {
                // "find address" clicked. go to PAFConfim page.
                // OR, the user has click the "submit " button,
                // but the PAF confirmation is yet to be completed.
                // Before we proceed to create a user, the user MUST
                // have confirmed his address using the PAFConfirm page
                if ( doPAFLookUp( request )  || !localModel.isPafUpdated())
                {
                    // store the form in session before going to PAFConfirm page.
                    // we will need to read this back on return
                    addFormToSession( request, form );
                    Map model = PafLookupController.getSimpleModelForPafAddress( form.getAddress() );
                    model.put( REQUEST_ATTR_NAME_CALLBACK, pafCallback );
                    mav = new ModelAndView( addressLookupView, model );
                } else
                {
                    // create new user in Orange
                    try
                    {
                        UserTO userFromForm = createuserTO( form );

                        // Add pos business unit.
                        userFromForm.setPosBusinessUnit( localModel.getProduct().getProductPosBusinessUnit() );
                        userFromForm.setMsisdnValid("Yes");

                        user = facade.createUser( userFromForm );
                        
                        /*
                         * The password is required to be set in the USERTO to do Silent-Login. The password
                         * is not returned as part of the USERTO thats returned after a user is successfully
                         * created. So, use the password thats available on the form.
                         */
                        user.setPassword(form.getPassword());
                        
                        // update localModel with user just created
                        localModel.setUser( user );
                        localModel.setNewAccount( true );
                        localModel.setMsisdnVerified(true);
                    }
                    catch (MsisdnBarredException me)
                    {
                        log.error( "[EnterUserDetailsController.onSubmit]Error creating user. " + "Reason - Msisdn Barred " );
                        fbMessage = PropertyManager.getFeedbackProps().getMsisdnBarredMessage();

                    }
                    catch (MaxSecondaryAccsExceededException me)
                    {
                        log.error( "[EnterUserDetailsController.onSubmit]Error creating user. "
                                + "Reason - Max Seconday Accounts Exceeded " );
                        fbMessage = PropertyManager.getFeedbackProps().getMaxSecondaryAccsReachedMessage();

                    }
                    catch (UserNameAlreadyExistsException me)
                    {
                    	 log.error( "[UserNameAlreadyExistsException.onSubmit]Error creating user. "
                                 + "Username already Exists " );
                        fbMessage = PropertyManager.getFeedbackProps().getUsernameExistsMessage();
                    }
					catch (UsernameExistsInReservedUsernameTableException ue)
					{
						 log.error( "[UsernameExistsInReservedUsernameTableException.onSubmit]Error creating user. "
                                 + "Username already Exists in reserved username table. " );
						 //Use the same error message as the Username Already exists.
						 fbMessage = PropertyManager.getFeedbackProps().getUsernameExistsMessage();
					}
                    
                    
                    
                    
                    if (fbMessage != null)
                    {
                        feedBack = new FeedbackTO( FeedbackTO.SERVER_ERROR, fbMessage );
                        Map model = new HashMap();
                        model.put( FEEDBACK_REQUEST_KEY, feedBack );
                        mav = showForm( request, response, errors, model );
                    }
                    if (mav == null)
                    {
                        // User successfully created. Forward to SilentLoginController
                    	mav = new ModelAndView( getSilentLoginView() );
                    }
                }

            }
        } else
        {
            log.info( "Invalid flow access." );
            mav = new ModelAndView( getInvalidFlowView() );
            localModel.clear();
        }


        log.info( "EnterUserDetailsController onSubmit ends.");
        log.debug("send to ======================================"+mav.toString() );
        return mav;
    }

    /**
     *
     */
    protected Object formBackingObject( HttpServletRequest request ) throws Exception
    {
        log.info( "formBackingObject start." );
        
        String   			 msisdn       = null;
        EnterUserDetailsForm form         = new EnterUserDetailsForm();
        
        /*
         * Check if the user is returning from the PAFConfirm page. If he is, and
         * a valid address is selected, then retrieve it and set it in the form. If,
         * however, the CANCEL button was pressed on the PAFConfirm page, then check if
         * the user has an already PAF confirmed address. If he has, then set that address
         * in the form.
         * 
         */
        if ( returnFromPAFConfirm( request )  )
        {
            log.debug( "Returned from PAF" );

        	form = getFormFromSession( request );
	
			// get the address selected on the PAFconfirm page
		    AddressBean address = PafLookupController.extractPafAddress( request );
		    
		    if ( address != null )
		    {

                form.setPafAddress( true );

		        /*
		         * A valid, PAF confirmed address has been selected. Set it in the form and
		         * also save another copy of that address as another property with in the form.
		         * The copy will be used in case the user does a another round of PAF look up, but
		         * with an invalid address.  
		         * 
		         */
                log.debug( "Address selected on PafConfirm page, setting address on form." );

		    	form.setAddress( address );

		        // store a copy of the PAF-updated address
                log.debug( "Setting copy of PAF-updated address." );
		        form.setCopyOfPAFConfirmedAddress( address );
		    }
		    else
		    {
		    	// CANCEL button was pressed on the PAFConfirm page.
		    	// If the user has a previously PAF-Confirmed address,
		    	// display that.
                log.debug( "PAF lookup was cancelled, using previously stored address." );

                AddressBean storedAddress = form.getcopyOfPAFConfirmedAddress();

                if ( ! storedAddress.equals( new AddressBean(  ) ))
                {
                    form.setPafAddress( true );
                }

		    	form.setAddress( form.getcopyOfPAFConfirmedAddress() );
		    }
        }
        else
        {
            log.debug( "Setting up form." );
        	form.setTitles( USER_DETAILS_FIELD_TITLES );
            form.setMobileMakes( USER_DETAILS_FIELD_MOBILE_MAKES );
            form.setMonths( USER_DETAILS_FIELD_BIRTH_MONTHS );
            form.setSecurityQuestions( USER_DETAILS_FIELD_SECURITY_QUESTIONS );
            if (localModel.getMsisdn() != null)
            {
                msisdn = localModel.getMsisdn();
            } else if (localModel.getUser() != null)
            {
                msisdn = localModel.getUser().getMsisdn();
                localModel.setMsisdn( msisdn );
            }
            StoredUserDetailsBean storedUser = form.getStoredUserDetailsBean();
            storedUser.setStoredMsisdn( msisdn );
            form.setStoredUserDetailsBean( storedUser );
        }

        log.info( "formBackingObject ends." );
        return form;
    }

    /**
     * @param localModel
     */
    public void setLocalModel( FinanceLocalModel localModel )
    {
        this.localModel = localModel;
    }

    /**
     * @return the facacde
     */
    public FinanceFacade getFacade()
    {
        return facade;
    }

    /**
     * @param financeFacade
     */
    public void setFacade( FinanceFacade facade )
    {
        this.facade = facade;
    }

    /**
     * Construct a userTO using the values from the Form
     *
     * @param form
     * @return
     */
    private UserTO createuserTO( EnterUserDetailsForm form )
    {
        log.info( "createuserTO start." );

        UserTO userTO = new UserTO();

        userTO.setTitle( form.getTitle() );
        userTO.setForename( form.getForename().trim() );
        userTO.setLastname( form.getLastName().trim() );
        userTO.setGender( form.getGender().getGender() );

        if (!"DD".equals( form.getDateOfBirth().getBirthDay() ) && !"YYYY".equals( form.getDateOfBirth().getBirthYear() ))
        {
            userTO.setDateOfBirth( Integer.parseInt( form.getDateOfBirth().getBirthDay() ),
                    Integer.parseInt( form.getDateOfBirth().getBirthMonth() ),
                    Integer.parseInt( form.getDateOfBirth().getBirthYear() ) );
        }

        userTO.setMsisdn( MsisdnConverter.msisdnToInternational( form.getStoredUserDetailsBean().getStoredMsisdn() ) );
        userTO.setPhoneMake( form.getMobileMake() );
        userTO.setAlternativeEmail( form.getAlternativeEmail() );
        userTO.setId( form.getUsername() );
        userTO.setPassword( form.getPassword() );
        userTO.setSecurityQuestion( form.getSecurityQuestion() );
        userTO.setSecurityAnswer( form.getSecurityAnswer() );
        userTO.setWantsO2Marketing( form.isWantsO2Marketing() );
        userTO.setWantsOtherMarketing( form.isWantsOtherMarketing() );
        userTO.setDomain( PropertyManager.getApplicationProperties().getRegistrationDomain() );

        AddressBean addressBean = form.getAddress();

        String houseNm = addressBean.getHouseName();
        if (houseNm != null && houseNm.trim().length() != 0)
        {
            userTO.setHouseName( houseNm.trim() );
        }
        String houseNo = addressBean.getHouseNumber();
        if (houseNo != null && houseNo.trim().length() != 0)
        {
            userTO.setHouseNumber( houseNo.trim() );
        }
        userTO.setPostcode( addressBean.getPostcode() );

        userTO.setAddressLine1( addressBean.getAddressLine1() );
        userTO.setAddressLine2( addressBean.getAddressLine2() );
        userTO.setTownCity( addressBean.getTownOrCity() );
        userTO.setCountry( addressBean.getCountry() );



        log.info( "[EnterUserDetailsController.createuserTO] userTO" + " created with following values - " + userTO.toString() );

        log.info( "createuserTO ends." );

        return userTO;
    }

    public String getAddressLookupView()
    {
        return addressLookupView;
    }

    public void setAddressLookupView( String addressLookupView )
    {
        this.addressLookupView = addressLookupView;
    }

    public String getPafCallback()
    {
        return pafCallback;
    }

    public void setPafCallback( String pafCallback )
    {
        this.pafCallback = pafCallback;
    }

    public String getInvalidFlowView()
    {
        return initialView;
    }

    public void setInvalidFlowView( String initialView )
    {
        this.initialView = initialView;
    }
    public String getSilentLoginView() {
		return silentLoginView;
	}

	public void setSilentLoginView(String silentLoginView) {
		this.silentLoginView = silentLoginView;
	}
    
    /**
     * 
     * @param request
     * @return
     */
    private boolean doPAFLookUp( HttpServletRequest request )
    {  	
    	boolean doPAF        = false;
    	String  findAddress  = (String) request.getParameter( "findAddress" );
    	
    	if ( findAddress != null && findAddress.trim().length() > 0 )
    	{
    		doPAF = true;
    	}
    	
    	return doPAF;
    }
    
    /**
     * 
     * @param form
     */
    private void addFormToSession( HttpServletRequest request, EnterUserDetailsForm form )
    {
    	request.getSession().setAttribute( ENTERUSERDETAILSFORM_SESSION_OBJ, form );
    }
    
    /**
     * 
     * @param request
     * @return
     */
    private EnterUserDetailsForm getFormFromSession( HttpServletRequest request )
    {
    	EnterUserDetailsForm form = (EnterUserDetailsForm) 
    								request.getSession().
    								getAttribute( ENTERUSERDETAILSFORM_SESSION_OBJ );

    	request.getSession().removeAttribute( ENTERUSERDETAILSFORM_SESSION_OBJ );
    	
    	return form;
    }
    
    /**
     * 
     * @param request
     * @return
     */
    private boolean returnFromPAFConfirm( HttpServletRequest request )
    {
    	boolean yesNo = false;    	
    	Object  obj   = request.getSession().
        				getAttribute( ENTERUSERDETAILSFORM_SESSION_OBJ );
    	
    	if ( obj != null && !doPAFLookUp (request) )
    	{
    		yesNo = true;
    	}
    	
    	return yesNo;
    }
   
}
