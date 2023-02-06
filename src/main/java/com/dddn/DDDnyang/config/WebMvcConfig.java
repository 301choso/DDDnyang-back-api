package com.dddn.DDDnyang.config;

import com.dddn.DDDnyang.repository.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;


@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {

    private final SessionRepository sessionRepository;

    private static final String[] SWAGGER_WHITELIST = {
            "/v3/api-docs/**",
            "/swagger-ui/**",
            "/swagger-ui.html",
    };

    private static final String [] EXCLUDE_PATH = {
            "/api/auth/login",
            "/api/board"
    };

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // HandlerInterceptor를 상속받은 AuthInterceptor를 등록
        registry.addInterceptor(new AuthInterceptor())
                .excludePathPatterns(SWAGGER_WHITELIST)
                .excludePathPatterns(EXCLUDE_PATH);
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        // HandlerMethodArgumentResolver를 상속받은 AuthResolver를 등록
        resolvers.add(new AuthResolver(sessionRepository));
    }
}
