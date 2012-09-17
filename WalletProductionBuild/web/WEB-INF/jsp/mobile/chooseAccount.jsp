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


    <meta name="keywords" content="O2, 02, o2, product registration, sign in, mobile"/>
    <meta name="description" content="Your mobile number"/>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"/>
    <meta http-equiv="Cache-control" content="no-cache"/>

    <jsp:include page="/WEB-INF/fragments/coreMetrics.jsp"/>

    <!-- Don't display phone numbers as links -->
    <meta name="format-detection" content="telephone=no">


    <%-- Load the theme based on the device --%>
   	<jsp:include page="/WEB-INF/jsp/mobile/fragments/theme.jsp" />

   	
   	<c:url var="mobileUtilsJS" value="/scripts/mobileUtils.js"/>
    <script type="text/javascript" src="<c:out value='${mobileUtilsJS}'/>"></script>

</head>


<body>

<!-- This is chooseAccount (mobile).jsp -->

<!-- coremetrics tpRegistration -->
<div id="cmTPpageID" style="display:none;">O2 Money - Authentication - Confirm Which Portal Account</div>
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

        <div class="icon bang"></div>
        <div class="heading">
            Are you already registered?
        </div>

        <p>
            We've found one or more accounts matching your mobile number <span class="static"><c:out value="${chooseAccountForm.msisdn}"/></span>.
            Please choose one of the accounts from the list below:
        </p>


        <jsp:include page="/WEB-INF/jsp/mobile/fragments/feedback.jsp" flush="true"/>

    </div>

    <div class="content">
        <form:form method="post"
                   commandName="chooseAccountForm"
                   cssClass="txt">
                                                   
                <c:forEach var="friendlyusernamelabelbean" items="${chooseAccountForm.accounts}">     
                   <span class="static">
                   <c:out value="${friendlyusernamelabelbean.friendlyUsername}"/><br/>	        
                   </span>         
                </c:forEach>             
          
            <form:hidden path="account" />
                             
          <!--  <div class="buttonBox">
                <input type="submit" name="requestcode" value="Sign in"
                       title="Sign in" class="content"/>
            </div>
          -->  

        </form:form>
        
        <form action="<reg:ProductRegistrationLoginForMobile/>" method="GET">
        <div class="buttonBox">
                <input type="submit" value="Sign in" title="Sign in" class="content"/>
        </div>
        </form>                  

    </div>
</div>


</body>
</html>