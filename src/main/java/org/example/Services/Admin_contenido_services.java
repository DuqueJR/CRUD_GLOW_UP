package org.example.Services;


import jakarta.persistence.criteria.CriteriaBuilder;
import org.example.Model.Admin_contenido;
import org.example.Repositories.Admin_contenido_repositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Admin_contenido_services {

    @Autowired
    public Admin_contenido_repositories ac_repo;


    //CREATE

    public Admin_contenido save_ad(Admin_contenido ad){
        return ac_repo.save(ad);
    }


    //READ
    public Optional<Admin_contenido> get_ad_id(Integer ID){
        return ac_repo.findById(ID);

    }

    public List<Admin_contenido> get_all(){
        return ac_repo.findAll();
    }

    //UPDATE
    public Admin_contenido update_ad_info(Integer ID, Admin_contenido new_info){
        return ac_repo.findById(ID).map(
                adminContenido -> {
                    adminContenido.setPermisos_edicion(new_info.getPermisos_edicion());

                    return ac_repo.save(adminContenido);
                }
        ).orElse(null);
    }

    //DELETE
    public boolean delete_ad(Integer ID){
        if(ac_repo.existsById(ID)){
            ac_repo.deleteById(ID);
            return true;
        }else{
            return false;
        }
    }


}
