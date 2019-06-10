package com.fandp.api.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class FeignController {
    @Autowired
    private MemberApiFeignConsul memberApiFeign;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/feignmember")
    public String feignMember(){
         return memberApiFeign.feignmember();
    }
    @RequestMapping("/test")
    public String test(){
        return "200";
    }

    // 订单服务调用会员服务
    @RequestMapping("/getOrder")
    public String getOrder() {
        // 有两种方式，一种是采用服务别名方式调用，另一种是直接调用 使用别名去注册中心上获取对应的服务调用地址
        String serviceUrl = getServiceUrl("consul-member-server") + "/feignmember";
        String result = restTemplate.getForObject(serviceUrl, String.class);
        System.out.println("订单服务调用会员服务result:" + result);
        return result;
    }

    public String getServiceUrl(String name) {
        List<ServiceInstance> list = discoveryClient.getInstances(name);
        if (list != null && !list.isEmpty()) {
            return list.get(0).getUri().toString();
        }
        return null;
    }
}
