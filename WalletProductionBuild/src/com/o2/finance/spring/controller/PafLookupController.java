/**
 * 
 */
package com.o2.finance.spring.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.o2.finance.etc.RequestParameterConstants;
import com.o2.finance.exception.AddressNotFoundException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.o2.finance.beans.AddressBean;
import com.o2.finance.beans.PafLookupForm;
import com.o2.finance.etc.FinanceConstants;
import com.o2.finance.facade.FinanceFacade;
import com.o2.finance.model.FinanceLocalModel;

/**
 * Web controller to handle a PAF Address lookup.
 * 
 * This handler will take a house number and/or house name along with a postcode, it will request an address from the back-end PAF
 * service and return a list of available addresses for selection.
 * 
 * This handler allows a process to set a 'callback' view request parameter,
 * 
 * e.g. .....pafLookup.do?callback=enterUserDetails.do&.......
 * 
 * the handler will navigate back to this view on successfully selecting an address or when the cancel button has been pressed.
 * 
 * This has been written as a utility request and therefore makes no assumption as to what is to be done with the address, the
 * address is therefore passed back to the caller for actioning.
 * 
 * @author SWatson
 * 
 */
public class PafLookupController extends SimpleFormController implements FinanceConstants, RequestParameterConstants
{
    public static final String REQUEST_ATTR_NAME_ADDRESS = "pafaddress";
    public static final String REQUEST_ATTR_NAME_HOUSE_NAME = ".houseName";
    public static final String REQUEST_ATTR_NAME_HOUSE_NUMBER = ".houseNumber";
    public static final String REQUEST_ATTR_NAME_ADDRESSLINE1 = ".addressLine1";
    public static final String REQUEST_ATTR_NAME_ADDRESSLINE2 = ".addressLine2";
    public static final String REQUEST_ATTR_NAME_TOWN_OR_CITY = ".townOrCity";
    public static final String REQUEST_ATTR_NAME_COUNTY = ".county";
    public static final String REQUEST_ATTR_NAME_POSTCODE = ".postcode";
    public static final String REQUEST_ATTR_NAME_COUNTRY = ".country";
    private FinanceLocalModel localModel;
    private FinanceFacade facade;
    private String initialView;

    private final static Logger log = LogManager.getLogger( PafLookupController.class );


    public PafLookupController()
    {
        super();
    }

    /**
     * @param facacde
     * @param formView
     * @param defaultSuccessView
     */
    public PafLookupController(FinanceLocalModel localModel, FinanceFacade facade, String formView, String defaultSuccessView)
    {
        super();
        log.info( "PafLookupController start." );

        setFormView(formView);
        setSuccessView(defaultSuccessView);
        this.localModel = localModel;
        this.facade = facade;

        log.info( "PafLookupController ends." );
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.web.servlet.mvc.AbstractFormController#formBackingObject(javax.servlet.http.HttpServletRequest)
     */
    protected Object formBackingObject(HttpServletRequest request) throws AddressNotFoundException
    {

        log.info( "formBackingObject start." );
        /*
         * Collect the address look up data from the query parameters and make a request to the back-end PAF service to retrieve a
         * list of matching addresses for selection.
         */
        String houseNumber = (String) request.getParameter(REQUEST_ATTR_NAME_ADDRESS + REQUEST_ATTR_NAME_HOUSE_NUMBER);
        String houseName = (String) request.getParameter(REQUEST_ATTR_NAME_ADDRESS + REQUEST_ATTR_NAME_HOUSE_NAME);
        String postcode = (String) request.getParameter(REQUEST_ATTR_NAME_ADDRESS + REQUEST_ATTR_NAME_POSTCODE);
        AddressBean address = null;

        List results = facade.findAddress(houseNumber, houseName, postcode);
        if (results != null && results.size() > 0)
        {
            /*
             * If at least one result is returned then set the first entry as the default selection.
             */
            address = (AddressBean) results.get(0);
        } else
        {
            // No address found
            address = new AddressBean(houseNumber, houseName, "", "", "", "", postcode, "");
        }

        log.info( "formBackingObject ends." );

        return new PafLookupForm(address, results);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.web.servlet.mvc.SimpleFormController#onSubmit(javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.validation.BindException)
     */
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors)
            throws Exception
    {
        log.info( "onSubmit start." );

        ModelAndView mav = null;

        if (! localModel.isJourneyInitialised() )
        {
            log.info( "Invalid flow access." );
            mav = new ModelAndView( getInvalidFlowView() );
            localModel.clear();
        }
        else
        {

            if (errors != null && errors.hasErrors())
            {
                /*
                 * Validation errors exist so return to the data entry form to display the validation messages.
                 */
                mav = showForm(request, response, errors);
            }
            else
            {

                Map model = null;

                /*
                 * Here we need to return the address back thorough the request, to the designated success view, as this maybe a
                 * redirected view then we need to add the request as set of simple query parameters within the model.
                 *
                 * but only if form not cancelled or the back buton has been pressed.
                 */

                // Back button pressed
                if (isBack( request ))
                {

                    // No addresses found, set paf updated to false
                    log.debug( "Paf updated flag set to false." );
                    localModel.setPafUpdated( false );


                } else if (isCancel( request ))
                {
                    // Form cancelled
                    log.debug( "PAF lookup cancelled." );
                    localModel.setPafUpdated( false );

                } else
                {
                    // Address found and selected
                    /*
                     * This a successful selection of an address we therefore set the Address PAF Validated flag within the local
                     * session model.
                     */
                    localModel.setPafUpdated( true );

                    PafLookupForm form = (PafLookupForm) command;
                    model = getSimpleModelForPafAddress( form.getAddress() );

                }


                String callback = request.getParameter(REQUEST_ATTR_NAME_CALLBACK);
                String forward  = request.getParameter(REQUEST_ATTR_NAME_FORWARD_TO);
                
                if ( localModel.isPafUpdated() && forward != null )
                {
                	/*
                	 * A "forward to" URI has been provided, so instead of going back to the calling page, we take the user forward to the given URI
                	 */
                	mav = new ModelAndView( forward, model );
                }                
                else if (callback != null && callback.trim().length() > 0)
                {
                    /*
                     * A 'callback' query parameter has been provided so we will need to pass the successful address back to this view
                     * via the request.
                     */
                    mav = new ModelAndView(callback, model);
                }
                else
                {
                    /*
                     * No 'callback' parameter was provided so we forward to the default success view.
                     */
                    mav = new ModelAndView(getSuccessView(), model);
                }
            }
        }
        log.info( "onSubmit ends." );
        return mav;
    }

    /**
     * Utility method to create a model contain simple request parameters representing an address.
     *
     * @param {@link com.o2.finance.beans.AddressBean}
     * @return Map - model containing request parameter name value pairs
     */
    public static Map getSimpleModelForPafAddress(AddressBean bean)
    {
        log.info( "getSimpleModelForPafAddress start." );

        Map model = new HashMap();
        if (bean.getHouseNumber().trim().length() > 0)
        {
            model.put(REQUEST_ATTR_NAME_ADDRESS + REQUEST_ATTR_NAME_HOUSE_NUMBER, bean.getHouseNumber());
        }
        if (bean.getHouseName().trim().length() > 0)
        {
            model.put(REQUEST_ATTR_NAME_ADDRESS + REQUEST_ATTR_NAME_HOUSE_NAME, bean.getHouseName());
        }
        if (bean.getAddressLine1().trim().length() > 0)
        {
            model.put(REQUEST_ATTR_NAME_ADDRESS + REQUEST_ATTR_NAME_ADDRESSLINE1, bean.getAddressLine1());
        }
        if (bean.getAddressLine2().trim().length() > 0)
        {
            model.put(REQUEST_ATTR_NAME_ADDRESS + REQUEST_ATTR_NAME_ADDRESSLINE2, bean.getAddressLine2());
        }
        if (bean.getTownOrCity().trim().length() > 0)
        {
            model.put(REQUEST_ATTR_NAME_ADDRESS + REQUEST_ATTR_NAME_TOWN_OR_CITY, bean.getTownOrCity());
        }
        if (bean.getCounty().trim().length() > 0)
        {
            model.put(REQUEST_ATTR_NAME_ADDRESS + REQUEST_ATTR_NAME_COUNTY, bean.getCounty());
        }
        if (bean.getPostcode().trim().length() > 0)
        {
            model.put(REQUEST_ATTR_NAME_ADDRESS + REQUEST_ATTR_NAME_POSTCODE, bean.getPostcode());
        }
        if (bean.getCountry().trim().length() > 0)
        {
            model.put(REQUEST_ATTR_NAME_ADDRESS + REQUEST_ATTR_NAME_COUNTRY, bean.getCountry());
        }


        log.info( "getSimpleModelForPafAddress ends." );
        return model;
    }

    private boolean isCancel( HttpServletRequest request )
    {
        String cancel = request.getParameter( "cancel" );

        return (null != cancel && cancel.trim().length() > 0);

    }


    private boolean isBack( HttpServletRequest request )
    {
        String back   =  request.getParameter( BACK );

        return null != back && back.trim().length() > 0;
    }

    /**
     * Utility method an {@link com.o2.finance.beans.AddressBean} from a set of request query parameters.
     * 
     * e.g. .../pafLookup.do?pafaddress.houseNumber=28&pafaddress.addressLine1=The+Street....
     * 
     * @param {@link com.o2.finance.beans.AddressBean}
     * @return Map - model containing request parameter name value pairs
     */
    public static AddressBean extractPafAddress(HttpServletRequest request)
    {
        log.info( "extractPafAddress start." );

        AddressBean paf = null;
        boolean pafFound = false;
        Enumeration itr = request.getParameterNames();
        while (itr.hasMoreElements() && !pafFound)
        {
            pafFound = ((String) itr.nextElement()).startsWith(PafLookupController.REQUEST_ATTR_NAME_ADDRESS);
        }
        if (pafFound)
        {
            paf = new AddressBean((String) request.getParameter(PafLookupController.REQUEST_ATTR_NAME_ADDRESS + REQUEST_ATTR_NAME_HOUSE_NUMBER),
                    (String) request.getParameter(PafLookupController.REQUEST_ATTR_NAME_ADDRESS + REQUEST_ATTR_NAME_HOUSE_NAME),
                    (String) request.getParameter(PafLookupController.REQUEST_ATTR_NAME_ADDRESS + REQUEST_ATTR_NAME_ADDRESSLINE1),
                    (String) request.getParameter(PafLookupController.REQUEST_ATTR_NAME_ADDRESS + REQUEST_ATTR_NAME_ADDRESSLINE2),
                    (String) request.getParameter(PafLookupController.REQUEST_ATTR_NAME_ADDRESS + REQUEST_ATTR_NAME_TOWN_OR_CITY),
                    (String) request.getParameter(PafLookupController.REQUEST_ATTR_NAME_ADDRESS + REQUEST_ATTR_NAME_COUNTY),
                    (String) request.getParameter(PafLookupController.REQUEST_ATTR_NAME_ADDRESS + REQUEST_ATTR_NAME_POSTCODE),
                    (String) request.getParameter( PafLookupController.REQUEST_ATTR_NAME_ADDRESS + REQUEST_ATTR_NAME_COUNTRY ));


            log.info("Created address from request parameters: " + paf.toString() );

        }

        log.info( "extractPafAddress ends." );
        return paf;
    }

    /**
     * @return the facacde
     */
    public FinanceFacade getFacade()
    {
        return facade;
    }

    /**
     * @param facacde
     *            the facacde to set
     */
    public void setFacade(FinanceFacade facade)
    {
        this.facade = facade;
    }

    /**
     * @return the localModel
     */
    public FinanceLocalModel getLocalModel()
    {
        return localModel;
    }

    /**
     * @param localModel
     *            the localModel to set
     */
    public void setLocalModel(FinanceLocalModel localModel)
    {
        this.localModel = localModel;
    }

    public String getInvalidFlowView()
    {
        return initialView;
    }

    public void setInvalidFlowView( String initialView )
    {
        this.initialView = initialView;
    }
}
