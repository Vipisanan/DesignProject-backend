package com.kelani.demo.Services;

import com.kelani.demo.Controllers.VoterController;
import com.kelani.demo.Models.RoleModel;
import com.kelani.demo.Models.UserModel;
import com.kelani.demo.Models.VoterModel;
import com.kelani.demo.Repository.RoleRepository;
import com.kelani.demo.Repository.UserRepository;
import com.kelani.demo.Repository.VoterRepository;
import com.kelani.demo.exceptions.AGException;
import com.kelani.demo.exceptions.AGStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class VoterService {

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(VoterService.class);

    @Autowired
    private VoterRepository voterRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public List<VoterModel> getAllVoter() {
        LOGGER.info("Called get all voter method in VoterService");
        return voterRepository.findAll();
    }

    public VoterModel addVoter(int userId) throws AGException {
        LOGGER.info("called addVoter method in VoterService");
        VoterModel voterModel = new VoterModel();
        if (null != userRepository.findFirstById(userId)) {
            UserModel userModel=userRepository.findFirstById(userId);
            userModel.setVoter(true);
            userRepository.save(userModel);
            voterModel.setUserModel(userRepository.findFirstById(userId));
        } else {
            LOGGER.error(AGStatus.NO_ENTRY_FOUND.getStatusDescription() + "for this id: " + userId);
            throw new AGException(AGStatus.NO_ENTRY_FOUND);
        }
        voterModel.setPassword(passwordEncoder.encode("password"));
//        add default role here as USER
        Set<RoleModel> roleModelset = voterModel.getRoleModelset();
        roleModelset.add(roleRepository.findFirstById(4));
        voterModel.setRoleModelset(roleModelset);

        voterModel.setActiveVoter(true);
        try {
            voterRepository.save(voterModel);
            LOGGER.info("Added to voter List");
        } catch (IllegalArgumentException e) {
            LOGGER.error(AGStatus.ALREADY_EXIST.getStatusDescription());
            throw new AGException(AGStatus.ALREADY_EXIST);
        } catch (Exception e) {
            LOGGER.error(AGStatus.DB_ERROR.getStatusDescription());
            throw new AGException(AGStatus.DB_ERROR);
        }
        return voterModel;
    }
}
