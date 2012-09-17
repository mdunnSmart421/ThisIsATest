package com.o2.finance.spring.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.o2.finance.beans.AddressBean;
import com.o2.finance.beans.DateOfBirthBean;
import com.o2.finance.beans.EditableUserDetailFlags;
import com.o2.finance.beans.GenderBean;
import com.o2.finance.beans.ProductBean;
import com.o2.finance.beans.StageBean;
import com.o2.finance.beans.StoredUserDetailsBean;
import com.o2.finance.beans.UpdateUserDetailsForm;
import com.o2.finance.etc.FinanceConstants;
import com.o2.finance.etc.RequestParameterConstants;
import com.o2.finance.facade.FinanceFacade;
import com.o2.finance.model.FinanceLocalModel;
import com.o2.finance.model.UserTO;
import com.o2.finance.properties.PropertyManager;
import com.o2.finance.util.CookieUtils;
import com.o2.finance.util.MsisdnConverter;
import com.o2.finance.util.StringFunctions;

/**
 * Web controller to handle requests to update existing user details.
 * 
 * @author SWatson
 * 
 */
public class UpdateUserDetailsController extends SimpleFormController implements FinanceConstants, RequestParameterConstants
{
    private FinanceFacade facade;
    private FinanceLocalModel localModel;
    private String confirmUserDetailsView;
    private String updateUserDetailsView;
    private String addressLookupView;
    private String initialView;
    private String pafCallbackActivatedByFindAddress;
    private String pafCallbackActivatedByContinue;    
    private String saveUserUpdatesView;


	Logger log = LogManager.getLogger( this.getClass() );

    public UpdateUserDetailsController()
    {
        super();
    }

    /**
     * @param facade
     * @param localModel
     * @param confirmUserDetailsView
     * @param updateUserDetailsView
     * @param addressLookupView
     * @param loopBackView
     */
    public UpdateUserDetailsController(FinanceFacade facade, FinanceLocalModel localModel, String confirmUserDetailsView,
            String updateUserDetailsView, String addressLookupView)
    {
        this( facade, localModel, confirmUserDetailsView, updateUserDetailsView, addressLookupView, null, null, null, null );
    }
    
    /**
     * 
     * @param facade
     * @param localModel
     * @param confirmUserDetailsView
     * @param updateUserDetailsView
     * @param addressLookupView
     * @param initialView
     * @param pafCallback
     * @param saveUserUpdatesView
     */
    public UpdateUserDetailsController( FinanceFacade facade,
			FinanceLocalModel localModel, String confirmUserDetailsView,
			String updateUserDetailsView, String addressLookupView,
			String initialView, String pafCallbackActivatedByFindAddress, String pafCallbackActivatedByContinue , String saveUserUpdatesView )
    {
    	super();
        log.info( "UpdateUserDetailsController start." );
        
		this.facade                  			= facade;
		this.localModel              			= localModel;
		this.confirmUserDetailsView  			= confirmUserDetailsView;
		this.updateUserDetailsView   			= updateUserDetailsView;
		this.addressLookupView       			= addressLookupView;
		this.initialView             			= initialView;
		this.pafCallbackActivatedByFindAddress  = pafCallbackActivatedByFindAddress;
		this.pafCallbackActivatedByContinue     = pafCallbackActivatedByContinue;
		this.saveUserUpdatesView                = saveUserUpdatesView;
		
		log.info( "UpdateUserDetailsController ends." );
	}
    
    /**
     * This overridden onBind method gets called after the form values are bound
     * to the command object and just before the validator is invoked. This 
     * method give us the ability to do custom binding on the command object 
     */
    protected void onBind ( HttpServletRequest request, Object command )
    {
    	log.info( "onBind start." );
    	
    	UpdateUserDetailsForm form = ( UpdateUserDetailsForm ) command;
    	
    	/*
    	 * set a flag to indicate to the validator whether to validate
    	 * all fields or only PAF specific fields
    	 */
    	if( isContinueConfirm( request ) )
        {
            // Continue button on confirm details page was activated.
            form.setActivatedButton( CONTINUE_CONFIRM );
        }
        else if ( isFindAddress( request ) )
        {
            // Find address button on update form pressed
        	form.setActivatedButton( PAF_LOOKUP_BUTTON );        	
        }
        else
        {
        	// continue button was clicked on the update details page 
        	form.setActivatedButton( CONTINUE_UPDATE );
        }
    	
    	log.info( "onBind end." );
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.web.servlet.mvc.AbstractFormController#formBackingObject(javax.servlet.http.HttpServletRequest)
     */
    protected Object formBackingObject(HttpServletRequest request) throws Exception
    {
        log.info( "formBackingObject start." );

        UserTO user;

        // If the request contains the productid, there is a 'returnurl' parameter and the user is logged in,
        // then the user has reached this page from the Wavecrest app (aka interstitial flow) (assuming it is a get, not a post).
        String userIdCookie    = PropertyManager.getApplicationProperties().getPaaAuthUserIdCookie();
        String authTokenCookie = PropertyManager.getApplicationProperties().getPaaAuthTokenCookie();
        String userId          = CookieUtils.getCookieValue( userIdCookie, request );
        String authToken       = CookieUtils.getCookieValue( authTokenCookie, request );

        if ( ( ! isFormSubmission( request ) ) && ( facade.isUserLoggedIn( userId, authToken, false )) && (isInterstitialFlow( request ) ) )
        {
            // This is a return to edit the user details from outside the normal program flow.

            // Determine product being applied for
            String productId = request.getParameter( PRODUCT_ID );
            localModel.setProduct( ProductBean.getProduct( productId, request.getSession( true ) ) );


            // Determine where to send the user after the update.
            localModel.setReturnUrl( request.getParameter( RETURN_URL ) );

            // Force a paf lookup on form submission
            localModel.setPafUpdated( false );


            // This is a valid entry point into the app so set initialised flag so user not dumped out of flow.
            localModel.setJourneyInitialised( true );


            // Get hold of user details
            String userName = facade.getUsernameFromId( userId, authToken );
            user = facade.getUserByUsername( userName );

            // Put the user onto the session.
            localModel.setUser( user );

        } else
        {
            user = getUser(request);
        }

        UpdateUserDetailsForm form = new UpdateUserDetailsForm();
        if (user != null)
        {
            form = populateUserDetailsForm( request, user );
        }

        log.info( "formBackingObject ends." );

        return form;
    }



    /*
    * (non-Javadoc)
    *
    * @see org.springframework.web.servlet.mvc.SimpleFormController#onSubmit(javax.servlet.http.HttpServletRequest,
    * javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.validation.BindException)
    */
    protected ModelAndView onSubmit( HttpServletRequest request, HttpServletResponse response, Object command, BindException errors )
            throws Exception
    {
        log.info( "onSubmit start." );
        
        log.info("MSISDN = "+localModel.getOriginalMsisdn()+ " "+localModel.getMsisdn());
        
        String orig = localModel.getOriginalMsisdn();
        String msisdn = localModel.getMsisdn();

        ModelAndView mav;
        if (localModel.isJourneyInitialised())
        {
            if (errors != null && errors.hasErrors())
            {
                /*
                 * Validation errors exist so return to the data entry form to display the validation messages.
                 */
                mav = showForm( request, response, errors );
            } 
            else
            {
                /*
                 * Load user from session or if a username is provided as a query parameter in the request then load request the user
                 * record from the back-end server.
                 */
                UserTO user = getUser( request );

                UpdateUserDetailsForm form = (UpdateUserDetailsForm) command;


                if ( isFindAddress( request ) )
                {
                    //  Find address button hit

                    log.info( "isFindAddress: " + isFindAddress( request ) );
                    log.info( "localModel " + localModel.isPafUpdated() );


                    /*
                    * Apply any updates from the form submission to the in-session user object.
                    */
                    applyUserDetailUpdates( form, user, true );


                    /*
                    * The 'Find Address' link was requested so forward to the PAF Address Lookup handler, providing the address look
                    * up details in the request as query parameters.
                    */
                    Map model = PafLookupController.getSimpleModelForPafAddress( form.getAddress() );
                    model.put( REQUEST_ATTR_NAME_CALLBACK, pafCallbackActivatedByFindAddress );
                    
                    mav = new ModelAndView( addressLookupView, model );

                } 
                else if ( isEdit( request ) )
                {
                    /*
                     * The 'Edit' details link was activated from the detail confirmation view.
                     *
                     * Here we set the 'Paf Validated' flag to false and navigate to the the update details form.
                     */
                    localModel.setPafUpdated( false );
                    mav = showForm( request, response, errors );

                } 
                else if ( isContinueUpdate( request ) &&  !localModel.isPafUpdated() )
                {
                	/*
                	 * User has clicked CONTINUE on update details page, but PAF confirmation has been done.
                	 * Take the user to PAF confirm page.
                	 */
                	applyUserDetailUpdates( form, user, false );
                	localModel.setUser( user );
                	
                	Map model = PafLookupController.getSimpleModelForPafAddress( form.getAddress() );
                    model.put( REQUEST_ATTR_NAME_CALLBACK, pafCallbackActivatedByContinue );
                    model.put( REQUEST_ATTR_NAME_FORWARD_TO, saveUserUpdatesView );
                    mav = new ModelAndView( addressLookupView, model );
                }                
                else if ( isContinueUpdate( request ) &&  localModel.isPafUpdated() )  
                {                    
                	/*
                	 * User has clicked CONTINUE on update details page, AND PAF confirmation has also been done.
                	 * Save the details to the DB
                	 */
                	applyUserDetailUpdates( form, user, false );
                    localModel.setUser( user );                    
                    mav = new ModelAndView( saveUserUpdatesView );

                } 
                else
                {
                    /*
                     * Everything should now be OK, HAND OFF to BOA/WaveCrest
                     */

                    StageBean.getStage( request.getSession( true ) ).setStageToComplete();
                    mav = new ModelAndView( getSuccessView() );
                }
            }
        } else
        {

            log.info( "Invalid flow access." );
            mav = new ModelAndView( getInvalidFlowView() );
            localModel.clear();


        }
        log.info( "onSubmit ends." );
        return mav;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.web.servlet.mvc.SimpleFormController#showForm(javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse, org.springframework.validation.BindException)
     */
    protected ModelAndView showForm(HttpServletRequest request, HttpServletResponse response, BindException errors)
            throws Exception
    {
        log.info( "showForm start." );

        // set default view
        String view = updateUserDetailsView;        
        
        /*
        * Are we here because a new user has just been created and silently logged in?
        * 
        * Or, are we deciding which page to load, update details or confirm? if PAFUpdated flag is set, then its confirm page. 
        * 
        * Or, are we here because the "continue" button has been activated on the UpdateDetails page?
        * 
        */
        if (localModel.isLegacyChecksPassed() || ( ( localModel.isNewAccount()         		 
                || ( ! hasErrors( errors ) && localModel.isPafUpdated() ) 
                || ( ! hasErrors( errors ) && localModel.isPafUpdated() && isContinueUpdate( request ) )
              )                
        	  && !returnFromPAFViaFindAddress( request )))
        {
            view = confirmUserDetailsView;

            /*
            * If its a new account, Reset the  new account flag
            */
            localModel.setNewAccount( false );
            localModel.setLegacyChecksPassed(false);
        }


        if ( confirmUserDetailsView.equalsIgnoreCase( view ) )
        {
            StageBean.getStage(request.getSession(true)).setStageToComplete();
        }
        else
        {
            StageBean.getStage(request.getSession(true)).setStageToCheck();
        }

        log.info( "showForm ends." );
        return showForm(request, errors, view, getModel(request));
    }




    private UpdateUserDetailsForm populateUserDetailsForm( HttpServletRequest request, UserTO user )
    {
        log.info( "populateUserDetailsForm start." );

        UpdateUserDetailsForm form = new UpdateUserDetailsForm();
        log.info( "Populating formBean from user." );
        log.debug( "The user is forename : " + user.getForename() +  "  Lastname : " +user.getLastname());
        String houseNumber;
        String houseName;
        String line1;
        String line2;
        String townOrCity;
        String county;
        String postcode = null;
        String country;

        AddressBean address = PafLookupController.extractPafAddress( request );
        if (address == null)
        {
            /*
             * Here a PAF validated address has not been provided so add the existing user address for display.
             */
            log.info( "PAF validated address not found - using existing user address." );

            houseNumber = user.getHouseNumber();
            houseName = user.getHouseName();
            line1 = user.getAddressLine1();
            line2 = user.getAddressLine2();
            townOrCity = user.getTownCity();
            county = user.getCounty();
            postcode = user.getPostcode();
            country = user.getCountry();
            address = new AddressBean(houseNumber, houseName, line1, line2, townOrCity, county, postcode, country);
        }

        log.info( "Setting address on form:" + address.toString());
        form.setAddress(address);

        GenderBean gender = new GenderBean(user.getGender(), user.getGenderText());
        form.setGender(gender);

        
        int day = user.getBirthDay();
        int month = user.getBirthMonth();
        int year = user.getBirthYear();
        
        DateOfBirthBean dob;
        
        if(year==0)
        {
        	dob = null;
        }
        else
        {
        	dob = new DateOfBirthBean(day, month, year);
        }
        
        
        form.setDateOfBirth(dob);
        form.setTitle(user.getTitle());
        form.setForename(user.getForename());
        form.setLastName(user.getLastname());
        form.setAlternativeEmail(user.getAlternativeEmail());
        form.setMobileNumber( MsisdnConverter.msisdnToNational( user.getMsisdn() ));
        form.setMobileMake(user.getPhoneMake());
        form.setNewAccount(localModel.isNewAccount());

        /*
    * Provide the select lists for 'Titles' and 'Months'
    */
        form.setTitles(USER_DETAILS_FIELD_TITLES);
        form.setMonths(USER_DETAILS_FIELD_BIRTH_MONTHS);
        form.setMobileMakes(USER_DETAILS_FIELD_MOBILE_MAKES);

        log.info( "populateUserDetailsForm ends." );
        return form;

    }



    private boolean hasErrors( BindException errors )
    {

        return (errors != null) && errors.hasErrors();
//        return !(errors == null || !errors.hasErrors());
    }

    private Map getModel(HttpServletRequest request)
    {
        log.info( "getModel start." );
        /*
         * Collects supplementary data used to render the user details entry view.
         */
        Map model = new HashMap();
        UserTO user = getUser(request);
        model.put( "storedUserDetails", applyStoredUserDetails( localModel, user, localModel.isPafUpdated() ) );
        if (localModel.isPostPay())
        {
            model.put("editable", applyPostPayEditable(user));
            model.put("postPayDivClass", "showOverflow");
        } else
        {
            model.put("editable", applyNonPostPayEditable());
            model.put("postPayDivClass", "w77");
        }

        log.info( "getModel ends." );
        return model;

    }

    private StoredUserDetailsBean applyStoredUserDetails(FinanceLocalModel model, UserTO user, boolean pafUpdated)
    {
        log.info( "applyStoredUserDetails start." );

        /*
         * Collect together all data stored at the back-end that is not subject to change in the update user details form.
         */
        String storedMsisdn = null;
        String productName = null;
        String productId = null;
        String existingUsername = null;
        
        if (model != null && user!=null )
        {
            storedMsisdn = user.getMsisdn();
            existingUsername = user.getId();

            if (!StringFunctions.isEmpty(existingUsername))
            {
                existingUsername = StringFunctions.acceptValidCharacters(existingUsername, DISALLOWED_XSS_CHARACTERS);
            }

            if (!StringFunctions.isEmpty(storedMsisdn))
            {
                storedMsisdn = StringFunctions.acceptValidCharacters(MsisdnConverter.msisdnToNational(storedMsisdn),
                        DISALLOWED_XSS_CHARACTERS);
            }

            ProductBean product = model.getProduct();
            if (product != null)
            {
                productName = model.getProduct().getProductTitle();
                if (!StringFunctions.isEmpty(productName))
                {
                    productName = StringEscapeUtils.escapeHtml(productName);
                }
                productId = model.getProduct().getProductId();
            }
        }

        log.info( "applyStoredUserDetails ends." );
        return new StoredUserDetailsBean(storedMsisdn, productName, productId, existingUsername);
    }

    /**
     * @return the localModel
     */
    public FinanceLocalModel getLocalModel()
    {
        return localModel;
    }

    /**
     * @param localModel
     *            the localModel to set
     */
    public void setLocalModel(FinanceLocalModel localModel)
    {
        this.localModel = localModel;
    }

    /**
     * @return the pafUpdatedView
     */
    public String getConfirmUserDetailsView()
    {
        return confirmUserDetailsView;
    }

    /**
     * @param pafUpdatedView
     *            the pafUpdatedView to set
     */
    public void setConfirmUserDetailsView(String confirmUserDetailsView)
    {
        this.confirmUserDetailsView = confirmUserDetailsView;
    }

    /**
     * @return the pafNotUpdatedView
     */
    public String getUpdateUserDetailsView()
    {
        return updateUserDetailsView;
    }

    /**
     * @param pafNotUpdatedView
     *            the pafNotUpdatedView to set
     */
    public void setUpdateUserDetailsView(String updateUserDetailsView)
    {
        this.updateUserDetailsView = updateUserDetailsView;
    }

    /**
     * @return the facade
     */
    public FinanceFacade getFacade()
    {
        return facade;
    }

    /**
     * @param facade
     *            the facade to set
     */
    public void setFacade(FinanceFacade facade)
    {
        this.facade = facade;
    }

    /**
     * @return the addressLookup
     */
    public String getAddressLookupView()
    {
        return addressLookupView;
    }

    /**
     * @param addressLookup
     *            the addressLookup to set
     */
    public void setAddressLookupView(String addressLookupView)
    {
        this.addressLookupView = addressLookupView;
    }

    // True if the find address button has been pressed on the update form
    private boolean isFindAddress(HttpServletRequest request)
    {
        String findAddress = (String) request.getParameter( FIND_ADDRESS );
        return findAddress != null && findAddress.trim().length() > 0;
    }


    // True if the continue button was pressed on the Update details page
    private boolean isContinueUpdate(HttpServletRequest request)
    {
        String continueUpdate = (String) request.getParameter( CONTINUE_UPDATE );
        return continueUpdate != null && continueUpdate.trim().length() > 0;
    }



    // True if continue button has been pressed on update page
    private boolean isContinueConfirm(HttpServletRequest request)
    {
        String continueConfirm = (String) request.getParameter( CONTINUE_CONFIRM );
        return continueConfirm != null && continueConfirm.trim().length() > 0;
    }


    // True if the edit button was pressed on the Confirm details page.
    private boolean isEdit(HttpServletRequest request)
    {
        String edit = request.getParameter(EDIT );
        return edit != null && edit.trim().length() > 0;
    }

    private EditableUserDetailFlags applyPostPayEditable(UserTO user)
    {
        /*
         * If the account is 'post pay' then only the gender is editable if not already provided.
         */
        EditableUserDetailFlags editable = new EditableUserDetailFlags();
        if (UserTO.GENDER_UNKNOWN_TEXT.equalsIgnoreCase(user.getGenderText()))
        {
            editable.setGender(true);
        }
        return editable;
    }

    private EditableUserDetailFlags applyNonPostPayEditable()
    {
        /*
         * If the account is not 'post pay' then set all relevent items as editable.
         */
        return new EditableUserDetailFlags(true, true, true, true);
    }

    private UserTO getUser(HttpServletRequest request)
    {
        log.info( "getUser start." );

        /*
         * Get the existing user object from the in-session model, if not available and a username is provided as a request query
         * parameter then try to obtain a user from the back-end service.
         */
        UserTO user = localModel.getUser();
        if (user == null)
        {
            String userId = (String) request.getParameter("userid");
            if (userId != null && userId.trim().length() > 0)
            {
                user = facade.getUserByUsername(userId);
                if (user != null)
                {
                    localModel.setUser(user);
                }
            }
        }

        log.info( "getUser ends." );
        return user;
    }
    
    /**
     * 
     * @param form
     * @param user
     * @param isFindAddress
     */
    private void applyUserDetailUpdates(UpdateUserDetailsForm form, UserTO user, boolean isFindAddress)
    {
        log.info( "applyUserDetailUpdates start." );
        /*
         * Apply collected form data to the in-session user object.
         */
        GenderBean gender = form.getGender();
        user.setGender(gender.getGender());
        DateOfBirthBean dob = form.getDateOfBirth();
        String day = dob.getBirthDay();
        String month = dob.getBirthMonth();
        String year = dob.getBirthYear();
        if (day != null && day.trim().matches(DateOfBirthBean.DIGIT_ONLY_PATTERN) && month != null
                && month.trim().matches(DateOfBirthBean.DIGIT_ONLY_PATTERN) && year != null
                && year.trim().matches(DateOfBirthBean.DIGIT_ONLY_PATTERN))
        {
            user.setDateOfBirth(Integer.parseInt(day.trim()), Integer.parseInt(month.trim()), Integer.parseInt(year.trim()));
        }
        
        /*
         * don't update the address details if we are about to do a PAF lookup.
         */
        if ( !isFindAddress )
        {
        	AddressBean address = form.getAddress();
            user.setAddressLine1(address.getAddressLine1());
            user.setAddressLine2(address.getAddressLine2());
            user.setHouseName(address.getHouseName());
            user.setHouseNumber(address.getHouseNumber());
            user.setTownCity(address.getTownOrCity());
            user.setPostcode(address.getPostcode());
        }
        
        user.setTitle(form.getTitle());
        user.setForename( form.getForename() );
        user.setLastname( form.getLastName() );
        user.setAlternativeEmail( form.getAlternativeEmail() );
        user.setPhoneMake( form.getMobileMake() );
        user.setMsisdn(MsisdnConverter.msisdnToInternational(form.getMobileNumber()));
        log.info( "applyUserDetailUpdates ends." );
    }

    public String getInvalidFlowView()
    {
        return initialView;
    }

    public void setInvalidFlowView( String initialView )
    {
        this.initialView = initialView;
    }
    


    private boolean isInterstitialFlow(HttpServletRequest request)
    {

        // If there is a productid and a return url on the request then this is a return visit from
        // outside the flow.
        boolean isProductId = ( null != request.getParameter( PRODUCT_ID ) ) &&
                ( ! "".equalsIgnoreCase( request.getParameter( PRODUCT_ID ) ));

        boolean isReturnUrl = ( null != request.getParameter( RETURN_URL )) &&
                ( ! "".equalsIgnoreCase( request.getParameter( RETURN_URL ) ) );


        return (isProductId && isReturnUrl);


    }
    
    /**
     * 
     * Check if we are back from a PAF confirm, and whether that PAF confirm was
     * triggered by clicking the "FIND ADDRESS" button.
     * 
     * @param request
     * @return
     */
    private boolean returnFromPAFViaFindAddress( HttpServletRequest request )
    {
    	boolean yesNo = false;
    	
    	String activatedBy = ( String ) request.getParameter( REQUEST_ATTR_PAF_ACTIVATED_BY_BUTTON  );
    	
    	if ( activatedBy != null && activatedBy.equals( ACTIVATED_BY_FIND_ADDRESS_BUTTON ) )
    	{
    		yesNo = true;
    	}
    	
    	return yesNo;
    }

	public void setSaveUserUpdatesView(String saveUserUpdatesView) {
		this.saveUserUpdatesView = saveUserUpdatesView;
	}

	public String getSaveUserUpdatesView() {
		return saveUserUpdatesView;
	}

	public String getPafCallbackActivatedByFindAddress() {
		return pafCallbackActivatedByFindAddress;
	}

	public void setPafCallbackActivatedByFindAddress(
			String pafCallbackActivatedByFindAddress) {
		this.pafCallbackActivatedByFindAddress = pafCallbackActivatedByFindAddress;
	}

	public String getPafCallbackActivatedByContinue() {
		return pafCallbackActivatedByContinue;
	}

	public void setPafCallbackActivatedByContinue(
			String pafCallbackActivatedByContinue) {
		this.pafCallbackActivatedByContinue = pafCallbackActivatedByContinue;
	}
	

}
