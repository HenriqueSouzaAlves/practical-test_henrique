package com.example.api.exceptionhandler;

import java.util.Date;

public class MessageExceptionHandler {
	
	private Date timestamp;
	private Integer status;
	private String message;
	private String messageErro;
	
	public MessageExceptionHandler(Date timestamp, Integer status, String message, String messageErro) {
		this.timestamp = timestamp;
		this.status = status;
		this.message = message;
		this.messageErro = messageErro;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessageErro() {
		return messageErro;
	}

	public void setMessageErro(String messageErro) {
		this.messageErro = messageErro;
	}

}
