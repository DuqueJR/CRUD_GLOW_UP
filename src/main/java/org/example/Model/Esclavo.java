package org.example.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "esclavo")
@Data
@NoArgsConstructor


public class Esclavo {
    @Id
    private int id_esclavo;

    private String nombre;

    private String pais;

    private int edad;

    private LocalDate fecha_captura;

    private String salud;

    @ManyToOne
    @JoinColumn(name = "id_fabrica")
    private Fabrica fabrica;

    public Esclavo(int id_escalvo, String nombre, String pais, int edad, LocalDate fecha_captura, String salud, Fabrica fabrica) {
        this.id_esclavo = id_escalvo;
        this.nombre = nombre;
        this.pais = pais;
        this.edad = edad;
        this.fecha_captura = fecha_captura;
        this.salud = salud;
        this.fabrica = fabrica;
    }
}
