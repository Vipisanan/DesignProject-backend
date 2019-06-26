package com.kelani.demo.Repository;

import com.kelani.demo.Models.ElectionCenterStaffModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectionStaffRepository extends JpaRepository<ElectionCenterStaffModel , Integer> {
}
