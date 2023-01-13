package com.aorez.mapper;


import com.aorez.pojo.Brand;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    public List<Brand> selectAll();

    //默认public
    Brand selectById(int id);

    public List<Brand> selectByCondition1(
            @Param("status") int status,
            @Param("companyName") String companyName,
            @Param("brandName") String brandName
    );

    public List<Brand> selectByCondition6(
            int status,
            String companyName,
            String brandName
    );

    public List<Brand> selectByCondition2(Brand brand);

    List<Brand> selectByCondition3(Map map);

    List<Brand> selectByCondition4(Map map);

    List<Brand> selectByCondition5(Map map);

    List<Brand> selectByConditionSingle(Brand brand);

    void add(Brand brand);

    int update(Brand brand);

    int updateDynamically(Brand brand);

    int deleteById(int id);

    int deleteByIds(int[] ids);

    int deleteByIds2(@Param("idsParam")int[] ids);
    int deleteByIds3(Map ids);

    @Delete("delete from tb_brand where id=#{id}")
    int deleteById2(int id);

    Brand selectById2(Map map);
}
