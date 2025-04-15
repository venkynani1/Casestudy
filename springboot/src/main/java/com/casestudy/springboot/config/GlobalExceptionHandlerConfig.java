	package com.casestudy.springboot.config;
	
	import java.io.IOException;
	
	
	
	
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.http.HttpStatusCode;
	import org.springframework.web.ErrorResponse;
	import org.springframework.web.bind.annotation.ExceptionHandler;
	import org.springframework.web.bind.annotation.RestControllerAdvice;
	
	import com.casestudy.springboot.exception.*;
	
	@RestControllerAdvice
	public class GlobalExceptionHandlerConfig {
	
		Logger logger =  LoggerFactory.getLogger("GlobalExceptionHandlerConfig"); 
		 @ExceptionHandler(InvalidUsernameException.class)
		 public ErrorResponse invalidUsernameExceptionHandler(InvalidUsernameException e) {
			 //logger for invalid USERNAme given exception
			 logger.error("Invalid Username given " + e.getMessage());
			 return ErrorResponse.create
					 			(e, 
					 			HttpStatusCode.valueOf(400), 
					 			e.getMessage()); 
		 }
		 
		 @ExceptionHandler(InvalidIDException.class)
		 public ErrorResponse invalidIDExceptionHandler(InvalidIDException e) {
			 //logger for invalid id given exception
			 logger.error("Invalid ID given " + e.getMessage());
			 return ErrorResponse.create
					 			(e, 
					 			HttpStatusCode.valueOf(400), 
					 			e.getMessage()); 
		 }
		 
		 
		 @ExceptionHandler(RuntimeException.class)
		 public ErrorResponse invalidImageExceptionHandler(RuntimeException e) {
			 return ErrorResponse.create
					 			(e, 
					 			HttpStatusCode.valueOf(400), 
					 			e.getMessage()); 
		 }
		 
		 @ExceptionHandler(IOException.class)
		 public ErrorResponse invalidIOExceptionHandler(IOException e) {
			 return ErrorResponse.create
					 			(e, 
					 			HttpStatusCode.valueOf(400), 
					 			e.getMessage()); 
		 }
		 
		 @ExceptionHandler(Exception.class)
		 public ErrorResponse exceptionHandler(Exception e) {
			 return ErrorResponse.create
					 			(e, 
					 			HttpStatusCode.valueOf(400), 
					 			e.getMessage()); 
		 }
	}