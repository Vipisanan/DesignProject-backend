package com.kelani.demo.Services;

import com.kelani.demo.Models.VoterModel;

import java.util.List;

public interface UserService {

    VoterModel save(VoterModel user);
    List<VoterModel> findAll();
    void delete(long id);
}
