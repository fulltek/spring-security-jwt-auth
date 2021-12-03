package com.arack.mvcjwt.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginResponse {
	private String username;
    private String token;
    private String message;
    
    public LoginResponse(String message) {
    	this.message=message;
    }
    
    public LoginResponse(String username,String token) {
    	this.username=username;
    	this.token=token;
    }

}
