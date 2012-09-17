package com.o2.finance.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.o2.finance.beans.FriendlyUsernameLabelBean;
import v1.datamodel.xsd.types.search.orange.o2.AccountLinkageType;
import v1.datamodel.xsd.types.search.orange.o2.IdentityDataType;
import v1.datamodel.xsd.types.search.orange.o2.LinkedAccount_type0;
import v1.datamodel.xsd.types.search.orange.o2.PortalDataType;
import v1.datamodel.xsd.types.search.orange.o2.ProfileDataType;
import v1.datamodel.xsd.types.search.orange.o2.UserDataType;


/**
 * Adapt the searchService result list into a lightweight list containing just the information
 * required for the chooseAccount Gui screen.
 * @author ADawson
 */
public class SearchServiceResultAdapter {

	static Logger log = LogManager.getLogger("com.o2.finance.service.SearchServiceResultAdapter");
	
public static List<FriendlyUsernameLabelBean> constructChooseAccountGuiList(UserDataType[] searchServiceResultUserList) {
		
				
		Map<String, FriendlyUsernameLabelBean> tmpMap = new HashMap<String, FriendlyUsernameLabelBean>(); 
		
		ProfileDataType profileDataType;
		IdentityDataType identityDataType;
		PortalDataType[] portalDataTypeArr;
		AccountLinkageType accountLinkageType;

		int userIndex = 0;
		for(UserDataType user : searchServiceResultUserList) {
			userIndex++;			
			log.info("USER: " + userIndex);						
			profileDataType = user.getProfile();
			identityDataType = user.getIdentity();
			portalDataTypeArr = user.getPortal();
			accountLinkageType = user.getAccountLinkage();
			//identity data
			log.info("IDENTITY UID: " + identityDataType.getUID());
            
			//linkedAccount data
			LinkedAccount_type0[] linkedAccountArr = accountLinkageType.getLinkedAccount();
			log.info("Number of linked Accounts " + linkedAccountArr.length);
			int linkedAccountIndex = 0;
			for(LinkedAccount_type0 linkedAccount : linkedAccountArr) {
				linkedAccountIndex++;
				log.info("		ACCOUNTLINKAGE LINKEDACCOUNT                  : " + linkedAccountIndex);
				log.info("		ACCOUNTLINKAGE LINKEDACCOUNT ISDEFAULT        : " + linkedAccount.getIsDefault());
				log.info("		ACCOUNTLINKAGE LINKEDACCOUNT LABEL            : " + linkedAccount.getLabel()); 
				log.info("		ACCOUNTLINKAGE LINKEDACCOUNT FRIENDLY USERNAME: " + linkedAccount.getUsernameRef().getUsername());
				log.info("		ACCOUNTLINKAGE LINKEDACCOUNT IDENTITY UID REF : " + linkedAccount.getUsernameRef().getId());				
				log.info("		ACCOUNTLINKAGE LINKEDACCOUNT PORTAL BFID REF  : " + linkedAccount.getUsernameRef().getBFID());								
			
			    //only put our default accounts into the map			
			    if(linkedAccount.getIsDefault()) {
			       tmpMap.put (linkedAccount.getUsernameRef().getBFID().toString(),
					           new FriendlyUsernameLabelBean(
					               linkedAccount.getUsernameRef().getBFID().toString(),
					               linkedAccount.getUsernameRef().getUsername().toString(),
					               linkedAccount.getLabel()));
			    }
			
			} //end of likedaccount loop
			
			//at this point we have Map of FriendlyUsernameLabels with no corresponding portal ids.
			
			//loop through portal data and add the portal ids to the corresponding accounts			
			log.info("Number of Portals " + portalDataTypeArr.length);
			int portalIndex = 0;
			for(PortalDataType portalDataType : portalDataTypeArr) {
				portalIndex++;
				log.info("	PORTAL       : " + portalIndex);
				log.info("	PORTAL ID    : " + portalDataType.getUsername());
				log.info("	PORTAL BFID  : " + portalDataType.getBFID());
				log.info("	PORTAL MSISDN: " + portalDataType.getMsisdn());						
				if(tmpMap.containsKey(portalDataType.getBFID().toString())) {					
					FriendlyUsernameLabelBean currentBean = tmpMap.get(portalDataType.getBFID().toString());
					//note the portal id is used as the username
					currentBean.setPortalId((portalDataType.getUsername().toString()));										
				}
				
				
			}
			//now all out beans should have all the values
			
		}				
								 
		Collection<FriendlyUsernameLabelBean> myColl = tmpMap.values();
		List<FriendlyUsernameLabelBean> friendlyUsernameLabelBeanList = new ArrayList<FriendlyUsernameLabelBean>(myColl);
		return friendlyUsernameLabelBeanList;
	}
	
}
