<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<div class="bodyHdr01Text">
    <h1 class="eHead1">
        <c:choose>
          <c:when test="${sessionScope.processStage.stage eq 'CHECK'}">
             <c:out value="${sessionScope.product.productTitle} - step 1: check your details"/>
          </c:when>
          <c:when test="${sessionScope.processStage.stage eq 'COMPLETE'}">
             <c:out value="${sessionScope.product.productTitle} - step 1: done"/>
          </c:when>
          <c:otherwise>
             <c:out value="${sessionScope.product.productTitle} - step 1: setting up your account"/>
          </c:otherwise>
        </c:choose>
    </h1>
</div>