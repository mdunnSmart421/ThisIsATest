<%@ page import="com.o2.finance.properties.PropertyManager" %>
<%@ page import="com.o2.finance.properties.StyleSheetProps" %>
<!--
Adds all necessary style sheets
-->
<%

	org.apache.log4j.Logger logger = org.apache.log4j.LogManager.getLogger(this.getClass());


    // try to get the ssProps data object from the servlet context first
    StyleSheetProps ssProps = PropertyManager.getStyleSheetProps();

//    if (ssProps == null)
//    {
//        // it wasn't found in the servlet context, so create from scratch
//        ssProps = new StyleSheetProps();
//        log.debug( "Creating a new StyleSheetProps object" );
//        // save to the servlet context - it is a lightweight object with no user-specific data, so
//        // saving it here will avoid continual IO access of the properties file
//        application.setAttribute( ApplicaitonConstants.STYLE_INCLUDES, ssProps );
//    }
%>
<!--
Credential Reminder - Forgotten Password. Once o2 moves this to o2 style sheet this section can be removed
-->
<style type="text/css">
    #register {
        background-color: #FFFFFF;
        border: 1px solid black;
        padding: 5px;
        width: 730px;
    }

    .reg_left {
        float: left;
        width: 300px;
        text-align: right;
        padding-right: 10px;
        padding-top: 5px;
        font-weight: bold;
    }

    .reg_right {
        width: 120px;
    }

    #rating_outer {
        border-top: 1px solid black;
        width: 120px;
        height: 7px;
    }

    #rating_inner {
        background-color: #d2d1d1;
        width: 120px;
        height: 7px;
    }

    #rating_text {
        width: 120px;
        text-align: left;
    }

    #rating_background {
        width: 120px;
        background-color: #FFFFFF;
        border: 1px solid black;
    }

    .register_text {
        width: 40%;
    }

</style>
<!--
Credential Reminder - END *************************************************
-->

<link href="<%=ssProps.getProtocol() %><%=ssProps.getServer() %><%=ssProps.getEservices() %>" type="text/css"
      media="all" rel="stylesheet"/>
