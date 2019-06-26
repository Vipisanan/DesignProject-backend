package com.kelani.demo.Repository;

import com.kelani.demo.Models.NominatedPartyModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NominatedPartyRepository extends JpaRepository<NominatedPartyModel , Integer> {
}
