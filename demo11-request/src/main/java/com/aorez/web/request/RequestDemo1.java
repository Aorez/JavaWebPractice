package com.aorez.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/req1")
public class RequestDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        //获取访问方式GET
        String method = req.getMethod();
        System.out.println(method);

        //获取虚拟目录（项目路径），/request-demo
        String contextPath = req.getContextPath();
        System.out.println(contextPath);

        //完整url（统一资源定位符），http://localhost:8080/request-demo/req1
        StringBuffer requestURL = req.getRequestURL();
        System.out.println(requestURL);

        //统一资源标识符，/request-demo/req1
        String requestURI = req.getRequestURI();
        System.out.println(requestURI);

        //获取请求参数
        String queryString = req.getQueryString();
        System.out.println(queryString);

        //获取请求头
        String header = req.getHeader("user-agent");
        System.out.println(header);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        //获取post请求体
        //先写req.html页面
        BufferedReader reader = req.getReader();
        String line = reader.readLine();
        //输出text1=haha1&text2=haha2
        System.out.println(line);
    }
}
