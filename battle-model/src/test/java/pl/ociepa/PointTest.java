package pl.ociepa;

import org.junit.jupiter.api.Test;


class PointTest {

    @Test
    void distancePoint(){

        Point point = new Point(2,5);
        Point point1 = new Point(5,9);
        double distance = point1.distance(point);
        System.out.println(distance);
    }

}