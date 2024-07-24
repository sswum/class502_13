package org.choongang.member.repositories;

import org.choongang.member.entities.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member,Long>,
        QuerydslPredicateExecutor<Member> {
  Member findByEmail(String email); //이메일로 조회

    Page<Member> findByEmailContaining(String keyword, Pageable pageable);
    //앞으로 Page를 많이 쓴다. 반환값은 page이고 매개변수 pageable 이다.


    List<Member> findByEmailContainingAndUserNameContainingOrderByCreatedAtDesc(String key1, String key2);

    @Query("SELECT m FROM Member m WHERE m.email LIKE :k1 AND m.userName LIKE :k2 ORDER BY m.createdAt DESC")
    List<Member> getMembers(@Param("k1")String key1,@Param("k2") String key2);
//쿼리를 직접 쓰는게 아니라 메서드를 조합해서 쿼리를 조합해 가는 방식
}
