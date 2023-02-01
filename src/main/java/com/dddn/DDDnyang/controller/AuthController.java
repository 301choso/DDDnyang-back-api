package com.dddn.DDDnyang.controller;

import com.dddn.DDDnyang.constant.ApiConstant;
import com.dddn.DDDnyang.entity.Member;
import com.dddn.DDDnyang.excrption.InvalidSigninInformation;
import com.dddn.DDDnyang.repository.MemberRepository;
import com.dddn.DDDnyang.vo.LoginVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(ApiConstant.AUTH)
public class AuthController {

    private final MemberRepository memberRepository;

    @PostMapping("/login")
    public Member login(@RequestBody LoginVO login) {
        log.info(">>>login={}", login);
        return memberRepository.findByMemberIdAndMemberPw(login.getMemberId(), login.getMemberPw())
                .orElseThrow(InvalidSigninInformation::new);
    }
}
