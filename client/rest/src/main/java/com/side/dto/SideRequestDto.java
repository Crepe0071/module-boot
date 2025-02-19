package com.side.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SideRequestDto {

	private String originName;

	public SideRequestDto(String originName) {
		this.originName = originName;
	}
}
