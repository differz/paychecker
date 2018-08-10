package com.differz.paychecker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        System.out.println(Application.class.getPackage().getName());
        SpringApplication.run(Application.class, args);
    }
}
