package org.example.Services;


import jakarta.persistence.criteria.CriteriaBuilder;
import org.example.Model.Fabrica;
import org.example.Repositories.Fabrica_repositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.Inet4Address;
import java.util.List;
import java.util.Optional;

@Service
public class Fabrica_services {


    @Autowired
    private Fabrica_repositories fabrica_repositories;

    //CREATE
    public Fabrica save_fabrica( Fabrica fabrica){
        return fabrica_repositories.save(fabrica);
    }

    //READ
    public Optional<Fabrica> get_fabrica_id(Integer ID){
        return fabrica_repositories.findById(ID);
    }

    public List<Fabrica> get_all(){
        return fabrica_repositories.findAll();
    }


    //UPDATEA
    public Fabrica update_fabrica_info(Integer ID, Fabrica new_info){
        return fabrica_repositories.findById(ID).map(
                fabrica -> {
                    fabrica.setPais(new_info.getPais());
                    fabrica.setCiudad(new_info.getCiudad());
                    fabrica.setCapacidad(new_info.getCapacidad());
                    fabrica.setNivel_auto(new_info.getNivel_auto());

                    return fabrica_repositories.save(fabrica);
                }
        ).orElse(null);
    }

    //DELETE
    public boolean delete_fabrica(Integer ID){
        if(fabrica_repositories.existsById(ID)){
            fabrica_repositories.deleteById(ID);
            return  true;
        }else{
            return false;
        }
    }
}
