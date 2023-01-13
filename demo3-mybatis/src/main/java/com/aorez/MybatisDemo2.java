package com.aorez;

import com.aorez.mapper.UserMapper;
import com.aorez.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisDemo2 {
    public static void main(String[] args) throws Exception {
        //加载配置文件
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));

        //获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //Mapper接口对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //执行SQL
        List<User> list = userMapper.selectAll();
        System.out.println(list);

        sqlSession.close();
    }
}

