package ar.edu.utn.fra.cine.app.vista;

import ar.edu.utn.fra.cine.app.modelo.Cliente;
import ar.edu.utn.fra.cine.app.modelo.Cine;
import ar.edu.utn.fra.cine.app.persistencia.PersistenciaCine;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.List;

public class LoginView extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label usuarioLabel = new Label("Usuario:");
        TextField usuarioField = new TextField();

        Label passLabel = new Label("Contraseña:");
        PasswordField passField = new PasswordField();

        Button loginBtn = new Button("Iniciar Sesión");
        Label mensajeError = new Label();
        mensajeError.setTextFill(Color.RED);

        loginBtn.setOnAction(e -> {
            String usuario = usuarioField.getText();
            String contraseña = passField.getText();

            Cliente cliente = verificarLogin(usuario, contraseña);
            if (cliente != null) {
                mensajeError.setText("");
                // Cargar el cine con toda la info persistida
                Cine cine = PersistenciaCine.cargarCine();

                // Abrir el menú pasando cine, cliente y stage
                new MenuView(cine, cliente, primaryStage).mostrar();

                
            } else {
                mensajeError.setText("Usuario o contraseña incorrectos");
            }
        });

        VBox layout = new VBox(10, usuarioLabel, usuarioField, passLabel, passField, loginBtn, mensajeError);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login - Cine");
        primaryStage.show();
    }

    private Cliente verificarLogin(String usuario, String contraseña) {
        Cine cine = PersistenciaCine.cargarCine();
        List<Cliente> clientes = cine.getClientes();

        for (Cliente c : clientes) {
            if (c.getNombre().equals(usuario) && c.getContraseña().equals(contraseña)) {
                return c;
            }
        }
        return null;
    }

}
