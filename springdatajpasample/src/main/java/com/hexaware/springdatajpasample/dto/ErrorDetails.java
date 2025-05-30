package com.hexaware.springdatajpasample.dto;

import java.time.LocalDateTime;

public class ErrorDetails {
	private LocalDateTime time;
	private String message;
	private String path;
	private String errorCode;
	
	
	public ErrorDetails(LocalDateTime localDateTime, String string, String string2, String string3) {
		super();
		// TODO Auto-generated constructor stub
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
