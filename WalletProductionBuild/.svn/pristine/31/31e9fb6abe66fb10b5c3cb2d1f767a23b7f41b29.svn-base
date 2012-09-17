package com.o2.finance.etc.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.o2.finance.etc.RequestParameterConstants;
import com.o2.finance.model.FeedbackTO;

public class FeedbackModelBuilder implements RequestParameterConstants
{

    public static Map getFeedbackModel(int type, String message)
    {
        Map model = new HashMap();
        model.put(FEEDBACK_TYPE_REQUEST_KEY, new Integer(type));
        model.put(FEEDBACK_MESSAGE_REQUEST_KEY, message);
        return model;
    }

    public static Map getFeedbackModel(FeedbackTO feedback)
    {
        Map model = new HashMap();
        model.put(FEEDBACK_TYPE_REQUEST_KEY, new Integer(feedback.getType()));
        model.put(FEEDBACK_MESSAGE_REQUEST_KEY, feedback.getDesc());
        return model;
    }

    public static FeedbackTO getFeedback(HttpServletRequest request)
    {
        FeedbackTO feedback = null;
        String type = (String) request.getParameter(FEEDBACK_TYPE_REQUEST_KEY);
        String message = (String) request.getParameter(FEEDBACK_MESSAGE_REQUEST_KEY);
        if (message != null && message.trim().length() > 0)
        {
            feedback = new FeedbackTO(Integer.parseInt(type), message);
        }
        return feedback;
    }
}
