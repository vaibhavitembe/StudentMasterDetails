package com.zplus.schoolmaster;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.zplus.schoolmaster")
public class Application {
    public static void main(String args[])
    {

        SpringApplication.run(Application.class,args);

    }

}
