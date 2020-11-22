package pl.ociepa.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import pl.ociepa.GameEngine;
import pl.ociepa.Creature;


import java.util.ArrayList;
import java.util.List;

public class BattleMapController {

    @FXML
    private GridPane gridMap;

    @FXML
    Button passButton;

    private final GameEngine gameEngine;

    public BattleMapController() {

        List<Creature> creatures1 = new ArrayList<>();
        creatures1.add(new Creature());
        creatures1.add(new Creature());
        creatures1.add(new Creature());

        List<Creature> creatures2 = new ArrayList<>();
        creatures2.add(new Creature());
        creatures2.add(new Creature());
        creatures2.add(new Creature());

        gameEngine = new GameEngine(creatures1, creatures2);


    }

    @FXML
    void initialize(){

        passButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
            gameEngine.pass();
            refreshGUI();
        } );

        refreshGUI();
    }

    private void refreshGUI() {
        for (int x = 0; x < 20 ; x++) {
            for (int y = 0; y <15 ; y++) {
                MapTile mapTile = new MapTile();
                gridMap.add(mapTile,x,y);

                Creature creature = gameEngine.get(x,y);
                if(creature != null){
                    mapTile.addCreature(creature.getName());

                    if(creature == gameEngine.getActiveCreatures()){
                        mapTile.setBackground(Color.YELLOW);
                    }
                }
            }
        }
    }

}
