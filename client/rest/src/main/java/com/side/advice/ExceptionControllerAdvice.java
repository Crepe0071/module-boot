package com.side.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.side.dto.util.ApiResponse;

@RestControllerAdvice
public class ExceptionControllerAdvice {

	@ExceptionHandler(IllegalStateException.class)
	public ApiResponse<String> illegalStateException(IllegalStateException exception) {
		return ApiResponse.fail(exception.getMessage());
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ApiResponse<String> illegalArgumentException(IllegalArgumentException exception) {
		return ApiResponse.fail(exception.getMessage());
	}
}
