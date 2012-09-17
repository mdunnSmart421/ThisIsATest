package com.o2.finance.spring.controller;

import com.o2.finance.beans.LoginForm;
import com.o2.finance.etc.RequestParameterConstants;
import com.o2.finance.exception.FinanceException;
import com.o2.finance.model.FinanceLocalModel;
import com.o2.finance.model.UserTO;
import com.o2.finance.properties.ApplicationProperties;
import com.o2.finance.properties.PropertyManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;






/**
 * Purpose:
 * com.o2.finance.spring.controller
 * User: D Smith
 * Date: 29/10/2011
 */
public class LoginController extends SimpleFormController implements RequestParameterConstants
{
    private FinanceLocalModel localModel;

    Logger log = LogManager.getLogger( this.getClass() );

    //TODO - needs retry logic
    //TODO needs validator

    protected Object formBackingObject( HttpServletRequest request ) throws Exception
    {
        log.info( "formBackingObject start." );

        ApplicationProperties appProps = PropertyManager.getApplicationProperties();

        LoginForm form = new LoginForm();

        if (null == localModel)
        {
            // Session timeout??
            throw new FinanceException( "Model is null." );
        }

//        UserTO user = localModel.getUser();
//
//        if (null == user)
//        {
//            throw new FinanceException( "User is null." );
//        }


        String userId = localModel.getToLoginAs();
        if (null == userId || "".equalsIgnoreCase( userId ))
        {
            //Try and get userid form request params
            userId = request.getParameter( "id" );
        }


        form.setUsername( userId );

        form.setLoginURL( appProps.getNewUserPostLoginUrl() );

        // get the O2LoginPageUrl. It will be of the format -
        // https://bluedawn.ref.o2.co.uk/login?sendTo=http://dave.o2.co.uk:8080/finance/accountChangeLoginCheck.do
        // We need the sendTo URL in the above value. This will be our return value
        // or
        // if you are using in-memory facade the O2LoginPageUrl value is
        // http://localhost:8080/finance/mocklogin.do?skipreset=true
        // In this case, do nothing        
        String rURL = appProps.getO2LoginPageUrl();
        if ( rURL.indexOf( "mocklogin.do" ) == -1 )
        {
        	rURL = rURL.substring( ( rURL ).indexOf( "sendTo" ) + 7 );
        } 
        
        form.setReturnURL( rURL );
        form.setFailureURL( rURL );


        log.info( "formBackingObject ends." );

        return form;
    }


    public FinanceLocalModel getLocalModel()
    {
        return localModel;
    }

    public void setLocalModel( FinanceLocalModel localModel )
    {
        this.localModel = localModel;
    }
}
