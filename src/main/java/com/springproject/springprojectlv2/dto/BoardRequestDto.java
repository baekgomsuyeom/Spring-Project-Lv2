package com.springproject.springprojectlv2.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardRequestDto {
    private String title;           // 제목
    private String contents;        // 작성 내용
//    private String username;        // 작성자명
//    private String password;        // 비밀번호
}

