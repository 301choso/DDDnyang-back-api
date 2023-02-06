package com.dddn.DDDnyang.config;

import com.dddn.DDDnyang.config.data.UserSession;
import com.dddn.DDDnyang.entity.Session;
import com.dddn.DDDnyang.exception.Unauthorized;
import com.dddn.DDDnyang.repository.SessionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@RequiredArgsConstructor
public class AuthResolver implements HandlerMethodArgumentResolver {

    private final SessionRepository sessionRepository;
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        // 특정 파라미터 타입이 맞는지 확인
        return parameter.getParameterType().equals(UserSession.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest servletRequest = webRequest.getNativeRequest(HttpServletRequest.class);
        Cookie[] cookies = servletRequest.getCookies();
        if(servletRequest == null) {
            log.error("servletRequest null");
            throw new Unauthorized();
        }

        if(cookies.length == 0) {
            log.error("쿠키가 없음");
            throw new Unauthorized();
        }
        String accessToken = cookies[0].getValue();
        Session session = sessionRepository.findByAccessToken(accessToken)
               .orElseThrow(Unauthorized::new);
        return new UserSession(session.getMember().getMemberNum());
    }
}
