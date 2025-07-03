/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.utn.fra.cine.app.modelo;

import java.io.Serializable;

/**
 cliente, sala, butaca.
*
 * @author Admin
 */
public class Entrada implements Serializable{
    private Cliente cliente;
    private Sala sala;
    private Butaca butaca;

    public Entrada(Cliente cliente, Sala sala, Butaca butaca) {
        this.cliente = cliente;
        this.sala = sala;
        this.butaca = butaca;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Butaca getButaca() {
        return butaca;
    }

    public void setButaca(Butaca butaca) {
        this.butaca = butaca;
    }
    
    
    @Override
    public String toString() {
        return "Entrada para " + cliente.getNombre()
                + " | Película: " + sala.getPelicula()
                + " | Sala: " + sala.getNumeroSala()
                + " | Butaca: " + butaca.getFila() + butaca.getNumero();
    }
    
    
 
}
