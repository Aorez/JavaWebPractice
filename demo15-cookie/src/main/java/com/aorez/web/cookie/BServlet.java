package com.aorez.web.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

@WebServlet("/bServlet")
public class BServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先访问aServlet，再访问bServlet

        //获取Cookie
        Cookie[] cookies = req.getCookies();

        //遍历Cookie数组
        for (Cookie cookie: cookies) {
            if (cookie.getName().equals("username")) {

                //对应的URL解码
                String valueDecode = URLDecoder.decode(cookie.getValue(), "utf-8");
                System.out.println("接收到的cookie为：" + valueDecode);

//                System.out.println("username: " + cookie.getValue());
                break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        this.doGet(req, resp);
    }
}
