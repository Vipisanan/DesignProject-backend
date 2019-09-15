package com.kelani.demo.DbInitializer;

import com.kelani.demo.Models.ElectionTypeModel;
import com.kelani.demo.Repository.ElectionTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(6)
public class AddElectionTypes implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(AddElectionTypes.class);

    @Autowired
    private ElectionTypeRepository electionTypeRepository;

    @Override
    public void run(String... args) throws Exception {

        ElectionTypeModel t1=new ElectionTypeModel(1 ,"President Election");
        ElectionTypeModel t2=new ElectionTypeModel(2 ,"Lok sabha Election");
        ElectionTypeModel t3=new ElectionTypeModel(3 ,"Parliament Election");

        electionTypeRepository.save(t1);
        electionTypeRepository.save(t2);
        electionTypeRepository.save(t3);

        LOGGER.info("Election types has been initialized");

    }
}
