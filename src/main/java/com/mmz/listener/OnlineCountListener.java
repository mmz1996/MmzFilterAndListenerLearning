package com.mmz.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @Classname OnlineCountListener
 * @Description TODO
 * @Date 2020/12/17 15:33
 * @Created by mmz
 */
// 统计网站在线人数监听 统计session
public class OnlineCountListener implements HttpSessionListener {
    // 创建session监听
    // 一旦创建一个session，就会触发一个事件
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        ServletContext servletContext = httpSessionEvent.getSession().getServletContext();
        Integer onlineCount =(Integer) servletContext.getAttribute("OnlineCount");

        if(onlineCount == null){
            onlineCount = new Integer(1);
        }else{
            int count = onlineCount.intValue();
            onlineCount = new Integer(count+1);
        }

        servletContext.setAttribute("OnlineCount",onlineCount);
    }

    // 销毁session监听
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        ServletContext servletContext = httpSessionEvent.getSession().getServletContext();
        Integer onlineCount =(Integer) servletContext.getAttribute("OnlineCount");

        if(onlineCount == null){
            onlineCount = new Integer(0);
        }else{
            int count = onlineCount.intValue();
            onlineCount = new Integer(count-1);
        }

        servletContext.setAttribute("OnlineCount",onlineCount);
    }
}
