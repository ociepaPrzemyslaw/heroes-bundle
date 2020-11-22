package pl.ociepa.gui;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

class MapTile extends StackPane {

    Rectangle rectangle;

    public MapTile() {

        rectangle = new Rectangle(40, 40, Color.WHITE);
        rectangle.setStroke(Color.BLACK);
        getChildren().add(rectangle);
    }

    void addCreature(String aName){
        getChildren().add(new Label(aName));
    }

    void setBackground(Color aColor){
        rectangle.setFill(aColor);
    }
}
