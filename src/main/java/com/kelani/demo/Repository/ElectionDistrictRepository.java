package com.kelani.demo.Repository;

import com.kelani.demo.Models.ElectionalDistrictModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectionDistrictRepository extends JpaRepository<ElectionalDistrictModel , Integer> {
}
