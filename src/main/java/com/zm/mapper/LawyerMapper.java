package com.zm.mapper;

import com.zm.pojo.Delegator;
import com.zm.pojo.Lawyer;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface LawyerMapper {


    //查
    @Select("select * from ssm.lawyer")
    List<Lawyer> queryAllLawyer();

    //登录
    Lawyer login(@Param("name") String name, @Param("password") String password);
}
