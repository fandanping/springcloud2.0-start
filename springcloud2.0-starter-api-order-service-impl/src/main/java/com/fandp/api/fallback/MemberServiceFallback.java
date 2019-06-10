package com.fandp.api.fallback;

import com.fandp.api.entity.UserEntity;
import com.fandp.api.feign.MemberServiceFeign;
import com.fandp.base.BaseApiService;
import com.fandp.base.ResponseBase;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceFallback extends BaseApiService implements MemberServiceFeign {

    @Override
    public UserEntity getMember(String name) {
        return null;
    }
    //服务降级友好提示
    @Override
    public ResponseBase getUserInfo() {
        return setResultError("服务器忙，请稍后重试，以类的方式写服务降级");
    }
}
