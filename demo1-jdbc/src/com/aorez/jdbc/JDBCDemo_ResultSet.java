package com.aorez.jdbc;

import com.aorez.pojo.ClassN;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo_ResultSet {
    @Test
    public void testResultSet() throws Exception {
        //注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //连接
        //useSSL=false取消SSL警告
        String url = "jdbc:mysql://127.0.0.1:3306/db1?useSSL=false";
        String name = "root";
        String password = "root221899";
        Connection conn = DriverManager.getConnection(url, name, password);

        //查询
        String sql = "select * from tab1;";
        Statement stat = conn.createStatement();
        ResultSet resultSet = stat.executeQuery(sql);

        //解析ResultSet
        while (resultSet.next()) {
            String n1 = resultSet.getString(1);
            System.out.println(n1);
            String n2 = resultSet.getString("n");
            System.out.println(n2);
        }

        //释放资源
        resultSet.close();
        stat.close();
        conn.close();
    }

    @Test
    public void testResultSet2() throws Exception {
        //注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //连接
        //useSSL=false取消SSL警告
        String url = "jdbc:mysql://127.0.0.1:3306/db1?useSSL=false";
        String name = "root";
        String password = "root221899";
        Connection conn = DriverManager.getConnection(url, name, password);

        //查询
        String sql = "select * from tab1;";
        Statement stat = conn.createStatement();
        ResultSet resultSet = stat.executeQuery(sql);

        List list = new ArrayList<ClassN>();

        //解析ResultSet
        while (resultSet.next()) {
            String n1 = resultSet.getString(1);
            String n2 = resultSet.getString("n");
            ClassN classN = new ClassN();
            classN.setN(n1);
            list.add(classN);
        }

        System.out.println(list);

        //释放资源
        resultSet.close();
        stat.close();
        conn.close();
    }
}
