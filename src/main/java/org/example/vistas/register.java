package org.example.vistas;

import org.example.Model.Usuario;
import org.example.Services.Usuario_services;
import org.springframework.context.ApplicationContext;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;

public class register extends JFrame {
    private JTextField RegisterEmail_textField;
    private JTextField RegisterNombre_textField;
    private JPasswordField RegisterContraseña_passwordField;
    private JButton Register_login_button;
    private JButton LoginEnviar_button;
    private JPanel panel_main;

    private final Usuario_services usuario_services;
    private final NavigationController navigation;

    private int id = 0;

    public register(NavigationController navigation, ApplicationContext context) {
        this.usuario_services = context.getBean(Usuario_services.class);
        this.navigation = navigation;

        setContentPane(panel_main);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        LoginEnviar_button.addActionListener(e -> guardarUsuarioDb());
        Register_login_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigation.mostrarVista("login");
            }
        });
    }

    private void guardarUsuarioDb() {
        String email = RegisterEmail_textField.getText();
        String nombre = RegisterNombre_textField.getText();
        String contrasena = RegisterContraseña_passwordField.getText();

        if (nombre.isEmpty() || contrasena.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        Usuario usuario = new Usuario(id++, nombre, email, contrasena, "USER", LocalDate.now(), "ACTIVA");

        usuario_services.save_usuario(usuario);
    }

    public JPanel getMainPanel() {
        return panel_main;
    }
}
