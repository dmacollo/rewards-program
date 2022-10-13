package com.chartercom.rewardsprogram.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.chartercom.rewardsprogram.vo.CustomerPointsResponse;
import com.chartercom.rewardsprogram.vo.ErrorInfo;
import com.chartercom.rewardsprogram.vo.ServiceResponse;


@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
	  @ExceptionHandler(value={CustomerNotFoundException.class})
	  public ResponseEntity<ServiceResponse<CustomerPointsResponse>> customerNotFoundError(Exception e){		
	    ErrorInfo errorInfo=new ErrorInfo("404",e.getLocalizedMessage());	     
	    return new ResponseEntity<>(new ServiceResponse<>(null,errorInfo),HttpStatus.NOT_FOUND);
	  }

}
