package pl.ociepa.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloFX extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        Scene scene = new Scene(FXMLLoader.load(getClass().getClassLoader().getResource("fxml/coordinate.fxml")));
        stage.setScene(scene);
        stage.show();
    }
}