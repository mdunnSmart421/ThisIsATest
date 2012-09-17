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

    <jsp:useBean id="enterUserDetailsForm" scope="request" class="com.o2.finance.beans.EnterUserDetailsForm"/>

    <jsp:include page="/WEB-INF/fragments/coreMetrics.jsp"/>

    <%-- Load the theme based on the device --%>
    <jsp:include page="/WEB-INF/jsp/mobile/fragments/theme.jsp"/>

    <c:url var="usernameFinderJS" value="/scripts/usernameFinder.js"/>
    <c:url var="commonValidationJS" value="/scripts/commonvalidation.js"/>
    <c:url var="commonUtilsJS" value="/scripts/commonUtils.js"/>
    <c:url var="mobileUtilsJS" value="/scripts/mobileUtils.js"/>

    <script type="text/javascript" src="<c:out value='${usernameFinderJS}'/>"></script>
    <script type="text/javascript" src="<c:out value='${commonValidationJS}'/>"></script>
    <script type="text/javascript" src="<c:out value='${commonUtilsJS}'/>"></script>
    <script type="text/javascript" src="<c:out value='${mobileUtilsJS}'/>"></script>


    <script language="JavaScript" type="text/javascript">
        function disableSubmit()
        {
            var elmt = document.getElementById( "submit" );
            if (elmt != null)
            {
                try
                {
                    // first, disable specific style attributes
                    elmt.disabled = true;
                    document.body.style.cursor = "wait";
                }
                catch(Exception)
                {
                    ;
                }
            }
        }
    </script>

</head>

<body>
<!-- This is enterUserDetails (mobile).jsp -->


<!-- coremetrics tpRegistration -->
<div id="cmTPpageID" style="display:none;">O2 Money - Authentication - Portal Registration</div>
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
    <div class="heading noicon">Please compete your details</div>
    <p class="mandatory" >Fields marked with an asterisk * are mandatory</p>


    <jsp:include page="/WEB-INF/jsp/mobile/fragments/feedback.jsp" flush="true"/>

</div>

<div class="content">
<form:form method="post"
           commandName="enterUserDetailsForm"
           id="enterUserDetailsForm"
           name="enterUserDetailsForm"
           onsubmit="disableSubmit()">

<%--title--%>
<div class="select-wrapper arrow">
    <form:select path="title"  tabindex="09" title="Title *" id="in_title"
                  cssClass="select-wrapper arrow">
        <form:options items="${enterUserDetailsForm.titles}"/>
    </form:select>
</div>

<%--Forename--%>
<form:input path="forename" title="Your first name *" id="forename" cssClass="mobileInput" tabindex="10"
            maxlength="30" size="30" onkeypress="return event.keyCode!=13" alt="First name *"/>
<form:errors path="forename" element="div" cssClass="errorText"/>


<%--Lastname--%>
<form:input path="lastName" title="Your last name *" id="lastName" cssClass="mobileInput" tabindex="20"
            maxlength="30" size="30" onkeypress="return event.keyCode!=13" alt="Last name *"/>
<form:errors path="lastName" element="div" cssClass="errorText"/>

<hr/>

<p>Find my address *</p>

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
            tabindex="50" maxlength="10" onkeypress="return event.keyCode!=13" alt="Postcode *"/>
<form:errors path="address.postcode" element="div" cssClass="errorText"/>


<form:hidden path="address.addressLine1"/>
<form:hidden path="address.addressLine2"/>
<form:hidden path="address.townOrCity"/>

<!-- Save a copy of the PAF confirmed address -->
<form:hidden path="copyOfPAFConfirmedAddress.addressLine1"/>
<form:hidden path="copyOfPAFConfirmedAddress.addressLine2"/>
<form:hidden path="copyOfPAFConfirmedAddress.townOrCity"/>
<form:hidden path="copyOfPAFConfirmedAddress.houseNumber"/>
<form:hidden path="copyOfPAFConfirmedAddress.houseName"/>
<form:hidden path="copyOfPAFConfirmedAddress.postcode"/>


<div class="buttonBox">
    <input name="findAddress" type="submit" id="findAddress" title="Find address" value="Find address"
           class="continueButton"/>
</div>


<c:if test="${ enterUserDetailsForm.pafAddress }">
    <p class="address">Your current address is:</p>
    <%=enterUserDetailsForm.getAddress().getAddress()%>
</c:if>


<hr/>


<%--Gender--%>

<label>Gender *</label>

<div class="gender">
    <label for="male"><form:radiobutton path="gender.gender" title="Male" id="male" value="M" tabindex="60"
                      onkeypress="return event.keyCode!=13" cssClass="radio" /> Male</label>


    <label for="female"><form:radiobutton path="gender.gender" title="Female" id="female" value="F" tabindex="70"
                          onkeypress="return event.keyCode!=13" cssClass="radio"/> Female</label>

</div>

<form:errors path="gender.gender" element="div" cssClass="errorText"/>


<%--Date of Birth--%>


<label>Date of birth *</label>

<div class="dateOfBirth">
    <div class="dayYearContainer">

        <div class="ds_left">

            <form:input path="dateOfBirth.birthDay" id="birthDay" title="birthDay" tabindex="80" size="2" maxlength="2"
                        onkeypress="return event.keyCode!=13" alt="Day"
                        cssClass="mobileInput w2"/>

        </div>

        <div class="ds_main">

            <div class="select-wrapper arrow">
                <form:select path="dateOfBirth.birthMonth" id="birthMonth" title="Date of Birth - Month" tabindex="90"
                             onkeypress="return event.keyCode!=13">
                    <form:options items="${enterUserDetailsForm.months}"/>
                </form:select>
            </div>
        </div>
    </div>


    <div class="ds_sidebar">
        <form:input path="dateOfBirth.birthYear" id="birthYear" title="Year" tabindex="100" size="4" maxlength="4"
                    onkeypress="return event.keyCode!=13" alt="Year" cssClass="mobileInput"/>
    </div>
</div>

<form:errors path="dateOfBirth.birthDay" element="div" cssClass="errorText"/>
<form:errors path="dateOfBirth.birthMonth" element="div" cssClass="errorText"/>
<form:errors path="dateOfBirth.birthYear" element="div" cssClass="errorText"/>


<hr/>

<%--Make of mobile phone--%>
<label class="inputLabel">Type of mobile *</label>

<div class="select-wrapper arrow">
    <form:select path="mobileMake" title="Type of mobile  *" id="mobileMake" cssClass="mobileInput" tabindex="110"
                 onkeypress="return event.keyCode!=13">
        <form:options items="${enterUserDetailsForm.mobileMakes}"/>
    </form:select>
</div>
<form:errors path="mobileMake" element="div" cssClass="errorText"/>



<%--Email address--%>

<form:input path="alternativeEmail" title="Current email address *" id="emailAddress" cssClass="mobileInput"
            tabindex="120" size="30" maxlength="127" onkeypress="return event.keyCode!=13" alt="Email address *"/>

<form:errors path="alternativeEmail" element="div" cssClass="errorText"/>

<%-- Confirm email address--%>
<form:input path="confirmAlternativeEmail" title="Retype email address*" id="confirmEmail"
            cssClass="mobileInput" tabindex="120" size="30" maxlength="127"
            onkeypress="return event.keyCode!=13" alt="Confirm email *"/>

<form:errors path="confirmAlternativeEmail" element="div" cssClass="errorText"/>

<hr/>


<%--User name--%>

<p>Your username must consist of letters and numbers and can be from 3 to 30 characters long.</p>

<p>If you do not wish to select your own username,
    <a class="hover" href="javascript:void(0)" tabindex="140"
       onclick="javascript:if(UserNamesSuggestionCheck()){uf.getNames();}" title="we can suggest a username">
        we can suggest a username.
    </a>
</p>

<!-- usernameSuggestions div is an AJAX display area -->
<div id="usernameSuggestions"></div>

<form:input path="username" title="User name *" id="username" cssClass="mobileInput" tabindex="130"
            maxlength="30" size="30" alt="Username *"/>

<form:errors path="username" element="div" cssClass="errorText"/>


<hr/>


<%--Password--%>
<p>Your password must be between 6 to 16 characters long.</p>
<form:password path="password" title="Password *" id="password" cssClass="mobileInput" tabindex="150"
               maxlength="16" onkeypress="return event.keyCode!=13" alt="Password *"/>
<form:errors path="password" element="div" cssClass="errorText"/>

<%--Confirm password--%>
<form:password path="confirmPassword" title="Re-type password *" id="confirmPassword" cssClass="mobileInput"
               tabindex="160" maxlength="16" onkeypress="return event.keyCode!=13" alt="Confirm password *"/>
<form:errors path="confirmPassword" element="div" cssClass="errorText"/>


<hr/>


<p>To ensure that your account is protected you need to select and answer
a security question.</p>

<%--Security question--%>


<label>Security question *</label>

<div class="select-wrapper arrow">
    <form:select path="securityQuestion" title="Security question *" id="securityQuestion" cssClass="mobileInput"
                 tabindex="170" onkeypress="return event.keyCode!=13">
        <form:options items="${enterUserDetailsForm.securityQuestions}"/>
    </form:select>
</div>

<form:errors path="securityQuestion" element="div" cssClass="errorText"/>


<%--Security answer--%>
<form:input path="securityAnswer" title="Security answer *" id="securityAnswer" cssClass="mobileInput"
            tabindex="180" size="30" maxlength="50" onkeypress="return event.keyCode!=13" alt="Security answer *"/>
<form:errors path="securityAnswer" element="div" cssClass="errorText"/>


<hr/>

<%--Marketing prefs --%>
<p>Keeping you up to date</p>

<div class="checkboxes">

    <form:checkbox path="wantsO2Marketing" id="wantsO2Marketing" title="Cool Stuff" value="Y" tabindex="190"
                   onkeypress="return event.keyCode!=13"/>
    <label for="wantsO2Marketing" title="O2's newsletters and offers" class="checkbox">
        <span class="marketingLabel">O2's newsletters and offers</span>
    </label>

</div>

<div class="checkboxes">
    <form:checkbox path="wantsOtherMarketing" id="wantsOtherMarketing" title="Our partners' offers and messages"
                   value="Y" tabindex="200" onkeypress="return event.keyCode!=13"/>
    <label for="wantsOtherMarketing" title="Our partners' offers and messages" class="checkbox">
        <span class="marketingLabel"> Our partners' offers and messages</span>
    </label>

</div>

<hr/>

<%--T&C--%>
<div class="infobox">
    <div class="infoheader">Note</div>
    by clicking the 'Continue' button you will be accepting the o2.co.uk
    <a class="hover" tabindex="210" href="http://www.o2.co.uk/termsconditions" title="terms and conditions"
       target="_blank">
        terms and conditions
    </a>


</div>

<%--Continue--%>
<div class="buttonBox">
    <input type="submit" name="Continue" value="Continue"
           title="Continue" class="continueButton"/>
</div>

</form:form>

</div>

</div>

<script language="JavaScript" type="text/javascript">

    resetDateOfBirth();

    var uf = new usernameFinder( document.forms['enterUserDetailsForm'], 'usernameSuggestions' );


    fixRadio();

</script>


</body>

</html>