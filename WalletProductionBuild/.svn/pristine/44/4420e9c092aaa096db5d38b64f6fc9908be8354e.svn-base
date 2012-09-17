package com.o2.finance.exception;

public class SearchServiceIdentitiesExceededException extends FinanceException {

	private static final long serialVersionUID = 21062011132416L;
	private String faultString;
    private String faultCode;
    private String faultDetail;
    
	public SearchServiceIdentitiesExceededException(String faultCode, String faultString, String faultDetail) {
	        super(faultString);
	        this.faultString = faultString;
	        this.faultCode = faultCode;
	        this.faultDetail = faultDetail;
	}
	
	public SearchServiceIdentitiesExceededException(String message, Exception rootException) {
		super(message, rootException);
	}

	public SearchServiceIdentitiesExceededException(String message) {
		super(message);		
	}

    public String getFaultCode() {
        return faultCode;
    }

    public String getFaultDetail() {
        return faultDetail;
    }

    public String getFaultString() {
        return faultString;
    }

}
