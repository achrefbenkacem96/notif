package com.example.application.dao;


import com.example.application.entities.Regle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RegleRepository extends JpaRepository<Regle, Long> {

}
