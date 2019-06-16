package com.kelani.demo.Repository;

import com.kelani.demo.Models.DistrictModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictRepository extends JpaRepository<DistrictModel , Integer> {

    DistrictModel findFirstByName(String s);
}
