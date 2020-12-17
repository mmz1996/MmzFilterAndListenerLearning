package com.mmz.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Classname CharacterEncodingFilter
 * @Description TODO
 * @Date 2020/12/17 15:07
 * @Created by mmz
 */
public class CharacterEncodingFilter implements Filter {
    // 初始化
    // web服务器启动，filter就开始初始化了，随时等过滤对象出现
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("开始初始化");
    }

    // Chain
    /*
    * 1.过滤中的所有代码，在过滤特定请求的时候都会执行
    * 2.必须要让过滤器继续通行，
    * */
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=UTF-8");

        System.out.println("characterEncoding执行前...");

        filterChain.doFilter(servletRequest,servletResponse); // 让我们的请求继续往下走，如果不写，程序到这里就被拦截停止了


        System.out.println("characterEncoding执行后...");
    }

    // 销毁
    // web服务器停止，过滤器会销毁
    public void destroy() {
        System.out.println("已经销毁");
    }
}
