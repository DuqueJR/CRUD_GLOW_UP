package org.example.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "desarrollador_prod")
@Data
@NoArgsConstructor




public class Desarrollador_producto {

    @Id
    private int id_desarrollador_prod;

    @OneToOne
    @MapsId
    @JoinColumn(name="id_desarrollador_prod",referencedColumnName = "id_usuario")
    private Usuario usuario;

    private String especialidad;

    public Desarrollador_producto(Usuario usuario, int id_desarrollador_prod) {
        this.usuario = usuario;
        this.id_desarrollador_prod = id_desarrollador_prod;
    }

    public Desarrollador_producto(int id_desarrollador_prod, Usuario usuario, String especialidad) {
        this.id_desarrollador_prod = id_desarrollador_prod;
        this.usuario = usuario;
        this.especialidad = especialidad;
    }


//Getters and setters for lambok


}
