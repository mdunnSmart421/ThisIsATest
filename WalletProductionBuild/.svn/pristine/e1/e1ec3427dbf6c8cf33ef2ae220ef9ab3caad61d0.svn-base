package com.o2.finance.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.o2.finance.etc.ApplicationConstants;

/**
 * Provide the title for each page.
 * 
 * @author csimms
 */
/**
 * @deprecated Intention is not to use this.
 */
public class PageTitle extends TagSupport implements ApplicationConstants
{
    private static final long serialVersionUID = 1L;
    public static final String PAGE_TITLE = "Page Title";
    /**
     * String name for DEFAULT FLOW
     */
    private static final String DEFAULT_DESCRIPTION = "REGISTRATION";
    /**
     * String value
     */
    private String value;

    public Object getValue()
    {
        return value;
    }

    /**
     * Object passed in, mapping to title.
     * 
     * @param avalue
     */
    public final void setValue(final Object avalue)
    {
        if (avalue instanceof String)
        {
            this.value = (String) avalue;
        } else
        {
            this.value = DEFAULT_DESCRIPTION;
        }
    }

    /**
     * 
     * @return String HTML output title
     * 
     *         private final String getTitle() {
     * 
     *         String rtnTitle = null; String sourcePage = (String) getValue();
     * 
     *         if (sourcePage.equals(MYACCOUNTS_FLOW)) { rtnTitle = MYACCOUNTS; } else { rtnTitle = DEFAULT_DESCRIPTION; }
     * 
     *         return rtnTitle; }
     */
    public int doEndTag() throws JspException
    {
        return EVAL_PAGE;
    }

    public int doStartTag() throws JspException
    {
        try
        {
            // String title = getTitle();
            pageContext.getOut().print(DEFAULT_PAGE_TITLE);
        } catch (IOException ioe)
        {
            // LoggingHelper logHelper = LoggingHelper.getInstance();
            // logHelper.logSystemError(this.getClass().getName(), ioe);
        }
        return super.doStartTag();
    }
}
