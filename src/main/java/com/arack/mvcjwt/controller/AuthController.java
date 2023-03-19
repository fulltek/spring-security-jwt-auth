package com.arack.mvcjwt.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arack.mvcjwt.config.security.JwtTokenUtil;
import com.arack.mvcjwt.domain.User;
import com.arack.mvcjwt.dto.ApiResponse;
import com.arack.mvcjwt.dto.LoginRequest;
import com.arack.mvcjwt.dto.LoginResponse;
import com.arack.mvcjwt.services.UserService;

@RestController
@RequestMapping("auth")
public class AuthController {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private UserService userService;

	@PostMapping("login")
	public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
		User dbuser = userService.findUserByUsername(loginRequest.getUsername());
		if (dbuser != null) {
			if (passwordEncoder.matches(loginRequest.getPassword(), dbuser.getPassword())) {
				return ResponseEntity.ok().contentType(APPLICATION_JSON)
						.body(new LoginResponse(dbuser.getUsername(), jwtTokenUtil.generateAccessToken(dbuser)));
			} else {
				return ResponseEntity.badRequest().body(new LoginResponse("登录凭据无效"));
			}
		} else
			return ResponseEntity.badRequest().body(new LoginResponse("登录凭据无效"));
	}

	@PostMapping("signup")
	public ResponseEntity<ApiResponse> signup(@RequestBody User user) {
		User user0 = userService.findUserByUsername(user.getUsername());
		if (user0 != null)
			return ResponseEntity.badRequest().body(new ApiResponse(1, "用户已存在"));
		else {
			user0 = user;
			user0.setPassword(passwordEncoder.encode(user.getPassword()));
			userService.insertUser(user0);
			return ResponseEntity.ok().contentType(APPLICATION_JSON).body(new ApiResponse(0, "用户注册成功"));
		}
	}

}