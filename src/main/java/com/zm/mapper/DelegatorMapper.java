package com.zm.mapper;

import com.zm.pojo.Delegator;
import org.apache.ibatis.annotations.Insert;

public interface DelegatorMapper {

    @Insert("insert into ssm.delegator(dename,depassword,email,phone,address,sex) values (#{dename},#{depassword},#{email},#{phone},#{address},#{sex});")
    int addDelegator(Delegator delegator);
}
