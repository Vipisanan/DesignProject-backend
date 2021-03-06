package com.kelani.demo.Repository;

import com.kelani.demo.Models.ElectionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElectionRepository extends JpaRepository<ElectionModel ,Integer> {
    ElectionModel findFirstById(int i);
    ElectionModel deleteById(int i);
    List<ElectionModel> findFirstByActive(boolean b);
}
