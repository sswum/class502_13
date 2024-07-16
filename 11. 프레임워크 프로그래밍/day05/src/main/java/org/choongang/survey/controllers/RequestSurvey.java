package org.choongang.survey.controllers;

import lombok.Data;

@Data
//커맨드 객체 생성
public class RequestSurvey {
    private String q1;
    private String q2;
    private String q3;
    private String q4;

}
