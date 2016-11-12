package com.usermanagement.commons.dto;

import java.net.HttpURLConnection;
import java.util.Collection;

import org.springframework.validation.ObjectError;

public class ResponseDTO {
	private int httpStatus;
	private Object body;
	private String message;

	private ResponseDTO(int httpStatus, Object body, String message) {
		this.httpStatus = httpStatus;
		this.body = body;
		this.message = message;
	}
	
	private ResponseDTO(int httpStatus, String message) {
		this.httpStatus = httpStatus;
		this.message = message;
	}

	private ResponseDTO() {
	}

	public int getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(int httpStatus) {
		this.httpStatus = httpStatus;
	}

	public Object getBody() {
		return body;
	}

	public void setBody(Object body) {
		this.body = body;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static ResponseDTO ok(Object body) {
		return new ResponseDTO(HttpURLConnection.HTTP_OK, body, null);
	}

	public static ResponseDTO not_found(Object objectId, String message) {
		return new ResponseDTO(HttpURLConnection.HTTP_NOT_FOUND, objectId, message);
	}
	
	public static ResponseDTO not_found(String message) {
		return new ResponseDTO(HttpURLConnection.HTTP_NOT_FOUND, message);
	}

	public static ResponseDTO validation_errors(Collection<ObjectError> errors) {
		return new ResponseDTO(HttpURLConnection.HTTP_BAD_REQUEST, errors, "Your submission was invalid, fix the following");
	}

	public static ResponseDTO bad_request(String message) {
		return new ResponseDTO(HttpURLConnection.HTTP_BAD_REQUEST, null, message);
	}

	public static ResponseDTO server_error(Exception e) {
		return new ResponseDTO(HttpURLConnection.HTTP_INTERNAL_ERROR, e.getStackTrace(), "Server blew up");
	}

	public static ResponseDTO forbidden(Object objectId, String message) {
		return new ResponseDTO(HttpURLConnection.HTTP_FORBIDDEN, objectId, message);
	}

	public static ResponseDTO unsupported(String message) {
		return new ResponseDTO(HttpURLConnection.HTTP_NOT_ACCEPTABLE, null, message);
	}
}
