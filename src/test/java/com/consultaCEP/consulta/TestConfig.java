package com.consultaCEP.consulta;

import com.consultaCEP.consulta.service.LeilaoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {
    @Bean
    public LeilaoService leilao(){return new LeilaoService();}
}
