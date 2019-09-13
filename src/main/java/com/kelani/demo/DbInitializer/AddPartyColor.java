package com.kelani.demo.DbInitializer;


import com.kelani.demo.Models.PartyColourModel;
import com.kelani.demo.Repository.PartyColourRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(5)
@ConditionalOnProperty(name = "app.init-province-db", havingValue = "true")
public class AddPartyColor implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddProvinceInitializer.class);


    @Autowired
    private PartyColourRepository partyColourRepository;

    @Override
    public void run(String... args) throws Exception {

        PartyColourModel m1=new PartyColourModel(1 , "red");
        PartyColourModel m2=new PartyColourModel(2 , "green");
        PartyColourModel m3=new PartyColourModel(3 , "blue");
        PartyColourModel m4=new PartyColourModel(4 , "yellow");


        partyColourRepository.save(m1);
        partyColourRepository.save(m2);
        partyColourRepository.save(m3);
        partyColourRepository.save(m4);

        LOGGER.info("first four colors are added in DB | Database has been initialized");


    }
}
