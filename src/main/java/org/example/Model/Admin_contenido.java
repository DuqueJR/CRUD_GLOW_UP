package org.example.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "admin_contenido")
@Data
@NoArgsConstructor

public class Admin_contenido {
    @Id
    private int id_admin_contenido;

    @OneToOne  //This is for create a foreign key constraint one to one in only one direction,
    @MapsId
    @JoinColumn(name = "id_admin_contenido", referencedColumnName = "id_usuario")
    private Usuario usuario;

    @ElementCollection
    @CollectionTable(
            name = "permisos_edicion_admin_contenido",
            joinColumns = @JoinColumn(name = "id_admin_contenido")
    )
    @Column (name = "Permisos_edicion")
    private List<String> permisos_edicion = new ArrayList<>();

    public Admin_contenido(int id_admin_contenido, Usuario usuario, List<String> permisos_edicion) {
        this.id_admin_contenido = id_admin_contenido;
        this.usuario = usuario;
        this.permisos_edicion = permisos_edicion;
    }

    public int getId_admin_contenido() {
        return id_admin_contenido;
    }

    public void setId_admin_contenido(int id_admin_contenido) {
        this.id_admin_contenido = id_admin_contenido;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<String> getPermisos_edicion() {
        return permisos_edicion;
    }

    public void setPermisos_edicion(List<String> permisos_edicion) {
        this.permisos_edicion = permisos_edicion;
    }
}
