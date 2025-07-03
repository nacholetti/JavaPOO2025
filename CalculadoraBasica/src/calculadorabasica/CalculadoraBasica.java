/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculadorabasica;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Admin
 */
public class CalculadoraBasica extends Application{


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
       TextField operador1 = new TextField();
       TextField operador2 = new TextField();
       
       Button btnSuma = new Button("Suma");
       Button btnResta = new Button("Restar");
       Button btnMultiplicar = new Button("Multiplicar");
       Button btnDividir = new Button("Dividir");
       Label resultado = new Label();

       btnSuma.setOnAction(e->{
       try{
       double op1 = Double.parseDouble(operador1.getText());
       double op2 = Double.parseDouble(operador2.getText());
       resultado.setText("Resultado: " + (op1 + op2));
           }catch(NumberFormatException ex){
               System.out.println("Ingrese valores validos");
           }
       });
       
       
       btnResta.setOnAction(e->{
       double op1 = Double.parseDouble(operador1.getText());
       double op2 = Double.parseDouble(operador2.getText());
       resultado.setText("Resultado: " + (op1 - op2));

       });
       
       GridPane grid = new GridPane();
       grid.setHgap(10);
       grid.setVgap(10);
       grid.setPadding(new Insets(20));
       grid.add(operador1, 0,0);
       grid.add(btnSuma, 1, 0);
       grid.add(btnResta, 2, 0);
       grid.add(operador2, 0, 1);
       grid.add(btnMultiplicar,1,1);
       grid.add(btnDividir,2,1);
       grid.add(resultado, 0, 2);
       
       Scene scene = new Scene(grid,300,400);
       
       stage.setTitle("Calculadora Basica");
       stage.setScene(scene);
       stage.show();
       
    }
    
}
