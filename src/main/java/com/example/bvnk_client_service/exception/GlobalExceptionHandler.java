package com.example.bvnk_client_service.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

import static com.example.bvnk_client_service.util.constants.ClientMicroserviceConstants.ERROR_WHILE_PROCESSING_REQUEST;
import static com.example.bvnk_client_service.util.constants.ClientMicroserviceConstants.INVALID_REQUEST;


@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<CustomErrorResponse> handleIllegalArgumentException(IllegalArgumentException e) {
		LOG.error(INVALID_REQUEST + e.getMessage());
		CustomErrorResponse customErrorResponse = new CustomErrorResponse();
		customErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		customErrorResponse.setTimestamp(ZonedDateTime.now());
		customErrorResponse.setError(INVALID_REQUEST);
		customErrorResponse.setMessage(INVALID_REQUEST + e.getMessage());
		return ResponseEntity.badRequest().body(customErrorResponse);
	}

	@ExceptionHandler(IllegalStateException.class)
	public ResponseEntity<CustomErrorResponse> handleIllegalStateException(IllegalStateException e) {
		CustomErrorResponse customErrorResponse = new CustomErrorResponse();
		customErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		customErrorResponse.setTimestamp(ZonedDateTime.now());
		customErrorResponse.setError(ERROR_WHILE_PROCESSING_REQUEST);
		customErrorResponse.setMessage(ERROR_WHILE_PROCESSING_REQUEST + e.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
							 .body(customErrorResponse);
	}

}
