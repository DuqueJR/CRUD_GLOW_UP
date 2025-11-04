package org.example.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "fabrica")
@Data
@NoArgsConstructor


public class Fabrica {

    @Id
    private int id_fabrica;

    private String pais;

    private String Ciudad;

    private int capacidad;

    private String nivel_auto;


    public Fabrica(int id_fabrica, String pais, String ciudad, int capacidad, String nivel_auto) {
        this.id_fabrica = id_fabrica;
        this.pais = pais;
        Ciudad = ciudad;
        this.capacidad = capacidad;
        this.nivel_auto = nivel_auto;
    }

    //GET AND SET for lambok
}
