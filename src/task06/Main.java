package task06;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Input the carrying capacity of the knapsack from 1 to 100: ");
            int knapsackCarrying = scanner.nextInt();

            if (knapsackCarrying <= 0 || knapsackCarrying >= 100) {
                throw new InputMismatchException();
            }

            System.out.print("Input the number of things to generate from 1 to 1000: ");
            int numberThings = scanner.nextInt();

            if (numberThings <= 0 || numberThings >= 1000) {
                throw new InputMismatchException();
            }

            final List<Thing> things = Stream
                    .generate(Thing::generate)
                    .limit(numberThings)
                    .collect(Collectors.toList());

            System.out.println("\nGenerated %d things with the following characteristics: " + things.size());

            Thing.printList(things);

            final Knapsack knapsack = new Knapsack(knapsackCarrying);
            List<Thing> packerList = knapsack.packer(things);
            int sumCost = knapsack.sumCost(packerList);

            System.out.println("\nThe backpack is packed with things with a total cost: " + sumCost);
            Thing.printList(packerList);

        } catch (InputMismatchException e) {
            System.out.println("Oops! You input an incorrect value.");
        }
    }

}
