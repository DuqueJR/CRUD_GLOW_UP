package org.example.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "cliente")
@Data
@NoArgsConstructor

public class Cliente {
    @Id
    private int id_cliente;


    @OneToOne
    @MapsId
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_usuario")
    private Usuario usuario;

    private String direccion_envio;

    private int telefono;

    public Cliente(int id_cliente, Usuario usuario, String direccion_envio, int telefono) {
        this.id_cliente = id_cliente;
        this.usuario = usuario;
        this.direccion_envio = direccion_envio;
        this.telefono = telefono;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDireccion_envio() {
        return direccion_envio;
    }

    public void setDireccion_envio(String direccion_envio) {
        this.direccion_envio = direccion_envio;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
