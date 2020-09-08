package com.huanyue.spaceserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpaceServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpaceServerApplication.class, args);
    }



}
