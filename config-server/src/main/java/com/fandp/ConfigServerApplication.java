package com.fandp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableConfigServer
@SpringBootApplication
@EnableEurekaClient
public class ConfigServerApplication {
    //@EnableConfigServer：开启config server功能
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
