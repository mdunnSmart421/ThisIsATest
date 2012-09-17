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
// * Tag to display an inline validation error message for a particular field.
// *
// * @author psacre
// *
// */
//public class ValidationErrorTag extends BodyTagSupport
//{
//    private static final long serialVersionUID = 20071016L;
//    private String fieldName;
//    private Logger log = LogManager.getLogger(this.getClass());
//
//    public int doStartTag() throws JspException
//    {
//        if (null == fieldName || "".equals(fieldName))
//        {
//            return SKIP_BODY;
//        }
//        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
//        List errorsList = (List) request.getAttribute(ValidationUtils.REQUEST_ATTRIBUTE_ERROR_LIST);
//        if (null != errorsList && errorsList.size() > 0)
//        {
//            Iterator it = errorsList.iterator();
//            while (it.hasNext())
//            {
//                ValidationError error = (ValidationError) it.next();
//                if (fieldName.equals(error.getFieldName()))
//                {
//                    JspWriter out = pageContext.getOut();
//                    try
//                    {
//                        out.print(ValidationUtils.getProperty("validationError.header", ""));
//                        out.print(error.getMessage());
//                        out.print(ValidationUtils.getProperty("validationError.footer", ""));
//                    } catch (IOException e)
//                    {
//                        log.error(this.getClass().getName(), e);
//                    }
//                    break;
//                }
//            }
//        }
//        return SKIP_BODY;
//    }
//
//    /* === Accessors =================================== */
//    public String getFieldName()
//    {
//        return fieldName;
//    }
//
//    public void setFieldName(String fieldName)
//    {
//        this.fieldName = fieldName;
//    }
//}
