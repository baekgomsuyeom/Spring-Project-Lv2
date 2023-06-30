package com.springproject.springprojectlv2.service;

import com.springproject.springprojectlv2.dto.LoginRequestDto;
import com.springproject.springprojectlv2.dto.SignupRequestDto;
import com.springproject.springprojectlv2.entity.User;
import com.springproject.springprojectlv2.jwt.JwtUtil;
import com.springproject.springprojectlv2.repository.UserRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Service
@Validated
public class UserService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public UserService(UserRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    // 회원 가입
    private final String ADMIN_TOKEN = "AAABnvxRVklrnYxKZ0aHgTBcXukeZygoC";     // ADMIN_TOKEN : 관리자 권한 부여를 위해
    /* 단, 실제로는 이렇게 하지 않고, 관리자 권한을 부여하는 페이지를 따로 만들거나 승인자에 의해 결제하는 과정으로 구현 */

    public void signup(SignupRequestDto requestDto) {
        String username = requestDto.getUsername();
        String password = requestDto.getPassword();

        // 회원 중복 확인
        Optional<User> checkUsername = userRepository.findByUsername(username);
        if (checkUsername.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자가 존재합니다.");
        }

        // 사용자 등록 (admin = false 일 경우 아래 코드 수행)
        User user = new User(username, password);
        userRepository.save(user);      // DB 에 저장
    }

    // 로그인
    public void login(LoginRequestDto loginRequestDto, HttpServletResponse response) {
        String username = loginRequestDto.getUsername();
        String password = loginRequestDto.getPassword();

        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new IllegalArgumentException("해당 사용자를 찾을 수 없습니다.")
        );

        // 비밀번호 일치 여부 확인
        if (!user.getPassword().equals(password)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        response.addHeader(JwtUtil.AUTHORIZATION_HEADER, JwtUtil.createToken(user.getUsername()));
    }
}
