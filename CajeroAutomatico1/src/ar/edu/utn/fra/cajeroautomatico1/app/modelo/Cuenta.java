/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.utn.fra.cajeroautomatico1.app.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Cuenta implements Serializable {
    private String pin;
    private double saldo;
    private List<Transaccion> transacciones = new ArrayList<>();

    public Cuenta(String pin, double saldo) {
        this.pin = pin;
        this.saldo = saldo;
    }
    
    
    public boolean validarPin(String entrada){
        return this.pin.equals(entrada);
    }
    
    
    public void depositar(double monto){
        if(monto>0) saldo +=monto;
    }
    
    public boolean extraer(double monto){
        if(monto > 0 && monto<= saldo ){
            saldo -=monto;
            return true;
        }
        return false;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public void agregarTransaccion(String tipo, double monto) {
        transacciones.add(new Transaccion(tipo, monto));
    }

    public List<Transaccion> getUltimosMovimientos(int cantidad) {
        int total = transacciones.size();
        if (cantidad > total) {
            cantidad = total;
        }
        return transacciones.subList(total - cantidad, total);
    }
    
}
