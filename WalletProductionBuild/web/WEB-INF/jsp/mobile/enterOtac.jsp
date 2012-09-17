<html>

<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/WEB-INF/taglib/productRegistration.tld" prefix="reg" %>


<head>
    <title><reg:PageTitle value="${localModel.processName}"/></title>

    <meta name="keywords" content="O2, 02, o2, product registration, sign in, mobile"/>
    <meta name="description" content="Your mobile number"/>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"/>
    <meta http-equiv="Cache-control" content="no-cache">

    <jsp:include page="/WEB-INF/fragments/coreMetrics.jsp"/>

    <meta name="viewport" content="width=320; initial-scale=1.0; maximum-scale=1.0; width=device-width"/>

    <!-- Don't display phone numbers as links -->
    <meta name="format-detection" content="telephone=no">


    <%-- Load the theme based on the device --%>
   	<jsp:include page="/WEB-INF/jsp/mobile/fragments/theme.jsp" />
   	
   	<c:url var="mobileUtilsJS" value="/scripts/mobileUtils.js"/>
    <script type="text/javascript" src="<c:out value='${mobileUtilsJS}'/>"></script>

</head>
<body>
<!-- This is enterOtac (mobile).jsp -->


<!-- coremetrics tpRegistration -->
<div id="cmTPpageID" style="display:none;">O2 Money - Authentication - Mobile Verification</div>
<div id="cmTPcatID" style="display:none;">O2 Money - Prepaid Card - Authentication</div>

<form:form method="post" commandName="enterOtacForm">


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

            <div class="icon bang"></div>
            <div class="heading">Check your messages</div>

            	<c:url var="backUrl" value="/enterMpn.do"/>

            <p>We've sent a text.<br/>
                If your mobile number isn't <span class="bold"><c:out value="${enterOtacForm.msisdn}"/></span>, let's <a
                        href="<c:out value='${backUrl}'/>">try
                    again</a>.</p>

            <jsp:include page="/WEB-INF/jsp/mobile/fragments/feedback.jsp" flush="true"/>

        </div>

        <div class="content">


            <form:input path="verificationCode" id="verificationCode" title="Verification"
                        onkeypress="return numbersonly(this, event);" maxlength="6" size="10"
                        cssClass="mobileInput widthHalf" alt="Verification code"/>

            <form:errors path="verificationCode" cssClass="errorText" element="div"/>


            <div class="buttonBox">
                <input type="submit" name="Continue" value="Continue"
                       title="Continue" class="continueButton"/>
            </div>


            <div class="infobox">
                <div class="infoicon"></div>
                <div class="infoheader">
                    Still waiting?
                </div>

                <c:url var="resendOtacUrl" value="/enterMpn.do">
                    <c:param name="action" value="resendotac"/>
                </c:url>

                If you are still waiting after ten minutes, ask us
                to <a href="<c:out value='${resendOtacUrl}'/>">send another code</a>.

            </div>

        </div>


    </div>
</form:form>

</body>
</html>