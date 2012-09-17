package com.o2.finance.spring.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

import com.o2.finance.beans.StageBean;
import com.o2.finance.etc.RequestParameterConstants;
import com.o2.finance.exception.FinanceException;
import com.o2.finance.facade.FinanceFacade;
import com.o2.finance.model.FinanceLocalModel;
import com.o2.finance.model.UserTO;
import com.o2.finance.properties.PropertyManager;
import com.o2.finance.properties.ValidationRegexProperties;
import com.o2.finance.util.CookieUtils;


/**
 * This will check if data passes legacy data validation and route to the appropriate place.
 * @author mdunn
 *
 */
public class LegacyDataValidationController extends SecurityCheckController
		implements RequestParameterConstants {

	private static final String TEMP_POSTCODE = "XX55 5XX";

	Logger log = LogManager.getLogger( this.getClass() );

	private static ValidationRegexProperties regexProperties =  PropertyManager.getValidatorRegexProperties();
	
	private String errorView;
	private String updateDetailsView;
	
	private String chooseAccountView;
	private String handoffView;
	
	
	public String getChooseAccountView() {
		return chooseAccountView;
	}

	public void setChooseAccountView(String chooseAccountView) {
		this.chooseAccountView = chooseAccountView;
	}

	public String getHandoffView() {
		return handoffView;
	}

	public void setHandoffView(String handoffView) {
		this.handoffView = handoffView;
	}

	public LegacyDataValidationController()
	{
		super();
	}
	
	public LegacyDataValidationController(FinanceLocalModel localModel,            
            String successView,
            String updateDetailsView, FinanceFacade facade )
	{
		setSuccessView( successView );
        this.localModel = localModel;
        this.setFacade(facade);
        this.updateDetailsView = updateDetailsView;
	}
	
	
	public LegacyDataValidationController(FinanceLocalModel localModel,            
            String successView,
            String chooseAccountView,
            String updateDetailsView,
            String handoffView,
            FinanceFacade facade )
	{
		
        this.localModel = localModel;
        this.setFacade(facade);
        setSuccessView( successView );
        this.chooseAccountView = chooseAccountView;        
        this.updateDetailsView = updateDetailsView;
        this.handoffView = handoffView;
        
	}
	
	
	
	
	public ModelAndView handleRequest( HttpServletRequest request, HttpServletResponse response )
            throws Exception
    {
        log.info( "handleRequest start." );
        Map model = request.getParameterMap();        
        ModelAndView mav = null;
        
         
        
		//if(localModel.isLoggedIn())
        if (localModel.isJourneyInitialised())
        {

	        if (checkForLoginAndLoadUser( request ) )
	        {
		        
				//UserTO user = getUser(request);		
		        //localModel.setUser(user);
	        	UserTO user = localModel.getUser();
	        	
	        	
				log.info("logged in");        	        
		        log.info("Original msisdn =  "+localModel.getOriginalMsisdn());	        
		        log.info("msisdn = "+localModel.getMsisdn());	        
		        
		      	        
		        
		        if(!localModel.getOriginalMsisdn().equals(localModel.getMsisdn()))
		        {
		        	log.info("We need to update the datbase with the new msisdn");
		        	updateDatabaseWithNewMpn(user);
		        }
		        
		        //TODO what is the real check to know if they have a wavecrestlogin.
                // DS - we shouldn't care about the product here as it should be taken care of in the handOff controller (have renamed view accordingly)

                // DS  nullcheck?
		        if(facade.hasMsisdnGotProduct(user.getMsisdn(),localModel.getProduct().getProductId()))
				 {
					 //user has product so redirect straight to handoff.
					 mav = new ModelAndView( getHandoffView(), model );
					 log.info("CheckLegacyData passed checks and redirect to handoff");
				 }
		        else
		        {
		            //no product we need to check the user data is ok.
		        	mav  = checkLegacyData(model,false,request,user);
		        }
		        
		        
	        }
	        else
	        {
	        	log.info("Not logged in send to choose account page"+localModel.getOriginalMsisdn());
	        	mav = new ModelAndView(getChooseAccountView(), model );
	        }
        } 
        else
        {
            log.info( "Invalid flow access." );
            mav = new ModelAndView( getInvalidFlowView() );           
        }
        log.info( "handleRequest ends." );

		return mav;
	
    }
	
	
	 /**
	  * Checks if legacy data is correct if not blank them and sends them to the edit details page otherwise
	  * will return it to the confirm page.
	  * @param model
	  * @param passedLegacyDataCheck
	  * @param request
	  * @param user
	  * @return
	  * @throws FinanceException
	  */
	 private ModelAndView checkLegacyData(Map model, boolean passedLegacyDataCheck,HttpServletRequest request,UserTO user) throws FinanceException {
		// TODO Auto-generated method stub
		 ModelAndView mav = null;
		 log.info("CheckLegacyData entered");
		 
		 boolean editUser = false;
		 //determine if we need to edit user.
		 if(localModel!=null)
		 {
			
			 if(!localModel.isBypassLegacyCheck())
			 {			 
				 
				 if(user!=null)
				 {
					 
					 //DOB VALIDATION STUFF				 
					 log.info("DOB DAY " + user.getBirthDay() + " MONTH " + user.getBirthMonth() + " YEAR " + user.getBirthYear()); 
					 int dayPart = user.getBirthDay();
				     int monthPart = user.getBirthMonth();
				     int yearPart = user.getBirthYear();
				 
				     
		     	     
				     try
				     {
	                	 
	                	 Calendar calendar = GregorianCalendar.getInstance();
	   				     calendar.setLenient( false );
	   	                 calendar.set(yearPart, monthPart - 1, dayPart);

					     Date date = calendar.getTime();
					     
				 
					     
					     
					     //Additional check to make sure date is not more than configurable number of years in the past            
				         Date legacyYearsInPastConfiguableDate = new Date();	     		        		        
				         legacyYearsInPastConfiguableDate.setYear(legacyYearsInPastConfiguableDate.getYear() - regexProperties.getLegacyYearsInPast());	        	        
				         if (date.before(legacyYearsInPastConfiguableDate)) 
				         {
				           log.info("Legacy Check shows Date of birth is more than " + regexProperties.getLegacyYearsInPast() + " years in the past");
				           editUser = true;
				           user.setBirthYear(0);
				         }
					        			        				 				 
						 log.info("title ="+localModel.getUser().getTitle());
						 if(user.getTitle()==null)
						 {
							 log.info("Legacy Check shows title is null");
							 
							 editUser = true;
						 }	
						 
						 
						 if(!validPostcode(user) )
						 {
							 //postcode needs to be updated to something valid.
							 editUser = true;
						 }
							
						 if(TEMP_POSTCODE.equals(user.getPostcode())){
							 //postcode needs to be updated to something valid.
							 editUser = true;
						 }
						 
					 
				 	} catch(IllegalArgumentException ex) {
				 		   editUser = true;
				           user.setBirthYear(0);
				           log.info("DOB is Zero so we user will have to update it to a correct value.");
				 	}
			 	}
			 }		 
		 }
		 
		 
		 if(editUser )
		 {
			 //we need to update the user details.
			 StageBean.getStage(request.getSession(true)).setStageToCheck();
			 localModel.setLegacyChecksPassed(false);
			 mav = new ModelAndView( getUpdateDetailsView(), model );
			 log.info("CheckLegacyData passed checks and redirect to confirm/edit details.");
			 
		 }
		 else
		 {
			//success route go straight to confirm page;
			 StageBean.getStage( request.getSession( true ) ).setStageToComplete();
			 localModel.setLegacyChecksPassed(true);
			 mav = new ModelAndView(getSuccessView(), model );
			 log.info("CheckLegacyData failed checks need to reset them to blank for user to re-enter them.");
		 }
		
		 log.info("CheckLegacyData finished");
		 return mav;
	}


	
    private UserTO getUser(HttpServletRequest request) throws FinanceException
    {
        log.info( "getUser start." );
        
        
        String userIdCookie    = PropertyManager.getApplicationProperties().getPaaAuthUserIdCookie();
        String authTokenCookie = PropertyManager.getApplicationProperties().getPaaAuthTokenCookie();
        String userId          = CookieUtils.getCookieValue( userIdCookie, request );
        String authToken       = CookieUtils.getCookieValue( authTokenCookie, request );
        
  
        /*
         * Get the existing user object from the in-session model, if not available and a username is provided as a request query
         * parameter then try to obtain a user from the back-end service.
         */
        UserTO user = localModel.getUser();
        if (user == null)
        {
            String userIdRequest = (String) request.getParameter("userid");
            if (userIdRequest != null && userIdRequest.trim().length() > 0)
            {
                user = facade.getUserByUsername(userIdRequest);
                if (user != null)
                {
                    localModel.setUser(user);
                }
            }
            else
            {
            	   // Get hold of user details
                String userName = facade.getUsernameFromId( userId, authToken );
                user = facade.getUserByUsername( userName );
            }
        }

        log.info( "getUser ends." );
        return user;
    }
	

	public void setUpdateDetailsView(String updateDetailsView) {
		this.updateDetailsView = updateDetailsView;
	}

	
	/**
	 * 
	 * @param user
	 */
	private void updateDatabaseWithNewMpn(UserTO user) {			
		
			log.info("entered updateDatabaseWithNewMpn:");		
			user.setMsisdn(localModel.getMsisdn());

        // DS - can this conversion go into the user bean setPostcode method?
log.info("Postode ='"+user.getPostcode()+"'");

			if(validPostcode(user))
			{

				log.info("POSTCODE IS VALID");
				String postCodeStart = user.getPostcode().substring(0, user.getPostcode().length()-3).toUpperCase();
				String postCodeEnd = user.getPostcode().substring(user.getPostcode().length()-3).toUpperCase();
				//TODO Postcode needs to be validated.
				user.setPostcode(postCodeStart+" "+postCodeEnd);

			}
			else
			{
				log.info("We need to populate postcode with something or there will be a error.");
				user.setPostcode(TEMP_POSTCODE);
			}
			
			
			facade.updateUser(user);
			log.info("finished updateDatabaseWithNewMpn:");
	    	log.info("updateDatabaseWithNewMpn entered.......This will update the DB with new mobilephone number.");
			
		}

	private boolean validPostcode(UserTO user) {
		boolean valid = false;		
		//(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(user.getPostcode()).matches("[A-Z]{1,2}[0-9R][0-9A-Z]? [0-9][A-Z-[CIKMOV]]{2}")) 
		//same regex check that is used in PostcodeType
		if(!"".equals(user.getPostcode()) && null != user.getPostcode() && user.getPostcode().length()>=6)
		{
			log.info("Postcode is invalid for USER "+user.getId()+" msisdn="+user.getMsisdn()+" This will be reset in DB.");
			valid = true;
		}
		else
		{
			valid = false;
		}
		return valid;
	
	}
	
	/**
     * @param localModel the localModel to set
     */
    public void setLocalModel( FinanceLocalModel localModel )
    {
        this.localModel = localModel;
    }

    /**
     * @param facade the facade to set
     */
    public void setFacade( FinanceFacade facade )
    {
        this.facade = facade;
    }
    
    /**
     * @param errorView the errorView to set
     */
    public void setErrorView( String errorView )
    {
        this.errorView = errorView;
    }

    
    
	private String getUpdateDetailsView() {
		
		log.info("entered getUpdateDetailsView:");
		return updateDetailsView;
	}
}
