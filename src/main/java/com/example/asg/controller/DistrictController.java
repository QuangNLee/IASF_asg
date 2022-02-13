package com.example.asg.controller;

import com.example.asg.entity.District;
import com.example.asg.entity.Street;
import com.example.asg.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/districts")
public class DistrictController {
    @Autowired
    DistrictService districtService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> getList(@RequestParam (required = false, defaultValue = "1")int page, @RequestParam(defaultValue = "10")int limit){
        HashMap<String, Object> response = new HashMap<>();
        response.put("page", page);
        response.put("limit", limit);
        response.put("data", districtService.findAll());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<Object> getDetail(@PathVariable int id){
        Optional<District> optionalFood = districtService.findById(id);
        if(optionalFood.isPresent()){
            return new ResponseEntity<>(districtService.findById(id).orElse(null), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
