package com.kelani.demo.Repository;

import com.kelani.demo.Models.VoterModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoterRepository extends JpaRepository<VoterModel, Integer> {
}
