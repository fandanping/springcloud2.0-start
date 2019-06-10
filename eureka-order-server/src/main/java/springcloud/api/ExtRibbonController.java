package springcloud.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ExtRibbonController {
    //可以获取注册中心上的服务列表
    @Autowired
    private DiscoveryClient discoveryClient;
    //接口的请求总数
    private int reqCount;
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/ribbonMember")
    public String ribbonMember(){
        //1. 获取对应服务器远程调用地址
        String instancesUrl = getInstances()+ "/getMember";
        System.out.println("instancesUrl:"+ instancesUrl);
        // 2.远程调用
        String result = restTemplate.getForObject(instancesUrl,String.class);
        return  result;
    }
    private synchronized String getInstances(){
        //获取对应服务器远程调用地址
        List<ServiceInstance> instances = discoveryClient.getInstances("app-itmayiedu-member");
        if(instances == null || instances.size() <=0 ){
            return  null;
        }
        //获取服务器集群个数
        int intstanceSize = instances.size();
        int serviceIndex = reqCount % intstanceSize;
        reqCount++;
        return  instances.get(serviceIndex).getUri().toString();
    }
}
