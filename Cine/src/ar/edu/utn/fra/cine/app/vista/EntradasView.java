package ar.edu.utn.fra.cine.app.vista;

import ar.edu.utn.fra.cine.app.modelo.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.List;
import java.util.stream.Collectors;

public class EntradasView {

    private Cine cine;
    private Cliente cliente;
    private Stage stage;

    public EntradasView(Cine cine, Cliente cliente, Stage stage) {
        this.cine = cine;
        this.cliente = cliente;
        this.stage = stage;
    }

    public void mostrar() {
        Label titulo = new Label("Entradas compradas por " + cliente.getNombre());

        // Filtrar entradas del cliente
        List<Entrada> entradasCliente = cine.getEntradas().stream()
            .filter(e -> e.getCliente().getMail().equals(cliente.getMail()))
            .collect(Collectors.toList());

        VBox vboxEntradas = new VBox(10);
        vboxEntradas.setPadding(new Insets(10));

        if (entradasCliente.isEmpty()) {
            vboxEntradas.getChildren().add(new Label("No tenés entradas compradas."));
        } else {
            for (Entrada entrada : entradasCliente) {
                Butaca b = entrada.getButaca();
                Sala s = entrada.getSala();
                String texto = "Sala " + s.getNumeroSala() +
                               " - Película: " + s.getPelicula() +
                               " - Butaca: " + b.getFila() + b.getNumero();
                Label lbl = new Label(texto);
                vboxEntradas.getChildren().add(lbl);
            }
        }

        Button btnVolver = new Button("Volver");
        btnVolver.setOnAction(e -> {
            new MenuView(cine, cliente, stage).mostrar();
        });

        VBox layout = new VBox(20, titulo, vboxEntradas, btnVolver);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 400, 400);
        stage.setScene(scene);
        stage.setTitle("Resumen de Entradas");
        stage.show();
    }
}
