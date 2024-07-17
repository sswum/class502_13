package org.choongang.member.api.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.choongang.member.controllers.RequestJoin;
import org.choongang.member.entities.Member;
import org.choongang.member.mappers.MemberMapper;
import org.choongang.member.services.JoinService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.IntStream;

@Slf4j
@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class ApiMemberController {

    private final MemberMapper mapper;
    private final JoinService joinService;

    @PostMapping // POST /api/member
    public void join(RequestJoin form) {
        log.info(form.toString());
    }

    @GetMapping("/info/{email}")
    public Member info(@PathVariable("email") String email) {
        //Conten-Type : application/json
        Member member = mapper.get(email);
        return member;
    }

    @GetMapping("/list") //여러 사용자 만들기
    public List<Member> list() {
        List<Member> members = IntStream.rangeClosed(1, 10)
                .mapToObj(i -> Member.builder()
                        .email("user" + i + "@test.org")
                        //제일 민감한 건 비밀번호 =>민감한 부분은 json을 방지하는 애노테이션이 있음
                        .password("12345678")
                        .userName("사용자" + i)
                        .regDt(LocalDateTime.now())
                        .build())
                .toList();
        return members;
    }


    @GetMapping(path = "/test", produces = "text/html; charset=UTF-8")
    public String test() {

        //Content-Type : text/plain
        return "안녕하세요!";
    }
    @GetMapping("/test2")
    public void test2() {
        log.info("test2...");
    }
}
