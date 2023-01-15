package com.dddn.DDDnyang;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ComponentScan({"com.dddn"})
@PropertySource("classpath:/config/database.properties")
@EnableCaching(proxyTargetClass = true)
@RequiredArgsConstructor
public class DdDnyangApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(DdDnyangApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DdDnyangApplication.class);
	}
}
