package org.choongang.member.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class Member {
    @Id
    private long seq;
    private String email;
    @JsonIgnore
    private String password;
    private String userName;
  //  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regDt;
    //날짜를 원하는 패턴으로 나오게끔 바꿔주는 애노테이션
}