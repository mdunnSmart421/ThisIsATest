<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ taglib uri="http://java.sun.com/jstl/core"            prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/WEB-INF/taglib/productRegistration.tld"  prefix="reg" %>

<head>
    <title><reg:PageTitle value="${localModel.processName}" /></title>
    <meta name="keywords" content="O2, 02, o2, product registration, sign in, mobile" />
    <meta name="description" content="Your mobile number" />
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
    <meta http-equiv="Cache-control" content="no-cache"/>
    <jsp:include page="/WEB-INF/fragments/favicon.jsp"/>

     <jsp:include page="/WEB-INF/fragments/coreMetrics.jsp" />

</head>
<jsp:include page="/WEB-INF/fragments/StyleSheets.jsp" />
<jsp:include page="/WEB-INF/fragments/topNav.jsp"/>
<jsp:include page="/WEB-INF/fragments/leftPanelClear.jsp"/>

<jsp:useBean id="postPayDivClass" scope="request" class="java.lang.String"/>


<!-- coremetrics tpRegistration -->
<div id="cmTPpageID" style="display:none;">O2 Money - Authentication - Portal details Confirmation</div>
<div id="cmTPcatID" style="display:none;">O2 Money - Prepaid Card - Authentication</div>

<div id="contentCol">
<div class="innerContentGrid">

<jsp:include page="/WEB-INF/fragments/processTitle.jsp"/>
<div class="bodyHdr03Text">
    <h3 class="eHead3">
        It's important that we have the right details for you so check that everything is correct.  Use 'Edit' to make
        any changes or click 'Continue' to complete your <c:out value="${sessionScope.product.productTitle}"/> application.
    </h3>
</div>

<div class="module6Box noBorder noMargin">
	
<form:form method="post" 
           commandName="updateUserDetailsForm"
           cssClass="txt">
	<hr/>
	<div class="clear"><div class="shim">&nbsp;</div></div>
	<br />	
	
	<jsp:include page="/WEB-INF/fragments/Feedback.jsp" flush="true"/>
	
	<p>Fields marked with an '*' are mandatory.</P>
	<br/>
	
	<br class="clear"/>
	<div class="clear"><div class="shim">&nbsp;</div></div>
	
	<form:errors path="title" cssClass="errorText" element="div"/>
	<div class="contentInnerLeft30 w24">
	    <p class="formLabelClass">
	        <label class="esLabelClass" for="title" title="Title*">Title*</label>
	    </p>
	</div>
	<div class="formContainer floatLeft showOverflow">
	    <form:select path="title" items="${updateUserDetailsForm.titles}" tabindex="09" title="Title*"/>
	</div>
	<div class="clear"><div class="shim">&nbsp;</div></div>
	<div class="clear"><div class="shim">&nbsp;</div></div>
	
	<form:errors path="forename" cssClass="errorText" element="div"/>
	<div class="contentInnerLeft30 w24">
	    <p class="formLabelClass">
	        <label class="esLabelClass" for="forename" title="Your first name*">Your first name*</label>
	    </p>
	</div>
	<div class="formContainer floatLeft showOverflow">
	   <c:choose>
	      <c:when test="${editable.forename}">
	          <form:input path="forename" title="Your first name*" id="forename" tabindex="10"  maxlength="30" size="30" onkeypress="return event.keyCode!=13"/>
	      </c:when>
	      <c:otherwise>
	     <form:hidden path="forename" />
	     <p class="formLabelClass">
	            <c:out value="${updateUserDetailsForm.forename}"/>
	     </p>
	      </c:otherwise>
	   </c:choose>
	</div>
	<div class="floatLeft">
	    <div>
	        <span class="floatHeight balloon">&nbsp;</span>
	        <div class="coloredBox0">
	            <p>Use your full name here </p><p>e.g. use Timothy, not Tim</p>
	        </div>
	        <div class="clear"><div class="shim">&nbsp;</div></div>
	    </div>
	</div>
	<div class="clear"><div class="shim">&nbsp;</div></div>
	<div class="clear"><div class="shim">&nbsp;</div></div>
	
	<form:errors path="lastName" cssClass="errorText" element="div"/>
	<div class="contentInnerLeft30 w24">
	    <p class="formLabelClass">
	        <label class="esLabelClass" for="lastName" title="Your last name*">Your last name*</label>
	    </p>
	</div>
	<div class="formContainer floatLeft  <%= postPayDivClass %>">
	   <c:choose>
	      <c:when test="${editable.lastName}">
	          <form:input path="lastName" title="Your last name*"  id="lastname" tabindex="20"  maxlength="30" size="30" onkeypress="return event.keyCode!=13"/>
	      </c:when>
	      <c:otherwise>
	           <form:hidden path="lastName" />
	           <p class="formLabelClass">
	              <c:out value="${updateUserDetailsForm.lastName}"/>
	           </p>
	      </c:otherwise>
	   </c:choose>
	</div>
	<div class="clear"><div class="shim">&nbsp;</div></div>
	<div class="clear"><div class="shim">&nbsp;</div></div>
	
	<form:errors path="gender.gender" cssClass="errorText" element="div"/>
	<div class="contentInnerLeft30 w24">
	    <p class="radioPadding" title="Gender*">Gender*</p>
	</div>
	<div class="formContainer floatLeft  <%= postPayDivClass %>">
	   <c:choose>
	      <c:when test="${editable.gender}">
	        <div class="floatLeft checkboxPadding">
	           <form:radiobutton 
	                 path="gender.gender"
	                 tabindex="30" onkeypress="return event.keyCode!=13"
	                 value="M"/>
	        </div>
	        <div class="floatLeft checkboxPadding">
	            <label for="gender.gender" title="Male">Male</label>
	            &nbsp;&nbsp;&nbsp;&nbsp;
	        </div>
	        <div class="floatLeft checkboxPadding">
	           <form:radiobutton 
	                 path="gender.gender"
	                 tabindex="30" onkeypress="return event.keyCode!=13"
	                 value="F"/>
	        </div>
	        <div class="floatLeft checkboxPadding">
	            <label for="gender.gender" title="Male">Female</label>
	        </div>
	      </c:when>
	      <c:otherwise>
	        <form:hidden path="gender.gender" />
	        <p class="formLabelClass">
	            <c:out value="${updateUserDetailsForm.gender.genderText}"/>
	        </p>
	      </c:otherwise>
	   </c:choose>
	</div>
	<div class="clear"><div class="shim">&nbsp;</div></div>
	
	<form:errors path="dateOfBirth.birthDay" cssClass="errorText" element="div"/>
	<form:errors path="dateOfBirth.birthMonth" cssClass="errorText" element="div"/>
	<form:errors path="dateOfBirth.birthYear" cssClass="errorText" element="div"/>
	<div class="contentInnerLeft30 w24">
	    <p class="formLabelClass">
	       <label class="esLabelClass" for="dateOfBirth.birthDay" title="Date of Birth*">Date of birth*</label>
	    </p>
	</div>
	<div class="formContainer floatLeft  <%= postPayDivClass %>">
	   <c:choose>
	      <c:when test="${editable.dateOfBirth}">
	        <form:input  path="dateOfBirth.birthDay" title="Birthday"  tabindex="50" onkeypress="return event.keyCode!=13" size="2" maxlength="2" />
	        <form:select path="dateOfBirth.birthMonth" items="${updateUserDetailsForm.months}" title="Date of birth - Month" tabindex="60" onkeypress="return event.keyCode!=13"/>
	        <form:input path="dateOfBirth.birthYear" title="Year" tabindex="70" onkeypress="return event.keyCode!=13" size="4" maxlength="4" />
	      </c:when>
	      <c:otherwise>
	        <form:hidden  path="dateOfBirth.birthDay" />
	        <form:hidden path="dateOfBirth.birthMonth"  />
	        <form:hidden path="dateOfBirth.birthYear"  />
	        <p class="formLabelClass">
	           <c:out value="${updateUserDetailsForm.dateOfBirth.dateOfBirth}"/>
	        </p>
	      </c:otherwise>
	   </c:choose>
	</div>
	<div class="clear"><div class="shim">&nbsp;</div></div>
	<div class="clear"><div class="shim">&nbsp;</div></div>
	
	<div class="contentInnerLeft30 w24">
	    <div class="formLabelClass">
	        <p class="formLabelClass">
	            <label class="esLabelClass" title="Mobile number">Mobile number</label>
	        </p>
	    </div>
	</div>
	<div class="formContainer floatLeft w77">
	    <c:out value="${storedUserDetails.storedMsisdn}"/>
	</div>
	<div class="clear"><div class="shim">&nbsp;</div></div>
	<div class="clear"><div class="shim">&nbsp;</div></div>
	
        <form:errors path="mobileMake" cssClass="errorText" element="div"/>
        <div class="contentInnerLeft30 w24">
          <div class="formLabelClass">
             <label class="esLabelClass" for="mobileMake" title="Type of mobile*">Type of mobile*</label>
          </div>
        </div>
        <div class="formContainer floatLeft w77">
          <form:select path="mobileMake" items="${updateUserDetailsForm.mobileMakes}" 
                       title="Type of mobile" tabindex="80" onkeypress="return event.keyCode!=13"/>
        </div>
        <div class="clear"><div class="shim">&nbsp;</div></div>
        <div class="clear"><div class="shim">&nbsp;</div></div>
        
    <c:set var="houseNumErrors"><form:errors path="address.houseNumber"/></c:set>
	<c:set var="houseNameErrors"><form:errors path="address.houseName"/></c:set>
	<c:set var="postcodeErrors"><form:errors path="address.postcode"/></c:set>

	<div class="contentInnerLeftCol">
	    <p>Your current address is:</p>
	    <c:choose>
	    	<c:when test="${ ( empty houseNumErrors ) && ( empty houseNameErrors ) && ( empty postcodeErrors ) }">
	    		<p><strong><c:out value="${updateUserDetailsForm.address.address}"/></strong></p>	
	    	</c:when>
	    	<c:otherwise>
	    		<p>&nbsp;</p>
	    	</c:otherwise>	    	
	    </c:choose>
	    <%-- 
	    <c:if test="${ ( empty houseNumErrors ) && ( empty houseNameErrors ) && ( empty postcodeErrors ) }">
	    	<p><strong><c:out value="${updateUserDetailsForm.address.address}"/></strong></p>
	    </c:if>	   
	    --%> 
	</div>
	<div class="clear"><div class="shim">&nbsp;</div></div>
	<div class="clear"><div class="shim">&nbsp;</div></div>
	
	
	
	<div class="coloredBox0 w85">
	    <p>Address not right?</p>	    
	    <p>Type in your details and click on Find address.<br/></p>	   
	</div>
	<div class="clear"><div class="shim">&nbsp;</div></div>
	<div class="clear"><div class="shim">&nbsp;</div></div>
	<div class="eShim"><div class="shim">&nbsp;</div></div>
	
	<form:errors path="address.houseNumber" cssClass="errorText" element="div"/>
	<div class="contentInnerLeft30 w24">
	    <p class="formLabelClass">
	        <label class="esLabelClass" for="address.houseNumber" title="House number">House number<br />(if applicable)</label>
	    </p>
	</div>
	<div class="formContainer floatLeft showOverflow">
	    <form:input path="address.houseNumber" tabindex="80" id="houseNumber" title="House number" size="10" maxlength="5" onkeypress="return event.keyCode!=13" />&nbsp;&nbsp;<br />
	</div>
	<div class="floatLeft">
	    <div>
	        <span class="floatHeight balloon">&nbsp;</span>
	        <div class="coloredBox0">
	            <p>Type in your house number here</p>
	        </div>
	    </div>
	</div>
	<div class="clear"><div class="shim">&nbsp;</div></div>
	<div class="clear"><div class="shim">&nbsp;</div></div>
	
	<form:errors path="address.houseName" cssClass="errorText" element="div"/>
	<div class="contentInnerLeft30 w24">
	    <p class="formLabelClass">
	        <label class="esLabelClass" for="address.houseName" title="Flat number or house name">Flat number or house name<br />(if applicable)</label>
	    </p>
	</div>
	<div class="formContainer floatLeft showOverflow">
	    <form:input path="address.houseName" tabindex="90" title="Flat number or house name"  id="in_houseName"  maxlength="80" size="30" onkeypress="return event.keyCode!=13" />
	</div>
	<div class="floatLeft">
	    <div>
	        <span class="floatHeight balloon">&nbsp;</span>
	        <div class="coloredBox0">
	            <p>Type in your flat, apartment number</p> <p>or house name here</p>
	        </div>
	        <div class="clear"><div class="shim">&nbsp;</div></div>
	    </div>
	</div>
	<div class="clear"><div class="shim">&nbsp;</div></div>
	<div class="clear"><div class="shim">&nbsp;</div></div>
	
	<form:errors path="address.postcode" cssClass="errorText" element="div"/>
	<div class="contentInnerLeft30 w24">
	   <p class="formLabelClass">
	       <label class="esLabelClass" for="address.postcode" title="Postcode*">Postcode*</label>
	   </p>
	</div>
	<div class="contentInnerLeftCol w30 showOverflow">
	   <div class="formContainer floatLeft w30">
	       <form:input path="address.postcode" tabindex="100" id="postcode" title="Postcode*" size="10" maxlength="10" onkeypress="return event.keyCode!=13" />
	   </div>
	   <div class="contentInnerLeftCol floatLeft w30">
	       <input name="findAddress" 
	              type="submit" 
	              class="broadbandButton" 
	              title="Find address" 
	              value="Find address" />
	   </div>
	</div>
	<div class="clear"><div class="shim">&nbsp;</div></div>
	<div class="clear"><div class="shim">&nbsp;</div></div>
	
	<form:errors path="alternativeEmail" cssClass="errorText" element="div"/>
	<div class="contentInnerLeft30 w24">
	    <p class="formLabelClass">
	        <label class="esLabelClass" for="alternativeEmail" title="Current email address">Current email address*</label>
	    </p>
	</div>
	
	<div class="formContainer floatLeft  <%= postPayDivClass %>">
	    <form:input path="alternativeEmail" tabindex="110" title="Current email address"  id="alternativeEmail" size="30" maxlength="127" onkeypress="return event.keyCode!=13" />&nbsp;&nbsp;
	</div>
	
	<div class="clear"><div class="shim">&nbsp;</div></div>
	<div class="eShim"><div class="shim">&nbsp;</div></div>
	<br />
	
	<div class="eButtonContainer allTxtRight">
	    <div class="allTxtRight" id="continueHolderA">
	        <input tabindex="150" name="continueUpdate" type="submit" class="broadbandButton marginRight5" title="Continue" value="Continue" />&nbsp;&nbsp;
	    </div>
	    <div class="allTxtRight" id="cancelHolderA">
	        <reg:ProductRegistrationCancel />
	    </div>
	</div>
	
</form:form>
</div>
</div>  
<jsp:include page="/WEB-INF/fragments/footer.jsp"/>
</div>