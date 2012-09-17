package com.o2.finance.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.o2.finance.beans.AddressBean;
import com.o2.finance.facade.FinanceFacade;
import com.o2.finance.model.FinanceLocalModel;
import com.o2.finance.model.UserTO;
import com.o2.finance.properties.PropertyManager;

/**
 * 
 * Web controller to save the updates the user has made on the update details page and PAFconfirm page
 * back to the Orange DB.
 * 
 * The user is then forward to the confirmDetails page.
 * 
 * 
 * @author vkancherla
 *
 */
public class SaveUserUpdatesController extends SimpleFormController
{
	private Logger log = LogManager.getLogger( this.getClass() );
	
	private FinanceLocalModel localModel;
	private FinanceFacade     facade;
	
	/**
	 * 
	 */
	public SaveUserUpdatesController()
	{
		super();
	}
	
	/**
	 * 
	 * @param localModel
	 * @param facade
	 */
	public SaveUserUpdatesController( FinanceLocalModel localModel, FinanceFacade facade )
	{
		super();
		this.localModel = localModel;
		this.facade     = facade;
	}
	
	/**
	 * 
	 */
	public ModelAndView handleRequest( HttpServletRequest request, HttpServletResponse response ) throws Exception
	{
        log.info( "handleRequest start." );
        
        UserTO      user    = localModel.getUser();
        AddressBean address = PafLookupController.extractPafAddress( request );
        
        if ( address != null )   
        {
        	user.setHouseNumber( address.getHouseNumber() );
            user.setHouseName( address.getHouseName() );
            user.setAddressLine1( address.getAddressLine1() );
            user.setAddressLine2( address.getAddressLine2() );
            user.setTownCity( address.getTownOrCity() );
            user.setCounty( address.getCounty() );
            user.setPostcode( address.getPostcode() );
            user.setCountry( address.getCountry() );
        }
        
        user.setPosBusinessUnit( PropertyManager.getProductProps().getPosBusinessUnit( localModel.getProduct().getProductId() ) );
        
        facade.updateUser( user );
        
        UserTO savedUser = facade.getUserByUsername( user.getId() );
        
        localModel.setUser( savedUser );
        // User has updated there data so we will bypass Legacydata checks until next session.
        localModel.setBypassLegacyCheck(true);
        
        
        log.info( "handleRequest end." );
        
        return new ModelAndView( getSuccessView() );
    }

	public FinanceLocalModel getLocalModel() {
		return localModel;
	}

	public void setLocalModel(FinanceLocalModel localModel) {
		this.localModel = localModel;
	}

	public FinanceFacade getFacade() {
		return facade;
	}

	public void setFacade(FinanceFacade facade) {
		this.facade = facade;
	}
}
