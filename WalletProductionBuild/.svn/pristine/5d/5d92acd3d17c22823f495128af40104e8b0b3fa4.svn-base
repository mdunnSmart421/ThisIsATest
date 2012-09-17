/**
 * 
 */
package com.o2.finance.spring.controller.testing;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 * @author SCroft
 * 
 *         YES- Goes to O2 Login Page NO - Goes to UpdateUserDetails
 */
public class TestingIdChangeController extends SimpleFormController
{
    Logger log = LogManager.getLogger(this.getClass().getName());

    /**
     * On form submission, automatically transfer to view O2 Login Page
     * 
     * @param command
     * @return
     * @throws Exception
     */
    protected ModelAndView onSubmit(Object command) throws Exception
    {
        // TODO - determine whether this should be run based on presence of entry in application property file.
        // NB business logic goes here to determine next view
        //
        log.debug("onSubmit.");
        return new ModelAndView("Yes or No");
    }
}