package member.services;

import global.validators.Validator;
import member.controllers.RequestJoin;

public class JoinService {

    //의존역전원칙을 이용해서 객체지향적으로 만듦 (유연하게)
    private Validator<RequestJoin> validator;

    public JoinService(Validator<RequestJoin> validator) {
        this.validator= validator;
    }

    public void process(RequestJoin form) {
validator.check(form);
    }
}
