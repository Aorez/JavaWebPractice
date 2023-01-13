package com.aorez.web.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/resp1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        System.out.println("ResponseDemo1...");

        //重定向到resp2
//        resp.setStatus(302);
//        resp.setHeader("location", "/request-demo/resp2");

        String contextPath = req.getContextPath();
        //第二种写法
        resp.sendRedirect(contextPath + "/resp2");

        //重定向到百度
//        resp.sendRedirect("https://www.baidu.com");
    }

}
