<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<style type="text/css">
    
    .narrative
    {
        font: 0.85em verdana,helvetica,clean,sans-serif;
    }
    
    #leftPanel ol li 
    {
      list-style-type: decimal;
      list-style-position:inside;
    }

    #leftPanel 
    {
        border-color: #FFFFFF green green;
        border-right: 0 solid green;
        border-style: solid;
        border-width: 6px 0 0;
        float: left;
        font-family: verdana;
        font-size: 1.125em !important;
        margin: 0 0 0 6px !important;
        padding: 0 !important;
        text-align: left;
        width: 224px !important;
    }

    #foot_banner li 
    {
        float: left;
        font-size: 1.1em;
        padding: 0 10px 0 15px;
    }
    
    .narrativeIndent
    {
    	margin-left: 1em; 
    	text-indent: -1em;
    }
    
</style>

<div id="leftPanel">
   <div class="narrative">
	   <p>
	   <c:out value="Before you can get an ${sessionScope.product.productTitle} you need to do two things."/>
	   </p>
	   <div class="divSpacer">&nbsp;</div>
	   <div class="narrativeIndent">
			1. Check we have the right details &nbsp;for you.
	   </div>
	   <div class="narrativeIndent">
			2. <c:out value="Apply for your ${sessionScope.product.productTitle}."/>
	   </div>
	   
	   <div class="divSpacer">&nbsp;</div>
	   <p>	   	
	   		<c:choose>
	   			<c:when test="${sessionScope.product.productTitle eq 'O2 Credit Card'}">
	   				It'll take about ten minutes. We'll copy all the info you give us in step 1 across to step 2.
	   			</c:when>
	   			<c:otherwise>
	   				It'll take about five minutes. We'll copy all the info you give us in step 1 across to step 2.
	   			</c:otherwise>
	   		</c:choose>	   		 
	   </p>
           <div class="divSpacer">&nbsp;</div>
           <p>
           Just type in your mobile number to get started.
           </p>
   </div>
</div>