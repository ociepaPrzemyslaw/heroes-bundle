package pl.ociepa;

import javafx.scene.shape.Line;

import java.awt.*;
import java.util.Objects;
import javafx.scene.paint.Color;

public class Segment extends Line {

    private Point startPoint;
    private Point endPoint;
    private final Color color;
    private final double strokeWidth;

    public Segment(Point startPoint, Point endPoint, Color aColor, double aStrokeWidth) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.color = aColor;
        this.strokeWidth = aStrokeWidth;

        refreshGui();
    }

    public Segment(Point startPoint, Point endPoint) {
        this(startPoint,endPoint,Color.BLUE, 5);
    }

    public void refreshGui() {
        setStartX(startPoint.getX()*50+50);
        setStartY(350 - startPoint.getY() *50);
        setEndX(endPoint.getX()*50+50);
        setEndY(350 - endPoint.getY() *50);

        setStrokeWidth(strokeWidth);
        setStroke(color);
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    @Override
    public String toString() {
        return "Segment{" +
                "startPoint=" + startPoint +
                ", endPoint=" + endPoint +
                ", Lenght=" + calculateLength(this) +
                '}';
    }

    @Override
    public boolean equals(Object oPoint) {
        return calculateLength(this) == calculateLength((Segment)  oPoint);
    }

    private double calculateLength(Segment oPoint) {

        int diffX = oPoint.startPoint.getX() - oPoint.endPoint.getX();
        int diffY = oPoint.startPoint.getY() - oPoint.endPoint.getY();

        return Math.sqrt(diffX*diffX+diffY*diffY);
    }

    /*@Override
    public int hashCode() {
        return Objects.hash(startPoint, endPoint);
    }*/

    void draw(){
        System.out.println(toString());
    }
}
