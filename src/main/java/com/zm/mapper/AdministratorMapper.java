package com.zm.mapper;

import com.zm.pojo.Administrator;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface AdministratorMapper {


    //用户登录
    @Select("select * from ssm.administrator where name = #{name} and password = #{password}")
    Administrator login(@Param("name") String name,@Param("password") String password);
}
