package br.com.condominus.Condominus.Configurations;

import br.com.condominus.Condominus.domain.core.regex.ValidationsRegex;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ValidationsRegex validationsRegex(){
        return new ValidationsRegex();
    }
}
