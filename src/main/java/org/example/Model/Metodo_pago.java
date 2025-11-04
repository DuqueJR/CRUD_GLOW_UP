package org.example.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "metodo_pago")
@Data
@NoArgsConstructor

public class Metodo_pago {

    @Id
    private int id_metodo_pago;

    @ManyToOne
    @JoinColumn(name = "id_clilente")
    private Cliente cliente;

    private String tipo;

    private String numero_enmascarado;

    public Metodo_pago(int id_metodo_pago, Cliente cliente, String tipo, String numero_enmascarado) {
        this.id_metodo_pago = id_metodo_pago;
        this.cliente = cliente;
        this.tipo = tipo;
        this.numero_enmascarado = numero_enmascarado;
    }


    public int getId_metodo_pago() {
        return id_metodo_pago;
    }

    public void setId_metodo_pago(int id_metodo_pago) {
        this.id_metodo_pago = id_metodo_pago;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumero_enmascarado() {
        return numero_enmascarado;
    }

    public void setNumero_enmascarado(String numero_enmascarado) {
        this.numero_enmascarado = numero_enmascarado;
    }
}
