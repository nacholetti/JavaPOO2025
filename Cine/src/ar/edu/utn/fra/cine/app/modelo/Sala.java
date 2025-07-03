/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.utn.fra.cine.app.modelo;

import java.io.Serializable;

/**
  número, película, matriz de butacas*
 * @author Admin
 */
public class Sala implements Serializable{
    private int numeroSala;
    private String pelicula;
    private Butaca[][] butacas;

    public Sala(int numeroSala, String pelicula, Butaca[][] butacas) {
        this.numeroSala = numeroSala;
        this.pelicula = pelicula;
        this.butacas = butacas;
    }
    
    
    public static Sala crearSala(int numeroSala, String pelicula, int filas, int columnas) {
    Butaca[][] matriz = new Butaca[filas][columnas];
    for (int i = 0; i < filas; i++) {
        for (int j = 0; j < columnas; j++) {
            String letraFila = String.valueOf((char) ('A' + i));
            matriz[i][j] = new Butaca(j + 1, letraFila, false);
        }
    }
    return new Sala(numeroSala, pelicula, matriz);
}


    public int getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(int numeroSala) {
        this.numeroSala = numeroSala;
    }

    public String getPelicula() {
        return pelicula;
    }

    public void setPelicula(String pelicula) {
        this.pelicula = pelicula;
    }

    public Butaca[][] getButacas() {
        return butacas;
    }

    public void setButacas(Butaca[][] butacas) {
        this.butacas = butacas;
    }

    @Override
    public String toString() {
        return "Sala{" + "numeroSala=" + numeroSala + ", pelicula=" + pelicula + '}';
    }

    

  
    
}
