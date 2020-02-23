package task06;

import java.util.ArrayList;
import java.util.List;

public class Knapsack {
    private final int knapsackCarrying;
    private List<Thing> packerList;

    public Knapsack(int knapsackCarrying) {
        this.knapsackCarrying = knapsackCarrying;
        this.packerList = new ArrayList<>();
    }

    public int getKnapsackCarrying() {
        return knapsackCarrying;
    }

    public List<Thing> getPackerList() {
        return packerList;
    }

    public List<Thing> packer(List<Thing> things) {
        List<Thing> packerList = new ArrayList<>();
        int numberThings = things.size();
        int[] weights = new int[numberThings];
        int[] costs = new int[numberThings];

        for (int i = 0; i < things.size(); i++) {
            weights[i] = things.get(i).getWeight();
            costs[i] = things.get(i).getCost();
        }

        int[][] matrix = new int[numberThings + 1][knapsackCarrying + 1];

        for (int i = 0; i <= numberThings; i++) {
            for (int j = 0; j <= knapsackCarrying; j++) {
                if (i == 0 || j == 0)
                    matrix[i][j] = 0;
                else if (weights[i - 1] <= j)
                    matrix[i][j] = Math.max(costs[i - 1] + matrix[i - 1][j - weights[i - 1]], matrix[i - 1][j]);
                else
                    matrix[i][j] = matrix[i - 1][j];
            }
        }

        int result = matrix[numberThings][knapsackCarrying];
        //System.out.println("\nThe backpack is packed with things with a total cost: " + result);

        for (int i = numberThings; i > 0 && result > 0; i--) {
            int w = knapsackCarrying;
            if (result != matrix[i - 1][w]) {
                result = result - costs[i - 1];
                w -= weights[i - 1];
                packerList.add(things.get(i));
                /**
                System.out.println("Thing #" +
                        i +
                        " with a weight of " +
                        weights[i - 1] +
                        " and a coast of " +
                        costs[i - 1]);
                */
            }
        }

        return packerList;
    }

    public int sumCost(List<Thing> packerList) {
        int sum = 0;
        for (Thing thing : packerList
                ) {
            sum += thing.getCost();
        }

        return sum;
    }

}
