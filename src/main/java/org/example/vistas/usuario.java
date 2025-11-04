package org.example.vistas;

import org.example.Services.Usuario_services;

import javax.swing.*;

public class usuario extends JPanel {

    private JButton UsuarioPrincipal_button;
    private JButton UsuarioCesta_Button;

    private final Usuario_services usuario_services;
    private final NavigationController navigation;

    public usuario(Usuario_services usuario_services, NavigationController navigation){
        this.usuario_services = usuario_services;
        this.navigation = navigation;

        setSize(400, 300);
    }
}
