package com.fandp.Filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class TokenFilter extends ZuulFilter {
    //过滤器类型  :"pre"表示在请求之前进行执行
    @Override
    public String filterType() {
        return "pre";
    }
    //过滤器执行顺序：当一个请求在同一个阶段的时候存在多个过滤器的时候，多个过滤器执行顺序
    @Override
    public int filterOrder() {
        return 0;
    }
    //判断过滤器是否生效
    @Override
    public boolean shouldFilter() {
        return true;
    }
    //编写过滤器拦截业务逻辑代码
    @Override
    public Object run() throws ZuulException {
        //案例： 拦截所有的服务接口，判断服务接口是哪个是否有传递usertoken参数
        // 1. 获取上下文
        RequestContext currentContext = RequestContext.getCurrentContext();
        //2. 获取Request
        HttpServletRequest request = currentContext.getRequest();
        // 3. 获取token的时候，从请求头中获取
        String userToken = request.getParameter("userToken");
        if (StringUtils.isEmpty(userToken)) {
            //不会继续往下执行：不会去调用服务接口，网关服务直接响应给客户端
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(401);
            //返回一个错误提示
            currentContext.setResponseBody("userToken is null");
            return null;
        }
        // 否则正常执行业务逻辑.....
        return null;
    }
}
