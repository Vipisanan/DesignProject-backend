package com.kelani.demo.Repository;

import com.kelani.demo.Models.UserModel;
import com.kelani.demo.Models.VoterModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoterRepository extends JpaRepository<VoterModel, Integer> {
    VoterModel findFirstByVoterId(String s);
    VoterModel findFirstByUserModel(UserModel userModel);
}
