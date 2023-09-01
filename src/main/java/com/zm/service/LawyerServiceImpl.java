package com.zm.service;

import com.zm.mapper.LawyerMapper;
import com.zm.pojo.Lawyer;
import com.zm.pojo.Message;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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

    @Override
    public int getAllSize() {
        return lawyerMapper.getAllSize();
    }

    @Override
    public List<Lawyer> getAll(Map<String, Integer> map) {
        return lawyerMapper.getAll(map);
    }

    @Override
    public int delLaw(int lawyerId) {
        return lawyerMapper.delLaw(lawyerId);
    }

    @Override
    public int upLaw(Lawyer lawyer) {
        return lawyerMapper.upLaw(lawyer);
    }

    @Override
    public List<Lawyer> selectLawyer(String name) {
        return lawyerMapper.selectLawyer(name);
    }


}
