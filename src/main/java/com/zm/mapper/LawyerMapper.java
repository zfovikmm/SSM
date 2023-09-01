package com.zm.mapper;

import com.zm.pojo.Delegator;
import com.zm.pojo.Lawyer;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface LawyerMapper {


    //查
    @Select("select * from ssm.lawyer")
    List<Lawyer> queryAllLawyer();

    //登录
    Lawyer login(@Param("name") String name, @Param("password") String password);

    //查询总条数
    int getAllSize();

    //分页查询
    List<Lawyer> getAll(Map<String,Integer> map);

    //删除
    @Delete("delete from ssm.lawyer where lawyer_id = #{lawyerId}")
    int delLaw(@Param("lawyerId") int lawyerId);

    //改
    @Update("update ssm.lawyer\n" +
            "set name = #{name},age=#{age},contact=#{contact},address=#{address},law_firm=#{lawFirm},education=#{education},specialization=#{specialization}\n" +
            "where lawyer_id=${lawyerId};")
    int upLaw(Lawyer lawyer);

    //模糊查询
    List<Lawyer> selectLawyer(@Param("name") String name);
}
