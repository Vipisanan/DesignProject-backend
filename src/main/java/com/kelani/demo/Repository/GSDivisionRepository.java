package com.kelani.demo.Repository;

import com.kelani.demo.Models.GSDivisionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GSDivisionRepository extends JpaRepository<GSDivisionModel , Integer> {
GSDivisionModel findFirstById(int id);
}
