package com.zm.service;

import com.zm.pojo.Administrator;

public interface AdministratorService {


    //登录
    Administrator login(String name, String password);

}
