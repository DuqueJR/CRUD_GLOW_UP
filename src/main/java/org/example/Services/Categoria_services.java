package org.example.Services;


import org.example.Model.Categoria;
import org.example.Repositories.Categoria_repositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Categoria_services {

    @Autowired
    private Categoria_repositories categoria_repositories;

    //CREATE
    public Categoria save_categoria(Categoria categoria){
        return categoria_repositories.save(categoria);
    }

    //READ
    public Optional<Categoria> get_categoria_id(Integer ID){
        return categoria_repositories.findById(ID);

    }

    public Optional<Categoria> get_categoria_nombre(String nombre){
        return categoria_repositories.findBynombre(nombre);

    }

    public List<Categoria> get_all(){
        return categoria_repositories.findAll();
    }


    //UPDATE

    public Categoria update_categoria_info (Integer ID, Categoria new_info){
        return categoria_repositories.findById(ID).map(
                categoria -> {
                    categoria.setNombre(new_info.getNombre());
                    categoria.setDescripcion(new_info.getDescripcion());
                    return categoria_repositories.save(categoria);
                }
        ).orElse(null);
    }

    //DELETE
    public boolean delete_categoria(Integer ID){
        if(categoria_repositories.existsById(ID)){
            categoria_repositories.deleteById(ID);
            return true;
        }else{
            return false;
        }
    }


}
