package org.example.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "consejo_sombrio")
@Data
@NoArgsConstructor



public class Consejo_sombrio {
    @Id
    private int id_consejo_sombrio;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_consejo_sombrio", referencedColumnName = "id_usuario")
    private Usuario usuario;

    private String nombre_clave;

    public Consejo_sombrio(int id_consejo_sombrio, Usuario usuario, String nombre_clave) {
        this.id_consejo_sombrio = id_consejo_sombrio;
        this.usuario = usuario;
        this.nombre_clave = nombre_clave;
    }
}
