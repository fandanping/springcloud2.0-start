package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class AppZKOrder {
    //启动消费者服务
    //如果使用rest方式以别名方式进行调用需要依赖ribbon负载均衡器
    //    @LoadBalanced: 就支持以别名进行服务调用
    public static void main(String[] args){
        SpringApplication.run(AppZKOrder.class,args);
    }

    //解决RestTemplate模板找不到原因，应该把restTemplate注册到SpringBoot容器中
    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        //@LoadBalanced 就能让这个RestTemplate在请求时拥有客户端负载均衡的能力
        return new RestTemplate();
    }
}
