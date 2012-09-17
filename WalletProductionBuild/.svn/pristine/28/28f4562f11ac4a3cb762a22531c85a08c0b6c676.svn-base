<html>

<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/WEB-INF/taglib/productRegistration.tld" prefix="reg" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>




<head>
    <title><reg:PageTitle value="${localModel.processName}"/></title>

    <meta name="viewport" content="width=320; initial-scale=1.0; maximum-scale=1.0; width=device-width"/>


    <!-- Don't display phone numbers as links -->
    <meta name="format-detection" content="telephone=no">


    <!-- make full screen if launched from home page -->
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="apple-mobile-web-app-status-bar-style" content="black"/>


    <meta name="keywords" content="O2, 02, o2, product registration, sign in, mobile"/>
    <meta name="description" content="Your mobile number"/>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"/>
    <meta http-equiv="Cache-control" content="no-cache"/>

    <jsp:include page="/WEB-INF/fragments/coreMetrics.jsp"/>
    
    <%-- Load the theme based on the device --%>
   	<jsp:include page="/WEB-INF/jsp/mobile/fragments/theme.jsp" />


</head>


<body>

<!-- This is enterMPN (mobile).jsp -->

<!-- coremetrics tpRegistration -->
<div id="cmTPpageID" style="display:none;">O2 Money - Enter Mobile number</div>
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
            <div class="heading noicon">Tell us your mobile number</div>

            <p>To register for an O2 Money Account we need to know your mobile number. We'd
                like to send you a text to make sure it's you.</p>

            <jsp:include page="/WEB-INF/jsp/mobile/fragments/feedback.jsp" flush="true"/>


        </div>


        <div class="content">

            <form:form method="post"
               commandName="enterMpnForm"
               cssClass="txt">

            <%--<form:input path="msisdn" title="Mobile number" id="msisdn"--%>
                        <%--onkeypress="return numbersonly(this, event);"--%>
                        <%--maxlength="11" cssClass="mobileInput widthFull" alt="Mobile number *"/>--%>


                <c:set var="setMaxLength"><spring:theme code="setMaxLength"/></c:set>

                <c:choose>
                    <c:when test="${setMaxLength}">
                        <form:input path="msisdn" title="Mobile number" id="msisdn"
                                    onkeypress="return numbersonly(this, event);"
                                    maxlength="11" cssClass="mobileInput widthFull" alt="Mobile number *"/>
                    </c:when>
                    <c:otherwise>
                        <form:input path="msisdn" title="Mobile number" id="msisdn"
                                    onkeypress="return numbersonly(this, event);"
                                    cssClass="mobileInput widthFull" alt="Mobile number *"/>
                    </c:otherwise>
                </c:choose>


            <form:errors path="msisdn" cssClass="errorText" element="div"/>

            <div class="buttonBox">

                <input type="submit" name="requestcode" value="Continue"
                       title="Send me the code" class="content"/>

            </div>

            <div class="infobox">
                <div class="infoicon"></div>
                <div class="infoheader">Need help?</div>
                Get in touch with our <a href="http://m.o2.co.uk/support/contactus" >customer service team </a>
             </div>

        </form:form>

        </div>



    </div>

</body>

</html>