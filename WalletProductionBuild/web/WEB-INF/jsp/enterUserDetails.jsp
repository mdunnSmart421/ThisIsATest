<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<%-- This is enterUserDetails.jsp --%>

  <%@ taglib uri="http://java.sun.com/jstl/core"            prefix="c" %>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
  <%@ taglib uri="/WEB-INF/taglib/productRegistration.tld"  prefix="reg" %>

  <head>
      <title><reg:PageTitle value="${pageTitle}" /></title>
      <meta name="keywords" content="O2, 02, o2, product registration, sign in, mobile" />
      <meta name="description" content="Your mobile number" />
      <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
      <meta http-equiv="Cache-control" content="no-cache"/>

      <jsp:include page="/WEB-INF/fragments/favicon.jsp"/>


    <jsp:include page="/WEB-INF/fragments/coreMetrics.jsp" />

  </head>
  
	<jsp:include page="/WEB-INF/fragments/StyleSheets.jsp" />
	<jsp:include page="/WEB-INF/fragments/topNav.jsp" />
	<jsp:include page="/WEB-INF/fragments/leftPanelClear.jsp" />
	
	<%--<%@page import="com.o2.finance.beans.AddressBean"%>--%>
    <%--<%@page import="com.o2.finance.beans.DateOfBirthBean"%>--%>
    <%--<%@page import="com.o2.finance.beans.GenderBean"%>--%>
    <%--<%@page import="com.o2.finance.beans.StoredUserDetailsBean"%>--%>
	
    <c:url var="usernameFinderJS" value="/scripts/usernameFinder.js"/>
    <c:url var="commonValidationJS" value="/scripts/commonvalidation.js"/>
    <c:url var="commonUtilsJS" value="/scripts/commonUtils.js"/>
    
	<script type="text/javascript" src="<c:out value='${usernameFinderJS}'/>"> </script>
	<script type="text/javascript" src="<c:out value='${commonValidationJS}'/>"> </script>
	<script type="text/javascript" src="<c:out value='${commonUtilsJS}'/>"> </script>
        
                
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

	<jsp:useBean id="enterUserDetailsForm" scope="request" class="com.o2.finance.beans.EnterUserDetailsForm" />
	
	<!-- Start Content -->


<!-- coremetrics tpRegistration -->
<div id="cmTPpageID" style="display:none;">O2 Money - Authentication - Portal Registration</div>
<div id="cmTPcatID" style="display:none;">O2 Money - Prepaid Card - Authentication</div>

        <div id="contentCol">
	<div class="innerContentGrid">

        <jsp:include page="/WEB-INF/fragments/processTitle.jsp"/>
	<!-- End Breadcrumb -->

	
	<div class="module6Box noBorder noMargin">
		<form:form method="post"
		           commandName="enterUserDetailsForm" 
		           id="enterUserDetailsForm" 
		           name="enterUserDetailsForm"
		           onsubmit="disableSubmit()"
		           cssClass="txt">			
			 
     		<hr />
			<div class="clear">
				<div class="shim">&nbsp;</div>
			</div>
			<br />

			<!-- feedback start -->
			<jsp:include page="/WEB-INF/fragments/Feedback.jsp" flush="true" />
			<!-- feedback end -->

			<div class="shim">&nbsp;</div>

			<div>
				Please complete your details below.<br /><br />
				Fields marked with an '*' are mandatory.<br/><br/>
			</div>
			<div class="clear">
				<div class="shim">&nbsp;</div>
			</div>

			<!-- Start Content Personal Details -->
			
			<form:errors path="title" element="div" cssClass="errorText"/>
			<div class="contentInnerLeft30 w24">
				<p class="formLabelClass">
					<label class="esLabelClass" for="in_title" title="Title*">Title*</label>
				</p>
			</div>
			<div class="formContainer floatLeft w77">
				<form:select path="title" tabindex="09" title="Title*" id="in_title" >
					<form:options items="${enterUserDetailsForm.titles}" />
				</form:select>
			</div>
			<div class="clear">
				<div class="shim">&nbsp;</div>
			</div>
			
			
			<form:errors path="forename" element="div" cssClass="errorText"/>
			<div class="contentInnerLeft30 w24">
				<p class="formLabelClass">
					<label class="esLabelClass" for="forename" title="Your first name*">Your first name*</label>
				</p>
			</div>
			<div class="formContainer floatLeft showOverflow">
				<form:input path="forename" title="Your first name*" id="forename" tabindex="10" maxlength="30" size="30" onkeypress="return event.keyCode!=13" />
			</div>
			<div class="floatLeft">
				<div>
					<span class="floatHeight balloon">&nbsp;</span>
					<div class="coloredBox0">
						<p>Use your full name here </p><p>e.g. use Timothy, not Tim&nbsp;&nbsp;</p>
					</div>
					<div class="clear">
						<div class="shim">&nbsp;</div>
					</div>
				</div>
			</div>
			<div class="clear">
				<div class="shim">&nbsp;</div>
			</div>
			
			<form:errors path="lastName" cssClass="errorText" element="div"/>
			<div class="contentInnerLeft30 w24">
				<p class="formLabelClass">
					<label class="esLabelClass" for="lastName" title="Your last name*">Your last name*</label>
				</p>
			</div>
			<div class="formContainer floatLeft w77">
				<form:input path="lastName"   title="Your last name*" id="lastName" tabindex="20" maxlength="30" size="30" onkeypress="return event.keyCode!=13" />
			</div>
			
			<div class="clear">
				<div class="shim">&nbsp;</div>
			</div>

		
			<form:errors path="address.houseNumber" cssClass="errorText" element="div"/>

			<div class="contentInnerLeft30 w24">
				<p class="formLabelClass">
					<label class="esLabelClass" for="address.houseNumber" title="House number">House number<br />(if applicable)</label>
				</p>
			</div>
			<div class="formContainer floatLeft showOverflow">
				<form:input path="address.houseNumber" id="houseNumber" title="House number" tabindex="30" size="10" maxlength="5" onkeypress="return event.keyCode!=13" />&nbsp;&nbsp;<br />
			</div>

			<div class="floatLeft">
				<div>
					<span class="floatHeight balloon">&nbsp;</span>
					<div class="coloredBox0">
						<p>Type in your house number here&nbsp;&nbsp;</p>
					</div>
					<div class="clear">
						<div class="shim">&nbsp;</div>
					</div>
				</div>
			</div>
			<div class="clear">
				<div class="shim">&nbsp;</div>
			</div>
			
			<form:errors path="address.houseName" cssClass="errorText" element="div"/>
			
			<div class="contentInnerLeft30 w24">
				<p class="formLabelClass">
					<label class="esLabelClass" for="address.houseName"	title="Flat number or house name">Flat number or house name<br />(if applicable)</label>
				</p>
			</div>
			
			<div class="formContainer floatLeft showOverflow">
				<form:input path="address.houseName" title="House name*" id="houseName" tabindex="40" maxlength="80" size="30" onkeypress="return event.keyCode!=13" />
			</div>

			<div class="floatLeft">
				<div>
					<span class="floatHeight balloon">&nbsp;</span>
					<div class="coloredBox0">
						<p>Type in your flat, apartment number</p> <p>or house name here &nbsp;&nbsp;</p>
					</div>
					<div class="clear">
						<div class="shim">&nbsp;</div>
					</div>
				</div>
			</div>
			<div class="clear">
				<div class="shim">&nbsp;</div>
			</div>
			<div class="clear">
				<div class="shim">&nbsp;</div>
			</div>
			
			<form:errors path="address.postcode" cssClass="errorText" element="div"/>

			<div class="contentInnerLeft30 w24">
				<p class="formLabelClass">
					<label class="esLabelClass" for="address.postcode" title="Postcode*">Postcode*</label>
				</p>
			</div>
			<div class="contentInnerLeftCol w30 showOverflow">
				<div class="formContainer floatLeft w30">
					<form:input path="address.postcode" id="postcode" title="Postcode*" size="10" tabindex="50" maxlength="10" onkeypress="return event.keyCode!=13" />
				</div>
				<div class="contentInnerLeftCol floatLeft w30">

					<input name="findAddress" type="submit"	class="broadbandButton" id="findAddress" title="Find address" value="Find address" />
				</div>
			</div>


             <form:hidden path="address.addressLine1"  />
             <form:hidden path="address.addressLine2" />
             <form:hidden path="address.townOrCity" />
			
			 <!-- Save a copy of the PAF confirmed address -->
			 <form:hidden path="copyOfPAFConfirmedAddress.addressLine1"  />
             <form:hidden path="copyOfPAFConfirmedAddress.addressLine2" />
             <form:hidden path="copyOfPAFConfirmedAddress.townOrCity" />
             <form:hidden path="copyOfPAFConfirmedAddress.houseNumber"  />
             <form:hidden path="copyOfPAFConfirmedAddress.houseName" />
             <form:hidden path="copyOfPAFConfirmedAddress.postcode" />
             

			<div class="clear">
				<div class="shim">&nbsp;</div>
			</div>
			<div class="contentInnerLeftCol">
				<p>Your current address is:</p>
				<p>


                    <c:if test="${ enterUserDetailsForm.pafAddress }">
                        <strong> <%=enterUserDetailsForm.getAddress().getAddress()%> </strong>
                    </c:if>




				</p>
			</div>
			<div class="displayNone">
				<div id="loadLabel"></div>
				<div class="eShim">
					<div class="shim">&nbsp;</div>
				</div>
			</div>
			<div class="displayNone">
				<div id="resultsLabel"></div>
				<div class="eShim">
					<div class="shim">&nbsp;</div>
				</div>
			</div>

			<div class="clear">
				<div class="shim">&nbsp;</div>
			</div>
			
			
			<form:errors path="gender.gender" cssClass="errorText" element="div"/>
			<div class="contentInnerLeft30 w24">
				<p class="radioPadding" title="Gender*">Gender*</p>
			</div>
			<div class="formContainer floatLeft w77">
				<div class="floatLeft checkboxPadding">
					<form:radiobutton  path="gender.gender"  title="Male" id="male" value="M" tabindex="60" onkeypress="return event.keyCode!=13" />
				</div>
				<div class="floatLeft checkboxPadding">
					<label for="genderMale" title="Male">Male</label>
					&nbsp;&nbsp;&nbsp;&nbsp;
				</div>
				<div class="floatLeft checkboxPadding">
					<form:radiobutton path="gender.gender" title="Female" id="female" value="F" tabindex="70" onkeypress="return event.keyCode!=13" />
				</div>
				<div class="floatLeft checkboxPadding">
					<label for="genderfemale" title="Female">Female</label>
				</div>
			</div>
			<div class="clear">
				<div class="shim">&nbsp;</div>
			</div>
			
			<form:errors path="dateOfBirth.birthDay" cssClass="errorText" element="div"/>
			<form:errors path="dateOfBirth.birthMonth" cssClass="errorText" element="div"/>
			<form:errors path="dateOfBirth.birthYear" cssClass="errorText" element="div"/>
			
			<div class="contentInnerLeft30 w24">
				<p class="formLabelClass">
					<label class="esLabelClass" for="dateOfBirth.birthDay" title="Date of Birth*">Date of birth*</label>
				</p>
			</div>
			<div class="formContainer floatLeft w77">
				<form:input path="dateOfBirth.birthDay" id="birthDay" title="birthDay" tabindex="80" size="2" maxlength="2" onfocus="resetDD(this)" onkeypress="return event.keyCode!=13" />
				<form:select path="dateOfBirth.birthMonth" id="birthMonth" title="Date of Birth - Month" tabindex="90" onkeypress="return event.keyCode!=13">		
					  	<form:options items="${enterUserDetailsForm.months}" />	
				</form:select> 
				<form:input path="dateOfBirth.birthYear" id="birthYear" title="Year" tabindex="100" size="4" maxlength="4" onfocus="resetYYYY(this)" onkeypress="return event.keyCode!=13" />
			</div>
			<div class="clear">
				<div class="shim">&nbsp;</div>
			</div>
			<div class="contentInnerLeft30 w24">
				<div class="formLabelClass">
					<p class="formLabelClass">
						<label class="esLabelClass" title="Mobile number">Mobile number</label>
					</p>
				</div>
			</div>
			<div class="formContainer floatLeft w77">
				<p class="formLabelClass">
				    <%= enterUserDetailsForm.getStoredUserDetailsBean().getStoredMsisdn() %>
				</p>
			</div>
			<div class="clear">
				<div class="shim">&nbsp;</div>
			</div>
                        
                        <form:errors path="mobileMake" cssClass="errorText" element="div"/>
                        <div class="contentInnerLeft30 w24">
                                <div class="formLabelClass">
                                        <label class="esLabelClass" for="mobileMake" title="Type of mobile*">Type of mobile*</label>
                                </div>
                        </div>
                        <div class="formContainer floatLeft w77">
                                <form:select path="mobileMake"  title="Type of mobile*" id="mobileMake" tabindex="110" onkeypress="return event.keyCode!=13">
                                        <form:options items="${enterUserDetailsForm.mobileMakes}"  />
                                </form:select>
                        </div>
			
	        <div class="clear"><div class="shim">&nbsp;</div></div>
                        <form:errors path="alternativeEmail" cssClass="errorText" element="div"/>
			<div class="contentInnerLeft30 w24">
				<p class="formLabelClass">
					<label class="esLabelClass" for="alternativeEmail" title="Current email address*">Current email address*</label>
				</p>
			</div>
			

			<div class="formContainer floatLeft showOverflow">
				<form:input path="alternativeEmail" title="Current email address*" id="emailAddress" tabindex="120" size="30" maxlength="127" onkeypress="return event.keyCode!=13" />&nbsp;&nbsp;
			</div>
			<div class="clear">
				<div class="shim">&nbsp;</div>
			</div>			

			<form:errors path="confirmAlternativeEmail" cssClass="errorText" element="div"/>

			<div class="contentInnerLeft30 w24">
				<p class="formLabelClass">
					<label class="esLabelClass" for="confirmAlternativeEmail" title="Retype email address*">Retype email address*</label>
				</p>
			</div>
			
			<div class="formContainer floatLeft showOverflow">
				<form:input path="confirmAlternativeEmail"   title="Retype email address*" id="confirmEmail" tabindex="120" size="30" maxlength="127" onkeypress="return event.keyCode!=13" />&nbsp;&nbsp;
			</div>
			<div class="clear">
				<div class="shim">&nbsp;</div>
			</div>
			<div class="clear">
				<div class="shim">&nbsp;</div>
			</div>

			<!-- End Content Personal Details -->

			<!-- Start Content Username and Password Details -->
			<div class="coloredBox0 w99">
				Your username must consist of letters and numbers and can be from 3
				to 30 characters long.<br /> <strong>Possible suggestions
					for a username could be:</strong><br />
				<p class="listDot">use underscore &quot;_&quot; or hyphen
					&quot;-&quot; between your names</p>
				<p class="listDot">include your initials or your nickname</p>
				<p class="listDot">reverse your surname and first name</p>
				<p class="listDot">to use the name of a favourite pet, footie
					team, house, school, street or town in combination with a number
					such as your date of birth, house number or mobile number</p>
				<script type="text/javascript">
				<!--
					document.write("<br/>If you do not wish to select your own username, we can suggest one for you by clicking 'Suggest a username for me'");
				-->
				</script>
			</div>
			<div class="clear">
				<div class="shim">&nbsp;</div>
			</div>

			<div class="clear">
				<div class="shim">&nbsp;</div>
			</div>

			<div class="eShim">
				<div class="shim">&nbsp;</div>
			</div>
			<div class="displayNone">
				<div id="loadLabel"></div>
				<div class="eShim">
					<div class="shim">&nbsp;</div>
				</div>
			</div>
			<div class="displayNone">
				<div id="resultsLabel"></div>

				<div class="eShim">
					<div class="shim">&nbsp;</div>
				</div>
			</div>

			<!-- usernameSuggestions div is an AJAX display area -->
			<div id="usernameSuggestions"></div>

			<form:errors path="username" cssClass="errorText" element="div"/>
			<div class="contentInnerLeft30 w24">
				<p class="formLabelClass">
					<label class="esLabelClass" for="username" title="User name*">User name*</label>
				</p>
			</div>
			<div class="formContainer floatLeft w77">
				<form:input path="username"  title="User name*" id="username" tabindex="130" maxlength="30" size="30" /> &nbsp;&nbsp;
				<div class="divRelativeInline">
					<!-- username suggestion for script aware only -->
					<script type="text/javascript">
						<!--
						document.write('<a class=\"hover\" href=\"javascript:void(0)\" tabindex=\"140\" onclick=\"javascript:if(UserNamesSuggestionCheck()){uf.getNames();}\" title=\"Suggest a username for me\">Suggest a username for me</a><br/>');
						-->
					</script>
				</div>
			</div>
			<div class="clear">
				<div class="shim">&nbsp;</div>
			</div>

			<form:errors path="password" cssClass="errorText" element="div"/>
			<div class="contentInnerLeft30 w24">
				<p class="formLabelClass">
					<label class="esLabelClass" for="password" title="Password*">Password*</label>
				</p>
			</div>
			<div class="formContainer floatLeft showOverflow">
				<form:password path="password" title="Password*" id="password" tabindex="150" maxlength="16" onkeypress="return event.keyCode!=13" />&nbsp;&nbsp;
			</div>

			<div class="floatLeft">
				<div>
					<span class="floatHeight balloon">&nbsp;</span>
					<div class="coloredBox0">
						<p>Between 6 to 16 characters long &nbsp;&nbsp;</p>
					</div>
					<div class="clear">
						<div class="shim">&nbsp;</div>
					</div>
				</div>
			</div>
			<div class="clear">
				<div class="shim">&nbsp;</div>
			</div>
			
			<form:errors path="confirmPassword" cssClass="errorText" element="div"/>
			<div class="contentInnerLeft30 w24">
				<p class="formLabelClass">
					<label class="esLabelClass" for="confirmPassword" title="Re-type password*">Re-type password*</label>
				</p>
			</div>
			<div class="formContainer floatLeft w77">
				<form:password path="confirmPassword" title="Re-type password*" id="confirmPassword" tabindex="160" maxlength="16" onkeypress="return event.keyCode!=13" />
			</div>
			<div class="clear">
				<div class="shim">&nbsp;</div>
			</div>
			
			<form:errors path="securityQuestion" cssClass="errorText" element="div"/>
			<div class="contentInnerLeft30 w24">
				<p class="formLabelClass">
					<label class="esLabelClass" for="securityQuestion" title="Security question*">Security question*</label>
				</p>
			</div>
			<div class="formContainer floatLeft showOverflow">
				<form:select path="securityQuestion" title="Security question*" id="securityQuestion" tabindex="170" onkeypress="return event.keyCode!=13">				
				 	<form:options items="${enterUserDetailsForm.securityQuestions}"/>
				 </form:select>
			</div>
			<div class="clear">
				<div class="shim">&nbsp;</div>
			</div>
			
			<form:errors path="securityAnswer" cssClass="errorText" element="div"/>
			<div class="contentInnerLeft30 w24">
				<p class="formLabelClass">
					<label id="securityAnswer" for="securityAnswer" title="Security answer*">&nbsp;&nbsp;&nbsp;Security answer* </label>
				</p>
			</div>
			<div class="formContainer floatLeft showOverflow">
				<form:input path="securityAnswer" title="Security answer*" id="securityAnswer" tabindex="180" size="30" maxlength="50" onkeypress="return event.keyCode!=13" />&nbsp;&nbsp;
			</div>
			<div class="floatLeft">
				<div>
					<span class="floatHeight balloon">&nbsp;</span>
					<div class="coloredBox0">
						<p>For security purposes if you contact customer care &nbsp;&nbsp;</p>
					</div>
					<div class="clear">
						<div class="shim">&nbsp;</div>
					</div>
				</div>
			</div>

			<!-- End Content Username and Password Details -->

			<div class="clear">
				<div class="shim">&nbsp;</div>
			</div>

			<br /> <strong>Marketing preferences</strong><br />
			<br />
			<div class="esLabelClass">
				<div class="floatLeft">
					<form:checkbox path="wantsO2Marketing" id="wantsO2Marketing" title="Cool Stuff" value="Y" tabindex="190" onkeypress="return event.keyCode!=13" />
				</div>
				<div class="floatLeft checkboxPadding w90">
					<label for="in_wantsO2Marketing" title="Send me cool O2 stuff">
						Send me cool O2 stuff, e.g. newsletters, free offers, games, latest
						mobile offers.
					</label>
				</div>
			</div>
			<div class="clear">
				<div class="shim">&nbsp;</div>
			</div>
			<div class="eShim">
				<div class="shim">&nbsp;</div>
			</div>
			<div class="esLabelClass">
				<div class="floatLeft">
					<form:checkbox path="wantsOtherMarketing" id="wantsOtherMarketing" title="Be the first to hear about O2 partner offers" value="Y" tabindex="200"	onkeypress="return event.keyCode!=13" />
				</div>
				<div class="floatLeft checkboxPadding w90">
					<label for="in_wantsOtherMarketing"
						title="Be the first to hear about O2 partner offers">
						Be the first to hear about O2 partner offers, messages, competitions,
						free offers
					</label>
				</div>
			</div>
			<div class="clear">
				<div class="shim">&nbsp;</div>
			</div>
			<div class="eShim">
				<div class="shim">&nbsp;</div>
			</div>
			If you wish to receive these please tick the box. You can opt out
			anytime in the future.
			<div class="eShim">
				<div class="shim">&nbsp;</div>
			</div>

			<!-- Start Content Button Section -->

			<strong>Note, by clicking the 'continue' button you will be
				accepting our <a class="hover" tabindex="210"
				href="http://www.o2.co.uk/termsconditions"
				title="terms and conditions" target="_blank">terms and
					conditions</a>. </strong>
			<div class="eShim">
				<div class="shim">&nbsp;</div>
			</div>
			<br />
			<div class="eButtonContainer allTxtRight">
				<div id="cancelHolder">
					<reg:ProductRegistrationCancel />
				</div>
				<div id="continueHolder">
					<input name="submit" type="submit" class="broadbandButton" id="submit" title="Continue" tabindex="220" value="Continue" />&nbsp;&nbsp;
				</div>
			</div>
		

	<!-- End Content Button Section -->
	
	<div class="clear">
		<div class="shim">&nbsp;</div>
	</div>
	
	<br />
	<br />


	<!-- End Content -->
	
	
	</form:form>

    <script language="JavaScript" type="text/javascript">
		var uf = new usernameFinder(document.forms['enterUserDetailsForm'],'usernameSuggestions');
	</script>
        
   </div>
   </div>
        <jsp:include page="/WEB-INF/fragments/footer.jsp" />
   </div>