package com.example.api.exceptionhandler;

import java.util.Date;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice(basePackages = "com.example.api.web.rest")
public class CustomerControllerAdvice {

	@ResponseBody
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<MessageExceptionHandler> argumentNotValid(CustomerNotFoundException argument) {
		MessageExceptionHandler error = new MessageExceptionHandler
				(new Date(), HttpStatus.NOT_FOUND.value(), "Cliente não encontrado.", argument.getMessage());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ResponseBody
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MessageExceptionHandler> methodArgumentNotValid(MethodArgumentNotValidException method) {
		MessageExceptionHandler error = new MessageExceptionHandler
				(new Date(), HttpStatus.BAD_REQUEST.value(), "Nome ou Email inválido.", method.getMessage());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ResponseBody
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<MessageExceptionHandler> methodArgumentNotValid(DataIntegrityViolationException violation) {
		MessageExceptionHandler error = new MessageExceptionHandler
				(new Date(), HttpStatus.INTERNAL_SERVER_ERROR.value(), "Ocorreu um erro ao inserir Cliente no banco de dados.", violation.getMessage());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
