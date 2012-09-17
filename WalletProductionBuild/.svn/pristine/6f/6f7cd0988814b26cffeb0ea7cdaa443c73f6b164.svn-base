package com.o2.finance.service;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import junit.framework.TestCase;

import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

import com.o2.finance.model.UserTO;
import com.o2.finance.service.UserTOAdapter;

/**
 * @author ccoe
 *
 */
public class UserTOAdapterTest extends TestCase
{

    /**
     * @param name
     */
    public UserTOAdapterTest(String name)
    {
	super(name);
    }

    /* (non-Javadoc)
     * @see junit.framework.TestCase#setUp()
     */
    protected void setUp() throws Exception
    {
	super.setUp();
    }

    /* (non-Javadoc)
     * @see junit.framework.TestCase#tearDown()
     */
    protected void tearDown() throws Exception
    {
	super.tearDown();
    }

    /**
     * Test method for {@link com.o2.finance.service.UserTOAdapter#UserTOAdapter()}.
     */
    public final void testUserTOAdapter()
    {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.o2.finance.service.UserTOAdapter#fromXML(java.lang.String)}.
     */
    public final void testFromXML()
    {
	String message = "<users><userDetails><user MSISDN=\"07110727956\" MSISDNvalid=\"Yes\" SecurityAnswer=\"asdfasdf\" " +
			"SecurityQuestion=\"Place of birth\" alternativeEmail=\"ccoe@smart421.com\" contactMedium=\"Email\" " +
			"custnum=\"11547384\" dateOfBirth=\"1970-01-01\" domain=\"stf.ref.o2.co.uk\" " +
			"dqlistingdetail=\"Ex-Directory\" dqlistinglevel=\"Not Opted\" forename=\"chris\" gender=\"M\" " +
			"hasBeenBillingContact=\"No\" hasHadRole=\"No\" id=\"ccoe_07270957\" isESMECustomer=\"No\" " +
			"lastname=\"coe\" password=\"password\" phoneMake=\"Alcatel\" posBusinessUnit=\"WALLET\" " +
			"timeStamp=\"2011-07-27T09:58:32.861\" title=\"Mr\" wantsGenieMarketting=\"No\" " +
			"wantsOtherMarketting=\"No\"><Address><houseNumber>70</houseNumber><addressLine1>FIELD LANE</addressLine1>" +
			"<townCity>CAMBERLEY</townCity><postcode>GU16 8JZ</postcode><country></country></Address></user>" +
			"</userDetails></users>";
	UserTOAdapter utoa;
	UserTO user = null;
	try
	{
	    utoa = new UserTOAdapter();
	    user = utoa.fromXML(message);
	} catch (SAXNotRecognizedException e)
	{
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (SAXNotSupportedException e)
	{
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (ParserConfigurationException e)
	{
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (SAXException e)
	{
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IOException e)
	{
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	
	System.out.println(user.toString());
	assertNotNull("UserTO is null",user);
	assertEquals("ID ccoe_07270957 does not match " + user.getId(), "ccoe_07270957", user.getId());
	
    }

    

}
