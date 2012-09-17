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

    <jsp:include page="/WEB-INF/fragments/coreMetrics.jsp" />

    <jsp:include page="/WEB-INF/fragments/favicon.jsp"/>
</head>

<jsp:include page="/WEB-INF/fragments/StyleSheets.jsp"/>
<jsp:include page="/WEB-INF/fragments/topNav.jsp"/>
<jsp:include page="/WEB-INF/fragments/leftPanelNewUserNarrative.jsp"/>


<!-- coremetrics tpRegistration -->
<div id="cmTPpageID" style="display:none;">O2 Money - Enter Mobile number</div>
<div id="cmTPcatID" style="display:none;">O2 Money - Prepaid Card - Authentication</div>


<div id="contentCol">
<div class="innerContentGrid">

<jsp:include page="/WEB-INF/fragments/processTitle.jsp"/>

<div class="module6Box noBorder noMargin">
<div class="module23Box">
    <b>Make sure you've got your mobile phone with you.</b>
    We'll text you a code to check it's your phone.
    <div class="divSpacer">&nbsp;</div>
    Type in your number below (e.g. 07756 49xxxx). Choose 'Send me a code'. Then, on the next page enter the
    code.
    <div class="divSpacer"><hr/></div>
</div>
  
<jsp:include page="/WEB-INF/fragments/Feedback.jsp" flush="true"/>
    
<form:form method="post" 
           commandName="enterMpnForm" 
           cssClass="txt">
    
    <div class="clear eShim6"><div class="shim">&nbsp;</div></div>

    <div class="module23Box">
        Fields marked with an '*' are mandatory.
    </div>

    <br/>
    <br/>

    <form:errors path="msisdn" cssClass="errorText" element="div"/>
    <div class="clear"><div class="shim">&nbsp;</div></div> 

    <div class="contentInnerLeft30 w30">
        <label class="esLabelClass" for="msisdn" title="Mobile number">Tell us your mobile number*:</label>
    </div>

    <div class="formContainer floatLeft padRight">
      <form:input path="msisdn" title="Mobile number" id="msisdn" onkeypress="return numbersonly(this, event);" size="35" maxlength="11" />
    </div>
    <div class="clear"><div class="shim">&nbsp;</div></div> 

    <div class="eButtonContainer eTxRight">
        <input type="submit" name="requestcode" value="Send me the code"
               title="Send me the code" class="broadbandButton bContinue" tabindex="40"/>&nbsp;
    </div>
    <div class="clear"><div class="shim">&nbsp;</div></div> 

</form:form>

</div>
</div>
<jsp:include page="/WEB-INF/fragments/footer.jsp"/>
</div>