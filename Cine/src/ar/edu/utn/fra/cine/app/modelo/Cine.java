package ar.edu.utn.fra.cine.app.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cine implements Serializable {

    private List<Sala> salas;
    private List<Entrada> entradas;
    private List<Cliente> clientes;

    public Cine() {
        this.salas = new ArrayList<>();
        this.entradas = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    // Getters
    public List<Sala> getSalas() {
        return salas;
    }

    public void setSalas(List<Sala> salas) {
        this.salas = salas;
    }

    public void setEntradas(List<Entrada> entradas) {
        this.entradas = entradas;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    
    
    

    public List<Entrada> getEntradas() {
        return entradas;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    // Métodos
    public void agregarSala(Sala sala) {
        salas.add(sala);
    }

    public void registrarEntrada(Entrada entrada) {
        entradas.add(entrada);
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cliente buscarClientePorMail(String mail) {
        for (Cliente c : clientes) {
            if (c.getMail().equalsIgnoreCase(mail)) {
                return c;
            }
        }
        return null;
    }

    public Sala buscarSalaPorNumero(int numero) {
        for (Sala sala : salas) {
            if (sala.getNumeroSala() == numero) {
                return sala;
            }
        }
        return null;
    }

    public List<Entrada> obtenerEntradasPorCliente(Cliente cliente) {
        List<Entrada> resultado = new ArrayList<>();
        for (Entrada e : entradas) {
            if (e.getCliente().equals(cliente)) {
                resultado.add(e);
            }
        }
        return resultado;
    }
}
