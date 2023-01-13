package com.aorez.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //登录验证

        //要用一些方法，所以需要强转
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        //拦截路径写了"/*"，如果不加以判断，注册也进不去，页面css样式也获取不到，只有一个login.jsp
        //所以要排除掉一些资源路径
        //添加资源路径数组
        String[] urls = {"/login.jsp", "/loginServlet", "/imgs/", "/css/", "/register.jsp", "/registerServlet", "/checkCodeServlet"};
        //获取当前资源路径
        String requestURL = httpServletRequest.getRequestURL().toString();
        //遍历数组进行判断
        for (String url: urls) {
            if (requestURL.contains(url)) {
                //放行
                chain.doFilter(httpServletRequest, response);
                return;
            }
        }

        //因为登录之后保存在了Session对象中，所以可以通过判断Session对象实现过滤
        //获取Session对象中的user
        HttpSession httpSession = httpServletRequest.getSession();
        Object user = httpSession.getAttribute("user");

        //判断user
        if (user != null) {
            chain.doFilter(request, response);
        }
        else {
            request.setAttribute("login_msg", "您尚未登录");
            //用request变量也可以
            request.getRequestDispatcher("/login.jsp").forward(httpServletRequest, response);
        }
    }
}
