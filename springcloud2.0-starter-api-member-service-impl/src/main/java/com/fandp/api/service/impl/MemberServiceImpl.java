package com.fandp.api.service.impl;

import com.fandp.api.entity.UserEntity;
import com.fandp.api.service.IMemberService;
import com.fandp.base.BaseApiService;
import com.fandp.base.ResponseBase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberServiceImpl extends BaseApiService implements IMemberService {
    @Value("${server.port}")
    private String serverPort;
    @Override
    @RequestMapping("/getMember")
    public UserEntity getMember(@RequestParam("name") String name) {
        UserEntity user =new UserEntity();
        user.setAge(26);
        user.setName(name+"端口号："+ serverPort);
        return user;
    }

    @Override
    @RequestMapping("/getUserInfo")
    public ResponseBase getUserInfo() {
        try {
            //会员服务产生1.5s延迟
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return setResultSuccess("订单服务接口调用会员服务接口成功");
    }
}
