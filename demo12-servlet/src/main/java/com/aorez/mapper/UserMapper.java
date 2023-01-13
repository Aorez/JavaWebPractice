package com.aorez.mapper;

import com.aorez.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select * from tb_user2 where username=#{username} and password=#{password}")
    public User select(@Param("username") String username, @Param("password") String password);

    @Select("select * from tb_user2 where username=#{username}")
    User selectByUsername(String username);

    @Insert("insert into tb_user2 values(null,#{username},#{password})")
    int add(User user);
}
