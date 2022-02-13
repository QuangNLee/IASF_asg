package com.example.asg.controller;

import com.example.asg.entity.Street;
import com.example.asg.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/streets")
public class StreetController {
    @Autowired
    StreetService streetService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> getList(@RequestParam(required = false, defaultValue = "1")int page, @RequestParam(defaultValue = "10") int limit){
        HashMap<String, Object> response = new HashMap<>();
        response.put("page", page);
        response.put("limit", limit);
        response.put("data", streetService.findAll());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/detail/{id}")
    public ResponseEntity<Object> getDetail(@PathVariable int id){
        Optional<Street> optionalFood = streetService.findById(id);
        if(optionalFood.isPresent()){
            return new ResponseEntity<>(streetService.findById(id).orElse(null), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Street> create(@RequestBody Street street){
        streetService.save(street);
        return new ResponseEntity<Street>(street, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity<Object> update(@PathVariable int id, @RequestBody Street updateStreet){
        Optional<Street> optionalStreet = streetService.findById(id);
        if(optionalStreet.isPresent()){
            Street street = optionalStreet.get();
            street.setName(updateStreet.getName());
            streetService.save(street);
            return new ResponseEntity<>(street, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id){
        Optional<Street> optionalStreet = streetService.findById(id);
        if(optionalStreet.isPresent()){
            streetService.delete(optionalStreet.get());
            return new ResponseEntity<>(true, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/district/{district_id")
    public List<Street> findAllByDistrictId(@PathVariable int district_id){
        return streetService.findStreetByDistrict_Id(district_id);
    }
}
