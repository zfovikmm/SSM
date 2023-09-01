package com.zm.service;

import com.zm.pojo.Lawyer;
import com.zm.pojo.Message;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface LawyerService {
    //查询所有律师
    List<Lawyer> queryAllLawyer();

    Lawyer login(String name,String password);

    int getAllSize();

    List<Lawyer> getAll(Map<String,Integer> map);

    int delLaw(int lawyerId);

    int upLaw(Lawyer lawyer);

    List<Lawyer> selectLawyer(String name);
}
