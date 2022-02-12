package com.sunglowsys.resource;

import com.sunglowsys.domain.RatePlan;
import com.sunglowsys.service.RatePlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RatePlanResource {

    @Autowired
    private RatePlanService ratePlanService;

    @PostMapping("/rate_plan")
    public ResponseEntity<?> create(@RequestBody RatePlan ratePlan){
        RatePlan result = ratePlanService.create(ratePlan);
        return ResponseEntity.ok().body(" RatePlan is created successfully: " + result);
    }

    @GetMapping
    public List<RatePlan> getAll(){
        List<RatePlan> result1 = ratePlanService.findAll();
        return result1;
    }

    @GetMapping("find_rate_plan/{id}")
    public RatePlan getById(@PathVariable("id") Integer id){
        return ratePlanService.findById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody RatePlan ratePlan, @PathVariable("id") Integer id){
        ratePlanService.update(ratePlan, id);
        return ResponseEntity.ok().body(" RatePlan is updated successfully: " + id);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        ratePlanService.delete(id);
        return ResponseEntity.ok().body(" RatePlan is successfully Deleted on this ID: " + id);
    }
}
