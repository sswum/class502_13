package org.choongang.jpa_study;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.choongang.member.constants.Authority;
import org.choongang.member.entities.Member;
import org.choongang.member.entities.QMember;
import org.choongang.member.repositories.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;
import java.util.stream.IntStream;

import static javax.management.Query.or;

@TestPropertySource(properties = "spring.profiles.active=test")
@SpringBootTest
public class Ex07 {

    @Autowired
    private MemberRepository memberRepository;


    @BeforeEach
    void init() {
        //열명의 회원 데이터 복붙 (Ex05.java)
        List<Member> members = IntStream.rangeClosed(1, 10)
                .mapToObj(i -> Member.builder()
                        .email("user" + i + "@test.org")
                        .password("12345678")
                        .userName("사용자" + i)        //검색 조건을 다양하게▽
                        .authority(i % 2 == 0 ? Authority.USER : Authority.ADMIN)
                        .build()).toList();

        memberRepository.saveAllAndFlush(members);

    }


    @Test
    void test1() {
        QMember member = QMember.member;
        BooleanExpression c1 = member.userName.contains("용");

        List<Member> members = (List<Member>) memberRepository.findAll(c1);
        members.forEach(System.out::println);
    }

    @Test
    void test2() {
        String key ="용";
        QMember member = QMember.member;
        BooleanBuilder andBuilder = new BooleanBuilder();

        BooleanBuilder orBuilder = new BooleanBuilder();
        orBuilder.or(member.email.contains(key));
        .or(member.userName.contains(key));
        andBuilder.and(orBuilder);

        List<Member> members = (List<Member>) memberRepository.findAll(andBuilder)
    }
    @Test
    void test3() {
        QMember member
    }
}
