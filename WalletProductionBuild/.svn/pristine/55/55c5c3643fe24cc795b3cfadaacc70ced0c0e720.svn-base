package com.o2.finance.service;

import com.o2.finance.beans.FriendlyUsernameLabelBean;
import com.o2.finance.exception.SearchServiceIdentitiesExceededException;
import com.o2.finance.exception.unchecked.RuntimeServiceException;
import com.o2.finance.properties.ApplicationProperties;
import com.o2.finance.properties.PropertyManager;
import com.o2.finance.properties.ValidationRegexProperties;
import com.o2.finance.ws.search.searchService.SearchServiceStub;
import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.description.Parameter;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.rampart.RampartMessageData;
import org.apache.rampart.handler.WSSHandlerConstants;
import org.apache.rampart.handler.config.InflowConfiguration;
import uk.co.o2.registration.registration.searchtypes.*;
import v1.commontypes.xsd.types.search.orange.o2.*;
import weblogic.xml.security.specs.User;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: dave
 * Date: 24/02/2012
 * Time: 15:47
 * To change this template use File | Settings | File Templates.
 */
public class SearchServiceImpl extends BasicAuthSupportingService implements SearchService {

    Logger log = LogManager.getLogger(this.getClass());

    
    
    private SearchServiceStub service;


    private SearchServiceImpl() {
        super();
        init();
    }

    private void init() {
        log.info("init start.");
        ApplicationProperties props = PropertyManager.getApplicationProperties();                        
        //String endPoint = "https://orange.stf.ref.o2.co.uk:443/orangeServices-JaxWs/SearchService";
        String endPoint = props.getOrangeSearchServiceEndpoint();
        
        SearchServiceStub stub = null;
        try {
            stub = new SearchServiceStub(getConfigurationContext(), endPoint);
            log.debug("Http Setting up WS creds.");            
            //the original stuff
            ServiceClient client = stub._getServiceClient();
            Options options = client.getOptions();
            client.engageModule("rampart");
            Parameter parm = getInflowConfiguration("Timestamp");
            options.setProperty(WSSHandlerConstants.INFLOW_SECURITY, parm);
            this.service = stub;                       
            log.info("init ends.");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    private Parameter getInflowConfiguration(String item) {
            InflowConfiguration ifc = new InflowConfiguration();
            //set the action item
            ifc.setActionItems(item);
            return ifc.getProperty();
       }



    public static SearchServiceImpl createSearchServiceImpl() {
        return new SearchServiceImpl();
    }


    public List<FriendlyUsernameLabelBean> searchForUsersByMsisdn(String msisdn) throws SearchServiceIdentitiesExceededException {

        log.info("searchForUsersByMsisdn start.");
        
        ApplicationProperties props = PropertyManager.getApplicationProperties(); 
                
        List<FriendlyUsernameLabelBean> users = new ArrayList();
        //ArrayList users = new ArrayList();

        try {
            SearchUserInformationRequest request = new SearchUserInformationRequest();

            SearchUserInformationRequestType param = new SearchUserInformationRequestType();

            // Set Search criteria
            CriteriaType criteria = new CriteriaType();
            Msisdn_type0 msisdnType = new Msisdn_type0();
            msisdnType.setMsisdnType(msisdn);
            criteria.setMsisdn(msisdnType);

            // Set unused option to empty string
            Username_type0 username_type0 = new Username_type0();
            username_type0.setString("");
            username_type0.setMatchingCondition(SearchConditionType.EXACT);

            criteria.setUsername(username_type0);
            param.setSearchCriteria(criteria);

            // Set Search Options
            SearchOptionsType searchOptions = new SearchOptionsType();
            UsernameNamespace_type0 userNamespace = new UsernameNamespace_type0();
            userNamespace.setSource(UsernameNamespaceType.PORTAL);

            // Set unused option to empty string
            userNamespace.setString("");

            searchOptions.setUsernameNamespace(userNamespace);                        
            SummaryListOnMultipleMatch_type0 summaryListOnMultipleMatch_type0 = new SummaryListOnMultipleMatch_type0();
            summaryListOnMultipleMatch_type0.setSummaryMode(SummaryResultsType.ALL);
            // Set unused option to empty string
            summaryListOnMultipleMatch_type0.setString("");
            searchOptions.setSummaryListOnMultipleMatch(summaryListOnMultipleMatch_type0);
            param.setSearchOptions(searchOptions);

            // Set Search Order
            SortOrderDataType sortOrderDataType = new SortOrderDataType();
            FieldSortOrderType fieldSortOrderType = new FieldSortOrderType();

            fieldSortOrderType.setSortBy(SortByListType.BILLING);
            fieldSortOrderType.setSortDirection( SortDirectionType.asc );
            sortOrderDataType.setSortOrderData(fieldSortOrderType);

            param.setSortOrder(sortOrderDataType);

            // Set return types
            ResultDataType resultDataType = new ResultDataType();

            resultDataType.addReturnData(ResultDataListType.portalInfo);
            resultDataType.addReturnData(ResultDataListType.accountLinkageInfo);

            param.setReturnSpecificDataTypes(resultDataType);

            request.setSearchUserInformationRequest(param);

            SearchUserInformationResponse response = service.searchUserInformation(request);
        
            FaultType fault = response.getSearchUserInformationResponse().getFault();
            
            if (fault != null) {
              // a fault has occurred, if it is the exceeded one, then show a nice message to the user
              //else just show the normal error page	
              log.error("The call to the orange search service has thrown a user defined excpetion. " );
              log.error("FaultCode:" + fault.getFaultcode()); 
              log.error("FaultString:" + fault.getFaultstring());
              log.error("FaultDetails:" + fault.getDetail());              
              String faultCode = fault.getFaultcode();
              if (faultCode.equalsIgnoreCase(props.getOrangeSearchServiceIdentitiesExceededErrorCode()))
              {
                  throw new SearchServiceIdentitiesExceededException(fault.getFaultcode(), fault.getFaultstring(),
                          fault.getDetail());
              } else
              {
              	RuntimeServiceException error = new RuntimeServiceException(this.getClass(), "orangeSearchService", null);
                  log.error( error.getMessage(), error );
                  throw error;
              }                            
            }
            else {
              //no fault has occurred
              UserListType ult = response.getSearchUserInformationResponse().getUserInformation();                                                
              if(ult.getCount().intValue() == 0) {
            	//no GUI list to build as no users where returned
              }
              else {
            	//construct the users account list for use in the ChooseAccount Gui screen   
            	users = SearchServiceResultAdapter.constructChooseAccountGuiList(ult.getUser());
            	for(com.o2.finance.beans.FriendlyUsernameLabelBean fulb : users) {	        		
            		log.info("BFID: " + fulb.getBfid());
            		log.info("PORTALID: " + fulb.getPortalId());
            		log.info("USERNAME: " + fulb.getFriendlyUsername());
            		log.info("LABEL: " + fulb.getLabel());	        		
	            }            	                	                
              }
            
            }//end of if userList returned
                        
        } catch (AxisFault axisFault) {
            log.error(axisFault.getMessage(), axisFault);
            throw new RuntimeServiceException(this.getClass(), "searchForUsersByMsisdn", axisFault);

        } catch (RemoteException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeServiceException(this.getClass(), "searchForUsersByMsisdn", e);
        }

        log.info("searchForUsersByMsisdn ends.");
        return users;
    }




}
