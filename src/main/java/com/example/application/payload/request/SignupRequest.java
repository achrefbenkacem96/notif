package com.example.application.payload.request;

import java.util.Set;

import jakarta.validation.constraints.*;
import lombok.Getter;

public class SignupRequest {

    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    private Set<String> role;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;


   /* @NotBlank
    @Size(max = 120)
    private String nom;


    @NotBlank
    @Size(max = 120)
    private String prenom;


    @NotBlank
    @Size(max = 120)
    private long telephone;

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public long getTelephone() {
        return telephone;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }



    public void setTelephone(long telephone) {
        this.telephone = telephone;
    }
*/
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRole() {
        return this.role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }
}
