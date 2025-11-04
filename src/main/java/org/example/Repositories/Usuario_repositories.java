package org.example.Repositories;


import org.example.Model.Categoria;
import org.example.Model.Producto;
import org.example.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Usuario_repositories extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findBynombre(String nombre);
    Optional<Usuario> findByRole(String Role);

}
