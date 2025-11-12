package com.example.feignedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.example.feignedemo.feign")
public class FeignedemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignedemoApplication.class, args);
    }

}
