package com.springproject.springprojectlv2.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardRequestDto {
    private String title;
    private String contents;
}
