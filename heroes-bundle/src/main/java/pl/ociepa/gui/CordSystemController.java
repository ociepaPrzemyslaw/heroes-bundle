package pl.ociepa.gui;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import pl.ociepa.Point;
import pl.ociepa.Segment;
import pl.ociepa.SelfishSegment;

import java.awt.*;

public class CordSystemController {

    @FXML
    AnchorPane pane;

    @FXML
    private void initialize(){

        Point point1 = new Point(1,1);
        Point point2 = new Point(3,1);
        Point point3 = new Point(1,3);
        Point point4 = new Point(1,2);

       /* pane.getChildren().add(new Segment(point1,point2, Color.BLUE, 5));
        pane.getChildren().add(new Segment(point2,point3, Color.BLUE, 5));
        pane.getChildren().add(new Segment(point3,point4, Color.BLUE, 5));
        pane.getChildren().add(new Segment(point4,point1, Color.BLUE,5));*/

        Segment s1 = new Segment(point1,point2, Color.RED, 10);
        Segment s2 = new SelfishSegment(point1,point2);

        pane.getChildren().addAll(s1,s2);
        s1.getStartPoint().setX(7);
        refreshGui(s1, s2);


    }

    private void refreshGui(Segment aS1, Segment aS2) {
        aS1.refreshGui();
        aS2.refreshGui();
    }


}
