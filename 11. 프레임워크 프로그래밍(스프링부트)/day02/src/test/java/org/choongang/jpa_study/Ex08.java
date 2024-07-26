package org.choongang.jpa_study;

import jakarta.persistence.EntityManager;
import jakarta.persistence.FlushModeType;
import jakarta.persistence.PersistenceContext;
import org.choongang.member.constants.Authority;
import org.choongang.member.entities.Member;
import org.choongang.member.repositories.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@ActiveProfiles("test")
@SpringBootTest
public class Ex08 {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach
    void init() { //자동 플러쉬모드 해놔야 한다.
        em.setFlushMode(FlushModeType.AUTO);

        Member member = Member.builder()
                .email("user01@test.org")
                .password("12345678")
                .userName("사용자01")
                .authority(Authority.USER)
                .build(); //날짜를 안 쓴 이유는 generated 안에 쿼리dsl이 날짜를 넣어주기때문
        memberRepository.saveAndFlush(member);

        em.clear(); //영속성 안에 있으면 쿼리수행이 되지 않기 때문에 비웠당
    }
@Test
   void test1() {
    Member member = memberRepository.findById(1L).orElse(null);
    member.setUserName("테스트!!");

    List<Member> members = memberRepository.findAll();
    members.forEach(System.out::println);

   }

}
