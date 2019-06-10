package springcloud.api.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {
    @Autowired
    private MemberApiFeign memberApiFeign;
    @RequestMapping("feignMember")
    public String feignMember(){
         return memberApiFeign.getMember();
    }
}
