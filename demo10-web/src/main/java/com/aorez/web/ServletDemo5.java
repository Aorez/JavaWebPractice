package com.aorez.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebServlet("/demo5")
public class ServletDemo5 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //转为http的
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        //获取请求方式
        String method = httpServletRequest.getMethod();

        //分别处理
        if ("GET".equals(method)) {
            //浏览器get访问时输出
            System.out.println("demo5 get");
        }
        else if ("POST".equals(method)) {
            System.out.println("demo5 post");
        }
        //每次都写这些很麻烦，所以有了HttpServlet，简单模仿，MyHttpServlet
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
