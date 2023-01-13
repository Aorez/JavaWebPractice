package com.itheima.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.itheima.pojo.Brand;
import com.itheima.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
    private BrandService brandService = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //先测试
        //接收ajax请求
//        String brandName = request.getParameter("brandName");
//        System.out.println(testData);
        //因为Request的getParameter方法获取的是“&”符号隔开的数据，而json数据是字典格式，所以获取不了json数据
        //要直接取整个请求体

        BufferedReader bufferedReader = request.getReader();
        String jsonLine = bufferedReader.readLine();
        //json转java对象
        Brand brand = JSON.parseObject(jsonLine, Brand.class);

        brandService.add(brand);

        //发送响应信息
        response.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
