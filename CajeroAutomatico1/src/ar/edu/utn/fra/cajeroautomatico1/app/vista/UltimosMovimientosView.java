package ar.edu.utn.fra.cajeroautomatico1.app.vista;

import ar.edu.utn.fra.cajeroautomatico1.app.modelo.Cuenta;
import ar.edu.utn.fra.cajeroautomatico1.app.modelo.Transaccion;
import java.util.List;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UltimosMovimientosView extends VBox {

    public UltimosMovimientosView(Stage stage, Cuenta cuenta) {
        setSpacing(10);
        setPadding(new javafx.geometry.Insets(20));

        Label lblTitulo = new Label("Últimos 5 Movimientos");

        ListView<String> lista = new ListView<>();
        List<Transaccion> ultimos = cuenta.getUltimosMovimientos(5);

        for (Transaccion t : ultimos) {
            lista.getItems().add(t.toString());
        }

        Button btnVolver = new Button("Volver");
        btnVolver.setOnAction(e -> {
            // Volvemos al menú principal
            MenuView menu = new MenuView(stage, cuenta, null); // Asegurate de pasar el HashMap si lo usás
            stage.setScene(new Scene(menu));
        });

        getChildren().addAll(lblTitulo, lista, btnVolver);
    }
}
