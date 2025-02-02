package com.fandp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class AppConsulOrderFeign {

    //@EnableFeignClients：可以开启feign客户端权限
    public static void main(String[] args){
        SpringApplication.run(AppConsulOrderFeign.class,args);
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }


}
