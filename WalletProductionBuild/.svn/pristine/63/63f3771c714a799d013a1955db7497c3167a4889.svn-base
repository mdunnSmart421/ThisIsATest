package com.o2.finance.spring.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import com.o2.finance.beans.ChooseAccountForm;
import com.o2.finance.etc.RequestParameterConstants;
import com.o2.finance.exception.SearchServiceIdentitiesExceededException;
import com.o2.finance.facade.FinanceFacade;
import com.o2.finance.model.FeedbackTO;
import com.o2.finance.model.FinanceLocalModel;
import com.o2.finance.model.UserTO;
import com.o2.finance.properties.PropertyManager;
import com.o2.finance.util.MsisdnConverter;

/**
 * Web controller to handle account selection for those user how have multiple accounts.
 * 
 * @author SWatson
 * 
 */
public class ChooseAccountController 
extends SimpleFormController
implements RequestParameterConstants
{
    private static final Logger log = LogManager.getLogger( ChooseAccountController.class );
    
    private FinanceLocalModel localModel;
    private FinanceFacade     facade;
    private String            newAccountView;
    private String  initialView;

    public ChooseAccountController()
    {
        super();
    }

    /**
     * @param localModel
     * @param facade
     */
    public ChooseAccountController(FinanceLocalModel localModel, 
                                   FinanceFacade     facade, 
                                   String            formView, 
                                   String            successView,
                                   String            newAccountView)
    {
        super();

        log.info( "ChooseAccountController start." );

        setFormView(formView);
        setSuccessView(successView);
        this.localModel     = localModel;
        this.facade         = facade;
        this.newAccountView = newAccountView;

        log.info( "ChooseAccountController ends." );
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.web.servlet.mvc.SimpleFormController#onSubmit(java.lang.Object)
     */
    protected ModelAndView onSubmit(Object command) 
    throws Exception
    {
        log.info( "onSubmit start." );

        ModelAndView      mav;
        ChooseAccountForm form        = (ChooseAccountForm) command;
        UserTO            currentUser = localModel.getUser();
        String            selectedId  = form.getAccount();

        if (  localModel.isJourneyInitialised() )
        {


            if (currentUser != null &&
                    currentUser.getId() != null &&
                    currentUser.getId().equals( selectedId ) &&
                    localModel.isLoggedIn())
            {
                /*
                 * Selected account matches that held in session so forward to the success view.
                 */
            	log.debug("Keep account : " + selectedId.trim());
                mav = new ModelAndView( getSuccessView() );
            } else if (selectedId != null && selectedId.trim().length() > 0)
            {
                /*
                 * A different account from the session held account has been selected so change the session held account and direct
                 * the user to the O2 login page.
                 *
                 * The URL should contain the callback reference being the success view.
                 *
                 * N.B. It appears from dev. testing that the O2 login page at www.o2.co.uk/login only excepts a ?sendTo= parameter
                 * set to the www.o2.co.uk domain, anything else appears to redirect to www.o2.co.uk/login?sendTo=http://www.o2.co.uk
                 *
                 * It also seems that adding the username parameter USERNAME= (or username=) does not pre-populate the username field
                 * in the login form. So the form only seems to initialise with blank details which must be filled in by the user.
                 */
            	log.debug("Account changed, new account is : " + selectedId.trim());
                localModel.setLoggedIn( false );
                localModel.setToLoginAs( selectedId.trim() );

                String o2LoginPageUrl = PropertyManager.getApplicationProperties().getO2LoginPageUrl();
                mav = new ModelAndView( new RedirectView( o2LoginPageUrl, false ) );
            } else
            {
                /*
                 * No account was selected so represent the form view.
                 */
                mav = new ModelAndView( getFormView() );
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
    protected ModelAndView showForm(HttpServletRequest  request, 
                                    HttpServletResponse response, 
                                    BindException       errors)
            throws Exception
    {
        log.info( "showForm start." );

        ModelAndView mav      = null;
        String       msisdn   = localModel.getMsisdn();

        if ( localModel.isJourneyInitialised() )
        {
            UserTO user = localModel.getUser();
            if(user == null)
            {
                user = new UserTO();
                localModel.setUser(user);
            }
            user.setMsisdn(MsisdnConverter.msisdnToInternational(msisdn));
                        
            try {
                Map accounts = facade.getUsersByMsisdn(msisdn);
                                    
	            if(accounts.size() == 0)
	            {
	                mav = new ModelAndView(newAccountView);
	            }
	            else if(accounts.size() == 1 && ( null != user.getId()  ) && accounts.containsKey(user.getId()) && localModel.isLoggedIn()   )
	            {
	        	localModel.setPafUpdated(true);
	        	mav = new ModelAndView(getSuccessView());
	            }
	            else if(accounts.size() > 0)
	            {
	            	//get the list of portalids to set in the forms account field
	                List              listing = new ArrayList(accounts.keySet());
	                //get the list of FriendlyUsernameLabelBeans for the screen display
	                Collection<com.o2.finance.beans.FriendlyUsernameLabelBean> myColl = accounts.values();
	        		List<com.o2.finance.beans.FriendlyUsernameLabelBean> friendlyUsernameLabelBeanList
	        		  = new ArrayList<com.o2.finance.beans.FriendlyUsernameLabelBean>(myColl);
	                                
	                ChooseAccountForm form    = new ChooseAccountForm();
	                form.setMsisdn(MsisdnConverter.msisdnToNational(msisdn));
	                form.setAccounts(friendlyUsernameLabelBeanList);
	
	                if(user != null && user.getId() != null && user.getId().trim().length() > 0)
	                  form.setAccount(user.getId());
	                else
	                  form.setAccount((String)listing.get(0));
	
	                Map model = new HashMap();
	                model.put(getCommandName(), form);
	                mav = new ModelAndView(getFormView(), model);
	            }
            }
            catch(SearchServiceIdentitiesExceededException ssiee) {
                /*
                 * The back-end server has indicated that the identities limit has been exceeded and
                 * therefore we need to send a message to the view layer for display.
                 *
                 * Here we create a FeedbackTO and place it in the request to be picked up by the view layer to display an error
                 * message, and we navigate back to the data entry view.
                 *
                 * As this is a simple forward request returns back to the existing view we can add the FeedbackTO to the model
                 * for rendition by the view handler. 
                 * 
                 * Everything else should be the same, apart from the fact that as no user records have been returned, we need
                 * to make sure a default account is populated with value (N/A) in order to maintain existing functionality in case the 02Login
                 * screen wants to use a account friendly username to populate the username textbox. 
                 * TODO - In reality all the (selectedId) functionality should be removed as O2 no longer care about passing
                 * the portalid/friendly username to the O2 Login screens. This would simplify this class considerably.
                 * 
                 */
              log.info("Show a nice message in the front screen");	
              //Pass the msisdn and a default account and empty accountsList back to the choose account screen
              //anyway to maintain existing functionality.
              ChooseAccountForm form    = new ChooseAccountForm();
              form.setMsisdn(MsisdnConverter.msisdnToNational(msisdn));
              form.setAccounts(new ArrayList());
              if(user != null && user.getId() != null && user.getId().trim().length() > 0) {
                  form.setAccount(user.getId());
              }
              else {
                  form.setAccount("N/A");
              }              
              Map model = new HashMap();
              model.put(getCommandName(), form);
              //Send back an additional feedback error message to the choose account screen                            
              String limitExceededMessage = PropertyManager.getFeedbackProps().getSearchServiceIdentityLimitExceededMessage();              
              FeedbackTO feedback = new FeedbackTO( FeedbackTO.VALIDATION_ERROR, limitExceededMessage);
              model.put(FEEDBACK_REQUEST_KEY, feedback);                                          
              mav = new ModelAndView(getFormView(), model);                                                        
            }                                        
        } else
        {
            log.info( "Invalid flow access." );
            mav = new ModelAndView( getInvalidFlowView() );
            localModel.clear();
        }

        log.info( "showForm ends." );       
        return mav;
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
     * @param facade
     *            the facade to set
     */
    public void setFacade(FinanceFacade facade)
    {
        this.facade = facade;
    }

    /**
     * @param newAccountView the newAccountView to set
     */
    public void setNewAccountView(String newAccountView)
    {
        this.newAccountView = newAccountView;
    }

    public String getInvalidFlowView()
    {
        return initialView;
    }

    public void setInvalidFlowView( String initialView )
    {
        this.initialView = initialView;
    }
}
