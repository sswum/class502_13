package member.services;
import global.Mailer;
import global.exceptions.ValidationException;
import global.validators.Validator;
import jakarta.servlet.http.HttpServletRequest;
import member.validators.LoginValidator;

import java.util.Locale;

public class LoginService {

    private Validator<HttpServletRequest> validator;
    private Mailer mailer;

    public LoginService(Validator<HttpServletRequest> validator) {
        this.validator = validator;
    }

    public void setMailer(Mailer mailer) {
        this.mailer = mailer;
    }

    public void process(HttpServletRequest request) {
        validator.check(request);

        //로그인 시 성공 가정
        //성공 시 메일 전송
        if (mailer != null) {
            String email = request.getParameter("email");
            mailer.send(email);
           // mailer.send(email);



        }
    }
}
