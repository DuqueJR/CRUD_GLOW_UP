package org.example.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "producto")
@Data
@NoArgsConstructor


public class Producto {
    @Id
    private int id_producto;

    private String nombre;

    private String descripcion;

    private int unidades_stock;

    private LocalDate fecha_lanzamiento;

    private int precio_unitario;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;


    //Constructor

    public Producto(int id_producto, String nombre, String descripcion, int unidades_stock, LocalDate fecha_lanzamiento, int precio_unitario, Categoria categoria) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.unidades_stock = unidades_stock;
        this.fecha_lanzamiento = fecha_lanzamiento;
        this.precio_unitario = precio_unitario;
        this.categoria = categoria;
    }



    //Get and Set

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getUnidades_stock() {
        return unidades_stock;
    }

    public void setUnidades_stock(int unidades_stock) {
        this.unidades_stock = unidades_stock;
    }

    public LocalDate getFecha_lanzamiento() {
        return fecha_lanzamiento;
    }

    public void setFecha_lanzamiento(LocalDate fecha_lanzamiento) {
        this.fecha_lanzamiento = fecha_lanzamiento;
    }

    public int getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(int precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
