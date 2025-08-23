package com.kmp.newslish.controller.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import jakarta.servlet.http.HttpServletRequest;

// @RestControllerAdvice(basePackages = "com.kmp.newslish.controller")
public class RestAPIExceptionHandler {

	private ResponseEntity<ErrorResponse> buildResponse(HttpServletRequest request, HttpStatus status, String message) {
		ErrorResponse response = ErrorResponse.builder()
			.path(request.getRequestURI())
			.message(message)
			.timestamp(LocalDateTime.now())
			.build();
		return ResponseEntity.status(status).body(response);
	}

	@ExceptionHandler({IllegalArgumentException.class, NullPointerException.class})
	public ResponseEntity<ErrorResponse> handleIllegalOrNull(Exception e, HttpServletRequest request) {
		return buildResponse(request, HttpStatus.BAD_REQUEST, "처리중 서버 문제가 발생했습니다. error: " + e.getMessage());
	}

	@ExceptionHandler({HandlerMethodValidationException.class})
	public ResponseEntity<ErrorResponse> handleInputValidation(Exception e, HttpServletRequest request) {
		return buildResponse(request, HttpStatus.BAD_REQUEST, "올바르지 않은 유효값입니다.");
	}
}
