package com.kelani.demo.DbInitializer;

import com.kelani.demo.Models.GSDivisionModel;
import com.kelani.demo.Repository.DistrictRepository;
import com.kelani.demo.Repository.GSDivisionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(4)
public class AddGSDivision  implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddGSDivision.class);


    @Autowired
    private GSDivisionRepository gsDivisionRepository;

    @Autowired
    private DistrictRepository districtRepository;


    @Override
    public void run(String... args) throws Exception {
//get from
// http://www.vavuniya.ds.gov.lk/index.php/en/administrative-structure/gn-divisions.html
        GSDivisionModel model1 = new GSDivisionModel(1 , "Vavuniya Town" , "214" , "0242223234" , districtRepository.findFirstById(3));
        GSDivisionModel model2 = new GSDivisionModel(2 , "Thandikulam" , "214A" , "0242221547" , districtRepository.findFirstById(3));
        GSDivisionModel model3 = new GSDivisionModel(3 , "Paddanichchipuliyankulam" , "214B" , "0242226916" , districtRepository.findFirstById(3));
        GSDivisionModel model4 = new GSDivisionModel(4 , "Vavuniya Town North" , "214C" , "0242226916" , districtRepository.findFirstById(3));
        GSDivisionModel model5 = new GSDivisionModel(5 , "Vairavapuliyankulam" , "214D  " , "0242224942" , districtRepository.findFirstById(3));

        gsDivisionRepository.save(model1);
        gsDivisionRepository.save(model2);
        gsDivisionRepository.save(model3);
        gsDivisionRepository.save(model4);
        gsDivisionRepository.save(model5);

        LOGGER.info("First five GSDivision Database has been initialized");
    }
}
