package com.kelani.demo.DbInitializer;

import com.kelani.demo.Models.ProvinceModel;
import com.kelani.demo.Repository.ProvinceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
@ConditionalOnProperty(name = "app.init-province-db", havingValue = "true")

public class AddProvinceInitializer implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(AddProvinceInitializer.class);

    @Autowired
    private ProvinceRepository provinceRepository;


    @Override
    public void run(String... args) throws Exception {


        ProvinceModel p1=new ProvinceModel(1 , "Nothern Province");
        ProvinceModel p2=new ProvinceModel(2 , "Eastern Province");
        ProvinceModel p3=new ProvinceModel(3 , "Central Province");
        ProvinceModel p4=new ProvinceModel(4 , "Southern Province");
        ProvinceModel p5=new ProvinceModel(5 , "Western Province");
        ProvinceModel p6=new ProvinceModel(6 , "North Western Province");
        ProvinceModel p7=new ProvinceModel(7 , "North Central Province");
        ProvinceModel p8=new ProvinceModel(8 , "Uva Province");
        ProvinceModel p9=new ProvinceModel(9 , "Sabaragamuwa Province");

        provinceRepository.save(p1);
        provinceRepository.save(p2);
        provinceRepository.save(p3);
        provinceRepository.save(p4);
        provinceRepository.save(p5);
        provinceRepository.save(p6);
        provinceRepository.save(p7);
        provinceRepository.save(p8);
        provinceRepository.save(p9);

        LOGGER.info("Province Database has been initialized");
    }
}
