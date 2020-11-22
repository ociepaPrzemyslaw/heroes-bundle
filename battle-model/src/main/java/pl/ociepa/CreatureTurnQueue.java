package pl.ociepa;

import java.util.*;

class CreatureTurnQueue {
    private final Collection<Creature> creatures;
    private final Queue<Creature> creatureQueue;
    private Creature activeCreature;
    private Set<Creature> observers;

    public CreatureTurnQueue(Collection<Creature> aCreatureList) {
        creatures = aCreatureList;
        creatureQueue = new LinkedList<>();
        observers = new HashSet<>();
        observers.forEach(this::addObserver);
        initQueue();
        next();
    }

    void addObserver(Creature aObserver){
        observers.add(aObserver);
    }

    void removeObserver(Creature aObserver){
        observers.remove(aObserver);
    }

    void notifyObserver(){
        observers.forEach(o -> o.update());
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
