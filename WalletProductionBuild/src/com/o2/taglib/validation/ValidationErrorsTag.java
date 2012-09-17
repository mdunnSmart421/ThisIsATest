//package com.o2.taglib.validation;
//
//import com.o2.finance.validation.ValidationUtils;
//import com.o2.finance.validation.vo.ValidationError;
//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.jsp.JspException;
//import javax.servlet.jsp.JspWriter;
//import javax.servlet.jsp.tagext.BodyTagSupport;
//import java.io.IOException;
//import java.util.Iterator;
//import java.util.List;
//
///**
// * JSP tag to write out all validation errors to the page. HTML is taken from the validation.properties file.
// *
// * @author psacre
// *
// */
//public class ValidationErrorsTag extends BodyTagSupport
//{
//    private static final long serialVersionUID = 20071016L;
//
//    public int doStartTag() throws JspException
//    {
//        Logger log = LogManager.getLogger(this.getClass());
//        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
//        List errorsList = (List) request.getAttribute(ValidationUtils.REQUEST_ATTRIBUTE_ERROR_LIST);
//        if (null != errorsList && errorsList.size() > 0)
//        {
//            JspWriter out = pageContext.getOut();
//            try
//            {
//                out.print(ValidationUtils.getProperty("validationErrors.header", ""));
//                Iterator it = errorsList.iterator();
//                while (it.hasNext())
//                {
//                    ValidationError error = (ValidationError) it.next();
//                    out.print(ValidationUtils.getProperty("validationErrors.itemStart", ""));
//                    out.print(error.getMessage());
//                    out.print(ValidationUtils.getProperty("validationErrors.itemEnd", ""));
//                }
//                out.print(ValidationUtils.getProperty("validationErrors.footer", ""));
//            } catch (IOException e)
//            {
//                log.error("Error writing validationErrorsTag to output", e);
//            }
//        }
//        return SKIP_BODY;
//    }
//}
