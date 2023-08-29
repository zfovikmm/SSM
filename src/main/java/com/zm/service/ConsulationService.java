package com.zm.service;

import com.zm.pojo.Consultation;

public interface ConsulationService {

    int addCs(Consultation consultation);

    Consultation selectCs(long consultationId);
}
