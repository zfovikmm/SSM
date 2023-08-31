package com.zm.mapper;

import com.zm.pojo.Delegator;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface DelegatorMapper {

    //注册
    @Insert("insert into ssm.delegator(dename,depassword,email,phone,address,sex) values (#{dename},#{depassword},#{email},#{phone},#{address},#{sex});")
    int addDelegator(Delegator delegator);

    //登录
    //@Select("select * from ssm.delegator where dename = #{dename} and depassword = #{depassword} ")
    Delegator login(@Param("dename") String dname,@Param("depassword") String depassword);

    //展示委托人
    //@Select("select * from ssm.delegator")
    List<Delegator> queryAll();

    //删除委托人
    @Delete("delete from ssm.delegator where delegator_id = #{delegatorId} ")
    int delGator(@Param("delegatorId") int delegatorId);

    //更新委托人
    @Update("update ssm.delegator\n" +
            "set dename = #{dename},email=#{email},phone=#{phone},address=#{address},sex=#{sex}\n" +
            "where delegator_id=${delegatorId};")
    int upDele(Delegator delegator);

    //模糊查询
    //@Select("select * from ssm.delegator where dename like concat('%',#{dename},'%')")
    List<Delegator> selectDele(@Param("dename") String dename);

    //查询总条数
    int getAllSize();

    //分页查询
    List<Delegator> getAll(Map<String,Integer> map);
}
