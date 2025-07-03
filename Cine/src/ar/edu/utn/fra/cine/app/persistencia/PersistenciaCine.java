package ar.edu.utn.fra.cine.app.persistencia;

import ar.edu.utn.fra.cine.app.modelo.Cliente;
import ar.edu.utn.fra.cine.app.modelo.Cine;
import ar.edu.utn.fra.cine.app.modelo.Sala;
import java.io.*;
import java.util.ArrayList;

public class PersistenciaCine {

    private static final String ARCHIVO = "cine.ser";

    public static void guardarCine(Cine cine) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            oos.writeObject(cine);
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

    public static Cine cargarCine() {
        File archivo = new File(ARCHIVO);
        if (!archivo.exists()) {
            Cine cine = crearCineDePrueba();
            guardarCine(cine);
            return cine;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (Cine) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar el archivo: " + e.getMessage());
            return crearCineDePrueba();
        }
    }

    private static Cine crearCineDePrueba() {
        Cine cine = new Cine();
        if (cine.getClientes() == null) {
            cine.setClientes(new ArrayList<>());
        }
        cine.getClientes().add(new Cliente("toto", "toto@mail.com", "1234"));
        cine.getClientes().add(new Cliente("pepe", "pepe@mail.com", "abcd"));
      // ? AGREGAR SALAS DE PRUEBA
         cine.getSalas().add(Sala.crearSala(1, "Avengers", 5, 6));
        cine.getSalas().add(Sala.crearSala(2, "Toy Story", 4, 5));

  

        System.out.println("Clientes y salas de prueba creados.");
        return cine;
    }
}
