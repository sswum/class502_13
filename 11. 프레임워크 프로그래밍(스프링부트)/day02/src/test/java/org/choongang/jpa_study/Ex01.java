package org.choongang.jpa_study;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.choongang.member.entities.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;

@SpringBootTest
@TestPropertySource(properties = "spring.profiles.active=test")
public class Ex01 {

    @Autowired
    private EntityManagerFactory emf;


    @Test
    void test1() {
        EntityManager em= emf.createEntityManager(); // 상태변화에 따라서 쿼리 자동생성

        EntityTransaction tx = em.getTransaction(); //트랜잭션으로 감싸고

        tx.begin(); //트랜잭션 시작
        Member member = new Member();
        member.setSeq(1L);
        member.setEmail("user01@test.org");
        member.setPassword("12345678");
        member.setUserName("사용자01");
        member.setCreatedAt(LocalDateTime.now());

        //영속성관리(변화감지)를 해줄려면 persist(member); 해줘야 됨. 값의 변화에 따라서 쿼리 생성
        em.persist(member);
        em.flush();
        tx.commit(); // 트랜잭션 커밋
    }
}
