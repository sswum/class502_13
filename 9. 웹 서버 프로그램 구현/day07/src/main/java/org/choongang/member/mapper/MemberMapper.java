package org.choongang.member.mapper;

import org.choongang.member.entities.Member;

public interface MemberMapper {
    //select , insert , delete 기능

    long exist(String email);

    Member get(String email);

    int register(Member member);



}
