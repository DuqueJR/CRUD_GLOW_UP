package org.example.Repositories;


import org.example.Model.Categoria;
import org.example.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Categoria_repositories extends JpaRepository<Categoria, Integer> {
    Optional<Categoria> findBynombre(String nombre);
}
