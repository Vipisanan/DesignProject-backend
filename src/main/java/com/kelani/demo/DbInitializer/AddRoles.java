package com.kelani.demo.DbInitializer;

import com.kelani.demo.Models.RoleModel;
import com.kelani.demo.Repository.RoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(7)
@ConditionalOnProperty(name = "app.init-user-roles-db", havingValue = "true")
public class AddRoles implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddRoles.class);

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        RoleModel roleModel1= new RoleModel(1 , "SUPER_ADMIN");
        RoleModel roleModel2= new RoleModel(2 , "ADMIN");
        RoleModel roleModel3= new RoleModel(3 , "VOTER");
        RoleModel roleModel4= new RoleModel(4 , "USER");

        roleRepository.save(roleModel1);
        roleRepository.save(roleModel2);
        roleRepository.save(roleModel3);
        roleRepository.save(roleModel4);

        LOGGER.info("User ROLES Database has been initialized");
    }
}
