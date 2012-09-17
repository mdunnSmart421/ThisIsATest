
/**
 * GetProfileFault.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:35 LKT)
 */

package com.o2.finance.ws.online;

public class GetProfileFault extends java.lang.Exception{
    
    private uk.co.o2.soa.onlinecustomerdata_1.GetProfileFault faultMessage;
    
    public GetProfileFault() {
        super("GetProfileFault");
    }
           
    public GetProfileFault(java.lang.String s) {
       super(s);
    }
    
    public GetProfileFault(java.lang.String s, java.lang.Throwable ex) {
      super(s, ex);
    }
    
    public void setFaultMessage(uk.co.o2.soa.onlinecustomerdata_1.GetProfileFault msg){
       faultMessage = msg;
    }
    
    public uk.co.o2.soa.onlinecustomerdata_1.GetProfileFault getFaultMessage(){
       return faultMessage;
    }
}
    