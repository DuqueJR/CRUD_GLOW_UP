package org.example.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;



@Entity
@Table(name = "desarrollo_prod")
@Data
@NoArgsConstructor


public class Desarrollo_prod {
    @EmbeddedId
    private DesarrolloProdID id;


    @ManyToOne
    @MapsId("id_producto")
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @ManyToOne
    @MapsId("id_desarrollador")
    @JoinColumn(name = "id_desarrollador")
    private Desarrollador_producto desarrollador_producto;
}

