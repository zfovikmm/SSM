package com.zm.service;

import com.zm.pojo.Casetype;

import java.util.List;

public interface CaseService {

    //查
    List<Casetype> queryAllCase();


    //增
    int  addCase(Casetype casetype);

    //删
    int delCase(int caseId);

    //改
    int upCase(Casetype cas);
}
