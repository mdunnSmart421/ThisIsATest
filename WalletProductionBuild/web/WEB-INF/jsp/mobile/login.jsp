<%--
  Created by IntelliJ IDEA.
  User: smithd
  Date: 29/10/2011
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>


    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="/WEB-INF/taglib/productRegistration.tld" prefix="reg" %>
    <%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>


    <jsp:useBean id="loginForm" scope="request" class="com.o2.finance.beans.LoginForm" />

    <meta name="viewport" content="width=320; initial-scale=1.0; maximum-scale=1.0; width=device-width"/>


    <!-- Don't display phone numbers as links -->
    <meta name="format-detection" content="telephone=no">


    <!-- make full screen if launched from home page -->
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="apple-mobile-web-app-status-bar-style" content="black"/>

    <meta name="keywords" content="O2, 02, o2, product registration, sign in, mobile"/>
    <meta name="description" content="Login"/>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"/>
    <meta http-equiv="Cache-control" content="no-cache"/>


    <jsp:include page="/WEB-INF/jsp/mobile/fragments/theme.jsp" />

   	<c:url var="mobileUtilsJS" value="/scripts/mobileUtils.js"/>
    <script type="text/javascript" src="<c:out value='${mobileUtilsJS}'/>"></script>

    <title><reg:PageTitle value="${localModel.processName}"/></title>


</head>

<body>

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

    </div>

    <div class="content">

        <form:form method="post" commandName="loginForm"
                   action="<%=loginForm.getLoginURL()%>">

            <form:input path="username" cssClass="mobileInput widthFull" alt="Username *"/>

            <form:password path="password" cssClass="mobileInput widthFull" alt="Password *" />

            <form:hidden path="returnURL" id="destURL" />
            <form:hidden path="failureURL" id="fuUrl" />
            <form:hidden path="skipRedirects" id="skipRedirects" />


        <div class="buttonBox">
            <input type="submit" id="silentLoginsubmit" name="submit" value="Submit" title="submit"
                   onclick="submit"/>
        </div>

        </form:form>

    </div>


</div>



</body>
</html>