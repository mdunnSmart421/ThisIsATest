package com.o2.finance.spring.theme;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.theme.AbstractThemeResolver;

import com.o2.finance.model.FinanceLocalModel;
import com.o2.finance.util.MobileThemeSupportHelper;

/**
 * Purpose:
 * com.o2.finance.spring.theme
 * User: D Smith
 * Date: 25/08/2011
 */
public class MobileThemeResolver extends AbstractThemeResolver
{
	private static final Logger log = LogManager.getLogger( MobileThemeResolver.class );
	
	private FinanceLocalModel localModel;
	
	/**
	 * 
	 */
	public MobileThemeResolver()
	{
		this (null);
	}
	
	/**
	 * @param localModel
	 */
	public MobileThemeResolver( FinanceLocalModel localModel )
	{
		super();
		this.localModel = localModel;
	}
	
	/**
	 * 
	 */
//    public String resolveThemeName( HttpServletRequest request )
//    {
//    	log.info( "Theme to load : "+localModel.getTheme() );
//        return localModel.getTheme();
//    }
    
    public String resolveThemeName( HttpServletRequest request )
    {
     String theme = localModel.getTheme();
     
     // sometimes, the session is being reset. If thats the case, there won't be any value in localModel.themeName.
     // Check the cookies to see if we can determine the cookies from there.     
     if ( null == theme || "".equals( theme ) )
     {
      theme = MobileThemeSupportHelper.getThemeName( request );
     }
     
     log.info( "Theme to load : "+theme );
        
     return theme;
    }
    
    
    
    

    /**
     * 
     */
    public void setThemeName( HttpServletRequest request, HttpServletResponse response, String s )
    {
        throw new UnsupportedOperationException( "This method should not be used. The THEME will be resolved at runtime based on the device request parameter, which is done in *resolveThemeName()* " );
    }
    
    /**
     * 
     * @param localModel
     */
    public void setLocalModel( FinanceLocalModel localModel )
    {
        this.localModel = localModel;
    }
}
