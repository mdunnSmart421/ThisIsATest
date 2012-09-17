/**
 * AvatarServiceStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:35 LKT)
 */
package com.o2.finance.ws.orange;

/*
 *  AvatarServiceStub java implementation
 */
public class AvatarServiceStub extends org.apache.axis2.client.Stub implements AvatarService
{
    protected org.apache.axis2.description.AxisOperation[] _operations;
    // hashmaps to keep the fault mapping
    private java.util.HashMap faultExceptionNameMap = new java.util.HashMap();
    private java.util.HashMap faultExceptionClassNameMap = new java.util.HashMap();
    private java.util.HashMap faultMessageMap = new java.util.HashMap();
    private static int counter = 0;

    private static synchronized String getUniqueSuffix()
    {
        // reset the counter if it is greater than 99999
        if (counter > 99999)
        {
            counter = 0;
        }
        counter = counter + 1;
        return Long.toString(System.currentTimeMillis()) + "_" + counter;
    }

    private void populateAxisService() throws org.apache.axis2.AxisFault
    {
        // creating the Service with a unique name
        _service = new org.apache.axis2.description.AxisService("AvatarService" + getUniqueSuffix());
        addAnonymousOperations();
        // creating the operations
        org.apache.axis2.description.AxisOperation __operation;
        _operations = new org.apache.axis2.description.AxisOperation[6];
        __operation = new org.apache.axis2.description.OutInAxisOperation();
        __operation
                .setName(new javax.xml.namespace.QName("http://www.o2.com/broadband/AvatarService", "searchForUsersByCustNum"));
        _service.addOperation(__operation);
        _operations[0] = __operation;
        __operation = new org.apache.axis2.description.OutInAxisOperation();
        __operation.setName(new javax.xml.namespace.QName("http://www.o2.com/broadband/AvatarService", "suggestUserName"));
        _service.addOperation(__operation);
        _operations[1] = __operation;
        __operation = new org.apache.axis2.description.OutInAxisOperation();
        __operation.setName(new javax.xml.namespace.QName("http://www.o2.com/broadband/AvatarService", "createUser"));
        _service.addOperation(__operation);
        _operations[2] = __operation;
        __operation = new org.apache.axis2.description.OutInAxisOperation();
        __operation.setName(new javax.xml.namespace.QName("http://www.o2.com/broadband/AvatarService", "searchForUsersByMSISDN"));
        _service.addOperation(__operation);
        _operations[3] = __operation;
        __operation = new org.apache.axis2.description.OutInAxisOperation();
        __operation.setName(new javax.xml.namespace.QName("http://www.o2.com/broadband/AvatarService", "updateUser"));
        _service.addOperation(__operation);
        _operations[4] = __operation;
        __operation = new org.apache.axis2.description.OutInAxisOperation();
        __operation
                .setName(new javax.xml.namespace.QName("http://www.o2.com/broadband/AvatarService", "searchForUsersByUserName"));
        _service.addOperation(__operation);
        _operations[5] = __operation;
    }

    // populates the faults
    private void populateFaults()
    {
    }

    /**
     * Constructor that takes in a configContext
     */
    public AvatarServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext, java.lang.String targetEndpoint)
            throws org.apache.axis2.AxisFault
    {
        this(configurationContext, targetEndpoint, false);
    }

    /**
     * Constructor that takes in a configContext and useseperate listner
     */
    public AvatarServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext, java.lang.String targetEndpoint,
            boolean useSeparateListener) throws org.apache.axis2.AxisFault
    {
        // To populate AxisService
        populateAxisService();
        populateFaults();
        _serviceClient = new org.apache.axis2.client.ServiceClient(configurationContext, _service);
        configurationContext = _serviceClient.getServiceContext().getConfigurationContext();
        _serviceClient.getOptions().setTo(new org.apache.axis2.addressing.EndpointReference(targetEndpoint));
        _serviceClient.getOptions().setUseSeparateListener(useSeparateListener);
    }

    /**
     * Default Constructor
     */
    public AvatarServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext)
            throws org.apache.axis2.AxisFault
    {
        this(configurationContext, "https://speedy.london.02.net:8443/broadband/AvatarService");
    }

    /**
     * Default Constructor
     */
    public AvatarServiceStub() throws org.apache.axis2.AxisFault
    {
        this("https://speedy.london.02.net:8443/broadband/AvatarService");
    }

    /**
     * Constructor taking the target endpoint
     */
    public AvatarServiceStub(java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault
    {
        this(null, targetEndpoint);
    }

    /**
     * Auto generated method signature
     * 
     * @see com.o2.finance.ws.orange.AvatarService#searchForUsersByCustNum
     * @param searchForUsersByCustNumRequest0
     */
    public com.o2.www.broadband.avatartypes.SearchForUsersByCustNumResponse searchForUsersByCustNum(
            com.o2.www.broadband.avatartypes.SearchForUsersByCustNumRequest searchForUsersByCustNumRequest0)
            throws java.rmi.RemoteException
    {
        org.apache.axis2.context.MessageContext _messageContext = null;
        try
        {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
            _operationClient.getOptions().setAction("\"\"");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);
            addPropertyToOperationClient(_operationClient,
                    org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR, "&");
            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();
            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;
            env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), searchForUsersByCustNumRequest0,
                    optimizeContent(new javax.xml.namespace.QName("http://www.o2.com/broadband/AvatarService",
                            "searchForUsersByCustNum")));
            // adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);
            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);
            // execute the operation client
            _operationClient.execute(true);
            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient
                    .getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
            java.lang.Object object = fromOM(_returnEnv.getBody().getFirstElement(),
                    com.o2.www.broadband.avatartypes.SearchForUsersByCustNumResponse.class, getEnvelopeNamespaces(_returnEnv));
            return (com.o2.www.broadband.avatartypes.SearchForUsersByCustNumResponse) object;
        } catch (org.apache.axis2.AxisFault f)
        {
            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt != null)
            {
                if (faultExceptionNameMap.containsKey(faultElt.getQName()))
                {
                    // make the fault by reflection
                    try
                    {
                        java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(faultElt
                                .getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex = (java.lang.Exception) exceptionClass.newInstance();
                        // message class
                        java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage", new java.lang.Class[]
                        { messageClass });
                        m.invoke(ex, new java.lang.Object[]
                        { messageObject });
                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (java.lang.ClassCastException e)
                    {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e)
                    {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.NoSuchMethodException e)
                    {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e)
                    {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.IllegalAccessException e)
                    {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.InstantiationException e)
                    {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else
                {
                    throw f;
                }
            } else
            {
                throw f;
            }
        } finally
        {
            _messageContext.getTransportOut().getSender().cleanup(_messageContext);
        }
    }

    /**
     * Auto generated method signature
     * 
     * @see com.o2.finance.ws.orange.AvatarService#suggestUserName
     * @param suggestUserNameRequest2
     */
    public com.o2.www.broadband.avatartypes.SuggestUserNameResponse suggestUserName(
            com.o2.www.broadband.avatartypes.SuggestUserNameRequest suggestUserNameRequest2) throws java.rmi.RemoteException
    {
        org.apache.axis2.context.MessageContext _messageContext = null;
        try
        {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[1].getName());
            _operationClient.getOptions().setAction("\"\"");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);
            addPropertyToOperationClient(_operationClient,
                    org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR, "&");
            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();
            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;
            env = toEnvelope(
                    getFactory(_operationClient.getOptions().getSoapVersionURI()),
                    suggestUserNameRequest2,
                    optimizeContent(new javax.xml.namespace.QName("http://www.o2.com/broadband/AvatarService", "suggestUserName")));
            // adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);
            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);
            // execute the operation client
            _operationClient.execute(true);
            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient
                    .getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
            java.lang.Object object = fromOM(_returnEnv.getBody().getFirstElement(),
                    com.o2.www.broadband.avatartypes.SuggestUserNameResponse.class, getEnvelopeNamespaces(_returnEnv));
            return (com.o2.www.broadband.avatartypes.SuggestUserNameResponse) object;
        } catch (org.apache.axis2.AxisFault f)
        {
            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt != null)
            {
                if (faultExceptionNameMap.containsKey(faultElt.getQName()))
                {
                    // make the fault by reflection
                    try
                    {
                        java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(faultElt
                                .getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex = (java.lang.Exception) exceptionClass.newInstance();
                        // message class
                        java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage", new java.lang.Class[]
                        { messageClass });
                        m.invoke(ex, new java.lang.Object[]
                        { messageObject });
                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (java.lang.ClassCastException e)
                    {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e)
                    {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.NoSuchMethodException e)
                    {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e)
                    {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.IllegalAccessException e)
                    {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.InstantiationException e)
                    {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else
                {
                    throw f;
                }
            } else
            {
                throw f;
            }
        } finally
        {
            _messageContext.getTransportOut().getSender().cleanup(_messageContext);
        }
    }

    /**
     * Auto generated method signature
     * 
     * @see com.o2.finance.ws.orange.AvatarService#createUser
     * @param createUserRequest4
     */
    public com.o2.www.broadband.avatartypes.CreateUserResponse createUser(
            com.o2.www.broadband.avatartypes.CreateUserRequest createUserRequest4) throws java.rmi.RemoteException
    {
        org.apache.axis2.context.MessageContext _messageContext = null;
        try
        {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[2].getName());
            _operationClient.getOptions().setAction("\"\"");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);
            addPropertyToOperationClient(_operationClient,
                    org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR, "&");
            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();
            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;
            env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), createUserRequest4,
                    optimizeContent(new javax.xml.namespace.QName("http://www.o2.com/broadband/AvatarService", "createUser")));
            // adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);
            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);
            // execute the operation client
            _operationClient.execute(true);
            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient
                    .getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
            java.lang.Object object = fromOM(_returnEnv.getBody().getFirstElement(),
                    com.o2.www.broadband.avatartypes.CreateUserResponse.class, getEnvelopeNamespaces(_returnEnv));
            return (com.o2.www.broadband.avatartypes.CreateUserResponse) object;
        } catch (org.apache.axis2.AxisFault f)
        {
            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt != null)
            {
                if (faultExceptionNameMap.containsKey(faultElt.getQName()))
                {
                    // make the fault by reflection
                    try
                    {
                        java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(faultElt
                                .getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex = (java.lang.Exception) exceptionClass.newInstance();
                        // message class
                        java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage", new java.lang.Class[]
                        { messageClass });
                        m.invoke(ex, new java.lang.Object[]
                        { messageObject });
                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (java.lang.ClassCastException e)
                    {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e)
                    {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.NoSuchMethodException e)
                    {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e)
                    {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.IllegalAccessException e)
                    {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.InstantiationException e)
                    {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else
                {
                    throw f;
                }
            } else
            {
                throw f;
            }
        } finally
        {
            _messageContext.getTransportOut().getSender().cleanup(_messageContext);
        }
    }

    /**
     * Auto generated method signature
     * 
     * @see com.o2.finance.ws.orange.AvatarService#searchForUsersByMSISDN
     * @param searchForUsersByMSISDNRequest6
     */
    public com.o2.www.broadband.avatartypes.SearchForUsersByMSISDNResponse searchForUsersByMSISDN(
            com.o2.www.broadband.avatartypes.SearchForUsersByMSISDNRequest searchForUsersByMSISDNRequest6)
            throws java.rmi.RemoteException
    {
        org.apache.axis2.context.MessageContext _messageContext = null;
        try
        {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[3].getName());
            _operationClient.getOptions().setAction("\"\"");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);
            addPropertyToOperationClient(_operationClient,
                    org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR, "&");
            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();
            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;
            env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), searchForUsersByMSISDNRequest6,
                    optimizeContent(new javax.xml.namespace.QName("http://www.o2.com/broadband/AvatarService",
                            "searchForUsersByMSISDN")));
            // adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);
            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);
            // execute the operation client
            _operationClient.execute(true);
            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient
                    .getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
            java.lang.Object object = fromOM(_returnEnv.getBody().getFirstElement(),
                    com.o2.www.broadband.avatartypes.SearchForUsersByMSISDNResponse.class, getEnvelopeNamespaces(_returnEnv));
            return (com.o2.www.broadband.avatartypes.SearchForUsersByMSISDNResponse) object;
        } catch (org.apache.axis2.AxisFault f)
        {
            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt != null)
            {
                if (faultExceptionNameMap.containsKey(faultElt.getQName()))
                {
                    // make the fault by reflection
                    try
                    {
                        java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(faultElt
                                .getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex = (java.lang.Exception) exceptionClass.newInstance();
                        // message class
                        java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage", new java.lang.Class[]
                        { messageClass });
                        m.invoke(ex, new java.lang.Object[]
                        { messageObject });
                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (java.lang.ClassCastException e)
                    {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e)
                    {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.NoSuchMethodException e)
                    {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e)
                    {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.IllegalAccessException e)
                    {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.InstantiationException e)
                    {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else
                {
                    throw f;
                }
            } else
            {
                throw f;
            }
        } finally
        {
            _messageContext.getTransportOut().getSender().cleanup(_messageContext);
        }
    }

    /**
     * Auto generated method signature
     * 
     * @see com.o2.finance.ws.orange.AvatarService#updateUser
     * @param updateUserRequest8
     */
    public com.o2.www.broadband.avatartypes.UpdateUserResponse updateUser(
            com.o2.www.broadband.avatartypes.UpdateUserRequest updateUserRequest8) throws java.rmi.RemoteException
    {
        org.apache.axis2.context.MessageContext _messageContext = null;
        try
        {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[4].getName());
            _operationClient.getOptions().setAction("\"\"");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);
            addPropertyToOperationClient(_operationClient,
                    org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR, "&");
            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();
            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;
            env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), updateUserRequest8,
                    optimizeContent(new javax.xml.namespace.QName("http://www.o2.com/broadband/AvatarService", "updateUser")));
            // adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);
            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);
            // execute the operation client
            _operationClient.execute(true);
            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient
                    .getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
            java.lang.Object object = fromOM(_returnEnv.getBody().getFirstElement(),
                    com.o2.www.broadband.avatartypes.UpdateUserResponse.class, getEnvelopeNamespaces(_returnEnv));
            return (com.o2.www.broadband.avatartypes.UpdateUserResponse) object;
        } catch (org.apache.axis2.AxisFault f)
        {
            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt != null)
            {
                if (faultExceptionNameMap.containsKey(faultElt.getQName()))
                {
                    // make the fault by reflection
                    try
                    {
                        java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(faultElt
                                .getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex = (java.lang.Exception) exceptionClass.newInstance();
                        // message class
                        java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage", new java.lang.Class[]
                        { messageClass });
                        m.invoke(ex, new java.lang.Object[]
                        { messageObject });
                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (java.lang.ClassCastException e)
                    {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e)
                    {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.NoSuchMethodException e)
                    {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e)
                    {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.IllegalAccessException e)
                    {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.InstantiationException e)
                    {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else
                {
                    throw f;
                }
            } else
            {
                throw f;
            }
        } finally
        {
            _messageContext.getTransportOut().getSender().cleanup(_messageContext);
        }
    }

    /**
     * Auto generated method signature
     * 
     * @see com.o2.finance.ws.orange.AvatarService#searchForUsersByUserName
     * @param searchForUsersByUserNameRequest10
     */
    public com.o2.www.broadband.avatartypes.SearchForUsersByUserNameResponse searchForUsersByUserName(
            com.o2.www.broadband.avatartypes.SearchForUsersByUserNameRequest searchForUsersByUserNameRequest10)
            throws java.rmi.RemoteException
    {
        org.apache.axis2.context.MessageContext _messageContext = null;
        try
        {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[5].getName());
            _operationClient.getOptions().setAction("\"\"");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);
            addPropertyToOperationClient(_operationClient,
                    org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR, "&");
            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();
            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;
            env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), searchForUsersByUserNameRequest10,
                    optimizeContent(new javax.xml.namespace.QName("http://www.o2.com/broadband/AvatarService",
                            "searchForUsersByUserName")));
            // adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);
            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);
            // execute the operation client
            _operationClient.execute(true);
            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient
                    .getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
            java.lang.Object object = fromOM(_returnEnv.getBody().getFirstElement(),
                    com.o2.www.broadband.avatartypes.SearchForUsersByUserNameResponse.class, getEnvelopeNamespaces(_returnEnv));
            return (com.o2.www.broadband.avatartypes.SearchForUsersByUserNameResponse) object;
        } catch (org.apache.axis2.AxisFault f)
        {
            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt != null)
            {
                if (faultExceptionNameMap.containsKey(faultElt.getQName()))
                {
                    // make the fault by reflection
                    try
                    {
                        java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(faultElt
                                .getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex = (java.lang.Exception) exceptionClass.newInstance();
                        // message class
                        java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage", new java.lang.Class[]
                        { messageClass });
                        m.invoke(ex, new java.lang.Object[]
                        { messageObject });
                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (java.lang.ClassCastException e)
                    {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e)
                    {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.NoSuchMethodException e)
                    {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e)
                    {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.IllegalAccessException e)
                    {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.InstantiationException e)
                    {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else
                {
                    throw f;
                }
            } else
            {
                throw f;
            }
        } finally
        {
            _messageContext.getTransportOut().getSender().cleanup(_messageContext);
        }
    }

    /**
     * A utility method that copies the namepaces from the SOAPEnvelope
     */
    private java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env)
    {
        java.util.Map returnMap = new java.util.HashMap();
        java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
        while (namespaceIterator.hasNext())
        {
            org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
            returnMap.put(ns.getPrefix(), ns.getNamespaceURI());
        }
        return returnMap;
    }
    private javax.xml.namespace.QName[] opNameArray = null;

    private boolean optimizeContent(javax.xml.namespace.QName opName)
    {
        if (opNameArray == null)
        {
            return false;
        }
        for (int i = 0; i < opNameArray.length; i++)
        {
            if (opName.equals(opNameArray[i]))
            {
                return true;
            }
        }
        return false;
    }

    // https://speedy.london.02.net:8443/broadband/AvatarService
    private org.apache.axiom.om.OMElement toOM(com.o2.www.broadband.avatartypes.SearchForUsersByCustNumRequest param,
            boolean optimizeContent) throws org.apache.axis2.AxisFault
    {
        try
        {
            return param.getOMElement(com.o2.www.broadband.avatartypes.SearchForUsersByCustNumRequest.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e)
        {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(com.o2.www.broadband.avatartypes.SearchForUsersByCustNumResponse param,
            boolean optimizeContent) throws org.apache.axis2.AxisFault
    {
        try
        {
            return param.getOMElement(com.o2.www.broadband.avatartypes.SearchForUsersByCustNumResponse.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e)
        {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(com.o2.www.broadband.avatartypes.SuggestUserNameRequest param,
            boolean optimizeContent) throws org.apache.axis2.AxisFault
    {
        try
        {
            return param.getOMElement(com.o2.www.broadband.avatartypes.SuggestUserNameRequest.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e)
        {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(com.o2.www.broadband.avatartypes.SuggestUserNameResponse param,
            boolean optimizeContent) throws org.apache.axis2.AxisFault
    {
        try
        {
            return param.getOMElement(com.o2.www.broadband.avatartypes.SuggestUserNameResponse.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e)
        {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(com.o2.www.broadband.avatartypes.CreateUserRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault
    {
        try
        {
            return param.getOMElement(com.o2.www.broadband.avatartypes.CreateUserRequest.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e)
        {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(com.o2.www.broadband.avatartypes.CreateUserResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault
    {
        try
        {
            return param.getOMElement(com.o2.www.broadband.avatartypes.CreateUserResponse.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e)
        {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(com.o2.www.broadband.avatartypes.SearchForUsersByMSISDNRequest param,
            boolean optimizeContent) throws org.apache.axis2.AxisFault
    {
        try
        {
            return param.getOMElement(com.o2.www.broadband.avatartypes.SearchForUsersByMSISDNRequest.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e)
        {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(com.o2.www.broadband.avatartypes.SearchForUsersByMSISDNResponse param,
            boolean optimizeContent) throws org.apache.axis2.AxisFault
    {
        try
        {
            return param.getOMElement(com.o2.www.broadband.avatartypes.SearchForUsersByMSISDNResponse.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e)
        {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(com.o2.www.broadband.avatartypes.UpdateUserRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault
    {
        try
        {
            return param.getOMElement(com.o2.www.broadband.avatartypes.UpdateUserRequest.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e)
        {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(com.o2.www.broadband.avatartypes.UpdateUserResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault
    {
        try
        {
            return param.getOMElement(com.o2.www.broadband.avatartypes.UpdateUserResponse.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e)
        {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(com.o2.www.broadband.avatartypes.SearchForUsersByUserNameRequest param,
            boolean optimizeContent) throws org.apache.axis2.AxisFault
    {
        try
        {
            return param.getOMElement(com.o2.www.broadband.avatartypes.SearchForUsersByUserNameRequest.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e)
        {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(com.o2.www.broadband.avatartypes.SearchForUsersByUserNameResponse param,
            boolean optimizeContent) throws org.apache.axis2.AxisFault
    {
        try
        {
            return param.getOMElement(com.o2.www.broadband.avatartypes.SearchForUsersByUserNameResponse.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e)
        {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
            com.o2.www.broadband.avatartypes.SearchForUsersByCustNumRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault
    {
        try
        {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody().addChild(
                    param.getOMElement(com.o2.www.broadband.avatartypes.SearchForUsersByCustNumRequest.MY_QNAME, factory));
            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e)
        {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    /* methods to provide back word compatibility */
    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
            com.o2.www.broadband.avatartypes.SuggestUserNameRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault
    {
        try
        {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody().addChild(
                    param.getOMElement(com.o2.www.broadband.avatartypes.SuggestUserNameRequest.MY_QNAME, factory));
            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e)
        {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    /* methods to provide back word compatibility */
    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
            com.o2.www.broadband.avatartypes.CreateUserRequest param, boolean optimizeContent) throws org.apache.axis2.AxisFault
    {
        try
        {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody().addChild(
                    param.getOMElement(com.o2.www.broadband.avatartypes.CreateUserRequest.MY_QNAME, factory));
            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e)
        {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    /* methods to provide back word compatibility */
    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
            com.o2.www.broadband.avatartypes.SearchForUsersByMSISDNRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault
    {
        try
        {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody().addChild(
                    param.getOMElement(com.o2.www.broadband.avatartypes.SearchForUsersByMSISDNRequest.MY_QNAME, factory));
            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e)
        {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    /* methods to provide back word compatibility */
    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
            com.o2.www.broadband.avatartypes.UpdateUserRequest param, boolean optimizeContent) throws org.apache.axis2.AxisFault
    {
        try
        {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody().addChild(
                    param.getOMElement(com.o2.www.broadband.avatartypes.UpdateUserRequest.MY_QNAME, factory));
            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e)
        {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    /* methods to provide back word compatibility */
    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
            com.o2.www.broadband.avatartypes.SearchForUsersByUserNameRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault
    {
        try
        {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody().addChild(
                    param.getOMElement(com.o2.www.broadband.avatartypes.SearchForUsersByUserNameRequest.MY_QNAME, factory));
            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e)
        {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    /* methods to provide back word compatibility */
    /**
     * get the default envelope
     */
    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory)
    {
        return factory.getDefaultEnvelope();
    }

    private java.lang.Object fromOM(org.apache.axiom.om.OMElement param, java.lang.Class type, java.util.Map extraNamespaces)
            throws org.apache.axis2.AxisFault
    {
        try
        {
            if (com.o2.www.broadband.avatartypes.SearchForUsersByCustNumRequest.class.equals(type))
            {
                return com.o2.www.broadband.avatartypes.SearchForUsersByCustNumRequest.Factory.parse(param
                        .getXMLStreamReaderWithoutCaching());
            }
            if (com.o2.www.broadband.avatartypes.SearchForUsersByCustNumResponse.class.equals(type))
            {
                return com.o2.www.broadband.avatartypes.SearchForUsersByCustNumResponse.Factory.parse(param
                        .getXMLStreamReaderWithoutCaching());
            }
            if (com.o2.www.broadband.avatartypes.SuggestUserNameRequest.class.equals(type))
            {
                return com.o2.www.broadband.avatartypes.SuggestUserNameRequest.Factory.parse(param
                        .getXMLStreamReaderWithoutCaching());
            }
            if (com.o2.www.broadband.avatartypes.SuggestUserNameResponse.class.equals(type))
            {
                return com.o2.www.broadband.avatartypes.SuggestUserNameResponse.Factory.parse(param
                        .getXMLStreamReaderWithoutCaching());
            }
            if (com.o2.www.broadband.avatartypes.CreateUserRequest.class.equals(type))
            {
                return com.o2.www.broadband.avatartypes.CreateUserRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }
            if (com.o2.www.broadband.avatartypes.CreateUserResponse.class.equals(type))
            {
                return com.o2.www.broadband.avatartypes.CreateUserResponse.Factory
                        .parse(param.getXMLStreamReaderWithoutCaching());
            }
            if (com.o2.www.broadband.avatartypes.SearchForUsersByMSISDNRequest.class.equals(type))
            {
                return com.o2.www.broadband.avatartypes.SearchForUsersByMSISDNRequest.Factory.parse(param
                        .getXMLStreamReaderWithoutCaching());
            }
            if (com.o2.www.broadband.avatartypes.SearchForUsersByMSISDNResponse.class.equals(type))
            {
                return com.o2.www.broadband.avatartypes.SearchForUsersByMSISDNResponse.Factory.parse(param
                        .getXMLStreamReaderWithoutCaching());
            }
            if (com.o2.www.broadband.avatartypes.UpdateUserRequest.class.equals(type))
            {
                return com.o2.www.broadband.avatartypes.UpdateUserRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }
            if (com.o2.www.broadband.avatartypes.UpdateUserResponse.class.equals(type))
            {
                return com.o2.www.broadband.avatartypes.UpdateUserResponse.Factory
                        .parse(param.getXMLStreamReaderWithoutCaching());
            }
            if (com.o2.www.broadband.avatartypes.SearchForUsersByUserNameRequest.class.equals(type))
            {
                return com.o2.www.broadband.avatartypes.SearchForUsersByUserNameRequest.Factory.parse(param
                        .getXMLStreamReaderWithoutCaching());
            }
            if (com.o2.www.broadband.avatartypes.SearchForUsersByUserNameResponse.class.equals(type))
            {
                return com.o2.www.broadband.avatartypes.SearchForUsersByUserNameResponse.Factory.parse(param
                        .getXMLStreamReaderWithoutCaching());
            }
        } catch (java.lang.Exception e)
        {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
        return null;
    }
}
