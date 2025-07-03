package ar.edu.utn.fra.cine.app;

import ar.edu.utn.fra.cine.app.vista.LoginView;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainCine extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        new LoginView().start(stage);
    }
}
