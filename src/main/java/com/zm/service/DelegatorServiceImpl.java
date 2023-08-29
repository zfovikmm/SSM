package com.zm.service;

import com.zm.mapper.DelegatorMapper;
import com.zm.pojo.Delegator;

import javax.annotation.Resource;

public class DelegatorServiceImpl implements DelegatorService{

    @Resource
    private DelegatorMapper delegatorMapper;

    @Override
    public int addDelegator(Delegator delegator) {
        return 0;
    }
}
