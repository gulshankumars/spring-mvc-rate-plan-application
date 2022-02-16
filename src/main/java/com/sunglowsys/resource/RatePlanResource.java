package com.sunglowsys.resource;

import com.sunglowsys.domain.RatePlan;
import com.sunglowsys.resource.util.BadRequestException;
import com.sunglowsys.service.RatePlanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RatePlanResource {

    private final Logger log = LoggerFactory.getLogger(RatePlanResource.class);

    private final RatePlanService ratePlanService;

    public RatePlanResource(RatePlanService ratePlanService) {
        this.ratePlanService = ratePlanService;
    }

    @PostMapping("/rate-plans")
    public ResponseEntity<RatePlan> createRatePlan(@RequestBody RatePlan ratePlan) throws URISyntaxException {
        log.debug("REST request to save RatePlan : {}",ratePlan);
        if (ratePlan.getId() != null){
            throw new BadRequestException("Id should be null in create api call");
        }
        RatePlan result = ratePlanService.create(ratePlan);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @GetMapping("/rate-plans")
    public ResponseEntity<List<RatePlan>> getAllRatePlan( @RequestBody Pageable pageable){
        log.debug("REST request to get RatePlan : {}", pageable.toString());
        Page<RatePlan> result = ratePlanService.findAll(pageable);
        return ResponseEntity
                .ok()
                .body(result.getContent());
    }

    @GetMapping("rate-plan/{id}")
    public ResponseEntity<RatePlan> getRatePlanById(@PathVariable("id") Long id){
        log.debug("REST request to RstePlan : {}", id);
       Optional<RatePlan> result = ratePlanService.findById(id);
        return ResponseEntity
                .ok()
                .body(result.get());
    }

    @PutMapping("/rate-plan/{id}")
    public ResponseEntity<RatePlan> updateRatePlan(@RequestBody RatePlan ratePlan, @PathVariable("id") Long id) throws URISyntaxException{
        log.debug("REST request to update RatePlan : {}",id);
        if (ratePlan.getId() == null){
            throw new BadRequestException("Id should not be null in update api call");
        }
        RatePlan result = ratePlanService.update(ratePlan,id);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @DeleteMapping("rate-plan/{id}")
    public ResponseEntity<RatePlan> delete(@PathVariable("id") Long id){
        log.debug("REST request to delete RatePlan : {}", id);
        ratePlanService.delete(id);
        return ResponseEntity
                .ok()
                .build();
    }
}
