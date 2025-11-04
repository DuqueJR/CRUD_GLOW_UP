package org.example.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "duena")
@Data
@NoArgsConstructor


public class Duena {
    @Id
    private int id_duena;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_duena", referencedColumnName =  "id_usuario")
    private Usuario usuario;


    private LocalDate fecha_coronacion;

    private String clave_maestra;

    public Duena(int id_duena, Usuario usuario, LocalDate fecha_coronacion, String clave_maestra) {
        this.id_duena = id_duena;
        this.usuario = usuario;
        this.fecha_coronacion = fecha_coronacion;
        this.clave_maestra = clave_maestra;
    }


    //Getters and setter generated for lambok.Data
}
