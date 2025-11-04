package org.example.vistas;

import org.example.Model.Producto;
import org.example.Services.Producto_services;
import org.springframework.context.ApplicationContext;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class producto extends JPanel{
    private JButton ProductoAgregarCesta_Button;
    private JLabel ProductoImagen_label;
    private JLabel ProductoNombre_label;
    private JLabel ProductoDescripcion_label;

    public producto(Producto p) {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        setBackground(Color.WHITE);

        JPanel info = new JPanel();
        info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
        info.setOpaque(false);

        ProductoNombre_label = new JLabel(p.getNombre());
        ProductoNombre_label = new JLabel(p.getNombre());
        ProductoNombre_label.setFont(ProductoNombre_label.getFont().deriveFont(Font.BOLD, 14f));
        ProductoDescripcion_label = new JLabel("<html><body style='width:300px'>" + p.getDescripcion() + "</body></html>");
        ProductoDescripcion_label.setFont(ProductoDescripcion_label.getFont().deriveFont(12f));

        info.add(ProductoNombre_label);
        info.add(Box.createRigidArea(new Dimension(0,6)));
        info.add(ProductoDescripcion_label);

        add(info, BorderLayout.CENTER);

        ProductoAgregarCesta_Button = new JButton("Agregar a cesta");
        JPanel actions = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        actions.setOpaque(false);
        actions.add(ProductoAgregarCesta_Button);
        add(actions, BorderLayout.SOUTH);

        setPreferredSize(new Dimension(0, 120));
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 120));
        setAlignmentX(Component.LEFT_ALIGNMENT);

        ProductoAgregarCesta_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
