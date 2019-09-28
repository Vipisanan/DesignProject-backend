package com.kelani.demo.Repository;

import com.kelani.demo.Models.NominatedPartyModel;
import com.kelani.demo.Models.PartyModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NominatedPartyRepository extends JpaRepository<NominatedPartyModel , String> {
    NominatedPartyModel findFirstById(String s);
    NominatedPartyModel findFirstByPartyModel(PartyModel partyModel);
}
