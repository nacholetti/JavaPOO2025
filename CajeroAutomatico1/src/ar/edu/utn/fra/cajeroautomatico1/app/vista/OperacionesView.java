/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.utn.fra.cajeroautomatico1.app.vista;

import ar.edu.utn.fra.cajeroautomatico1.app.modelo.Cuenta;
import java.util.HashMap;
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
public class OperacionesView extends VBox {

    public OperacionesView(Stage stage, Cuenta cuenta, boolean esDeposito, HashMap<String, Cuenta> cuentas) {
        setSpacing(10);
        setPadding(new javafx.geometry.Insets(20));
        Label lbl = new Label(esDeposito ? "Ingrese monto a depositar" : "Ingrese monto a extraer");
        TextField campoMonto = new TextField();
        Button btnAceptar = new Button("Aceptar");
        Button btnCancelar = new Button("Cancelar");
        Label resultado = new Label();

        btnAceptar.setOnAction(e -> {
            try {
                double monto = Double.parseDouble(campoMonto.getText());
                if (esDeposito) {
                    cuenta.depositar(monto);
                    // 👇 Agregamos el movimiento
                    cuenta.agregarTransaccion("Depósito", monto);
                    resultado.setText("Depósito exitoso. Nuevo saldo: " + cuenta.getSaldo());
                } else {
                    boolean ok = cuenta.extraer(monto);
                    if (ok) {
                        // 👇 Agregamos el movimiento
                        cuenta.agregarTransaccion("Extracción", monto);
                        resultado.setText("Extracción exitosa. Nuevo saldo: " + cuenta.getSaldo());
                    } else {
                        resultado.setText("No se pudo retirar. Su saldo es: " + cuenta.getSaldo());
                    }
                }
            } catch (NumberFormatException nfe) {
                resultado.setText("Ingrese un número válido");
            }
        });
        btnCancelar.setOnAction(e -> {
            MenuView menu = new MenuView(stage, cuenta, cuentas);
            stage.setScene(new Scene(menu));
        });

        getChildren().addAll(lbl, campoMonto, btnAceptar, btnCancelar, resultado);

    }
}
