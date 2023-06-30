package com.springproject.springprojectlv2.controller;

import com.springproject.springprojectlv2.dto.LoginRequestDto;
import com.springproject.springprojectlv2.dto.MsgResponseDto;
import com.springproject.springprojectlv2.dto.SignupRequestDto;
import com.springproject.springprojectlv2.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 회원 가입
    @PostMapping("/signup")
//    public ResponseEntity<MsgResponseDto> signup(@RequestBody @Valid SignupRequestDto signupRequestDto) {
    public ResponseEntity<?> signup(@RequestBody @Valid SignupRequestDto signupRequestDto) {        // 이거도 되려나?
        userService.signup(signupRequestDto);
        return ResponseEntity.ok(new MsgResponseDto("회원가입 완료", HttpStatus.OK.value()));
//        return new ResponseEntity(new MsgResponseDto("회원가입 성공"), HttpStatus.OK);
    }

    // 로그인
    @PostMapping("/login")
//    public ResponseEntity<MsgResponseDto> login(@RequestBody LoginRequestDto loginRequestDto, HttpServletResponse response) {
    public ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequestDto, HttpServletResponse response) {
        userService.login(loginRequestDto, response);
        return ResponseEntity.ok(new MsgResponseDto("로그인 완료",HttpStatus.OK.value()));
//        return new ResponseEntity(new MsgResponseDto("로그인 성공"), HttpStatus.OK);
    }
}
