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


    <jsp:include page="/WEB-INF/fragments/coreMetrics.jsp" />

    <jsp:include page="/WEB-INF/fragments/favicon.jsp"/>
</head>
<jsp:include page="/WEB-INF/fragments/StyleSheets.jsp" />
<jsp:include page="/WEB-INF/fragments/topNav.jsp"/>
<jsp:include page="/WEB-INF/fragments/leftPanelClear.jsp"/>



<!-- coremetrics tpRegistration -->
<div id="cmTPpageID" style="display:none;">O2 Money - Authentication - Confirm Which Portal Account</div>
<div id="cmTPcatID" style="display:none;">O2 Money - Prepaid Card - Authentication</div>



<div id="contentCol">
<div class="innerContentGrid">

<jsp:include page="/WEB-INF/fragments/processTitle.jsp"/>

<!--
<div class="bodyHdr03Text">
    <h3 class="eHead3">
        <c:out value="${sessionScope.product.checkDetailsCopy}"/>
    </h3>
    <div class="divSpacer">&nbsp;</div>
</div>
-->

<div class="module6Box noBorder noMargin">

<jsp:include page="/WEB-INF/fragments/Feedback.jsp" flush="true"/>

<form:form method="post" 
           commandName="chooseAccountForm" 
           cssClass="txt">
    
    <div class="clear eShim6"><div class="shim">&nbsp;</div></div>
    
    <c:set var="numberOfAccounts" value="${chooseAccountForm.accountsListSize}" />    
          
    <div class="bodyHdr03Text">
    <h3 class="eHead3">      
       <c:choose>
          <c:when test="${numberOfAccounts eq 0}">
             <c:out value="" />
             <c:set var="continueLabel" value="Sign into MyO2 account" />
          </c:when>
          <c:when test="${numberOfAccounts eq 1}">                 
	         <c:out value="We've found your o2.co.uk master account for you with this mobile number. If this is correct please press 'Continue'. You'll need to sign in to this account before you can complete your registration so make sure you know the username and password" />
	         <c:set var="continueLabel" value="Continue registration using this o2.co.uk account" />        
          </c:when>          
          <c:otherwise>
	          <c:out value="We've found more than one o2.co.uk master account for you with this mobile number. Pick the one you want to use and then 'Continue'. You'll need to sign in to this account before you can complete your registration so make sure you know the username and password" />
	          <c:set var="continueLabel" value="Sign into MyO2 account" />
          </c:otherwise>
       </c:choose>    
    </h3>
    <div class="divSpacer">&nbsp;</div>
    </div>        
            
    <div class="clear eShim6"><div class="shim">&nbsp;</div></div>
    
    <div class="contentInnerLeft30 w30">
       <label class="esLabelClass" for="msisdn" title="Mobile number stored">Mobile number:</label>
    </div>
    <div class="formContainer floatLeft padRight">
        <form:input path="msisdn" tabindex="20" readonly="true" cssStyle="background-color:#CCCCCC;border: solid 1px #CADDEE;"
                    title="Mobile number" id="msisdn"
                    size="25"/>
    </div>
    <div class="clear eShim6"><div class="shim">&nbsp;</div></div>

    <div class="contentInnerLeft30 w30">
      <label class="esLabelClass" for="OnlineAccount" title="Username">Username:</label>
    </div>
            
    <div class="formContainer floatLeft padRight">      
      <table>                     
	  <c:forEach var="friendlyusernamelabelbean" items="${chooseAccountForm.accounts}">     
	  <tr>                           
	    <td>
	     <input type="text" value="<c:out value="${friendlyusernamelabelbean.friendlyUsername}"/>&nbsp;&nbsp;&nbsp;<c:out value="${friendlyusernamelabelbean.label}"/>" name="friendlyusername" tabindex="20" readonly="true" STYLE="background-color:#CCCCCC;border: solid 1px #CADDEE;" title="Friendly Username and Label" id="funid" size="60">
	    </td>	    	    	      
	  </tr>                      
	  </c:forEach>              
	  </table>
    </div>
    
    <form:hidden path="account" />

    <div class="formContainer floatLeft padRight">      
    <div class="divSpacer">&nbsp;</div>        
    <c:if test="${numberOfAccounts gt 1}">
      <c:out value="Remember your username and sign into the account you wish to use on the next page" />
    </c:if>
    </div>
                       
    <div class="clear eShim6"><div class="shim"></div></div>
                
    <div class="eButtonContainer allTxtRight">
            <input name="submit" type="submit" class="bbLinkButton broadbandButton" title="<c:out value='${continueLabel}'/>" value="<c:out value='${continueLabel}'/>"/>
    </div>

    <br/>
    <div class="clear eShim6"><div class="shim"></div></div>
    
    <c:url var="enterUserDetailsUrl" value="/enterUserDetails.do">            
    </c:url>
    <div class="coloredBox0">
	       <b>Help?</b> I have another o2.co.uk account i use that isn't shown here.
	       <a onmouseover="ShowContent('whypopup'); return true;" href="javascript:ShowContent('whypopup')" title="Why?"> Why?</a>
	       <br/>
	       Someone else pays my Mobile contract and the o2.co.uk account details shown here
	       are theirs. If so, <a href="<c:out value='${enterUserDetailsUrl}'/>" title="register for a new account here"> register for a new account here</a>
	</div>

</form:form>
        
</div>
</div>
<jsp:include page="/WEB-INF/fragments/footer.jsp"/>
</div>

<!-- Start of why popup code goes here. -->
<script type="text/javascript" language="JavaScript">
<!-- Copyright 2006,2007 Bontrager Connection, LLC
// http://bontragerconnection.com/ and http://www.willmaster.com/
// Version: July 28, 2007
var cX = 0; var cY = 0; var rX = 0; var rY = 0;
function UpdateCursorPosition(e){ cX = e.pageX; cY = e.pageY;}
function UpdateCursorPositionDocAll(e){ cX = event.clientX; cY = event.clientY;}
if(document.all) { document.onmousemove = UpdateCursorPositionDocAll; }
else { document.onmousemove = UpdateCursorPosition; }
function AssignPosition(d) {
if(self.pageYOffset) {
	rX = self.pageXOffset;
	rY = self.pageYOffset;
	}
else if(document.documentElement && document.documentElement.scrollTop) {
	rX = document.documentElement.scrollLeft;
	rY = document.documentElement.scrollTop;
	}
else if(document.body) {
	rX = document.body.scrollLeft;
	rY = document.body.scrollTop;
	}
if(document.all) {
	cX += rX;
	cY += rY;
	}
d.style.left = (cX+10) + "px";
d.style.top = (cY+10) + "px";
}
function HideContent(d) {
if(d.length < 1) { return; }
document.getElementById(d).style.display = "none";
}
function ShowContent(d) {
if(d.length < 1) { return; }
var dd = document.getElementById(d);
AssignPosition(dd);
dd.style.display = "block";
}
function ReverseContentDisplay(d) {
if(d.length < 1) { return; }
var dd = document.getElementById(d);
AssignPosition(dd);
if(dd.style.display == "none") { dd.style.display = "block"; }
else { dd.style.display = "none"; }
}
//-->
</script>

</br></br></br></br>


<a
   onmouseover="ShowContent('whypopup'); return true;"
   href="javascript:ShowContent('whypopup')">
[Why? show, content has "hide" link]
</a>
<div
   id="whypopup"
   style="display:none;
      position:absolute;
      border-style: solid;
      background-color: white;
      padding: 5px;">
      
<p><span style="float: right">
<a
   onclick="HideContent('whypopup'); return true;"
   href="javascript:HideContent('whypopup')">
[CLOSE POPUP]
</a>
</span>
<span style="float: left">
<b><u>Can't see the My O2 (o2.co.uk) account you’re looking for?</u></b>
</span> </p>
</br>
You've 2 options:</br>
1) Return to the previous screen and select one of the accounts offered to you.</br>
2) Close the O2 Wallet registration pages and sign into your My O2 account you wish to use and <b>edit</b> the details.</br>
- Either the mobile number on this account is old so requires updating</br>
<b>OR</b></br>
- You're expecting to see one of your linked accounts. </br>
You can only register for the O2 Wallet with a Master account (default) so sign in and make your preferred account the Master.</br>
</br>
<b><u>How to edit?</u></b></br>
To see and edit your accounts, sign in here and go to 'Link/view your o2.co.uk accounts' option under My O2 (top right menu). </br>
Once you've made your changes, you can register for the O2 Wallet using your preferred My O2 account. </br>
If you get stuck, call us on 10202 (free for O2 customers) or 0844 70 10202 (charges apply).</br>
</br>
<b><u>Important notes:</u></b></br>
Your Master account should be the account you access most (usually to check your mobile bill).</br>
Remember, once you've registered for the O2 Wallet using one My O2 account, you'll need to use this account every time you use your O2 Wallet.</br>
      
</div>


<!-- End of why popup code -->

