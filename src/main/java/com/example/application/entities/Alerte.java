package com.example.application.entities;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Alerte {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idA;
    private String typeAlerte;
    private Long emetteur;
    private Long destinataire;
    private String status;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Regle r;
}

