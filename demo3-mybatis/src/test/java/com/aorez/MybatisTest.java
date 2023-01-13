package com.aorez;

import com.aorez.mapper.BrandMapper;
import com.aorez.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisTest {
    @Test
    public void testSelectAll() throws Exception {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        List<Brand> brands = brandMapper.selectAll();

        System.out.println(brands);

        sqlSession.close();
    }

    @Test
    public void testSelectById() throws Exception {
        int id = 1;

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        Brand brand = brandMapper.selectById(id);

        System.out.println(brand);

        sqlSession.close();
    }

    @Test
    public void testSelectByCondition2() throws Exception {
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        List<Brand> brands = brandMapper.selectByCondition2(brand);

        System.out.println(brands);

        sqlSession.close();
    }

    @Test
    public void testSelectByCondition3() throws Exception {
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        Map map = new HashMap();
        map.put("status", status);
        map.put("companyName", companyName);
        map.put("brandName", brandName);
        List<Brand> brands = brandMapper.selectByCondition3(map);

        System.out.println(brands);

        sqlSession.close();
    }

    @Test
    public void testSelectByCondition1() throws Exception {
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        List<Brand> brands = brandMapper.selectByCondition1(status, companyName, brandName);

        System.out.println(brands);

        sqlSession.close();
    }

    @Test
    public void testSelectByCondition6() throws Exception {
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        List<Brand> brands = brandMapper.selectByCondition1(status, companyName, brandName);

        System.out.println(brands);

        sqlSession.close();
    }

    @Test
    public void testSelectByCondition4() throws Exception {
        //设置某个参数为空
        int status = 1;
        String companyName = "";
        String brandName = "华为";

        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        Map map = new HashMap();
        map.put("status", status);
        map.put("companyName", companyName);
        map.put("brandName", brandName);
        List<Brand> brands = brandMapper.selectByCondition4(map);

        System.out.println(brands);

        sqlSession.close();
    }

    @Test
    public void testSelectByCondition5() throws Exception {
        //设置某个参数为空
        int status = 1;
        String companyName = "";
        String brandName = "华为";

        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //如果没有传入参数或者传入空值，对应的sql语句缺失，会造成sql出错，原因是多了个and
        //解决方法是在Mapper的xml中加入“true”或者where标签
        Map map = new HashMap();
//        map.put("status", status);
        map.put("status", null);
        map.put("companyName", companyName);
        map.put("brandName", brandName);
        List<Brand> brands = brandMapper.selectByCondition5(map);

        System.out.println(brands);

        sqlSession.close();
    }

    @Test
    public void testSelectByConditionSingle() throws Exception {
        //如果有可能三个都是null，sql会出错，解决方法是where标签或者otherwise标签写恒等式
        Integer status = null;
        String companyName = "华为";
        String brandName = null;

        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        List<Brand> brands = brandMapper.selectByConditionSingle(brand);

        System.out.println(brands);

        sqlSession.close();
    }

    @Test
    public void testAdd() throws Exception {
        int status = 1;
        String companyName = "波导手机";
        String brandName = "波导";
        String description = "手机中的战斗机";
        int ordered = 100;

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));

        SqlSession sqlSession = sqlSessionFactory.openSession();
        //设置自动提交
//        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);
        brandMapper.add(brand);

        //获取id，直接获取是获取不到的，因为id是数据库自动自增添加的字段
        System.out.println(brand.getId());

        //没有提交，mybatis会自动rollback
//        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void testUpdate() throws Exception {
        int id = 4;
        int status = 1;
        String companyName = "波导手机";
        String brandName = "波导";
        String description = "波导手机，手机中的战斗机";
        int ordered = 200;

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        Brand brand = new Brand();
        brand.setId(id);
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);
        int updateRows = brandMapper.update(brand);

        System.out.println(updateRows);
//        sqlSession.commit();
        System.out.println(updateRows);

        sqlSession.close();
    }

    @Test
    public void testUpdateDynamically() throws Exception {
        int id = 4;
        int status = 0;
        //不修改null的字段
        String companyName = null;
        String brandName = null;
        String description = null;
        int ordered = 200;

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        Brand brand = new Brand();
        brand.setId(id);
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);
        int updateRows = brandMapper.updateDynamically(brand);

        System.out.println(updateRows);
//        sqlSession.commit();
        System.out.println(updateRows);

        sqlSession.close();
    }

    @Test
    public void testDeleteById() throws Exception {
        int id = 13;

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        int deleteRows = brandMapper.deleteById(id);

        System.out.println(deleteRows);
//        sqlSession.commit();
        System.out.println(deleteRows);

        sqlSession.close();
    }

    @Test
    public void testDeleteByIds() throws Exception {
        int[] ids = {8, 10};

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        int deleteRows = brandMapper.deleteByIds(ids);

        System.out.println(deleteRows);
//        sqlSession.commit();
        System.out.println(deleteRows);

        sqlSession.close();
    }

    @Test
    public void testDeleteByIds2() throws Exception {
        int[] ids = {8, 10};

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        int deleteRows = brandMapper.deleteByIds2(ids);

        System.out.println(deleteRows);
//        sqlSession.commit();
        System.out.println(deleteRows);

        sqlSession.close();
    }

    @Test
    public void testDeleteByIds3() throws Exception {
        int[] ids = {8, 10};

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        Map map = new HashMap();
        map.put("idsMap", ids);
        int deleteRows = brandMapper.deleteByIds3(map);

        System.out.println(deleteRows);
//        sqlSession.commit();
        System.out.println(deleteRows);

        sqlSession.close();
    }

    @Test
    public void testDeleteById2() throws Exception {
        int id = 4;

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        int deleteRows = brandMapper.deleteById2(id);

        System.out.println(deleteRows);
//        sqlSession.commit();
        System.out.println(deleteRows);

        sqlSession.close();
    }

    @Test
    public void testSelectById2() throws Exception {
        int id = 4;

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //用Map进行参数传递，Map中value为Brand对象，该对象的id才是真正的参数
        Map map = new HashMap();
        Brand brand = new Brand();
        brand.setId(id);
        map.put("param", brand);
        Brand brandResult = brandMapper.selectById2(map);

        System.out.println(brandResult);

        sqlSession.close();
    }

}