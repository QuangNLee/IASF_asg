package com.example.asg.service;

import com.example.asg.entity.District;
import com.example.asg.entity.Street;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DistrictService {
    @Autowired
    private DistrictService districtService;

    public List<District> findAll(){
        return districtService.findAll();
    }

    public Optional<District> findById(int id){
        return districtService.findById(id);
    }
}
