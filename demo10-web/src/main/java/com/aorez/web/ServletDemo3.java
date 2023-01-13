package com.aorez.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(urlPatterns = "/demo3")
public class ServletDemo3 implements Servlet {
    private ServletConfig servletConfig;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init");
        this.servletConfig = servletConfig;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //每次访问都输出
        System.out.println("Hello Servlet Demo3");
    }

    @Override
    public void destroy() {
        //关闭连接时输出
        System.out.println("destroy");
        //直接停止是不会输出的
        //控制台cd到当前目录，手动mvn tomcat7:run，然后Cirl+C
    }

    //init方法已经有了ServletConfig对象，可以直接用
    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    //该方法的作用是返回author、version、copyright等信息
    @Override
    public String getServletInfo() {
        return "";
    }
}
