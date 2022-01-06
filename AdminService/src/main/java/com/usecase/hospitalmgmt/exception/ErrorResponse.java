package com.usecase.hospitalmgmt.exception;

import java.util.Date;
import java.util.List;

//Custom Exception Response Class
public class ErrorResponse {
	// Date of Exception
	private Date date;
	// General error message about nature of error
	private String message;
	// Specific errors in API request processing
	private List<String> details;
	// url of Request
	private String url;

	public ErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ErrorResponse(Date date, String message, List<String> details, String url) {
		super();
		this.setDate(date);
		this.message = message;
		this.details = details;
		this.setUrl(url);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getDetails() {
		return details;
	}

	public void setDetails(List<String> details) {
		this.details = details;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}