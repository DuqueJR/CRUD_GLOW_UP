package org.example.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "categoria")
@Data
@NoArgsConstructor


public class Categoria {


    @Id
    private int id;

    private String nombre;

    private String descripcion;


}