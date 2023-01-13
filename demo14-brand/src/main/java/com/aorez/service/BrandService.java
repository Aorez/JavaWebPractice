package com.aorez.service;

import com.aorez.mapper.BrandMapper;
import com.aorez.pojo.Brand;
import com.aorez.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandService {
    private SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public List<Brand> selectAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = brandMapper.selectAll();
        sqlSession.close();

        return brands;
    }

    public int add(Brand brand) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        int rowNum = brandMapper.add(brand);
        sqlSession.commit();
        sqlSession.close();

        return rowNum;
    }

    public Brand selectById(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Brand brand = sqlSession.getMapper(BrandMapper.class).selectById(id);
        sqlSession.close();
        return brand;
    }

    public int update(Brand brand) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        int rowNum = brandMapper.update(brand);
        sqlSession.commit();
        sqlSession.close();

        return rowNum;
    }

    public int deleteById(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        int rowNum = brandMapper.deleteById(id);
        sqlSession.commit();
        sqlSession.close();

        return rowNum;
    }
}
