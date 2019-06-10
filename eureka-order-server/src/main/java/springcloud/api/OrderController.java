package springcloud.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
    //RestTemplate 是有SpringBoot Web组件提供，默认整合ribbon负载均衡器
    //rest方式底层是采用httpclient技术
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/getOrder")
    public String getOrder(){
        //order使用rpc远程调用技术，调用会员服务
        String memberUrl ="http://app-itmayiedu-member/getMember";
        String result = restTemplate.getForObject(memberUrl,String.class);
        //  String result = restTemplate.getForObject("http://127.0.0.1:8000/getMember",String.class);

        System.out.println("订单服务调用会员服务，result:"+result);
        return result;
    }
}
