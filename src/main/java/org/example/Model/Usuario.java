package org.example.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "usuario")
@Data
@NoArgsConstructor

public class Usuario {
    @Id
    private int id_usuario;

    private String nombre;

    private String email;

    private String password_hash;

    private String role;

    private LocalDate fecha_registro;

    private String estado_cuenta;

    public Usuario(int id_usuario, String nombre, String email, String password_hash, String role, LocalDate fecha_registro, String estado_cuenta) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.email = email;
        this.password_hash = password_hash;
        this.role = role;
        this.fecha_registro = fecha_registro;
        this.estado_cuenta = estado_cuenta;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDate getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDate fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getEstado_cuenta() {
        return estado_cuenta;
    }

    public void setEstado_cuenta(String estado_cuenta) {
        this.estado_cuenta = estado_cuenta;
    }
}
