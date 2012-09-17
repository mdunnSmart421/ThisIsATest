<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jstl/core"            prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/WEB-INF/taglib/productRegistration.tld"  prefix="reg" %>

<head>
    <title><reg:PageTitle value="${localModel.processName}" /></title>
    <meta name="keywords" content="O2, 02, o2, product registration, sign in, mobile" />
    <meta name="description" content="Your mobile number" />
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
    <meta http-equiv="Cache-control" content="no-cache">

    <jsp:include page="/WEB-INF/fragments/favicon.jsp"/>

    <jsp:include page="/WEB-INF/fragments/coreMetrics.jsp" />

</head>
<jsp:include page="/WEB-INF/fragments/StyleSheets.jsp" />
<jsp:include page="/WEB-INF/fragments/topNav.jsp"/>
<jsp:include page="/WEB-INF/fragments/leftPanelClear.jsp"/>

<%-- This is enterOtac.jsp --%>


<!-- coremetrics tpRegistration -->
<div id="cmTPpageID" style="display:none;">O2 Money - Authentication - Mobile Verification</div>
<div id="cmTPcatID" style="display:none;">O2 Money - Prepaid Card - Authentication</div>

<div id="contentCol">
<div class="innerContentGrid">

<jsp:include page="/WEB-INF/fragments/processTitle.jsp"/>

<div class="bodyHdr03Text">
    <h2 class="eHead3">
        Verification
    </h2>
</div>
<div class="horizRuler"><hr/></div>
<div class="divSpacer"></div>

<div class="module6Box noBorder noMargin">

<jsp:include page="/WEB-INF/fragments/Feedback.jsp" flush="true"/>

<form:form method="post"
           commandName="enterOtacForm"
           cssClass="txt">

        <div class="clear eShim6"><div class="shim">&nbsp;</div></div>

        <div class="clear"><div class="shim">&nbsp;</div></div>

	<div class="module23Box">
		 We've sent your code to your mobile. Enter the code in the box below.
		<div class="divSpacer">&nbsp;</div>
	</div>
        <div class="clear"><div class="shim">&nbsp;</div></div>

	<div class="contentInnerLeft30 w22">
		<label class="esLabelClass" for="msisdn" title="Mobile number stored">Mobile number</label>
	</div>
	<div class="formContainer floatLeft padRight">
		<form:input path="msisdn" tabindex="20" readonly="true"  cssStyle="background-color:#CCCCCC;border: solid 1px #CADDEE;" title="Mobile number" id="msisdn" size="25"/>
	</div>
        <div class="clear"><div class="shim">&nbsp;</div></div>

        <form:errors path="verificationCode" cssClass="errorText" element="div"/>
        <div class="clear"><div class="shim">&nbsp;</div></div>

	<div class="contentInnerLeft30 w22">
		<label class="esLabelClass" for="verificationCode" title="Type your code here">Type your code here</label>
	</div>
        <div class="contentInnerLeftCol w30 showOverflow">
	  <div class="contentInnerLeftCol w24">
	      <form:input path="verificationCode" tabindex="20" id="verificationCode" title="Verification" onkeypress="return numbersonly(this, event);" alt="Verification" maxlength="6" size="10"/>
	  </div>

          <c:url var="resendOtacUrl" value="/enterMpn.do">
            <c:param name="action" value="resendotac"/>
          </c:url>
          <div class="floatLeft">
	    <span class="floatHeight balloon"></span>
	    <div class="coloredBox0">
	       <b>Code not arrived?</b> If you haven't got your code after 10 minutes, ask us to
	       <a href="<c:out value='${resendOtacUrl}'/>" title="send another code">
	       send another code</a>
	    </div>
          </div>
        </div>
        <div class="clear"><div class="shim">&nbsp;</div></div>

	<div class="eButtonContainer eTxRight">
	   <input type="submit" name="Continue" value="Continue" title="Continue" class="broadbandButton bContinue" tabindex="40"/>
	</div>
        <div class="clear"><div class="shim">&nbsp;</div></div>

	<div class="module23Box">
		<b>Wrong number?</b> If we've got your number wrong, go back and tell us your number again.
		<div class="divSpacer">&nbsp;</div>
	</div>
        <div class="clear"><div class="shim">&nbsp;</div></div>

	<c:url var="backUrl" value="/initiate.do?productid=1000"/>
	<div class="eButtonContainer eTxRight">
	    <a tabindex="50" class="bbLinkButton allTxtRight marginRight5" href="<c:out value='${backUrl}'/>">&nbsp;Back&nbsp;</a>
	    <div class="clear"></div>
	</div>
        <div class="clear"><div class="shim">&nbsp;</div></div>
        
</form:form>

</div>
</div>
<jsp:include page="/WEB-INF/fragments/footer.jsp"/>
</div>

