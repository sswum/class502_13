package org.choongang.member.controllers;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
//가입요청이 들어왔을 때 써야 하는 필수 항목,체크해야하는거 쓰기
public class RequestJoin {
    private String email;
    private String password;
    private String confirmPassword;
    private String userName;
    private boolean termsAgree;
}
