package com.example.application.entities;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

import java.util.Set;

@Entity
@Data
@Table(name = "utilisateurs",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })

public class Utilisateur implements Serializable  {


    @Getter
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Getter
    @NotBlank
    @Size(max = 20)
    private String username;

    @Getter
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @Getter
    @NotBlank
    @Size(max = 120)
    private String password;

   /* @Getter
    @NotBlank
    @Size(max = 120)
    private String nom;

    @Getter
    @NotBlank
    @Size(max = 120)
    private String prenom;

    @Getter
    @NotBlank
    @Size(max = 120)
    private long telephone;

    */


    @Getter
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(  name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public Utilisateur() {
    }

    public Utilisateur( String username, String email, String password) {

        this.username = username;
        this.email = email;
        this.password = password;
       /* this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone; */
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
  /*  public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setTelephone(long telephone) {
        this.telephone = telephone;
    }
*/

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }




    @OneToMany(mappedBy = "u")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Historique> Historiques;






    @ManyToMany(mappedBy = "utilisateurs")
    Set<Regle> Regles =  new HashSet<>();

}