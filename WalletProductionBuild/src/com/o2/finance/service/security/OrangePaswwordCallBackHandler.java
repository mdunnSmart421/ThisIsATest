package com.o2.finance.service.security;

import org.apache.ws.security.WSPasswordCallback;

import com.o2.finance.properties.ApplicationProperties;
import com.o2.finance.properties.PropertyManager;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: dave
 * Date: 26/02/2012
 * Time: 15:12
 * To change this template use File | Settings | File Templates.
 */
public class OrangePaswwordCallBackHandler implements CallbackHandler {
			
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
    	ApplicationProperties props = PropertyManager.getApplicationProperties();
    	for (int i = 0; i < callbacks.length; i++) {
            //When the server side need to authenticate the user
            WSPasswordCallback pwcb = (WSPasswordCallback) callbacks[i];
            //When the client requests for the password to be added in to the UT element                        
            //pwcb.setPassword("Pa55word_1");
            pwcb.setPassword(props.getOrangeSearchServiceWsSecurityPassword());                        
        }
    }
}
