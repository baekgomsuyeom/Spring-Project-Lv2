package com.springproject.springprojectlv2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)        // unique = true : username 중복된 값 받지 않기 위해
    @Size(min = 4,max = 10, message ="작성자명은 4자 이상 10자 이하만 가능합니다.")
    @Pattern(regexp = "^[a-z0-9]*$", message = "작성자명은 알파벳 소문자, 숫자만 사용 가능합니다.")      // 정규식
    private String username;

//    @Column(nullable = false)
    @Column
    @Size(min = 8,max = 15, message ="비밀번호는 8자 이상 15자 이하만 가능합니다.")
    @Pattern(regexp = "^[a-zA-Z_0-9]*$", message = "비밀번호는 알파벳 대소문자, 숫자만 사용 가능합니다.")
    private String password;

//    @Column(nullable = false)
//    @Enumerated(value = EnumType.STRING)        // Enum 타입을 저장할 때 사용. value = EnumType.STRING 을 사용해서 Enum 의 이름 그대로 DB 에 저장
//    private UserRoleEnum role;

    // '사용자 등록'에서 받아온 값을 위의 필드에 넣는다
    public User(String username, String password) {
        this.username = username;
        this.password = password;
//        this.role = role;
    }
}
