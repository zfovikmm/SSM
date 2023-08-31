package com.zm.service;

import com.zm.mapper.LawyerMapper;
import com.zm.pojo.Lawyer;
import com.zm.pojo.Message;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LawyerServiceImpl implements LawyerService{

    @Resource
    private LawyerMapper lawyerMapper;

    @Override
    public List<Lawyer> queryAllLawyer() {
        return lawyerMapper.queryAllLawyer();
    }

    @Override
    public Lawyer login(String name, String password) {
        return lawyerMapper.login(name,password);
    }



}
