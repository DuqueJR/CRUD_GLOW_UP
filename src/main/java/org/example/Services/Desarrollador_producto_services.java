package org.example.Services;


import jakarta.persistence.criteria.CriteriaBuilder;
import org.example.Model.Desarrollador_producto;
import org.example.Repositories.Desarrollador_producto_repositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Desarrollador_producto_services {

    @Autowired
    private Desarrollador_producto_repositories dp_repo;

    //CREATE
    public Desarrollador_producto save_dp(Desarrollador_producto dp){
        return dp_repo.save(dp);
    }

    //READ
    public Optional<Desarrollador_producto> get_dp_id(Integer ID){
        return  dp_repo.findById(ID);
    }

    public List<Desarrollador_producto> get_all(){
        return dp_repo.findAll();
    }


    //UPDATE
    public Desarrollador_producto update_dp_info(Integer ID, Desarrollador_producto new_info){
        return dp_repo.findById(ID).map(
                desarrolladorProducto -> {
                    desarrolladorProducto.setEspecialidad(new_info.getEspecialidad());

                    return dp_repo.save(desarrolladorProducto);
                }
        ).orElse(null);
    }


    //DELETE
    public boolean delete_dp(Integer ID){
        if(dp_repo.existsById(ID)){
            dp_repo.deleteById(ID);
            return true;
        }else{
            return false;
        }
    }
}
