package com.example.application.controller;


import com.example.application.entities.Regle;
import com.example.application.entities.Utilisateur;
import com.example.application.service.RegleService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/regle")
@CrossOrigin(origins = "*")
public class RegleController {

    @Autowired
    RegleService regleService;

    @RequestMapping("/all")
    public List<Regle> getRegle() {
        System.out.println("liste desRegle");
        return (List<Regle>) regleService.getAllRegles();

    }

    @RequestMapping(method = RequestMethod.POST, value = "/add/all")
    public void addRegle(@RequestBody Regle regle) {
        System.out.println(regle.toString());
        regleService.addRegle(regle);
    }

    @RequestMapping("/all/{id}")
    public Optional<Regle> getSingleRegle(@PathVariable Long id) {
        return regleService.getSingleRegle(id);
    }



    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public void deleteRegle(@PathVariable Long id) {
        regleService.deleteRegle(id);
    }



}
