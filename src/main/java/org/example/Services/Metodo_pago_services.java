package org.example.Services;


import org.example.Model.Cliente;
import org.example.Model.Metodo_pago;
import org.example.Repositories.Metodo_pago_repositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Metodo_pago_services {

    @Autowired
    private Metodo_pago_repositories mp_repo;

    //CREATE
    public Metodo_pago save_metodo_pago(Metodo_pago mp){
        return mp_repo.save(mp);
    }

    //READ
    public Optional<Metodo_pago> get_mp_id(Integer ID){
        return mp_repo.findById(ID);
    }

    public Optional<Metodo_pago> get_mp_cliente(Cliente cliente){
        return mp_repo.findBycliente(cliente);
    }

    public List<Metodo_pago> get_all(){
        return mp_repo.findAll();
    }

    //UPDATE
    public Metodo_pago update_mp_info(Integer ID, Metodo_pago new_info){

        return mp_repo.findById(ID).map(
                metodoPago -> {
                    metodoPago.setCliente(new_info.getCliente());
                    metodoPago.setTipo(new_info.getTipo());
                    metodoPago.setNumero_enmascarado(new_info.getNumero_enmascarado());

                    return mp_repo.save(metodoPago);

                }
        ).orElse(null);

    }

    //DELETE

    public boolean delete_mp(Integer ID){
        if(mp_repo.existsById(ID)){
            mp_repo.deleteById(ID);
            return true;
        }else{
            return  false;
        }

    }
}
