<html>

<%@ taglib uri="/WEB-INF/taglib/productRegistration.tld"  prefix="reg" %>

<head>
    <title>O2 Finance error</title>

    <meta name="viewport" content="width=320; initial-scale=1.0; maximum-scale=1.0; width=device-width"/>
    <!-- make full screen if launched from home page -->
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="apple-mobile-web-app-status-bar-style" content="black"/>

    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"/>
    <meta http-equiv="Cache-control" content="no-cache"/>

    <jsp:include page="/WEB-INF/fragments/favicon.jsp"/>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

    <!-- Don't display phone numbers as links -->
    <meta name="format-detection" content="telephone=no">


    <%-- Load the theme based on the device --%>
   	<jsp:include page="/WEB-INF/jsp/mobile/fragments/theme.jsp" />

    <jsp:include page="/WEB-INF/fragments/coreMetrics.jsp"/>


</head>
<body>

<div id="cmTPpageID" style="display:none;">O2 Money - Registration failure</div>
<div id="cmTPcatID" style="display:none;">O2 Money - Prepaid Card - Authentication</div>


<div class="header">
    <span class="corporate-logo"></span>

    <div class="title">Register</div>
    <reg:ProductRegistrationCancelForMobile />
</div>


<div class="canvas">

    <div class="description">
        <div class="icon errorbang"></div>
        <div class="heading">
            We're a little busy right now
        </div>

        <p>Sorry, we appear to be experiencing a few problems. Please
            can you <a href="<%=request.getAttribute( "backUrl" )%>">try again</a>.
        </p>

    </div>
</div>

</body>
</html>