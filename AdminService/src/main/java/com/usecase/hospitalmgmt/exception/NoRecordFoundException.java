package com.usecase.hospitalmgmt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * No Record Found Custom Exception
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoRecordFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NoRecordFoundException() {}

	public NoRecordFoundException(String exception) {
		super(exception);
	}
}