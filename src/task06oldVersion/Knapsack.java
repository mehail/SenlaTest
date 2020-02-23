package task06oldVersion;

import java.util.ArrayList;
import java.util.List;

public class Knapsack {
    private int carrying;
    private List<Thing> thingList;

    public int getCarrying() {
        return carrying;
    }

    public void setCarrying(int carrying) {
        this.carrying = carrying;
    }

    public List<Thing> getThingList() {
        return thingList;
    }

    public void setThingList(List<Thing> thingList) {
        this.thingList = thingList;
    }

    public Knapsack(int carrying) {
        this.carrying = carrying;
        this.thingList = new ArrayList<>();
    }

    public void packer(List<Thing> generatedThingsList) {
        int numberThings = generatedThingsList.size();
        int[] weights = new int[numberThings];
        int[] costs = new int[numberThings];

        for (int i = 0; i < generatedThingsList.size(); i++) {
            weights[i] = generatedThingsList.get(i).getWeight();
            costs[i] = generatedThingsList.get(i).getCost();
        }

        int[][] matrix = new int[numberThings + 1][carrying + 1];

        for (int i = 0; i <= numberThings; i++) {
            for (int j = 0; j <= carrying; j++) {
                if (i == 0 || j == 0)
                    matrix[i][j] = 0;
                else if (weights[i - 1] <= j)
                    matrix[i][j] = Math.max(costs[i - 1] + matrix[i - 1][j - weights[i - 1]], matrix[i - 1][j]);
                else
                    matrix[i][j] = matrix[i - 1][j];
            }
        }

        int result = matrix[numberThings][carrying];
        System.out.println("\nThe backpack is packed with things with a total cost: " + result);

        for (int i = numberThings; i > 0 && result > 0; i--) {
            int w = carrying;
            if (result != matrix[i - 1][w]) {
                result = result - costs[i - 1];
                w -= weights[i - 1];
                System.out.println("Thing #" +
                        i +
                        " with a weight of " +
                        weights[i - 1] +
                        " and a coast of " +
                        costs[i - 1]);
            }
        }
    }
}