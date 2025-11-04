package org.example.Services;


import org.example.Model.Categoria;
import org.example.Model.Producto;
import org.example.Repositories.Producto_repositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Producto_services {

    @Autowired
    private Producto_repositories producto_repositories;


    //CREATE

    public Producto save_producto(Producto producto){
        return producto_repositories.save(producto);
    }




    //READ
    public Optional<Producto> get_producto_id(Integer ID){
        return producto_repositories.findById(ID);
    }

    public Optional<Producto> get_producto_nombre(String nombre){
        return producto_repositories.findBynombre(nombre);
    }

    public Optional<Producto> get_producto_categoria(Categoria categoria){
        return producto_repositories.findBycategoria(categoria);
    }

    public List<Producto> get_all (){
        return producto_repositories.findAll();
    }


    //UPDATE
    public Producto Update_product_info(int Id, Producto nueva_info){
        return producto_repositories.findById(Id).map(
                producto -> {
                    producto.setNombre(nueva_info.getNombre());
                    producto.setDescripcion(nueva_info.getDescripcion());
                    producto.setPrecio_unitario(nueva_info.getPrecio_unitario());
                    producto.setUnidades_stock(nueva_info.getUnidades_stock());
                    producto.setFecha_lanzamiento(nueva_info.getFecha_lanzamiento());
                    producto.setCategoria(nueva_info.getCategoria());

                    return producto_repositories.save(producto);
                }

        ).orElse(null);
    }


    //DELETE
    public boolean deleteProducto(Integer ID){

        if(producto_repositories.existsById(ID)){
            producto_repositories.deleteById(ID);
            return true;
        }else {
            return false;
        }
    }
}
