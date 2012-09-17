package com.o2.finance.beans;

import javax.servlet.http.HttpSession;

import com.o2.finance.properties.PropertyManager;

/**
 * @author SWatson
 * 
 */
public class ProductBean
{
    public static final String SESSION_ATTRIBUTE = "product";
    public static final String HANDOFF_BOA = "BOA";
    public static final String HANDOFF_WAVECREST = "WAVECREST";
    private String productId;

    public ProductBean()
    {
    }

    /**
     * @param productId
     */
    public ProductBean(String productId)
    {
        this.productId = productId;
    }

    /**
     * @return the productId
     */
    public String getProductId()
    {
        return productId;
    }

    /**
     * @param productId
     *            the productId to set
     */
    public void setProductId(String productId)
    {
        this.productId = productId;
    }

    /**
     * @return the productTitle
     */
    public String getProductTitle()
    {
        return PropertyManager.getProductProps().getProductTitle(getProductId());
    }

    public String getProductCopy()
    {
        return PropertyManager.getProductProps().getProductCopy(getProductId());
    }

    public String getProductHandoff()
    {
        return PropertyManager.getProductProps().getProductHandoff(getProductId());
    }

    public String getProductTargetUrl()
    {
        return PropertyManager.getProductProps().getProductTargetUrl(getProductId());
    }

    public String getProductReturnUrl()
    {
        return PropertyManager.getProductProps().getProductReturnUrl(getProductId());
    }


    public String getProductPosBusinessUnit()
    {
        return PropertyManager.getProductProps().getPosBusinessUnit( getProductId() );
    }

    public String getCheckDetailsCopy()
    {
        return PropertyManager.getProductProps().getCheckDetailsCopy( getProductId() );
    }



    public static ProductBean getProduct(String productId, HttpSession session)
    {
        boolean     createNew = false;
    	ProductBean product   = (ProductBean) session.getAttribute(ProductBean.SESSION_ATTRIBUTE);
        
    	if (product == null)
        { 
        	createNew = true;
        }
        else if ( product != null && !productId.equals(product.getProductId()) )
        {
        	createNew = true;
        }
        
        if ( createNew )
        {
        	product = new ProductBean(productId);
        	session.setAttribute(ProductBean.SESSION_ATTRIBUTE, product);
        }
        
        return product;
    }
    
    

    public String getProductSmsMessage()
    {
        return PropertyManager.getProductProps().getSmsCopy( getProductId() );
    }

}




