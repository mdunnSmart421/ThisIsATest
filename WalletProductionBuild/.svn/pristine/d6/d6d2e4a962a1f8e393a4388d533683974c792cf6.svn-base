<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:url var="mobileUtilsJS" value="/scripts/mobileUtils.js"/>
<script type="text/javascript" src="<c:out value='${mobileUtilsJS}'/>" language="javascript"></script>

<c:set var="css"><spring:theme code="css"/></c:set>

<c:choose>
    <c:when test="${not empty css}">
        <link rel="stylesheet" href="<c:url value='${css}'/>" type="text/css"/>
    </c:when>
    <c:otherwise>

    </c:otherwise>
</c:choose>

<c:set var="setLength"><spring:theme code="setMaxLength"/></c:set>


<c:choose>
    <c:when test="${setLength == 'true'}">
        <script type="text/javascript" language="javascript">
            window.onload = insertPlaceHoldersForInputFields;
        </script>

    </c:when>
    <c:otherwise>
        <script language="javascript" src="scripts/jquery-1.7.min.js" type="text/javascript"></script>
        <script language="javascript" src="scripts/bbplaceholder.min.js" type="text/javascript"></script>

    </c:otherwise>
</c:choose>