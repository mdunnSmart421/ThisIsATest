
/**
 * GetPortalProfileFault.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:35 LKT)
 */

package com.o2.finance.ws.online;

public class GetPortalProfileFault extends java.lang.Exception{
    
    private uk.co.o2.soa.onlinecustomerdata_1.GetPortalProfileFault faultMessage;
    
    public GetPortalProfileFault() {
        super("GetPortalProfileFault");
    }
           
    public GetPortalProfileFault(java.lang.String s) {
       super(s);
    }
    
    public GetPortalProfileFault(java.lang.String s, java.lang.Throwable ex) {
      super(s, ex);
    }
    
    public void setFaultMessage(uk.co.o2.soa.onlinecustomerdata_1.GetPortalProfileFault msg){
       faultMessage = msg;
    }
    
    public uk.co.o2.soa.onlinecustomerdata_1.GetPortalProfileFault getFaultMessage(){
       return faultMessage;
    }
}
    