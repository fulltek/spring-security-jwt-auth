package com.arack.mvcjwt.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse {
	private int status;
	private String message;
	private Object result;

	public ApiResponse(String message) {
		this.message = message;
	}

	public ApiResponse(int status, String message) {
		this.status = status;
		this.message = message;
	}

}
