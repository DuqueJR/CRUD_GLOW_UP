package org.example.Repositories;

import org.example.Model.Cliente;
import org.example.Model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Compra_repositories extends JpaRepository<Compra, Integer> {
    Optional<Compra> findBycliente(Cliente cliente);
}
