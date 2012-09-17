
/**
 * GetDefaultProfileFault.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:35 LKT)
 */

package com.o2.finance.ws.online;

public class GetDefaultProfileFault extends java.lang.Exception{
    
    private uk.co.o2.soa.onlinecustomerdata_1.GetDefaultProfileFault faultMessage;
    
    public GetDefaultProfileFault() {
        super("GetDefaultProfileFault");
    }
           
    public GetDefaultProfileFault(java.lang.String s) {
       super(s);
    }
    
    public GetDefaultProfileFault(java.lang.String s, java.lang.Throwable ex) {
      super(s, ex);
    }
    
    public void setFaultMessage(uk.co.o2.soa.onlinecustomerdata_1.GetDefaultProfileFault msg){
       faultMessage = msg;
    }
    
    public uk.co.o2.soa.onlinecustomerdata_1.GetDefaultProfileFault getFaultMessage(){
       return faultMessage;
    }
}
    