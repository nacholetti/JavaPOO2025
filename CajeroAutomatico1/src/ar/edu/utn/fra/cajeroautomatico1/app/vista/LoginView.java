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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Admin
 */
public class LoginView extends VBox{
    
    
    
    public LoginView(Stage stage,HashMap<String,Cuenta> cuentas){
        setSpacing(10);
        
        setPadding(new javafx.geometry.Insets(20));
        
        Label lblUser = new Label("Usuario:");
        TextField campoUsuario = new TextField();
        
        
        Label lbl = new Label("Ingrese su PIN");
        PasswordField campoPin = new PasswordField();
        
        Button btnIngresar = new Button("Ingresar");
        Label mensaje = new Label();
        
        btnIngresar.setOnAction(e->{
            
            String usuario = campoUsuario.getText();
            String pin = campoPin.getText();
            
            Cuenta cuenta = cuentas.get(usuario);
            
           
            
            
            if(cuenta!=null && cuenta.validarPin(campoPin.getText())){
                /*IR A LA PANTALLA DE MENU*/
                MenuView menu = new MenuView(stage, cuenta,cuentas);
                stage.setScene(new Scene (menu));
                
                
            }else{
                mensaje.setText("Usuario o Pin incorrecto");
            }
        });
        
        getChildren().addAll(lblUser,campoUsuario,lbl,campoPin,btnIngresar,mensaje);
        
    }
}
