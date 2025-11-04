package org.example.Repositories;

import org.example.Model.Admin_usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Admin_usuarios_repositories extends JpaRepository<Admin_usuarios, Integer> {
}
