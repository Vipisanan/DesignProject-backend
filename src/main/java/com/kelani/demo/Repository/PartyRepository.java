package com.kelani.demo.Repository;

import com.kelani.demo.Models.PartyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartyRepository extends JpaRepository<PartyModel , Integer> {
}
