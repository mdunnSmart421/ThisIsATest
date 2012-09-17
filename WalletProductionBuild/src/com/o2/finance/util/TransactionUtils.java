package com.o2.finance.util;

/**
 * File: TransactionUtils.java
 * Project: O2 A&R
 *
 * @author rstowe
 *
 * Developed by Smart421 (www.smart421.com).
 * (c) Copyright 2010 Telefonica O2 UK Limited.
 */

import org.apache.commons.lang.StringUtils;
import org.safehaus.uuid.UUIDGenerator;

import java.io.Serializable;

/**
 * Utility class providing static methods that implement Orange transaction
 * functionality.
 */
public final class TransactionUtils
{
    private static final String TRANSACTION_PROPERTY = "financeTransactionId";

    /**
     * Private constructor prevents instances of the class being created
     */
    private TransactionUtils()
    {

    }

    /**
     * Sets the id within the {@link ThreadLocalTransaction} to a new UUID
     */
    public static void setThreadLocalId()
    {
        ThreadLocalTransaction.setTransactionId( new TransactionId( getUuidId() ) );
    }

    /**
     * Removes the id from the {@link ThreadLocalTransaction}
     */
    public static void removeThreadLocalId()
    {
        ThreadLocalTransaction.removeTransactionId();
    }

    /**
     * Generates a new UUID
     *
     * @return The UUID
     */
    private static String getUuidId()
    {
        return UUIDGenerator.getInstance().generateRandomBasedUUID().toString();
    }

    /**
     * Returns the current transaction id
     *
     * @return The transaction id
     */
    public static String getTransactionId()
    {
        if (getTransactionIdObj() != null)
        {
            return getTransactionIdObj().getTransactionId();
        } else
        {
            return null;
        }
    }

    /**
     * Returns the current transaction id with a unique suffix
     *
     * @return The transaction id with a unique suffix
     */
    public static String getTransactionIdUniqueSuffix()
    {
        if (getTransactionIdObj() != null)
        {
            return getTransactionIdObj().getTransactionIdUniqueSuffix();
        } else
        {
            return null;
        }
    }

    /**
     * Returns the current transaction ID.
     * The transaction id may exist in one of 2 places:
     * - In this thread's instance of {@link ThreadLocalTransaction}
     * - Held as a property in the Weblogic transaction
     * This class attempts to retrieve a transaction id in the order stated above.
     * If no transaction id can be found null will be returned.
     *
     * @return The transaction id
     */
    private static TransactionId getTransactionIdObj()
    {
        if (ThreadLocalTransaction.getTransactionId() != null)
        {
            return ThreadLocalTransaction.getTransactionId();
        } else
        {
//            return getWeblogicTransactionId();
            return null;
        }

    }

//    /**
//     * Private utility method to retrieve the transaction id from the Weblogic transaction.
//     * If no transaction exists null is returned.
//     * If no transaction id exists in the Weblogic transaction a new UUID is added.
//     * Otherwise the orangeTransactionId property is retrieved from the Weblogic transaction
//     * and returned.
//     *
//     * @return The transaction id
//     */
//    private static TransactionId getWeblogicTransactionId()
//    {
//        final javax.transaction.Transaction transaction = TransactionHelper.getTransactionHelper().getTransaction();
//
//        if (transaction == null || !( transaction instanceof weblogic.transaction.Transaction ))
//        {
//            return null;
//        } else
//        {
//            final weblogic.transaction.Transaction wlTransaction = (weblogic.transaction.Transaction) transaction;
//
//            if (wlTransaction.getProperty( TRANSACTION_PROPERTY ) == null)
//            {
//                wlTransaction.setProperty( TRANSACTION_PROPERTY, new TransactionId( getUuidId() ) );
//            }
//
//            return (TransactionId) wlTransaction.getProperty( TRANSACTION_PROPERTY );
//        }
//    }
}

/**
 * Utility class with static methods used for holding Orange transaction IDs.
 * This class utilises {@link ThreadLocal} to store transaction IDs.
 * on a per-transaction basis
 */
final class ThreadLocalTransaction
{
    private static ThreadLocal threadLocal = new ThreadLocal();

    /**
     * Private constructor prevents instances of the class being created
     */
    private ThreadLocalTransaction()
    {

    }

    /**
     * Retrieves the current transaction ID from the ThreadLocal.
     * Returns null if the id does not exist or is blank.
     *
     * @return The transaction ID
     */
    static TransactionId getTransactionId()
    {
        return (TransactionId) threadLocal.get();
    }

    /**
     * Sets the transaction ID in the ThreadLocal.
     *
     * @param id The transaction ID
     */
    static void setTransactionId( TransactionId id )
    {
        threadLocal.set( id );
    }

    /**
     * Removes the transaction ID from the Threadlocal.
     */
    static void removeTransactionId()
    {
        threadLocal.set( null );
    }
}

/**
 * This class represents an Orange transaction id.
 * It has the capability of applying unique suffixes to the transaction id to make it
 * unique for particular calls
 */
final class TransactionId implements Serializable
{
    private static final long serialVersionUID = 5334815449075132228L;
    private static final int SUFFIX_PAD_LENGTH = 4;
    private static final char SUFFIX_PAD_CHAR = '0';

    private String id;
    private int counter = 1;

    /**
     * Create the transaction id object with an id
     *
     * @param id The id
     */
    public TransactionId( String id )
    {
        this.id = id;
    }

    /**
     * Return the transaction id object
     *
     * @return The transaction id object
     */
    public String getTransactionId()
    {
        return id;
    }

    /**
     * Returns the transaction id with a unique suffix taken from a counter
     *
     * @return The transaction id with unique suffix
     */
    public String getTransactionIdUniqueSuffix()
    {
        final String uniqueTransId = getTransactionId()
                + "-" + StringUtils.leftPad( Integer.toString( counter ), SUFFIX_PAD_LENGTH, SUFFIX_PAD_CHAR );
        counter++;
        return uniqueTransId;
    }
}
