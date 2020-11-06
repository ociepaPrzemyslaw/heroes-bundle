package pl.ociepa;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ShapeTest {

    @Test
    void ShapeTest(){

        Set<Point> points = new HashSet<>();
        points.add(new Point(1,1));
        points.add(new Point(1,4));
        points.add(new Point(4,4));
        points.add(new Point(4,1));
        Shape s = new Shape(points);

        s.draw();

    }

}