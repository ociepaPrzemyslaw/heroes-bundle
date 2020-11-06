package pl.ociepa;

import java.util.*;
import java.util.stream.Stream;

public class Shape {


    private final Set<Point> points;

    public Shape(Set<Point> points){
        this.points = points;
    }

    public void draw() {

           Stream<Point> pointStream = points.stream();

           Point pointFirst = pointStream.findFirst().get();
           Point nextPoint = pointStream.findAny().get();
           pointStream.forEach(n -> System.out.println(n));

           SelfishSegment s = new SelfishSegment(pointFirst, nextPoint);
           s.draw();
        }

   /*  private final Queue<Point> points;

    public Shape(Queue<Point> points) {
        this.points = points;

    }

    public void draw(){

        Point temp = points.peek();
        for (int i = 0; i <= points.size(); i++) {
            SelfishSegment s = new SelfishSegment(points.poll(), points.peek());
            s.draw();
        }

        SelfishSegment s = new SelfishSegment(points.peek(), temp);
        s.draw();

    }*/

   /*Iterator<Point> iterator = points.iterator();

        Point StartPoint = null;
        Point EndPoint = null;

            while (iterator.hasNext()){

                    StartPoint = iterator.next();
                    EndPoint = iterator.next();

                    if (StartPoint!=null && EndPoint!=null){
                        SelfishSegment s = new SelfishSegment(StartPoint, EndPoint);
                        s.draw();
                    }

                    Point beckPoint = EndPoint;
                    Point nextPoint = iterator.next();
                    SelfishSegment s = new SelfishSegment(beckPoint, nextPoint);
                    s.draw();
*/
}
