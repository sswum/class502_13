package org.choongang.member.validators;

import lombok.RequiredArgsConstructor;
import org.choongang.member.controllers.RequestLogin;
import org.choongang.member.entities.Member;
import org.choongang.member.mappers.MemberMapper;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@RequiredArgsConstructor
@Component
public class LoginValidator implements Validator {
    private final MemberMapper mapper;
    //DB에 아이디 비밀번호 체크를 위해서 DB연결


    //넘어온 리퀘스트 로그인만 검증하겠다
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(RequestLogin.class);
    }


    @Override
    public void validate(Object target, Errors errors) {

        // Bean Validation 검증 실패시에는 다음 검증을 진행 X
        if (errors.hasErrors()) {
            return;  //여기서 필수항목조건이 끝났기 때문에
            //밑에 StringUtils를 빼도 된다.
        }



      /*  2) email로 회원이 조회 되는지 검증
          3) 조회된 회원의 비밀번호가 입력한 값과 일치하는지 검증 */

        RequestLogin form = (RequestLogin) target;
        String email = form.getEmail();
        String password = form.getPassword();

        if (StringUtils.hasText(email)) {
            Member member = mapper.get(email);
            if (member == null) { //이메일이 같지않으면
                errors.reject("Check.emailPassword");
            }
            if (StringUtils.hasText(password) && !BCrypt.checkpw(password, member.getPassword())) {
               errors.reject("Check.emailPassword");
                //비밀번호가 같은지 체크해주고 아닐 경우 해당 에러가 발생하도록
            }
        }
    }
}
