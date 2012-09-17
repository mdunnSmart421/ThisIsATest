<html>

	<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
	<%@ taglib uri="/WEB-INF/taglib/productRegistration.tld" prefix="reg" %>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


	<head>
	    <title><reg:PageTitle value="${localModel.processName}"/></title>
	
	    <meta name="viewport" content="width=320; initial-scale=1.0; maximum-scale=1.0; width=device-width"/>
	
	    <!-- make full screen if launched from home page -->
	    <meta name="apple-mobile-web-app-capable" content="yes"/>
	    <meta name="apple-mobile-web-app-status-bar-style" content="black"/>
	
        <!-- Don't display phone numbers as links -->
        <meta name="format-detection" content="telephone=no">


	    <meta name="keywords" content="O2, 02, o2, product registration, sign in, mobile"/>
	    <meta name="description" content="Your mobile number"/>
	    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"/>
	    <meta http-equiv="Cache-control" content="no-cache"/>
	
	    <jsp:include page="/WEB-INF/fragments/coreMetrics.jsp"/>
	    
	    <jsp:useBean id="silentLoginForm" scope="request" class="com.o2.finance.beans.SilentLoginForm" />
	
	    <%-- Load the theme based on the device --%>
   		<jsp:include page="/WEB-INF/jsp/mobile/fragments/theme.jsp" />
	
	</head>

	<body onload="doAutoSubmitForm()">
		
<div class="header">
    <span class="corporate-logo"></span>

    <div class="title">Apply for O2 Money</div>
    <reg:ProductRegistrationCancelForMobile />
</div>


<div class="progress-steps">

    <span class="active">1. Mobile</span>
    <span id="step-two" class="active">2. About you</span>
    <span class="">3. All done</span>
</div>


<div class="canvas">


    <div class="description">
        <noscript>

            <div class="icon bang"></div>
            <div class="heading">Javascript not enabled</div>


            <p>JavaScript is currently disabled or not supported by your browser.
            Please click 'Continue' to proceed with your application.</p>


        </noscript>


        <script language="javascript" type="text/javascript">
            document.write( "<div class='heading noicon'>" );
            document.write( "Please wait while we log you in..." );
            document.write( "</div>" );
        </script>

    </div>

    <form name="silentLoginForm" id="silentLoginForm" method="post" action="<%=silentLoginForm.getLoginURL()%>">

        <input type="hidden" name="username" id="username" value="<%=silentLoginForm.getUsername()%>"/>
        <input type="hidden" name="password" id="password" value="<%=silentLoginForm.getPassword()%>"/>
        <input type="hidden" name="destURL" id="destURL" value="<%=silentLoginForm.getReturnURL()%>"/>
        <input type="hidden" name="fuUrl" id="fuUrl" value="<%=silentLoginForm.getFailureURL()%>"/>
        <input type="hidden" name="skipRedirects" id="skipRedirects" value="true"/>



        <div class="content">

            <script language="javascript" type="text/javascript">
                document.write('            <div class="waitbox"> \
                <div class="throbberbox"> \
                <img src="img/spinning_wheel_throbber.gif" alt="wait" class="throbber"> \
                    </div>\
            </div>')
            </script>


            <noscript>
                <div class="buttonBox">
                    <input type="submit" id="silentLoginsubmit" name="submit" value="Submit" title="submit"
                           onclick="submit"/>
                </div>
            </noscript>

        </div>
    </form>

</div>

<script language="JavaScript" type="text/javascript">

    function doAutoSubmitForm()
    {
        document.silentLoginForm.submit();
    }
</script>

</body>
</html>