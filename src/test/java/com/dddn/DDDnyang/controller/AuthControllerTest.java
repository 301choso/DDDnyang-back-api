package com.dddn.DDDnyang.controller;

import com.dddn.DDDnyang.config.data.UserSession;
import com.dddn.DDDnyang.entity.Member;
import com.dddn.DDDnyang.entity.Session;
import com.dddn.DDDnyang.repository.MemberRepository;
import com.dddn.DDDnyang.repository.SessionRepository;
import com.dddn.DDDnyang.vo.LoginVO;;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;

import javax.servlet.http.Cookie;
import java.net.HttpCookie;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.cookie;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AuthControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private SessionRepository sessionRepository;

    /*@BeforeEach
    void clean() {
        memberRepository.deleteAll();
    }*/

    @Test
    @DisplayName("로그인 성공")
    void test() throws Exception {
        // given
        LoginVO loginVO = LoginVO.builder()
                .memberId("hahaha")
                .memberPw("1234")
                .build();

        String json = objectMapper.writeValueAsString(loginVO);

        // expected
        mockMvc.perform(post("/api/auth/login")
                        .contentType(APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @DisplayName("로그인 성공 후 세션 1개 생성")
    void test2() throws Exception {
        // given
        Member member = new Member();
        member.setMemberNum(1L);
        member.setMemberYn("Y");
        member.setMemberCall("01234123132");
        member.setMemberName("hahaha");
        member.setMemberEmail("jj@navaer");
        member.setMemberJoinDate(LocalDateTime.now());
        member.setMemberId("hahaha");
        member.setMemberPw("1234");
        memberRepository.save(member);

        LoginVO loginVO = LoginVO.builder()
                .memberId("hahaha")
                .memberPw("1234")
                .build();

        String json = objectMapper.writeValueAsString(loginVO);

        // expected
        mockMvc.perform(post("/api/auth/login")
                            .contentType(APPLICATION_JSON)
                            .content(json))
                .andExpect(status().isOk())
                .andDo(print());

        Assertions.assertEquals(1L, sessionRepository.count());
    }

    @Test
    @DisplayName("로그인 성공 후 세션값으로 접속")
    void test3() throws Exception {
        // given
        Member member = new Member();
        member.setMemberNum(1L);
        member.setMemberYn("Y");
        member.setMemberCall("01234123132");
        member.setMemberName("hahaha");
        member.setMemberEmail("jj@navaer");
        member.setMemberJoinDate(LocalDateTime.now());
        member.setMemberId("hahaha");
        member.setMemberPw("1234");

        Session session = member.addSession();
        memberRepository.save(member);

        // expected
        mockMvc.perform(post("/api/auth/login")
                        .header("Authorization", session.getAccessToken())
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @DisplayName("로그인 성공 후 인증되지 않은 세션값으로 접속할 수 없다.")
    void test4() throws Exception {
        // given
        Member member = new Member();
        member.setMemberNum(1L);
        member.setMemberYn("Y");
        member.setMemberCall("01234123132");
        member.setMemberName("hahaha");
        member.setMemberEmail("jj@navaer");
        member.setMemberJoinDate(LocalDateTime.now());
        member.setMemberId("hahaha");
        member.setMemberPw("1234");

        Session session = member.addSession();
        memberRepository.save(member);

        // expected
        mockMvc.perform(post("/api/auth/login")
                        .header("Authorization", session.getAccessToken() + "1234")
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isUnauthorized())
                .andDo(print());
    }

    @Test
    @DisplayName("로그인 쿠키 생성 확인")
    void test5() throws Exception {
        // given
        LoginVO loginVO = LoginVO.builder()
                .memberId("hahaha")
                .memberPw("1234")
                .build();

        String json = objectMapper.writeValueAsString(loginVO);

        mockMvc.perform(post("/api/auth/login")
                        .contentType(APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andDo(print());
    }

}