package com.example.application.dao;

import com.example.application.entities.Alerte;
import com.example.application.entities.Historique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface HistoriqueRepository extends JpaRepository<Historique, Long> {
}