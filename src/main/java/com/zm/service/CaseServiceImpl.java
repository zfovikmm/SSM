package com.zm.service;

import com.zm.mapper.CasetypeMapper;
import com.zm.pojo.Casetype;

import javax.annotation.Resource;
import java.util.List;

public class CaseServiceImpl implements CaseService{

    @Resource
    private CasetypeMapper casetypeMapper;

    @Override
    public List<Casetype> queryAllCase() {
        return casetypeMapper.queryAllCase();
    }

    @Override
    public int addCase(Casetype casetype) {
        return casetypeMapper.addCase(casetype);
    }

    @Override
    public int delCase(int caseId) {
        return casetypeMapper.delCase(caseId);
    }

    @Override
    public int upCase(Casetype cas) {
        return casetypeMapper.upCase(cas);
    }


}
