package Task06;

import java.util.ArrayList;
import java.util.List;

public class Thing {
    private int weight;
    private int cost;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public List<Thing> generate(int numberThings, int carrying) {
        List<Thing> generatedThingsList = new ArrayList<>();
        for (int i = 0; i < numberThings; i++) {
            Thing thing = new Thing();
            thing.randomValue(carrying);
            generatedThingsList.add(thing);
        }

        System.out.println("\nGenerated " + generatedThingsList.size() +
                            " things with the following characteristics:");

        for (int i = 0; i < generatedThingsList.size(); i++) {
            int weight = generatedThingsList.get(i).getWeight();
            int cost = generatedThingsList.get(i).getCost();
            System.out.println("Thing #" + (i + 1) + " with a weight of " + weight + " and a coast of " + cost);
        }

        return generatedThingsList;
    }

    public void randomValue(int carrying) {
        cost = (int) ((Math.random() * 999) + 1);
        weight = (int) ((Math.random() * (carrying - 1)) + 1);
    }
}