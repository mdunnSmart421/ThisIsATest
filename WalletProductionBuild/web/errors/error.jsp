
<%@page import="com.o2.finance.etc.DeviceConstants"%>
<%@page import="com.o2.finance.util.MobileThemeSupportHelper"%>
	
 
<%
	String errorPage = "/errors/webError.html";

	String themeName = MobileThemeSupportHelper.getThemeName( request );
	if ( MobileThemeSupportHelper.isMobileTheme( themeName ) )
	{
		if ( DeviceConstants.IPHONE.equals( themeName ) )
		{
			errorPage = "/errors/iphoneError.html";
		}
		else if ( DeviceConstants.ANDROID.equals( themeName ) )
		{
			errorPage = "/errors/androidError.html";
		}
		else if ( DeviceConstants.BLACKBERRY.equals( themeName ) )
		{
			errorPage = "/errors/blackberryError.html";
		}
	}
%>

<jsp:include page="<%=errorPage%>" />
	






    

