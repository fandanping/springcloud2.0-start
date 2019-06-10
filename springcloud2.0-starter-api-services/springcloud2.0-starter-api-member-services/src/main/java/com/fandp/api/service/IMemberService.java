package com.fandp.api.service;

import com.fandp.api.entity.UserEntity;
import com.fandp.base.ResponseBase;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface IMemberService {
    //实体类存放在接口项目里
    //实体类和定义接口信息存放在接口项目
    //代码实现存放在接口实现类里面
    @RequestMapping("/getMember")
    public UserEntity getMember(@RequestParam("name") String name);

    @RequestMapping("getUserInfo")
    public ResponseBase getUserInfo();



}
