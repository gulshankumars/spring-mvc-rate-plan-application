package com.sunglowsys.service;

import com.sunglowsys.domain.RatePlan;
import com.sunglowsys.repository.RatePlanRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RatePlanServiceImpl implements RatePlanService{

    private  final Logger log = LoggerFactory.getLogger(RatePlanServiceImpl.class);


    private final RatePlanRepository ratePlanRepository;

    public RatePlanServiceImpl(RatePlanRepository ratePlanRepository) {
        this.ratePlanRepository = ratePlanRepository;
    }

    @Override
    public RatePlan create(RatePlan ratePlan) {
        log.debug("Request to save RatePlan : {}",ratePlan);
        return ratePlanRepository.save(ratePlan);
    }

    @Override
    public RatePlan update(RatePlan ratePlan, Long id) {
        log.debug("Request to update RatePlan : {}",ratePlan);
        return ratePlanRepository.save(ratePlan);

    }

    @Override
    public Page<RatePlan> findAll(Pageable pageable) {
        log.debug("Request to update RatePlan : {}",pageable.toString());
        return ratePlanRepository.findAll(pageable);
    }

    @Override
    public Optional<RatePlan> findById(Long id) {
       log.debug("Request to get RatePlan : {}", id);
       return ratePlanRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete RatePlan : {}",id);
        ratePlanRepository.deleteById(id);
    }
}
