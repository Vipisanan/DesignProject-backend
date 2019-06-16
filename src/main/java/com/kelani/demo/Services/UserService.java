package com.kelani.demo.Services;

import com.kelani.demo.Models.UserModel;
import com.kelani.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserModel> findAll() {
        return userRepository.findAll();
    }

    public UserModel save(UserModel userModel) {
        userRepository.save(userModel);
        return userModel;
    }
}
