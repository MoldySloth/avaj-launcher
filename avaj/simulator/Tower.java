package avaj.simulator;

import avaj.simulator.aircraft.Flyable;

import java.io.IOException;
import java.util.*;

public class Tower {
    private static List<Flyable>           flyableList = new ArrayList<Flyable>();

    public void register(Flyable flyable) {
        flyableList.add(flyable);
    }

    public void unregister(Flyable flyable) {
        flyableList.remove(flyable);
    }

    protected void conditionsChanged() {
        for (int i = 0; i < flyableList.size(); i++) {
            flyableList.get(i).updateConditions();
        }
    }
}

// Aggregate to Flyable

// Name
//  Tower
// Attributes
//  private observers: Flyable*
// Methods
//  public register(flyable Flyble): void
//  public unregister(flyable : Flyable): void
//  protected conditionsChanged(): void
