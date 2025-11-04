package org.example.Services;


import org.example.Model.Cliente;
import org.example.Model.Compra;
import org.example.Repositories.Compra_repositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Compra_services {


    @Autowired
    private Compra_repositories compra_repositories;

    //CREATE
    public Compra save_compra(Compra compra){
        return compra_repositories.save(compra);
    }

    //READ

    public Optional<Compra> get_compra_id(Integer ID){
        return compra_repositories.findById(ID);
    }

    public Optional<Compra> get_compra_cliente(Cliente cliente){
        return compra_repositories.findBycliente(cliente);
    }

    public List<Compra> get_all(){
        return compra_repositories.findAll();
    }

    //UPDATE
    public Compra update_compra_info(Integer ID,  Compra new_info){
        return compra_repositories.findById(ID).map(
                compra -> {
                    compra.setTotal_compra(new_info.getTotal_compra());
                    compra.setEstado(new_info.getEstado());
                    compra.setCliente(new_info.getCliente());

                    return compra_repositories.save(compra);

                }
        ).orElse(null);
    }

    //DELETE

    public boolean delete_compta(Integer ID){
        if(compra_repositories.existsById(ID)){
            compra_repositories.deleteById(ID);
            return true;
        }else{
            return false;
        }
    }

}
