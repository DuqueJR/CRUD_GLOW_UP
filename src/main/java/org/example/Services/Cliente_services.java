package org.example.Services;

import org.example.Model.Cliente;
import org.example.Repositories.Cliente_repositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Cliente_services {

    @Autowired
    private Cliente_repositories cliente_repositories;

    //CREATE

    public Cliente save_cliente(Cliente cliente){
        return cliente_repositories.save(cliente);
    }

    //READ
    public Optional<Cliente> get_cliente_id(Integer ID){
        return cliente_repositories.findById(ID);

    }

    public List<Cliente> get_all(){
        return cliente_repositories.findAll();
    }


    //UPDATE
    public Cliente updaate_cliente_info(Integer ID, Cliente new_info){
        return cliente_repositories.findById(ID).map(
                cliente -> {
                    cliente.setDireccion_envio(new_info.getDireccion_envio());
                    cliente.setTelefono(new_info.getTelefono());

                    return cliente_repositories.save(cliente);
                }
        ).orElse(null);
    }


    //DELETE
    public boolean delete_cliente(Integer ID){
        if(cliente_repositories.existsById(ID)){
            cliente_repositories.deleteById(ID);
            return true;
        }else{
            return false;
        }
    }
}
