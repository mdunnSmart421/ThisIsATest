package com.o2.finance.service;

import java.io.IOException;
import java.io.StringReader;
import java.text.ParseException;
import java.util.Calendar;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

import com.o2.finance.model.UserTO;

/**
 * Converts a User details returned from Orange into UserTO object
 */
/*
 * 
 * Adapted from Orange CustomerVOAdapter
 */
public class UserTOAdapter extends GenericTOAdapter
{
    private UserTO userTO;

    public UserTOAdapter() throws ParserConfigurationException, SAXException, SAXNotRecognizedException, SAXNotSupportedException
    {
        super();
    }

    /**
     * Parses the given XML string and updates the locally held UserTO
     * 
     * @return a UserTO object
     */
    public UserTO fromXML(String xml) throws SAXException, IOException
    {
        // Convert the XML string into an InputSource
        StringReader sr = new StringReader(xml);
        InputSource is = new InputSource(sr);
        this.userTO = new UserTO();
        this.xmlReader.parse(is);
        return this.userTO;
    }

    /**
     * Called when the SAX parser encounters a new element
     */
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
    {
        if (qName.equals("userDetails"))
        {
            storeUserDetailsAttr(attributes);
        } else if (qName.equals("user"))
        {
            storeUserAttr(attributes);
        } else if (qName.equals("Address"))
        {
            storeAddressAttr(attributes);
        }
        this.saxStack.push(new StringBuffer(""));
    }

    // Stores <userDetails> element attributes in UserTO
    private void storeUserDetailsAttr(Attributes attributes)
    {
    }

    // Store <user> element attributes into UserTO
    private void storeUserAttr(Attributes attributes) throws SAXException
    {
        String tempStr = null;
        if ((tempStr = attributes.getValue("custnum")) != null)
        {
            userTO.setCustomerNumber(new Integer(tempStr));
        }
        if ((tempStr = attributes.getValue("id")) != null)
        {
            userTO.setId(tempStr);
        }
        if ((tempStr = attributes.getValue("domain")) != null)
        {
            userTO.setDomain(tempStr);
        }
        if ((tempStr = attributes.getValue("SecurityQuestion")) != null)
        {
            userTO.setSecurityQuestion(tempStr);
        }
        if ((tempStr = attributes.getValue("SecurityAnswer")) != null)
        {
            userTO.setSecurityAnswer(tempStr);
        }
        if ((tempStr = attributes.getValue("key")) != null)
        {
            userTO.setKey(tempStr);
        }
        if ((tempStr = attributes.getValue("password")) != null)
        {
            userTO.setPassword(tempStr);
        }
        if ((tempStr = attributes.getValue("level2Password")) != null)
        {
            userTO.setLevel2Password(tempStr);
        }
        if ((tempStr = attributes.getValue("gender")) != null)
        {
            if (!"".equals(tempStr))
            {
                userTO.setGender(tempStr.substring(0, 1).toUpperCase());
            } else
            {
                userTO.setGender("U");
            }
        }
        if ((tempStr = attributes.getValue("forename")) != null)
        {
            userTO.setForename(tempStr);
        }
        if ((tempStr = attributes.getValue("lastname")) != null)
        {
            userTO.setLastname(tempStr);
        }
        if ((tempStr = attributes.getValue("initials")) != null)
        {
            userTO.setInitials(tempStr);
        }
        if ((tempStr = attributes.getValue("title")) != null)
        {
            userTO.setTitle(tempStr);
        }
        if ((tempStr = attributes.getValue("alternativeEmail")) != null)
        {
            userTO.setAlternativeEmail(tempStr);
        }
        if ((tempStr = attributes.getValue("alternativeContactNumber")) != null)
        {
            userTO.setAlternativeContactNumber(tempStr);
        }
        if ((tempStr = attributes.getValue("dateOfBirth")) != null)
        {
            if (!"".equals(tempStr))
            {
                Calendar tempDate;
                try
                {
                    tempDate = Calendar.getInstance();
                    tempDate.setTime(parseDate(tempStr));
                    userTO.setDateOfBirth(tempDate.get(Calendar.DAY_OF_MONTH), (tempDate.get(Calendar.MONTH)) + 1,
                            tempDate.get(Calendar.YEAR));
                } catch (ParseException pe)
                {
                    throw new SAXException("ParseException caught while parseing date in XML", pe);
                }
            }
        }
        if ((tempStr = attributes.getValue("partner")) != null)
        {
            userTO.setPartner(tempStr);
        }
        if ((tempStr = attributes.getValue("MSISDN")) != null)
        {
            userTO.setMsisdn(fixmsisdn(tempStr));
        }
        if ((tempStr = attributes.getValue("MSISDNvalid")) != null)
        {
            userTO.setMsisdnValid(tempStr);
        }
        if ((tempStr = attributes.getValue("phoneMake")) != null)
        {
            userTO.setPhoneMake(tempStr);
        }
        if ((tempStr = attributes.getValue("network")) != null)
        {
            userTO.setNetwork(tempStr);
        }
        if ((tempStr = attributes.getValue("wantsGenieMarketting")) != null)
        {
            userTO.setWantsO2Marketing(getBoolean(tempStr));
        }
        if ((tempStr = attributes.getValue("wantsOtherMarketting")) != null)
        {
            userTO.setWantsOtherMarketing(getBoolean(tempStr));
        }
        if ((tempStr = attributes.getValue("segmentation")) != null)
        {
            userTO.setSegmentationType(tempStr);
        }
        if ((tempStr = attributes.getValue("customerType")) != null)
        {
            userTO.setCustomerType(tempStr);
        }
        if ((tempStr = attributes.getValue("contactMedium")) != null)
        {
            userTO.setContactMedium(tempStr);
        }
        if ((tempStr = attributes.getValue("posBusinessUnit")) != null)
        {
            userTO.setPosBusinessUnit(tempStr);
        }
        if ((tempStr = attributes.getValue("saleDate")) != null)
        {
            try
            {
                userTO.setSaleDate(parseDate(tempStr));
            } catch (ParseException pe)
            {
                throw new SAXException("ParseException caught while parseing date in XML", pe);
            }
        }
        if ((tempStr = attributes.getValue("riskThreshold")) != null)
        {
            userTO.setRiskThreshold(new Integer(tempStr));
        }
        if ((tempStr = attributes.getValue("riskThresholdDate")) != null)
        {
            try
            {
                userTO.setRiskThresholdDate(parseDate(tempStr));
            } catch (ParseException pe)
            {
                throw new SAXException("ParseException caught while parseing date in XML", pe);
            }
        }
        if ((tempStr = attributes.getValue("creditVetPassed")) != null)
        {
            userTO.setCreditVetPassed(tempStr);
        }
        if ((tempStr = attributes.getValue("creditVetDate")) != null)
        {
            try
            {
                userTO.setCreditVetDate(parseDate(tempStr));
            } catch (ParseException pe)
            {
                throw new SAXException("ParseException caught while parseing date in XML", pe);
            }
        }
        if ((tempStr = attributes.getValue("referral")) != null)
        {
            userTO.setReferral(tempStr);
        }
        if ((tempStr = attributes.getValue("referralDate")) != null)
        {
            try
            {
                userTO.setReferralDate(parseDate(tempStr));
            } catch (ParseException pe)
            {
                throw new SAXException("ParseException caught while parseing date in XML", pe);
            }
        }
        if ((tempStr = attributes.getValue("companyName")) != null)
        {
            userTO.setCompanyName(tempStr);
        }
        if ((tempStr = attributes.getValue("companyTelephoneNumber")) != null)
        {
            userTO.setCompanyTelephoneNumber(tempStr);
        }
        if ((tempStr = attributes.getValue("numberOfEmployees")) != null)
        {
            userTO.setNoCompanyEmployees(new Integer(tempStr));
        }
        if ((tempStr = attributes.getValue("jobTitle")) != null)
        {
            userTO.setJobTitle(tempStr);
        }
        if ((tempStr = attributes.getValue("jobFunction")) != null)
        {
            userTO.setJobFunction(tempStr);
        }
        if ((tempStr = attributes.getValue("hasHadRole")) != null)
        {
            userTO.setHasHadRole(getBoolean(tempStr));
        }
        if ((tempStr = attributes.getValue("hasBeenBillingContact")) != null)
        {
            userTO.setHasBeenBillingContact(getBoolean(tempStr));
        }
        if ((tempStr = attributes.getValue("owningBusinessDivision")) != null)
        {
            userTO.setOwningBusinessDivision(tempStr);
        }
        if ((tempStr = attributes.getValue("registrationType")) != null)
        {
            userTO.setRegistrationType(tempStr);
        }
        if ((tempStr = attributes.getValue("sector")) != null)
        {
            userTO.setSector(tempStr);
        }
        if ((tempStr = attributes.getValue("companyRegistrationNumber")) != null)
        {
            userTO.setCompanyRegistrationNumber(tempStr);
        }
        if ((tempStr = attributes.getValue("isESMECustomer")) != null)
        {
            userTO.setEsmeCustomer(getBoolean(tempStr));
        }
        if ((tempStr = attributes.getValue("accountManagerName")) != null)
        {
            userTO.setAccountManagerName(tempStr);
        }
        if ((tempStr = attributes.getValue("accountManagerEmail")) != null)
        {
            userTO.setAccountManagerEmail(tempStr);
        }
        if ((tempStr = attributes.getValue("attribute6")) != null)
        {
            userTO.setAttribute6(tempStr);
        }
        if ((tempStr = attributes.getValue("attribute7")) != null)
        {
            userTO.setAttribute7(tempStr);
        }
    }

    // Stores <address> element attributes in UserTO
    private void storeAddressAttr(Attributes attributes)
    {
        String tempStr = null;
        if ((tempStr = attributes.getValue("PTCABS")) != null)
        {
            userTO.setPtCaps(tempStr);
        }
        if ((tempStr = attributes.getValue("status")) != null)
        {
            userTO.setAddressStatus(tempStr);
        }
    }

    /**
     * Called when SAX parser finished parsing an element
     */
    public void endElement(String uri, String localName, String qName)
    {
        StringBuffer buffer = (StringBuffer) this.saxStack.pop();
        String elementValue = buffer.toString();
        if (qName.equals("houseNumber"))
            this.userTO.setHouseNumber(elementValue);
        else if (qName.equals("houseName"))
            this.userTO.setHouseName(elementValue);
        else if (qName.equals("addressLine1"))
            this.userTO.setAddressLine1(elementValue);
        else if (qName.equals("addressLine2"))
            this.userTO.setAddressLine2(elementValue);
        else if (qName.equals("townCity"))
            this.userTO.setTownCity(elementValue);
        else if (qName.equals("county"))
            this.userTO.setCounty(elementValue);
        else if (qName.equals("postcode"))
            this.userTO.setPostcode(elementValue);
        else if (qName.equals("country"))
        {
            this.userTO.setCountry(elementValue);
        }
    }

    /**
     * Called when the parser encounters data (i.e. not tags) If you want to ignore whitespace add the code here
     */
    public void characters(char[] ch, int start, int length)
    {
        StringBuffer buffer;
        buffer = (StringBuffer) this.saxStack.peek();
        buffer.append(ch, start, length);
    }

    protected boolean getBoolean(String yesNo)
    {
        return (yesNo.equalsIgnoreCase("Yes")) ? true : false;
    }

    /**
     * @param msisdn
     * @return
     */
    private static String fixmsisdn(String msisdn)
    {
        if (msisdn.startsWith("07"))
        {
            msisdn = "447" + msisdn.substring(2);
        }
        return msisdn;
    }
}
