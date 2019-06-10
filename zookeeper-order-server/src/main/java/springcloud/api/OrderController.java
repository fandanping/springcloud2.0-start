package springcloud.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {
    //RestTemplate 是有SpringBoot Web组件提供，默认整合ribbon负载均衡器
    //rest方式底层是采用httpclient技术
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/getOrder")
    public String getOrder(){
        //order使用rpc远程调用技术，调用会员服务
        String memberUrl ="http://zk-member/getZKMember";
        String result = restTemplate.getForObject(memberUrl,String.class);
        //  String result = restTemplate.getForObject("http://127.0.0.1:8000/getMember",String.class);

        System.out.println("订单服务调用会员服务，result:"+result);
        return result;
    }
    @RequestMapping("/getServiceUrl")
    public List<String> getServiceUrl() {
        List<ServiceInstance> list = discoveryClient.getInstances("zk-member");
        List<String> services = new ArrayList<>();
        for (ServiceInstance serviceInstance : list) {
            if (serviceInstance != null) {
                System.out.println(serviceInstance.getUri().toString());
                services.add(serviceInstance.getUri().toString());
            }
        }
        return services;
    }
}
