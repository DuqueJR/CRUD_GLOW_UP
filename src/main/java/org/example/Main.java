package org.example;

import org.example.vistas.login;
import org.example.vistas.main_vista;
import org.example.vistas.register;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {

        // 🔹 Creamos el SpringApplication manualmente
        SpringApplication app = new SpringApplication(Main.class);

        // 🔹 Muy importante: habilitar modo gráfico y desactivar servidor web
        app.setWebApplicationType(WebApplicationType.NONE);
        app.setHeadless(false);

        // 🔹 Iniciamos el contexto de Spring Boot
        ConfigurableApplicationContext context = app.run(args);

        // 🔹 Ejecutamos la ventana Swing en el hilo de eventos
        SwingUtilities.invokeLater(() -> {
            main_vista ventana = new main_vista(context);
            ventana.setVisible(true);
        });
    }
}
