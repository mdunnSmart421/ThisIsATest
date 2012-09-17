<%@ page import="com.o2.finance.properties.PageIncludesProperties" %>
<%@ page import="com.o2.finance.properties.PropertyManager" %>
<!-- Start Header -->
<%@ taglib uri="/WEB-INF/taglib/io.tld" prefix="io" %>
<!-- %@ taglib uri="weblogic-tags.tld" prefix="wl" % -->     
<%
	// the protocol, server name and remaingin URL are pulled from properties file using a custom
	// class to get around the problem of including the results of a custom tag in
	// another custom tag - basically it didn't work...
	// 20/2/2007 Probinson - removed ienstyle.css

	org.apache.log4j.Logger logger = org.apache.log4j.LogManager.getLogger("topNav.jsp");


	if (request.getParameter("clearNavProps") != null) {
		// clear the navigation values cached from the props file, meaning they will be read again, allowing prop changes on the fly
		application.setAttribute("includeProps", null);
	}
		
	// try to get the includeProps data object from the servlet context first
//    PageIncludesProperties includeProps = (PageIncludesProperties) application.getAttribute( ApplicaitonConstants.PAGE_INCLUDES );
    PageIncludesProperties navProps = PropertyManager.getPageIncludesProperties();
//	if (includeProps == null) {
//		// it wasn't found in the servlet context, so create from scratch
//	    includeProps = new PageIncludesProperties();
//		System.out.println("Creating a new PageIncludesProperties object");
//		// save to the servlet context - it is a lightweight object with no user-specific data, so
//		// saving it here will avoid continual IO access of the properties file
//		application.setAttribute( ApplicaitonConstants.PAGE_INCLUDES, includeProps );
//	}


//	if (request.getParameter("printProps") != null) {
//		// print to the console a string representation of the NavProps class
//		System.out.println( includeProps.toString());
//	}

	String path = navProps.getProtocol();
	path += navProps.getServer();
	path += navProps.getRegTopnav();
	try {
%>
	
<!--<wl:cache timeout="15m" async="true" name="RegTopnav">-->
		<io:http url="<%= path %>" action="GET"/>
<!--</wl:cache>-->
<%
      } catch (Exception e)
      {
    	  logger.error( "Failed in topNav.jsp.", e );
      }
%>
<!-- End Header -->
