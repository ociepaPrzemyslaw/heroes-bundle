package pl.ociepa;

import java.util.HashMap;
import java.util.Map;

class Board {

    private final Map<Point, Creature> map;
    public final static int WIDTH = 20;
    public final static int HEIGHT = 15;

    Board() {
        map = new HashMap<>();
    }



    void add(Point aPoint, Creature aCreature) {
        throwExceptionWhenFieldIsOutsideMap(aPoint);
        map.put(aPoint, aCreature);
    }

    private void throwExceptionWhenFieldIsOutsideMap(Point aPoint) {
        if (aPoint.getY() < 0 || aPoint.getX() > WIDTH || aPoint.getY() < 0 || aPoint.getY() > HEIGHT) {
            throw new IllegalArgumentException(" You are trying to works outside map ");
        }
    }

    Creature get(int aX, int aY) {
        return map.get(new Point(aX, aY));

    }

    Point get(Creature aCreature){
        return map.keySet().stream().filter(p -> map.get(p).equals(aCreature)).findAny().get();
    }

    void move(Creature aCreature, Point aTargetPoint){
        move(get(aCreature), aTargetPoint);
    }

    void move(Point aSourcePoint, Point aTargetPoint1) {

        throwExceptionWhenFieldIsOutsideMap(aTargetPoint1);

        if (map.containsKey(aTargetPoint1)){
            throw new IllegalArgumentException("Tile is taken");
        }

        Creature creatureFromBoardSourcePoint = map.get(aSourcePoint);
        map.remove(aSourcePoint);
        map.put(aTargetPoint1, creatureFromBoardSourcePoint);
     }


    boolean canMove(Creature aCreature, int aX, int aY) {
        throwExceptionWhenFieldIsOutsideMap(new Point(aX,aY));

        if(tileIsEmpty(aCreature)){
            throw new IllegalArgumentException("Creature isn't in board");
        }

        Point currentPosition = get(aCreature);
        double distance = currentPosition.distance(new Point(aX,aY));

        return distance <= aCreature.getMoveRange();

    }

    private boolean tileIsEmpty(Creature aCreature) {
        return !map.containsValue(aCreature);
    }


}
