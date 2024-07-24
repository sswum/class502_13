package org.choongang.jpa_study;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.choongang.member.entities.Member;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
@TestPropertySource(properties = "spring.profiles.active=test")
public class Ex04 {

    @PersistenceContext
    private EntityManager em;

    @Test
    void test1() throws Exception  {
        Member member = new Member();
        member.setEmail("user01@test.org");
        member.setPassword("12345678");
        member.setUserName("사용자01");

        em.persist(member);
        em.flush(); //안 쓰면 그냥 바로 그대로 데이터를 가져옴

        em.clear(); //새로운 데이터를 가져오기 위해서 클리어를 했다. 영속성을 비워야지 다시 조회해서 새로운 데이터로 가져오니까

        member = em.find(Member.class, member.getSeq());
        //공통 속성화를 해서 보이게끔 작성했따. 두개의 날짜를 출력
        System.out.printf("createdAt : %s, modifiedAt: %s%n", member.getCreatedAt(),member.getModifiedAt());

        Thread.sleep(5000);
        member.setUserName("(수정)사용자01");
        em.flush();
        em.clear();

        member = em.find(Member.class, member.getSeq());
        System.out.printf("createdAt : %s, modifiedAt: %s%n", member.getCreatedAt(),member.getModifiedAt());
    }
}
