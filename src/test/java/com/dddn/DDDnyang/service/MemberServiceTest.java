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
                .member_id(1L)
                .member_num(1L)
                .member_pw("1234")
                .member_yn("Y")
                .member_email("jj@naver.com")
                .member_call("01012341234")
                .member_join_date(LocalDateTime.now()).build());*/
        List<Member> mList = memberService.listMember(new HashMap<>());
        assertEquals(1L, mList.get(0).getMember_id());
    }
}