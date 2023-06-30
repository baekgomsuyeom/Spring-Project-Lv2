package com.springproject.springprojectlv2.entity;

import com.springproject.springprojectlv2.dto.BoardRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "board")
@NoArgsConstructor
public class Board extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "username", nullable = false)
    private String username;

//    @Column(name = "password", nullable = false)
//    private String password;

    @Column(name = "contents", nullable = false, length = 500)
    private String contents;

    // board : user = N : 1 다대일 단방향 연관관계
//    @ManyToOne(fetch = FetchType.LAZY)      // board 를 조회할 때마다 매번 user 의 정보가 필요한 건 아니기 때문에 이렇게 설정
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // 게시글 작성
    public Board(BoardRequestDto requestDto, User user) {
        this.title = requestDto.getTitle();
        this.username = user.getUsername();
        this.contents = requestDto.getContents();
        this.user = user;
    }

    // 게시글 수정
    public void update(BoardRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
    }
}