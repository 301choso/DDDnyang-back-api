package com.dddn.DDDnyang.controller;

import com.dddn.DDDnyang.constant.ApiConstant;
import com.dddn.DDDnyang.entity.Member;
import com.dddn.DDDnyang.service.AuthService;
import com.dddn.DDDnyang.vo.LoginVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(ApiConstant.AUTH)
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public void login(@RequestBody LoginVO loginVO) {
        authService.signin(loginVO);
    }
}
