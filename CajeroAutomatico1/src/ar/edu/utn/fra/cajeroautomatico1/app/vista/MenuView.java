/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.utn.fra.cajeroautomatico1.app.vista;

import ar.edu.utn.fra.cajeroautomatico1.app.modelo.Cuenta;
import java.util.HashMap;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Admin
 */
public class MenuView extends VBox {
    public MenuView(Stage stage, Cuenta cuenta,HashMap<String,Cuenta> cuentas){
        setSpacing(15);
        setPadding(new javafx.geometry.Insets(20));
        
        Label bienvenida = new Label("Bienvenido al cajero");
        Button btnSaldo = new Button("Consultar Saldo");
        Button  btnDeposito = new Button("Depositar Dinero");
        Button btnExtraccion = new Button("Extraer Dinero");
        Button btnSalir = new Button("Salir del menu");
  
        Button btnUltimosMovimientos = new Button("Últimos movimientos");

        btnUltimosMovimientos.setOnAction(e -> {
            UltimosMovimientosView vista = new UltimosMovimientosView(stage, cuenta);
            stage.setScene(new Scene(vista));
        });

        btnSaldo.setOnAction(e->{
            Alert alerta = new Alert(Alert.AlertType.INFORMATION,"Saldo actual: $" + cuenta.getSaldo());
            alerta.showAndWait();
        });
        
        btnDeposito.setOnAction(e->{
            OperacionesView vista = new OperacionesView(stage,cuenta,true,cuentas);
            stage.setScene(new Scene(vista));
        });
        
        btnExtraccion.setOnAction(e->{
            OperacionesView vista = new OperacionesView(stage,cuenta,false,cuentas);
            stage.setScene(new Scene(vista));
        });
        
        btnSalir.setOnAction(e->{
           LoginView login = new LoginView(stage,cuentas);
           stage.setScene(new Scene(login));
        });
        
        getChildren().addAll(btnUltimosMovimientos,bienvenida,btnSaldo,btnDeposito,btnExtraccion,btnSalir);
                
    }
}
