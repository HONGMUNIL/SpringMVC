package com.korit.springboot_study.ioc;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigA {

    @Bean
    public ClassD call(){

        System.out.println("ConfigA call");
        return new ClassD();
    }

}



