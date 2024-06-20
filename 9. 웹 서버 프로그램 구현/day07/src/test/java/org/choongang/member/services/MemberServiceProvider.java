package org.choongang.member.services;

import org.apache.ibatis.session.SqlSession;
import org.choongang.global.configs.DBConn;
import org.choongang.member.mapper.MemberMapper;
import org.choongang.member.validators.JoinValidator;
import org.choongang.member.validators.LoginValidator;

// 객체 조립기
public class MemberServiceProvider {
    private static MemberServiceProvider instance;

    private MemberServiceProvider() {}

    public static MemberServiceProvider getInstance() {
        if (instance == null) {
            instance = new MemberServiceProvider();
        }

        return instance;
    }
    public SqlSession getSession() {
        return DBConn.getSession();

    }


    public MemberMapper memberMapper() {
        return getSession().getMapper(MemberMapper.class);
    } //겟세션이 있어야 롤백이 가능해지기 때문에 넣어주기

    public JoinValidator joinValidator() {
        return new JoinValidator(memberMapper());
    }

    public JoinService joinService() {
        return new JoinService(joinValidator(), memberMapper());
    }

    public LoginValidator loginValidator() {
        return new LoginValidator(memberMapper());
    }

//객체 조립기로 의존성을 해결 !
    public LoginService loginService() {
        return new LoginService(loginValidator(), memberMapper()); //memberMapper를 넣어줘야 오류가 해결
    }
}