package com.hexaware.springdatajpasample.controller;

import java.net.http.HttpHeaders;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.hexaware.springdatajpasample.customexception.ResourceNotFoundException;
import com.hexaware.springdatajpasample.dto.ErrorDetails;

@ControllerAdvice
public class GlobalExceptionController {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exceptionObj, WebRequest w){
		ErrorDetails error = new ErrorDetails(LocalDateTime.now(),
				exceptionObj.getMessage(),
				w.getDescription(true),"PRODUCT_NOT_FOUND");
		return new ResponseEntity<ErrorDetails>(error,HttpStatus.NOT_FOUND);
	}
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request){
		Map<String,String> errorMap = new HashMap();
		List<ObjectError> errorList = ex.getBindingResult().getAllErrors();
		errorList.forEach((error)->{
			String fieldName = ((FieldError)error).getField();
			String message = error.getDefaultMessage();
			errorMap.put(fieldName, message);
			
			
		});
		return null;
	}
}
