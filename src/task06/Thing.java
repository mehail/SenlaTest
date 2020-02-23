package task06;

import java.util.List;

public class Thing {

    private int name;
    private int weight;
    private int cost;
    private static int nameCount = 1;

    public Thing(int name, int weight, int cost) {
        this.name = name;
        this.weight = weight;
        this.cost = cost;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

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

    public static Thing generate() {
        final int name = nameCount;
        nameCount++;
        final int weight = (int) (Math.random() * 99) + 1;
        final int cost = (int) (Math.random() * 999) + 1;
        return new Thing(name, weight, cost);
    }

    public static void printList(List<Thing> list) {
        for (Thing thing : list
        ) {
            String thingGenerated = String.format("Thing #%d  with a weight of %d  and a coast of %d",
                    thing.getName(), thing.getWeight(), thing.getCost());
            System.out.println(thingGenerated);
        }
    }
}
