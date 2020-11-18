package pl.ociepa;

import javafx.scene.shape.Line;

import java.util.Objects;

public class Point extends Line {

    private int x;
    private int y;
    private double distanceToCenter;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        distanceToCenter =  Math.sqrt(x*x+y*y);

        setStartX(x*50+50);
        setStartY(350 - y *50);
        setEndX(x*50+50);
        setEndY(350 - y *50);

        setStrokeWidth(5);
    }

    public Point(Point copyPoint) { //konstruktor samokopujący
       this(copyPoint.x, copyPoint.y);
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public double getDistanceToCenter() {
        return distanceToCenter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
