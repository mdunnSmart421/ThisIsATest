<html>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/taglib/productRegistration.tld" prefix="reg" %>

<head>
    <title><reg:PageTitle value="${pageTitle}"/></title>
    <meta name="keywords" content="O2, 02, o2, product registration, sign in, mobile"/>
    <meta name="description" content="Your mobile number"/>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"/>
    <meta http-equiv="Cache-control" content="no-cache"/>

    <meta name="viewport" content="width=320; initial-scale=1.0; maximum-scale=1.0; width=device-width"/>


    <!-- Don't display phone numbers as links -->
    <meta name="format-detection" content="telephone=no">


    <jsp:include page="/WEB-INF/fragments/favicon.jsp"/>

    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


    <jsp:include page="/WEB-INF/fragments/coreMetrics.jsp"/>

    <%-- Load the theme based on the device --%>
    <jsp:include page="/WEB-INF/jsp/mobile/fragments/theme.jsp"/>


</head>
<body>


<%--<script type="text/javascript" src="<%= request.getContextPath() %>/ProductReg/scripts/commonvalidation.js"></script>--%>


<!-- coremetrics tpRegistration -->
<div id="cmTPpageID" style="display:none;">O2 Money - Authentication - Portal details Confirmation</div>
<div id="cmTPcatID" style="display:none;">O2 Money - Prepaid Card - Authentication</div>



    <div class="header">
        <span class="corporate-logo"></span>

        <div class="title">Register</div>
        <reg:ProductRegistrationCancelForMobile />
    </div>


    <div class="progress-steps">

        <span class="active">1. Mobile</span>
        <span id="step-two" class="active">2. About you</span>
        <span class="active">3. All done</span>
    </div>


    <div class="canvas">
        <div class="description">

            <div class="icon tick"></div>
            <div class="heading">You're now registered</div>

            <p>You're now registered with O2. The next step is to
            activate your O2 Wallet. It won't take long as we'll use
            the information you've already given us.</p>

            <jsp:include page="/WEB-INF/jsp/mobile/fragments/feedback.jsp" flush="true"/>

        </div>


        <div class="content">


                <form:form method="post"
                       commandName="updateUserDetailsForm">


                <div class="buttonBox">
                    <input name="continueConfirm" type="submit" class="continueButton"
                           title="Continue" value="Continue"/>
                </div>


             <div class="infobox">
                <div class="infoheader noicon">Using the O2 Wallet App?</div>
                We take your security seriously, so we need to do a couple of
                additional checks to link your wallet to you mobile and email
                address.
            </div>

            </form:form>

        </div>


    </div>
</body>

</html>