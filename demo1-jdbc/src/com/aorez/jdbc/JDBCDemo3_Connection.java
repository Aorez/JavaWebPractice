package com.aorez.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo3_Connection {
    public static void main(String[] args) throws Exception {
        //注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //连接
        //useSSL=false取消SSL警告
        String url = "jdbc:mysql://127.0.0.1:3306/db1?useSSL=false";
        String name = "root";
        String password = "root221899";
        Connection conn = DriverManager.getConnection(url, name, password);

        String sql1 = "update tab1 set n = 'haha3'";
        String sql2 = "update  tab1 set n='hahaha3' where n='haha3'";
        Statement stat = conn.createStatement();

        try {
            //开启事务
            conn.setAutoCommit(false);

            //执行查询
            int count1 = stat.executeUpdate(sql1);
            System.out.println(count1);

            //造一个异常
//            int n = 1/0;

            int count2 = stat.executeUpdate(sql2);
            System.out.println(count2);

            //提交事务
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            e.printStackTrace();
        }

        //释放资源
        stat.close();
        conn.close();
    }
}
