package com.kelani.demo.Services;

import com.kelani.demo.Models.UserTypeModel;
import com.kelani.demo.Repository.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserTypeService {

    @Autowired
    private UserTypeRepository userTypeRepository;

    public Set<UserTypeModel> saveAllRoles(Set<UserTypeModel> userTypeModel) {
        userTypeRepository.saveAll(userTypeModel);
        return userTypeModel;
    }
}
