package com.example.application.service;
import com.example.application.dao.UtilisateurRepository;
import com.example.application.entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;
@Service
@CrossOrigin(origins = "*")
public class UtilisateurService {
    @Autowired
    UtilisateurRepository utilisateurRepository;
    public List<Utilisateur> getAllUtilisateurs() {
        System.out.println("une liste trié");
        return utilisateurRepository.findAll();
    }
    public void addUtilisateur(Utilisateur Utilisateur) {
         utilisateurRepository.save(Utilisateur);
    }

    public Optional<Utilisateur> getSingleUtilisateur(Long id) {
        return utilisateurRepository.findById(id);
    }

    public void updateUtilisateur(Long id, Utilisateur Utilisateur) {
        utilisateurRepository.save(Utilisateur);
    }

    public void deleteUtilisateur(Long id) {
        utilisateurRepository.deleteById(id);
    }
}
