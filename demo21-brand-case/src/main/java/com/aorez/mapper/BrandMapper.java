package com.aorez.mapper;

import com.aorez.pojo.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BrandMapper {
    @Select("select * from tab_brand")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();

    @Insert("insert into tab_brand values(null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    void add(Brand brand);

    @Delete("delete from tab_brand where id=#{id}")
    void deleteById(int id);

    void deleteByIds(@Param("ids") int[] ids);

    //分页查询
    @Select("select * from tab_brand limit #{begin},#{size}")
    @ResultMap("brandResultMap")
    List<Brand> selectByPage(@Param("begin") int begin, @Param("size") int size);
    @Select("select count(*) from tab_brand")
    int selectTotalCount();

    //分页条件查询
    List<Brand> selectByPageAndCondition(@Param("begin") int begin, @Param("size") int size, @Param("brand") Brand brand);
    int selectTotalCountByCondition(Brand brand);
}
