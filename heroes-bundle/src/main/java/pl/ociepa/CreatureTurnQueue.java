package pl.ociepa;

import java.util.Collection;

public class CreatureTurnQueue {
    private final Collection<Creature> creatures;

    public CreatureTurnQueue(Collection<Creature> aCreatureList) {
        creatures = aCreatureList;
    }
}
