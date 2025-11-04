package org.example.Services;


import org.example.Model.Esclavo;
import org.example.Repositories.Esclavo_repositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Esclavo_services {

    @Autowired
    private Esclavo_repositories esclavo_repositories;

    //CREATE
    public Esclavo save_escalvo(Esclavo esclavo){
        return esclavo_repositories.save(esclavo);
    }

    //READ
    public Optional<Esclavo> get_escalvo_id(Integer ID){
        return esclavo_repositories.findById(ID);

    }

    public Optional<Esclavo> get_escalvo_nombre(String nombre){
        return esclavo_repositories.findBynombre(nombre);
    }

    public List<Esclavo> get_all(){
        return esclavo_repositories.findAll();
    }

    //UPDATE

    public Esclavo update_escalvo_info(Integer ID, Esclavo new_info){
        return esclavo_repositories.findById(ID).map(
                esclavo -> {
                    esclavo.setNombre(new_info.getNombre());
                    esclavo.setPais(new_info.getPais());
                    esclavo.setEdad(new_info.getEdad());
                    esclavo.setSalud(new_info.getSalud());
                    esclavo.setFabrica(new_info.getFabrica());

                    return esclavo_repositories.save(esclavo);

                }
        ).orElse(null);
    }


    //DELETE

    public boolean delete_esclavo(Integer ID){
        if(esclavo_repositories.existsById(ID)){
            esclavo_repositories.deleteById(ID);
            return true;
        }else{
            return false;
        }
    }
}
