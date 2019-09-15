package com.kelani.demo.Repository;

import com.kelani.demo.Models.CandidateModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CandidateRepository extends JpaRepository<CandidateModel, Integer> {
    CandidateModel findFirstById(int i);
}
