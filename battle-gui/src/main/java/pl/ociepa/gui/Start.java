package pl.ociepa.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
/*import pl.ociepa.GameEngine;
import pl.ociepa.Point;*/

import java.io.IOException;
import java.util.ArrayList;

public class Start extends Application {

    public Start() {
       /* GameEngine gameEngine = new GameEngine(new ArrayList<>(), new ArrayList<>());
        gameEngine.move(new Point(5,5));*/
    }

    @Override
    public void start(Stage stage) throws IOException {

        Scene scene = new Scene(FXMLLoader.load(getClass().getClassLoader().getResource("fxml/battleMap.fxml")));
        stage.setScene(scene);
        stage.show();
    }
}
