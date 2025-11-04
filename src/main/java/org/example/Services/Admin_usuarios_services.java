package org.example.Services;


import org.example.Model.Admin_contenido;
import org.example.Model.Admin_usuarios;
import org.example.Repositories.Admin_usuarios_repositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.InsufficientResourcesException;
import java.util.List;
import java.util.Optional;

@Service
public class Admin_usuarios_services {

    @Autowired
    private Admin_usuarios_repositories au_repo;

    //CREATE

    public Admin_usuarios save_au(Admin_usuarios au){
        return au_repo.save(au);
    }

    //READ
    public Optional<Admin_usuarios> get_au_id(Integer ID){
        return au_repo.findById(ID);

    }

    public List<Admin_usuarios> get_all(){
        return au_repo.findAll();
    }

    //UPDATE
    public Admin_usuarios updatea_au_info(Integer ID, Admin_usuarios new_info){
        return au_repo.findById(ID).map(
                adminUsuarios -> {
                    adminUsuarios.setNivel_acceso(new_info.getNivel_acceso());
                    return au_repo.save(adminUsuarios);
                }
        ).orElse(null);
    }


    //DELETE
    public boolean delte_au(Integer ID){
        if(au_repo.existsById(ID)){
            au_repo.deleteById(ID);
            return true;
        }else{
            return false;
        }
    }


}
