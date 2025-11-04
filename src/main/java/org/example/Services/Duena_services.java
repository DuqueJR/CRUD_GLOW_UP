package org.example.Services;


import org.example.Model.Duena;
import org.example.Repositories.Duena_repositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Duena_services {


    @Autowired
    private Duena_repositories duena_repositories;

    //CREATE
    public Duena save_duean(Duena duena){
        return duena_repositories.save(duena);
    }

    //READ
    public Optional<Duena> get_duena_id(Integer ID){
        return duena_repositories.findById(ID);
    }

    public List<Duena> get_all(){
        return duena_repositories.findAll();
    }

    //UPDATE
    public Duena update_duena_info(Integer ID, Duena new_info){
        return duena_repositories.findById(ID).map(
                duena -> {
                    duena.setClave_maestra(new_info.getClave_maestra());

                    return duena_repositories.save(duena);
                }
        ).orElse(null);
    }


    //DELETE
    public boolean delete_duena(Integer ID){
        if(duena_repositories.existsById(ID)){
            duena_repositories.deleteById(ID);
            return true;
        }else{
            return false;
        }
    }
}
