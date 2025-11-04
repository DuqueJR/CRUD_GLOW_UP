package org.example.Model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class DesarrolloProdID implements Serializable {
    private int id_producto;
    private int id_desarrollador;
}