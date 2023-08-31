package com.zm.mapper;

import com.zm.pojo.Casetype;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CasetypeMapper {


    //查询
    List<Casetype> queryAllCase();

    //增
    int  addCase(Casetype casetype);

    //删
    int delCase(@Param("caseId") int caseId);

    //改
    @Update("update ssm.casetype set type = #{type} where case_id = #{caseId}")
    int upCase(Casetype cas);
}
