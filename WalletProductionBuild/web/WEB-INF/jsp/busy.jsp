<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<head>
	<title>O2 Finance error</title>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
	<meta http-equiv="Cache-control" content="no-cache"/>

	<jsp:include page="/WEB-INF/fragments/favicon.jsp"/>

	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

        <jsp:include page="/WEB-INF/fragments/coreMetrics.jsp" />


</head>
<jsp:include page="/WEB-INF/fragments/StyleSheets.jsp" />
<jsp:include page="/WEB-INF/fragments/topNav.jsp"/>
<jsp:include page="/WEB-INF/fragments/leftPanelClear.jsp"/>


<div id="cmTPpageID" style="display:none;">O2 Money - Registration failure</div>
<div id="cmTPcatID" style="display:none;">O2 Money - Prepaid Card - Authentication</div>

<div id="contentCol">
	<div class="innerContentGrid">



		<div class="bodyHdr01Text">
			<h1><%= request.getAttribute( "busyHeader" ) %></h1>
		</div>

		<div class="module6Box noBorder noMargin">


			<div class="module23Box">
				<div class="contentInnerLeftCol w100">
                   	<%= request.getAttribute( "busyBody" ) %>
				</div>

                <div class="eShim6"><div class="shim">&nbsp;</div></div>
                <div class="eShim6"><div class="shim">&nbsp;</div></div>
                <div class="eShim6"><div class="shim">&nbsp;</div></div>
                <div class="eShim6"><div class="shim">&nbsp;</div></div>
                <div class="eShim6"><div class="shim">&nbsp;</div></div>
                <div class="eShim6"><div class="shim">&nbsp;</div></div>
                <div class="eShim6"><div class="shim">&nbsp;</div></div>
                <div class="eShim6"><div class="shim">&nbsp;</div></div>
                <div class="eShim6"><div class="shim">&nbsp;</div></div>




                <div class="eButtonContainer eTxRight">

                    <div id="cancelHolder">
                        <a class="bbLinkButton allTxtRight marginRight5" href="<%=request.getAttribute( "backUrl" )%>"
                           ><%= request.getAttribute( "backButtonValue" )%></a>
                    </div>

                    <div class="eShim6"><div class="shim">&nbsp;</div></div>
                    <div class="eShim6"><div class="shim">&nbsp;</div></div>
                    <div class="eShim6"><div class="shim">&nbsp;</div></div>
                    <div class="eShim6"><div class="shim">&nbsp;</div></div>

                </div>

			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/fragments/footer.jsp" />
</div>					
