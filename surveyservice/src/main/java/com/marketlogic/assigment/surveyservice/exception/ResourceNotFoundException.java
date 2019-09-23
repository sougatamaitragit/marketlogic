package com.marketlogic.assigment.surveyservice.exception;

public class ResourceNotFoundException extends Exception{
String errorMessage;
	
	String errCode;

	public ResourceNotFoundException(String errm,String errCode) {
		errorMessage=errm;
		this.errCode = errCode;
	}
	
	
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


	public String getErrCode() {
		return errCode;
	}


	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

}
