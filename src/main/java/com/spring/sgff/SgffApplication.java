package com.spring.sgff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SgffApplication {
    public static void main(String[] args) {
        SpringApplication.run(SgffApplication.class, args);
        System.out.println(new BCryptPasswordEncoder().encode("123"));
    }

}
