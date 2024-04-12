package com.example.application.controller;

import com.example.application.entities.Utilisateur;
import com.example.application.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/utilisateur")
@CrossOrigin(origins = "*")
public class UtilisateurController {

    @Autowired
    UtilisateurService utilisateurService;
    @RequestMapping("/all")
    public List<Utilisateur> getUtilisateur() {
        System.out.println("liste desUtilisateur");
        return (List<Utilisateur>)utilisateurService.getAllUtilisateurs();

    }

    @RequestMapping(method = RequestMethod.POST, value = "/add/all")
    public void addUtilisateur (@RequestBody Utilisateur utilisateur) {
        System.out.println(utilisateur.toString());
        utilisateurService.addUtilisateur(utilisateur);
    }

    @RequestMapping("/all/{id}")
    public Optional<Utilisateur> getSingleUtilisateur (@PathVariable Long id) {
        return utilisateurService.getSingleUtilisateur(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update/{id}")
    public void updateUtilisateur (@RequestBody Utilisateur utilisateur, @PathVariable Long id) {
        utilisateurService.updateUtilisateur(id,utilisateur);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public void deleteUtilisateur (@PathVariable Long id) {
        utilisateurService.deleteUtilisateur(id);
    }


}
