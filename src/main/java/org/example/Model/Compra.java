package org.example.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "compra")
@Data
@NoArgsConstructor

public class Compra {

    @Id
    private int id_compra;

    private LocalDate fecha;

    private int total_compra;

    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    public Compra(int id_compra, LocalDate fecha, int total_compra, String estado, Cliente cliente) {
        this.id_compra = id_compra;
        this.fecha = fecha;
        this.total_compra = total_compra;
        this.estado = estado;
        this.cliente = cliente;
    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getTotal_compra() {
        return total_compra;
    }

    public void setTotal_compra(int total_compra) {
        this.total_compra = total_compra;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
