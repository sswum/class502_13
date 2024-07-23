package org.choongang.jpa_study;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.choongang.member.entities.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;

@Transactional
@TestPropertySource(properties = "spring.profiles.active=test")
@SpringBootTest
public class Ex02 {

    @PersistenceContext
    private EntityManager em;

    @BeforeEach
    void init() {
        for (long i = 1L; i <= 10L; i++) {
            Member member = new Member();
            member.setSeq(i);
            member.setEmail("user"+ i+"@test.org");
            member.setPassword("12345678");
            member.setUserName("사용자"+ i);
            member.setCreatedAt(LocalDateTime.now());
            em.persist(member); // 영속 상태
        }
        em.flush(); //DB 영구 반영
    }
    @Test
    void test1() {

    }
}
