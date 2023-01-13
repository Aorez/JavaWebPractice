package com.aorez.web;

import com.aorez.pojo.User;
import com.aorez.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //校验验证码
        //验证码由register.jsp的request传来
        String checkCodeInput = request.getParameter("checkCode");
        //正确的验证码保存在Session对象的checkCodeGen键值对中
        HttpSession session = request.getSession();
        String checkCodeCorrect = (String) session.getAttribute("checkCodeGen");

        if (!checkCodeCorrect.equals(checkCodeInput)) {
            //验证码不正确
            request.setAttribute("register_msg", "验证码不正确");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        }

        //Service查询
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        boolean b = userService.register(user);

        //判断
        if (b) {
            request.setAttribute("register_msg", "注册成功，请登录");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
        else {
            request.setAttribute("register_msg", "用户名已存在");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
