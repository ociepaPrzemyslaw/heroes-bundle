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

    static boolean canMove(Creature aActiveCreatures, int aX, int aY) {
        return true;
    }

    void add(Point aPoint, Creature aCreature) {
        throwExceptionWhenFieldIsTakenOrIsOutsideMap(aPoint);
        map.put(aPoint, aCreature);
    }

    private void throwExceptionWhenFieldIsTakenOrIsOutsideMap(Point aPoint) {
        if (aPoint.getY() < 0 || aPoint.getX() > WIDTH || aPoint.getY() < 0 || aPoint.getY() > HEIGHT || map.containsKey(aPoint)) {
            throw new IllegalArgumentException();
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

        throwExceptionWhenFieldIsTakenOrIsOutsideMap(aTargetPoint1);

        Creature creatureFromBoardSourcePoint = map.get(aSourcePoint);
        map.remove(aSourcePoint);
        map.put(aTargetPoint1, creatureFromBoardSourcePoint);
     }


}
