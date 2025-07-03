package ar.edu.utn.fra.cine.app.vista;

import ar.edu.utn.fra.cine.app.modelo.Cine;
import ar.edu.utn.fra.cine.app.modelo.Cliente;
import ar.edu.utn.fra.cine.app.persistencia.PersistenciaCine;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuView {

    private Cine cine;
    private Cliente cliente;
    private Stage stage;

    public MenuView(Cine cine, Cliente cliente, Stage stage) {
        this.cine = cine;
        this.cliente = cliente;
        this.stage = stage;
    }
    
    
    public void mostrar() {
        Label bienvenida = new Label("Bienvenido, " + cliente.getNombre() + "!");

        Button btnSeleccionarSala = new Button("Seleccionar Sala");
        Button btnComprarEntrada = new Button("Comprar Entrada");
        Button btnMisEntradas = new Button("Ver mis entradas");
        Button btnSalir = new Button("Salir");

        btnSeleccionarSala.setOnAction(e -> {
        Cine cine = PersistenciaCine.cargarCine();
        new SalasView(cine, cliente, stage).mostrar();
        });
        
        
         btnMisEntradas.setOnAction(e -> {
        new EntradasView(cine, cliente, stage).mostrar();
        });

        btnComprarEntrada.setOnAction(e -> {
            // Lógica para comprar entrada
            System.out.println("Abrir compra de entrada...");
        });

       
        btnSalir.setOnAction(e -> {
            stage.close();
        });

        btnSeleccionarSala.setOnAction(e -> {
            Cine cine = PersistenciaCine.cargarCine();
            new SalasView(cine, cliente, stage).mostrar();
        });

        VBox layout = new VBox(10, bienvenida, btnSeleccionarSala, btnComprarEntrada, btnMisEntradas, btnSalir);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 300, 250);
        stage.setScene(scene);
        stage.setTitle("Menú - Cine");
        stage.show();
    }
}
