package com.kelani.demo.DbInitializer;

import com.kelani.demo.Models.UserTypeModel;
import com.kelani.demo.Repository.UserTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Order(1)
@ConditionalOnProperty(name = "app.init-user-type-db", havingValue = "true")
public class AddUserType implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddUserType.class);

    @Autowired
    private UserTypeRepository userTypeRepository;

    @Override
    public void run(String... args) throws Exception {

        UserTypeModel userTypeModel1 = new UserTypeModel(1, "Voter");
        UserTypeModel userTypeModel2 = new UserTypeModel(2, "Election Commissioner");
        UserTypeModel userTypeModel3 = new UserTypeModel(3, "Party Register Officer");
        UserTypeModel userTypeModel4 = new UserTypeModel(4, "Head of the Election Centre");
        UserTypeModel userTypeModel5 = new UserTypeModel(5, "Voter Register Officer");
        UserTypeModel userTypeModel6 = new UserTypeModel(6, "Election Organizer");
        UserTypeModel userTypeModel7 = new UserTypeModel(7, "Election Office");
        UserTypeModel userTypeModel8 = new UserTypeModel(8, "Candidate Register Officer");


        userTypeRepository.save(userTypeModel1);
        userTypeRepository.save(userTypeModel2);
        userTypeRepository.save(userTypeModel3);
        userTypeRepository.save(userTypeModel4);
        userTypeRepository.save(userTypeModel5);
        userTypeRepository.save(userTypeModel6);
        userTypeRepository.save(userTypeModel7);
        userTypeRepository.save(userTypeModel8);

        LOGGER.info("User Type Database has been initialized");
//        }


    }
}
