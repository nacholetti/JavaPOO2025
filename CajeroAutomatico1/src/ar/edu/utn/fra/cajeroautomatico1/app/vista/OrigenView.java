/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.utn.fra.cajeroautomatico1.app.vista;

import ar.edu.utn.fra.cajeroautomatico1.app.modelo.Cuenta;
import java.util.HashMap;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Admin
 */
public class OrigenView extends VBox  {
    public OrigenView(Stage stage, Cuenta cuenta, HashMap<String, Cuenta> cuentas, MenuView menu) {
        setSpacing(15);
        setPadding(new Insets(20));
        
        Label label = new Label("Ingrese origen:");
        TextField txtOrigen = new TextField();
        Button btnGuardar = new Button("Guardar y Volver");
        Label mensaje = new Label();

        btnGuardar.setOnAction(e -> {
            String origen = txtOrigen.getText().trim();
            if(origen.isEmpty()){
                mensaje.setText("Debe ingresar un origen válido.");
            } else {
                menu.setOrigen(origen);
                stage.setScene(new Scene(menu));
            }
        });

        getChildren().addAll(label, txtOrigen, btnGuardar, mensaje);
    }
}
