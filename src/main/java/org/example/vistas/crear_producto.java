package org.example.vistas;

import lombok.Getter;

import javax.swing.*;

public class crear_producto {
    private JButton AgregarProducto_agregarCategoriaButton;
    private JButton AgregarProducto_agregarProductoButton;
    private JButton AgregarProducto_principalButton;
    private JTextField agregarProducto_nombretextField;
    private JTextField agregarProducto_descripciontextField;
    private JTextField agregarProducto_categoriatextField;
    private JTextField agregarProducto_precioUnitariotextField;
    private JTextField agregarProducto_UnidadesStocktextField;
    private JTextField agregarProducto_fechaLanzamienyotextField;
    private JButton agregarProducto_agregarButton;

    @Getter
    private JPanel CrearProducto_panel;
}
