package com.zm.mapper;

import com.zm.pojo.Delegator;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface DelegatorMapper {

    //注册
    @Insert("insert into ssm.delegator(dename,depassword,email,phone,address,sex) values (#{dename},#{depassword},#{email},#{phone},#{address},#{sex});")
    int addDelegator(Delegator delegator);

    //登录
    //@Select("select * from ssm.delegator where dename = #{dename} and depassword = #{depassword} ")
    Delegator login(@Param("dename") String dname,@Param("depassword") String depassword);
}
