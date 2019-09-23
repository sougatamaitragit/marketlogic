package com.marketlogic.assignment.questionservice.error.model;


/**
 * This is the error class model which will be returned back to user in case of any exceptions
 * @author Sougata Maitra
 *
 */
public class ApiError {
	
	String errorMessage;
	String exceptionCode;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getExceptionCode() {
		return exceptionCode;
	}

	public void setExceptionCode(String exceptionCode) {
		this.exceptionCode = exceptionCode;
	}

}
