package member.controllers;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestJoin {
    private String email; // 유저들이 쓰는 아이디랑 같게 쓸 이메일
    private String password;
    private String confirmPassword; // 비번 확인
    private String userName;
    private boolean termsAgree; //약관 동의

}
