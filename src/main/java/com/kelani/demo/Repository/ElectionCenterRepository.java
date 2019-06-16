package com.kelani.demo.Repository;

import com.kelani.demo.Models.ElectionCenterModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectionCenterRepository extends JpaRepository<ElectionCenterModel, Integer> {
}
