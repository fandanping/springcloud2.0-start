package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class AppOrderFeign {

    //@EnableFeignClients：可以开启feign客户端权限
    public static void main(String[] args){
        SpringApplication.run(AppOrderFeign.class,args);
    }

}
