package com.kingmartinien.backend.config;

import com.kingmartinien.backend.auditing.AuditorAwareImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

@Configuration
public class BeansConfig {

    @Bean
    AuditorAware<String> auditorAware() {
        return new AuditorAwareImpl();
    }

}
