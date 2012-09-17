<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<c:if test="${!empty feedback && !empty feedback.type}">    
    <c:choose>
        <c:when test="${feedback.type == 103}">
                <c:out value="${feedback.desc}"/>
                <%--<h4>Success</h4>--%>
        </c:when>
        <c:otherwise>
            <div class="error">
                <div class="smallicon smallerrorbang"></div>
                <c:out value="${feedback.desc}"/>
            </div>
        </c:otherwise>
    </c:choose>
</c:if>
