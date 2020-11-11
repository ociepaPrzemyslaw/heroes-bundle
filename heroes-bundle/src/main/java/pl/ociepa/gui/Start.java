package pl.ociepa.gui;

import pl.ociepa.GameEngine;
import pl.ociepa.Point;

import java.util.ArrayList;

public class Start {

    public Start() {
        GameEngine gameEngine = new GameEngine(new ArrayList<>(), new ArrayList<>());
        gameEngine.move(new Point(5,5));
    }
}
