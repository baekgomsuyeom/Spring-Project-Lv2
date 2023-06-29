package com.springproject.springprojectlv2.dto;

import lombok.Getter;

@Getter
public class BoardRequestDto {
    private String title;           // 제목
    private String username;        // 작성자명
    private String password;        // 비밀번호
    private String contents;        // 작성 내용
}
