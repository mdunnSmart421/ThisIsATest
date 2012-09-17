
<%@page import="com.o2.finance.etc.DeviceConstants"%>
<%@page import="com.o2.finance.util.MobileThemeSupportHelper"%>
	
 
<%
	String splashPage = "/splash/webSplash.html";

	String themeName = MobileThemeSupportHelper.getThemeName( request );
	if ( MobileThemeSupportHelper.isMobileTheme( themeName ) )
	{
		if ( DeviceConstants.IPHONE.equals( themeName ) )
		{
		    splashPage = "/splash/iphoneSplash.html";
		}
		else if ( DeviceConstants.ANDROID.equals( themeName ) )
		{
		    splashPage = "/splash/androidSplash.html";
		}
		else if ( DeviceConstants.BLACKBERRY.equals( themeName ) )
		{
		    splashPage = "/splash/blackberrySplash.html";
		}
	}
%>

<jsp:include page="<%=splashPage%>" />
	






    

