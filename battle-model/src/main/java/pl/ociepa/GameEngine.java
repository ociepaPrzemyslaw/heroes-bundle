package pl.ociepa;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class GameEngine {

    public static final String CURRENT_CREATURE_CHANGED = "CURRENT_CREATURE_CHANGED";
    private final Board board;
    private final CreatureTurnQueue queue;
    private final PropertyChangeSupport observerSupport;

    public GameEngine(List<Creature> aCreatures1, List<Creature> aCreatures2) {
        board = new Board();
        putCreaturesToBoard(aCreatures1, aCreatures2);
        List<Creature> twoSidesCreatures = new ArrayList<>();
        twoSidesCreatures.addAll(aCreatures1);
        twoSidesCreatures.addAll(aCreatures2);
        queue = new CreatureTurnQueue(twoSidesCreatures);

        twoSidesCreatures.forEach(c -> queue.addObserver(c));
        observerSupport = new PropertyChangeSupport(this);
    }

    public void addObserver(String aEventType, PropertyChangeListener aObs){
        observerSupport.addPropertyChangeListener(aEventType, aObs);
    }

    public void removeObserver(PropertyChangeListener aObs){
        observerSupport.removePropertyChangeListener(aObs);
    }

    public void notifyObservers(PropertyChangeEvent aEvent){
        observerSupport.firePropertyChange(aEvent);
    }



    public void move(Point aTargetPoint){
        board.move(queue.getActiveCreature(), aTargetPoint);

    }

    public void pass(){
        Creature oldActiveCreature = queue.getActiveCreature();
        queue.next();
        Creature newActiveCreature = queue.getActiveCreature();
        notifyObservers(new PropertyChangeEvent(this, CURRENT_CREATURE_CHANGED, oldActiveCreature, newActiveCreature));
    }

    public void attack(int x, int y){
        queue.getActiveCreature().attack(board.get(x,y));
    }

    private void putCreaturesToBoard(List<Creature> aCreatures1, List<Creature> aCreatures2) {

        putCreaturesFromOneSideToBoard(aCreatures1, 0);

        putCreaturesFromOneSideToBoard(aCreatures2, board.WIDTH-1);


    }

    private void putCreaturesFromOneSideToBoard(List<Creature> aCreatures1, int aAI) {
        for (int i = 0; i < aCreatures1.size(); i++) {
            board.add(new Point(aAI, i * 2), (aCreatures1.get(i)));
        }
    }

    public Creature get(int aX, int aY) {
        return board.get(aX,aY);
    }

    public Creature getActiveCreatures() {
        return queue.getActiveCreature();
    }

    public boolean canMove(int aX, int aY) {
        return board.canMove(getActiveCreatures(),  aX, aY);

    }
}
