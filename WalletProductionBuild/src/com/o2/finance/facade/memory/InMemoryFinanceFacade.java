package com.o2.finance.facade.memory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.o2.finance.beans.AddressBean;
import com.o2.finance.exception.FinanceDelegateException;
import com.o2.finance.exception.FinanceException;
import com.o2.finance.exception.FinanceServiceOtacTriesExceededException;
import com.o2.finance.exception.FinanceServiceSLMBreachException;
import com.o2.finance.exception.FinanceServiceVerificationCodeTriesExceededException;
import com.o2.finance.exception.MaxSecondaryAccsExceededException;
import com.o2.finance.exception.MsisdnBarredException;
import com.o2.finance.exception.UserNameAlreadyExistsException;
import com.o2.finance.exception.unchecked.RuntimeFinanceException;
import com.o2.finance.facade.FinanceFacade;
import com.o2.finance.model.FinanceLocalModel;
import com.o2.finance.model.UserTO;
import com.o2.finance.properties.PropertyManager;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Provides a simple implementation of the {@link com.o2.finance.facade.FinanceFacade} backed by in-memory storage.
 * 
 * This is to be used for testing purposes only.
 * 
 * @author SWatson
 * 
 */
public class InMemoryFinanceFacade extends FinanceFacade
{

    Logger log = LogManager.getLogger( this.getClass() );

    private static final String OTACS_FILE   = "/finance";
    private static final String COOKIES_FILE = "/finance";
    
    private FinanceLocalModel model;
    
    private Map  baseCustomers;
    private Map  baseAddresses;
    private Map  baseOtacs;
    private Map  baseUsernames;
    private Map  baseProducts;
    private List basePostpay;

    private Map  customers;
    private Map  addresses;
    private Map  otacs;
    private Map  usernames;
    private Map  products;
    private List postpay;

    public InMemoryFinanceFacade()
    {
        this(new FinanceLocalModel(),
             new HashMap(), 
             new HashMap(), 
             new HashMap(), 
             new HashMap(),
             new HashMap(),
             new ArrayList());
    }

    public InMemoryFinanceFacade(FinanceLocalModel model, Map customers, Map addresses)
    {
        this(model, customers, addresses, new ArrayList());
    }

    public InMemoryFinanceFacade(FinanceLocalModel model, 
                                 Map               customers, 
                                 Map               addresses, 
                                 List              postpay)
    {
        this(model, customers, addresses, new HashMap(), new HashMap(), postpay);
    }

    public InMemoryFinanceFacade(FinanceLocalModel model, 
                                 Map               customers, 
                                 Map               addresses,
                                 Map               products,
                                 List              postpay)
    {
        this(model, customers, addresses, new HashMap(), products, postpay);
    }

    public InMemoryFinanceFacade(FinanceLocalModel model,
                                 Map               customers, 
                                 Map               addresses, 
                                 Map               otacs,
                                 Map               products,
                                 List              postpay)
    {
        this(model, customers, addresses, otacs, new HashMap(), products, postpay);
    }

    public InMemoryFinanceFacade(FinanceLocalModel model,
                                 Map               customers, 
                                 Map               addresses, 
                                 Map               otacs, 
                                 Map               usernames,
                                 Map               products,
                                 List              postpay)
    {
        this.model         = model;
        this.baseCustomers = customers;
        this.baseAddresses = addresses;
        this.baseOtacs     = otacs;
        this.baseUsernames = usernames;
        this.basePostpay   = postpay;
        this.baseProducts  = products;
        reset();
    }

    public void reset()
    {
        customers = new HashMap();
        Iterator itr = baseCustomers.entrySet().iterator();
        while(itr.hasNext())
        {
            Entry entry = (Entry)itr.next();
            customers.put(entry.getKey(), new UserTO((UserTO)entry.getValue()));
        }

        addresses = new HashMap();
        itr = baseAddresses.entrySet().iterator();
        while(itr.hasNext())
        {
            Entry    entry = (Entry)itr.next();
            List     coll  = new ArrayList();
            Iterator items = ((List)entry.getValue()).iterator();
            while(items.hasNext())
            {
                coll.add(new AddressBean((AddressBean)items.next()));
            }
            
            addresses.put(entry.getKey(), coll);
        }
        
        otacs     = new HashMap(baseOtacs);
        usernames = new HashMap(baseUsernames);
        postpay   = new ArrayList(basePostpay);

        products = new HashMap();
        itr = baseProducts.entrySet().iterator();
        while(itr.hasNext())
        {
            Entry entry = (Entry)itr.next();
            products.put(entry.getKey(), new ArrayList((List)entry.getValue()));
        }

        if (customers != null)
        {
            itr = customers.values().iterator();
            while (itr.hasNext())
            {
                UserTO user = (UserTO) itr.next();
                addAddress(user);
                addUserIdAuthTokenMapping(user);
            }
        }
     }
    
    /*
     * (non-Javadoc)
     * 
     * @see com.o2.finance.facade.FinanceFacade#findAddress(java.lang.String, java.lang.String, java.lang.String)
     */
    public List findAddress(String houseNumber, String houseName, String postcode)
    {
        houseNumber = houseNumber != null ? houseNumber.trim() : "";
        houseName = houseName != null ? houseName.trim() : "";
        postcode = postcode != null ? postcode.trim() : "";
        List out = new ArrayList();
        List result = (List) addresses.get(postcode);
        if (result != null)
        {
            if (houseNumber.length() + houseName.length() > 0)
            {
                Iterator itr = result.iterator();
                while (itr.hasNext())
                {
                    AddressBean bean = (AddressBean) itr.next();
                    if ((houseNumber.length() > 0 && houseNumber.equalsIgnoreCase(bean.getHouseNumber()))
                            || (houseName.length() > 0 && houseName.equalsIgnoreCase(bean.getHouseName())))
                    {
                        out.add(bean);
                    }
                }
            } else
            {
                out.addAll(result);
            }
        }
        return out;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.o2.finance.facade.FinanceFacade#getUserById(java.lang.String)
     */
    public UserTO getUserByUsername(String id)
    {
        return (UserTO) customers.get(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.o2.finance.facade.FinanceFacade#getUsernameFromId(java.lang.String, java.lang.String)
     */
    public String getUsernameFromId(String userId, String authToken)
    {
        UsernameKey key = new UsernameKey(userId, authToken);
        return (String) usernames.get(key);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.o2.finance.facade.FinanceFacade#isUserLoggedIn(java.lang.String, java.lang.String)
     */
    public boolean isUserLoggedIn(String userId, String authToken, boolean authFromRequest) throws FinanceServiceSLMBreachException
    {
	if (StringUtils.equalsIgnoreCase(userId, "slmbreach"))
        {
	    System.out.println("SLM BREACH");       
            FinanceServiceSLMBreachException breach = new FinanceServiceSLMBreachException(
        	    "AG-100000-3000-E", "Rejected by SLM Monitor", null);
            throw breach;
        }
        if(authFromRequest)
        {
            return isUserLoggedIn(userId, authFromRequest);
        }
        return usernames.containsKey(new UsernameKey(userId, authToken));
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.o2.finance.facade.FinanceFacade#getUsersByMsisdn(java.lang.String)
     */
    public Map getUsersByMsisdn(String msisdn)
    {
        Map results = new TreeMap();
        Iterator itr = new ArrayList(customers.values()).iterator();
        while (itr.hasNext())
        {
            UserTO user = (UserTO) itr.next();
            if (user.getMsisdn() != null && user.getMsisdn().equals(msisdn))
            {
                results.put(user.getId(), user);
            }
        }
        return results;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.o2.finance.facade.FinanceFacade#createUser(com.o2.registration.phase2.ejb.valueobjects.CustomerVO)
     */
    public UserTO createUser(UserTO user) throws MsisdnBarredException, MaxSecondaryAccsExceededException,
            UserNameAlreadyExistsException
    {
        UserTO created = user;
        customers.put(created.getId(), created);
        addAddress(created);
        addUserIdAuthTokenMapping(created);
        return new UserTO(created);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.o2.finance.facade.FinanceFacade#updateUser(com.o2.registration.phase2.ejb.valueobjects.CustomerVO)
     */
    public UserTO updateUser(UserTO user)
    {
        String id     = user.getId();
        UserTO stored = (UserTO) customers.get(id);
        if (stored != null)
        {
            customers.put(id, new UserTO(user));
            addAddress(user);
            
            List items =(List)products.get(user.getMsisdn());
            if(items == null)
            {
                items = new ArrayList();
                products.put(user.getMsisdn(), items);
            }
            items.add(model.getProduct().getProductId());
        } 
        else
        {
            RuntimeFinanceException error = new RuntimeFinanceException(this.getClass(),"updateUser",null);
            log.error( error.getMessage(), error );
            throw error;
        }
        return user;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.o2.finance.facade.FinanceFacade#sendOtac(java.lang.String)
     */
    public String sendOtac(String msisdn, String message) throws FinanceServiceVerificationCodeTriesExceededException, FinanceServiceSLMBreachException
    {
		 if (StringUtils.equalsIgnoreCase(msisdn, "447100003000"))
	     {
	         System.out.println("SLM BREACH");       
	         FinanceServiceSLMBreachException breach = new FinanceServiceSLMBreachException(
	     	    "AG-100000-3000-E", "Rejected by SLM Monitor", null);
	         throw breach;
	     }
        
		 String otac = "999999";
	     otacs.put(msisdn, otac);
	     
	     /*
	      * 
	      * Uncomment below code to generate a random OTAC
	      * 
	 	 String time = Long.toString(System.currentTimeMillis());
         String otac = time.substring(time.length() - 6);
     
	     
         String otac = "999999";
	     otacs.put(msisdn, otac);
    	
        FileWriter fos = null;
        try
        {
            URL url = this.getClass().getResource(OTACS_FILE);
            File file = new File(url.getFile(), "otacs");
            if (!file.exists())
            {
                file.createNewFile();
            }
            fos = new FileWriter(file, true);
            fos.write("MSISDN [" + msisdn + "] OTAC [" + otac + "]\n");
        } catch (IOException ioe)
        {
        } finally
        {
            if (fos != null)
            {
                try
                {
                    fos.flush();
                    fos.close();
                } catch (IOException ioe)
                {
                }
            }
        }
	    */
	     
        return otac;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.o2.finance.facade.FinanceFacade#verifyOtac(java.lang.String, java.lang.String)
     */
    public boolean verifyOtac(String msisdn, String otac) throws FinanceServiceOtacTriesExceededException
    {
        return otac.equalsIgnoreCase((String) otacs.get(msisdn));
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.o2.finance.facade.FinanceFacade#isUserPostPay(com.o2.registration.phase2.ejb.valueobjects.CustomerVO)
     */
    public boolean isUserPostPay(UserTO user)
    {
        boolean ispostpay = false;
        if (user != null)
        {
            ispostpay = postpay.contains(user.getId());
        }
        return ispostpay;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.o2.finance.facade.FinanceFacade#validateProductId(java.lang.String)
     */
    public boolean validateProductId(String productID) throws FinanceDelegateException
    {
        List products = PropertyManager.getProductProps().getProductIdList();
        return products.contains(productID);
    }

    public UsernameKey getUsernameKey(UserTO user)
    {
        int mid = (user.getId() + user.getMsisdn()).hashCode();
        mid     = mid < 0 ? -mid : mid;
        int mat = user.getMsisdn().hashCode();
        mat     = mat < 0 ? -mat : mat;
        
        return new UsernameKey(Integer.toString(mid), Integer.toString(mat));
    }

    public List suggestUserName(String forename, String lastname)
    {
        List suggestions = new ArrayList();
        suggestions.add(forename.charAt(0) + "_" + lastname);
        suggestions.add(lastname + "_" + forename);
        return suggestions;
    }

    public boolean hasMsisdnGotProduct(String msisdn, String productId) 
    throws FinanceException
    {
        boolean hasProduct = false;
        
        List items = (List)products.get(msisdn);
        if(items != null)
        {
            hasProduct = items.contains(productId);
        }
        
        return hasProduct;
    }
    
    private void addAddress(UserTO user)
    {
        AddressBean address = extractAddress(user);
        List matches = findAddress(address.getHouseNumber(), address.getHouseName(), address.getPostcode());
        if (matches.isEmpty())
        {
            List var = (List) addresses.get(address.getPostcode());
            if (var == null)
            {
                addresses.put(address.getPostcode(), Arrays.asList(new AddressBean[]
                { address }));
            } else
            {
                var.add(address);
            }
        }
    }

    private AddressBean extractAddress(UserTO user)
    {
        return new AddressBean(user.getHouseNumber(), user.getHouseName(), user.getAddressLine1(), user.getAddressLine2(),
                user.getTownCity(), user.getCounty(), user.getPostcode(), user.getCountry());
    }

    private void addUserIdAuthTokenMapping(UserTO user)
    {
        UsernameKey cookies = getUsernameKey(user);
        usernames.put(cookies, user.getId());
        FileWriter fos = null;
        try
        {
            URL url = this.getClass().getResource(COOKIES_FILE);
            File file = new File(url.getFile(), "cookies");
            if (!file.exists())
            {
                file.createNewFile();
            }
            fos = new FileWriter(file, true);
            fos.write("USERNAME [" + user.getId() + "] MID [" + cookies.userId + "] MAT [" + cookies.authToken + "]\n");
        } catch (IOException ioe)
        {
        } finally
        {
            if (fos != null)
            {
                try
                {
                    fos.flush();
                    fos.close();
                } catch (IOException ioe)
                {
                }
            }
        }
    }

    public class UsernameKey
    {
        public String userId;
        public String authToken;

        /**
         * @param userId
         * @param authToken
         */
        public UsernameKey(String userId, String authToken)
        {
            this.userId = userId;
            this.authToken = authToken;
        }

        public UsernameKey(UsernameKey key)
        {
            this.userId = key.userId;
            this.authToken = key.authToken;
        }

        /*
         * (non-Javadoc)
         * 
         * @see java.lang.Object#hashCode()
         */
        public int hashCode()
        {
            final int prime = 31;
            int result = 1;
            result = prime * result + getOuterType().hashCode();
            result = prime * result + ((authToken == null) ? 0 : authToken.hashCode());
            result = prime * result + ((userId == null) ? 0 : userId.hashCode());
            return result;
        }

        /*
         * (non-Javadoc)
         * 
         * @see java.lang.Object#equals(java.lang.Object)
         */
        public boolean equals(Object obj)
        {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            UsernameKey other = (UsernameKey) obj;
            if (!getOuterType().equals(other.getOuterType()))
                return false;
            if (authToken == null)
            {
                if (other.authToken != null)
                    return false;
            } else if (!authToken.equals(other.authToken))
                return false;
            if (userId == null)
            {
                if (other.userId != null)
                    return false;
            } else if (!userId.equals(other.userId))
                return false;
            return true;
        }

        private InMemoryFinanceFacade getOuterType()
        {
            return InMemoryFinanceFacade.this;
        }
    }

    /**
     * @param customers the customers to set
     */
    public void setCustomers(Map customers)
    {
        this.customers = customers;
    }

    /**
     * @param addresses the addresses to set
     */
    public void setAddresses(Map addresses)
    {
        this.addresses = addresses;
    }

    /**
     * @param otacs the otacs to set
     */
    public void setOtacs(Map otacs)
    {
        this.otacs = otacs;
    }

    /**
     * @param usernames the usernames to set
     */
    public void setUsernames(Map usernames)
    {
        this.usernames = usernames;
    }

    /**
     * @param postpay the postpay to set
     */
    public void setPostpay(List postpay)
    {
        this.postpay = postpay;
    }

    /**
     * @param products the products to set
     */
    public void setProducts(Map products)
    {
        this.products = products;
    }

    /**
     * @param model the model to set
     */
    public void setModel(FinanceLocalModel model)
    {
        this.model = model;
    }
}
