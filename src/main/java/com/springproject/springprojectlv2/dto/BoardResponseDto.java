package com.springproject.springprojectlv2.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.springproject.springprojectlv2.entity.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BoardResponseDto {
    private Long id;        // 게시글 구분을 위한 id 값
    private String title;       // 제목
    private String username;    // 작성자명
    private String contents;    // 작성 내용
    private LocalDateTime createdAt;        // 게시글 생성 날짜
    private LocalDateTime modifiedAt;       // 게시글 수정 날짜

    public BoardResponseDto(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.username = board.getUsername();
        this.contents = board.getContents();
        this.createdAt = board.getCreatedAt();
        this.modifiedAt = board.getModifiedAt();
    }
}
