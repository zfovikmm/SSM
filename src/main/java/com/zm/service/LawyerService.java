package com.zm.service;

import com.zm.pojo.Lawyer;
import com.zm.pojo.Message;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LawyerService {
    //查询所有律师
    List<Lawyer> queryAllLawyer();

    Lawyer login(String name,String password);


}
