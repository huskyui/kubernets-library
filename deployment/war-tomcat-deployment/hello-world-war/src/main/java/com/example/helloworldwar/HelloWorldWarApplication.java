package com.example.helloworldwar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloWorldWarApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloWorldWarApplication.class, args);
    }

    @RequestMapping("")
    public String hello(){
        return "hello,world! this is a simple war";
    }

}
