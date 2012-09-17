<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<c:if test="${!empty feedback && !empty feedback.type}">    
    <c:choose>
        <c:when test="${feedback.type == 103}">
            <div class="moduleFrmBoxSuccessCondition w96">
                <div class="confirmationTickDiv">&nbsp;</div>
                <div class="floatLeft textLeft w90">
                <c:out value="${feedback.desc}"/>
                <div class="visH"><h4>Success</h4></div></div>
                <br class="clear"/>
            </div>
        </c:when>
        <c:otherwise>
            <div class="moduleFrmBoxErrorCondition w96">
                <div class="exclamationMarkDiv">&nbsp;</div>
                <div class="floatLeft textLeft w90">
                <c:out value="${feedback.desc}"/>
                <div class="visH"><h4>Error</h4></div></div>
                <br class="clear"/>
            </div>
        </c:otherwise>
    </c:choose>
</c:if>