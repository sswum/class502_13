package exam01;

import exam01.config.AppCtx2;
import exam01.member.Assembler;
import exam01.member.controllers.RequestJoin;
import exam01.member.dao.MemberDao;
import exam01.member.entities.Member;
import exam01.member.services.JoinService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Ex02 {

    @Test
    void test1() {

        //필요할 때 호출하면 알아서 객체 조립해줄 것
        // 객체 조립기로 인해 통제와 관리가 쉬워짐
        Assembler assembler = new Assembler();
        JoinService joinService = assembler.joinService();
        MemberDao memberDao = assembler.memberDao();

        RequestJoin form = RequestJoin.builder()
                .email("user01@test.org")
                .userName("사용자")
                .password("12345678")
                .confirmPassword("12345678")
                .build();

        joinService.process(form);

        List<Member> members = memberDao.getList();
        members.forEach(System.out::println);

    }


        @Test
    void test2() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx2.class);
    }
}

