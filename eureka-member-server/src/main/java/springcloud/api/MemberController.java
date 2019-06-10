package springcloud.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
    @Value("${server.port}")
    private String serverPort;
    //服务接口
    @RequestMapping("/getMember")
    public String getMember(){
        return "this is getMember"+serverPort;
    }
}
