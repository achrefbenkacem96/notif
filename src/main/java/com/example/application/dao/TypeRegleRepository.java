package com.example.application.dao;
import com.example.application.entities.TypeRegle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TypeRegleRepository extends JpaRepository<TypeRegle, Long> {
}


