package com.zm.service;

import com.zm.pojo.Delegator;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DelegatorService {

    //登录
    Delegator login(String dename,String depassword);

    //注册
    int addDelegator(Delegator delegator);

    //展示所有委托人
    List<Delegator> queryAll();

    //删除委托人
    int delGator(int delegatorId);

    //编辑委托人
    int upDele(Delegator delegator);

    //模糊查询
    List<Delegator> selectDele(String dename);

    //查询总条数
    int getAllSize();

    //分页查询
    List<Delegator> getAll(Map<String,Integer> map);
}
