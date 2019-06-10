package com.fandp.api.service;

import com.fandp.base.ResponseBase;
import org.springframework.web.bind.annotation.RequestMapping;

public interface IOrderService {
    //订单服务调用会员服务接口信息 feign
    @RequestMapping("orderToMember")
    public String orderToMember(String name);
    //订单服务接口调用会员服务接口
    @RequestMapping("orderToMemberUserInfo")
    public ResponseBase orderToMemberUserInfo();
    //
    @RequestMapping("orderInfo")
    public ResponseBase orderInfo();

}
