package com.aorez.web;

import com.aorez.pojo.User;
import com.aorez.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //记住密码的复选框
        String remember = request.getParameter("remember");

        //Service查询
        User user = userService.login(username, password);

        //判断
        if (user != null) {
            //重定向的url会变，转发的url不变，还是这个loginServlet
            //为了使用cookie和session，才用了重定向
            //如果用转发，SelectAllServlet也要修改
            //所以这是在三个地方进行数据共享，即loginServlet，selectAllServlet，brand.jsp

            //设置Session
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            //设置Cookie，实现记住密码
            //把"1"写在前面可以防止空指针异常
            if ("1".equals(remember)) {
                Cookie usernameCookie = new Cookie("username", username);
                Cookie passwordCookie = new Cookie("password", password);
                usernameCookie.setMaxAge(60*60*24*7);
                passwordCookie.setMaxAge(60*60*24*7);
                response.addCookie(usernameCookie);
                response.addCookie(passwordCookie);
            }

            //动态获取虚拟目录
            String contextPath = request.getContextPath();

            response.sendRedirect(contextPath + "/selectAllServlet");
        }
        else {
            //设置登录失败的信息
            request.setAttribute("login_msg", "用户名或密码错误");

            //跳转到login.jsp
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
