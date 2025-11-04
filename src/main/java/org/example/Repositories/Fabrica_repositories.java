package org.example.Repositories;

import org.example.Model.Fabrica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Fabrica_repositories extends JpaRepository<Fabrica, Integer> {
}
