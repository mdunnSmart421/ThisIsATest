package com.o2.finance.spring.controller.testing;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.o2.finance.beans.EnterMpnForm;
import com.o2.finance.etc.NavigationConstants;

/**
 * Purpose: com.o2.finance.spring.controller User: D Smith Date: 20/05/2011
 */
public class TestingController implements Controller
{
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        // TODO - determine whether this should be run based on presence of entry in application property file.
        // read parameter 'view' from request to send to appropriate view:
        String view = request.getParameter("view");
        Map map = new HashMap();
        if (NavigationConstants.ENTER_MPN.equals(view))
        {
            map.put("enterMpnForm", new EnterMpnForm());
        } else if ("error".equals(view))
        {
            throw new Exception("Test exception");
        }
        return new ModelAndView(view, map);
    }
}
