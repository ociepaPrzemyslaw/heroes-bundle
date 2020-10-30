package pl.ociepa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SegmentTest {

    @Test
    void Blable(){

        Point point1 = new Point(1,1);
        Point point2 = new Point(3,1);
        Point point3 = new Point(1,3);

        Segment ss1 = new SelfishSegment(point1, point2);
        Segment ss2 = new SelfishSegment(point1, point3);

        assertEquals(ss1,ss2);

        ss1.getStartPoint().setX(5);

        assertEquals(ss1, ss2);



    }

}