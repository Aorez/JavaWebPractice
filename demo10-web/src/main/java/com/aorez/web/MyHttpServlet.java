package com.aorez.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class MyHttpServlet implements Servlet {

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String method = httpServletRequest.getMethod();
        if ("GET".equals(method)) {
            doGet(servletRequest, servletResponse);
        }
        else if ("POST".equals(method)) {
            doPost(servletRequest, servletResponse);
        }
    }

    protected void doGet(ServletRequest servletRequest, ServletResponse servletResponse) {
        System.out.println("MyHttpServlet get");
    }

    protected void doPost(ServletRequest servletRequest, ServletResponse servletResponse) {
        System.out.println("MyHttpServlet post");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
