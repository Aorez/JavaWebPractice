package com.aorez.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

//req2.html
@WebServlet("/req2")
public class RequestDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
//        System.out.println("RequestDemo2 doGet ...");

        //获取所有参数的Map集合
        System.out.println("getParameterMap...");
        Map<String, String[]> parameterMap = req.getParameterMap();
        for (String key: parameterMap.keySet()) {
            System.out.print(key + ": ");

            String[] values = parameterMap.get(key);
            for (String value: values) {
                System.out.print(value + " ");
            }
            System.out.println("");
        }

        //根据参数名获取参数数组
        System.out.println("getParameterValues...");
        String[] hobbies = req.getParameterValues("hobby");
        System.out.print("hobby: ");
        for (String hobby: hobbies) {
            System.out.println(hobby + " ");
        }
        System.out.println("");

        //根据参数名获取单个参数
        System.out.println("getParameter...");
        String username = req.getParameter("username");
        System.out.println("username: " + username);
    }

    //get和post两种方式都适用这些函数
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        this.doGet(req, resp);
//        System.out.println("RequestDemo2 doPost ...");
//
//        //获取所有参数的Map集合
//        System.out.println("getParameterMap...");
//        Map<String, String[]> parameterMap = req.getParameterMap();
//        for (String key: parameterMap.keySet()) {
//            System.out.print(key + ": ");
//
//            String[] values = parameterMap.get(key);
//            for (String value: values) {
//                System.out.print(value + " ");
//            }
//            System.out.println("");
//        }
//
//        //根据参数名获取参数数组
//        System.out.println("getParameterValues...");
//        String[] hobbies = req.getParameterValues("hobby");
//        System.out.print("hobby: ");
//        for (String hobby: hobbies) {
//            System.out.print(hobby + " ");
//        }
//        System.out.println("");
//
//        //根据参数名获取单个参数
//        System.out.println("getParameter...");
//        String username = req.getParameter("username");
//        System.out.println("username: " + username);
    }
}
