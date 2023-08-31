package com.zm.service;

import com.zm.mapper.DelegatorMapper;
import com.zm.pojo.Delegator;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class DelegatorServiceImpl implements DelegatorService{

    @Resource
    private DelegatorMapper delegatorMapper;

    @Override
    public Delegator login(String dename, String depassword) {
        return delegatorMapper.login(dename,depassword);
    }

    @Override
    public int addDelegator(Delegator delegator) {
        return delegatorMapper.addDelegator(delegator);
    }

    @Override
    public List<Delegator> queryAll() {
        return delegatorMapper.queryAll();
    }

    @Override
    public int delGator(int delegatorId) {
        return delegatorMapper.delGator(delegatorId);
    }

    @Override
    public int upDele(Delegator delegator) {
        return delegatorMapper.upDele(delegator);
    }

    @Override
    public List<Delegator> selectDele(String dename) {
        return delegatorMapper.selectDele(dename);
    }

    @Override
    public int getAllSize() {
        return delegatorMapper.getAllSize();
    }

    @Override
    public List<Delegator> getAll(Map<String, Integer> map) {
        return delegatorMapper.getAll(map);
    }
}
