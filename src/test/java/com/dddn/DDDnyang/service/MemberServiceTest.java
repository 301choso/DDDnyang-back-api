package com.dddn.DDDnyang.service;

import com.dddn.DDDnyang.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Test
    public void 멤버확인() {
        /*Member member = memberService.saveMember(Member.builder()
                .memberId(1L)
                .memberNum(1L)
                .memberPw("1234")
                .memberYn("Y")
                .memberEmail("jj@naver.com")
                .memberCall("01012341234")
                .memberJoinDate(LocalDateTime.now()).build());*/
        List<Member> mList = memberService.listMember(new HashMap<>());
        assertEquals(1L, mList.get(0).getMemberId());
    }
}