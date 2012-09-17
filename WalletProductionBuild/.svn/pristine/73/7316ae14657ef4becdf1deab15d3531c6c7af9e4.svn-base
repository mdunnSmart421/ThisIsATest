<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
  <%@ taglib uri="http://java.sun.com/jstl/core"            prefix="c" %>
  <%@ taglib uri="/WEB-INF/taglib/productRegistration.tld"  prefix="reg" %>

  <head>
      <title><reg:PageTitle value="${pageTitle}" /></title>
      <meta name="keywords" content="O2, 02, o2, product registration, sign in, mobile" />
      <meta name="description" content="Your mobile number" />
      <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
      <meta http-equiv="Cache-control" content="no-cache"/>

      <jsp:include page="/WEB-INF/fragments/favicon.jsp"/>


      <jsp:include page="/WEB-INF/fragments/coreMetrics.jsp" />

    <style type="text/css">
    
	.confirmDetailsContent 
	{
	    float: left;
	    font-family: arial,helvetica,clean,sans-serif;
	    font-size: 1.75em;
	    margin: 0;
	    padding: 0;
	}

        .confirmDetailsButtons 
        {
            font-family: arial,helvetica,clean,sans-serif;
            font-size: 1.22em;
        }

        .confirmDetailsTxt
        {
            font: 1.22em arial,helvetica,clean,sans-serif;
            font-weight:bold;
            color: #666666;
        }

        .confirmDetailsNarrativeTxt
        {
            font: 1.22em arial,helvetica,clean,sans-serif;
            font-weight:bold;
            color: #004999;
        }

        .confirmDetailsCopyTextBox 
        {
            border: 0.4em solid #004999;
	    margin: 0 0 2em 0.5em;
	    padding: 1em 1em 0;
            background: none;
            float: left;
            position: relative;
            width: 35%;
            min-height: 30em;
        }
            
        .confirmDetailsTextBox 
        {
            border: 0.4em solid #004999;
            margin: 0 0.5em 2em 0;
            padding: 1em 1em 0;
            background: none;
            float: right;
            position: relative;
            width: 57%;
            min-height: 30em;
        }
        
        .paraPadding
		{
			padding: 0em 0em 0.5em 0.1em;
		}
    </style>
  </head>

    <jsp:include page="/WEB-INF/fragments/StyleSheets.jsp" />
    <jsp:include page="/WEB-INF/fragments/topNav.jsp"/>

    <jsp:useBean id="postPayDivClass" scope="request" class="java.lang.String"/>

<!-- coremetrics tpRegistration -->
<div id="cmTPpageID" style="display:none;">O2 Money - Authentication - Portal details Confirmation</div>
<div id="cmTPcatID" style="display:none;">O2 Money - Prepaid Card - Authentication</div>

    <script type="text/javascript" src="<%= request.getContextPath() %>/ProductReg/scripts/commonvalidation.js"></script>
    <script language="JavaScript" src="https://view.atdmt.com/jaction/zo2tbl_O2MoneyAuthenticationPortaldetailsConfi_1"></script>
    <noscript>
        <iframe src="https://view.atdmt.com/iaction/zo2tbl_O2MoneyAuthenticationPortaldetailsConfi_1" 
                width="1" 
                height="1" 
                frameborder="0" 
                scrolling="no" 
                marginheight="0" 
                marginwidth="0">
        </iframe>
    </noscript>

    <div class="innerContentGrid">

    <div class="confirmDetailsContent">

      <jsp:include page="/WEB-INF/fragments/processTitle.jsp"/>

      Hello <c:out value="${updateUserDetailsForm.forename}"/> - Nearly there. 
      It won't take too long as we'll use the information that you've already given us.
    </div>
    
    <div class="clear eShim6"><div class="shim">&nbsp;</div></div>
    <div class="clear eShim6"><div class="shim">&nbsp;</div></div>

    <jsp:include page="/WEB-INF/fragments/Feedback.jsp" flush="true"/>

    <div>
    <div class="confirmDetailsCopyTextBox">
                
        <div class="confirmDetailsNarrativeTxt">
            It's important that we have the right details for you so
            check that everything is correct.  Use 'Edit' to make any
            changes or click 'Continue' to complete your
            <c:out value="${sessionScope.product.productTitle}"/>
            application.
        </div>
        </br>
        <c:out value="${sessionScope.product.productCopy}" escapeXml="false"/>
                
    </div>
    <div class="confirmDetailsTextBox">
        <h2 class="eHead3">
            My O2 details
        </h2>
        <div class="confirmDetailsTxt">
            <c:out value="${updateUserDetailsForm.title}"/>
            <c:out value="${updateUserDetailsForm.forename}"/>
            <c:out value="${updateUserDetailsForm.lastName}"/>
        </div>
        <div class="confirmDetailsTxt">
            <c:out value="${updateUserDetailsForm.address.address}"/>
        </div>
        <div class="confirmDetailsTxt">
            <c:out value="${updateUserDetailsForm.mobileNumber}"/>
        </div>
        <div class="confirmDetailsTxt">
            <c:out value="${updateUserDetailsForm.alternativeEmail}"/>
        </div>
        <div class="confirmDetailsTxt">            
            <c:out value="${updateUserDetailsForm.dateOfBirth.dateOfBirth}"/>
        </div>
                
        <div class="clear eShim6"><div class="shim">&nbsp;</div></div>
        
    </div>
    <div class="clear"><div class="shim">&nbsp;</div></div>
    <div class="clear"><div class="shim">&nbsp;</div></div>
    <div class="clear"><div class="shim">&nbsp;</div></div>
    </div>
      <form:form method="post" 
                 commandName="updateUserDetailsForm">
    
        <form:hidden path="title" />
        <form:hidden path="forename" />
        <form:hidden path="lastName" />
        <form:hidden path="gender.gender" />
        <form:hidden path="dateOfBirth.birthDay" />
        <form:hidden path="dateOfBirth.birthMonth" />
        <form:hidden path="dateOfBirth.birthYear" />
        <form:hidden path="mobileNumber" />
        <form:hidden path="address.houseNumber" />
        <form:hidden path="address.houseName" />
        <form:hidden path="address.postcode" />
        <form:hidden path="alternativeEmail" />
        
        <div class="clear"><div class="shim">&nbsp;</div></div>
        
        <div class="confirmDetailsButtons">
        <div class="eButtonContainer allTxtRight">
            <div class="allTxtRight" id="continueHolderB">
                <input name="continueConfirm" type="submit" class="broadbandButton marginRight5" id="submit" title="Continue" value="Continue" />
            </div>
            <div class="allTxtRight" id="editHolder">
                <input name="edit" type="submit" class="broadbandButton marginRight5" id="submit" title="Edit" value="Edit" />
            </div>
            <div class="allTxtRight" id="cancelHolderB">
                <reg:ProductRegistrationCancel />
            </div>
        </div>
        </div>
        <div class="clear"><div class="shim">&nbsp;</div></div>
    </form:form>
    <jsp:include page="/WEB-INF/fragments/footer.jsp"/>
    </div>

