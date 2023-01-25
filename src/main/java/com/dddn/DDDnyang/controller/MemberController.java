package com.dddn.DDDnyang.controller;

import com.dddn.DDDnyang.constant.ApiConstant;
import com.dddn.DDDnyang.entity.Member;
import com.dddn.DDDnyang.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 회원 REST 컨트롤러 클래스
 */

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(ApiConstant.MEMBER)
public class MemberController {

    private final MemberService memberService;

    @GetMapping()
    public ResponseEntity<List<Member>> listMember(@RequestParam Map<String, Object> paramMap) {
        List<Member> memberList = memberService.listMember(paramMap);
        return ResponseEntity.status(HttpStatus.OK).body(memberList);
    }

}
