package com.dddn.DDDnyang.repository;

import com.dddn.DDDnyang.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


/**
 * 회원 Repository 인터페이스
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByMemberIdAndMemberPw(String memberId, String memberPw);

}
