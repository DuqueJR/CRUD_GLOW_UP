package org.example.vistas;

import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;
import java.awt.*;

public class main_vista extends JFrame implements NavigationController {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private ConfigurableApplicationContext context;

    public main_vista(ConfigurableApplicationContext context) {
        this.context = context;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        add(mainPanel);

        // Crear vistas (pasamos 'this' para que puedan cambiar de vista)
        login loginView = new login(this, context);
        register registerView = new register(this, context);

        // Agregar al CardLayout
        mainPanel.add(loginView.getMainPanel(), "login");
        mainPanel.add(registerView.getMainPanel(), "register");

        // Mostrar primera vista
        mostrarVista("login");

    }

    @Override
    public void mostrarVista(String nombreVista) {
        cardLayout.show(mainPanel, nombreVista);
    }
}
