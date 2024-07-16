package org.choongang.member.controllers;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class MemberSearch {

    //가입 시작일 , 가입 종료일 => 검색 범위를 지정해줄 것
    @DateTimeFormat(pattern="yyyyMMdd")
    private LocalDate sDate; //검색 시작일
    @DateTimeFormat(pattern="yyyyMMdd")
    private LocalDate eDate; //검색 종료일

}
