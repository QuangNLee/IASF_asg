package com.example.asg.repository;

import com.example.asg.entity.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StreetRepository extends JpaRepository<Street, Integer>, PagingAndSortingRepository<Street, Integer> {
    List<Street> findStreetByDistrict_Id(@Param("district_id")int district_id);
}
