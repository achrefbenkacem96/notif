package com.example.application.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity

public class TypeRegle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTR;

    private String libelleTR;
    @OneToMany(mappedBy = "Tr")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Regle> regles;
}