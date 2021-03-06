package com.kelani.demo.Services;

import com.kelani.demo.DAO.UserDAO;
import com.kelani.demo.Models.FingerPrintModel;
import com.kelani.demo.Models.UserModel;
import com.kelani.demo.Models.VoterModel;
import com.kelani.demo.Repository.FingerPrintRepository;
import com.kelani.demo.Repository.UserRepository;
import com.kelani.demo.Repository.VoterRepository;
import com.kelani.demo.exceptions.AGException;
import com.kelani.demo.exceptions.AGStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceUser {

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(ServiceUser.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FingerPrintRepository fingerPrintRepository;
    @Autowired
    private VoterRepository voterRepository;

    public List<UserModel> findAll() {
        return userRepository.findAll();
    }

    public UserModel save(UserModel userModel) {
        userRepository.save(userModel);
        return userModel;
    }

    public List<UserModel> findAllUser() {
        List<UserDAO> dao = new ArrayList<>();
        UserDAO detailsDAO = new UserDAO();
        List<UserModel> model = new ArrayList<>();
        model = userRepository.findAll();
        for (int i = 0; i < model.size(); i++) {
            dao.add(new UserDAO(model.get(i).getId(),
                    model.get(i).getFirstName(),
                    model.get(i).getLastName(),
                    model.get(i).getImageUrl(),
                    model.get(i).getNicNo(),
                    model.get(i).getGsDivisionModel().getName()));

        }
        return userRepository.findAll();
    }

    public UserModel getUserById(int uId) throws Exception {
        UserModel userModel = new UserModel();
        try {
            userModel = userRepository.findFirstById(uId);
        } catch (Exception e) {
            LOGGER.error(AGStatus.DB_ERROR.getStatusDescription());
            throw new AGException(AGStatus.DB_ERROR);
        }
        return userModel;
    }

    public UserModel addFingerPrint(int id, String fingerPrint) throws AGException {
        UserModel userModel = userRepository.findFirstById(id);
        FingerPrintModel fingerPrintModel = new FingerPrintModel();
        fingerPrintModel.setFingerprint(fingerPrint);
        fingerPrintModel.setUserModel(userModel);
        try {
            fingerPrintRepository.save(fingerPrintModel);
        } catch (Exception e) {
            LOGGER.error(AGStatus.DB_ERROR.getStatusDescription());
            throw new AGException(AGStatus.DB_ERROR);
        }
        return userModel;
    }

    public List<FingerPrintModel> getAllFingerPrints() {
        return fingerPrintRepository.findAll();
    }

    public String findUserByFingerPrint(String fingerPrint) throws AGException {
        FingerPrintModel printModel = new FingerPrintModel();
        VoterModel voterModel;
        UserModel userModel;
        try {
            printModel = fingerPrintRepository.findByFingerprint(fingerPrint);
            userModel = printModel.getUserModel();
        } catch (NullPointerException e) {
            LOGGER.error(AGStatus.NO_USER_FOUND.getStatusDescription());
            throw new AGException(AGStatus.NO_USER_FOUND);
        } catch (Exception e) {
            LOGGER.error(AGStatus.DB_ERROR.getStatusDescription());
            throw new AGException(AGStatus.DB_ERROR);
        }

        try {
            voterModel = voterRepository.findFirstByUserModel(userModel);

        } catch (NullPointerException e) {
            LOGGER.error(AGStatus.NO_VOTER_FOUND.getStatusDescription());
            throw new AGException(AGStatus.NO_VOTER_FOUND);
        } catch (Exception e) {
            LOGGER.error(AGStatus.DB_ERROR.getStatusDescription());
            throw new AGException(AGStatus.DB_ERROR);
        }

        return voterModel.getVoterId();
    }
}
