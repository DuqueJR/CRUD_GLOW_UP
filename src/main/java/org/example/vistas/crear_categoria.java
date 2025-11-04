package org.example.vistas;

import org.example.Model.Categoria;
import org.example.Model.Usuario;
import org.example.Services.Categoria_services;
import org.springframework.context.ApplicationContext;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class crear_categoria extends JPanel {
    private JButton agregarCategoriaButton1;
    private JButton agregarProductoButton;
    private JButton principalButton;
    private JTextField CategoriaNombre_textField;
    private JTextField CategoriaDescripcion_textField;
    private JButton agregarCategoriaButton;
    private JPanel panel_main;

    private final NavigationController navigation;
    private final Categoria_services categoria_services;

    private int id = 0;

    public crear_categoria(NavigationController navigation, ApplicationContext context) {
        this.navigation = navigation;
        this.categoria_services = context.getBean(Categoria_services.class);

        setSize(400, 300);
        setVisible(true);

        agregarProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigation.mostrarVista("agregarProducto");
            }
        });


        agregarCategoriaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarCategoriaDb();
            }
        });
    }

    private void guardarCategoriaDb() {
        String nombre = CategoriaNombre_textField.getText();
        String descripcion = CategoriaDescripcion_textField.getText();

        if (nombre.isEmpty() || descripcion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        Categoria categoria = new Categoria(id++, nombre, descripcion);

        categoria_services.save_categoria(categoria);
    }

    public JPanel getMainPanel() {
        return panel_main;
    }
}
