package com.dddn.DDDnyang.service;

import com.dddn.DDDnyang.entity.Member;
import com.dddn.DDDnyang.exception.InvalidSigninInformation;
import com.dddn.DDDnyang.repository.MemberRepository;
import com.dddn.DDDnyang.vo.LoginVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final MemberRepository memberRepository;

    @Transactional
    public void signin(LoginVO loginVO) {
        Member member = memberRepository.findByMemberIdAndMemberPw(loginVO.getMemberId(), loginVO.getMemberPw())
                .orElseThrow(InvalidSigninInformation::new);
        member.addSession();
    }
}
