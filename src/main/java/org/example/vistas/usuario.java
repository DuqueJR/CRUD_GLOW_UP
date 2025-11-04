package org.example.vistas;

import org.example.Model.Producto;
import org.example.Services.Producto_services;
import org.springframework.context.ApplicationContext;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class usuario extends JPanel {

    private JButton UsuarioPrincipal_button;
    private JButton UsuarioCesta_Button;
    private JPanel UsuarioContenedorProducto_panel;
    private JScrollPane Usuario_scrollPane;
    private JPanel panel_main;

    private final Producto_services producto_services;
    private final NavigationController navigation;

    public usuario(NavigationController navigation, ApplicationContext context) {
        this.producto_services = context.getBean(Producto_services.class);
        this.navigation = navigation;

        setSize(400, 300);

        UsuarioContenedorProducto_panel.removeAll();

        List<Producto> productos = producto_services.get_all();

        for(Producto p : productos){
            producto panel = new producto(p);

            panel.setAlignmentX(Component.LEFT_ALIGNMENT);
            panel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

            UsuarioContenedorProducto_panel.add(panel);
            UsuarioContenedorProducto_panel.add(Box.createRigidArea(new Dimension(0, 8)));

        }

        UsuarioContenedorProducto_panel.revalidate();
        UsuarioContenedorProducto_panel.repaint();
    }

    public JPanel getMainPanel(){
        return panel_main;
    }
}
