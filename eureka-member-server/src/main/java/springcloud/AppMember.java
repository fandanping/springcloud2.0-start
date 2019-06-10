package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AppMember {
   //启动会员服务
    //@EnableEurekaClient:表示将当前服务注册到eureka上
    public static void main(String [] args){
        SpringApplication.run(AppMember.class,args);
    }
}
