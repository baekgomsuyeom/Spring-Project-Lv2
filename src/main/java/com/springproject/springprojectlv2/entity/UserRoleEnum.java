//package com.springproject.springprojectlv2.entity;
//
//// 유저의 권한을 관리하는 클래스
//public enum UserRoleEnum {
//    USER(Authority.USER),       // 사용자 권한 (일반 사용자)
//    ADMIN(Authority.ADMIN);     // 관리자 권한
//
//    private final String authority;
//
//    // 생성자
//    UserRoleEnum(String authority) {        // 생성자의 매개변수를 위의 사용자 권한, 관리자 권한으로 넣는다
//        this.authority = authority;
//    }
//
//    public String getAuthority() {
//        return this.authority;
//    }
//
//    // 생성자의 매개변수 값을 관리하는 내부 클래스
//    public static class Authority {
//        public static final String USER = "ROLE_USER";
//        public static final String ADMIN = "ROLE_ADMIN";
//    }
//}
