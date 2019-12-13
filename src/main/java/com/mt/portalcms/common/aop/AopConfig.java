package com.mt.portalcms.common.aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AopConfig {
    @Bean
    public Aspecttoken demo() {
        return new Aspecttoken();
    }
}
