<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
<jsp:include page="/WEB-INF/fragments/leftPanelClear.jsp"/>



<div id="cmTPpageID" style="display:none;">O2 Money - Registration failure</div>
<div id="cmTPcatID" style="display:none;">O2 Money - Prepaid Card - Authentication</div>


<div id="contentCol">
<div class="innerContentGrid">

<div class="bodyHdr01Text">
    <h1 class="eHead1">
        O2 Money - wallet application
    </h1>
</div>

<br/>
<div class="horizRuler"><hr/></div>
<br/>

<jsp:include page="/WEB-INF/fragments/Feedback.jsp" flush="true"/>
    
<br/>
<div class="horizRuler"><hr/></div>
<br/>

</div>
<jsp:include page="/WEB-INF/fragments/footer.jsp"/>
</div>