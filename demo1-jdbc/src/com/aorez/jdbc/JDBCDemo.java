package com.aorez.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCDemo {
    public static void main(String[] args) throws Exception {
        //注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //连接
        //useSSL=false取消SSL警告
        String url = "jdbc:mysql://127.0.0.1:3306/db1?useSSL=false";
        String name = "root";
        String password = "root221899";
        Connection conn = DriverManager.getConnection(url, name, password);

        //查询
        String sql = "update tab1 set n = 'hahaha'";
        Statement stat = conn.createStatement();
        int count = stat.executeUpdate(sql);
        System.out.println(count);

        //释放资源
        stat.close();
        conn.close();
    }
}
