package com.fandp.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class IndexController {
    @Value("${fandpInfo}")
    private String info;

    @RequestMapping("/info")
    private String getinfo() {
        return info;
    }

}