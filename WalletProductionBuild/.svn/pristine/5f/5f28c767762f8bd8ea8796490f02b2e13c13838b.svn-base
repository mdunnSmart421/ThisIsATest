///**
// *
// */
//package com.o2.finance.beans;
//
//import org.apache.commons.lang.StringEscapeUtils;
//
//import com.o2.finance.etc.FinanceConstants;
//import com.o2.finance.model.FinanceLocalModel;
//import com.o2.finance.util.MsisdnConverter;
//import com.o2.finance.util.StringFunctions;
//
///**
// * @author SCroft
// *
// */
//public class MsisdnBackingBean
//{
//    private org.apache.log4j.Logger logger = org.apache.log4j.LogManager.getLogger(this.getClass().getName());
//    private String storedMsisdn;
//    private String newMsisdn;
//    private FinanceLocalModel productModel;
//    private String productId;
//    private String userId;
//
//    /**
//     * @return the productName
//     */
//    public String getProductId()
//    {
//        return productId;
//    }
//
//    /**
//     * @param productName
//     *            the productName to set
//     */
//    public void setProductId(String productId)
//    {
//        this.productId = productId;
//    }
//
//    /**
//     * @return the msisdn
//     */
//    public String getStoredMsisdn()
//    {
//        return storedMsisdn;
//    }
//
//    /**
//     * @return the productModel
//     */
//    public FinanceLocalModel getProductModel()
//    {
//        return productModel;
//    }
//
//    /**
//     * Setting the productModel sets the productName to be used in the backing bean
//     *
//     * @param productModel
//     *            the productModel to set
//     */
//    public void setProductModel(FinanceLocalModel productModel)
//    {
//        logger.debug("set the product model name in EnterOtacBackingBean");
//        String productId;
//        if (productModel != null)
//        {
//            productId = productModel.getProduct().getProductId();
//            logger.debug("productModel productId = " + productId);
//            this.productId = StringEscapeUtils.escapeHtml(productId);
//            logger.debug("Filtered productModel productId = " + productId);
//        }
//        // this.productModel = productModel;
//    }
//
//    /**
//     * Setting the storedMsisdn set the msisdn to be displayed in the backing bean
//     *
//     * @param msisdn
//     *            the msisdn to set
//     */
//    public void setStoredMsisdn(String storedMsisdn)
//    {
//        logger.debug("set stored msisdn in otacBackingBean = " + storedMsisdn);
//        if (storedMsisdn != null)
//        {
//            this.storedMsisdn = filterString(storedMsisdn);
//            logger.debug("Filtered stored msisdn = " + storedMsisdn);
//        }
//    }
//
//    /**
//     * Filter strings, used in old and new msisdn
//     *
//     * @param storedMsisdn
//     *            or new msisdn
//     * @return String
//     */
//    private String filterString(String toFilter)
//    {
//        String validChar = StringFunctions.acceptValidCharacters(MsisdnConverter.msisdnToNational(toFilter),
//                FinanceConstants.DISALLOWED_XSS_CHARACTERS);
//        String escapedStr = StringEscapeUtils.escapeHtml(validChar);
//        return escapedStr;
//    }
//
//    /**
//     * @return the newMsisdn
//     */
//    public String getNewMsisdn()
//    {
//        return newMsisdn;
//    }
//
//    /**
//     * @param newMsisdn
//     *            the newMsisdn to set
//     */
//    public void setNewMsisdn(Object objMsisdn)
//    {
//        String newMsisdn = (String) objMsisdn;
//        logger.debug("set new msisdn in otacBackingBean = " + newMsisdn);
//        if (newMsisdn != null)
//        {
//            this.newMsisdn = filterString(newMsisdn);
//            logger.debug("filtered new msisdn in otacBackingBean = " + newMsisdn);
//        }
//    }
//
//    /**
//     * @return the userId
//     */
//    public String getUserId()
//    {
//        return userId;
//    }
//
//    /**
//     * @param userId
//     *            the userId to set
//     */
//    public void setUserId(String userId)
//    {
//        // String newMsisdn = (String) objMsisdn;
//        logger.debug("set userId = " + userId);
//        if (userId != null)
//        {
//            this.userId = filterString(userId);
//            logger.debug("filtered userId = " + userId);
//        }
//    }
//}
///*
// * <!-- This is JSP page RequestPinValidation.jsp --> <%-- RequestPinValidation.jsp Version: 1.00 Description: Allow the user to
// * enter the receive verification code during the registration process --%> <%--FinanceLocalModel productModel =
// * (FinanceLocalModel)session.getAttribute("user");--%>
// *
// * <%--String storedMsisdn = (String)request.getSession().getAttribute(ProductRegistrationConstants.UNVERIFIED_MSISDN);--%>
// * <%--String productName = null;--%> <%--String verificationCode = null;--%> <%--if (productModel != null)--%> <%--{--%>
// * <%--productName = productModel.getProductId();--%> <%--productName = StringEscapeUtils.escapeHtml(productName);--%> <%--}--%>
// * <%--if (storedMsisdn != null)--%> <%--{--%> <%--storedMsisdn =
// * StringFunctions.acceptValidCharacters(MsisdnConverter.msisdnToNational(storedMsisdn),
// * ProductRegistrationConstants.DISALLOWED_XSS_CHARACTERS);--%> <%--storedMsisdn = StringEscapeUtils.escapeHtml(storedMsisdn);--%>
// * <%--}--%>
// *
// * <%--request.getSession().getAttribute(ProductRegistrationConstants.UNVERIFIED_MSISDN);--%> <%--%>--%>
// */
