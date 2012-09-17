
/**
 * UserRoleType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:41 LKT)
 */
            
                package com.o2.www.broadband.avatartypes;
            

            /**
            *  UserRoleType bean class
            */
        
        public  class UserRoleType
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = userRoleType
                Namespace URI = http://www.o2.com/broadband/AvatarTypes
                Namespace Prefix = ns1
                */
            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://www.o2.com/broadband/AvatarTypes")){
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for GenevaAccountId
                        */

                        
                                    protected java.lang.String localGenevaAccountId ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getGenevaAccountId(){
                               return localGenevaAccountId;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param GenevaAccountId
                               */
                               public void setGenevaAccountId(java.lang.String param){
                            
                                            this.localGenevaAccountId=param;
                                    

                               }
                            

                        /**
                        * field for GenevaAccountName
                        */

                        
                                    protected java.lang.String localGenevaAccountName ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localGenevaAccountNameTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getGenevaAccountName(){
                               return localGenevaAccountName;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param GenevaAccountName
                               */
                               public void setGenevaAccountName(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localGenevaAccountNameTracker = true;
                                       } else {
                                          localGenevaAccountNameTracker = false;
                                              
                                       }
                                   
                                            this.localGenevaAccountName=param;
                                    

                               }
                            

                        /**
                        * field for GenevaCustomerId
                        */

                        
                                    protected java.lang.String localGenevaCustomerId ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getGenevaCustomerId(){
                               return localGenevaCustomerId;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param GenevaCustomerId
                               */
                               public void setGenevaCustomerId(java.lang.String param){
                            
                                            this.localGenevaCustomerId=param;
                                    

                               }
                            

                        /**
                        * field for GenevaCustomerName
                        */

                        
                                    protected java.lang.String localGenevaCustomerName ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getGenevaCustomerName(){
                               return localGenevaCustomerName;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param GenevaCustomerName
                               */
                               public void setGenevaCustomerName(java.lang.String param){
                            
                                            this.localGenevaCustomerName=param;
                                    

                               }
                            

                        /**
                        * field for HorizonCompanyCustnum
                        */

                        
                                    protected java.math.BigInteger localHorizonCompanyCustnum ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.math.BigInteger
                           */
                           public  java.math.BigInteger getHorizonCompanyCustnum(){
                               return localHorizonCompanyCustnum;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param HorizonCompanyCustnum
                               */
                               public void setHorizonCompanyCustnum(java.math.BigInteger param){
                            
                                            this.localHorizonCompanyCustnum=param;
                                    

                               }
                            

                        /**
                        * field for CompanyCustomerType
                        */

                        
                                    protected com.o2.www.broadband.avatartypes.TypeOfCustomerType localCompanyCustomerType ;
                                

                           /**
                           * Auto generated getter method
                           * @return com.o2.www.broadband.avatartypes.TypeOfCustomerType
                           */
                           public  com.o2.www.broadband.avatartypes.TypeOfCustomerType getCompanyCustomerType(){
                               return localCompanyCustomerType;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CompanyCustomerType
                               */
                               public void setCompanyCustomerType(com.o2.www.broadband.avatartypes.TypeOfCustomerType param){
                            
                                            this.localCompanyCustomerType=param;
                                    

                               }
                            

                        /**
                        * field for Msisdn
                        */

                        
                                    protected com.o2.www.broadband.avatartypes.MobilePhoneType localMsisdn ;
                                

                           /**
                           * Auto generated getter method
                           * @return com.o2.www.broadband.avatartypes.MobilePhoneType
                           */
                           public  com.o2.www.broadband.avatartypes.MobilePhoneType getMsisdn(){
                               return localMsisdn;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Msisdn
                               */
                               public void setMsisdn(com.o2.www.broadband.avatartypes.MobilePhoneType param){
                            
                                            this.localMsisdn=param;
                                    

                               }
                            

                        /**
                        * field for AccountType
                        */

                        
                                    protected com.o2.www.broadband.avatartypes.TypeOfAccountType localAccountType ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAccountTypeTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.o2.www.broadband.avatartypes.TypeOfAccountType
                           */
                           public  com.o2.www.broadband.avatartypes.TypeOfAccountType getAccountType(){
                               return localAccountType;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param AccountType
                               */
                               public void setAccountType(com.o2.www.broadband.avatartypes.TypeOfAccountType param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localAccountTypeTracker = true;
                                       } else {
                                          localAccountTypeTracker = false;
                                              
                                       }
                                   
                                            this.localAccountType=param;
                                    

                               }
                            

     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;
        
        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
          isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
   }
     
     
        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{


        
               org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,parentQName){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       UserRoleType.this.serialize(parentQName,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               parentQName,factory,dataSource);
            
       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
            
                


                java.lang.String prefix = null;
                java.lang.String namespace = null;
                

                    prefix = parentQName.getPrefix();
                    namespace = parentQName.getNamespaceURI();

                    if ((namespace != null) && (namespace.trim().length() > 0)) {
                        java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                        if (writerPrefix != null) {
                            xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                        } else {
                            if (prefix == null) {
                                prefix = generatePrefix(namespace);
                            }

                            xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                            xmlWriter.writeNamespace(prefix, namespace);
                            xmlWriter.setPrefix(prefix, namespace);
                        }
                    } else {
                        xmlWriter.writeStartElement(parentQName.getLocalPart());
                    }
                
                  if (serializeType){
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://www.o2.com/broadband/AvatarTypes");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":userRoleType",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "userRoleType",
                           xmlWriter);
                   }

               
                   }
               
                                    namespace = "http://www.o2.com/broadband/AvatarTypes";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"genevaAccountId", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"genevaAccountId");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("genevaAccountId");
                                    }
                                

                                          if (localGenevaAccountId==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("genevaAccountId cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localGenevaAccountId);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                              if (localGenevaAccountNameTracker){
                                    namespace = "http://www.o2.com/broadband/AvatarTypes";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"genevaAccountName", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"genevaAccountName");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("genevaAccountName");
                                    }
                                

                                          if (localGenevaAccountName==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("genevaAccountName cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localGenevaAccountName);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             }
                                    namespace = "http://www.o2.com/broadband/AvatarTypes";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"genevaCustomerId", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"genevaCustomerId");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("genevaCustomerId");
                                    }
                                

                                          if (localGenevaCustomerId==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("genevaCustomerId cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localGenevaCustomerId);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "http://www.o2.com/broadband/AvatarTypes";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"genevaCustomerName", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"genevaCustomerName");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("genevaCustomerName");
                                    }
                                

                                          if (localGenevaCustomerName==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("genevaCustomerName cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localGenevaCustomerName);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "http://www.o2.com/broadband/AvatarTypes";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"horizonCompanyCustnum", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"horizonCompanyCustnum");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("horizonCompanyCustnum");
                                    }
                                

                                          if (localHorizonCompanyCustnum==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("horizonCompanyCustnum cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localHorizonCompanyCustnum));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             
                                            if (localCompanyCustomerType==null){
                                                 throw new org.apache.axis2.databinding.ADBException("companyCustomerType cannot be null!!");
                                            }
                                           localCompanyCustomerType.serialize(new javax.xml.namespace.QName("http://www.o2.com/broadband/AvatarTypes","companyCustomerType"),
                                               factory,xmlWriter);
                                        
                                            if (localMsisdn==null){
                                                 throw new org.apache.axis2.databinding.ADBException("msisdn cannot be null!!");
                                            }
                                           localMsisdn.serialize(new javax.xml.namespace.QName("http://www.o2.com/broadband/AvatarTypes","msisdn"),
                                               factory,xmlWriter);
                                         if (localAccountTypeTracker){
                                            if (localAccountType==null){
                                                 throw new org.apache.axis2.databinding.ADBException("accountType cannot be null!!");
                                            }
                                           localAccountType.serialize(new javax.xml.namespace.QName("http://www.o2.com/broadband/AvatarTypes","accountType"),
                                               factory,xmlWriter);
                                        }
                    xmlWriter.writeEndElement();
               

        }

         /**
          * Util method to write an attribute with the ns prefix
          */
          private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          private void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
              }
          }


           /**
             * Util method to write an attribute without the ns prefix
             */
            private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


         /**
         * Register a namespace prefix
         */
         private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                    }

                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }

                return prefix;
            }


  
        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{


        
                 java.util.ArrayList elementList = new java.util.ArrayList();
                 java.util.ArrayList attribList = new java.util.ArrayList();

                
                                      elementList.add(new javax.xml.namespace.QName("http://www.o2.com/broadband/AvatarTypes",
                                                                      "genevaAccountId"));
                                 
                                        if (localGenevaAccountId != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localGenevaAccountId));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("genevaAccountId cannot be null!!");
                                        }
                                     if (localGenevaAccountNameTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://www.o2.com/broadband/AvatarTypes",
                                                                      "genevaAccountName"));
                                 
                                        if (localGenevaAccountName != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localGenevaAccountName));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("genevaAccountName cannot be null!!");
                                        }
                                    }
                                      elementList.add(new javax.xml.namespace.QName("http://www.o2.com/broadband/AvatarTypes",
                                                                      "genevaCustomerId"));
                                 
                                        if (localGenevaCustomerId != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localGenevaCustomerId));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("genevaCustomerId cannot be null!!");
                                        }
                                    
                                      elementList.add(new javax.xml.namespace.QName("http://www.o2.com/broadband/AvatarTypes",
                                                                      "genevaCustomerName"));
                                 
                                        if (localGenevaCustomerName != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localGenevaCustomerName));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("genevaCustomerName cannot be null!!");
                                        }
                                    
                                      elementList.add(new javax.xml.namespace.QName("http://www.o2.com/broadband/AvatarTypes",
                                                                      "horizonCompanyCustnum"));
                                 
                                        if (localHorizonCompanyCustnum != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localHorizonCompanyCustnum));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("horizonCompanyCustnum cannot be null!!");
                                        }
                                    
                            elementList.add(new javax.xml.namespace.QName("http://www.o2.com/broadband/AvatarTypes",
                                                                      "companyCustomerType"));
                            
                            
                                    if (localCompanyCustomerType==null){
                                         throw new org.apache.axis2.databinding.ADBException("companyCustomerType cannot be null!!");
                                    }
                                    elementList.add(localCompanyCustomerType);
                                
                            elementList.add(new javax.xml.namespace.QName("http://www.o2.com/broadband/AvatarTypes",
                                                                      "msisdn"));
                            
                            
                                    if (localMsisdn==null){
                                         throw new org.apache.axis2.databinding.ADBException("msisdn cannot be null!!");
                                    }
                                    elementList.add(localMsisdn);
                                 if (localAccountTypeTracker){
                            elementList.add(new javax.xml.namespace.QName("http://www.o2.com/broadband/AvatarTypes",
                                                                      "accountType"));
                            
                            
                                    if (localAccountType==null){
                                         throw new org.apache.axis2.databinding.ADBException("accountType cannot be null!!");
                                    }
                                    elementList.add(localAccountType);
                                }

                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());
            
            

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static UserRoleType parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            UserRoleType object =
                new UserRoleType();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {
                
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                
                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                  java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                  if (fullTypeName!=null){
                    java.lang.String nsPrefix = null;
                    if (fullTypeName.indexOf(":") > -1){
                        nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                    }
                    nsPrefix = nsPrefix==null?"":nsPrefix;

                    java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);
                    
                            if (!"userRoleType".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (UserRoleType)com.o2.www.broadband.avatartypes.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                 
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.o2.com/broadband/AvatarTypes","genevaAccountId").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setGenevaAccountId(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.o2.com/broadband/AvatarTypes","genevaAccountName").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setGenevaAccountName(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.o2.com/broadband/AvatarTypes","genevaCustomerId").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setGenevaCustomerId(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.o2.com/broadband/AvatarTypes","genevaCustomerName").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setGenevaCustomerName(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.o2.com/broadband/AvatarTypes","horizonCompanyCustnum").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setHorizonCompanyCustnum(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInteger(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.o2.com/broadband/AvatarTypes","companyCustomerType").equals(reader.getName())){
                                
                                                object.setCompanyCustomerType(com.o2.www.broadband.avatartypes.TypeOfCustomerType.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.o2.com/broadband/AvatarTypes","msisdn").equals(reader.getName())){
                                
                                                object.setMsisdn(com.o2.www.broadband.avatartypes.MobilePhoneType.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.o2.com/broadband/AvatarTypes","accountType").equals(reader.getName())){
                                
                                                object.setAccountType(com.o2.www.broadband.avatartypes.TypeOfAccountType.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                  
                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();
                            
                                if (reader.isStartElement())
                                // A start element we are not expecting indicates a trailing invalid property
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                            



            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class

        

        }
           
          