/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.utn.fra.cajeroautomatico1.app.modelo;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author Admin
 */
public class Transaccion implements Serializable{
    private String tipo; // "Depósito", "Extracción", etc.
    private double monto;
    private LocalDateTime fecha;

    public Transaccion(String tipo, double monto) {
        this.tipo = tipo;
        this.monto = monto;
        this.fecha = LocalDateTime.now();
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Transaccion{" + "tipo=" + tipo + ", monto=" + monto + ", fecha=" + fecha + '}';
    }
    
    
}
