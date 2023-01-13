package com.aorez.web.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/aServlet")
public class AServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //访问aServlet，在浏览器设置中可以查看Cookie

        //创建cookie
//        Cookie cookie = new Cookie("username", "zhang");

        //直接加中文会报错500
//        Cookie cookie = new Cookie("username", "张");
        //可以用URL编码
        String username = "张";
        String cookieEncode = URLEncoder.encode(username, "utf-8");
        Cookie cookie = new Cookie("username", cookieEncode);
        System.out.println("发送的cookie为：" + cookieEncode);

        //设置cookie存活时间，七天
        //也可以通过浏览器cookie设置看到
        cookie.setMaxAge(60*60*24*7);

        //发送cookie
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        this.doGet(req, resp);
    }
}
