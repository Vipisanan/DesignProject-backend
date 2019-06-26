package com.kelani.demo.Repository;

import com.kelani.demo.Models.PartyVoteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartyVoteRepository  extends JpaRepository<PartyVoteModel , Integer> {
}
