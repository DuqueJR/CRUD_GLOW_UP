package org.example.Repositories;


import org.example.Model.Categoria;
import org.example.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Producto_repositories extends JpaRepository<Producto, Integer> {
    Optional<Producto> findBynombre(String nombre);
    Optional<Producto> findBycategoria(Categoria categoria);
}
