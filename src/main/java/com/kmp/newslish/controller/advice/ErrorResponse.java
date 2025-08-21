package com.kmp.newslish.controller.advice;

import java.time.LocalDateTime;

import lombok.Builder;

@Builder
public class ErrorResponse {
	private String message;
	private String path;
	private LocalDateTime timestamp;
}
