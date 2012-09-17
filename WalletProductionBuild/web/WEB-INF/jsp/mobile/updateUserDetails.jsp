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

    <jsp:useBean id="postPayDivClass" scope="request" class="java.lang.String"/>

    <jsp:include page="/WEB-INF/fragments/coreMetrics.jsp"/>

    <%-- Load the theme based on the device --%>
   	<jsp:include page="/WEB-INF/jsp/mobile/fragments/theme.jsp" />
   	
   	<c:url var="mobileUtilsJS" value="/scripts/mobileUtils.js"/>
    <script type="text/javascript" src="<c:out value='${mobileUtilsJS}'/>"></script>

</head>


<body>

<!-- This is updateUserDetails (mobile).jsp -->

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
    <span class="">3. All done</span>
</div>

<div class="canvas">

<div class="description">
    <div class="heading noicon">Check your details</div>

    <p>
        It's important that we have the right details for you so check that everything is correct. Update
        your details below if needed and continue with your O2 Wallet application.
    </p>

    <p class="mandatory">Fields marked with an asterisk * are mandatory</p>

    <jsp:include page="/WEB-INF/fragments/Feedback.jsp" flush="true"/>

</div>


<div class="content">

<form:form method="post" commandName="updateUserDetailsForm" cssClass="txt">

<%--Title--%>


<c:choose>
    <c:when test="${editable.forename}">
        <div class="inputLabel">
            <label for="in_title" title="Title">Title *</label>
        </div>
        <div class="select-wrapper arrow">
            <form:select path="title" cssClass="select-wrapper arrow" tabindex="09" title="Title *"
                         id="in_title" >
                <form:options items="${updateUserDetailsForm.titles}"/>
            </form:select>
        </div>

    </c:when>
    <c:otherwise>
        <form:hidden path="title"/>
        <div class="static label"><c:out value="${updateUserDetailsForm.title}"/></div>
    </c:otherwise>
</c:choose>



<%--end title--%>


<%--forename--%>



<c:choose>
    <c:when test="${editable.forename}">
        <form:input path="forename" title="Your first name *" id="forename" cssClass="mobileInput" tabindex="10"
                    maxlength="30" size="30" onkeypress="return event.keyCode!=13" alt="First name"/>
    </c:when>
    <c:otherwise>
        <form:hidden path="forename"/>
        <div class="static label"><c:out value="${updateUserDetailsForm.forename}"/></div>
    </c:otherwise>
</c:choose>

<form:errors path="forename" element="div" cssClass="errorText"/>


<%--end forename--%>

<%--lastname--%>

<c:choose>
    <c:when test="${editable.lastName}">
        <form:input path="lastName" title="Your last name *" id="lastName" cssClass="mobileInput" tabindex="20"
                    maxlength="30" size="30" onkeypress="return event.keyCode!=13" alt="Last name"/>
    </c:when>
    <c:otherwise>
        <form:hidden path="lastName"/>
        <div class="static label">
            <c:out value="${updateUserDetailsForm.lastName}"/>
        </div>
    </c:otherwise>
</c:choose>

<form:errors path="lastName" element="div" cssClass="errorText"/>

<%--end lastname--%>


<%--address--%>

<c:set var="houseNumErrors"><form:errors path="address.houseNumber"/></c:set>
<c:set var="houseNameErrors"><form:errors path="address.houseName"/></c:set>
<c:set var="postcodeErrors"><form:errors path="address.postcode"/></c:set>

<c:choose>
    <c:when test="${ ( empty houseNumErrors ) && ( empty houseNameErrors ) && ( empty postcodeErrors ) }">
        <p class="address">Your current address is:</p>
        <c:out value="${updateUserDetailsForm.address.address}"/>
    </c:when>
    <c:otherwise>
        &nbsp;
    </c:otherwise>
</c:choose>


<p>If your address isn't right, type in your details below and click on 'Find address' to
    look up your address.</p>


<%--House number--%>
<form:input path="address.houseNumber" id="houseNumber" title="House number" cssClass="mobileInput"
            tabindex="30" size="10" maxlength="5" onkeypress="return event.keyCode!=13"
            alt="House number (if applicable)"/>
<form:errors path="address.houseNumber" element="div" cssClass="errorText"/>

<%--House name--%>

<form:input path="address.houseName" title="House name *" id="houseName" cssClass="mobileInput" tabindex="40"
            maxlength="80" size="30" onkeypress="return event.keyCode!=13" alt="House name (if applicable)"/>
<form:errors path="address.houseName" element="div" cssClass="errorText"/>


<%--Postcode--%>
<form:input path="address.postcode" id="postcode" title="Postcode *" size="10" cssClass="mobileInput"
            tabindex="50" maxlength="10" onkeypress="return event.keyCode!=13" alt="Postcode"/>

<form:errors path="address.postcode" element="div" cssClass="errorText"/>


<div class="buttonBox">
    <input name="findAddress" type="submit" id="findAddress" title="Find address" value="Find address"
           class="continueButton"/>
</div>
<%--end address--%>


<hr/>


<%--gender--%>

    <label title="Gender">Gender *</label>

<c:choose>
    <c:when test="${editable.gender}">

        <div class="gender">
            <label for="male"><form:radiobutton path="gender.gender" title="Male" id="male" value="M" tabindex="60"
                              onkeypress="return event.keyCode!=13" cssClass="radio" /> Male</label>


            <label for="female"><form:radiobutton path="gender.gender" title="Female" id="female" value="F" tabindex="70"
                                  onkeypress="return event.keyCode!=13" cssClass="radio"/> Female</label>

        </div>

    </c:when>
    <c:otherwise>
        <form:hidden path="gender.gender"/>
        <div class="static label"><c:out value="${updateUserDetailsForm.gender.genderText}"/></div>
    </c:otherwise>
</c:choose>

<form:errors path="gender.gender" element="div" cssClass="errorText"/>

<%--end gender--%>


<%--Date of birth--%>



<c:choose>
    <c:when test="${editable.dateOfBirth}">
        <label>Date of birth *</label>
        <div class="dateOfBirth">

                <div class="dayYearContainer">

                    <div class="ds_left">

                        <form:input path="dateOfBirth.birthDay" id="birthDay" title="birthDay" tabindex="80" size="2"
                                    maxlength="2"
                                    onfocus="resetDD(this)" onkeypress="return event.keyCode!=13" alt="Day"
                                    cssClass="mobileInput w2"/>

                    </div>

                    <div class="ds_main">

                        <div class="select-wrapper arrow">
                            <form:select path="dateOfBirth.birthMonth" id="birthMonth" title="Date of Birth - Month"
                                         tabindex="90"
                                         onkeypress="return event.keyCode!=13">
                                <form:options items="${updateUserDetailsForm.months}"/>
                            </form:select>
                        </div>
                    </div>
                </div>


                <div class="ds_sidebar">
                    <form:input path="dateOfBirth.birthYear" id="birthYear" title="Year" tabindex="100" size="4" maxlength="4"
                                onfocus="resetYYYY(this)" onkeypress="return event.keyCode!=13" alt="Year"
                                cssClass="mobileInput"/>
                </div>

        </div>

        <form:errors path="dateOfBirth.birthDay" element="div" cssClass="errorText"/>
        <form:errors path="dateOfBirth.birthMonth" element="div" cssClass="errorText"/>
        <form:errors path="dateOfBirth.birthYear" element="div" cssClass="errorText"/>

    </c:when>

    <c:otherwise>
        <form:hidden path="dateOfBirth.birthDay"/>
        <form:hidden path="dateOfBirth.birthMonth"/>
        <form:hidden path="dateOfBirth.birthYear"/>
        <label>Date of birth</label>
        <div class="static label">
            <c:out value="${updateUserDetailsForm.dateOfBirth.dateOfBirth}"/>
        </div>
    </c:otherwise>
</c:choose>
<%-- end Date of birth--%>


<%--Mobile make--%>
<label class="inputLabel">Type of mobile *</label>


<div class="select-wrapper arrow">
    <form:select path="mobileMake" title="Type of mobile  *" id="mobileMake" cssClass="mobileInput" tabindex="110"
                 onkeypress="return event.keyCode!=13">
        <form:options items="${updateUserDetailsForm.mobileMakes}"/>
    </form:select>
</div>
<form:errors path="mobileMake" element="div" cssClass="errorText"/>
<%--end Mobile make--%>


<hr/>


<%--email--%>

<form:input path="alternativeEmail" title="Current email address *" id="emailAddress" cssClass="mobileInput"
            tabindex="120" size="30" maxlength="127" onkeypress="return event.keyCode!=13" alt="Email address"/>

<form:errors path="alternativeEmail" element="div"/>

<hr/>

<%--Continue--%>
<div class="buttonBox">
    <input type="submit" name="continueUpdate" value="Continue"
           title="Continue" class="continueButton"/>
</div>

</form:form>

</div>
</div>

<script language="JavaScript" type="text/javascript">

    fixRadio();

</script>

</body>
</html>