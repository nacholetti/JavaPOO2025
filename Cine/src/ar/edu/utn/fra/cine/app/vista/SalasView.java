package ar.edu.utn.fra.cine.app.vista;

import ar.edu.utn.fra.cine.app.modelo.Cine;
import ar.edu.utn.fra.cine.app.modelo.Cliente;
import ar.edu.utn.fra.cine.app.modelo.Sala;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class SalasView {

   private Cine cine;
    private Cliente cliente;
    private Stage stage;

    public SalasView(Cine cine, Cliente cliente, Stage stage) {
        this.cine = cine;
        this.cliente = cliente;
        this.stage = stage;
    }


  

    public void mostrar() {
        Label titulo = new Label("Seleccione una Sala");

        List<Sala> salas = cine.getSalas();

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);

        layout.getChildren().add(titulo);
        

        
        Button btnVolver = new Button("Volver al Menú");
        btnVolver.setOnAction(e -> {
            new MenuView(cine, cliente, stage).mostrar();
            layout.getChildren().add(btnVolver);
        });
        if (salas.isEmpty()) {
            Label sinSalas = new Label("No hay salas disponibles.");
            layout.getChildren().add(sinSalas);
        } else {
            for (Sala sala : salas) {
                Button btnSala = new Button("Sala " + sala.getNumeroSala()+ " - " + sala.getPelicula());
                btnSala.setOnAction(e -> {
                    // Aquí podés abrir la vista para ver butacas de la sala
                     new ButacasView(sala, cine, cliente, stage).mostrar();
                    // Ejemplo: new ButacasView(sala, stage).mostrar();
                });
                layout.getChildren().add(btnSala);
                
            }
        }

        Scene scene = new Scene(layout, 300, 400);
        stage.setScene(scene);
        stage.setTitle("Salas - Cine");
        stage.show();
    }
}
