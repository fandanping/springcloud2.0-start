package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AppConsulMember {
   //启动会员服务
    //@EnableDiscoveryClient:表示如果服务使用consul ,zookeeper ,使用@EnableDiscoveryClient向注册中心注册服务
    public static void main(String [] args){
        SpringApplication.run(AppConsulMember.class,args);
    }
}
