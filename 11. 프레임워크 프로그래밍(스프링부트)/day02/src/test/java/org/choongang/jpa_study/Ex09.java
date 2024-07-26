package org.choongang.jpa_study;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.choongang.board.entities.BoardData;
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

@ActiveProfiles("test")
@SpringBootTest
@Transactional
public class Ex09 { //원 데이터 외에 다른 데이터를 가져올 때는 영속성을 유지해야한다. 그러기 위해서 트랜잭셔널 사용

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private BoardDataRepository boardDataRepository;

    @PersistenceContext //이거 대신 @Autowired써도 똑같지만 확실한 정보 확인을 위해 저걸씀!
    private EntityManager em;

    @BeforeEach
    void init() { //먼저 사용자 생성
        Member member = Member.builder()
                .email("user01@test.org")
                .password("12345678")
                .userName("사용자01")
                .authority(Authority.USER)
                .build();

        memberRepository.saveAndFlush(member);

        List<BoardData> items = IntStream.rangeClosed(1,10)
                .mapToObj(i -> BoardData.builder()
                        .subject("제목"+i)
                        .content("내용"+i)
                        .member(member) //멤버(엔티티)를 꼭 넣어야지만 값이 들어간다
                        .build()).toList();

        boardDataRepository.saveAllAndFlush(items);
        em.clear(); //싹다 영속성을 비워야지 새로운 쿼리가 작성해서 들어가기 때문에! 현장에선 비우면 안된당.
                    //현장에선 캐시의 장점을 이용해 쿼리를 실행 하지 않는 것이 효율성 UP!

    }

    @Test // 게시글 하나 조회하는 test1 메소드 생성
    void test1() {
        BoardData item = boardDataRepository.findById(1L).orElse(null);
        Member member = item.getMember();
        System.out.println(member);

    }
    //inner join은 게시글의 값이 회원쪽에 있어야 가능 (잘 나오지 않는다)
  //"left join" 한쪽만 있고 한쪽은 없어도 가능한 조인 (주가 되는 테이블은 값이 있어야 한다.)
    //  비회원인경우는 null로 나오게끔

    @Test
    void test2() {
        Member member = memberRepository.findById(1L).orElse(null); //한명만 있으니 1L
        List<BoardData> items = member.getItems();
        items.forEach(System.out::println);
    }

}
