package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AppEureka {
    //浏览器输入http://127.0.0.1:8100/    验证是否注册中心启动成功
    //@EnableEurekaServer:表示开启EurekaServer服务
    public static void main(String[] args){
        SpringApplication.run(AppEureka.class,args);
    }

}
