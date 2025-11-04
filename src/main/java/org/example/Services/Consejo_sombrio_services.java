package org.example.Services;


import jakarta.persistence.criteria.CriteriaBuilder;
import org.example.Model.Consejo_sombrio;
import org.example.Repositories.Consejo_sombrio_repositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Consejo_sombrio_services {

    @Autowired
    private Consejo_sombrio_repositories cs_repo;

    //CREATE
    public Consejo_sombrio save_cs(Consejo_sombrio cs){
        return cs_repo.save(cs);
    }


    //READ
    public Optional<Consejo_sombrio> get_cs_id(Integer ID){
        return  cs_repo.findById(ID);
    }

    public List<Consejo_sombrio> get_all(){
        return cs_repo.findAll();
    }


    //UPDATE
    public Consejo_sombrio update_cs_info(Integer ID, Consejo_sombrio new_info){
        return cs_repo.findById(ID).map(
                consejoSombrio -> {
                    consejoSombrio.setNombre_clave(new_info.getNombre_clave());

                    return cs_repo.save(consejoSombrio);
                }
        ).orElse(null);
    }

    //DELETE
    public boolean delete_cs(Integer ID){
        if(cs_repo.existsById(ID)){
            cs_repo.deleteById(ID);
            return true;
        }else{
            return false;
        }
    }
}
