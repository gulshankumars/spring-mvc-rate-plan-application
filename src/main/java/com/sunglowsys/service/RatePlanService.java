package com.sunglowsys.service;

import com.sunglowsys.domain.RatePlan;

import java.util.List;

public interface RatePlanService {

    RatePlan create(RatePlan ratePlan);

    RatePlan update(RatePlan ratePlan, Integer id);

    List<RatePlan> findAll();

    RatePlan findById(Integer id);

    void delete(Integer id);
}
