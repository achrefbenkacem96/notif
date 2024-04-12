package com.example.application.service;

import com.example.application.dao.HistoriqueRepository;
import com.example.application.dao.RegleRepository;
import com.example.application.entities.Historique;
import com.example.application.entities.Regle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Service
@CrossOrigin(origins = "*")
public class RegleService {
    @Autowired
    RegleRepository regleRepository;
    HistoriqueRepository historiqueRepository;
    public List<Regle> getAllRegles() {
        System.out.println("une liste trié");
        return regleRepository.findAll();
    }
    public void addRegle(Regle Regle) {
        LocalDateTime date;
        date = LocalDateTime.now();
        regleRepository.save(Regle);
       Historique hs = new Historique();
       hs.setUtilisateurs(Regle.getUtilisateurs());
       hs.setR(Regle);
       hs.setDate(date);
       historiqueRepository.save(hs);

    }

    public Optional<Regle> getSingleRegle(Long idR ) {
        return regleRepository.findById(idR);
    }

    public void updateRegle(Long idR , Regle Regle) {
        regleRepository.save(Regle);
    }

    public void deleteRegle(Long idR ) {
        regleRepository.deleteById(idR );
    }

}
