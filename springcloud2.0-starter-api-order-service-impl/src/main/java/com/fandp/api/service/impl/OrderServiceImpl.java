package com.fandp.api.service.impl;

import com.fandp.api.entity.UserEntity;
import com.fandp.api.feign.MemberServiceFeign;
import com.fandp.api.service.IOrderService;
import com.fandp.base.BaseApiService;
import com.fandp.base.ResponseBase;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderServiceImpl  extends BaseApiService implements IOrderService{
    @Autowired
    private MemberServiceFeign memberServiceFeign;

    @Override
    @RequestMapping("/orderToMember")
    public String orderToMember(String name) {
        UserEntity user = memberServiceFeign.getMember(name);
        return user == null ? "没有找到用户信息":user.toString();
    }
    //是没有解决服务雪崩效应的
    @Override
    @RequestMapping("/orderToMemberUserInfo")
    public ResponseBase orderToMemberUserInfo() {
        //业务逻辑代码......
        return  memberServiceFeign.getUserInfo();
    }

    //解决服务雪崩效应的
    //@HystrixCommand默认开启线程池隔离方式（是以线程池方式） 服务降级 服务熔断
    //设置Hystrix超时时间：默认1s （如果调用其他接口超时的时候，如果在一秒内没有及时响应，默认情况下业务逻辑是可以执行的，但是直接执行服务降级）
    //fallbackMethod方法的作用：服务降级执行
    @HystrixCommand(fallbackMethod = "orderToMemberUserInfoHystrixFallback")
    @RequestMapping("/orderToMemberUserInfoHystrix")
    public ResponseBase orderToMemberUserInfoHystrix() {
        System.out.println("orderToMemberUserInfoHystrix:" + "线程池名称:" + Thread.currentThread().getName());
        return memberServiceFeign.getUserInfo();
    }

    public ResponseBase orderToMemberUserInfoHystrixFallback() {
        return setResultSuccess("返回一个友好的提示：服务降级,服务器忙，请稍后重试!");
    }
     //Hystrix第二种写法:使用类方式
     @RequestMapping("/orderToMemberUserInfoHystrix_demo02")
     public ResponseBase orderToMemberUserInfoHystrixDemo02() {
         System.out.println("orderToMemberUserInfoHystrix:" + "线程池名称:" + Thread.currentThread().getName());
         return memberServiceFeign.getUserInfo();
     }

    // 订单服务接口
    @RequestMapping("/orderInfo")
    public ResponseBase orderInfo() {
        System.out.println("orderInfo:" + "线程池名称:" + Thread.currentThread().getName());
        return setResultSuccess();
    }


}
