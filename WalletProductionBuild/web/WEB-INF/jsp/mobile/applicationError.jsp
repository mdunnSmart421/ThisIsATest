<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>

<%@ taglib uri="/WEB-INF/taglib/productRegistration.tld"  prefix="reg" %>

<head>


    <meta name="viewport" content="width=320; initial-scale=1.0; maximum-scale=1.0; width=device-width"/>


    <%--<title><reg:PageTitle value="${localModel.processName}"/></title>--%>
    <title>Error</title>
    <meta name="keywords" content="O2, 02, o2, product registration, sign in, mobile"/>
    <meta name="description" content="Your mobile number"/>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"/>
    <meta http-equiv="Cache-control" content="no-cache"/>


    <!-- Don't display phone numbers as links -->
    <meta name="format-detection" content="telephone=no">


	<%-- Load the theme based on the device --%>
   	<jsp:include page="/WEB-INF/jsp/mobile/fragments/theme.jsp" />
    <jsp:include page="/WEB-INF/fragments/coreMetrics.jsp"/>

    <jsp:include page="/WEB-INF/fragments/favicon.jsp"/>
    <link rel="stylesheet" href='css/iphone.css' type="text/css"/>
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
            Sorry, something went wrong
        </div>
        <p>
            <jsp:include page="/WEB-INF/jsp/mobile/fragments/feedback.jsp" flush="true"/>
        </p>

    </div>



</div>

</body>

</html>