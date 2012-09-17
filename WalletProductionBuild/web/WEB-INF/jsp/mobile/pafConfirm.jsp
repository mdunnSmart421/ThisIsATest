
<html>

<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/WEB-INF/taglib/productRegistration.tld" prefix="reg" %>


<head>
    <title><reg:PageTitle value="${localModel.processName}"/></title>

    <meta name="viewport" content="width=320; initial-scale=1.0; maximum-scale=1.0; width=device-width"/>

    <!-- make full screen if launched from home page -->
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="apple-mobile-web-app-status-bar-style" content="black"/>

    <!-- Don't display phone numbers as links -->
    <meta name="format-detection" content="telephone=no">


    <meta name="keywords" content="O2, 02, o2, product registration, sign in, mobile"/>
    <meta name="description" content="Your mobile number"/>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"/>
    <meta http-equiv="Cache-control" content="no-cache"/>

    <jsp:include page="/WEB-INF/fragments/coreMetrics.jsp"/>

    <%-- Load the theme based on the device --%>
   	<jsp:include page="/WEB-INF/jsp/mobile/fragments/theme.jsp" />

</head>

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

<body>
	<!-- This is pafConfirm (mobile).jsp -->
	
    <div class="header">
        <span class="corporate-logo"></span>

        <div class="title">Register</div>
        <reg:ProductRegistrationCancelForMobile />
    </div>


    <div class="progress-steps">

        <span class="active">1. Mobile</span>
        <span id=step-two class="step-two active">2. About you</span>
        <span class="">3. All done</span>
    </div>


    <div class="canvas">
    	 <div class="description">
    	<c:choose>
	        <c:when test="${pafLookupForm.size > 0}">
                <div class="heading noicon">Choose your addresss</div>
                <p>Choose your address from the list. If your address isn't here
                you can pick the nearest one and then update or add your
                house number or name on the next page.</p>
	        </c:when>
	        <c:otherwise>
                <div class="icon errorbang"></div>
                <div class="heading">Address not found</div>

               <p>We can't find an address for that postcode. Please use the back button, check your postcode and try again.</p>

	        </c:otherwise>
    	</c:choose>


    	<jsp:include page="/WEB-INF/jsp/mobile/fragments/feedback.jsp" flush="true"/>

        </div>




    <div class="content">
    	<form:form method="post" commandName="pafLookupForm" cssClass="txt">
    	
    		<form:hidden path="address.houseNumber" />
			<form:hidden path="address.houseName" />
			<form:hidden path="address.addressLine1" />
			<form:hidden path="address.addressLine2" />
			<form:hidden path="address.townOrCity"/>
			<form:hidden path="address.postcode"/>
			
			<c:choose>
		        <c:when test="${pafLookupForm.size > 0}">


                    <div style="display: table;">
                        <c:forEach items="${pafLookupForm.pafList}" var="item" varStatus="counter" >
                            <div class="pafentry">
                                <div class="pafrow">
                                    <form:radiobutton cssClass="pafradio"
                                           path="current"
                                           onclick="selectAddress('${item.houseNumber}','${item.houseName}','${item.addressLine1}','${item.addressLine2}','${item.townOrCity}','${item.postcode}')"
                                           value="${item.address}"/>

                                    <label class="paflabel" for="current<c:out value="${counter.count}"/>"><c:out value="${item.address}"/></label>

                                </div>
                            </div>
                        </c:forEach>
                    </div>



				</c:when>
		</c:choose>


    <div class="buttonBox">

		<c:choose>
            <c:when test="${pafLookupForm.size > 0}">
		        <input name="select"
		               type="submit"
		               class="continueButton"
		               id="bGo1"
		               title="Select address"
		               value="Select Address"/>
		
		        <%--<input name="cancel"--%>
		               <%--class="continueButton"--%>
		               <%--type="submit"--%>
		               <%--value="Cancel"--%>
		               <%--title="Cancel"/>--%>
            </c:when>
            <c:otherwise>
            <input name="back"
                   class="continueButton"
                   type="submit"
                   value="Back"
                   title="Back"/>
            </c:otherwise>
        </c:choose>

</div>


    	</form:form>
          </div>
    </div>

    <script language="JavaScript" type="text/javascript">
        fixRadio();
    </script>
</body>
</html>

