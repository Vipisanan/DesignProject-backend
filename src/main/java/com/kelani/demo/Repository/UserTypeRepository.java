package com.kelani.demo.Repository;

import com.kelani.demo.Models.UserTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTypeRepository extends JpaRepository<UserTypeModel , Integer> {
    UserTypeModel findFirstById(int id);

}
