package com.zm.service;

import com.zm.pojo.Delegator;

public interface DelegatorService {

    //登录
    Delegator login(String dename,String depassword);

    //注册
    int addDelegator(Delegator delegator);
}
