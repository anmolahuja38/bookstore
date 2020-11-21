package com.anmolahuja.bookstore.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = { NullPointerException.class })
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ResponseEntity<CustomApiErrorResponse> handleGenericNullPointerException(NullPointerException e) {
		CustomApiErrorResponse error = new CustomApiErrorResponse();
		error.setCause(e.getCause());
		error.setError(true);
		error.setHttpStatus("NOT_FOUND");
		error.setHttpStatusCode(500);
		error.setMessage(e.getMessage());
		error.setSuccess(true);
		return ResponseEntity.status(HttpStatus.OK).body(error);
	}
}
