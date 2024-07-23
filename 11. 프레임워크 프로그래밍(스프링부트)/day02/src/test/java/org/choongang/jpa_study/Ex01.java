package org.choongang.jpa_study;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.choongang.member.entities.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;

@SpringBootTest
@Transactional //트랜잭션을 알아서 처리해줌
@TestPropertySource(properties = "spring.profiles.active=test")
public class Ex01 {

    // @Autowired
    // private EntityManagerFactory emf;
   // @Autowired
    @PersistenceContext
    private EntityManager em;


    @Test
    void test1() {
        // EntityManager em= emf.createEntityManager(); // 상태변화에 따라서 쿼리 자동생성

       //EntityTransaction tx = em.getTransaction(); //트랜잭션으로 감싸고

        //tx.begin(); //트랜잭션 시작
        Member member = new Member();
        member.setSeq(1L);
        member.setEmail("user01@test.org");
        member.setPassword("12345678");
        member.setUserName("사용자01");
        member.setCreatedAt(LocalDateTime.now());

        //영속성관리(변화감지)를 해줄려면 persist(member); 해줘야 됨. 값의 변화에 따라서 쿼리 생성
        em.persist(member); // 영속 상태 -변화 감지 메모리에 있다. 변화 감지...
        em.flush(); //INSERT쿼리 실행되는 부분

        em.detach(member); //영속 상태 분리 -변화 감지 x

        member.setUserName("(수정)사용자01"); //변경
        member.setModifiedAt(LocalDateTime.now());

        em.flush(); // UPDATE 쿼리 ( 인서트 후 그안에서 내용이 바뀌면 업데이트 쿼리로 실행)

        em.merge(member);

        em.flush();
        //em.remove(member); //제거 상태, 제거X 상태만 제거 상태다
        // em.flush(); // DELETE 쿼리  (플러쉬를 해야만 진짜 제거가 된다)
        // tx.commit(); // 트랜잭션 커밋 (위에 transactional 넣어서 뺌)
    }
}
