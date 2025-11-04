package org.example.vistas;

import org.example.Model.Categoria;
import org.example.Model.Producto;
import org.example.Services.Categoria_services;
import org.springframework.context.ApplicationContext;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

public class crear_producto extends JPanel{
    private JButton CrearCategoriaAgregarCategoria_Button;
    private JButton CrearCategoriaAgregarProducto_button;
    private JButton CrearCategoriaPrincipal_Button;
    private JTextField CrearProductoNombre_textField;
    private JTextField CrearProductoDescripcion_textField;
    private JTextField CrearProductoCategoria_textField;
    private JTextField CrearProductoPrecioUnitario_textField;
    private JTextField CrearProductoUnidadesStock_textField;
    private JTextField CrearProductoFechaLanzamiento_textField;
    private JButton CrearProductoaAgregar_button;
    private JPanel panel_main;

    private final NavigationController navigation;
    private final Categoria_services categoria_services;

    private int id = 0;

    public crear_producto(NavigationController navigation, ApplicationContext context) {
        this.navigation = navigation;
        this.categoria_services = context.getBean(Categoria_services.class);

        setSize(400, 300);
        setVisible(true);


    }

    private void guardarProductoDb() {
        String nombre = CrearProductoNombre_textField.getText();
        String descripcion = CrearProductoDescripcion_textField.getText();
        String categoria = CrearProductoCategoria_textField.getText();
        String precioUnitario = CrearProductoPrecioUnitario_textField.getText();
        String unidadesStock = CrearProductoUnidadesStock_textField.getText();
        String fechaLanzamiento = CrearProductoFechaLanzamiento_textField.getText();


        if (nombre.isEmpty() || descripcion.isEmpty() || categoria.isEmpty() || precioUnitario.isEmpty() || unidadesStock.isEmpty() || fechaLanzamiento.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        Optional<Categoria> categoriaOptional = categoria_services.get_categoria_nombre(categoria);

        Categoria categoria1 = categoriaOptional.get();

        Producto producto = new Producto(id++, nombre, descripcion, Integer.parseInt(unidadesStock), LocalDate.parse(fechaLanzamiento), Integer.parseInt(precioUnitario), categoria1);


    }
}
