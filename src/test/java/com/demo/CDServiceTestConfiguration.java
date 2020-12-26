package com.demo;

import com.demo.services.CDService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class CDServiceTestConfiguration {
    @Bean
    @Primary
    public CDService cdService() {
        return Mockito.mock(CDService.class);
    }
}
