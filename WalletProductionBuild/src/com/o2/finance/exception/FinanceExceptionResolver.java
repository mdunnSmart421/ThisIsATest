package com.o2.finance.exception;

import com.o2.finance.model.FinanceLocalModel;
import com.o2.finance.properties.CopyProperties;
import com.o2.finance.properties.PropertyManager;
import com.o2.finance.util.MobileThemeSupportHelper;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Purpose:
 * com.o2.finance.exception
 * User: D Smith
 * Date: 12/07/2011
 */
public class FinanceExceptionResolver implements HandlerExceptionResolver
{

    private static final String PORTAL_SHOULD_HAVE_MSISDN = "onlinecustomer-11220-3003-E";

	private static final String AUTHENTICATION_FAILED = "onlinecustomer-11220-3000-E";

	private static final Logger log = LogManager.getLogger( FinanceExceptionResolver.class );

    private String errorView;
    private String busyView;
    private String error2View;
    private String portalMSISDNView;
    private String authFailView;
    private String sessionTimedOut;
    
    
    public String getSessionTimedOut() {
		return sessionTimedOut;
	}

	public void setSessionTimedOut(String sessionTimedOut) {
		this.sessionTimedOut = sessionTimedOut;
	}

	public String getPortalMSISDNView() {
		return portalMSISDNView;
	}

	public void setPortalMSISDNView(String portalMSISDNView) {
		this.portalMSISDNView = portalMSISDNView;
	}

	public String getAuthFailView() {
		return authFailView;
	}

	public void setAuthFailView(String authFailView) {
		this.authFailView = authFailView;
	}

	public String getError2View() {
		return error2View;
	}

	public void setError2View(String error2View) {
		this.error2View = error2View;
	}

	private FinanceLocalModel localModel;

    public ModelAndView resolveException( HttpServletRequest request, HttpServletResponse response, Object o, Exception e )
    {
        log.error( e.getMessage(), e );
        String viewName = getErrorView();

        if (e instanceof FinanceServiceSLMBreachException)
        {
        	viewName = getBusyView();


            CopyProperties props = PropertyManager.getCopyProps();

            String headerText = props.getBusyHeaderText();
            String bodyText = props.getBusyBodyText();
            String returnUrl = props.getBusyReturnUrl();
            String buttonLabel = props.getBusyButtonLabel();


            request.setAttribute( "busyHeader", headerText );
            request.setAttribute( "busyBody", bodyText );
        	request.setAttribute( "backUrl", returnUrl );
            request.setAttribute( "backButtonValue", buttonLabel );
        }
        
        
        
        //Determine which authentication error it is and show the error page.
        if (e instanceof AuthenticationServiceException)
        {
        	viewName = getError2View();
        	AuthenticationServiceException auth = (AuthenticationServiceException)e;
        	auth.getErrorCode();
        	
        	 if(PORTAL_SHOULD_HAVE_MSISDN.equals(auth.getErrorCode()))
             {
          	   	//<Portal Account should be associated with a valid MSISDN>	
             		log.error("PORTAL_SHOULD_HAVE_MSISD");
         			log.error("PORTAL_SHOULD_HAVE_MSISD "+auth.getErrorCode());
         			
         			viewName = getPortalMSISDNView();
             }
             
          	if(AUTHENTICATION_FAILED.equals(auth.getErrorCode()))
          	{
          		//Authentication failed due to incorrect customerid or authtoken
          		log.error("AUTHENTICATION_FAILED");
          		log.error("AUTHENTICATION_FAILED "+auth.getErrorCode());
          		
          		viewName = getAuthFailView();
          		
          	}
         	//onlinecustomer-11220-3002-E
          	//Failed to retrieve user detail
        	
        }
        if(e instanceof SessionTimedOutException)
        {
//        	if(localModel!=null)
//        	{
//        		localModel.setJourneyInitialised(false);
//        	}
        	log.error("SESSION TIMED OUT REDIRECT TO session timed out page.");
        	viewName = getSessionTimedOut();
        }
        
        /*
         *  check which version of the error page we need to display - web or mobile
         */


        // If the session has timed out then the localModel will be null

        String themeName;
        if ( null != localModel )
        {
            themeName = MobileThemeSupportHelper.getThemeName( localModel );
        } else
        {
            themeName = MobileThemeSupportHelper.getThemeName( request );

        }




        viewName = MobileThemeSupportHelper.getViewName( viewName, themeName );


//        if ( MobileThemeSupportHelper.displayMobileView( localModel ) )
//        {
//        	viewName = MobileThemeSupportHelper.getMobileEquivalentView( viewName );
//        }
        
        return new ModelAndView( viewName );
    }

    public String getErrorView()
    {
        return errorView;
    }

    public void setErrorView( String errorView )
    {
        this.errorView = errorView;
    }


    public String getBusyView()
    {
        return busyView;
    }

    public void setBusyView( String busyView )
    {
        this.busyView = busyView;
    }

	public void setLocalModel(FinanceLocalModel localModel) {
		this.localModel = localModel;
	}

}
