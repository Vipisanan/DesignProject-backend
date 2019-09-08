package com.kelani.demo.Repository;

import com.kelani.demo.Models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel , Integer> {
    UserModel findFirstById(int i);
}
