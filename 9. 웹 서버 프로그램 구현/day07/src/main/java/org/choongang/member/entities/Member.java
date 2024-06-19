package org.choongang.member.entities;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Member {
    //카멜방식으로
 private long userNO;
 private String email;
 private String password;
 private String userName;
 private LocalDateTime regDt;
 private LocalDateTime modDt;



}
