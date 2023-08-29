package com.zm.service;

import com.zm.mapper.AdministratorMapper;
import com.zm.pojo.Administrator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdministratorServiceImpl implements AdministratorService{

    @Resource
    private AdministratorMapper administratorMapper;

    @Override
    public Administrator login(String name,String password) {
        return administratorMapper.login(name,password);
    }

    public void setAdministratorMapper(AdministratorMapper administratorMapper) {
        this.administratorMapper = administratorMapper;
    }
}
