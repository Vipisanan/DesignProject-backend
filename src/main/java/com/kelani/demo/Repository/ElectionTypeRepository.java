package com.kelani.demo.Repository;

import com.kelani.demo.Models.ElectionTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectionTypeRepository extends JpaRepository<ElectionTypeModel ,Integer> {
    ElectionTypeModel findFirstById(int i);
}
