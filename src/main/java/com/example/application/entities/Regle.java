package com.example.application.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "regle")
public class Regle implements Serializable {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idR;
    @Getter
    private String libelleR;
    @Getter
    private String description;
    @Getter
    private boolean statut;


    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private TypeRegle Tr;

    @OneToMany(mappedBy = "r")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Alerte> alertes;


    @Getter
    @OneToMany(mappedBy = "r", cascade = CascadeType.ALL)
    private Set<Historique> historiques = new HashSet<>();

    public void setIdR(Long idR) {
        this.idR = idR;
    }

    public void setLibelleR(String libelleR) {
        this.libelleR = libelleR;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "utilisateur_regle",
            joinColumns = @JoinColumn(name = "idR"),
            inverseJoinColumns = @JoinColumn(name = "id"))
    private Set<Utilisateur> utilisateurs = new HashSet<>();

}