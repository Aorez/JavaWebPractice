package com.aorez;

import com.aorez.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class MybatisDemo {
    public static void main(String[] args) throws Exception {
        //加载xml配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //sql语句
        List<User> list = sqlSession.selectList("test.selectAll");
        System.out.println(list);

        sqlSession.close();
    }
}
