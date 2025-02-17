package com.side.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.side.dto.SideRequestDto;
import com.side.dto.util.ApiResponse;
import com.side.usecase.ArticleUseCase;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class SideController {

	private final ArticleUseCase articleUseCase;

	@PostMapping
	public ApiResponse<String> create(
		@RequestBody SideRequestDto sideRequestDto
	) {
		if (!StringUtils.hasText(sideRequestDto.getOriginName())) {
			throw new IllegalArgumentException("originName required");
		}
		return ApiResponse.ok(articleUseCase.create(sideRequestDto.getOriginName()));
	}

	@GetMapping
	public ApiResponse<String> get(
		@RequestParam(name = "originName", required = false) String originName
	) {
		if (!StringUtils.hasText(originName)) {
			throw new IllegalArgumentException("originName required");
		}
		return ApiResponse.ok(articleUseCase.find(originName));
	}
}
