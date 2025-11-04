package org.example.Repositories;


import org.example.Model.Duena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Duena_repositories extends JpaRepository<Duena, Integer> {
}
