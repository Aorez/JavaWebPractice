package com.aorez.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//任意匹配
//"/*"优先级高于"/"
//"/*"和"/"会覆盖掉Tomcat的默认配置，在安装目录/conf/web.xml中
//Tomcat默认"/"为访问静态资源的路径，添加这种路径后，访问静态资源如a.html等等，会跑到这里来
//任意匹配和其他匹配的优先级规则有点奇怪
@WebServlet("/*")
public class ServletDemo12 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        System.out.println("demo12 GET 任意匹配 /* ...");
    }
}
