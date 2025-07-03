/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.utn.fra.cine.app.modelo;

import java.io.Serializable;

/**
 número, fila, estado (ocupada/libre).
*
 * @author Admin
 */
public class Butaca implements Serializable {
    private int numero;
    private String fila;
    private boolean ocupada;

    public Butaca(int numero, String fila, boolean ocupada) {
        this.numero = numero;
        this.fila = fila;
        this.ocupada = ocupada;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    @Override
    public String toString() {
        return "Butaca{" + "numero=" + numero + ", fila=" + fila + ", ocupada=" + ocupada + '}';
    }

 

    
}
