package com.kelani.demo.Repository;

import com.kelani.demo.Models.ElectionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectionRepository extends JpaRepository<ElectionModel ,Integer> {
}
