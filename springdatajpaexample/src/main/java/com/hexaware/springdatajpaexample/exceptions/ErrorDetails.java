package com.hexaware.springdatajpaexample.exceptions;

import java.time.LocalDateTime;

public class ErrorDetails {
	private LocalDateTime time;
	private String message;
	private String path;
	private String errorCode;
	public ErrorDetails(LocalDateTime time, String message, String path, String errorCode) {
		super();
		this.time = time;
		this.message = message;
		this.path = path;
		this.errorCode = errorCode;
	}
	public ErrorDetails() {
		super();
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	
}
