package com.kelani.demo.Repository;

import com.kelani.demo.Models.FingerPrintModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FingerPrintRepository extends JpaRepository<FingerPrintModel, Integer> {


}

