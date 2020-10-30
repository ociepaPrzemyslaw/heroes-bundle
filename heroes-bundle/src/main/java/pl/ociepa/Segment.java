package pl.ociepa;

import java.util.Objects;

public class Segment {

    private Point startPoint;
    private Point endPoint;

    public Segment(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
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

    @Override
    public int hashCode() {
        return Objects.hash(startPoint, endPoint);
    }
}
