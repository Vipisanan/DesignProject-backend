package com.kelani.demo.Repository;

import com.kelani.demo.Models.ElectionZoneModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectionZoneRepository extends JpaRepository<ElectionZoneModel , Integer> {
}
