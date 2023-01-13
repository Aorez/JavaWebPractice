package com.aorez.web.response;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/resp4")
public class ResponseDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        //响应字节数据

        //打开文件
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\on.gif");

        //获取字节输出流
        ServletOutputStream outputStream = resp.getOutputStream();

        //copy
//        byte[] bytes = new byte[1024];
//        int len = 0;
//        while ((len = fileInputStream.read(bytes)) != -1) {
//            outputStream.write(bytes, 0, len);
//        }
        //第二种写法
        //使用io工具类，要导入jar包
        IOUtils.copy(fileInputStream, outputStream);

        //关闭文件
        //流不用关闭
        fileInputStream.close();

    }

}
