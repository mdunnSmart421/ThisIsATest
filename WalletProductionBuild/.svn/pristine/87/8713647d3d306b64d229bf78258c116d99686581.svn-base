/*
 * FeedbackVO.java
 *
 * Created on 20 August 2002, 10:56
 * Merged with P1 on 8 November 2002
 */
package com.o2.finance.model;

import java.io.Serializable;

public class FeedbackTO implements Serializable
{
    private static final long serialVersionUID = 3432665200303863980L;
    public static final int SUCCESSFUL = 0;
    public static final int TEST = 1000;
    public static final int VALIDATION_ERROR = 101;
    public static final int SERVER_ERROR = 102;
    public static final int MESSAGE = 103;
    private int type;
    private String desc;

    public FeedbackTO()
    {
    }

    public FeedbackTO( int type, String desc )
    {
        this.type = type;
        this.desc = desc;
    }

    /**
     * @return the type
     */
    public int getType()
    {
        return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(int type)
    {
        this.type = type;
    }

    /**
     * @return the desc
     */
    public String getDesc()
    {
        return desc != null ? desc : "";
    }

    /**
     * @param desc
     *            the desc to set
     */
    public void setDesc(String desc)
    {
        this.desc = desc;
    }
}
