package com.adixSoftware.relationship.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody ExceptionResponse handleResourceNotFound(final ResourceNotFoundException exception,
			final HttpServletRequest request) {

		ExceptionResponse errorMessage = new ExceptionResponse();
		errorMessage.setError(exception.getMessage());
		return errorMessage;
	}

	@ExceptionHandler(DuplicateValueException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody ExceptionResponse handleDuplicateValueException(final DuplicateValueException exception,
			final HttpServletRequest request) {

		ExceptionResponse errorMessage = new ExceptionResponse();
		errorMessage.setError(exception.getMessage());
		return errorMessage;
	}
	
	@ExceptionHandler(PhoneNumberValidationException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody ExceptionResponse handlePhoneNumberValidationException(final PhoneNumberValidationException exception,
			final HttpServletRequest request) {

		ExceptionResponse errorMessage = new ExceptionResponse();
		errorMessage.setError(exception.getMessage());
		return errorMessage;
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<String> conflict(DataIntegrityViolationException exception) {

		ExceptionResponse errorMessage = new ExceptionResponse();
		errorMessage.setError(exception.getMessage());
		return new ResponseEntity<String>("No duplicate value allowed", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException entityNotFoundException) {
		return new ResponseEntity<String>("No value is present in DB", HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String, Object> body = new HashMap<>();
		List<String> errors = exception.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage())
				.collect(Collectors.toList());
		body.put("errors", errors);
		return new ResponseEntity<>(body, headers, status);
	}
}
