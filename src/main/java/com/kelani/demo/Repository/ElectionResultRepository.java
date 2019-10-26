package com.kelani.demo.Repository;

import com.kelani.demo.Models.ElectionResultModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectionResultRepository extends JpaRepository<ElectionResultModel, Integer> {
}
