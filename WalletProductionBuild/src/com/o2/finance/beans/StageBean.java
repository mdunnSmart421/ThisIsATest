package com.o2.finance.beans;

import javax.servlet.http.HttpSession;

/**
 * @author SWatson
 * 
 */
public class StageBean
{
    public static final String SESSION_ATTRIBUTE = "processStage";
    private static final String STAGE_APPLY = "APPLY";
    private static final String STAGE_CHECK = "CHECK";
    private static final String STAGE_COMPLETE = "COMPLETE";
    private String stage;

    public StageBean()
    {
        this(STAGE_APPLY);
    }

    /**
     * @param stage
     */
    public StageBean(String stage)
    {
        this.stage = stage;
    }

    /**
     * @return the stage
     */
    public String getStage()
    {
        return stage != null ? stage : "";
    }

    public void setStageToApply()
    {
        this.stage = STAGE_APPLY;
    }

    public void setStageToCheck()
    {
        this.stage = STAGE_CHECK;
    }

    public void setStageToComplete()
    {
        this.stage = STAGE_COMPLETE;
    }

    public static StageBean getStage(HttpSession session)
    {
        StageBean stage = (StageBean) session.getAttribute(StageBean.SESSION_ATTRIBUTE);
        if (stage == null)
        {
            stage = new StageBean();
            session.setAttribute(StageBean.SESSION_ATTRIBUTE, stage);
        }
        return stage;
    }
}
