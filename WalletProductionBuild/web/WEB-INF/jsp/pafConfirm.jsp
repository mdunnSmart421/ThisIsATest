<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jstl/core"            prefix="c" %>
<%@ taglib uri="/WEB-INF/taglib/productRegistration.tld"  prefix="reg" %>

<head>
    <title><reg:PageTitle value="${localModel.processName}" /></title>
    <meta name="keywords" content="O2, 02, o2, product registration, sign in, mobile" />
    <meta name="description" content="Your mobile number" />
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
    <meta http-equiv="Cache-control" content="no-cache">

    <jsp:include page="/WEB-INF/fragments/favicon.jsp"/>

</head>
<jsp:include page="/WEB-INF/fragments/StyleSheets.jsp" />
<jsp:include page="/WEB-INF/fragments/topNav.jsp"/>
<jsp:include page="/WEB-INF/fragments/leftPanelClear.jsp"/>

<!--  Scripting, for controlling all the Paf stuff -->
<script type="text/javascript">

function selectAddress(houseNumber,
		               houseName,
		               addressLine1,
		               addressLine2,
		               townOrCity,
		               postcode) 
{
    document.getElementById("address.houseNumber").value  = houseNumber;
    document.getElementById("address.houseNumber").value  = houseNumber;
    document.getElementById("address.houseName").value    = houseName;
    document.getElementById("address.addressLine1").value = addressLine1;
    document.getElementById("address.addressLine2").value = addressLine2;
    document.getElementById("address.townOrCity").value   = townOrCity;
    document.getElementById("address.postcode").value     = postcode;
}

</script>

<div id="contentCol">
<div class="innerContentGrid">
<!-- Start Breadcrumb -->

<jsp:include page="/WEB-INF/fragments/processTitle.jsp"/>
   
   <!-- End Breadcrumb -->
<div class="module6Box noBorder noMargin">

<div class="bodyHdr03Text">

    <c:choose>
        <c:when test="${pafLookupForm.size > 0}">
            <h2 class="eHead2"><c:out value="${pafLookupForm.addressFoundHeaderCopy}" escapeXml="false"/></h2>
        </c:when>
        <c:otherwise>
            <h2 class="eHead2"><c:out value="${pafLookupForm.addressNotFoundHeaderCopy}" escapeXml="false"/></h2>
        </c:otherwise>
    </c:choose>


  <%--<h2 class="eHead2">Please select an address</h2>--%>
</div>
    
<jsp:include page="/WEB-INF/fragments/Feedback.jsp" flush="true"/>

<!-- Display Validation Errors -->
<!-- End Validation Errors -->	
<form:form method="post" 
           commandName="pafLookupForm" 
           cssClass="txt">
	<form:hidden path="address.houseNumber" />
	<form:hidden path="address.houseName" />
	<form:hidden path="address.addressLine1" />
	<form:hidden path="address.addressLine2" />
	<form:hidden path="address.townOrCity"/>
	<form:hidden path="address.postcode"/>
	
        <div class="divSpacer"><hr/></div>
        <div class="clear eShim6"><div class="shim">&nbsp;</div></div>
       

	<c:choose>
        <c:when test="${pafLookupForm.size > 0}">
            <div class="coloredBox0 w65">

                <c:out value="${pafLookupForm.addressFoundBodyCopy}" escapeXml="false"/>


                <%--<p>Choose your address from the list. If it's not there pick the nearest </p>--%>

                <%--<p>one and then you can update or add your flat/apartment number</p>--%>

                <%--<p>or house name details on the next page.</p>--%>
            </div>
            <div class="clear eShim6">
                <div class="shim">&nbsp;</div>
            </div>

            <div class="formContainer floatLeft">
	        <table width="100%">
	          <c:forEach items="${pafLookupForm.pafList}" var="item" varStatus="counter" >
	            <tr>
	                <td colspan="1" width="20" class="FormActionTxt">
	                   <form:radiobutton 
	                          path="current"
	                          onclick="javascript:selectAddress('${item.houseNumber}','${item.houseName}','${item.addressLine1}','${item.addressLine2}','${item.townOrCity}','${item.postcode}')"
	                          value="${item.address}"/>
	                </td>
	                <td colspan="1" width="432" class="FormActionTxt">
	                   <c:out value="${item.address}"/>
	                </td>
	             </tr>                           
	          </c:forEach>
	        </table>
	</c:when>
	<c:otherwise>


                <div class="coloredBox0 w65">
                    <c:out value="${pafLookupForm.addressNotFoundBodyCopy}" escapeXml="false"/>
                    <%--<p>We can't find an address for that postcode. Please use the back button, check your postcode and--%>
                        <%--try again.</p>--%>
                </div>
                <div class="clear eShim6">
                    <div class="shim">&nbsp;</div>
                </div>

                <div class="formContainer floatLeft">

                    <br/>
		<table width="100%">
		   <tr>
		     <td colspan="1" width="100" style="padding-right:1em;" class="FormActionTxt">
		       House Number:
		     </td>
		     <td colspan="1" width="350" class="FormActionTxt">
		       <c:out value="${pafLookupForm.address.houseNumber}"/>
		     </td>
		   </tr>
		   <tr>
		     <td colspan="1" width="100" style="padding-right:1em;" class="FormActionTxt">
		       House Name:
		     </td>
		     <td colspan="1" width="350" class="FormActionTxt">
		       <c:out value="${pafLookupForm.address.houseName}"/>
		     </td>
		   </tr>
		   <tr>
		     <td colspan="1" width="100" style="padding-right:1em;" class="FormActionTxt">
		       Post Code:
		     </td>
		     <td colspan="1" width="350" class="FormActionTxt">
		       <c:out value="${pafLookupForm.address.postcode}"/>
		     </td>
		   </tr>
		</table>
		<br/>
	</c:otherwise>
	</c:choose>
	</div>

        <div class="clear eShim6"><div class="shim">&nbsp;</div></div>
	
	<div class="eButtonContainer allTxtRight">

        <c:choose>
            <c:when test="${pafLookupForm.size > 0}">
        <input name="select"
               type="submit"
               class="bbLinkButton broadbandButtonLongText allTxtRight marginRight5"
               id="bGo1"
               title="Select address"
               value="Select Address"/>

        <input name="cancel"
               class="bbLinkButton broadbandButtonLongText allTxtRight marginRight5"
               type="submit"
               value="Cancel"
               title="Cancel"/>
            </c:when>
            <c:otherwise>
            <input name="back"
                   class="bbLinkButton broadbandButtonLongText allTxtRight marginRight5"
                   type="submit"
                   value="Back"
                   title="Back"/>
            </c:otherwise>
        </c:choose>

    </div>
                <div class="clear eShim6">
                    <div class="shim">&nbsp;</div>
                </div>

   </form:form>
   <br/>
</div>
</div>
<jsp:include page="/WEB-INF/fragments/footer.jsp"/>
