/**
 * 
 */
package com.o2.finance.spring.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.o2.finance.etc.RequestParameterConstants;
import com.o2.finance.exception.SessionTimedOutException;
import com.o2.finance.model.FinanceLocalModel;
/**
 * @author mdunn
 *
 */
public class SessionHandlerInterceptor implements HandlerInterceptor, RequestParameterConstants{

private static final Logger log = LogManager.getLogger( SessionHandlerInterceptor.class );
    

    private FinanceLocalModel localModel;

    private String timeoutMapping;
    private String errorView;

    public String getErrorView() {
		return errorView;
	}

	public void setErrorView(String errorView) {
		this.errorView = errorView;
	}

	public String getTimeoutMapping() {
		return timeoutMapping;
	}

	public void setTimeoutMapping(String timeoutMapping) {
		this.timeoutMapping = timeoutMapping;
	}

	public boolean preHandle( HttpServletRequest request, HttpServletResponse response, Object o ) throws Exception
    {
		long startTime = System.currentTimeMillis();
		request.setAttribute("startTime", startTime);
		
		String destUrl = request.getRequestURI();
		
		if(localModel!=null )
        {
			if(localModel.isJourneyInitialised())
			{
				log.info("Session has not expired " + localModel.isJourneyInitialised());
			}
			else
			{
				validSessionTimout(request, destUrl);
			}
        }
		else
		{
			validSessionTimout(request, destUrl);
		}
		 	 
		
		
		
		return true;
    }

	/**
	 * Checks if destination url is trying to restart registration process again. 
	 * If not then display session timeout error page again.
	 * @param request
	 * @param destUrl
	 * @throws SessionTimedOutException
	 */
	private void validSessionTimout(HttpServletRequest request, String destUrl)
			throws SessionTimedOutException {
		
		log.info("SESSION has Expired so redirect to sesssion timout page. " + localModel.isJourneyInitialised());
		log.info(request.getRequestURI());
		if(destUrl.indexOf("initiate.do")>0)
		{
			//going to the initiate page which is correct to start registration again.
		}
		else
		{
			throw new SessionTimedOutException();
			//return false;
		}
	}
	
    public void postHandle( HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView ) throws Exception
    {
//    	long startTime = (Long)request.getAttribute("startTime");
//    	 
//		long endTime = System.currentTimeMillis();
// 
//		long executeTime = endTime - startTime;
// 
//		//modified the exisitng modelAndView
//		modelAndView.addObject("executeTime",executeTime);
// 
//		SimpleFormController form = (SimpleFormController)o;
//		o.getClass().getName();
//		
//		//log it
//		if(log.isDebugEnabled()){
//		   log.debug(o.getClass().getName()+"[" + o + "] executeTime : " + executeTime + "ms");
//		}
//		 if(localModel!=null )
//        {
//			if(localModel.isJourneyInitialised())
//			{
//				log.info("Session has not expired " + localModel.isJourneyInitialised());
//			}
//			else
//			{
//				log.info("SESSION has Expired so redirect to sesssion timout page. " + localModel.isJourneyInitialised());
//			}
//        }
//		 else
//		 {
//			 log.info("SESSION has Expired so redirect to sesssion timout page.");
//			 
//		 }	 
		 
    }
	
    
    
    public FinanceLocalModel getLocalModel()
    {
        return localModel;
    }

    public void setLocalModel( FinanceLocalModel localModel )
    {
        this.localModel = localModel;
    }

	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	//turns /mypage.jsp into something like /myapp/mypage.jsp
	private String createRedirectUrl(HttpServletRequest request) {
		if (timeoutMapping.startsWith("/")) {
			return request.getContextPath() + timeoutMapping;
		} else {
			return timeoutMapping;
		}
	}
    
	/**
	 * if(localModel!=null )
        {
        	log.info("session still valid ='"+localModel.getMsisdn()+"' ='"+localModel.getOriginalMsisdn()+"' ='"+localModel.getUser()+"'");
        
        	log.info("journey has been initialised = "+localModel.isJourneyInitialised());
        	
        	if(!localModel.isJourneyInitialised()){
        		log.info("a. session EXPIRED ");
            	response.sendRedirect("/errors/sessionTimedOut.jsp"); 
            	return false;
        	}
        	else
        	{
        		log.info("session ok and still valid");
        	}  
        	
        }
        else
        {
        	//session timed out redirect.
        	log.info("b. session EXPIRED ");
        	response.sendRedirect("/errors/sessionTimedOut.jsp");  
        	return false;
        }
	 */
}
