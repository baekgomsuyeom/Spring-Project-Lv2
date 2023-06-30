package com.springproject.springprojectlv2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public class MsgResponseDto {
    private String msg;
    private int statusCode;
}
