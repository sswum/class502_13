package org.choongang.jpa_study;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.choongang.board.entities.BoardData;
import org.choongang.board.entities.HashTag;
import org.choongang.board.repositories.BoardDataRepository;
import org.choongang.member.repositories.HashTagRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.IntStream;

@ActiveProfiles("test")
@Transactional
@SpringBootTest
public class Ex11 {

    @Autowired
    private BoardDataRepository boardDataRepository;

    @Autowired
    private HashTagRepository hashTagRepository;

   @PersistenceContext
    private EntityManager em;

    @BeforeEach
    void init() {
        List<HashTag> tags = IntStream.rangeClosed(1, 5) //태그를 5개 생성
                .mapToObj(i -> HashTag.builder().tag("태그" + i).build()).toList();

        hashTagRepository.saveAllAndFlush(tags); //레포지토리에 넣어주고 영속성

        List<BoardData> items = IntStream.rangeClosed(1, 5)
                .mapToObj(i -> BoardData.builder()
                        .subject("제목" + i)
                        .content("내용" + i)
//                        .tags(tags)
                        .build()).toList();
        boardDataRepository.saveAllAndFlush(items);
        em.clear();//영속성 비우기

    }

    @Test
    void test1() { //게시글 하나에 태그 1~5번까지 조회
        BoardData item = boardDataRepository.findById(1L).orElse(null);
//        List<HashTag> tags = item.getTags();
//        tags.forEach(System.out::println);

    }

    @Test
    void test() {                       //hashtagrepository에서 <Hashtag, String> 으로 바꿔야됨
        HashTag tag = hashTagRepository.findById("태그2").orElse(null);
//        List<BoardData> items =tag.getItems();
//        items.forEach(System.out::println);
    }
}
