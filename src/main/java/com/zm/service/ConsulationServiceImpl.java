package com.zm.service;

import com.zm.mapper.ConsultationMapper;
import com.zm.pojo.Consultation;

import javax.annotation.Resource;

public class ConsulationServiceImpl implements ConsulationService{

    @Resource
    private ConsultationMapper consultationMapper;
    @Override
    public int addCs(Consultation consultation) {
        return consultationMapper.addCs(consultation);
    }

    @Override
    public Consultation selectCs(long consultationId) {
        return consultationMapper.selectCs(consultationId);
    }
}
