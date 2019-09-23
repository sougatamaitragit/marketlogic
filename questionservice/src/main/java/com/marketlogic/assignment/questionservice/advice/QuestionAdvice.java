package com.marketlogic.assignment.questionservice.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.marketlogic.assignment.questionservice.error.model.ApiError;
import com.marketlogic.assignment.questionservice.exception.ResourceNotFoundException;
import com.marketlogic.assignment.questionservice.util.ServiceUtil;
/**
 * This class handles all un handled exceptions
 * @author Sougata Maitra
 *
 */
@ControllerAdvice
public class QuestionAdvice {
	

	@ResponseBody
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ApiError genericException(Exception ex) {
		ApiError res = new ApiError();
		res.setExceptionCode(ServiceUtil.SYSTEM_EXCEPTION_CODE);
		res.setErrorMessage(ex.getMessage());
		return res;
	}
	
	
	@ResponseBody
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ApiError businessException(ResourceNotFoundException ex) {
		ApiError res = new ApiError();
		res.setExceptionCode(ex.getErrCode());
		res.setErrorMessage(ex.getErrorMessage());
		return res;
	}

}
