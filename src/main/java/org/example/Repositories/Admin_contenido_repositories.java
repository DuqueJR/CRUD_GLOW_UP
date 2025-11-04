package org.example.Repositories;


import org.example.Model.Admin_contenido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Admin_contenido_repositories extends JpaRepository<Admin_contenido,Integer> {
}
