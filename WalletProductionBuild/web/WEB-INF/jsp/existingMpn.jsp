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
<jsp:include page="/WEB-INF/fragments/StyleSheets.jsp"/>
<jsp:include page="/WEB-INF/fragments/topNav.jsp"/>
<jsp:include page="/WEB-INF/fragments/leftPanelExistingUserNarrative.jsp"/>





<!-- coremetrics tpRegistration -->
<div id="cmTPpageID" style="display:none;">O2 Money - Authentication - Confirm number for account</div>
<div id="cmTPcatID" style="display:none;">O2 Money - Prepaid Card - Authentication</div>
<div id="contentCol">
<div class="innerContentGrid">

<jsp:include page="/WEB-INF/fragments/processTitle.jsp"/>

<form:form method="post"  
           commandName="enterMpnForm" 
           cssClass="txt">

<div class="bodyText">

        Check/Change my phone number<br /><br />
        <div class="clear eShim6"><div class="shim">&nbsp;</div></div>

        Please check we've got your phone number right. If it's not right, change it below.
        <div class="divSpacer">&nbsp;</div>
</div>

<div class="module6Box noBorder noMargin">

<jsp:include page="/WEB-INF/fragments/Feedback.jsp" flush="true"/>


        <div class="clear eShim6"><div class="shim">&nbsp;</div></div>

        <div class="contentInnerLeft30 w30">
           <label class="esLabelClass" for="msisdn" title="Mobile number stored">Mobile number stored:</label>
        </div>
	<div class="formContainer floatLeft padRight">
	    <form:input path="msisdn" tabindex="20" readonly="true" cssStyle="background-color:#CCCCCC;border: solid 1px #CADDEE;"
	                title="Mobile number" id="msisdn"
	                size="25"/>
	</div>
        <div class="clear eShim6"><div class="shim">&nbsp;</div></div>

	<div class="eButtonContainer eTxRight">
	    <input type="submit" name="requestcode" value="Continue Wallet registration using this number" title="Continue" class="broadbandButton bContinue"
	           onclick="submit" tabindex="40"/>&nbsp;
	</div>
	
        <div class="clear eShim6"><div class="shim">&nbsp;</div></div>


 <div class="module23Box">                
                To update your MyO2 Account with a new number, type your number below and then click Continue (replacing what is currently shown)
                <div class="divSpacer">&nbsp;</div>
        </div>
        <div class="clear eShim6"><div class="shim">&nbsp;</div></div>

		<form:errors path="newMsisdn" cssClass="errorText" element="div"/>
        <div class="contentInnerLeft30 w30">
            <label class="esLabelClass" for="msisdn" title="My new number">My new number:</label>
        </div>
        <div class="formContainer floatLeft padRight">
           <form:input path="newMsisdn" title="Mobile number" onkeypress="return numbersonly(this, event);" size="35" maxlength="11" />
        </div>
        <div class="clear eShim6"><div class="shim">&nbsp;</div></div>

	<div class="eButtonContainer eTxRight">
	    <input type="submit" name="edit" value="Update this MyO2 account with this number & Continue registration" title="Continue" class="broadbandButton bContinue" onclick="submit" tabindex="40"/>&nbsp;
	</div>
       
        <div class="clear eShim6"><div class="shim">&nbsp;</div></div>

</form:form>

</div>
</div>
<jsp:include page="/WEB-INF/fragments/footer.jsp"/>
</div>

