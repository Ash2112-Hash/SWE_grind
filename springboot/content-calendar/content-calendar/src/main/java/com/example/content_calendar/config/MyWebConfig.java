package com.example.content_calendar.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;



@Configuration
public class MyWebConfig {

    @Bean
    public RestClient restTemplate(){
        return RestClient.builder().build();
    }
}
