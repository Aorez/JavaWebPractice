package com.aorez.service;

import com.aorez.pojo.Brand;
import com.aorez.pojo.PageBean;

import java.util.List;

public interface BrandService {
    List<Brand> selectAll();

    void add(Brand brand);

    void deleteById(int id);

    void deleteByIds(int[] ids);

    //分页查询
    PageBean<Brand> selectByPage(int currentPage, int pageSize);

    //分页条件查询
    PageBean<Brand> selectByPageAndCondition(int currentPage, int pageSize, Brand brand);
}
