package com.kelani.demo.Repository;

import com.kelani.demo.Models.PartyColourModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartyColourRepository extends JpaRepository<PartyColourModel , Integer> {
}
