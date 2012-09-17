package com.o2.finance.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Stack;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.regexp.RESyntaxException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import com.o2.finance.properties.PropertyManager;
import com.o2.finance.util.XMLCleaner;

public class GenericTOAdapter extends DefaultHandler
{
    protected XMLReader xmlReader;
    protected Stack saxStack;
    protected String xmlDateFormat;
    protected DocumentBuilder docBuilder;
    protected Document doc;

    static Logger log = LogManager.getLogger( GenericTOAdapter.class );

    /**
     * Takes a properties file and creates a document builder and SAX parser to support the toXML and fromXML methods
     * 
     */
    public GenericTOAdapter() throws SAXException, ParserConfigurationException
    {
        super();

        log.info( "GenericTOAdapter start." );


        // Create and configure the document builder
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setCoalescing(false);
        dbf.setExpandEntityReferences(false);
        dbf.setIgnoringComments(true);
        dbf.setIgnoringElementContentWhitespace(true);
        dbf.setNamespaceAware(true);
        dbf.setValidating(false);
        // Create the document builder that satisfies the specified contraints
        docBuilder = dbf.newDocumentBuilder();
        // Create and configure the XML reader
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        this.xmlReader = saxParser.getXMLReader();
        this.xmlReader.setContentHandler(this);
        this.xmlReader.setFeature("http://xml.org/sax/features/validation", false);
        String serviceXMLDateFormat = PropertyManager.getApplicationProperties().getRegistrationServiceXmlDateFormat();
        this.xmlDateFormat = serviceXMLDateFormat;
        // Create the sax stack to save element values while parsing xml strings
        this.saxStack = new Stack();

        log.info( "GenericTOAdapter ends." );

    }

    /**
     * Converts a null string to an empty one ("")
     * 
     * @param String
     *            to be converted
     * @returns The original string if not null or "" otherwise
     */
    protected String valueOf(String sIn)
    {
        String sOut = sIn;
        if (sOut == null)
        {
            sOut = "";
        }
        return sOut;
    }

    protected String valueOf(Integer i)
    {
        String sOut = String.valueOf(i);
        return valueOf(sOut);
    }

    /**
     * Phase 3: Convenience method where the date format can be specified A.E.[20/06/03]
     * 
     * @param dateIn
     * @param formatPattern
     * @return
     */
    protected String formatDate(Date dateIn, String formatPattern)
    {
        SimpleDateFormat dateOutFormat = new SimpleDateFormat(formatPattern);
        return dateOutFormat.format(dateIn);
    }

    /**
     * Takes a date object and the desired output format and returns the reformated date as a string
     * 
     * @param dateIn
     *            a date object
     * @param formatOut
     *            a String containing the desired date format
     * @return A String containing the date in the new format
     */
    protected String formatDate(Date dateIn)
    {
        return formatDate(dateIn, xmlDateFormat);
    }

    /**
     * Takes a string containing a date and a format string, parses the date and returns a date object
     * 
     * @param dateIn
     *            a String containing the date
     * @param formatIn
     *            a String containing the format string
     * @return The date as a Date object
     * */
    protected Date parseDate(String dateIn) throws ParseException
    {
        SimpleDateFormat dateInFormat = new SimpleDateFormat(xmlDateFormat);
        Date dateOut = dateInFormat.parse(dateIn);
        return dateOut;
    }

    protected void setAttribute(Element element, String name, String value)
    {
        if (value != null)
        {
            element.setAttribute(name, value);
        }
    }

    protected void setAttribute(Element element, String name, Integer value)
    {
        if (value != null)
        {
            element.setAttribute(name, valueOf(value));
        }
    }

    protected void appendNewSimpleElement(Element parentElement, String name, String value, boolean mandatory)
    {
        // Default the elementValue to "" and assign it a value if specified
        String elementValue = (value == null) ? "" : value;
        // If the element is mandatory or the element value is not "" add the element to the parent
        if (mandatory || (!"".equals(elementValue)))
        {
            Element childElement = doc.createElement(name);
            childElement.appendChild(doc.createTextNode(elementValue));
            parentElement.appendChild(childElement);
        }
    }

    protected void appendNewSimpleElement(Element parentElement, String name, Integer value, boolean mandatory)
    {
        // Default the elementValue to "" and assign it a value if specified
        String elementValue = (value == null) ? "" : String.valueOf(value);
        // If the element is mandatory or the element value is not "" add the element to the parent
        if (mandatory || (!"".equals(elementValue)))
        {
            Element childElement = doc.createElement(name);
            childElement.appendChild(doc.createTextNode(elementValue));
            parentElement.appendChild(childElement);
        }
    }

    public static String nodeWalk(Node n) throws RESyntaxException
    {
        log.info( "nodeWalk start." );

        StringBuffer xml = new StringBuffer();
        short nodeType = n.getNodeType();
        switch (nodeType)
        {
        case Node.ATTRIBUTE_NODE:
            if (n.getNodeValue() != null)
            {
                xml.append(" ").append(n.getNodeName()).append("=\"").append(XMLCleaner.replaceXmlCharacters(n.getNodeValue()))
                        .append("\"");
            }
            break;
        case Node.ELEMENT_NODE:
            xml.append("<").append(n.getNodeName());
            if (n.hasAttributes())
            {
                xml.append(nodeMapWalk(n.getAttributes()));
            }
            xml.append(">");
            if (n.hasChildNodes())
            {
                xml.append(nodeListWalk(n.getChildNodes()));
            }
            xml.append("</").append(n.getNodeName()).append(">");
            break;
        case Node.DOCUMENT_NODE:
            if (n.hasChildNodes())
            {
                xml.append(nodeListWalk(n.getChildNodes()));
            }
            break;
        case Node.TEXT_NODE:
            xml.append(XMLCleaner.replaceXmlCharacters(n.getNodeValue()));
            break;
        default:
            // Not interested
            break;
        }
        log.info( "nodeWalk ends." );

        return xml.toString();
    }

    private static String nodeMapWalk(NamedNodeMap nnm) throws RESyntaxException
    {
        String xml = "";
        int count = nnm.getLength();
        for (int i = 0; i < count; i++)
        {
            xml += nodeWalk(nnm.item(i));
        }
        return xml;
    }

    private static String nodeListWalk(NodeList nl) throws RESyntaxException
    {
        String xml = "";
        int count = nl.getLength();
        for (int i = 0; i < count; i++)
        {
            xml += nodeWalk(nl.item(i));
        }
        return xml;
    }
}
