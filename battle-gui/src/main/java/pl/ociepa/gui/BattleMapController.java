package pl.ociepa.gui;

import com.sun.source.tree.IfTree;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import pl.ociepa.GameEngine;
import pl.ociepa.Creature;
import pl.ociepa.Point;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class BattleMapController implements PropertyChangeListener {

    @FXML
    private GridPane gridMap;

    @FXML
    private Button passButton;

    @FXML
    private Label playerOne, playerTwo;

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
        gameEngine.addObserver(GameEngine.CURRENT_CREATURE_CHANGED,this);
        gameEngine.addObserver(GameEngine.CREATURE_MOVED,this);
        gameEngine.addObserver(GameEngine.CREATURE_ATTACKED,this);


        playerOne.setText("Player One");
        playerOne.getStyleClass().add("labelPlayer");
        playerTwo.setText("Player Two");
        playerTwo.getStyleClass().add("labelPlayer");

        passButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
            gameEngine.pass();
        } );

        refreshGUI();
    }

    private void refreshGUI() {
        for (int x = 0; x < 20 ; x++) {
            for (int y = 0; y <15 ; y++) {
                MapTile rec = new MapTile();
                gridMap.add(rec,x,y);

                Creature creature = gameEngine.get(x,y);
                if(creature != null){
                    rec.addCreature(creature.getName());

                    if(creature == gameEngine.getActiveCreatures()){
                        rec.setBackground(Color.YELLOW);
                    } else if (gameEngine.canAttack(x,y)) {
                        final int x1 = x;
                        final int y1 = y;

                        rec.setBackground(Color.RED);
                        rec.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> gameEngine.attack(x1,y1));
                    }
                }
                else if (gameEngine.canMove(x,y)){
                    final int x1 = x;
                    final int y1 = y;

                    rec.setBackground(Color.AQUA);
                    rec.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> gameEngine.move(new Point(x1,y1)));
                }
            }
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent aPropertyChangeEvent) {
        refreshGUI();
    }
}
