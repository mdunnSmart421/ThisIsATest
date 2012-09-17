<html>

<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/WEB-INF/taglib/productRegistration.tld" prefix="reg" %>


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

    <%-- Load the theme based on the device --%>
   	<jsp:include page="/WEB-INF/jsp/mobile/fragments/theme.jsp" />
   	
   	<c:url var="mobileUtilsJS" value="/scripts/mobileUtils.js"/>
    <script type="text/javascript" src="<c:out value='${mobileUtilsJS}'/>"></script>

</head>


<body>

<!-- This is existingMpn (mobile).jsp --!>

<!-- coremetrics tpRegistration -->
<div id="cmTPpageID" style="display:none;">O2 Money - Authentication - Confirm number for account</div>
<div id="cmTPcatID" style="display:none;">O2 Money - Prepaid Card - Authentication</div>


<div class="header">
    <span class="corporate-logo"></span>

    <div class="title">Register</div>
    <reg:ProductRegistrationCancelForMobile />
</div>


<div class="progress-steps">

    <span class="active">1. Mobile</span>
    <span id="step-two">2. About you</span>
    <span class="">3. All done</span>
</div>


<div class="canvas">

    <div class="description">

        <div class="heading noicon">Is this your mobile number?</div>
        <p>
            If this isn't your number, change it and we'll send you another text.
        </p>

        <jsp:include page="/WEB-INF/jsp/mobile/fragments/feedback.jsp" flush="true"/>
    </div>

    <div class="content">

        <form:form method="post"
                   commandName="enterMpnForm"
                   cssClass="txt">


            <form:input path="newMsisdn" title="Mobile number" cssClass="mobileInput" tabindex="30"
                        onkeypress="return numbersonly(this, event);" size="35" maxlength="11" id="newMsisdn"
                        alt="New number"/>

            <form:errors path="newMsisdn" element="div" cssClass="errorText"/>


            <div class="buttonBox">
                <input type="submit" name="edit" value="Continue"
                       title="Continue" class="continueButton"/>
            </div>
        </form:form>

    </div>

</div>

<script language="JavaScript" type="text/javascript">

    document.getElementById('newMsisdn').value='<c:out value="${enterMpnForm.msisdn}"/>';

</script>

</body>
</html>