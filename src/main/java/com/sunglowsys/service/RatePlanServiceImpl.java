package com.sunglowsys.service;

import com.sunglowsys.domain.RatePlan;
import com.sunglowsys.repository.RatePlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatePlanServiceImpl implements RatePlanService{

    @Autowired
    private RatePlanRepository ratePlanRepository;

    @Override
    public RatePlan create(RatePlan ratePlan) {
        return ratePlanRepository.save(ratePlan);
    }

    @Override
    public RatePlan update(RatePlan ratePlan, Integer id) {
        RatePlan ratePlan1 = ratePlanRepository.getById(id);
        ratePlan1.setName(ratePlan1.getName());
        ratePlan1.setHotelId(ratePlan1.getHotelId());
        ratePlan1.setRoomTypeId(ratePlan1.getRoomTypeId());
        return ratePlanRepository.save(ratePlan);
    }

    @Override
    public List<RatePlan> findAll() {
        return ratePlanRepository.findAll();
    }

    @Override
    public RatePlan findById(Integer id) {
        Optional<RatePlan> optional = ratePlanRepository.findById(id);
        RatePlan ratePlan = null;
        if (optional.isPresent()){
            ratePlan = optional.get();
        }
        else {
            throw new RuntimeException("Rate-Plan is not found for id:" +id);
        }
        return ratePlan;
    }

    @Override
    public void delete(Integer id) {
        ratePlanRepository.deleteById(id);
    }
}
