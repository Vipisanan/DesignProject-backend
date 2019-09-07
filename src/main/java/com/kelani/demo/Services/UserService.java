package com.kelani.demo.Services;

import com.kelani.demo.DAO.UserDAO;
import com.kelani.demo.Models.UserModel;
import com.kelani.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<UserDAO> findAllUser() {
        List<UserDAO> dao = new ArrayList<>();
        UserDAO detailsDAO = new UserDAO();
        List<UserModel> model = new ArrayList<>();
        model = userRepository.findAll();
        for (int i=0; i<model.size(); i++){
            System.out.println("************************ " + model.size());
            detailsDAO.setFirstName(model.get(i).getFirstName());
            detailsDAO.setLastName(model.get(i).getLastName());
            detailsDAO.setImageUrl(model.get(i).getImageUrl());
            detailsDAO.setNicNo(model.get(i).getNicNo());
            detailsDAO.setGsDivisionName(model.get(i).getGsDivisionModel().getName());
            dao.add(detailsDAO);
        }


        return dao;
    }
}
