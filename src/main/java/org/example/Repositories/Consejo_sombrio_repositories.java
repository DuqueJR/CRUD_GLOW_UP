package org.example.Repositories;

import org.example.Model.Consejo_sombrio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Consejo_sombrio_repositories extends JpaRepository<Consejo_sombrio,Integer> {
}

