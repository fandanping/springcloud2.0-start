package com.fandp.api.feign;

import com.fandp.api.fallback.MemberServiceFallback;
import com.fandp.api.service.IMemberService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "app-itmayiedu-member",fallback = MemberServiceFallback.class)
public interface MemberServiceFeign  extends IMemberService {

}
