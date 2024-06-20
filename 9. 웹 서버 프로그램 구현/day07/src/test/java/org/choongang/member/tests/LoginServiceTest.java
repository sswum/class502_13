package org.choongang.member.tests;

import com.github.javafaker.Faker;
import jakarta.servlet.http.HttpServletRequest;
import org.choongang.global.exceptions.BadRequestException;
import org.choongang.member.services.LoginService;
import org.choongang.member.services.MemberServiceProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
//자주 쓸거라 *로 표시
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

//로그인을 문제없이 하기 위해서 만듦
@ExtendWith(MockitoExtension.class)
@DisplayName("로그인 기능 테스트")
public class LoginServiceTest {
    private LoginService loginService;
    private Faker faker;

    @Mock //가짜 요청 만들기
    private HttpServletRequest request;


    @BeforeEach
        //초기화 작업할 때 쓰고 | successTest 전에 각 1번씩 실행 후 그다음 success Test
    void init() {
        loginService = MemberServiceProvider.getInstance().loginService();

        //모의객체 만들기
        faker = new Faker(Locale.ENGLISH);


    }

    void setData() { //모의객체에 있다가 여기로 분리 시켜줬다.
        // 비번 검증 하려면 이메일이 있어야함. 비번검증할 때 이메일을 검증하는 건 이상하니까 이렇게 따로 분리
        setParam("email", faker.internet().emailAddress()); //이메일 체크
        setParam("password", faker.regexify("\\w{8}").toLowerCase()); // 패스워드 체크 소문자로만 나오게 8자리만
    }

    //편의를 위해 만듦 =>요청에 이름이 들어오면 값으로 반환해주겠다.
    void setParam(String name, String value) {
        given(request.getParameter(name)).willReturn(value);
    }


    @DisplayName("로그인 성공 시 예외가 발생하지 않음")
    @Test
    void successTest() {
        assertDoesNotThrow(() -> {
            // loginService에서 뭐 생성하니 여기 오류 나서 (request) 바꿔줌
            loginService.process(request);

        });
    }

    @Test
    @DisplayName("필수 입력 항목(이메일, 비밀번호 ) 검증 , 검증 실패 시 BadRequestException 발생")
        //값이 있는지, 문구가 제대로 나오는 지 체크 , null 값인지
    void requiredFieldTest() {
        assertAll(
                ()-> requiredEachFieldTest("email", false, "이메일"),
                ()-> requiredEachFieldTest("email", true, "이메일"),
                ()-> requiredEachFieldTest("password", false, "비밀번호"),
                ()-> requiredEachFieldTest("password", true, "비밀번호")
        );
    }


    void requiredEachFieldTest(String name, String message, boolean isNull) {
        //이메일이 제대로 들어갈 수 있게 데이터 초기화
        setData();

        BadRequestException thrown = assertThrows(BadRequestException.class, () -> {
            if (name.equals("password")) {
                setParam("password", isNull ? null : "  ");
            } else { //이메일
                setParam("email", isNull ? null : "   ");
            }
            loginService.process(request);
        }, name + "테스트");
        String msg = thrown.getMessage();  //여러개를 검증할 때는 메세지를 넣어놔서 어디서 문제가 생겼는지 알 수 있따
        assertTrue(msg.contains(message), name+", 키워드:"+message+"테스트");

    }
}
