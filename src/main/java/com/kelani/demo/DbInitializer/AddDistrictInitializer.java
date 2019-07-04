package com.kelani.demo.DbInitializer;

import com.kelani.demo.Models.DistrictModel;
import com.kelani.demo.Repository.DistrictRepository;
import com.kelani.demo.Repository.ProvinceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
@ConditionalOnProperty(name = "app.init-district-db", havingValue = "true")
public class AddDistrictInitializer implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddDistrictInitializer.class);

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private ProvinceRepository provinceRepository;

    @Override
    public void run(String... args) throws Exception {
        if (districtRepository.findAll()!=null){
//            districtRepository.deleteAll();
        }


        DistrictModel model1 = new DistrictModel(1, "Mullaitivu", provinceRepository.findFirstById(1));
        DistrictModel model2 = new DistrictModel(2, "Kilinochchi", provinceRepository.findFirstById(1));
        DistrictModel model3 = new DistrictModel(3, "Vavuniya", provinceRepository.findFirstById(1));
        DistrictModel model4 = new DistrictModel(4, "Mannar", provinceRepository.findFirstById(1));
        DistrictModel model5 = new DistrictModel(5, "Jaffna", provinceRepository.findFirstById(1));

        DistrictModel model6 = new DistrictModel(6, "Trincomalee", provinceRepository.findFirstById(2));
        DistrictModel model7 = new DistrictModel(7, "Batticaloa", provinceRepository.findFirstById(2));
        DistrictModel model8 = new DistrictModel(8, "Ampara", provinceRepository.findFirstById(2));

        DistrictModel model9 = new DistrictModel(9, "Matale", provinceRepository.findFirstById(3));
        DistrictModel model10 = new DistrictModel(10, "Kandy", provinceRepository.findFirstById(3));
        DistrictModel model11 = new DistrictModel(11, "Nuwara Eliya", provinceRepository.findFirstById(3));

        DistrictModel model12 = new DistrictModel(12, "Hambantota", provinceRepository.findFirstById(4));
        DistrictModel model13 = new DistrictModel(13, "Matara", provinceRepository.findFirstById(4));
        DistrictModel model14 = new DistrictModel(14, "Galle", provinceRepository.findFirstById(4));

        DistrictModel model15 = new DistrictModel(15, "Gampaha", provinceRepository.findFirstById(5));
        DistrictModel model16 = new DistrictModel(16, "Colombo", provinceRepository.findFirstById(5));
        DistrictModel model17 = new DistrictModel(17, "Kalutara", provinceRepository.findFirstById(5));

        DistrictModel model19 = new DistrictModel(18, "Kurunegala", provinceRepository.findFirstById(6));
        DistrictModel model18 = new DistrictModel(19, "Puttalam", provinceRepository.findFirstById(6));

        DistrictModel model21 = new DistrictModel(20, "Polonnaruwa", provinceRepository.findFirstById(7));
        DistrictModel model20 = new DistrictModel(21, "Anuradhapura", provinceRepository.findFirstById(7));

        DistrictModel model23 = new DistrictModel(22, "Monaragala", provinceRepository.findFirstById(8));
        DistrictModel model22 = new DistrictModel(23, "Badulla", provinceRepository.findFirstById(8));

        DistrictModel model25 = new DistrictModel(24, "Ratnapura", provinceRepository.findFirstById(9));
        DistrictModel model24 = new DistrictModel(25
                , "Kegalle", provinceRepository.findFirstById(9));


        districtRepository.save(model1);
        districtRepository.save(model2);
        districtRepository.save(model3);
        districtRepository.save(model4);
        districtRepository.save(model5);
        districtRepository.save(model6);
        districtRepository.save(model7);
        districtRepository.save(model8);
        districtRepository.save(model9);
        districtRepository.save(model10);
        districtRepository.save(model11);
        districtRepository.save(model12);
        districtRepository.save(model13);
        districtRepository.save(model14);
        districtRepository.save(model15);
        districtRepository.save(model16);
        districtRepository.save(model17);
        districtRepository.save(model18);
        districtRepository.save(model19);
        districtRepository.save(model20);
        districtRepository.save(model21);
        districtRepository.save(model22);
        districtRepository.save(model23);
        districtRepository.save(model24);
        districtRepository.save(model25);

        LOGGER.info("All 25 District Database has been initialized");

    }

}
