package com.o2.finance.service;

import com.o2.finance.util.TestSetup;
import junit.framework.TestCase;

/**
 * Purpose:
 * com.o2.finance.service
 * User: D Smith
 * Date: 10/07/2011
 */
public class JaxRpcAuthenticationServiceImplTest extends TestCase
{

    public JaxRpcAuthenticationServiceImplTest()
    {
        TestSetup.initialiseLog4j();
    }

    public void testIsUserLoggedIn() throws Exception
    {
        JaxRpcAuthenticationSoaServiceImpl service = JaxRpcAuthenticationSoaServiceImpl.createJaxRpcAuthenticationSoaServiceImpl();

        service.isUserLoggedIn( "badger", "password" );



    }

    public void testGetUsername() throws Exception
    {

    }
}
