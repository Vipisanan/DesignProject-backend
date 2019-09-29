package com.kelani.demo.Repository;

import com.kelani.demo.Models.NominatedCandidateModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NominatedCandidateRepository extends JpaRepository<NominatedCandidateModel , Integer> {
    NominatedCandidateModel findFirstById(int i);
}
