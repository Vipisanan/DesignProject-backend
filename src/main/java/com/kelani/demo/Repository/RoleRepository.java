package com.kelani.demo.Repository;

import com.kelani.demo.Models.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleModel , Integer> {
    RoleModel findFirstById(int i);
}
