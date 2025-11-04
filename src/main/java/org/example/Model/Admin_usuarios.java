package org.example.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "admin_usuarios")
@Data
@NoArgsConstructor

public class Admin_usuarios {
    @Id
    private int id_admin_usuarios;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_admin_usuarios", referencedColumnName = "id_usuario")
    private Usuario usuario;

    private String nivel_acceso;

    public Admin_usuarios(int id_admin_usuarios, Usuario usuario, String nivel_acceso) {
        this.id_admin_usuarios = id_admin_usuarios;
        this.usuario = usuario;
        this.nivel_acceso = nivel_acceso;
    }

    public int getId_admin_usuarios() {
        return id_admin_usuarios;
    }

    public void setId_admin_usuarios(int id_admin_usuarios) {
        this.id_admin_usuarios = id_admin_usuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNivel_acceso() {
        return nivel_acceso;
    }

    public void setNivel_acceso(String nivel_acceso) {
        this.nivel_acceso = nivel_acceso;
    }
}
