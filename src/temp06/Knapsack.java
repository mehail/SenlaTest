package temp06;

import java.util.ArrayList;
import java.util.List;

public class Knapsack {

    private final int carrying;
    private final List<Thing> things;

    public Knapsack(int carrying) {
        this.carrying = carrying;
        this.things = new ArrayList<>();
    }

    public int getCarrying() {
        return carrying;
    }

    public List<Thing> getThings() {
        return things;
    }

    public boolean isFull() {
        return things.size() >= carrying;
    }

    public void addThing(Thing thing) {
        things.add(thing);
    }

}
