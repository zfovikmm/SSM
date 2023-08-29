package com.zm.mapper;

import com.zm.pojo.Consultation;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ConsultationMapper {


    //创建信息
    @Insert("insert into ssm.consultation(status,type,context) values (#{status},#{type},#{context}) ")
    int addCs(Consultation consultation);

    //查询信息

    Consultation selectCs(@Param("consultationId") long consultationId);
}
