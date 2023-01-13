package com.aorez.web;

import com.aorez.pojo.Brand;
import com.aorez.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/selectByIdServlet")
public class SelectByIdServlet extends HttpServlet {
    private BrandService brandService = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取传过来的id
        String id = request.getParameter("id");

        //执行查询
        Brand brand = brandService.selectById(Integer.parseInt(id));

        //转发到update.jsp
        request.setAttribute("brand", brand);
        request.getRequestDispatcher("/update.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
