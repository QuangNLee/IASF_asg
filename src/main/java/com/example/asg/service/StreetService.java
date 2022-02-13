package com.example.asg.service;

import com.example.asg.entity.District;
import com.example.asg.entity.Street;
import com.example.asg.repository.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StreetService{
    @Autowired
    private StreetRepository streetRepository;

    public List<Street> findAll(){
        return streetRepository.findAll();
    }

    public Optional<Street> findById(int id) {
        return streetRepository.findById(id);
    }

    public Street save(Street street){
        return streetRepository.save(street);
    }

    public Street update(Street street){
        return streetRepository.save(street);
    }

    public boolean delete(Street street){
        streetRepository.delete(street);
        return true;
    }

    public List<Street> findStreetByDistrict_Id(int district_id){
        return streetRepository.findStreetByDistrict_Id(district_id);
    }
}
