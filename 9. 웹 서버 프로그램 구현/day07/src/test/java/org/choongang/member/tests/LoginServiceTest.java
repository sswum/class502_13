package org.choongang.member.tests;

import jakarta.servlet.http.HttpServletRequest;
import org.choongang.member.services.LoginService;
import org.choongang.member.services.MemberServiceProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
//자주 쓸거라 *로 표시
import static org.junit.jupiter.api.Assertions.*;

//로그인을 문제없이 하기 위해서 만듦
@ExtendWith(MockitoExtension.class)
@DisplayName("로그인 기능 테스트")
public class LoginServiceTest {
    private LoginService loginService;

    @Mock //가짜 요청 만들기
    private HttpServletRequest request;


    @BeforeEach //초기화 작업할 때 쓰고 | successTest 전에 각 1번씩 실행 후 그다음 success Test
    void init() {
        loginService = MemberServiceProvider.getInstance().loginService();
    }




    @DisplayName("로그인 성공 시 예외가 발생하지 않음")
    @Test
    void successTest() {
        assertDoesNotThrow(() -> {

            loginService.process();

        });
    }
        @Test
        @DisplayName("필수 입력 항목(이메일, 비밀번호 ) 검증 , 검증 실패 시 BadRequestException 발생")
        void requiredFieldTest () {


    }
}
