package org.example.Repositories;

import org.example.Model.Esclavo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface Esclavo_repositories extends JpaRepository<Esclavo,Integer> {
    Optional<Esclavo> findBynombre(String nombre);
}
