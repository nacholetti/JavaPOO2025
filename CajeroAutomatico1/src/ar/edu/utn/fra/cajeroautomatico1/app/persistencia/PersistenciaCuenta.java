/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.utn.fra.cajeroautomatico1.app.persistencia;

import ar.edu.utn.fra.cajeroautomatico1.app.modelo.Cuenta;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

/**
 *
 * LECTURA Y ESCRITURA, CARGAR Y GUARDAR.
 */
public class PersistenciaCuenta {
    private static final String ARCHIVO = "cuentas.dat";
    
    public static void guardar(HashMap<String,Cuenta> cuentas)/*GUARDADO*/{
        /*abrir archivo escribirlo y cerrarlo*/
        try(ObjectOutputStream oos =new ObjectOutputStream( new FileOutputStream(ARCHIVO))){
            oos.writeObject(cuentas);
        }catch(IOException e){
            System.out.println("Error guardando cuenta:" + e.getMessage());
        }
    }
    
    public static HashMap<String,Cuenta> cargar() {
        File archivo = new File(ARCHIVO);
        if(!archivo.exists()){
            HashMap<String,Cuenta> cuentas = new HashMap<>();
            cuentas.put("usuario", new Cuenta("12345",100000));
            cuentas.put("usuario2", new Cuenta("5416",200000));
            cuentas.put("usuario3", new Cuenta("8461",300000));

            return cuentas;
        }
        try(ObjectInputStream ois = new ObjectInputStream (new FileInputStream(ARCHIVO))){
            
            return(HashMap<String,Cuenta>)ois.readObject();
        
        }catch(IOException  | ClassNotFoundException e){
            
            System.out.println("Error al cargar cuenta:" + e.getMessage());
            HashMap<String,Cuenta> cuentas = new HashMap<>();
            cuentas.put("usuario", new Cuenta("12345",100000));
            cuentas.put("usuario2", new Cuenta("5416",200000));
            

            return cuentas;
        }
    }
}
