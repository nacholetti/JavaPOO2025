package ar.edu.utn.fra.cine.app.vista;

import ar.edu.utn.fra.cine.app.modelo.*;
import ar.edu.utn.fra.cine.app.persistencia.PersistenciaCine;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.*;

public class ButacasView {

    private Sala sala;
    private Cine cine;
    private Cliente cliente;
    private Stage stage;

    public ButacasView(Sala sala, Cine cine, Cliente cliente, Stage stage) {
        this.sala = sala;
        this.cine = cine;
        this.cliente = cliente;
        this.stage = stage;
    }

  public void mostrar() {
    Label titulo = new Label("Sala " + sala.getNumeroSala() + " - " + sala.getPelicula());

    GridPane grid = new GridPane();
    grid.setHgap(10);
    grid.setVgap(10);
    grid.setPadding(new Insets(20));
    grid.setAlignment(Pos.CENTER);

    Butaca[][] butacas = sala.getButacas();
    for (int i = 0; i < butacas.length; i++) {
        for (int j = 0; j < butacas[i].length; j++) {
            Butaca b = butacas[i][j];
            Button btn = new Button(b.getFila() + "" + b.getNumero());
            btn.setPrefSize(50, 40);

            if (b.isOcupada()) {
                btn.setStyle("-fx-background-color: red; -fx-text-fill: white;");
                btn.setDisable(true);
            } else {
                btn.setStyle("-fx-background-color: green; -fx-text-fill: white;");
                btn.setOnAction(e -> {
                    Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
                    confirmacion.setTitle("Confirmar compra");
                    confirmacion.setHeaderText("¿Deseás comprar la butaca " + b.getFila() + b.getNumero() + "?");

                    confirmacion.showAndWait().ifPresent(response -> {
                        if (response == ButtonType.OK) {
                            b.setOcupada(true); // marcar ocupada
                            cine.getEntradas().add(new Entrada(cliente, sala, b)); // registrar compra
                            PersistenciaCine.guardarCine(cine); // guardar todo

                            Alert exito = new Alert(Alert.AlertType.INFORMATION);
                            exito.setTitle("Compra Exitosa");
                            exito.setHeaderText(null);
                            exito.setContentText("¡Entrada comprada con éxito!");
                            exito.showAndWait();

                            mostrar(); // refrescar la vista
                        }
                    });
                });
            }

            grid.add(btn, j, i);
        }
    }

    Button btnVolver = new Button("Volver");
    btnVolver.setOnAction(e -> {
        new SalasView(cine, cliente, stage).mostrar();
    });

    VBox layout = new VBox(15, titulo, grid, btnVolver);
    layout.setAlignment(Pos.CENTER);
    layout.setPadding(new Insets(20));

    Scene scene = new Scene(layout, 600, 500);
    stage.setScene(scene);
    stage.setTitle("Butacas - Sala " + sala.getNumeroSala());
    stage.show();
}
}