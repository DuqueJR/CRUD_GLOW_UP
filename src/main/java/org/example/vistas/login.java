package org.example.vistas;

import org.example.Model.Usuario;
import org.example.Services.Usuario_services;
import org.springframework.context.ApplicationContext;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;

public class login extends JPanel {
    private JButton LoginIngresar_Button;
    private JTextField LoginNombre_textField;
    private JButton Login_register_button;
    private JPasswordField LoginContraseña_passwordField;
    private JPanel panel_main;

    private final Usuario_services usuario_services;
    private final NavigationController navigation;

    public login(NavigationController navigation,  ApplicationContext context){
        this.navigation = navigation;
        this.usuario_services = context.getBean(Usuario_services.class);

        setSize(400, 300);

        String nombre = LoginNombre_textField.getText().trim();
        String contraseña = new String(LoginContraseña_passwordField.getPassword());

        LoginIngresar_Button.addActionListener(e -> {
            //validarLogin(buscarUsuario(nombre, contraseña), nombre, contraseña);
            //validarRole(buscarUsuario(nombre, contraseña));
            navigation.mostrarVista("categoria");
        });
        Login_register_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigation.mostrarVista("register");
            }
        });
    }

    private Usuario buscarUsuario(String nombre, String contraseña){
        // 2️⃣ Verificar que no estén vacíos
        if (nombre.isEmpty() || contraseña.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // 3️⃣ Buscar el usuario en la base de datos
        Optional<Usuario> usuarioOptional = usuario_services.get_usuario_nombre(nombre);

        // 4️⃣ Validar existencia
        if (usuarioOptional.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Usuario no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        Usuario usuario = usuarioOptional.get();

        return usuario;
    }


    private void validarLogin(Usuario usuario, String nombre, String contraseña) {
        if (usuario.getPassword_hash().equals(contraseña)) {
            JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso. ¡Bienvenido, " + usuario.getNombre() + "!");
        } else {
            JOptionPane.showMessageDialog(this, "Contraseña incorrecta.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void validarRole(Usuario usuario) {
        if(usuario.getRole().equals("Admin")){
            navigation.mostrarVista("admin");
        }else if(usuario.getRole().equals("User")){
            navigation.mostrarVista("usuario");
        }
    }

    public JPanel getMainPanel() {
        return panel_main;
    }

}
