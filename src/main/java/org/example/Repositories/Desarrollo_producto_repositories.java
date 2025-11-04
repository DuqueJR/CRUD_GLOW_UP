package org.example.Repositories;

import org.example.Model.DesarrolloProdID;
import org.example.Model.Desarrollo_prod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Desarrollo_producto_repositories extends JpaRepository<Desarrollo_prod, DesarrolloProdID> {
}
