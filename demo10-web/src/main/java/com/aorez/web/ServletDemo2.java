package com.aorez.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(urlPatterns = "/demo2", loadOnStartup = 1)
public class ServletDemo2 implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        //因为只执行一次，所以输出一次，并且默认是在第一次访问时输出，可以通过修改loadOnStartup修改init时机
        System.out.println("init");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //每次访问都输出
        System.out.println("Hello Servlet Demo2");
    }

    @Override
    public void destroy() {
        //关闭连接时输出
        System.out.println("destroy");
        //直接停止是不会输出的
        //控制台cd到当前目录，手动mvn tomcat7:run，然后Cirl+C
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return null;
    }
}
