package com.exam.shiro;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:
 * @author: hwx
 * @date: 2022/05/23
 **/
@Order(1)
//如果我们有多个过滤器，那这个Order就可以指定优先级
@Component
//这里可以使用@Compent，也可以不加这个@Component，而是在@SpringBootApplication入口类上新增注解@ServletComponentScan。@Component也可以替换成@Configration
@WebFilter(urlPatterns = "/*",filterName = "myFilter")
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("我是过滤器的初始化方法init");
    }

    @Override
    public void doFilter(ServletRequest var1, ServletResponse var2, FilterChain var3) throws IOException, ServletException {
        System.out.println("我是过滤器的真正的执行方法doFilter，serverlet的请求，you are wanted one");
        HttpServletResponse httpServletResponse=(HttpServletResponse)var2;
        //允许的请求头字段
        httpServletResponse.setHeader("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept");
        //是否允许后续请求携带认证信息（cookies）,该值只能是true,否则不返回
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
        //指定允许其他域名访问
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:8070");
        //参数 chain 为代表当前 Filter 链的对象。
        var3.doFilter(var1,httpServletResponse);
        System.out.println("我是过滤器的真正的执行方法doFilter，serverlet的请求，you are wanted two");
    }

    @Override
    public  void destroy() {
        System.out.println("不行了，我要被销毁了");
    }
}