
/**
 * UserCreationType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:41 LKT)
 */
            
                package com.o2.www.broadband.avatartypes;
            

            /**
            *  UserCreationType bean class
            */
        
        public  class UserCreationType
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = userCreationType
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
                        * field for Address
                        */

                        
                                    protected com.o2.www.broadband.avatartypes.AddressType localAddress ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAddressTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.o2.www.broadband.avatartypes.AddressType
                           */
                           public  com.o2.www.broadband.avatartypes.AddressType getAddress(){
                               return localAddress;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Address
                               */
                               public void setAddress(com.o2.www.broadband.avatartypes.AddressType param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localAddressTracker = true;
                                       } else {
                                          localAddressTracker = false;
                                              
                                       }
                                   
                                            this.localAddress=param;
                                    

                               }
                            

                        /**
                        * field for RoleSet
                        */

                        
                                    protected com.o2.www.broadband.avatartypes.RoleSetType localRoleSet ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localRoleSetTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.o2.www.broadband.avatartypes.RoleSetType
                           */
                           public  com.o2.www.broadband.avatartypes.RoleSetType getRoleSet(){
                               return localRoleSet;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param RoleSet
                               */
                               public void setRoleSet(com.o2.www.broadband.avatartypes.RoleSetType param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localRoleSetTracker = true;
                                       } else {
                                          localRoleSetTracker = false;
                                              
                                       }
                                   
                                            this.localRoleSet=param;
                                    

                               }
                            

                        /**
                        * field for AccountManagerEmail
                        * This was an Attribute!
                        */

                        
                                    protected com.o2.www.broadband.avatartypes.EmailAddressType localAccountManagerEmail ;
                                

                           /**
                           * Auto generated getter method
                           * @return com.o2.www.broadband.avatartypes.EmailAddressType
                           */
                           public  com.o2.www.broadband.avatartypes.EmailAddressType getAccountManagerEmail(){
                               return localAccountManagerEmail;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param AccountManagerEmail
                               */
                               public void setAccountManagerEmail(com.o2.www.broadband.avatartypes.EmailAddressType param){
                            
                                            this.localAccountManagerEmail=param;
                                    

                               }
                            

                        /**
                        * field for AccountManagerName
                        * This was an Attribute!
                        */

                        
                                    protected java.lang.String localAccountManagerName ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getAccountManagerName(){
                               return localAccountManagerName;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param AccountManagerName
                               */
                               public void setAccountManagerName(java.lang.String param){
                            
                                            this.localAccountManagerName=param;
                                    

                               }
                            

                        /**
                        * field for AlternativeContactNumber
                        * This was an Attribute!
                        */

                        
                                    protected com.o2.www.broadband.avatartypes.PhoneNumberType localAlternativeContactNumber ;
                                

                           /**
                           * Auto generated getter method
                           * @return com.o2.www.broadband.avatartypes.PhoneNumberType
                           */
                           public  com.o2.www.broadband.avatartypes.PhoneNumberType getAlternativeContactNumber(){
                               return localAlternativeContactNumber;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param AlternativeContactNumber
                               */
                               public void setAlternativeContactNumber(com.o2.www.broadband.avatartypes.PhoneNumberType param){
                            
                                            this.localAlternativeContactNumber=param;
                                    

                               }
                            

                        /**
                        * field for AlternativeEmail
                        * This was an Attribute!
                        */

                        
                                    protected com.o2.www.broadband.avatartypes.EmailAddressType localAlternativeEmail ;
                                

                           /**
                           * Auto generated getter method
                           * @return com.o2.www.broadband.avatartypes.EmailAddressType
                           */
                           public  com.o2.www.broadband.avatartypes.EmailAddressType getAlternativeEmail(){
                               return localAlternativeEmail;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param AlternativeEmail
                               */
                               public void setAlternativeEmail(com.o2.www.broadband.avatartypes.EmailAddressType param){
                            
                                            this.localAlternativeEmail=param;
                                    

                               }
                            

                        /**
                        * field for BroadbandUser
                        * This was an Attribute!
                        */

                        
                                    protected com.o2.www.broadband.avatartypes.YesNoType localBroadbandUser ;
                                

                           /**
                           * Auto generated getter method
                           * @return com.o2.www.broadband.avatartypes.YesNoType
                           */
                           public  com.o2.www.broadband.avatartypes.YesNoType getBroadbandUser(){
                               return localBroadbandUser;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param BroadbandUser
                               */
                               public void setBroadbandUser(com.o2.www.broadband.avatartypes.YesNoType param){
                            
                                            this.localBroadbandUser=param;
                                    

                               }
                            

                        /**
                        * field for BroadbandActivatedDate
                        * This was an Attribute!
                        */

                        
                                    protected java.util.Calendar localBroadbandActivatedDate ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getBroadbandActivatedDate(){
                               return localBroadbandActivatedDate;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param BroadbandActivatedDate
                               */
                               public void setBroadbandActivatedDate(java.util.Calendar param){
                            
                                            this.localBroadbandActivatedDate=param;
                                    

                               }
                            

                        /**
                        * field for BroadbandCeasedDate
                        * This was an Attribute!
                        */

                        
                                    protected java.util.Calendar localBroadbandCeasedDate ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getBroadbandCeasedDate(){
                               return localBroadbandCeasedDate;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param BroadbandCeasedDate
                               */
                               public void setBroadbandCeasedDate(java.util.Calendar param){
                            
                                            this.localBroadbandCeasedDate=param;
                                    

                               }
                            

                        /**
                        * field for BroadbandOrderedDate
                        * This was an Attribute!
                        */

                        
                                    protected java.util.Calendar localBroadbandOrderedDate ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getBroadbandOrderedDate(){
                               return localBroadbandOrderedDate;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param BroadbandOrderedDate
                               */
                               public void setBroadbandOrderedDate(java.util.Calendar param){
                            
                                            this.localBroadbandOrderedDate=param;
                                    

                               }
                            

                        /**
                        * field for BroadbandPartialOrderedDate
                        * This was an Attribute!
                        */

                        
                                    protected java.util.Calendar localBroadbandPartialOrderedDate ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getBroadbandPartialOrderedDate(){
                               return localBroadbandPartialOrderedDate;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param BroadbandPartialOrderedDate
                               */
                               public void setBroadbandPartialOrderedDate(java.util.Calendar param){
                            
                                            this.localBroadbandPartialOrderedDate=param;
                                    

                               }
                            

                        /**
                        * field for BroadbandTerminatedDate
                        * This was an Attribute!
                        */

                        
                                    protected java.util.Calendar localBroadbandTerminatedDate ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getBroadbandTerminatedDate(){
                               return localBroadbandTerminatedDate;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param BroadbandTerminatedDate
                               */
                               public void setBroadbandTerminatedDate(java.util.Calendar param){
                            
                                            this.localBroadbandTerminatedDate=param;
                                    

                               }
                            

                        /**
                        * field for BroadbandStatus
                        * This was an Attribute!
                        */

                        
                                    protected com.o2.www.broadband.avatartypes.BroadbandStatusType localBroadbandStatus ;
                                

                           /**
                           * Auto generated getter method
                           * @return com.o2.www.broadband.avatartypes.BroadbandStatusType
                           */
                           public  com.o2.www.broadband.avatartypes.BroadbandStatusType getBroadbandStatus(){
                               return localBroadbandStatus;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param BroadbandStatus
                               */
                               public void setBroadbandStatus(com.o2.www.broadband.avatartypes.BroadbandStatusType param){
                            
                                            this.localBroadbandStatus=param;
                                    

                               }
                            

                        /**
                        * field for BroadbandPackage
                        * This was an Attribute!
                        */

                        
                                    protected com.o2.www.broadband.avatartypes.BroadbandPackageType localBroadbandPackage ;
                                

                           /**
                           * Auto generated getter method
                           * @return com.o2.www.broadband.avatartypes.BroadbandPackageType
                           */
                           public  com.o2.www.broadband.avatartypes.BroadbandPackageType getBroadbandPackage(){
                               return localBroadbandPackage;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param BroadbandPackage
                               */
                               public void setBroadbandPackage(com.o2.www.broadband.avatartypes.BroadbandPackageType param){
                            
                                            this.localBroadbandPackage=param;
                                    

                               }
                            

                        /**
                        * field for CompanyName
                        * This was an Attribute!
                        */

                        
                                    protected java.lang.String localCompanyName ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getCompanyName(){
                               return localCompanyName;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CompanyName
                               */
                               public void setCompanyName(java.lang.String param){
                            
                                            this.localCompanyName=param;
                                    

                               }
                            

                        /**
                        * field for CompanyRegistrationNumber
                        * This was an Attribute!
                        */

                        
                                    protected java.lang.String localCompanyRegistrationNumber ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getCompanyRegistrationNumber(){
                               return localCompanyRegistrationNumber;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CompanyRegistrationNumber
                               */
                               public void setCompanyRegistrationNumber(java.lang.String param){
                            
                                            this.localCompanyRegistrationNumber=param;
                                    

                               }
                            

                        /**
                        * field for CompanyTelephoneNumber
                        * This was an Attribute!
                        */

                        
                                    protected com.o2.www.broadband.avatartypes.PhoneNumberType localCompanyTelephoneNumber ;
                                

                           /**
                           * Auto generated getter method
                           * @return com.o2.www.broadband.avatartypes.PhoneNumberType
                           */
                           public  com.o2.www.broadband.avatartypes.PhoneNumberType getCompanyTelephoneNumber(){
                               return localCompanyTelephoneNumber;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CompanyTelephoneNumber
                               */
                               public void setCompanyTelephoneNumber(com.o2.www.broadband.avatartypes.PhoneNumberType param){
                            
                                            this.localCompanyTelephoneNumber=param;
                                    

                               }
                            

                        /**
                        * field for ContactMedium
                        * This was an Attribute!
                        */

                        
                                    protected com.o2.www.broadband.avatartypes.ContactMediumType localContactMedium ;
                                

                           /**
                           * Auto generated getter method
                           * @return com.o2.www.broadband.avatartypes.ContactMediumType
                           */
                           public  com.o2.www.broadband.avatartypes.ContactMediumType getContactMedium(){
                               return localContactMedium;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ContactMedium
                               */
                               public void setContactMedium(com.o2.www.broadband.avatartypes.ContactMediumType param){
                            
                                            this.localContactMedium=param;
                                    

                               }
                            

                        /**
                        * field for CreditVetDate
                        * This was an Attribute!
                        */

                        
                                    protected java.util.Date localCreditVetDate ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.util.Date
                           */
                           public  java.util.Date getCreditVetDate(){
                               return localCreditVetDate;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CreditVetDate
                               */
                               public void setCreditVetDate(java.util.Date param){
                            
                                            this.localCreditVetDate=param;
                                    

                               }
                            

                        /**
                        * field for CreditVetPassed
                        * This was an Attribute!
                        */

                        
                                    protected java.lang.String localCreditVetPassed ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getCreditVetPassed(){
                               return localCreditVetPassed;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CreditVetPassed
                               */
                               public void setCreditVetPassed(java.lang.String param){
                            
                                            this.localCreditVetPassed=param;
                                    

                               }
                            

                        /**
                        * field for CustomerType
                        * This was an Attribute!
                        */

                        
                                    protected com.o2.www.broadband.avatartypes.TypeOfCustomerType localCustomerType ;
                                

                           /**
                           * Auto generated getter method
                           * @return com.o2.www.broadband.avatartypes.TypeOfCustomerType
                           */
                           public  com.o2.www.broadband.avatartypes.TypeOfCustomerType getCustomerType(){
                               return localCustomerType;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CustomerType
                               */
                               public void setCustomerType(com.o2.www.broadband.avatartypes.TypeOfCustomerType param){
                            
                                            this.localCustomerType=param;
                                    

                               }
                            

                        /**
                        * field for Custnum
                        * This was an Attribute!
                        */

                        
                                    protected java.math.BigInteger localCustnum ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.math.BigInteger
                           */
                           public  java.math.BigInteger getCustnum(){
                               return localCustnum;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Custnum
                               */
                               public void setCustnum(java.math.BigInteger param){
                            
                                            this.localCustnum=param;
                                    

                               }
                            

                        /**
                        * field for DateOfBirth
                        * This was an Attribute!
                        */

                        
                                    protected java.util.Date localDateOfBirth ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.util.Date
                           */
                           public  java.util.Date getDateOfBirth(){
                               return localDateOfBirth;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DateOfBirth
                               */
                               public void setDateOfBirth(java.util.Date param){
                            
                                            this.localDateOfBirth=param;
                                    

                               }
                            

                        /**
                        * field for DiscountEligibilityFlag
                        * This was an Attribute!
                        */

                        
                                    protected com.o2.www.broadband.avatartypes.YesNoType localDiscountEligibilityFlag ;
                                

                           /**
                           * Auto generated getter method
                           * @return com.o2.www.broadband.avatartypes.YesNoType
                           */
                           public  com.o2.www.broadband.avatartypes.YesNoType getDiscountEligibilityFlag(){
                               return localDiscountEligibilityFlag;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DiscountEligibilityFlag
                               */
                               public void setDiscountEligibilityFlag(com.o2.www.broadband.avatartypes.YesNoType param){
                            
                                            this.localDiscountEligibilityFlag=param;
                                    

                               }
                            

                        /**
                        * field for DqListingDetail
                        * This was an Attribute!
                        */

                        
                                    protected com.o2.www.broadband.avatartypes.ListingDetailType localDqListingDetail ;
                                

                           /**
                           * Auto generated getter method
                           * @return com.o2.www.broadband.avatartypes.ListingDetailType
                           */
                           public  com.o2.www.broadband.avatartypes.ListingDetailType getDqListingDetail(){
                               return localDqListingDetail;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DqListingDetail
                               */
                               public void setDqListingDetail(com.o2.www.broadband.avatartypes.ListingDetailType param){
                            
                                            this.localDqListingDetail=param;
                                    

                               }
                            

                        /**
                        * field for DqListingLevel
                        * This was an Attribute!
                        */

                        
                                    protected com.o2.www.broadband.avatartypes.ListingLevelType localDqListingLevel ;
                                

                           /**
                           * Auto generated getter method
                           * @return com.o2.www.broadband.avatartypes.ListingLevelType
                           */
                           public  com.o2.www.broadband.avatartypes.ListingLevelType getDqListingLevel(){
                               return localDqListingLevel;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DqListingLevel
                               */
                               public void setDqListingLevel(com.o2.www.broadband.avatartypes.ListingLevelType param){
                            
                                            this.localDqListingLevel=param;
                                    

                               }
                            

                        /**
                        * field for Domain
                        * This was an Attribute!
                        */

                        
                                    protected com.o2.www.broadband.avatartypes.O2DomainType localDomain ;
                                

                           /**
                           * Auto generated getter method
                           * @return com.o2.www.broadband.avatartypes.O2DomainType
                           */
                           public  com.o2.www.broadband.avatartypes.O2DomainType getDomain(){
                               return localDomain;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Domain
                               */
                               public void setDomain(com.o2.www.broadband.avatartypes.O2DomainType param){
                            
                                            this.localDomain=param;
                                    

                               }
                            

                        /**
                        * field for EmailAddress
                        * This was an Attribute!
                        */

                        
                                    protected com.o2.www.broadband.avatartypes.EmailAddressType localEmailAddress ;
                                

                           /**
                           * Auto generated getter method
                           * @return com.o2.www.broadband.avatartypes.EmailAddressType
                           */
                           public  com.o2.www.broadband.avatartypes.EmailAddressType getEmailAddress(){
                               return localEmailAddress;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param EmailAddress
                               */
                               public void setEmailAddress(com.o2.www.broadband.avatartypes.EmailAddressType param){
                            
                                            this.localEmailAddress=param;
                                    

                               }
                            

                        /**
                        * field for Forename
                        * This was an Attribute!
                        */

                        
                                    protected java.lang.String localForename ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getForename(){
                               return localForename;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Forename
                               */
                               public void setForename(java.lang.String param){
                            
                                            this.localForename=param;
                                    

                               }
                            

                        /**
                        * field for Gender
                        * This was an Attribute!
                        */

                        
                                    protected com.o2.www.broadband.avatartypes.GenderType localGender ;
                                

                           /**
                           * Auto generated getter method
                           * @return com.o2.www.broadband.avatartypes.GenderType
                           */
                           public  com.o2.www.broadband.avatartypes.GenderType getGender(){
                               return localGender;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Gender
                               */
                               public void setGender(com.o2.www.broadband.avatartypes.GenderType param){
                            
                                            this.localGender=param;
                                    

                               }
                            

                        /**
                        * field for GenevaCustomerId
                        * This was an Attribute!
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
                        * field for HasBeenBillingContact
                        * This was an Attribute!
                        */

                        
                                    protected com.o2.www.broadband.avatartypes.YesNoType localHasBeenBillingContact ;
                                

                           /**
                           * Auto generated getter method
                           * @return com.o2.www.broadband.avatartypes.YesNoType
                           */
                           public  com.o2.www.broadband.avatartypes.YesNoType getHasBeenBillingContact(){
                               return localHasBeenBillingContact;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param HasBeenBillingContact
                               */
                               public void setHasBeenBillingContact(com.o2.www.broadband.avatartypes.YesNoType param){
                            
                                            this.localHasBeenBillingContact=param;
                                    

                               }
                            

                        /**
                        * field for HasHadRole
                        * This was an Attribute!
                        */

                        
                                    protected com.o2.www.broadband.avatartypes.YesNoType localHasHadRole ;
                                

                           /**
                           * Auto generated getter method
                           * @return com.o2.www.broadband.avatartypes.YesNoType
                           */
                           public  com.o2.www.broadband.avatartypes.YesNoType getHasHadRole(){
                               return localHasHadRole;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param HasHadRole
                               */
                               public void setHasHadRole(com.o2.www.broadband.avatartypes.YesNoType param){
                            
                                            this.localHasHadRole=param;
                                    

                               }
                            

                        /**
                        * field for Id
                        * This was an Attribute!
                        */

                        
                                    protected java.lang.String localId ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getId(){
                               return localId;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Id
                               */
                               public void setId(java.lang.String param){
                            
                                            this.localId=param;
                                    

                               }
                            

                        /**
                        * field for Initials
                        * This was an Attribute!
                        */

                        
                                    protected java.lang.String localInitials ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getInitials(){
                               return localInitials;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Initials
                               */
                               public void setInitials(java.lang.String param){
                            
                                            this.localInitials=param;
                                    

                               }
                            

                        /**
                        * field for IsESMECustomer
                        * This was an Attribute!
                        */

                        
                                    protected com.o2.www.broadband.avatartypes.YesNoType localIsESMECustomer ;
                                

                           /**
                           * Auto generated getter method
                           * @return com.o2.www.broadband.avatartypes.YesNoType
                           */
                           public  com.o2.www.broadband.avatartypes.YesNoType getIsESMECustomer(){
                               return localIsESMECustomer;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IsESMECustomer
                               */
                               public void setIsESMECustomer(com.o2.www.broadband.avatartypes.YesNoType param){
                            
                                            this.localIsESMECustomer=param;
                                    

                               }
                            

                        /**
                        * field for JobFunction
                        * This was an Attribute!
                        */

                        
                                    protected java.lang.String localJobFunction ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getJobFunction(){
                               return localJobFunction;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param JobFunction
                               */
                               public void setJobFunction(java.lang.String param){
                            
                                            this.localJobFunction=param;
                                    

                               }
                            

                        /**
                        * field for JobTitle
                        * This was an Attribute!
                        */

                        
                                    protected java.lang.String localJobTitle ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getJobTitle(){
                               return localJobTitle;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param JobTitle
                               */
                               public void setJobTitle(java.lang.String param){
                            
                                            this.localJobTitle=param;
                                    

                               }
                            

                        /**
                        * field for Key
                        * This was an Attribute!
                        */

                        
                                    protected java.lang.String localKey ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getKey(){
                               return localKey;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Key
                               */
                               public void setKey(java.lang.String param){
                            
                                            this.localKey=param;
                                    

                               }
                            

                        /**
                        * field for Lastname
                        * This was an Attribute!
                        */

                        
                                    protected java.lang.String localLastname ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getLastname(){
                               return localLastname;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Lastname
                               */
                               public void setLastname(java.lang.String param){
                            
                                            this.localLastname=param;
                                    

                               }
                            

                        /**
                        * field for Level2Password
                        * This was an Attribute!
                        */

                        
                                    protected java.lang.String localLevel2Password ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getLevel2Password(){
                               return localLevel2Password;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Level2Password
                               */
                               public void setLevel2Password(java.lang.String param){
                            
                                            this.localLevel2Password=param;
                                    

                               }
                            

                        /**
                        * field for Msisdn
                        * This was an Attribute!
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
                        * field for MsisdnValid
                        * This was an Attribute!
                        */

                        
                                    protected com.o2.www.broadband.avatartypes.PortalMSISDNStatusType localMsisdnValid ;
                                

                           /**
                           * Auto generated getter method
                           * @return com.o2.www.broadband.avatartypes.PortalMSISDNStatusType
                           */
                           public  com.o2.www.broadband.avatartypes.PortalMSISDNStatusType getMsisdnValid(){
                               return localMsisdnValid;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MsisdnValid
                               */
                               public void setMsisdnValid(com.o2.www.broadband.avatartypes.PortalMSISDNStatusType param){
                            
                                            this.localMsisdnValid=param;
                                    

                               }
                            

                        /**
                        * field for Network
                        * This was an Attribute!
                        */

                        
                                    protected java.lang.String localNetwork ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getNetwork(){
                               return localNetwork;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Network
                               */
                               public void setNetwork(java.lang.String param){
                            
                                            this.localNetwork=param;
                                    

                               }
                            

                        /**
                        * field for NumberOfEmployees
                        * This was an Attribute!
                        */

                        
                                    protected java.math.BigInteger localNumberOfEmployees ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.math.BigInteger
                           */
                           public  java.math.BigInteger getNumberOfEmployees(){
                               return localNumberOfEmployees;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param NumberOfEmployees
                               */
                               public void setNumberOfEmployees(java.math.BigInteger param){
                            
                                            this.localNumberOfEmployees=param;
                                    

                               }
                            

                        /**
                        * field for OwningBusinessDivision
                        * This was an Attribute!
                        */

                        
                                    protected com.o2.www.broadband.avatartypes.OwningBusinessDivisionType localOwningBusinessDivision ;
                                

                           /**
                           * Auto generated getter method
                           * @return com.o2.www.broadband.avatartypes.OwningBusinessDivisionType
                           */
                           public  com.o2.www.broadband.avatartypes.OwningBusinessDivisionType getOwningBusinessDivision(){
                               return localOwningBusinessDivision;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param OwningBusinessDivision
                               */
                               public void setOwningBusinessDivision(com.o2.www.broadband.avatartypes.OwningBusinessDivisionType param){
                            
                                            this.localOwningBusinessDivision=param;
                                    

                               }
                            

                        /**
                        * field for Partner
                        * This was an Attribute!
                        */

                        
                                    protected java.lang.String localPartner ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getPartner(){
                               return localPartner;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Partner
                               */
                               public void setPartner(java.lang.String param){
                            
                                            this.localPartner=param;
                                    

                               }
                            

                        /**
                        * field for Password
                        * This was an Attribute!
                        */

                        
                                    protected java.lang.String localPassword ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getPassword(){
                               return localPassword;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Password
                               */
                               public void setPassword(java.lang.String param){
                            
                                            this.localPassword=param;
                                    

                               }
                            

                        /**
                        * field for PhoneMake
                        * This was an Attribute!
                        */

                        
                                    protected java.lang.String localPhoneMake ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getPhoneMake(){
                               return localPhoneMake;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PhoneMake
                               */
                               public void setPhoneMake(java.lang.String param){
                            
                                            this.localPhoneMake=param;
                                    

                               }
                            

                        /**
                        * field for PosBusinessUnit
                        * This was an Attribute!
                        */

                        
                                    protected java.lang.String localPosBusinessUnit ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getPosBusinessUnit(){
                               return localPosBusinessUnit;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PosBusinessUnit
                               */
                               public void setPosBusinessUnit(java.lang.String param){
                            
                                            this.localPosBusinessUnit=param;
                                    

                               }
                            

                        /**
                        * field for PrimaryAccountUser
                        * This was an Attribute!
                        */

                        
                                    protected com.o2.www.broadband.avatartypes.YesNoType localPrimaryAccountUser ;
                                

                           /**
                           * Auto generated getter method
                           * @return com.o2.www.broadband.avatartypes.YesNoType
                           */
                           public  com.o2.www.broadband.avatartypes.YesNoType getPrimaryAccountUser(){
                               return localPrimaryAccountUser;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PrimaryAccountUser
                               */
                               public void setPrimaryAccountUser(com.o2.www.broadband.avatartypes.YesNoType param){
                            
                                            this.localPrimaryAccountUser=param;
                                    

                               }
                            

                        /**
                        * field for Referral
                        * This was an Attribute!
                        */

                        
                                    protected java.lang.String localReferral ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getReferral(){
                               return localReferral;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Referral
                               */
                               public void setReferral(java.lang.String param){
                            
                                            this.localReferral=param;
                                    

                               }
                            

                        /**
                        * field for ReferralDate
                        * This was an Attribute!
                        */

                        
                                    protected java.util.Date localReferralDate ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.util.Date
                           */
                           public  java.util.Date getReferralDate(){
                               return localReferralDate;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ReferralDate
                               */
                               public void setReferralDate(java.util.Date param){
                            
                                            this.localReferralDate=param;
                                    

                               }
                            

                        /**
                        * field for RegistrationType
                        * This was an Attribute!
                        */

                        
                                    protected com.o2.www.broadband.avatartypes.UserRegistrationType localRegistrationType ;
                                

                           /**
                           * Auto generated getter method
                           * @return com.o2.www.broadband.avatartypes.UserRegistrationType
                           */
                           public  com.o2.www.broadband.avatartypes.UserRegistrationType getRegistrationType(){
                               return localRegistrationType;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param RegistrationType
                               */
                               public void setRegistrationType(com.o2.www.broadband.avatartypes.UserRegistrationType param){
                            
                                            this.localRegistrationType=param;
                                    

                               }
                            

                        /**
                        * field for RiskThreshold
                        * This was an Attribute!
                        */

                        
                                    protected java.math.BigInteger localRiskThreshold ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.math.BigInteger
                           */
                           public  java.math.BigInteger getRiskThreshold(){
                               return localRiskThreshold;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param RiskThreshold
                               */
                               public void setRiskThreshold(java.math.BigInteger param){
                            
                                            this.localRiskThreshold=param;
                                    

                               }
                            

                        /**
                        * field for RiskThresholdDate
                        * This was an Attribute!
                        */

                        
                                    protected java.util.Date localRiskThresholdDate ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.util.Date
                           */
                           public  java.util.Date getRiskThresholdDate(){
                               return localRiskThresholdDate;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param RiskThresholdDate
                               */
                               public void setRiskThresholdDate(java.util.Date param){
                            
                                            this.localRiskThresholdDate=param;
                                    

                               }
                            

                        /**
                        * field for RoleSummary
                        * This was an Attribute!
                        */

                        
                                    protected com.o2.www.broadband.avatartypes.CustomerRoleSummaryType localRoleSummary ;
                                

                           /**
                           * Auto generated getter method
                           * @return com.o2.www.broadband.avatartypes.CustomerRoleSummaryType
                           */
                           public  com.o2.www.broadband.avatartypes.CustomerRoleSummaryType getRoleSummary(){
                               return localRoleSummary;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param RoleSummary
                               */
                               public void setRoleSummary(com.o2.www.broadband.avatartypes.CustomerRoleSummaryType param){
                            
                                            this.localRoleSummary=param;
                                    

                               }
                            

                        /**
                        * field for SaleDate
                        * This was an Attribute!
                        */

                        
                                    protected java.util.Date localSaleDate ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.util.Date
                           */
                           public  java.util.Date getSaleDate(){
                               return localSaleDate;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SaleDate
                               */
                               public void setSaleDate(java.util.Date param){
                            
                                            this.localSaleDate=param;
                                    

                               }
                            

                        /**
                        * field for Sector
                        * This was an Attribute!
                        */

                        
                                    protected com.o2.www.broadband.avatartypes.SectorType localSector ;
                                

                           /**
                           * Auto generated getter method
                           * @return com.o2.www.broadband.avatartypes.SectorType
                           */
                           public  com.o2.www.broadband.avatartypes.SectorType getSector(){
                               return localSector;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Sector
                               */
                               public void setSector(com.o2.www.broadband.avatartypes.SectorType param){
                            
                                            this.localSector=param;
                                    

                               }
                            

                        /**
                        * field for SecurityQuestion
                        * This was an Attribute!
                        */

                        
                                    protected java.lang.String localSecurityQuestion ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getSecurityQuestion(){
                               return localSecurityQuestion;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SecurityQuestion
                               */
                               public void setSecurityQuestion(java.lang.String param){
                            
                                            this.localSecurityQuestion=param;
                                    

                               }
                            

                        /**
                        * field for SecurityAnswer
                        * This was an Attribute!
                        */

                        
                                    protected java.lang.String localSecurityAnswer ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getSecurityAnswer(){
                               return localSecurityAnswer;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SecurityAnswer
                               */
                               public void setSecurityAnswer(java.lang.String param){
                            
                                            this.localSecurityAnswer=param;
                                    

                               }
                            

                        /**
                        * field for Segmentation
                        * This was an Attribute!
                        */

                        
                                    protected com.o2.www.broadband.avatartypes.CustomerSegmentationType localSegmentation ;
                                

                           /**
                           * Auto generated getter method
                           * @return com.o2.www.broadband.avatartypes.CustomerSegmentationType
                           */
                           public  com.o2.www.broadband.avatartypes.CustomerSegmentationType getSegmentation(){
                               return localSegmentation;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Segmentation
                               */
                               public void setSegmentation(com.o2.www.broadband.avatartypes.CustomerSegmentationType param){
                            
                                            this.localSegmentation=param;
                                    

                               }
                            

                        /**
                        * field for TimeStamp
                        * This was an Attribute!
                        */

                        
                                    protected java.util.Calendar localTimeStamp ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getTimeStamp(){
                               return localTimeStamp;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TimeStamp
                               */
                               public void setTimeStamp(java.util.Calendar param){
                            
                                            this.localTimeStamp=param;
                                    

                               }
                            

                        /**
                        * field for Title
                        * This was an Attribute!
                        */

                        
                                    protected java.lang.String localTitle ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getTitle(){
                               return localTitle;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Title
                               */
                               public void setTitle(java.lang.String param){
                            
                                            this.localTitle=param;
                                    

                               }
                            

                        /**
                        * field for WantsGenieMarketing
                        * This was an Attribute!
                        */

                        
                                    protected com.o2.www.broadband.avatartypes.YesNoType localWantsGenieMarketing ;
                                

                           /**
                           * Auto generated getter method
                           * @return com.o2.www.broadband.avatartypes.YesNoType
                           */
                           public  com.o2.www.broadband.avatartypes.YesNoType getWantsGenieMarketing(){
                               return localWantsGenieMarketing;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param WantsGenieMarketing
                               */
                               public void setWantsGenieMarketing(com.o2.www.broadband.avatartypes.YesNoType param){
                            
                                            this.localWantsGenieMarketing=param;
                                    

                               }
                            

                        /**
                        * field for WantsOtherMarketing
                        * This was an Attribute!
                        */

                        
                                    protected com.o2.www.broadband.avatartypes.YesNoType localWantsOtherMarketing ;
                                

                           /**
                           * Auto generated getter method
                           * @return com.o2.www.broadband.avatartypes.YesNoType
                           */
                           public  com.o2.www.broadband.avatartypes.YesNoType getWantsOtherMarketing(){
                               return localWantsOtherMarketing;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param WantsOtherMarketing
                               */
                               public void setWantsOtherMarketing(com.o2.www.broadband.avatartypes.YesNoType param){
                            
                                            this.localWantsOtherMarketing=param;
                                    

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
                       UserCreationType.this.serialize(parentQName,factory,xmlWriter);
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
                           namespacePrefix+":userCreationType",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "userCreationType",
                           xmlWriter);
                   }

               
                   }
               
                                    
                                    if (localAccountManagerEmail != null){
                                        writeAttribute("",
                                           "accountManagerEmail",
                                           localAccountManagerEmail.toString(), xmlWriter);
                                    }
                                    
                                            if (localAccountManagerName != null){
                                        
                                                writeAttribute("",
                                                         "accountManagerName",
                                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAccountManagerName), xmlWriter);

                                            
                                      }
                                    
                                    
                                    if (localAlternativeContactNumber != null){
                                        writeAttribute("",
                                           "alternativeContactNumber",
                                           localAlternativeContactNumber.toString(), xmlWriter);
                                    }
                                    
                                    
                                    if (localAlternativeEmail != null){
                                        writeAttribute("",
                                           "alternativeEmail",
                                           localAlternativeEmail.toString(), xmlWriter);
                                    }
                                    
                                    
                                    if (localBroadbandUser != null){
                                        writeAttribute("",
                                           "broadbandUser",
                                           localBroadbandUser.toString(), xmlWriter);
                                    }
                                    
                                            if (localBroadbandActivatedDate != null){
                                        
                                                writeAttribute("",
                                                         "broadbandActivatedDate",
                                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localBroadbandActivatedDate), xmlWriter);

                                            
                                      }
                                    
                                            if (localBroadbandCeasedDate != null){
                                        
                                                writeAttribute("",
                                                         "broadbandCeasedDate",
                                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localBroadbandCeasedDate), xmlWriter);

                                            
                                      }
                                    
                                            if (localBroadbandOrderedDate != null){
                                        
                                                writeAttribute("",
                                                         "broadbandOrderedDate",
                                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localBroadbandOrderedDate), xmlWriter);

                                            
                                      }
                                    
                                            if (localBroadbandPartialOrderedDate != null){
                                        
                                                writeAttribute("",
                                                         "broadbandPartialOrderedDate",
                                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localBroadbandPartialOrderedDate), xmlWriter);

                                            
                                      }
                                    
                                            if (localBroadbandTerminatedDate != null){
                                        
                                                writeAttribute("",
                                                         "broadbandTerminatedDate",
                                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localBroadbandTerminatedDate), xmlWriter);

                                            
                                      }
                                    
                                    
                                    if (localBroadbandStatus != null){
                                        writeAttribute("",
                                           "broadbandStatus",
                                           localBroadbandStatus.toString(), xmlWriter);
                                    }
                                    
                                    
                                    if (localBroadbandPackage != null){
                                        writeAttribute("",
                                           "broadbandPackage",
                                           localBroadbandPackage.toString(), xmlWriter);
                                    }
                                    
                                            if (localCompanyName != null){
                                        
                                                writeAttribute("",
                                                         "companyName",
                                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCompanyName), xmlWriter);

                                            
                                      }
                                    
                                            if (localCompanyRegistrationNumber != null){
                                        
                                                writeAttribute("",
                                                         "companyRegistrationNumber",
                                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCompanyRegistrationNumber), xmlWriter);

                                            
                                      }
                                    
                                    
                                    if (localCompanyTelephoneNumber != null){
                                        writeAttribute("",
                                           "companyTelephoneNumber",
                                           localCompanyTelephoneNumber.toString(), xmlWriter);
                                    }
                                    
                                    
                                    if (localContactMedium != null){
                                        writeAttribute("",
                                           "contactMedium",
                                           localContactMedium.toString(), xmlWriter);
                                    }
                                    
                                            if (localCreditVetDate != null){
                                        
                                                writeAttribute("",
                                                         "creditVetDate",
                                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCreditVetDate), xmlWriter);

                                            
                                      }
                                    
                                            if (localCreditVetPassed != null){
                                        
                                                writeAttribute("",
                                                         "creditVetPassed",
                                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCreditVetPassed), xmlWriter);

                                            
                                      }
                                    
                                    
                                    if (localCustomerType != null){
                                        writeAttribute("",
                                           "customerType",
                                           localCustomerType.toString(), xmlWriter);
                                    }
                                    
                                            if (localCustnum != null){
                                        
                                                writeAttribute("",
                                                         "custnum",
                                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCustnum), xmlWriter);

                                            
                                      }
                                    
                                            if (localDateOfBirth != null){
                                        
                                                writeAttribute("",
                                                         "dateOfBirth",
                                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDateOfBirth), xmlWriter);

                                            
                                      }
                                    
                                    
                                    if (localDiscountEligibilityFlag != null){
                                        writeAttribute("",
                                           "discountEligibilityFlag",
                                           localDiscountEligibilityFlag.toString(), xmlWriter);
                                    }
                                    
                                    
                                    if (localDqListingDetail != null){
                                        writeAttribute("",
                                           "dqListingDetail",
                                           localDqListingDetail.toString(), xmlWriter);
                                    }
                                    
                                    
                                    if (localDqListingLevel != null){
                                        writeAttribute("",
                                           "dqListingLevel",
                                           localDqListingLevel.toString(), xmlWriter);
                                    }
                                    
                                    
                                    if (localDomain != null){
                                        writeAttribute("",
                                           "domain",
                                           localDomain.toString(), xmlWriter);
                                    }
                                    
                                      else {
                                          throw new org.apache.axis2.databinding.ADBException("required attribute localDomain is null");
                                      }
                                    
                                    
                                    if (localEmailAddress != null){
                                        writeAttribute("",
                                           "emailAddress",
                                           localEmailAddress.toString(), xmlWriter);
                                    }
                                    
                                            if (localForename != null){
                                        
                                                writeAttribute("",
                                                         "forename",
                                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localForename), xmlWriter);

                                            
                                      }
                                    
                                      else {
                                          throw new org.apache.axis2.databinding.ADBException("required attribute localForename is null");
                                      }
                                    
                                    
                                    if (localGender != null){
                                        writeAttribute("",
                                           "gender",
                                           localGender.toString(), xmlWriter);
                                    }
                                    
                                            if (localGenevaCustomerId != null){
                                        
                                                writeAttribute("",
                                                         "genevaCustomerId",
                                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localGenevaCustomerId), xmlWriter);

                                            
                                      }
                                    
                                    
                                    if (localHasBeenBillingContact != null){
                                        writeAttribute("",
                                           "hasBeenBillingContact",
                                           localHasBeenBillingContact.toString(), xmlWriter);
                                    }
                                    
                                    
                                    if (localHasHadRole != null){
                                        writeAttribute("",
                                           "hasHadRole",
                                           localHasHadRole.toString(), xmlWriter);
                                    }
                                    
                                            if (localId != null){
                                        
                                                writeAttribute("",
                                                         "id",
                                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localId), xmlWriter);

                                            
                                      }
                                    
                                      else {
                                          throw new org.apache.axis2.databinding.ADBException("required attribute localId is null");
                                      }
                                    
                                            if (localInitials != null){
                                        
                                                writeAttribute("",
                                                         "initials",
                                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localInitials), xmlWriter);

                                            
                                      }
                                    
                                    
                                    if (localIsESMECustomer != null){
                                        writeAttribute("",
                                           "isESMECustomer",
                                           localIsESMECustomer.toString(), xmlWriter);
                                    }
                                    
                                            if (localJobFunction != null){
                                        
                                                writeAttribute("",
                                                         "jobFunction",
                                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localJobFunction), xmlWriter);

                                            
                                      }
                                    
                                            if (localJobTitle != null){
                                        
                                                writeAttribute("",
                                                         "jobTitle",
                                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localJobTitle), xmlWriter);

                                            
                                      }
                                    
                                            if (localKey != null){
                                        
                                                writeAttribute("",
                                                         "key",
                                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localKey), xmlWriter);

                                            
                                      }
                                    
                                            if (localLastname != null){
                                        
                                                writeAttribute("",
                                                         "lastname",
                                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLastname), xmlWriter);

                                            
                                      }
                                    
                                      else {
                                          throw new org.apache.axis2.databinding.ADBException("required attribute localLastname is null");
                                      }
                                    
                                            if (localLevel2Password != null){
                                        
                                                writeAttribute("",
                                                         "level2Password",
                                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLevel2Password), xmlWriter);

                                            
                                      }
                                    
                                    
                                    if (localMsisdn != null){
                                        writeAttribute("",
                                           "msisdn",
                                           localMsisdn.toString(), xmlWriter);
                                    }
                                    
                                    
                                    if (localMsisdnValid != null){
                                        writeAttribute("",
                                           "msisdnValid",
                                           localMsisdnValid.toString(), xmlWriter);
                                    }
                                    
                                            if (localNetwork != null){
                                        
                                                writeAttribute("",
                                                         "network",
                                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localNetwork), xmlWriter);

                                            
                                      }
                                    
                                            if (localNumberOfEmployees != null){
                                        
                                                writeAttribute("",
                                                         "numberOfEmployees",
                                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localNumberOfEmployees), xmlWriter);

                                            
                                      }
                                    
                                    
                                    if (localOwningBusinessDivision != null){
                                        writeAttribute("",
                                           "owningBusinessDivision",
                                           localOwningBusinessDivision.toString(), xmlWriter);
                                    }
                                    
                                            if (localPartner != null){
                                        
                                                writeAttribute("",
                                                         "partner",
                                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPartner), xmlWriter);

                                            
                                      }
                                    
                                            if (localPassword != null){
                                        
                                                writeAttribute("",
                                                         "password",
                                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPassword), xmlWriter);

                                            
                                      }
                                    
                                      else {
                                          throw new org.apache.axis2.databinding.ADBException("required attribute localPassword is null");
                                      }
                                    
                                            if (localPhoneMake != null){
                                        
                                                writeAttribute("",
                                                         "phoneMake",
                                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPhoneMake), xmlWriter);

                                            
                                      }
                                    
                                            if (localPosBusinessUnit != null){
                                        
                                                writeAttribute("",
                                                         "posBusinessUnit",
                                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPosBusinessUnit), xmlWriter);

                                            
                                      }
                                    
                                    
                                    if (localPrimaryAccountUser != null){
                                        writeAttribute("",
                                           "primaryAccountUser",
                                           localPrimaryAccountUser.toString(), xmlWriter);
                                    }
                                    
                                            if (localReferral != null){
                                        
                                                writeAttribute("",
                                                         "referral",
                                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localReferral), xmlWriter);

                                            
                                      }
                                    
                                            if (localReferralDate != null){
                                        
                                                writeAttribute("",
                                                         "referralDate",
                                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localReferralDate), xmlWriter);

                                            
                                      }
                                    
                                    
                                    if (localRegistrationType != null){
                                        writeAttribute("",
                                           "registrationType",
                                           localRegistrationType.toString(), xmlWriter);
                                    }
                                    
                                            if (localRiskThreshold != null){
                                        
                                                writeAttribute("",
                                                         "riskThreshold",
                                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRiskThreshold), xmlWriter);

                                            
                                      }
                                    
                                            if (localRiskThresholdDate != null){
                                        
                                                writeAttribute("",
                                                         "riskThresholdDate",
                                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRiskThresholdDate), xmlWriter);

                                            
                                      }
                                    
                                    
                                    if (localRoleSummary != null){
                                        writeAttribute("",
                                           "roleSummary",
                                           localRoleSummary.toString(), xmlWriter);
                                    }
                                    
                                            if (localSaleDate != null){
                                        
                                                writeAttribute("",
                                                         "saleDate",
                                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSaleDate), xmlWriter);

                                            
                                      }
                                    
                                    
                                    if (localSector != null){
                                        writeAttribute("",
                                           "sector",
                                           localSector.toString(), xmlWriter);
                                    }
                                    
                                            if (localSecurityQuestion != null){
                                        
                                                writeAttribute("",
                                                         "securityQuestion",
                                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSecurityQuestion), xmlWriter);

                                            
                                      }
                                    
                                      else {
                                          throw new org.apache.axis2.databinding.ADBException("required attribute localSecurityQuestion is null");
                                      }
                                    
                                            if (localSecurityAnswer != null){
                                        
                                                writeAttribute("",
                                                         "securityAnswer",
                                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSecurityAnswer), xmlWriter);

                                            
                                      }
                                    
                                      else {
                                          throw new org.apache.axis2.databinding.ADBException("required attribute localSecurityAnswer is null");
                                      }
                                    
                                    
                                    if (localSegmentation != null){
                                        writeAttribute("",
                                           "segmentation",
                                           localSegmentation.toString(), xmlWriter);
                                    }
                                    
                                            if (localTimeStamp != null){
                                        
                                                writeAttribute("",
                                                         "timeStamp",
                                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTimeStamp), xmlWriter);

                                            
                                      }
                                    
                                            if (localTitle != null){
                                        
                                                writeAttribute("",
                                                         "title",
                                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTitle), xmlWriter);

                                            
                                      }
                                    
                                    
                                    if (localWantsGenieMarketing != null){
                                        writeAttribute("",
                                           "wantsGenieMarketing",
                                           localWantsGenieMarketing.toString(), xmlWriter);
                                    }
                                    
                                    
                                    if (localWantsOtherMarketing != null){
                                        writeAttribute("",
                                           "wantsOtherMarketing",
                                           localWantsOtherMarketing.toString(), xmlWriter);
                                    }
                                     if (localAddressTracker){
                                            if (localAddress==null){
                                                 throw new org.apache.axis2.databinding.ADBException("address cannot be null!!");
                                            }
                                           localAddress.serialize(new javax.xml.namespace.QName("http://www.o2.com/broadband/AvatarTypes","address"),
                                               factory,xmlWriter);
                                        } if (localRoleSetTracker){
                                            if (localRoleSet==null){
                                                 throw new org.apache.axis2.databinding.ADBException("roleSet cannot be null!!");
                                            }
                                           localRoleSet.serialize(new javax.xml.namespace.QName("http://www.o2.com/broadband/AvatarTypes","roleSet"),
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

                 if (localAddressTracker){
                            elementList.add(new javax.xml.namespace.QName("http://www.o2.com/broadband/AvatarTypes",
                                                                      "address"));
                            
                            
                                    if (localAddress==null){
                                         throw new org.apache.axis2.databinding.ADBException("address cannot be null!!");
                                    }
                                    elementList.add(localAddress);
                                } if (localRoleSetTracker){
                            elementList.add(new javax.xml.namespace.QName("http://www.o2.com/broadband/AvatarTypes",
                                                                      "roleSet"));
                            
                            
                                    if (localRoleSet==null){
                                         throw new org.apache.axis2.databinding.ADBException("roleSet cannot be null!!");
                                    }
                                    elementList.add(localRoleSet);
                                }
                            attribList.add(
                            new javax.xml.namespace.QName("","accountManagerEmail"));
                            
                                      attribList.add(localAccountManagerEmail.toString());
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","accountManagerName"));
                            
                                      attribList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAccountManagerName));
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","alternativeContactNumber"));
                            
                                      attribList.add(localAlternativeContactNumber.toString());
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","alternativeEmail"));
                            
                                      attribList.add(localAlternativeEmail.toString());
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","broadbandUser"));
                            
                                      attribList.add(localBroadbandUser.toString());
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","broadbandActivatedDate"));
                            
                                      attribList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localBroadbandActivatedDate));
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","broadbandCeasedDate"));
                            
                                      attribList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localBroadbandCeasedDate));
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","broadbandOrderedDate"));
                            
                                      attribList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localBroadbandOrderedDate));
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","broadbandPartialOrderedDate"));
                            
                                      attribList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localBroadbandPartialOrderedDate));
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","broadbandTerminatedDate"));
                            
                                      attribList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localBroadbandTerminatedDate));
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","broadbandStatus"));
                            
                                      attribList.add(localBroadbandStatus.toString());
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","broadbandPackage"));
                            
                                      attribList.add(localBroadbandPackage.toString());
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","companyName"));
                            
                                      attribList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCompanyName));
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","companyRegistrationNumber"));
                            
                                      attribList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCompanyRegistrationNumber));
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","companyTelephoneNumber"));
                            
                                      attribList.add(localCompanyTelephoneNumber.toString());
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","contactMedium"));
                            
                                      attribList.add(localContactMedium.toString());
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","creditVetDate"));
                            
                                      attribList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCreditVetDate));
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","creditVetPassed"));
                            
                                      attribList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCreditVetPassed));
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","customerType"));
                            
                                      attribList.add(localCustomerType.toString());
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","custnum"));
                            
                                      attribList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCustnum));
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","dateOfBirth"));
                            
                                      attribList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDateOfBirth));
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","discountEligibilityFlag"));
                            
                                      attribList.add(localDiscountEligibilityFlag.toString());
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","dqListingDetail"));
                            
                                      attribList.add(localDqListingDetail.toString());
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","dqListingLevel"));
                            
                                      attribList.add(localDqListingLevel.toString());
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","domain"));
                            
                                      attribList.add(localDomain.toString());
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","emailAddress"));
                            
                                      attribList.add(localEmailAddress.toString());
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","forename"));
                            
                                      attribList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localForename));
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","gender"));
                            
                                      attribList.add(localGender.toString());
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","genevaCustomerId"));
                            
                                      attribList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localGenevaCustomerId));
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","hasBeenBillingContact"));
                            
                                      attribList.add(localHasBeenBillingContact.toString());
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","hasHadRole"));
                            
                                      attribList.add(localHasHadRole.toString());
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","id"));
                            
                                      attribList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localId));
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","initials"));
                            
                                      attribList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localInitials));
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","isESMECustomer"));
                            
                                      attribList.add(localIsESMECustomer.toString());
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","jobFunction"));
                            
                                      attribList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localJobFunction));
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","jobTitle"));
                            
                                      attribList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localJobTitle));
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","key"));
                            
                                      attribList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localKey));
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","lastname"));
                            
                                      attribList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLastname));
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","level2Password"));
                            
                                      attribList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLevel2Password));
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","msisdn"));
                            
                                      attribList.add(localMsisdn.toString());
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","msisdnValid"));
                            
                                      attribList.add(localMsisdnValid.toString());
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","network"));
                            
                                      attribList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localNetwork));
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","numberOfEmployees"));
                            
                                      attribList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localNumberOfEmployees));
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","owningBusinessDivision"));
                            
                                      attribList.add(localOwningBusinessDivision.toString());
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","partner"));
                            
                                      attribList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPartner));
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","password"));
                            
                                      attribList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPassword));
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","phoneMake"));
                            
                                      attribList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPhoneMake));
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","posBusinessUnit"));
                            
                                      attribList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPosBusinessUnit));
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","primaryAccountUser"));
                            
                                      attribList.add(localPrimaryAccountUser.toString());
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","referral"));
                            
                                      attribList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localReferral));
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","referralDate"));
                            
                                      attribList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localReferralDate));
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","registrationType"));
                            
                                      attribList.add(localRegistrationType.toString());
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","riskThreshold"));
                            
                                      attribList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRiskThreshold));
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","riskThresholdDate"));
                            
                                      attribList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRiskThresholdDate));
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","roleSummary"));
                            
                                      attribList.add(localRoleSummary.toString());
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","saleDate"));
                            
                                      attribList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSaleDate));
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","sector"));
                            
                                      attribList.add(localSector.toString());
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","securityQuestion"));
                            
                                      attribList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSecurityQuestion));
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","securityAnswer"));
                            
                                      attribList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSecurityAnswer));
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","segmentation"));
                            
                                      attribList.add(localSegmentation.toString());
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","timeStamp"));
                            
                                      attribList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTimeStamp));
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","title"));
                            
                                      attribList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTitle));
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","wantsGenieMarketing"));
                            
                                      attribList.add(localWantsGenieMarketing.toString());
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","wantsOtherMarketing"));
                            
                                      attribList.add(localWantsOtherMarketing.toString());
                                

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
        public static UserCreationType parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            UserCreationType object =
                new UserCreationType();

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
                    
                            if (!"userCreationType".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (UserCreationType)com.o2.www.broadband.avatartypes.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                 
                    // handle attribute "accountManagerEmail"
                    java.lang.String tempAttribAccountManagerEmail =
                        
                                reader.getAttributeValue(null,"accountManagerEmail");
                            
                   if (tempAttribAccountManagerEmail!=null){
                         java.lang.String content = tempAttribAccountManagerEmail;
                        
                                                  object.setAccountManagerEmail(
                                                        com.o2.www.broadband.avatartypes.EmailAddressType.Factory.fromString(reader,tempAttribAccountManagerEmail));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("accountManagerEmail");
                    
                    // handle attribute "accountManagerName"
                    java.lang.String tempAttribAccountManagerName =
                        
                                reader.getAttributeValue(null,"accountManagerName");
                            
                   if (tempAttribAccountManagerName!=null){
                         java.lang.String content = tempAttribAccountManagerName;
                        
                                                 object.setAccountManagerName(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(tempAttribAccountManagerName));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("accountManagerName");
                    
                    // handle attribute "alternativeContactNumber"
                    java.lang.String tempAttribAlternativeContactNumber =
                        
                                reader.getAttributeValue(null,"alternativeContactNumber");
                            
                   if (tempAttribAlternativeContactNumber!=null){
                         java.lang.String content = tempAttribAlternativeContactNumber;
                        
                                                  object.setAlternativeContactNumber(
                                                        com.o2.www.broadband.avatartypes.PhoneNumberType.Factory.fromString(reader,tempAttribAlternativeContactNumber));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("alternativeContactNumber");
                    
                    // handle attribute "alternativeEmail"
                    java.lang.String tempAttribAlternativeEmail =
                        
                                reader.getAttributeValue(null,"alternativeEmail");
                            
                   if (tempAttribAlternativeEmail!=null){
                         java.lang.String content = tempAttribAlternativeEmail;
                        
                                                  object.setAlternativeEmail(
                                                        com.o2.www.broadband.avatartypes.EmailAddressType.Factory.fromString(reader,tempAttribAlternativeEmail));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("alternativeEmail");
                    
                    // handle attribute "broadbandUser"
                    java.lang.String tempAttribBroadbandUser =
                        
                                reader.getAttributeValue(null,"broadbandUser");
                            
                   if (tempAttribBroadbandUser!=null){
                         java.lang.String content = tempAttribBroadbandUser;
                        
                                                  object.setBroadbandUser(
                                                        com.o2.www.broadband.avatartypes.YesNoType.Factory.fromString(reader,tempAttribBroadbandUser));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("broadbandUser");
                    
                    // handle attribute "broadbandActivatedDate"
                    java.lang.String tempAttribBroadbandActivatedDate =
                        
                                reader.getAttributeValue(null,"broadbandActivatedDate");
                            
                   if (tempAttribBroadbandActivatedDate!=null){
                         java.lang.String content = tempAttribBroadbandActivatedDate;
                        
                                                 object.setBroadbandActivatedDate(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(tempAttribBroadbandActivatedDate));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("broadbandActivatedDate");
                    
                    // handle attribute "broadbandCeasedDate"
                    java.lang.String tempAttribBroadbandCeasedDate =
                        
                                reader.getAttributeValue(null,"broadbandCeasedDate");
                            
                   if (tempAttribBroadbandCeasedDate!=null){
                         java.lang.String content = tempAttribBroadbandCeasedDate;
                        
                                                 object.setBroadbandCeasedDate(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(tempAttribBroadbandCeasedDate));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("broadbandCeasedDate");
                    
                    // handle attribute "broadbandOrderedDate"
                    java.lang.String tempAttribBroadbandOrderedDate =
                        
                                reader.getAttributeValue(null,"broadbandOrderedDate");
                            
                   if (tempAttribBroadbandOrderedDate!=null){
                         java.lang.String content = tempAttribBroadbandOrderedDate;
                        
                                                 object.setBroadbandOrderedDate(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(tempAttribBroadbandOrderedDate));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("broadbandOrderedDate");
                    
                    // handle attribute "broadbandPartialOrderedDate"
                    java.lang.String tempAttribBroadbandPartialOrderedDate =
                        
                                reader.getAttributeValue(null,"broadbandPartialOrderedDate");
                            
                   if (tempAttribBroadbandPartialOrderedDate!=null){
                         java.lang.String content = tempAttribBroadbandPartialOrderedDate;
                        
                                                 object.setBroadbandPartialOrderedDate(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(tempAttribBroadbandPartialOrderedDate));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("broadbandPartialOrderedDate");
                    
                    // handle attribute "broadbandTerminatedDate"
                    java.lang.String tempAttribBroadbandTerminatedDate =
                        
                                reader.getAttributeValue(null,"broadbandTerminatedDate");
                            
                   if (tempAttribBroadbandTerminatedDate!=null){
                         java.lang.String content = tempAttribBroadbandTerminatedDate;
                        
                                                 object.setBroadbandTerminatedDate(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(tempAttribBroadbandTerminatedDate));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("broadbandTerminatedDate");
                    
                    // handle attribute "broadbandStatus"
                    java.lang.String tempAttribBroadbandStatus =
                        
                                reader.getAttributeValue(null,"broadbandStatus");
                            
                   if (tempAttribBroadbandStatus!=null){
                         java.lang.String content = tempAttribBroadbandStatus;
                        
                                                  object.setBroadbandStatus(
                                                        com.o2.www.broadband.avatartypes.BroadbandStatusType.Factory.fromString(reader,tempAttribBroadbandStatus));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("broadbandStatus");
                    
                    // handle attribute "broadbandPackage"
                    java.lang.String tempAttribBroadbandPackage =
                        
                                reader.getAttributeValue(null,"broadbandPackage");
                            
                   if (tempAttribBroadbandPackage!=null){
                         java.lang.String content = tempAttribBroadbandPackage;
                        
                                                  object.setBroadbandPackage(
                                                        com.o2.www.broadband.avatartypes.BroadbandPackageType.Factory.fromString(reader,tempAttribBroadbandPackage));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("broadbandPackage");
                    
                    // handle attribute "companyName"
                    java.lang.String tempAttribCompanyName =
                        
                                reader.getAttributeValue(null,"companyName");
                            
                   if (tempAttribCompanyName!=null){
                         java.lang.String content = tempAttribCompanyName;
                        
                                                 object.setCompanyName(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(tempAttribCompanyName));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("companyName");
                    
                    // handle attribute "companyRegistrationNumber"
                    java.lang.String tempAttribCompanyRegistrationNumber =
                        
                                reader.getAttributeValue(null,"companyRegistrationNumber");
                            
                   if (tempAttribCompanyRegistrationNumber!=null){
                         java.lang.String content = tempAttribCompanyRegistrationNumber;
                        
                                                 object.setCompanyRegistrationNumber(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(tempAttribCompanyRegistrationNumber));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("companyRegistrationNumber");
                    
                    // handle attribute "companyTelephoneNumber"
                    java.lang.String tempAttribCompanyTelephoneNumber =
                        
                                reader.getAttributeValue(null,"companyTelephoneNumber");
                            
                   if (tempAttribCompanyTelephoneNumber!=null){
                         java.lang.String content = tempAttribCompanyTelephoneNumber;
                        
                                                  object.setCompanyTelephoneNumber(
                                                        com.o2.www.broadband.avatartypes.PhoneNumberType.Factory.fromString(reader,tempAttribCompanyTelephoneNumber));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("companyTelephoneNumber");
                    
                    // handle attribute "contactMedium"
                    java.lang.String tempAttribContactMedium =
                        
                                reader.getAttributeValue(null,"contactMedium");
                            
                   if (tempAttribContactMedium!=null){
                         java.lang.String content = tempAttribContactMedium;
                        
                                                  object.setContactMedium(
                                                        com.o2.www.broadband.avatartypes.ContactMediumType.Factory.fromString(reader,tempAttribContactMedium));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("contactMedium");
                    
                    // handle attribute "creditVetDate"
                    java.lang.String tempAttribCreditVetDate =
                        
                                reader.getAttributeValue(null,"creditVetDate");
                            
                   if (tempAttribCreditVetDate!=null){
                         java.lang.String content = tempAttribCreditVetDate;
                        
                                                 object.setCreditVetDate(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDate(tempAttribCreditVetDate));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("creditVetDate");
                    
                    // handle attribute "creditVetPassed"
                    java.lang.String tempAttribCreditVetPassed =
                        
                                reader.getAttributeValue(null,"creditVetPassed");
                            
                   if (tempAttribCreditVetPassed!=null){
                         java.lang.String content = tempAttribCreditVetPassed;
                        
                                                 object.setCreditVetPassed(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(tempAttribCreditVetPassed));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("creditVetPassed");
                    
                    // handle attribute "customerType"
                    java.lang.String tempAttribCustomerType =
                        
                                reader.getAttributeValue(null,"customerType");
                            
                   if (tempAttribCustomerType!=null){
                         java.lang.String content = tempAttribCustomerType;
                        
                                                  object.setCustomerType(
                                                        com.o2.www.broadband.avatartypes.TypeOfCustomerType.Factory.fromString(reader,tempAttribCustomerType));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("customerType");
                    
                    // handle attribute "custnum"
                    java.lang.String tempAttribCustnum =
                        
                                reader.getAttributeValue(null,"custnum");
                            
                   if (tempAttribCustnum!=null){
                         java.lang.String content = tempAttribCustnum;
                        
                                                 object.setCustnum(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInteger(tempAttribCustnum));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("custnum");
                    
                    // handle attribute "dateOfBirth"
                    java.lang.String tempAttribDateOfBirth =
                        
                                reader.getAttributeValue(null,"dateOfBirth");
                            
                   if (tempAttribDateOfBirth!=null){
                         java.lang.String content = tempAttribDateOfBirth;
                        
                                                 object.setDateOfBirth(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDate(tempAttribDateOfBirth));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("dateOfBirth");
                    
                    // handle attribute "discountEligibilityFlag"
                    java.lang.String tempAttribDiscountEligibilityFlag =
                        
                                reader.getAttributeValue(null,"discountEligibilityFlag");
                            
                   if (tempAttribDiscountEligibilityFlag!=null){
                         java.lang.String content = tempAttribDiscountEligibilityFlag;
                        
                                                  object.setDiscountEligibilityFlag(
                                                        com.o2.www.broadband.avatartypes.YesNoType.Factory.fromString(reader,tempAttribDiscountEligibilityFlag));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("discountEligibilityFlag");
                    
                    // handle attribute "dqListingDetail"
                    java.lang.String tempAttribDqListingDetail =
                        
                                reader.getAttributeValue(null,"dqListingDetail");
                            
                   if (tempAttribDqListingDetail!=null){
                         java.lang.String content = tempAttribDqListingDetail;
                        
                                                  object.setDqListingDetail(
                                                        com.o2.www.broadband.avatartypes.ListingDetailType.Factory.fromString(reader,tempAttribDqListingDetail));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("dqListingDetail");
                    
                    // handle attribute "dqListingLevel"
                    java.lang.String tempAttribDqListingLevel =
                        
                                reader.getAttributeValue(null,"dqListingLevel");
                            
                   if (tempAttribDqListingLevel!=null){
                         java.lang.String content = tempAttribDqListingLevel;
                        
                                                  object.setDqListingLevel(
                                                        com.o2.www.broadband.avatartypes.ListingLevelType.Factory.fromString(reader,tempAttribDqListingLevel));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("dqListingLevel");
                    
                    // handle attribute "domain"
                    java.lang.String tempAttribDomain =
                        
                                reader.getAttributeValue(null,"domain");
                            
                   if (tempAttribDomain!=null){
                         java.lang.String content = tempAttribDomain;
                        
                                                  object.setDomain(
                                                        com.o2.www.broadband.avatartypes.O2DomainType.Factory.fromString(reader,tempAttribDomain));
                                            
                    } else {
                       
                               throw new org.apache.axis2.databinding.ADBException("Required attribute domain is missing");
                           
                    }
                    handledAttributes.add("domain");
                    
                    // handle attribute "emailAddress"
                    java.lang.String tempAttribEmailAddress =
                        
                                reader.getAttributeValue(null,"emailAddress");
                            
                   if (tempAttribEmailAddress!=null){
                         java.lang.String content = tempAttribEmailAddress;
                        
                                                  object.setEmailAddress(
                                                        com.o2.www.broadband.avatartypes.EmailAddressType.Factory.fromString(reader,tempAttribEmailAddress));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("emailAddress");
                    
                    // handle attribute "forename"
                    java.lang.String tempAttribForename =
                        
                                reader.getAttributeValue(null,"forename");
                            
                   if (tempAttribForename!=null){
                         java.lang.String content = tempAttribForename;
                        
                                                 object.setForename(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(tempAttribForename));
                                            
                    } else {
                       
                               throw new org.apache.axis2.databinding.ADBException("Required attribute forename is missing");
                           
                    }
                    handledAttributes.add("forename");
                    
                    // handle attribute "gender"
                    java.lang.String tempAttribGender =
                        
                                reader.getAttributeValue(null,"gender");
                            
                   if (tempAttribGender!=null){
                         java.lang.String content = tempAttribGender;
                        
                                                  object.setGender(
                                                        com.o2.www.broadband.avatartypes.GenderType.Factory.fromString(reader,tempAttribGender));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("gender");
                    
                    // handle attribute "genevaCustomerId"
                    java.lang.String tempAttribGenevaCustomerId =
                        
                                reader.getAttributeValue(null,"genevaCustomerId");
                            
                   if (tempAttribGenevaCustomerId!=null){
                         java.lang.String content = tempAttribGenevaCustomerId;
                        
                                                 object.setGenevaCustomerId(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(tempAttribGenevaCustomerId));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("genevaCustomerId");
                    
                    // handle attribute "hasBeenBillingContact"
                    java.lang.String tempAttribHasBeenBillingContact =
                        
                                reader.getAttributeValue(null,"hasBeenBillingContact");
                            
                   if (tempAttribHasBeenBillingContact!=null){
                         java.lang.String content = tempAttribHasBeenBillingContact;
                        
                                                  object.setHasBeenBillingContact(
                                                        com.o2.www.broadband.avatartypes.YesNoType.Factory.fromString(reader,tempAttribHasBeenBillingContact));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("hasBeenBillingContact");
                    
                    // handle attribute "hasHadRole"
                    java.lang.String tempAttribHasHadRole =
                        
                                reader.getAttributeValue(null,"hasHadRole");
                            
                   if (tempAttribHasHadRole!=null){
                         java.lang.String content = tempAttribHasHadRole;
                        
                                                  object.setHasHadRole(
                                                        com.o2.www.broadband.avatartypes.YesNoType.Factory.fromString(reader,tempAttribHasHadRole));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("hasHadRole");
                    
                    // handle attribute "id"
                    java.lang.String tempAttribId =
                        
                                reader.getAttributeValue(null,"id");
                            
                   if (tempAttribId!=null){
                         java.lang.String content = tempAttribId;
                        
                                                 object.setId(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(tempAttribId));
                                            
                    } else {
                       
                               throw new org.apache.axis2.databinding.ADBException("Required attribute id is missing");
                           
                    }
                    handledAttributes.add("id");
                    
                    // handle attribute "initials"
                    java.lang.String tempAttribInitials =
                        
                                reader.getAttributeValue(null,"initials");
                            
                   if (tempAttribInitials!=null){
                         java.lang.String content = tempAttribInitials;
                        
                                                 object.setInitials(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(tempAttribInitials));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("initials");
                    
                    // handle attribute "isESMECustomer"
                    java.lang.String tempAttribIsESMECustomer =
                        
                                reader.getAttributeValue(null,"isESMECustomer");
                            
                   if (tempAttribIsESMECustomer!=null){
                         java.lang.String content = tempAttribIsESMECustomer;
                        
                                                  object.setIsESMECustomer(
                                                        com.o2.www.broadband.avatartypes.YesNoType.Factory.fromString(reader,tempAttribIsESMECustomer));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("isESMECustomer");
                    
                    // handle attribute "jobFunction"
                    java.lang.String tempAttribJobFunction =
                        
                                reader.getAttributeValue(null,"jobFunction");
                            
                   if (tempAttribJobFunction!=null){
                         java.lang.String content = tempAttribJobFunction;
                        
                                                 object.setJobFunction(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(tempAttribJobFunction));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("jobFunction");
                    
                    // handle attribute "jobTitle"
                    java.lang.String tempAttribJobTitle =
                        
                                reader.getAttributeValue(null,"jobTitle");
                            
                   if (tempAttribJobTitle!=null){
                         java.lang.String content = tempAttribJobTitle;
                        
                                                 object.setJobTitle(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(tempAttribJobTitle));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("jobTitle");
                    
                    // handle attribute "key"
                    java.lang.String tempAttribKey =
                        
                                reader.getAttributeValue(null,"key");
                            
                   if (tempAttribKey!=null){
                         java.lang.String content = tempAttribKey;
                        
                                                 object.setKey(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(tempAttribKey));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("key");
                    
                    // handle attribute "lastname"
                    java.lang.String tempAttribLastname =
                        
                                reader.getAttributeValue(null,"lastname");
                            
                   if (tempAttribLastname!=null){
                         java.lang.String content = tempAttribLastname;
                        
                                                 object.setLastname(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(tempAttribLastname));
                                            
                    } else {
                       
                               throw new org.apache.axis2.databinding.ADBException("Required attribute lastname is missing");
                           
                    }
                    handledAttributes.add("lastname");
                    
                    // handle attribute "level2Password"
                    java.lang.String tempAttribLevel2Password =
                        
                                reader.getAttributeValue(null,"level2Password");
                            
                   if (tempAttribLevel2Password!=null){
                         java.lang.String content = tempAttribLevel2Password;
                        
                                                 object.setLevel2Password(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(tempAttribLevel2Password));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("level2Password");
                    
                    // handle attribute "msisdn"
                    java.lang.String tempAttribMsisdn =
                        
                                reader.getAttributeValue(null,"msisdn");
                            
                   if (tempAttribMsisdn!=null){
                         java.lang.String content = tempAttribMsisdn;
                        
                                                  object.setMsisdn(
                                                        com.o2.www.broadband.avatartypes.MobilePhoneType.Factory.fromString(reader,tempAttribMsisdn));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("msisdn");
                    
                    // handle attribute "msisdnValid"
                    java.lang.String tempAttribMsisdnValid =
                        
                                reader.getAttributeValue(null,"msisdnValid");
                            
                   if (tempAttribMsisdnValid!=null){
                         java.lang.String content = tempAttribMsisdnValid;
                        
                                                  object.setMsisdnValid(
                                                        com.o2.www.broadband.avatartypes.PortalMSISDNStatusType.Factory.fromString(reader,tempAttribMsisdnValid));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("msisdnValid");
                    
                    // handle attribute "network"
                    java.lang.String tempAttribNetwork =
                        
                                reader.getAttributeValue(null,"network");
                            
                   if (tempAttribNetwork!=null){
                         java.lang.String content = tempAttribNetwork;
                        
                                                 object.setNetwork(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(tempAttribNetwork));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("network");
                    
                    // handle attribute "numberOfEmployees"
                    java.lang.String tempAttribNumberOfEmployees =
                        
                                reader.getAttributeValue(null,"numberOfEmployees");
                            
                   if (tempAttribNumberOfEmployees!=null){
                         java.lang.String content = tempAttribNumberOfEmployees;
                        
                                                 object.setNumberOfEmployees(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInteger(tempAttribNumberOfEmployees));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("numberOfEmployees");
                    
                    // handle attribute "owningBusinessDivision"
                    java.lang.String tempAttribOwningBusinessDivision =
                        
                                reader.getAttributeValue(null,"owningBusinessDivision");
                            
                   if (tempAttribOwningBusinessDivision!=null){
                         java.lang.String content = tempAttribOwningBusinessDivision;
                        
                                                  object.setOwningBusinessDivision(
                                                        com.o2.www.broadband.avatartypes.OwningBusinessDivisionType.Factory.fromString(reader,tempAttribOwningBusinessDivision));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("owningBusinessDivision");
                    
                    // handle attribute "partner"
                    java.lang.String tempAttribPartner =
                        
                                reader.getAttributeValue(null,"partner");
                            
                   if (tempAttribPartner!=null){
                         java.lang.String content = tempAttribPartner;
                        
                                                 object.setPartner(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(tempAttribPartner));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("partner");
                    
                    // handle attribute "password"
                    java.lang.String tempAttribPassword =
                        
                                reader.getAttributeValue(null,"password");
                            
                   if (tempAttribPassword!=null){
                         java.lang.String content = tempAttribPassword;
                        
                                                 object.setPassword(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(tempAttribPassword));
                                            
                    } else {
                       
                               throw new org.apache.axis2.databinding.ADBException("Required attribute password is missing");
                           
                    }
                    handledAttributes.add("password");
                    
                    // handle attribute "phoneMake"
                    java.lang.String tempAttribPhoneMake =
                        
                                reader.getAttributeValue(null,"phoneMake");
                            
                   if (tempAttribPhoneMake!=null){
                         java.lang.String content = tempAttribPhoneMake;
                        
                                                 object.setPhoneMake(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(tempAttribPhoneMake));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("phoneMake");
                    
                    // handle attribute "posBusinessUnit"
                    java.lang.String tempAttribPosBusinessUnit =
                        
                                reader.getAttributeValue(null,"posBusinessUnit");
                            
                   if (tempAttribPosBusinessUnit!=null){
                         java.lang.String content = tempAttribPosBusinessUnit;
                        
                                                 object.setPosBusinessUnit(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(tempAttribPosBusinessUnit));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("posBusinessUnit");
                    
                    // handle attribute "primaryAccountUser"
                    java.lang.String tempAttribPrimaryAccountUser =
                        
                                reader.getAttributeValue(null,"primaryAccountUser");
                            
                   if (tempAttribPrimaryAccountUser!=null){
                         java.lang.String content = tempAttribPrimaryAccountUser;
                        
                                                  object.setPrimaryAccountUser(
                                                        com.o2.www.broadband.avatartypes.YesNoType.Factory.fromString(reader,tempAttribPrimaryAccountUser));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("primaryAccountUser");
                    
                    // handle attribute "referral"
                    java.lang.String tempAttribReferral =
                        
                                reader.getAttributeValue(null,"referral");
                            
                   if (tempAttribReferral!=null){
                         java.lang.String content = tempAttribReferral;
                        
                                                 object.setReferral(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(tempAttribReferral));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("referral");
                    
                    // handle attribute "referralDate"
                    java.lang.String tempAttribReferralDate =
                        
                                reader.getAttributeValue(null,"referralDate");
                            
                   if (tempAttribReferralDate!=null){
                         java.lang.String content = tempAttribReferralDate;
                        
                                                 object.setReferralDate(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDate(tempAttribReferralDate));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("referralDate");
                    
                    // handle attribute "registrationType"
                    java.lang.String tempAttribRegistrationType =
                        
                                reader.getAttributeValue(null,"registrationType");
                            
                   if (tempAttribRegistrationType!=null){
                         java.lang.String content = tempAttribRegistrationType;
                        
                                                  object.setRegistrationType(
                                                        com.o2.www.broadband.avatartypes.UserRegistrationType.Factory.fromString(reader,tempAttribRegistrationType));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("registrationType");
                    
                    // handle attribute "riskThreshold"
                    java.lang.String tempAttribRiskThreshold =
                        
                                reader.getAttributeValue(null,"riskThreshold");
                            
                   if (tempAttribRiskThreshold!=null){
                         java.lang.String content = tempAttribRiskThreshold;
                        
                                                 object.setRiskThreshold(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInteger(tempAttribRiskThreshold));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("riskThreshold");
                    
                    // handle attribute "riskThresholdDate"
                    java.lang.String tempAttribRiskThresholdDate =
                        
                                reader.getAttributeValue(null,"riskThresholdDate");
                            
                   if (tempAttribRiskThresholdDate!=null){
                         java.lang.String content = tempAttribRiskThresholdDate;
                        
                                                 object.setRiskThresholdDate(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDate(tempAttribRiskThresholdDate));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("riskThresholdDate");
                    
                    // handle attribute "roleSummary"
                    java.lang.String tempAttribRoleSummary =
                        
                                reader.getAttributeValue(null,"roleSummary");
                            
                   if (tempAttribRoleSummary!=null){
                         java.lang.String content = tempAttribRoleSummary;
                        
                                                  object.setRoleSummary(
                                                        com.o2.www.broadband.avatartypes.CustomerRoleSummaryType.Factory.fromString(reader,tempAttribRoleSummary));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("roleSummary");
                    
                    // handle attribute "saleDate"
                    java.lang.String tempAttribSaleDate =
                        
                                reader.getAttributeValue(null,"saleDate");
                            
                   if (tempAttribSaleDate!=null){
                         java.lang.String content = tempAttribSaleDate;
                        
                                                 object.setSaleDate(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDate(tempAttribSaleDate));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("saleDate");
                    
                    // handle attribute "sector"
                    java.lang.String tempAttribSector =
                        
                                reader.getAttributeValue(null,"sector");
                            
                   if (tempAttribSector!=null){
                         java.lang.String content = tempAttribSector;
                        
                                                  object.setSector(
                                                        com.o2.www.broadband.avatartypes.SectorType.Factory.fromString(reader,tempAttribSector));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("sector");
                    
                    // handle attribute "securityQuestion"
                    java.lang.String tempAttribSecurityQuestion =
                        
                                reader.getAttributeValue(null,"securityQuestion");
                            
                   if (tempAttribSecurityQuestion!=null){
                         java.lang.String content = tempAttribSecurityQuestion;
                        
                                                 object.setSecurityQuestion(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(tempAttribSecurityQuestion));
                                            
                    } else {
                       
                               throw new org.apache.axis2.databinding.ADBException("Required attribute securityQuestion is missing");
                           
                    }
                    handledAttributes.add("securityQuestion");
                    
                    // handle attribute "securityAnswer"
                    java.lang.String tempAttribSecurityAnswer =
                        
                                reader.getAttributeValue(null,"securityAnswer");
                            
                   if (tempAttribSecurityAnswer!=null){
                         java.lang.String content = tempAttribSecurityAnswer;
                        
                                                 object.setSecurityAnswer(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(tempAttribSecurityAnswer));
                                            
                    } else {
                       
                               throw new org.apache.axis2.databinding.ADBException("Required attribute securityAnswer is missing");
                           
                    }
                    handledAttributes.add("securityAnswer");
                    
                    // handle attribute "segmentation"
                    java.lang.String tempAttribSegmentation =
                        
                                reader.getAttributeValue(null,"segmentation");
                            
                   if (tempAttribSegmentation!=null){
                         java.lang.String content = tempAttribSegmentation;
                        
                                                  object.setSegmentation(
                                                        com.o2.www.broadband.avatartypes.CustomerSegmentationType.Factory.fromString(reader,tempAttribSegmentation));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("segmentation");
                    
                    // handle attribute "timeStamp"
                    java.lang.String tempAttribTimeStamp =
                        
                                reader.getAttributeValue(null,"timeStamp");
                            
                   if (tempAttribTimeStamp!=null){
                         java.lang.String content = tempAttribTimeStamp;
                        
                                                 object.setTimeStamp(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(tempAttribTimeStamp));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("timeStamp");
                    
                    // handle attribute "title"
                    java.lang.String tempAttribTitle =
                        
                                reader.getAttributeValue(null,"title");
                            
                   if (tempAttribTitle!=null){
                         java.lang.String content = tempAttribTitle;
                        
                                                 object.setTitle(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(tempAttribTitle));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("title");
                    
                    // handle attribute "wantsGenieMarketing"
                    java.lang.String tempAttribWantsGenieMarketing =
                        
                                reader.getAttributeValue(null,"wantsGenieMarketing");
                            
                   if (tempAttribWantsGenieMarketing!=null){
                         java.lang.String content = tempAttribWantsGenieMarketing;
                        
                                                  object.setWantsGenieMarketing(
                                                        com.o2.www.broadband.avatartypes.YesNoType.Factory.fromString(reader,tempAttribWantsGenieMarketing));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("wantsGenieMarketing");
                    
                    // handle attribute "wantsOtherMarketing"
                    java.lang.String tempAttribWantsOtherMarketing =
                        
                                reader.getAttributeValue(null,"wantsOtherMarketing");
                            
                   if (tempAttribWantsOtherMarketing!=null){
                         java.lang.String content = tempAttribWantsOtherMarketing;
                        
                                                  object.setWantsOtherMarketing(
                                                        com.o2.www.broadband.avatartypes.YesNoType.Factory.fromString(reader,tempAttribWantsOtherMarketing));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("wantsOtherMarketing");
                    
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.o2.com/broadband/AvatarTypes","address").equals(reader.getName())){
                                
                                                object.setAddress(com.o2.www.broadband.avatartypes.AddressType.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.o2.com/broadband/AvatarTypes","roleSet").equals(reader.getName())){
                                
                                                object.setRoleSet(com.o2.www.broadband.avatartypes.RoleSetType.Factory.parse(reader));
                                              
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
           
          