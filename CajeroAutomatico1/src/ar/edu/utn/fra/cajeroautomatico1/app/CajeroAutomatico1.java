/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ar.edu.utn.fra.cajeroautomatico1.app;

import ar.edu.utn.fra.cajeroautomatico1.app.modelo.Cuenta;
import ar.edu.utn.fra.cajeroautomatico1.app.persistencia.PersistenciaCuenta;
import ar.edu.utn.fra.cajeroautomatico1.app.vista.LoginView;
import java.util.HashMap;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;



/**
 *
 * @author Admin
 */
public class CajeroAutomatico1 extends Application {

    
    private HashMap<String,Cuenta>cuentas;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
      cuentas = PersistenciaCuenta.cargar();
      
      LoginView login = new LoginView(primaryStage,cuentas);
       primaryStage.setScene(new Scene(login));
       primaryStage.setTitle("Cajero-Inicio de sesion");
      /*GUARDAR AL SALIR*/
      
      primaryStage.setOnCloseRequest(e->PersistenciaCuenta.guardar(cuentas));
      primaryStage.show();
    }
    
}
