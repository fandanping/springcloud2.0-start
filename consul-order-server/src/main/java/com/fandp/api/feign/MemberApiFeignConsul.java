package com.fandp.api.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "consul-member-server")
public interface MemberApiFeignConsul {
    //Feign书写方式：是以Spring mVC接口形式书写
    //FeignClient调用服务接口name就是服务名称
    @RequestMapping("/feignmember")
    public String feignmember();

}
