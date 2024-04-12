/* package com.example.application.service;

import com.example.application.entities.Alerte;
// import com.example.application.dao.AlerteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Service
@CrossOrigin(origins = "*")
public class AlerteService {
    @Autowired
    private AlerteRepository alerteRepository;

    public void addAlerte(Alerte Alerte) {
        alerteRepository.save(Alerte);
    }

    public List<Alerte> getAlertesByReceiverId(Long receiverId) {
        return alerteRepository.findByReceiverId(receiverId);
    }

    public void handleAlerteResponse(Long AlerteId, boolean response) {
        Alerte alerte = alerteRepository.findById(AlerteId).orElse(null);
        if (alerte != null) {
            alerte.setStatus(String.valueOf(response));
            alerteRepository.save(alerte);
        }
    }
}*/
