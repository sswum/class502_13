package org.choongang.board.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.choongang.global.entities.BaseEntity;
import org.choongang.member.entities.Member;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder

public class BoardData extends BaseEntity {
    @Id //직접 기본키 매핑
    @GeneratedValue // 기본키 할당을 DB에게 맡김 @Id와 같이 써야됨.
    private Long seq; //시퀀스 객체 생성

    @ManyToOne(fetch = FetchType.LAZY) // 멤버테이블에 기본키가 엔티티명 기준해서 만들어진다. member_seq - 엔티티명 기본키 속성명
    @JoinColumn(name = "mSeq") //원할 땐 조인컬럼을 이용해 이름 바꾸기 가능
    private Member member;

    @Column(nullable = false)
    private String subject;

    @Lob //CLOB으로 만들어질 것
    private String content;

    //@ManyToMany//게시글 하나에 여러 해시태그가 들어갈 수 있당!
    //private List<HashTag> tags;


}
