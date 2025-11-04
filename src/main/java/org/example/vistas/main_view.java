package org.example.vistas;

import javax.swing.*;
import java.awt.*;

public class main_view {
    private JPanel main_panel;

    public login login_card;
    public register register_card;
    public admin admin_card;
    public usuario usuario_card;
    public crear_categoria categoria_card;
    public crear_producto producto_card;
    public cesta cesta_card;

    public main_view() {
        login_card = new login();
        register_card = new register();
        admin_card = new admin();
        usuario_card = new usuario();
        categoria_card = new crear_categoria();
        producto_card = new crear_producto();
        cesta_card = new cesta();

        main_panel.add(login_card.getLogin_panel(), "Login");
        main_panel.add(register_card.getRegister_panel(), "Register");
        main_panel.add(admin_card.getAdmin_panel(), "Admin");
        main_panel.add(usuario_card.getUsuario_panel(), "Usuario");
        main_panel.add(categoria_card.getCrearCategoria_panel(), "Categoria");
        main_panel.add(producto_card.getCrearProducto_panel(), "Producto");
        main_panel.add(cesta_card.getCesta_panel(), "Cesta");
    }

    public void mostrarVista(String Vista){
        CardLayout cl = (CardLayout) main_panel.getLayout();
        cl.show(main_panel, Vista);
    }
}
