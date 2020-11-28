package pl.ociepa;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.*;

class CreatureTurnQueue {
    private final Collection<Creature> creatures;
    private final Queue<Creature> creatureQueue;
    private Creature activeCreature;
    private final PropertyChangeSupport observers;

    public CreatureTurnQueue(Collection<Creature> aCreatureList) {
        creatures = aCreatureList;
        creatureQueue = new LinkedList<>();
        observers = new PropertyChangeSupport(this);
        initQueue();
        next();
    }

    void addObserver(PropertyChangeListener aObserver){
        observers.addPropertyChangeListener(aObserver);
    }

    void removeObserver(PropertyChangeListener aObserver){
        observers.removePropertyChangeListener(aObserver);
    }

    void notifyObserver(){
        observers.firePropertyChange(new PropertyChangeEvent(this, GameEngine.END_OF_TURN, null, null));
    }

    private void initQueue() {
        creatureQueue.addAll(creatures);
    }

    Creature getActiveCreature() {
        return activeCreature;
    }

    void next() {

        if(creatureQueue.isEmpty()){
            initQueue();
            notifyObserver();
        }
        activeCreature = creatureQueue.poll();
    }
}
