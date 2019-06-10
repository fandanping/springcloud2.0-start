package com.fandp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;

@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
public class AppGateway {
     //@EnableZuulProxy:开启网关代理
    //http://127.0.0.1/api-order/orderToMember验证
    //加入过滤器之后 请求：  http://127.0.0.1/api-order/orderToMember?userToken=111   验证
    //  网关也可以实现负载均衡轮询效果

    public static void main(String[] args){
        SpringApplication.run(AppGateway.class,args);
    }

    // zuul配置能够使用config实现实时更新
    @RefreshScope
    @ConfigurationProperties("zuul")
    public ZuulProperties zuulProperties() {
        return new ZuulProperties();
    }
}
