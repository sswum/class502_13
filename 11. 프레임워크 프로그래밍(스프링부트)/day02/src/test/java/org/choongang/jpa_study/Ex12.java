package org.choongang.jpa_study;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.choongang.board.entities.BoardData;
import org.choongang.board.entities.QBoardData;
import org.choongang.board.repositories.BoardDataRepository;
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
import java.util.stream.IntStream;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class Ex12 {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BoardDataRepository boardDataRepository;

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private JPAQueryFactory queryFactory;

    @BeforeEach
    void init() {
        Member member = Member.builder()
                .email("user01@test.org")
                .password("12345678")
                .userName("사용자01")
                .authority(Authority.USER)
                .build();

        memberRepository.saveAndFlush(member);


        List<BoardData> items = IntStream.rangeClosed(1, 10)
                .mapToObj(i -> BoardData.builder()
                        .subject("제목" + i)
                        .content("내용" + i)
                        .member(member)
                        .build()).toList();

        boardDataRepository.saveAllAndFlush(items);
        em.clear(); //
    }

    @Test
    void test1() {
        List<BoardData> items = boardDataRepository.findAll();

        for (BoardData item : items) {
            Member member = item.getMember();
            String email = member.getEmail();
            String userName = member.getUserName();
            System.out.printf("email=%s, userName=%s%n", email, userName);
        }
    }

    @Test
    void test2() {
        List<BoardData> items = boardDataRepository.getAllList();
    }

    @Test
    void test3() {
        List<BoardData> items = boardDataRepository.findBySubjectContaining("제목");
    }

    @Test
    void test4() { //QueryDsl의 fetchJoin()을 써서 해결해본당
        QBoardData boardData = QBoardData.boardData; //큐클래스를 가져와서 쓴다.
       // JPAQueryFactory factory = new JPAQueryFactory(em);
        JPAQuery<BoardData> query = queryFactory
                .selectFrom(boardData)
                .leftJoin(boardData.member)
                .fetchJoin();

        List<BoardData> items = query.fetch();
       // items.forEach(System.out::println);
    }

    @Test
    void test5() {
        QBoardData boardData = QBoardData.boardData;
        JPAQuery<Tuple> query = queryFactory.select(boardData.subject, boardData.content);


        List<Tuple> items = query.fetch();
        for (Tuple item : items) {


            String subject = item.get(boardData.subject);
            String content = item.get(boardData.content);
            System.out.printf("subject=%s, content=%s%n", subject, content);
        }

    }

    @Test
    void test6() {
        QBoardData boardData = QBoardData.boardData;
        JPAQuery<Long> query = queryFactory.select(boardData.seq.sum())
                .from(boardData);
        long sum = query.fetchOne();
        System.out.println(sum);

    }

    @Test
    void test7() {
        QBoardData boardData = QBoardData.boardData;


        BooleanBuilder andBuilder = new BooleanBuilder();
        andBuilder.and(boardData.subject.contains("제목"))
                .and(boardData.member.email.eq("user01@test.org"));  // 다른쪽에 엔티티를 조회하는 것이기 때문에
/*
        BooleanBuilder orBuilder = new BooleanBuilder(); // in조건이 좋고 or는 쿼리가 꼬이는 경우가 많다.
        orBuilder.or(boardData.seq.eq(2L))
                .or(boardData.seq.eq(3L)) //메서드 체이닝을 허용하기 때문에 .해서 계속 연속으로 해서된다.
        andBuilder.and(orBuilder); */

        PathBuilder<BoardData> pathBuilder = new PathBuilder<>(BoardData.class,"boardData");//정렬 조건 만들기 ( .class 가 있어서 정보를 확인해보고 어떤 메서드를 호출할 지 알 수 있어서 편리하다
        // 프로젝트에서도 reflection API를 통해서 생성자라던지 필요한 메서드라던지 찾아서 사용할 예정
        //위에 variable은 [QBoardData.boardData;]에 있는 boardData이다.


        JPAQuery<BoardData> query = queryFactory.selectFrom(boardData)
                .leftJoin(boardData.member)
                .fetchJoin()
                .where(andBuilder)
                .offset(3) //조회 시작 레코드 위체 3번 행부터 조회 시작
                .limit(3)//3개 레코드로 한정 -갯수 제한
                .orderBy(
                        new OrderSpecifier(Order.DESC,pathBuilder.get("createdAt")),
                        new OrderSpecifier (Order.ASC,pathBuilder.get("subject")));
           //   .where(boardData.seq.in(2L,3L,4L)); //BooleanExpriession - Predicate

        List<BoardData> items = query.fetch();
        items.forEach(System.out::println);
    }

}