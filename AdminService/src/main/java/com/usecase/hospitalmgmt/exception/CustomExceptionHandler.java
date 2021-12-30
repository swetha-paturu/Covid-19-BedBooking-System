package com.usecase.hospitalmgmt.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@SuppressWarnings({ "unchecked", "rawtypes" })
@ControllerAdvice
public class CustomExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);
	
	//Exception handler for all Exception Object
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, HttpServletRequest request) {
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse(new Date(), ex.toString(), details, request.getRequestURI());
		logger.error(ex.getMessage(), ex);
		return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	//Exception handler for no records found Exception
	@ExceptionHandler(NoRecordFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(NoRecordFoundException ex,
			HttpServletRequest request) {
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse(new Date(), ex.toString(), details,request.getRequestURI());
		logger.error(ex.getMessage(), ex);
		return new ResponseEntity(error, HttpStatus.NOT_FOUND);
	}
}