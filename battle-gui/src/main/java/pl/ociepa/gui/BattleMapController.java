package pl.ociepa.gui;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

public class BattleMapController {

    @FXML
    private GridPane gridMap;

    @FXML
    void initialize(){


        for (int i = 0; i < 20 ; i++) {
            for (int j = 0; j <15 ; j++) {
                Rectangle rectangle = new MapTile();
                gridMap.add(rectangle,i,j);
            }
        }
    }

}
