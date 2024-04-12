package com.example.application.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {


    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/user")
    @PreAuthorize("hasAuthority('ROLE_UTILISATEUR')")
    public String userAccess() {
        return "Utilisateur Content.";
    }

    @GetMapping("/ges")
    @PreAuthorize("hasAuthority('ROLE_GESTIONNAIRE')")
    public String gestionnaireAccess() {
        return "Gestionnaire Board.";
    }
    @GetMapping("/res")
    @PreAuthorize("hasAuthority('ROLE_RESPONSABLE')")
    public String ResponsableAccess() {
        return "Responsable Board.";
    }
    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ROLE_ADMINISTRATEUR')")
    public String AdministrateurAccess() {
        return "Administrateur Board.";
    }

    @GetMapping("/doublerole")
    @PreAuthorize("hasAuthority('ROLE_ADMINISTRATEUR') or hasAuthority('ROLE_RESPONSABLE')")
    public String DoubleRole() {
        return "Res or ADMIN Board.";
    }

}
