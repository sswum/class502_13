package org.choongang.member.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Member { //변경하지 않으면 보통 클래스 이름이 테이블 이름이다.
    @Id
    private Long seq;
    private String email;
    private String password;
    private String userName;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

}
