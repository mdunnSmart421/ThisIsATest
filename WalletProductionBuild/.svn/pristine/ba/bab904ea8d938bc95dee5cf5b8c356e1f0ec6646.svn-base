package com.o2.finance.service;

import com.o2.finance.exception.AddressNotFoundException;
import com.o2.finance.exception.FinanceException;
import com.o2.finance.util.TestSetup;
import com.o2.registration.phase2.ejb.paf.PafVO;
import com.o2.smart421.ws.paf.model.AddressType;
import junit.framework.TestCase;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Purpose: com.o2.finance.service User: D Smith Date: 16/06/2011
 */
public class PafServiceImplTest extends TestCase
{
    Logger log = LogManager.getLogger(this.getClass());

    public void setUp() throws Exception
    {
        TestSetup.initialiseLog4j();
    }

//    public void testFindAddress() throws Exception
//    {
//        PafService service = new PafServiceImpl();
//        ArrayList addresses = (ArrayList) service.findAddress(null, null, null);
//        for (int i = 0; i < addresses.size(); i++)
//        {
//            log.debug(((AddressType) addresses.get(i)).toString());
//        }
//    }

    public void testAddressDoesNotExist() throws Exception
    {
        PafService service = new PafServiceImpl();

        try
        {
            service.findAddress( null, null, "IP1 1XX" );
        }
        catch (AddressNotFoundException e)
        {
            assertTrue( "Expecting addressNotFoundException.", true );
        }


    }
}
