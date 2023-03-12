package com.yoyoping.admin;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhangzheng on 12/3/2023
 */
@SpringBootApplication(scanBasePackages=("com.yoyoping.admin"))
public class YoYoPingMallApplication {

    public static void main(String[] args) {
        SpringApplication.run(YoYoPingMallApplication.class, args);
    }

}