package com.kelani.demo.Repository;

import com.kelani.demo.Models.CandidateVoteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateVoteRepository extends JpaRepository<CandidateVoteModel , Integer> {
}
