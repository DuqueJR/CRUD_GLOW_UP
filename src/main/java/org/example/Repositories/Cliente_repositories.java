package org.example.Repositories;

import org.example.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Cliente_repositories extends JpaRepository<Cliente, Integer> {
}
