package org.example.Services;



import org.example.Model.Usuario;
import org.example.Repositories.Usuario_repositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Usuario_services {
    @Autowired
    private Usuario_repositories usuario_repositories;

    //CREATE
    public Usuario save_usuario (Usuario usuario){
        return usuario_repositories.save(usuario);
    }

    //READ
    public Optional<Usuario> get_usuario_id(Integer ID){
        return usuario_repositories.findById(ID);

    }

    public Optional<Usuario> get_usuario_nombre(String nombre){
        return usuario_repositories.findBynombre(nombre);

    }

    public Optional<Usuario> get_usuario_rol(String Role){
        return usuario_repositories.findByRole(Role);
    }

    public List<Usuario> get_all(){
        return usuario_repositories.findAll();
    }


    //UPDATE
    public Usuario update_usuario_infomration(Integer ID, Usuario new_info){
        return usuario_repositories.findById(ID).map(
                usuario -> {
                    usuario.setNombre(new_info.getNombre());
                    usuario.setEmail(new_info.getEmail());
                    usuario.setPassword_hash(new_info.getPassword_hash());
                    usuario.setRole(new_info.getRole());
                    usuario.setEstado_cuenta(new_info.getEstado_cuenta());

                    return usuario_repositories.save(usuario);
                }
        ).orElse(null);
    }

    //DELETE
    public boolean delete_usuario(Integer ID){
        if(usuario_repositories.existsById(ID)){
            usuario_repositories.deleteById(ID);
            return true;
        }else{
            return false;
        }
    }


}
