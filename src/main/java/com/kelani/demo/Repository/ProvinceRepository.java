package com.kelani.demo.Repository;

import com.kelani.demo.Models.ProvinceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepository extends JpaRepository<ProvinceModel , Integer> {
    ProvinceModel getFirstById(int id);

}
