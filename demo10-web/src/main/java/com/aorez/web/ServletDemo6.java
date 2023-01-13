package com.aorez.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/demo6")
public class ServletDemo6 extends MyHttpServlet {

    @Override
    protected void doGet(ServletRequest servletRequest, ServletResponse servletResponse) {
        super.doGet(servletRequest, servletResponse);
        System.out.println("demo6 get");
    }

    @Override
    protected void doPost(ServletRequest servletRequest, ServletResponse servletResponse) {
        super.doPost(servletRequest, servletResponse);
        System.out.println("demo6 post");
        //b.html测试
    }
}
