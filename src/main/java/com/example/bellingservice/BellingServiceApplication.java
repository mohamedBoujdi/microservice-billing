package com.example.bellingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//@EnableFeignClients
public class BellingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BellingServiceApplication.class, args);
    }

}
