<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/taglib/productRegistration.tld" prefix="reg" %>


<head>
    <title><reg:PageTitle value="${localModel.processName}"/></title>
    <jsp:include page="/WEB-INF/fragments/favicon.jsp"/>
</head>

<jsp:include page="/WEB-INF/fragments/StyleSheets.jsp"/>
<jsp:include page="/WEB-INF/fragments/topNav.jsp"/>
<jsp:include page="/WEB-INF/fragments/leftPanelClear.jsp"/>

<jsp:useBean id="silentLoginForm" scope="request" class="com.o2.finance.beans.SilentLoginForm"/>

</div> <!-- closing "content" DIV tag here (instead of in the footer) which is set as part of topNav.jsp. This tag had CSS attributes which were causing formatting issues for the content below-->

<div> <!-- we need declare a DIV to keep the closing "content" DIV in the footer happy-->


    <div id="contentCol"> <!-- this tag is closed in footer.jsp -->

        <div class="innerContentGrid">

            <form name="silentLoginForm" id="silentLoginForm" method="post" action="<%=silentLoginForm.getLoginURL()%>">

                <input type="hidden" name="username" id="username" value="<%=silentLoginForm.getUsername()%>"/>
                <input type="hidden" name="password" id="password" value="<%=silentLoginForm.getPassword()%>"/>
                <input type="hidden" name="destURL" id="destURL" value="<%=silentLoginForm.getReturnURL()%>"/>
                <input type="hidden" name="fuUrl" id="fuUrl" value="<%=silentLoginForm.getFailureURL()%>"/>
                <input type="hidden" name="skipRedirects" id="skipRedirects" value="true"/>

                <div class="posInherit noMarginTop">

                    <div class="module6Box noBorder noMargin">

                        <div class="divSpacer">&nbsp;</div>

                        <div class="module23Box">

                            <noscript>
                                <center>

                                    <div class="divSpacer">&nbsp;</div>

                                    <h2>We are not able to log you in automatically.</h2>

                                    <div class="divSpacer">&nbsp;</div>

                                    <h3>JavaScript is currently disabled or is not supported by your browser.</h3>

                                    <div class="divSpacer">&nbsp;</div>

                                    <h4>Please click submit to continue with your application.</h4>

                                    <div class="divSpacer">&nbsp;</div>

                                    <div class="eButtonContainer">

                                        <input type="submit" id="silentLoginsubmit" name="submit" value="Submit"
                                               title="submit" class="broadbandButton bContinue" onclick="submit"/>

                                    </div>

                                </center>
                            </noscript>

                            <script language="JavaScript" type="text/javascript">

                                document.write( "<p class='centered' style='font-size: 1.5em;'>Please wait while we log you in...</p>" +
                                        "<div class='clear'>&nbsp;</div>" +
                                        "<div class='shim'>&nbsp;</div>" +
                                        "<div class='centered'>" +
                                        "<img src='https://www.o2.co.uk/assets/O2HybridNav/Static-files/eService/css/images/spinning_wheel_throbber.gif' alt='Please Wait' width='32' height='32'/>" +
                                        "</div>" );

                            </script>

                        </div>
                    </div>
                </div>
            </form>
        </div>

        <br/>
        <br/>

        <script language="JavaScript" type="text/javascript">

            window.onload = function()
            {
                document.silentLoginForm.submit();
            };

        </script>

        <div>
            <jsp:include page="/WEB-INF/fragments/footer.jsp"/>
        </div>
		
		
	
	
